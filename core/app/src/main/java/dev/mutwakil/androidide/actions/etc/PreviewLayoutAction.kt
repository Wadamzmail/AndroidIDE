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

package dev.mutwakil.androidide.actions.etc

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.android.aaptcompiler.AaptResourceType.LAYOUT
import com.android.aaptcompiler.extractPathData
import com.blankj.utilcode.util.KeyboardUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder 
import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.EditorRelatedAction
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.activities.editor.EditorHandlerActivity
import dev.mutwakil.androidide.activities.TerminalActivity
import dev.mutwakil.androidide.compose.preview.ComposePreviewActivity
import dev.mutwakil.androidide.editor.ui.IDEEditor
import dev.mutwakil.androidide.resources.R
import dev.mutwakil.androidide.uidesigner.UIDesignerActivity
import dev.mutwakil.androidide.projects.IProjectManager
import dev.mutwakil.androidide.utils.Environment
import org.slf4j.LoggerFactory
import java.io.File

/** @author Akash Yadav */
class PreviewLayoutAction(context: Context, override val order: Int) : EditorRelatedAction() {

  override val id: String = "ide.editor.previewLayout"

  override var requiresUIThread: Boolean = false
  
  private val localMavenRepo: File
        get() = File(Environment.HOME, "maven/localMvnRepository")
  
  private var previewType: PreviewType = PreviewType.NONE

  private enum class PreviewType {
    NONE,
    XML_LAYOUT,
    COMPOSE
  }
  
  companion object {
    private val LOG = LoggerFactory.getLogger(PreviewLayoutAction::class.java)
    
    private val COMPOSABLE_PREVIEW_PATTERN = Regex(
          """@Preview\s*(?:\(([^)]*)\))?\s*(?:@\w+(?:\s*\([^)]*\))?[\s\n]*)*(?:(?:private|internal|protected|public|open|override|suspend|inline|external|abstract|final|actual|expect)\s+)*fun\s+(\w+)""",
          setOf(RegexOption.MULTILINE, RegexOption.DOT_MATCHES_ALL)
      )
  }

  init {
    label = context.getString(R.string.title_preview_layout)
    icon = ContextCompat.getDrawable(context, R.drawable.ic_preview_layout)
  }

  override fun prepare(data: ActionData) {
    super.prepare(data)
    
    previewType = PreviewType.NONE

    if (data.getActivity() == null) {
      markInvisible()
      return
    }

    val viewModel = data.requireActivity().editorViewModel
    val editor = data.getEditor()
    val file = editor?.file

    if (file != null && !viewModel.isInitializing) {
      when {
        file.name.endsWith(".xml") -> {
          val type = try {
            extractPathData(file).type
          } catch (err: Throwable) {
            markInvisible()
            return
          }

          if (type == LAYOUT) {
            previewType = PreviewType.XML_LAYOUT
            visible = true
            enabled = true
          } else {
            markInvisible()
          }
        }
        file.name.endsWith(".kt") && moduleUsesCompose(file, editor.text.toString()) -> {
          previewType = PreviewType.COMPOSE
          visible = true
          enabled = true
        }
        else -> {
          markInvisible()
        }
      }
      } else {
      if (file != null && file.name.endsWith(".kt") && moduleUsesCompose(file)) {
        previewType = PreviewType.COMPOSE
        visible = true
        enabled = false
      } else {
        markInvisible()
      }
    }

  }

  override fun getShowAsActionFlags(data: ActionData): Int {
    val activity = data.getActivity() ?: return super.getShowAsActionFlags(data)
    return if (KeyboardUtils.isSoftInputVisible(activity)) {
      MenuItem.SHOW_AS_ACTION_IF_ROOM
    } else {
      MenuItem.SHOW_AS_ACTION_ALWAYS
    }
  }

  override suspend fun execAction(data: ActionData): Boolean {
    val activity = data.requireActivity()
    activity.saveAll()
    return true
  }

  override fun postExec(data: ActionData, result: Any) {
    val activity = data.requireActivity()
    
    when (previewType) {
      PreviewType.XML_LAYOUT -> {
        val editor = data.getEditor() ?: return
        val file = editor.file ?: return
        activity.previewXmlLayout(file)
      }
      PreviewType.COMPOSE -> {
        val editor = data.getEditor() ?: return
        val file = editor.file ?: return
        if (!checkComposeDeps(activity)) {
          return
        }
        activity.showComposePreviewSheet(file, editor.text.toString())
      }
      PreviewType.NONE -> {}
    }
  }

