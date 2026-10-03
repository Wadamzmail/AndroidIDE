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
package dev.mutwakil.androidide.utils

import android.content.Context
import dev.mutwakil.androidide.actions.ActionItem.Location.EDITOR_FILE_TABS
import dev.mutwakil.androidide.actions.ActionItem.Location.EDITOR_FILE_TREE
import dev.mutwakil.androidide.actions.ActionItem.Location.EDITOR_TOOLBAR
import dev.mutwakil.androidide.actions.ActionsRegistry
import dev.mutwakil.androidide.actions.build.ProjectSyncAction
import dev.mutwakil.androidide.actions.build.QuickRunAction
import dev.mutwakil.androidide.actions.build.RunTasksAction
import dev.mutwakil.androidide.actions.editor.CopyAction
import dev.mutwakil.androidide.actions.editor.CutAction
import dev.mutwakil.androidide.actions.editor.ExpandSelectionAction
import dev.mutwakil.androidide.actions.editor.LongSelectAction
import dev.mutwakil.androidide.actions.editor.PasteAction
import dev.mutwakil.androidide.actions.editor.SelectAllAction
import dev.mutwakil.androidide.actions.etc.DisconnectLogSendersAction
import dev.mutwakil.androidide.actions.etc.FindActionMenu
import dev.mutwakil.androidide.actions.etc.FindInFileAction
import dev.mutwakil.androidide.actions.etc.FindInProjectAction
import dev.mutwakil.androidide.actions.etc.LaunchAppAction
import dev.mutwakil.androidide.actions.etc.PreviewLayoutAction
import dev.mutwakil.androidide.actions.etc.ReloadColorSchemesAction
import dev.mutwakil.androidide.actions.etc.ReplaceInProjectAction
import dev.mutwakil.androidide.actions.file.CloseAllFilesAction
import dev.mutwakil.androidide.actions.file.CloseFileAction
import dev.mutwakil.androidide.actions.file.CloseOtherFilesAction
import dev.mutwakil.androidide.actions.file.FormatCodeAction
import dev.mutwakil.androidide.actions.file.SaveFileAction
import dev.mutwakil.androidide.actions.filetree.CopyPathAction
import dev.mutwakil.androidide.actions.filetree.DeleteAction
import dev.mutwakil.androidide.actions.filetree.NewFileAction
import dev.mutwakil.androidide.actions.filetree.NewFolderAction
import dev.mutwakil.androidide.actions.filetree.OpenWithAction
import dev.mutwakil.androidide.actions.filetree.RenameAction
import dev.mutwakil.androidide.actions.text.RedoAction
import dev.mutwakil.androidide.actions.text.UndoAction

/**
 * Takes care of registering actions to the actions registry for the editor activity.
 *
 * @author Akash Yadav
 */
class EditorActivityActions {

  companion object {

    @JvmStatic
    fun register(context: Context) {
      clear()
      val registry = ActionsRegistry.getInstance()
      var order = 0

      // Toolbar actions
      registry.registerAction(UndoAction(context, order++))
      registry.registerAction(RedoAction(context, order++))
      registry.registerAction(QuickRunAction(context, order++))
      registry.registerAction(RunTasksAction(context, order++))
      registry.registerAction(SaveFileAction(context, order++))
      registry.registerAction(PreviewLayoutAction(context, order++))
      registry.registerAction(FindActionMenu(context, order++))
      registry.registerAction(FindInFileAction(context, order++))
      registry.registerAction(FindInProjectAction(context, order++))
      registry.registerAction(ReplaceInProjectAction(context, order++))
      registry.registerAction(ProjectSyncAction(context, order++))
      registry.registerAction(ReloadColorSchemesAction(context, order++))
      registry.registerAction(DisconnectLogSendersAction(context, order++))
      registry.registerAction(LaunchAppAction(context, order++))

      // editor text actions
      registry.registerAction(ExpandSelectionAction(context, order++))
      registry.registerAction(SelectAllAction(context, order++))
      registry.registerAction(LongSelectAction(context, order++))
      registry.registerAction(CutAction(context, order++))
      registry.registerAction(CopyAction(context, order++))
      registry.registerAction(PasteAction(context, order++))
      registry.registerAction(FormatCodeAction(context, order++))

      // file tab actions
      registry.registerAction(CloseFileAction(context, order++))
      registry.registerAction(CloseOtherFilesAction(context, order++))
      registry.registerAction(CloseAllFilesAction(context, order++))

      // file tree actions
      registry.registerAction(CopyPathAction(context, order++))
      registry.registerAction(DeleteAction(context, order++))
      registry.registerAction(NewFileAction(context, order++))
      registry.registerAction(NewFolderAction(context, order++))
      registry.registerAction(OpenWithAction(context, order++))
      registry.registerAction(RenameAction(context, order++))
    }

    @JvmStatic
    fun clear() {
      // EDITOR_TEXT_ACTIONS should not be cleared as the language servers register actions there as
      // well
      val locations = arrayOf(EDITOR_TOOLBAR, EDITOR_FILE_TABS, EDITOR_FILE_TREE)
      val registry = ActionsRegistry.getInstance()
      locations.forEach(registry::clearActions)
    }
  }
}
