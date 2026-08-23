package dev.mutwakil.androidide.lsp.kotlin.actions

import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.actions.newDialogBuilder
import dev.mutwakil.androidide.actions.requireContext
import dev.mutwakil.androidide.actions.requireFile
import dev.mutwakil.androidide.lsp.kotlin.compiler.read
import dev.mutwakil.androidide.lsp.kotlin.diagnostic.DiagnosticAction
import dev.mutwakil.androidide.lsp.kotlin.utils.NullSafetyKind
import dev.mutwakil.androidide.lsp.kotlin.utils.NullSafetyVariant
import dev.mutwakil.androidide.lsp.kotlin.utils.findNullableMemberAccess
import dev.mutwakil.androidide.lsp.kotlin.utils.nullSafetyVariants
import dev.mutwakil.androidide.lsp.models.CodeActionItem
import dev.mutwakil.androidide.lsp.models.CodeActionKind
import dev.mutwakil.androidide.lsp.models.Command
import dev.mutwakil.androidide.lsp.models.DocumentChange
import dev.mutwakil.androidide.resources.R
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Offers null-safety quick fixes on an UNSAFE_CALL diagnostic (`receiver.selector` where `receiver`
 * is nullable): assert non-null (`!!`), safe call (`?.`), or an Elvis fallback (`?:`). Each is a
 * separate suggestion. Diagnostic-driven, mirroring [AddImportAction].
 *
 * Scope is deliberately the dot-qualified member-access case (UNSAFE_CALL). The sibling unsafe-call
 * factories (implicit-invoke/infix/operator) sit on other PSI shapes and would need different
 * rewrites; nullable type-mismatch (assignment/return/argument) is a different fix entirely. Both
 * are out of scope here.
 */
class NullSafetyAction : BaseKotlinCodeAction() {
	companion object {
		const val ID = "ide.editor.lsp.kt.diagnostics.nullSafety"
	}

	override var titleTextRes: Int = R.string.action_null_safety_fixes
	override val id: String = ID
	override var label: String = ""

	override fun prepare(data: ActionData) {
		super.prepare(data)

		val nullSafetyFixDiagnostic =
			data.findDiagnosticExtra<DiagnosticAction.NullSafetyFix>()

		if (!visible || nullSafetyFixDiagnostic == null) {
			markInvisible()
			return
		}
	}

	override suspend fun execAction(data: ActionData): List<NullSafetyVariant> =
		runCatching {
			val (diagnostic, extra) =
				data.findDiagnosticExtra<DiagnosticAction.NullSafetyFix>()
					?: return emptyList()

			val nioPath = data.requireFile().toPath()

			// Fetch the live KtFile BEFORE entering `read` (deadlock rule: its refresh needs write access).
			val ktFile =
				withContext(Dispatchers.IO) {
					extra.compilationEnv.ktSymbolIndex
						.getCurrentKtFile(nioPath)
						.get()
				} ?: return emptyList()

			extra.compilationEnv.project.read {
				val qe =
					findNullableMemberAccess(
						ktFile,
						diagnostic.range.start.requireIndex(),
						diagnostic.range.end.requireIndex(),
					) ?: return@read emptyList()
				nullSafetyVariants(qe)
			}
		}.getOrElse { e ->
			if (e is CancellationException) throw e
			logger.warn("Failed to compute null-safety fixes", e)
			emptyList()
		}

	override fun postExec(
		data: ActionData,
		result: Any,
	) {
		super.postExec(data, result)
		if (result !is List<*> || result.isEmpty()) return

		@Suppress("UNCHECKED_CAST")
		result as List<NullSafetyVariant>

		val client =
			data.languageClient ?: run {
				logger.warn("No language client set. Cannot apply null-safety fix.")
				return
			}
		val context = data.requireContext()
		val nioPath = data.requireFile().toPath()

		val actions =
			result.map { variant ->
				CodeActionItem(
					title = context.getString(variant.kind.titleRes),
					changes = listOf(DocumentChange(file = nioPath, edits = variant.edits)),
					kind = CodeActionKind.QuickFix,
					command = Command("", ""), // no post-action command (edits are already final)
				)
			}

		when (actions.size) {
			0 -> {
				return
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
							?: logger.error("Index $which is out of bounds for actions of size ${actions.size}")
					}.show()
			}
		}
	}
}

private val NullSafetyKind.titleRes: Int
	get() =
		when (this) {
			NullSafetyKind.ASSERT_NON_NULL -> R.string.action_null_safety_assert
			NullSafetyKind.SAFE_CALL -> R.string.action_null_safety_safe_call
			NullSafetyKind.ELVIS -> R.string.action_null_safety_elvis
		}
