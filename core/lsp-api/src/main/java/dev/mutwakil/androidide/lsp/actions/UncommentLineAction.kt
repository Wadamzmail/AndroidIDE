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
package dev.mutwakil.androidide.lsp.actions

import android.content.Context
import android.graphics.drawable.Drawable
import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.ActionItem
import dev.mutwakil.androidide.actions.EditorActionItem
import dev.mutwakil.androidide.actions.hasRequiredData
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.actions.requireContext
import dev.mutwakil.androidide.actions.requireEditor
import dev.mutwakil.androidide.actions.requireFile
import dev.mutwakil.androidide.resources.R
import io.github.rosemoe.sora.text.batchEdit
import java.io.File

/** @author Akash Yadav */
class UncommentLineAction(
	lang: String,
	private val targetFileExtensions: List<String>,
	private val lineCommentToken: String,
) : EditorActionItem {

	constructor(lang: String, extension: String, lineCommentToken: String) :
			this(lang, listOf(extension), lineCommentToken)

	override val id: String = "ide.editor.lsp.$lang.uncommentLine"
	override var label: String = ""

	override var visible = true
	override var enabled = true
	override var icon: Drawable? = null
	override var location: ActionItem.Location = ActionItem.Location.EDITOR_CODE_ACTIONS
	override var requiresUIThread: Boolean = true
//	override var tooltipTag: String = TooltipTag.EDITOR_CODE_ACTIONS_UNCOMMENT


	override fun prepare(data: ActionData) {
		super.prepare(data)

		if (!data.hasRequiredData(Context::class.java, File::class.java)) {
			markInvisible()
			return
		}

		val context = data.requireContext()
		label = context.getString(R.string.action_uncomment_line)

		val file = data.requireFile()
		if (file.extension !in targetFileExtensions) {
			markInvisible()
			return
		}
	}

	override suspend fun execAction(data: ActionData): Boolean {
		val editor = data.requireEditor()
		val text = editor.text
		val cursor = editor.cursor

		text.batchEdit {
			for (line in cursor.leftLine..cursor.rightLine) {
				val l = text.getLineString(line)
				if (l.trim().startsWith(lineCommentToken)) {
					val i = l.indexOf(lineCommentToken)
					text.delete(line, i, line, i + 2)
				}
			}
		}

		return true
	}

	override fun dismissOnAction() = true
}
