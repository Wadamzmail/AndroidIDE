package dev.mutwakil.androidide.lsp.kotlin

import dev.mutwakil.androidide.actions.ActionItem
import dev.mutwakil.androidide.lsp.actions.CommentLineAction
import dev.mutwakil.androidide.lsp.actions.IActionsMenuProvider
import dev.mutwakil.androidide.lsp.actions.SurroundWithTryCatchAction
import dev.mutwakil.androidide.lsp.actions.UncommentLineAction
import dev.mutwakil.androidide.lsp.kotlin.actions.AddImportAction
import dev.mutwakil.androidide.lsp.kotlin.actions.ExtractMethodAction
import dev.mutwakil.androidide.lsp.kotlin.actions.ExtractVariableAction
import dev.mutwakil.androidide.lsp.kotlin.actions.FindReferencesAction
import dev.mutwakil.androidide.lsp.kotlin.actions.GoToDefinitionAction
import dev.mutwakil.androidide.lsp.kotlin.actions.ImplementMembersAction
import dev.mutwakil.androidide.lsp.kotlin.actions.NullSafetyAction
import dev.mutwakil.androidide.lsp.kotlin.actions.OrganizeImportsAction

object KotlinCodeActionsMenu : IActionsMenuProvider {
	internal const val KT_LANG = "kt"
	private val KT_EXTS = listOf("kt", "kts")
	private const val KT_LINE_COMMENT_TOKEN = "//"
	private const val KT_CATCH_CLAUSE = "catch (e: Exception)"
	private const val KT_CATCH_BODY = "e.printStackTrace()"

	override val actions: List<ActionItem> =
		listOf(
			CommentLineAction(
				KT_LANG,
				KT_EXTS,
				KT_LINE_COMMENT_TOKEN,
			),
			UncommentLineAction(
				KT_LANG,
				KT_EXTS,
				KT_LINE_COMMENT_TOKEN,
			),
			GoToDefinitionAction(),
			FindReferencesAction(),
			AddImportAction(),
			OrganizeImportsAction(),
			SurroundWithTryCatchAction(
				KT_LANG,
				KT_EXTS,
				KotlinLanguageServer.SERVER_ID,
				KT_CATCH_CLAUSE,
				KT_CATCH_BODY,
			),
			NullSafetyAction(),
			ImplementMembersAction(),
			ExtractVariableAction(),
			ExtractMethodAction(),
		)
}
