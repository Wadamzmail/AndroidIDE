package dev.mutwakil.androidide.actions.etc

import android.content.Context
import androidx.core.content.ContextCompat
import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.ActionItem
import dev.mutwakil.androidide.actions.EditorActivityAction
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.projects.IProjectManager
import dev.mutwakil.androidide.resources.R

class ReplaceInProjectAction() : EditorActivityAction() {
    override val id: String = ID
    override var requiresUIThread: Boolean = true
    override var order: Int = 0

    companion object {
        const val ID = "ide.editor.replace.inProject"
    }

    constructor(context: Context, order: Int) : this() {
        this.label = context.getString(R.string.menu_replace_project)
        this.icon = ContextCompat.getDrawable(context, R.drawable.ic_search_project)
        this.order = order
    }

    override fun prepare(data: ActionData) {
        super.prepare(data)
        data.getActivity()
            ?: run {
                markInvisible()
                return
            }

        val gradleBuild = IProjectManager.getInstance().gradleBuild
        if (gradleBuild == null || gradleBuild.subProjectCount == 0) {
            markInvisible()
            return
        }

        visible = true
        enabled = true
    }

    override suspend fun execAction(data: ActionData): Boolean {
        val context = data.getActivity() ?: return false
        val dialog = context.replaceInProjectDialog ?: return false

        return run {
            dialog.show()
            true
        }
    }
}