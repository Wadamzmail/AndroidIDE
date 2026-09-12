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

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.util.TypedValue
import dev.mutwakil.androidide.databinding.GridItemIconBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.zip.ZipInputStream
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object IconBinder {
    fun bind(
        binding: GridItemIconBinding,
        icon: Icon,
        onLoaded: (Bitmap?, String?) -> Unit
    ) {
        binding.iconNameTextView.text = icon.name
        binding.iconImageView.setImageResource(R.drawable.ic_placeholder_24)

        val typedValue = TypedValue()
        binding.root.context.theme.resolveAttribute(
            com.google.android.material.R.attr.colorOnBackground,
            typedValue,
            true
        )
        val iconColor = typedValue.data
        binding.iconImageView.imageTintList = ColorStateList.valueOf(iconColor)

        CoroutineScope(Dispatchers.Main).launch {
            val result = withContext(Dispatchers.IO) {
                try {
                    val context = binding.root.context
                    val zipInputStream = ZipInputStream(context.assets.open("icons.zip"))
                    var xmlContent: String? = null

                    var entry = zipInputStream.nextEntry
                    while (entry != null) {
                        if (entry.name == icon.url) {
                            xmlContent = zipInputStream.bufferedReader().use { it.readText() }
                            break
                        }
                        zipInputStream.closeEntry()
                        entry = zipInputStream.nextEntry
                    }
                    zipInputStream.close()

                    if (xmlContent != null) {
                        val bitmap = VectorRenderer.createBitmapFromXml(xmlContent, 96, context = context)
                        Pair(bitmap, xmlContent)
                    } else {
                        Pair(null, null)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Pair(null, null)
                }
            }

            onLoaded(result.first, result.second)

            if (result.first != null) {
                binding.iconImageView.setImageBitmap(result.first)
            } else {
                binding.iconImageView.setImageResource(R.drawable.ic_error)
            }
        }
    }
}