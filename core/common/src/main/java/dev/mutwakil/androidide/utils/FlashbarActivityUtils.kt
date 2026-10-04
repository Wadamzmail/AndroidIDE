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
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuff.Mode.SRC_ATOP
import android.os.Looper
import android.widget.ImageView.ScaleType
import android.widget.ImageView.ScaleType.FIT_CENTER
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.FloatRange
import androidx.annotation.StringRes
import com.blankj.utilcode.util.ThreadUtils
import dev.mutwakil.androidide.flashbar.Flashbar
import dev.mutwakil.androidide.flashbar.Flashbar.Gravity.TOP
import dev.mutwakil.androidide.resources.R
import dev.mutwakil.androidide.utils.FlashType.ERROR
import dev.mutwakil.androidide.utils.FlashType.INFO
import dev.mutwakil.androidide.utils.FlashType.SUCCESS
import androidx.core.graphics.toColorInt

const val DURATION_SHORT = 2000L
const val DURATION_LONG = 3500L
const val DURATION_INDEFINITE = Flashbar.DURATION_INDEFINITE

val COLOR_SUCCESS = "#4CAF50".toColorInt()
val COLOR_ERROR = "#f44336".toColorInt()
const val COLOR_INFO = Color.DKGRAY

@JvmOverloads
fun Activity.flashbarBuilder(
    gravity: Flashbar.Gravity = TOP,
    duration: Long = DURATION_SHORT,
    backgroundColor: Int = resolveAttr(R.attr.colorPrimaryContainer),
    messageColor: Int = resolveAttr(R.attr.colorOnPrimaryContainer)
): Flashbar.Builder {
    return Flashbar.Builder(this)
        .gravity(gravity)
        .duration(duration)
        .backgroundColor(backgroundColor)
        .messageColor(messageColor)
}

fun Activity.flashMessage(msg: String?, type: FlashType) {
    msg ?: return
    when (type) {
        ERROR -> flashError(msg)
        INFO -> flashInfo(msg)
        SUCCESS -> flashSuccess(msg)
    }
}

fun Activity.flashMessageAndGet(msg: String?, type: FlashType): Flashbar? {
    msg ?: return null
   return when (type) {
        ERROR -> flashErrorAndGet(msg)
        INFO -> flashInfoAndGet(msg)
        SUCCESS -> flashSuccessAndGet(msg)
    }
}

fun Activity.flashMessage(@StringRes msg: Int, type: FlashType) {
    when (type) {
        ERROR -> flashError(msg)
        INFO -> flashInfo(msg)
        SUCCESS -> flashSuccess(msg)
    }
}

fun Activity.flashMessageAndGet(@StringRes msg: Int, type: FlashType): Flashbar? {
    return when (type) {
        ERROR -> flashErrorAndGet(msg)
        INFO -> flashInfoAndGet(msg)
        SUCCESS -> flashSuccessAndGet(msg)
    }
}

fun Activity.flashSuccess(msg: String?) {
    msg ?: return
    flashbarBuilder().successIcon().message(msg).showOnUiThread()
}

fun Activity.flashSuccessAndGet(msg: String?): Flashbar? {
    msg ?: return null
    return flashbarBuilder().successIcon().message(msg).showOnUiThreadAndGet()
}

fun Activity.flashError(msg: String?) {
    msg ?: return
    flashbarBuilder().errorIcon().message(msg).showOnUiThread()
}

fun Activity.flashErrorAndGet(msg: String?): Flashbar? {
    msg ?: return null
    return flashbarBuilder().errorIcon().message(msg).showOnUiThreadAndGet()
}

fun Activity.flashInfo(msg: String?) {
    msg ?: return
    flashbarBuilder().infoIcon().message(msg).showOnUiThread()
}

fun Activity.flashInfoAndGet(msg: String?): Flashbar? {
    msg ?: return null
    return flashbarBuilder().infoIcon().message(msg).showOnUiThreadAndGet()
}

fun Activity.flashSuccess(@StringRes msg: Int) {
    flashbarBuilder().successIcon().message(msg).showOnUiThread()
}

fun Activity.flashSuccessAndGet(@StringRes msg: Int): Flashbar {
    return flashbarBuilder().successIcon().message(msg).showOnUiThreadAndGet()
}

fun Activity.flashError(@StringRes msg: Int) {
    flashbarBuilder().errorIcon().message(msg).showOnUiThread()
}

fun Activity.flashErrorAndGet(@StringRes msg: Int): Flashbar {
    return flashbarBuilder().errorIcon().message(msg).showOnUiThreadAndGet()
}

fun Activity.flashInfo(@StringRes msg: Int) {
    flashbarBuilder().infoIcon().message(msg).showOnUiThread()
}

fun Activity.flashInfoAndGet(@StringRes msg: Int): Flashbar {
    return flashbarBuilder().infoIcon().message(msg).showOnUiThreadAndGet()
}

@JvmOverloads
fun <R : Any?> Activity.flashProgress(
    configure: (Flashbar.Builder.() -> Unit)? = null,
    action: (Flashbar) -> R
): R {
    val builder = flashbarBuilder(gravity = TOP, duration = DURATION_INDEFINITE)
        .showProgress(Flashbar.ProgressPosition.LEFT)

    configure?.invoke(builder)

    val flashbar = builder.build()
    flashbar.show()

    return action(flashbar)
}

fun Flashbar.Builder.showOnUiThread() {
    build().showOnUiThread()
}

fun Flashbar.Builder.showOnUiThreadAndGet(): Flashbar {
    val flashbar = build()
    flashbar.showOnUiThread()
    return flashbar
}

fun Flashbar.showOnUiThread() {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        show()
    } else {
        ThreadUtils.runOnUiThread { show() }
    }
}

fun Flashbar.Builder.successIcon(): Flashbar.Builder {
    return withIcon(R.drawable.ic_ok, colorFilter = COLOR_SUCCESS)
}

fun Flashbar.Builder.errorIcon(): Flashbar.Builder {
    return withIcon(R.drawable.ic_error, colorFilter = COLOR_ERROR)
}

fun Flashbar.Builder.infoIcon(): Flashbar.Builder {
    return withIcon(R.drawable.ic_info, colorFilter = COLOR_INFO)
}

fun Flashbar.Builder.withIcon(
    @DrawableRes icon: Int,
    @FloatRange(from = 0.0, to = 1.0) scale: Float = 1.0f,
    @ColorInt colorFilter: Int = -1,
    colorFilterMode: PorterDuff.Mode = SRC_ATOP,
    scaleType: ScaleType = FIT_CENTER
): Flashbar.Builder {
    return showIcon(scale = scale, scaleType = scaleType).icon(icon).also {
        if (colorFilter != -1) {
            iconColorFilter(colorFilter, colorFilterMode)
        }
    }
}