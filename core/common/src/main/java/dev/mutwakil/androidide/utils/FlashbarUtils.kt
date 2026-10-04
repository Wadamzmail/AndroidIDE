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

@file:Suppress("UNUSED")
package dev.mutwakil.androidide.utils

import android.app.Activity
import androidx.annotation.StringRes
import com.blankj.utilcode.util.ActivityUtils
import dev.mutwakil.androidide.flashbar.Flashbar

fun flashbarBuilder(): Flashbar.Builder? {
  return withActivity { flashbarBuilder() }
}

fun flashMessage(msg: String?, type: FlashType) {
  withActivity { flashMessage(msg, type) }
}

fun flashMessageAndGet(msg: String?, type: FlashType): Flashbar? {
  return withActivity { flashMessageAndGet(msg, type) }
}

fun flashMessage(@StringRes msg: Int, type: FlashType) {
  withActivity { flashMessage(msg, type) }
}

fun flashMessageAndGet(@StringRes msg: Int, type: FlashType): Flashbar? {
  return withActivity { flashMessageAndGet(msg, type) }
}

fun flashSuccess(msg: String?) {
  withActivity { flashSuccess(msg) }
}

fun flashSuccessAndGet(msg: String?): Flashbar? {
  return withActivity { flashSuccessAndGet(msg) }
}

fun flashSuccess(@StringRes msg: Int) {
  withActivity { flashSuccess(msg) }
}

fun flashSuccessAndGet(@StringRes msg: Int): Flashbar? {
  return withActivity { flashSuccessAndGet(msg) }
}

fun flashError(msg: String?) {
  withActivity { flashError(msg) }
}

fun flashErrorAndGet(msg: String?): Flashbar? {
  return withActivity { flashErrorAndGet(msg) }
}

fun flashError(@StringRes msg: Int) {
  withActivity { flashError(msg) }
}

fun flashErrorAndGet(@StringRes msg: Int): Flashbar? {
  return withActivity { flashErrorAndGet(msg) }
}

fun flashInfo(msg: String?) {
  withActivity { flashInfo(msg) }
}

fun flashInfoAndGet(msg: String?): Flashbar? {
  return withActivity { flashInfoAndGet(msg) }
}

fun flashInfo(@StringRes msg: Int) {
  withActivity { flashInfo(msg) }
}

fun flashInfoAndGet(@StringRes msg: Int): Flashbar? {
  return withActivity { flashInfoAndGet(msg) }
}

@JvmOverloads
fun <R> flashProgress(
  configure: (Flashbar.Builder.() -> Unit)? = null,
  action: (Flashbar) -> R?
) : R? {
  return withActivity { flashProgress(configure, action) }
}

private fun <T> withActivity(action: Activity.() -> T?): T? {
  return ActivityUtils.getTopActivity()?.let { it.action() }
    ?: run {
      ILogger.ROOT.warn("Cannot show flashbar message. Cannot get top activity.")
      null
    }
}

/** The type of flashbar message. */
enum class FlashType {

  ERROR,
  INFO,
  SUCCESS
}