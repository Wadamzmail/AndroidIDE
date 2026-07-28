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

package dev.mutwakil.androidide.handlers

import dev.mutwakil.androidide.R
import dev.mutwakil.androidide.activities.editor.EditorHandlerActivity
import dev.mutwakil.androidide.preferences.internal.GeneralPreferences
import dev.mutwakil.androidide.resources.R.string
import dev.mutwakil.androidide.services.builder.GradleBuildService
import dev.mutwakil.androidide.tooling.api.messages.result.BuildInfo
import dev.mutwakil.androidide.tooling.events.ProgressEvent
import dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationStartEvent
import dev.mutwakil.androidide.tooling.events.task.TaskStartEvent
import dev.mutwakil.androidide.utils.flashError
import dev.mutwakil.androidide.utils.flashSuccess
import org.slf4j.LoggerFactory
import java.lang.ref.WeakReference
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * Handles events received from [GradleBuildService] updates [EditorHandlerActivity].
 * @author Akash Yadav
 */
class EditorBuildEventListener : GradleBuildService.EventListener {

  private var lastStatusLine: String = ""

  private var buildStartTimeMs: Long = 0L
  private var lastOutputTimeMs: Long = 0L
  private var lineCounter: Int = 1

  private val timestampFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)

  private var enabled = true
  private var activityReference: WeakReference<EditorHandlerActivity> = WeakReference(null)

  companion object {

    private val log = LoggerFactory.getLogger(EditorBuildEventListener::class.java)
  }

  private val _activity: EditorHandlerActivity?
    get() = activityReference.get()
  private val activity: EditorHandlerActivity
    get() = checkNotNull(activityReference.get()) { "Activity reference has been destroyed!" }

  fun setActivity(activity: EditorHandlerActivity) {
    this.activityReference = WeakReference(activity)
    this.enabled = true
  }

  fun release() {
    activityReference.clear()
    this.enabled = false
  }

  override fun prepareBuild(buildInfo: BuildInfo) {
    checkActivity("prepareBuild") ?: return

    val isFirstBuild = GeneralPreferences.isFirstBuild
    activity
      .setStatus(
        activity.getString(if (isFirstBuild) string.preparing_first else string.preparing)
      )

    if (isFirstBuild) {
      activity.showFirstBuildNotice()
    }

    resetBuildTimers()

    activity.editorViewModel.isBuildInProgress = true
    activity.content.bottomSheet.clearBuildOutput()

    if (buildInfo.tasks.isNotEmpty()) {
      onOutput(
        activity.getString(R.string.title_run_tasks) + " : " + buildInfo.tasks
      )
    }
  }

  private fun resetBuildTimers() {
    buildStartTimeMs = System.currentTimeMillis()
    lastOutputTimeMs = buildStartTimeMs
    lineCounter = 1
  }

  override fun onBuildSuccessful(tasks: List<String?>) {
    checkActivity("onBuildSuccessful") ?: return

    analyzeCurrentFile()

    GeneralPreferences.isFirstBuild = false
    activity.editorViewModel.isBuildInProgress = false

    activity.flashSuccess(R.string.build_status_sucess)
  }

  override fun onProgressEvent(event: ProgressEvent) {
    checkActivity("onProgressEvent") ?: return

    if (event is ProjectConfigurationStartEvent || event is TaskStartEvent) {
      activity.setStatus(event.descriptor.displayName)
    }
  }

  override fun onBuildFailed(tasks: List<String?>) {
    checkActivity("onBuildFailed") ?: return

    analyzeCurrentFile()

    GeneralPreferences.isFirstBuild = false
    activity.editorViewModel.isBuildInProgress = false

    activity.flashError(R.string.build_status_failed)
  }

  override fun onOutput(line: String?) {
    checkActivity("onOutput") ?: return

    line?.let { raw ->
      val formattedOutput = formatOutput(raw)
      activity.appendBuildOutput(formattedOutput)
      if (raw.contains("BUILD SUCCESSFUL") || raw.contains("BUILD FAILED")) {
        activity.setStatus(raw)
        lastStatusLine = raw
      }
    }
  }

  private fun formatOutput(raw: String): String {
    val now = System.currentTimeMillis()
    if (buildStartTimeMs == 0L) {
      buildStartTimeMs = now
      lastOutputTimeMs = now
    }

    val totalDeltaMs = now - buildStartTimeMs
    val stepDeltaMs = now - lastOutputTimeMs
    lastOutputTimeMs = now

    val timeStr = timestampFormat.format(Date(now))
    val totalMins = TimeUnit.MILLISECONDS.toMinutes(totalDeltaMs)
    val totalSecs = TimeUnit.MILLISECONDS.toSeconds(totalDeltaMs) % 60
    val totalMillis = totalDeltaMs % 1000
    val totalDeltaStr = String.format(Locale.US, "+%02d:%02d.%03d", totalMins, totalSecs, totalMillis)
    val stepDeltaStr = String.format(Locale.US, "Δ%dms", stepDeltaMs)

    val lines = raw.split("\n")
    val builder = StringBuilder()
    for (i in lines.indices) {
      val l = lines[i]
      if (i == lines.lastIndex && l.isEmpty() && lines.size > 1) {
        continue
      }
      val lineNo = lineCounter++
      builder.append(
        String.format(
          Locale.US,
          "%5d | [%s] [%s] (%s) %s",
          lineNo,
          timeStr,
          totalDeltaStr,
          stepDeltaStr,
          l
        )
      )
      if (i < lines.size - 1 || raw.endsWith("\n")) {
        builder.append("\n")
      }
    }
    return builder.toString()
  }

  private fun analyzeCurrentFile() {
    checkActivity("analyzeCurrentFile") ?: return

    val editorView = _activity?.getCurrentEditor()
    if (editorView != null) {
      val editor = editorView.editor
      editor?.analyze()
    }
  }

  private fun checkActivity(action: String): EditorHandlerActivity? {
    if (!enabled) return null

    return _activity.also {
      if (it == null) {
        log.warn("[{}] Activity reference has been destroyed!", action)
        enabled = false
      }
    }
  }
}
