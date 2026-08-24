package dev.mutwakil.androidide.layouteditor.editor.callers.text

import android.content.Context
import android.view.View
import com.google.android.material.textfield.TextInputLayout
import dev.mutwakil.androidide.layouteditor.managers.ProjectManager
import dev.mutwakil.androidide.layouteditor.managers.ValuesManager
import dev.mutwakil.androidide.layouteditor.tools.ValuesResourceParser

object TextInputLayoutCaller {

    @JvmStatic
    fun setHint(target: View, value: String, context: Context) {
        var finalValue = value
        if (finalValue.startsWith("@string/")) {
            val project = ProjectManager.instance.openedProject ?: return
            finalValue = ValuesManager.getValueFromResources(
                ValuesResourceParser.TAG_STRING, finalValue, project.stringsPath
            )
        }
        (target as TextInputLayout).hint = finalValue
    }

    @JvmStatic
    fun setHintEnabled(target: View, value: String, context: Context) {
        (target as TextInputLayout).isHintEnabled = value.toBoolean()
    }

    @JvmStatic
    fun setErrorEnabled(target: View, value: String, context: Context) {
        (target as TextInputLayout).isErrorEnabled = value.toBoolean()
    }

    @JvmStatic
    fun setCounterEnabled(target: View, value: String, context: Context) {
        (target as TextInputLayout).isCounterEnabled = value.toBoolean()
    }
}
