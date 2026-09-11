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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.mutwakil.androidide.databinding.GridItemIconBinding
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object IconDialogHandler {
    fun showIconOptionsDialog(
        context: Context,
        binding: GridItemIconBinding,
        icon: Icon,
        bitmap: Bitmap?,
        xmlContent: String?
    ) {
        val options = arrayOf("Copy to", "Edit and Copy")
        MaterialAlertDialogBuilder(context)
            .setTitle(icon.name)
            .setItems(options) { dialog, which ->
                when (which) {
                    0 -> CopyDialogHandler.showCopyToDialogWithRename(
                        context,
                        icon,
                        bitmap,
                        xmlContent
                    )
                    1 -> EditDialogHandler.showEditDialog(
                        context,
                        icon,
                        bitmap,
                        xmlContent
                    )
                }
                dialog.dismiss()
            }
            .show()
    }
}