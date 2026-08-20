/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.mutwakil.androidide.lsp.java.actions

import dev.mutwakil.androidide.actions.ActionItem
import dev.mutwakil.androidide.lsp.actions.CommentLineAction
import dev.mutwakil.androidide.lsp.actions.IActionsMenuProvider
import dev.mutwakil.androidide.lsp.actions.SurroundWithTryCatchAction
import dev.mutwakil.androidide.lsp.actions.UncommentLineAction
import dev.mutwakil.androidide.lsp.java.JavaLanguageServer
import dev.mutwakil.androidide.lsp.java.actions.common.FindReferencesAction
import dev.mutwakil.androidide.lsp.java.actions.common.GoToDefinitionAction
import dev.mutwakil.androidide.lsp.java.actions.common.OrganizeImportsAction
import dev.mutwakil.androidide.lsp.java.actions.common.RemoveUnusedImportsAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.AddImportAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.AddThrowsAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.AutoFixImportsAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.CreateMissingMethodAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.FieldToBlockAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.ImplementAbstractMethodsAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.RemoveClassAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.RemoveMethodAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.RemoveUnusedThrowsAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.SuppressUncheckedWarningAction
import dev.mutwakil.androidide.lsp.java.actions.diagnostics.VariableToStatementAction
import dev.mutwakil.androidide.lsp.java.actions.generators.GenerateConstructorAction
import dev.mutwakil.androidide.lsp.java.actions.generators.GenerateMissingConstructorAction
import dev.mutwakil.androidide.lsp.java.actions.generators.GenerateSettersAndGettersAction
import dev.mutwakil.androidide.lsp.java.actions.generators.GenerateToStringMethodAction
import dev.mutwakil.androidide.lsp.java.actions.generators.OverrideSuperclassMethodsAction

/**
 * Java code actions.
 * @author Akash Yadav
 */
object JavaCodeActionsMenu : IActionsMenuProvider {

  private const val LANG = "java"
  private const val EXT = "java"
  private const val LINE_COMMENT_TOKEN = "//"

  private const val CATCH_CLAUSE = "catch (Exception e)"
  private const val CATCH_BODY = "e.printStackTrace();"

  override val actions: List<ActionItem> =
    listOf(
      CommentLineAction(LANG,EXT,LINE_COMMENT_TOKEN),
      UncommentLineAction(LANG,EXT,LINE_COMMENT_TOKEN),
      GoToDefinitionAction(),
      FindReferencesAction(),
      AddImportAction(),
      AutoFixImportsAction(),
      ImplementAbstractMethodsAction(),
      VariableToStatementAction(),
      FieldToBlockAction(),
      RemoveClassAction(),
      RemoveMethodAction(),
      RemoveUnusedThrowsAction(),
      CreateMissingMethodAction(),
      SuppressUncheckedWarningAction(),
      AddThrowsAction(),
      GenerateSettersAndGettersAction(),
      OverrideSuperclassMethodsAction(),
      GenerateMissingConstructorAction(),
      GenerateConstructorAction(),
      GenerateToStringMethodAction(),
      RemoveUnusedImportsAction(),
      OrganizeImportsAction(),
      SurroundWithTryCatchAction(
        LANG,
        EXT,
        JavaLanguageServer.SERVER_ID,
        CATCH_CLAUSE,
        CATCH_BODY
      ),
    )
}
