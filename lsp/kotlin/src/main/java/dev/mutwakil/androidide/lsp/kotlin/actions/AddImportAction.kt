package dev.mutwakil.androidide.lsp.kotlin.actions

import android.content.Context
import android.view.View
import android.widget.ListView
import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.has
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.actions.newDialogBuilder
import dev.mutwakil.androidide.actions.requireFile
import dev.mutwakil.androidide.lsp.api.ILanguageClient
import dev.mutwakil.androidide.lsp.kotlin.compiler.AbstractCompilationEnvironment
import dev.mutwakil.androidide.lsp.kotlin.compiler.index.findSymbolBySimpleName
import dev.mutwakil.androidide.lsp.kotlin.diagnostic.DiagnosticAction
import dev.mutwakil.androidide.lsp.kotlin.utils.insertImport
import dev.mutwakil.androidide.lsp.models.CodeActionItem
import dev.mutwakil.androidide.lsp.models.CodeActionKind
import dev.mutwakil.androidide.lsp.models.Command
import dev.mutwakil.androidide.lsp.models.DiagnosticItem
import dev.mutwakil.androidide.lsp.models.DocumentChange
import dev.mutwakil.androidide.lsp.models.TextEdit
import dev.mutwakil.androidide.resources.R
import dev.mutwakil.androidide.utils.applyLongPressRecursively
import dev.mutwakil.androidide.utils.flashError
import dev.mutwakil.androidide.utils.flashInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.nio.file.Path

class AddImportAction : BaseKotlinCodeAction() {
	companion object {
		const val ID = "ide.editor.lsp.kt.diagnostics.addImport"
	}

	override var titleTextRes: Int = R.string.action_import_classes

	override val id: String = ID
	override var label: String = ""

	override fun prepare(data: ActionData) {
		super.prepare(data)

		if (!visible || !data.has<DiagnosticItem>()) {
			markInvisible()
			return
		}

		// Optimistic visibility: decide from the in-memory unresolved-reference marker only. The
		// importable-classifier resolution runs in the background execAction; doing it here would be
		// main-thread SQLite I/O, because fillMenu() calls prepare() synchronously on the UI thread.
		val resolveReferenceActionDiagnostic =
			data.findDiagnosticExtra<DiagnosticAction.ResolveReference>()
		if (resolveReferenceActionDiagnostic == null) {
			markInvisible()
			return
		}
	}

	override suspend fun execAction(data: ActionData): Any {
		val (_, extra) =
			data.findDiagnosticExtra<DiagnosticAction.ResolveReference>()
				?: return ImportCandidates.Found(emptyMap())

		val (env, action) = extra
		val nioPath = data.requireFile().toPath()
		return withContext(Dispatchers.IO) {
			computeImportCandidates(env, nioPath, action.referenceName)
		}
	}

	/**
	 * Resolves [referenceName] to the importable classifiers known to [env], each mapped to the edits
	 * that import it into the file at [nioPath]. Keyed by fully-qualified name, which is what
	 * [postExec] shows in the chooser -- so two index entries for the same class collapse into one
	 * entry instead of duplicating it.
	 *
	 * Blocking: the index query is SQLite-backed and pinning the file resolves that file before handing
	 * it over, so callers must stay off the main thread ([execAction] wraps it in [Dispatchers.IO]).
	 */
	internal fun computeImportCandidates(
		env: AbstractCompilationEnvironment,
		nioPath: Path,
		referenceName: String,
	): ImportCandidates {
		/*
		 * Resolved before the file is pinned, not inside the pin: this is an unbounded SQLite scan that
		 * never reads the file, and a pin held across it freezes live-PSI refresh for the path - every
		 * concurrent acquirer joins the frozen instance and the refresh is only owed on release.
		 * Materialized here too, so the index's lazy source-active filter cannot trail into the scope.
		 */
		val classifiers =
			env.ktSymbolIndex
				.findSymbolBySimpleName(referenceName, limit = 0)
				.filter { it.kind.isClassifier }
				.toList()

		if (classifiers.isEmpty()) {
			return ImportCandidates.Found(emptyMap())
		}

		return env.ktSymbolIndex.withLiveKtFile(nioPath) { live ->
			if (live.isStale) {
				// Joining another feature's scope hands over text older than the buffer, so the import
				// insertion point computed from it would land in the wrong place.
				logger.debug(
					"skipping import candidates for {}: pinned text is behind the buffer",
					nioPath
				)
				return@withLiveKtFile ImportCandidates.FileChanged
			}

			val candidates =
				live.read { ktFile ->
					classifiers.associate { it.fqName to insertImport(ktFile, it.fqName) }
				}

			if (live.isStale) {
				// Resolving the file and taking the read lock can both block long enough for the user to
				// type, and nothing between here and performCodeAction re-checks the insertion point.
				logger.debug(
					"dropping import candidates for {}: buffer moved while computing",
					nioPath
				)
				return@withLiveKtFile ImportCandidates.FileChanged
			}

			ImportCandidates.Found(candidates)
		} ?: ImportCandidates.Found(emptyMap())
	}