  private fun EditorHandlerActivity.previewLayout(file: File) {
    val intent = Intent(this, UIDesignerActivity::class.java)
    intent.putExtra(UIDesignerActivity.EXTRA_FILE, file.absolutePath)
    uiDesignerResultLauncher?.launch(intent)
  }
  
  private fun EditorHandlerActivity.showComposePreviewSheet(file: File, sourceCode: String) {
    ComposePreviewActivity.start(this, sourceCode, file.absolutePath)
  }

  private fun ActionData.requireEditor(): IDEEditor {
    return this.getEditor() ?: throw IllegalArgumentException(
      "An editor instance is required but none was provided")
  }
  
  private fun moduleUsesCompose(file: File): Boolean {
    val module = IProjectManager.getInstance().findModuleForFile(file) ?: return false
    return module.hasExternalDependency("androidx.compose.runtime", "runtime")
  }

  private fun moduleUsesCompose(file: File, editorContent: String): Boolean {
    val module = IProjectManager.getInstance().findModuleForFile(file) ?: return false
    return module.hasExternalDependency("androidx.compose.runtime", "runtime") && COMPOSABLE_PREVIEW_PATTERN.findAll(editorContent).any()
  }
  
  private fun checkComposeDeps(context: Activity): Boolean {
    val kotlinVersion = "1.9.22"
    val trove4jVersion = "1.0.20200330"
    val annotationsVersion = "26.0.2"

    val requiredFiles = listOf(
        "org/jetbrains/kotlin/kotlin-compiler-embeddable/$kotlinVersion/kotlin-compiler-embeddable-$kotlinVersion.jar",
        "org/jetbrains/kotlin/kotlin-compiler-embeddable/$kotlinVersion/kotlin-compiler-embeddable-$kotlinVersion.pom",

        "org/jetbrains/kotlin/kotlin-stdlib/$kotlinVersion/kotlin-stdlib-$kotlinVersion.jar",
        "org/jetbrains/kotlin/kotlin-stdlib/$kotlinVersion/kotlin-stdlib-$kotlinVersion.pom",

        "org/jetbrains/kotlin/kotlin-reflect/$kotlinVersion/kotlin-reflect-$kotlinVersion.jar",
        "org/jetbrains/kotlin/kotlin-reflect/$kotlinVersion/kotlin-reflect-$kotlinVersion.pom",

        "org/jetbrains/kotlin/kotlin-script-runtime/$kotlinVersion/kotlin-script-runtime-$kotlinVersion.jar",
        "org/jetbrains/kotlin/kotlin-script-runtime/$kotlinVersion/kotlin-script-runtime-$kotlinVersion.pom",

        "org/jetbrains/intellij/deps/trove4j/$trove4jVersion/trove4j-$trove4jVersion.jar",
        "org/jetbrains/intellij/deps/trove4j/$trove4jVersion/trove4j-$trove4jVersion.pom",

        "org/jetbrains/annotations/$annotationsVersion/annotations-$annotationsVersion.jar",
        "org/jetbrains/annotations/$annotationsVersion/annotations-$annotationsVersion.pom"
    )

    if (requiredFiles.all { File(localMavenRepo, it).isFile }) {
        return true
    }

    MaterialAlertDialogBuilder(context)
        .setTitle("Compose Preview")
        .setMessage(
            "Kotlin Compiler is required for Compose Preview. " +
                "Do you want to download it now?"
        )
        .setPositiveButton("Download") { _, _ ->
            val intent = Intent(context, TerminalActivity::class.java)

            intent.putExtra(
                TerminalActivity.EXTRA_ONBOARDING_RUN_COMPOSESETUP,
                true
            )

            intent.putExtra(
                TerminalActivity.EXTRA_ONBOARDING_RUN_COMPOSESETUP_ARGS,
                listOf("1.9.22")
            )

            context.startActivity(intent)
        }
        .setNegativeButton("Cancel", null)
        .show()

    return false
  }
}
