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

package dev.mutwakil.androidide.preferences

import dev.mutwakil.androidide.R
import dev.mutwakil.androidide.preferences.internal.KotlinPreferences
import dev.mutwakil.androidide.resources.R.drawable
import dev.mutwakil.androidide.resources.R.string
import kotlinx.parcelize.Parcelize

@Parcelize
internal class KotlinCodeConfigurations(
    override val key: String = "idepref_editor_kotlin",
    override val title: Int = string.idepref_editor_category_kotlin,
    override val children: List<IPreference> = mutableListOf(),
) : IPreferenceGroup() {

    init {
        addPreference(KotlinLspEnabled())
    }
}

/** @author Mutwakil Suliman (Wadamzmail) */

@Parcelize
private class KotlinLspEnabled(
    override val key: String = KotlinPreferences.KOTLIN_LSP_ENABLED,
    override val title: Int = R.string.idepref_kotlin_lspEnabled_title,
    override val summary: Int? = R.string.idepref_kotlin_lspEnabled_summary,
    override val icon: Int? = drawable.ic_language_kotlin
) :
    SwitchPreference(
        getValue = KotlinPreferences::isKotlinLspEnabled::get,
        setValue = KotlinPreferences::isKotlinLspEnabled::set
    )
