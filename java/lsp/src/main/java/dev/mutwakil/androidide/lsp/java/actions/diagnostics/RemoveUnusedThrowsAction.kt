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
package dev.mutwakil.androidide.lsp.java.actions.diagnostics

import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.hasRequiredData
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.actions.requireFile
import dev.mutwakil.androidide.actions.requirePath
import dev.mutwakil.androidide.lsp.java.JavaCompilerProvider
import dev.mutwakil.androidide.lsp.java.actions.BaseJavaCodeAction
import dev.mutwakil.androidide.lsp.java.models.DiagnosticCode
import dev.mutwakil.androidide.lsp.java.Rewrite.RemoveException
import dev.mutwakil.androidide.lsp.java.utils.CodeActionUtils
import dev.mutwakil.androidide.projects.IProjectManager
import dev.mutwakil.androidide.resources.R
import org.slf4j.LoggerFactory

/** @author Akash Yadav */
class RemoveUnusedThrowsAction : BaseJavaCodeAction() {

  override val id: String = "ide.editor.lsp.java.diagnostics.removeUnusedThrows"
  override var label: String = ""
  private val diagnosticCode = DiagnosticCode.UNUSED_THROWS.id

  override val titleTextRes: Int = R.string.action_remove_unused_throws

  companion object {

    private val log = LoggerFactory.getLogger(RemoveUnusedThrowsAction::class.java)
  }

  override fun prepare(data: ActionData) {
    super.prepare(data)

    if (
      !visible ||
      !data.hasRequiredData(dev.mutwakil.androidide.lsp.models.DiagnosticItem::class.java)
    ) {
      markInvisible()
      return
    }

    val diagnostic = data[dev.mutwakil.androidide.lsp.models.DiagnosticItem::class.java]!!
    if (diagnosticCode != diagnostic.code) {
      markInvisible()
      return
    }
  }

  override suspend fun execAction(data: ActionData): Any {
    val d = data[dev.mutwakil.androidide.lsp.models.DiagnosticItem::class.java]!!
    val compiler =
      JavaCompilerProvider.get(
        IProjectManager.getInstance().workspace?.findModuleForFile(data.requireFile(), false)
          ?: return Any()
      )
    val file = data.requirePath()
    return compiler.compile(file).get { task ->
      val notThrown = CodeActionUtils.extractNotThrownExceptionName(d.message)
      val methodWithExtraThrow = CodeActionUtils.findMethod(task, d.range)

      return@get RemoveException(
        methodWithExtraThrow.className,
        methodWithExtraThrow.methodName,
        methodWithExtraThrow.erasedParameterTypes,
        notThrown
      )
    }
  }

  override fun postExec(data: ActionData, result: Any) {
    if (result !is RemoveException) {
      log.warn("Unable to remove unused throws")
      return
    }

    performCodeAction(data, result)
  }
}
