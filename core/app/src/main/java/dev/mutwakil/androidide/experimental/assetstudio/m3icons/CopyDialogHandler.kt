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
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.radiobutton.MaterialRadioButton
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object CopyDialogHandler {
    fun showCopyToDialogWithRename(
        context: Context,
        icon: Icon,
        bitmap: Bitmap?,
        xmlContent: String?
    ) {
        if (bitmap == null || xmlContent == null) return

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_copy_to, null)

        val fileNameInput = dialogView.findViewById<TextInputEditText>(R.id.fileNameInput)
        val radioDrawable = dialogView.findViewById<MaterialRadioButton>(R.id.radioDrawable)
        val radioMipmap = dialogView.findViewById<MaterialRadioButton>(R.id.radioMipmap)

        fileNameInput.setText(icon.name.replace(" ", "_"))
        radioDrawable.isChecked = true

        MaterialAlertDialogBuilder(context)
            .setTitle("Copy to")
            .setView(dialogView)
            .setPositiveButton("Copy") { dialog, _ ->
                val fileName = fileNameInput.text.toString().ifEmpty { icon.name }
                val destination = if (radioDrawable.isChecked) "drawable" else "mipmap"
                IconCopier.copyIconToDestination(context, fileName, bitmap, destination, xmlContent)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    fun showCopyToDialogAfterEdit(
        context: Context,
        fileName: String,
        bitmap: Bitmap,
        xmlContent: String,
        color: Int,
        dynamicColor: String?
    ) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_copy_to, null)

        val fileNameInput = dialogView.findViewById<TextInputEditText>(R.id.fileNameInput)
        val radioDrawable = dialogView.findViewById<MaterialRadioButton>(R.id.radioDrawable)
        val radioMipmap = dialogView.findViewById<MaterialRadioButton>(R.id.radioMipmap)

        fileNameInput.setText(fileName.replace(" ", "_"))
        radioDrawable.isChecked = true

        MaterialAlertDialogBuilder(context)
            .setTitle("Copy to")
            .setView(dialogView)
            .setPositiveButton("Copy") { dialog, _ ->
                val finalFileName = fileNameInput.text.toString().ifEmpty { fileName }
                val destination = if (radioDrawable.isChecked) "drawable" else "mipmap"
                IconCopier.copyIconToDestination(
                    context,
                    finalFileName.replace(" ", "_"),
                    bitmap,
                    destination,
                    xmlContent,
                    color,
                    dynamicColor
                )
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}