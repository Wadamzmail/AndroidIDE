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

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object DynamicColorHelper {
    fun getDynamicColors(): List<Pair<String, Int?>> {
        return listOf(
            "?attr/colorControlNormal" to android.R.attr.colorControlNormal,
            "Custom" to null,
            "?attr/colorPrimary" to android.R.attr.colorPrimary,
            "?attr/colorOnPrimary" to com.google.android.material.R.attr.colorOnPrimary,
            "?attr/colorPrimaryContainer" to com.google.android.material.R.attr.colorPrimaryContainer,
            "?attr/colorOnPrimaryContainer" to com.google.android.material.R.attr.colorOnPrimaryContainer,
            "?attr/colorSecondary" to com.google.android.material.R.attr.colorSecondary,
            "?attr/colorOnSecondary" to com.google.android.material.R.attr.colorOnSecondary,
            "?attr/colorSecondaryContainer" to com.google.android.material.R.attr.colorSecondaryContainer,
            "?attr/colorOnSecondaryContainer" to com.google.android.material.R.attr.colorOnSecondaryContainer,
            "?attr/colorTertiary" to com.google.android.material.R.attr.colorTertiary,
            "?attr/colorOnTertiary" to com.google.android.material.R.attr.colorOnTertiary,
            "?attr/colorTertiaryContainer" to com.google.android.material.R.attr.colorTertiaryContainer,
            "?attr/colorOnTertiaryContainer" to com.google.android.material.R.attr.colorOnTertiaryContainer,
            "?attr/colorError" to android.R.attr.colorError,
            "?attr/colorOnError" to com.google.android.material.R.attr.colorOnError,
            "?attr/colorErrorContainer" to com.google.android.material.R.attr.colorErrorContainer,
            "?attr/colorOnErrorContainer" to com.google.android.material.R.attr.colorOnErrorContainer,
            "?attr/colorSurface" to com.google.android.material.R.attr.colorSurface,
            "?attr/colorOnSurface" to com.google.android.material.R.attr.colorOnSurface,
            "?attr/colorSurfaceVariant" to com.google.android.material.R.attr.colorSurfaceVariant,
            "?attr/colorOnSurfaceVariant" to com.google.android.material.R.attr.colorOnSurfaceVariant,
            "?attr/colorOutline" to com.google.android.material.R.attr.colorOutline,
            "?attr/colorOutlineVariant" to com.google.android.material.R.attr.colorOutlineVariant
        )
    }
}