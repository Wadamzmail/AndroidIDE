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
import java.io.File
import java.io.FileOutputStream
import dev.mutwakil.androidide.projects.ProjectManagerImpl
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object IconCopier {
    fun copyIconToDestination(
        context: Context,
        fileName: String,
        bitmap: Bitmap,
        destination: String,
        xmlContent: String,
        color: Int? = null,
        dynamicColor: String? = null
    ) {
        try {
            val projectDir = ProjectManagerImpl.getInstance().projectDirPath
            if (projectDir.isEmpty()) {
                android.widget.Toast.makeText(
                    context,
                    "No project opened",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
                return
            }

            val resDir = File(projectDir, "app/src/main/res")
            val drawableDir = File(resDir, "drawable")
            drawableDir.mkdirs()

            val modifiedXml = ColorUtils.modifyXmlColor(xmlContent, color, dynamicColor)
            val xmlFile = File(drawableDir, "$fileName.xml")
            xmlFile.writeText(modifiedXml)

            android.widget.Toast.makeText(
                context,
                "Copied to res/drawable/$fileName.xml",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            android.widget.Toast.makeText(
                context,
                "Error copying icon: ${e.message}",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }
}