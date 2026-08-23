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
import dev.mutwakil.androidide.lsp.api.ILanguageServerRegistry
import dev.mutwakil.androidide.lsp.models.CodeActionItem
import dev.mutwakil.androidide.lsp.models.CodeActionKind
import dev.mutwakil.androidide.lsp.models.Command
import dev.mutwakil.androidide.lsp.models.DocumentChange
import dev.mutwakil.androidide.lsp.models.TextEdit
import dev.mutwakil.androidide.resources.R
import org.slf4j.LoggerFactory
import java.io.File

class SurroundWithTryCatchAction(
    lang: String,
    private val targetFileExtensions: List<String>,
    private val serverId: String,
    private val catchClause: String,
    private val catchBody: String
) : EditorActionItem {
    companion object {
        /** The id is per-language, since one instance is registered per language. */
        fun idFor(lang: String) = "ide.editor.lsp.$lang.surroundWithTryCatch"

        private val logger = LoggerFactory.getLogger(SurroundWithTryCatchAction::class.java)
    }

    constructor(
        lang: String,
        extension: String,
        serverId: String,
        catchClause: String,
        catchBody: String
    ) : this(lang, listOf(extension), serverId, catchClause, catchBody)

    override val id: String = idFor(lang)
    override var label: String = ""

    override var visible = true
    override var enabled = true
    override var icon: Drawable? = null
    override var location: ActionItem.Location = ActionItem.Location.EDITOR_CODE_ACTIONS

    // Reads the editor selection, so it must run on the UI thread (as CommentLineAction does).
    override var requiresUIThread: Boolean = true

    override fun prepare(data: ActionData) {
        super.prepare(data)

        if (!data.hasRequiredData(Context::class.java, File::class.java)) {
            markInvisible()
            return
        }

        val context = data.requireContext()
        label = context.getString(R.string.action_surround_with_try_catch)

        val file = data.requireFile()
        if (file.extension !in targetFileExtensions) {
            markInvisible()
            return
        }
    }

    override suspend fun execAction(data: ActionData): List<TextEdit> {
        val editor = data.requireEditor()
        val cursor = editor.cursor
        val (startLine, endLine) =
            resolveSurroundLines(
                cursor.leftLine,
                cursor.leftColumn,
                cursor.rightLine,
                cursor.rightColumn,
            )
        val edit =
            computeSurroundWithTryCatchEdit(
                editor.text.toString(),
                startLine,
                endLine,
                catchClause,
                catchBody,
            ) ?: return emptyList()
        return listOf(edit)
    }

    override fun postExec(
        data: ActionData,
        result: Any,
    ) {
        super.postExec(data, result)

        if (result !is List<*> || result.isEmpty()) {
            return
        }

        @Suppress("UNCHECKED_CAST")
        val edits = result as List<TextEdit>

        val client =
            ILanguageServerRegistry.getDefault().getServer(serverId)?.client
                ?: run {
                    logger.warn("No language client set. Cannot complete action.")
                    return
                }

        val file = data.requireFile()
        client.performCodeAction(
            CodeActionItem(
                title = label,
                changes = listOf(DocumentChange(file = file.toPath(), edits = edits)),
                kind = CodeActionKind.QuickFix,
                command = Command.CMD_FORMAT_CODE,
            ),
        )
    }
}