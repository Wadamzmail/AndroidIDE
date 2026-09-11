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

import android.content.Intent
import dev.mutwakil.androidide.activities.IDEConfigurations
import dev.mutwakil.androidide.resources.R

private const val KEY_IDECONFIGURATIONS = "idepref_ideConfigurations"

val ideConfigurations =
  SimpleClickablePreference(
    key = KEY_IDECONFIGURATIONS,
    title = R.string.pref_ide_configurations,
    summary = R.string.idepref_ide_configurations_summary
  ) {
    it.context.startActivity(Intent(it.context, IDEConfigurations::class.java)) 
    true
  }