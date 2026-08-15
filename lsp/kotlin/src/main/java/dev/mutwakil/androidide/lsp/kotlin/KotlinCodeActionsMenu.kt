package dev.mutwakil.androidide.lsp.kotlin

import dev.mutwakil.androidide.actions.ActionItem
import dev.mutwakil.androidide.lsp.actions.CommentLineAction
import dev.mutwakil.androidide.lsp.actions.IActionsMenuProvider
import dev.mutwakil.androidide.lsp.actions.UncommentLineAction
import dev.mutwakil.androidide.lsp.kotlin.actions.AddImportAction
import dev.mutwakil.androidide.lsp.kotlin.actions.FindReferencesAction
import dev.mutwakil.androidide.lsp.kotlin.actions.GoToDefinitionAction
import dev.mutwakil.androidide.lsp.kotlin.actions.ImplementMembersAction
import dev.mutwakil.androidide.lsp.kotlin.actions.NullSafetyAction
import dev.mutwakil.androidide.lsp.kotlin.actions.OrganizeImportsAction
import dev.mutwakil.androidide.lsp.kotlin.actions.SurroundWithTryCatchAction

object KotlinCodeActionsMenu : IActionsMenuProvider {
	private const val KT_LANG = "kt"
	private val KT_EXTS = listOf("kt", "kts")
	private const val KT_LINE_COMMENT_TOKEN = "//"

	override val actions: List<ActionItem> =
		listOf(
			CommentLineAction(KT_LANG, KT_EXTS, KT_LINE_COMMENT_TOKEN),
			UncommentLineAction(KT_LANG, KT_EXTS, KT_LINE_COMMENT_TOKEN),
			GoToDefinitionAction(),
			FindReferencesAction(),
			AddImportAction(),
			OrganizeImportsAction(),
			ImplementMembersAction(),
			SurroundWithTryCatchAction(),
			NullSafetyAction()
		)
}