	override fun postExec(
		data: ActionData,
		result: Any,
	) {
		super.postExec(data, result)

		if (result is ImportCandidates.FileChanged) {
			flashInfo(R.string.msg_import_file_changed)
			return
		}

		if (result !is ImportCandidates.Found) {
			return
		}

		val candidates = result.edits
		if (candidates.isEmpty()) {
			logger.warn("No classifiers to import.")
			flashError(R.string.msg_no_imports_found)
			return
		}

		val client =
			data.languageClient
				?: run {
					logger.warn("No language client set. Cannot complete action.")
					return
				}

		val file = data.requireFile()
		val nioPath = file.toPath()
		val actions =
			candidates
				.map { (fqName, edits) ->
					CodeActionItem(
						title = fqName,
						changes = listOf(DocumentChange(file = nioPath, edits = edits)),
						kind = CodeActionKind.QuickFix,
						command = Command.CMD_FORMAT_CODE,
					)
				}

		when (actions.size) {
			0 -> {
				logger.error("No code actions found. Cannot completion action.")
			}

			1 -> {
				client.performCodeAction(actions[0])
			}

			else -> {
				showImportChooser(data, actions, client)
			}
		}
	}

	/**
	 * Shows the import chooser and makes every part of it long-pressable for help.
	 *
	 * [applyLongPressRecursively] skips [ListView] subtrees, so the item list needs its own
	 * listener -- the dialog chrome and the rows are wired separately (ADFA-4510).
	 */
	private fun showImportChooser(
		data: ActionData,
		actions: List<CodeActionItem>,
		client: ILanguageClient,
	) {
		val context = data[Context::class.java] ?: return
		val dialog =
			newDialogBuilder(data)
				.setTitle(label)
				.setItems(actions.map { it.title }.toTypedArray()) { dialog, which ->
					dialog.dismiss()
					actions.getOrNull(which)?.also { client.performCodeAction(it) }
						?: run {
							logger.error("Index $which is out of bounds for actions of size ${actions.size}")
						}
				}.create()

		dialog.listView?.setOnItemLongClickListener { _, view, _, _ ->
			true
		}

		dialog.setOnShowListener {
			val root = dialog.window?.decorView ?: return@setOnShowListener
			root.applyLongPressRecursively {
				true
			}
		}

		dialog.show()
	}

}

/**
 * The outcome of resolving import candidates.
 *
 * The two are distinct at the UI: [Found] with no entries means the reference names nothing
 * importable, while [FileChanged] means candidates were found and then discarded because the buffer
 * moved out from under the offsets they were measured against.
 */
internal sealed interface ImportCandidates {
	/** The import edits for each candidate, keyed by fully-qualified name. */
	data class Found(
		val edits: Map<String, List<TextEdit>>,
	) : ImportCandidates

	/** The buffer moved while the candidates were being computed, so the edits were dropped. */
	data object FileChanged : ImportCandidates
}
