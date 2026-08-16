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

package dev.mutwakil.androidide.terminal

import android.content.Context
import dev.mutwakil.androidide.managers.ToolsManager
import dev.mutwakil.androidide.utils.Environment
import com.termux.shared.file.FileUtils
import com.termux.shared.shell.command.ExecutionCommand
import com.termux.shared.termux.shell.command.runner.terminal.TermuxSession
import com.termux.terminal.TerminalSession
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.charset.StandardCharsets

/**
 * [TermuxSession] implementation that is used to run the `composesetup` script during automatic
 * installation.
 *
 * @author Akash Yadav
 */
class ComposesetupSession private constructor(
  terminalSession: TerminalSession,
  executionCommand: ExecutionCommand,
  termuxSessionClient: TermuxSessionClient?,
  setStdoutOnExit: Boolean,
  private val script: File
) : TermuxSession(
  terminalSession,
  executionCommand,
  termuxSessionClient,
  setStdoutOnExit
) {

  companion object {

    private val log = LoggerFactory.getLogger(ComposesetupSession::class.java)

    @JvmStatic
    fun wrap(session: TermuxSession?, script: File) : ComposesetupSession? {
      return session?.let { ComposesetupSession(it, script) }
    }

    @JvmStatic
    fun createScript(context: Context) : File? {
      val script = Environment.createTempFile()

      // write script contents
      if (!writeComposesetupScript(context, script)) {
        return null
      }

      // make it readable and executable-only
      FileUtils.setFilePermissions("composesetupScript", script.absolutePath, "r-x")

      return script
    }

    private fun writeComposesetupScript(context: Context, script: File): Boolean {
      context.assets.open(ToolsManager.getCommonAsset("download-kotlin-artifacts.sh")).use {
        val error = FileUtils.writeTextToFile("composesetupScript", script.absolutePath,
          StandardCharsets.UTF_8, it.readBytes().toString(StandardCharsets.UTF_8), false)
        if (error != null) {
          log.error("Failed to write composesetup script: {}", error.errorLogString)
          return false
        }
      }

      return true
    }

  }

  private constructor(src: TermuxSession, script: File) : this(
    src.terminalSession,
    src.executionCommand,
    src.termuxSessionClient,
    src.isSetStdoutOnExit,
    script
  )

  override fun finish() {
    super.finish()
    // Delete the temporary script file once the session is finished
    val error = FileUtils.deleteFile("composesetupScript", script.absolutePath, true)
    if (error != null) {
      log.error(error.errorLogString)
    }
  }
}