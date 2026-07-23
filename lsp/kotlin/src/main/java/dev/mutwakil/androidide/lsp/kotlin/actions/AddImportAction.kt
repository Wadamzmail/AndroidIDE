package dev.mutwakil.androidide.lsp.kotlin.actions

import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.has
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.actions.newDialogBuilder
import dev.mutwakil.androidide.actions.requireFile
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
import dev.mutwakil.androidide.utils.flashError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.appdevforall.codeonthego.indexing.jvm.JvmSymbol

class AddImportAction : BaseKotlinCodeAction() {
	override var titleTextRes: Int = R.string.action_import_classes

	override val id: String = "ide.editor.lsp.kt.diagnostics.addImport"
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

	override suspend fun execAction(data: ActionData): Map<JvmSymbol, List<TextEdit>> {
		val (_, extra) =
			data.findDiagnosticExtra<DiagnosticAction.ResolveReference>()
				?: return emptyMap()

		val (env, action) = extra
		val file = data.requireFile()
		val nioPath = file.toPath()
		val ktFile =
			withContext(Dispatchers.IO) {
				env.ktSymbolIndex
					.getCurrentKtFile(nioPath)
					.get()
			}
				?: return emptyMap()

		return env.ktSymbolIndex
			.findSymbolBySimpleName(action.referenceName, limit = 0)
			.filter { it.kind.isClassifier }
			.associateWith { symbol -> insertImport(ktFile, symbol.fqName) }
	}

	override fun postExec(
		data: ActionData,
		result: Any,
	) {
		super.postExec(data, result)

		if (result !is Map<*, *>) {
			return
		}

		@Suppress("UNCHECKED_CAST")
		result as Map<JvmSymbol, List<TextEdit>>

		if (result.isEmpty()) {
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
			result
				.map { (symbol, edits) ->
					CodeActionItem(
						title = symbol.fqName,
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
				newDialogBuilder(data)
					.setTitle(label)
					.setItems(actions.map { it.title }.toTypedArray()) { dialog, which ->
						dialog.dismiss()
						actions.getOrNull(which)?.also { client.performCodeAction(it) }
							?: run {
								logger.error("Index $which is out of bounds for actions of size ${actions.size}")
							}
					}.show()
			}
		}
	}
}