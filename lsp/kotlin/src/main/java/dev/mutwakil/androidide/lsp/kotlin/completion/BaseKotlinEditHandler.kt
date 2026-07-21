package dev.mutwakil.androidide.lsp.kotlin.completion

import dev.mutwakil.androidide.editor.api.ILspEditor
import dev.mutwakil.androidide.lsp.edits.DefaultEditHandler
import dev.mutwakil.androidide.lsp.models.Command
import io.github.rosemoe.sora.widget.CodeEditor

/**
 * Implementation of [DefaultEditHandler] which avoids reflection in
 * [DefaultEditHandler.executeCommand].
 *
 * @author Akash Yadav
 */
open class BaseKotlinEditHandler : DefaultEditHandler() {

	override fun executeCommand(editor: CodeEditor, command: Command?) {
		if (editor is ILspEditor) {
			editor.executeCommand(command)
			return
		}
		super.executeCommand(editor, command)
	}
}
