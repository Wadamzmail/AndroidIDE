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

package dev.mutwakil.androidide.editor.ui

import android.content.Intent
import android.net.Uri
import android.widget.ListView
import dev.mutwakil.androidide.lsp.util.DocumentationReferenceProvider
import dev.mutwakil.androidide.progress.ProgressManager
import dev.mutwakil.androidide.utils.KeyboardUtils
import io.github.rosemoe.sora.lang.completion.CompletionItem
import io.github.rosemoe.sora.widget.component.CompletionLayout
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion
import org.slf4j.LoggerFactory
import java.lang.ref.WeakReference
import kotlin.math.min

/**
 * Completion window for the editor.
 *
 * @author Akash Yadav
 */
class EditorCompletionWindow(val editor: IDEEditor) : EditorAutoCompletion(editor) {

  private var listView: ListView? = null
  private val items: MutableList<CompletionItem> = mutableListOf()

  /**
   * A scheduled-but-not-yet-started completion request, kept so a newer keystroke can cancel it.
   * See [requireCompletion].
   */
  private var pendingCompletion: Runnable? = null

  companion object {

    private val log = LoggerFactory.getLogger(EditorCompletionWindow::class.java)

    /** Quiet period for coalescing a keystroke burst: analysis runs only after typing pauses this long. */
    private const val COMPLETION_DEBOUNCE_MS = 80L
  }

  init {
    setLayout(EditorCompletionLayout())
    setEnabledAnimation(true)
  }

  override fun isShowing(): Boolean {
    @Suppress("UNNECESSARY_SAFE_CALL", "USELESS_ELVIS")
    return popup?.isShowing ?: false
  }

  override fun setLayout(layout: CompletionLayout) {
    super.setLayout(layout)
    (layout.completionList as? ListView)?.let {
      listView = it
      it.adapter = this.adapter
      it.setOnItemLongClickListener { _, view, position, _ ->
        val data =
          (items[position] as? dev.mutwakil.androidide.lsp.models.CompletionItem)?.data
            ?: return@setOnItemLongClickListener false
        val url =
          DocumentationReferenceProvider.getUrl(data) ?: return@setOnItemLongClickListener false
        Intent().apply {
          action = Intent.ACTION_VIEW
          setData(Uri.parse(url))
          addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
          view.context.startActivity(this)
        }
        true
      }
    }
  }

  override fun select(pos: Int): Boolean {
    if (pos > adapter!!.count) {
      return false
    }
    return try {
      super.select(pos)
    } catch (e: Throwable) {
      log.warn("Unable to select completion item at {}", pos, e)
      false
    }
  }

  override fun select(): Boolean {
    return try {
      super.select()
    } catch (e: Throwable) {
      log.warn("Unable to select completion item", e)
      false
    }
  }

  override fun cancelCompletion() {
    // Drop any request that was scheduled but hasn't started yet.
    pendingCompletion?.let { editor.handler.removeCallbacks(it) }
    pendingCompletion = null
    if (completionThread != null) {
      ProgressManager.instance.cancel(completionThread)
    }
    super.cancelCompletion()
  }

  /**
   * Whether a completion may be shown for the current editor state. Hides the window (matching the
   * prior inline behaviour) when the cursor is selected or completion is otherwise not applicable.
   */
  private fun canStartCompletion(): Boolean {
    if (cancelShowUp || !isEnabled || !editor.isAttachedToWindow) {
      return false
    }
    if (editor.text.cursor.isSelected || checkNoCompletion()) {
      hide()
      return false
    }
    return true
  }

  /**
   * Coalesces a keystroke burst into one completion for the latest cursor position, keeping at most one
   * analysis in flight. This prevents the CompletionThread/allocation pile-up that saturated the heap and
   * froze the editor during fast typing.
   */
  override fun requireCompletion() {
    if (!canStartCompletion()) {
      return
    }

    // cancelCompletion() clears any in-flight and pending request, so we then schedule exactly one.
    cancelCompletion()

    val request = Runnable { startCompletion() }
    pendingCompletion = request
    editor.handler.postDelayed(request, COMPLETION_DEBOUNCE_MS)
  }

  /** Runs on the UI thread. */
  private fun startCompletion() {
    pendingCompletion = null

    // Editor state may have changed during the debounce delay; re-check the guards.
    if (!canStartCompletion()) {
      return
    }

    requestTime = System.nanoTime()
    currentSelection = -1

    publisher =
      IDECompletionPublisher(
        editor.handler,
        {
          val items = publisher.items

          this.items.apply {
            clear()
            addAll(items)
          }

          if (lastAttachedItems == null || lastAttachedItems.get() != items) {
            adapter.attachValues(this, items)
            adapter.notifyDataSetInvalidated()
            lastAttachedItems = WeakReference(items)
          } else {
            adapter.notifyDataSetChanged()
          }

          val newHeight = (adapter!!.itemHeight * adapter!!.count).toFloat()
          if (newHeight == 0F) {
            hide()
          }

          editor.getComponent(EditorAutoCompletion::class.java)
            .updateCompletionWindowPosition()
          setSize(width, min(newHeight, maxHeight.toFloat()).toInt())
          if (!isShowing) {
            show()
          }

          if (adapter!!.count >= 1
            && KeyboardUtils.isHardKeyboardConnected(context)
          ) {
            currentSelection = 0
          }
        },
        editor.editorLanguage.interruptionLevel
      )

    publisher.setUpdateThreshold(1)

    completionThread = CompletionThread(requestTime, publisher)
    completionThread.name = "CompletionThread-$requestTime"

    setLoading(true)

    completionThread.start()
  }

}
