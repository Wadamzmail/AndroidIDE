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

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.mutwakil.androidide.databinding.GridItemIconBinding
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

class IconAdapter(private var icons: List<Icon>) :
        RecyclerView.Adapter<IconAdapter.IconViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val binding =
                GridItemIconBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IconViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        holder.bind(icons[position])
    }

    override fun getItemCount(): Int = icons.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateIcons(newIcons: List<Icon>) {
        this.icons = newIcons
        notifyDataSetChanged()
    }

    class IconViewHolder(private val binding: GridItemIconBinding) :
            RecyclerView.ViewHolder(binding.root) {

        private var currentBitmap: android.graphics.Bitmap? = null
        private var currentXmlContent: String? = null

        fun bind(icon: Icon) {
            IconBinder.bind(binding, icon) { bitmap, xmlContent ->
                currentBitmap = bitmap
                currentXmlContent = xmlContent
            }

            binding.root.setOnClickListener {
                IconDialogHandler.showIconOptionsDialog(
                    binding.root.context,
                    binding,
                    icon,
                    currentBitmap,
                    currentXmlContent
                )
            }
        }
    }
}