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
package dev.mutwakil.androidide.handlers

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import dev.mutwakil.androidide.handlers.system.ICMake
import dev.mutwakil.androidide.handlers.system.INdk
import dev.mutwakil.androidide.managers.PreferenceManager

/** * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null */
object ConfigHandlerRegistry {
  private val handlers = mutableListOf<IConfigHandler>()

  fun registerHandlers(
      context: Context,
      prefManager: PreferenceManager,
      lifecycleScope: LifecycleCoroutineScope,
      isDarkTheme: Boolean,
  ) {
    handlers.clear()
    // Register all handlers here
    handlers.add(INdk(context, prefManager, lifecycleScope, isDarkTheme))
    handlers.add(ICMake(context, prefManager, lifecycleScope, isDarkTheme))
    // handlers.add(IFlutter(context, prefManager, lifecycleScope, isDarkTheme))
    // handlers.add(IRust(context, prefManager, lifecycleScope, isDarkTheme))
  }

  fun getHandlers(): List<IConfigHandler> = handlers.toList()

  fun getHandlerByName(name: String): IConfigHandler? =
      handlers.firstOrNull { it.handlerName == name }
}