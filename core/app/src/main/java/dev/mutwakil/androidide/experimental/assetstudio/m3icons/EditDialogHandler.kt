/*
 *  This file is part of AndroidCodeStudio.
 *
 *  AndroidCodeStudio is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidCodeStudio is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidCodeStudio.  If not, see <https://www.gnu.org/licenses/>.
*/

package dev.mutwakil.androidide.experimental.assetstudio.m3icons

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.mutwakil.androidide.databinding.DialogIconEditBinding
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object EditDialogHandler {
    fun showEditDialog(
        context: Context,
        icon: Icon,
        originalBitmap: Bitmap?,
        xmlContent: String?
    ) {
        if (originalBitmap == null || xmlContent == null) return

        val dialogBinding = DialogIconEditBinding.inflate(LayoutInflater.from(context))
        val dialog = MaterialAlertDialogBuilder(context)
            .setView(dialogBinding.root)
            .create()

        dialogBinding.fileNameInput.setText(icon.name)

        val defaultColor = ColorUtils.extractColorFromXml(xmlContent)
        var currentColor = defaultColor
        var currentDynamicColor: String? = "?attr/colorControlNormal"

        dialogBinding.colorPreview.setBackgroundColor(currentColor)
        dialogBinding.colorHexText.text = "?attr/colorControlNormal"

        val modifiedXml = ColorUtils.modifyXmlColor(xmlContent, null, currentDynamicColor)
        val previewBitmap = VectorRenderer.createBitmapFromXml(modifiedXml, 120, null, context)
        dialogBinding.iconPreview.setImageBitmap(previewBitmap)

        dialogBinding.colorPickerButton.setOnClickListener {
            ColorPickerDialog.show(context, currentColor, currentDynamicColor) { newColor, dynamicColor ->
                currentColor = newColor
                currentDynamicColor = dynamicColor
                dialogBinding.colorPreview.setBackgroundColor(newColor)

                if (dynamicColor != null) {
                    dialogBinding.colorHexText.text = dynamicColor
                    val modifiedXml = ColorUtils.modifyXmlColor(xmlContent, null, dynamicColor)
                    val updatedBitmap = VectorRenderer.createBitmapFromXml(modifiedXml, 120, null, context)
                    dialogBinding.iconPreview.setImageBitmap(updatedBitmap)
                } else {
                    dialogBinding.colorHexText.text = String.format("#%08X", newColor)
                    val modifiedXml = ColorUtils.modifyXmlColor(xmlContent, newColor, null)
                    val updatedBitmap = VectorRenderer.createBitmapFromXml(modifiedXml, 120, null, context)
                    dialogBinding.iconPreview.setImageBitmap(updatedBitmap)
                }
            }
        }

        dialogBinding.saveButton.setOnClickListener {
            val fileName = dialogBinding.fileNameInput.text.toString().ifEmpty { icon.name }
            val modifiedXml = ColorUtils.modifyXmlColor(xmlContent, if (currentDynamicColor == null) currentColor else null, currentDynamicColor)
            val finalBitmap = VectorRenderer.createBitmapFromXml(modifiedXml, 512, null, context)

            if (finalBitmap != null) {
                dialog.dismiss()
                CopyDialogHandler.showCopyToDialogAfterEdit(
                    context,
                    fileName,
                    finalBitmap,
                    xmlContent,
                    currentColor,
                    currentDynamicColor
                )
            }
        }

        dialogBinding.cancelButton.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }
}