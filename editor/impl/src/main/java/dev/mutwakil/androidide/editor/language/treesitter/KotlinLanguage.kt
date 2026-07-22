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

package dev.mutwakil.androidide.editor.language.treesitter

import android.content.Context
import dev.mutwakil.androidide.editor.language.newline.TSBracketsHandler
import dev.mutwakil.androidide.editor.language.newline.TSCStyleBracketsHandler
import dev.mutwakil.androidide.editor.language.utils.CommonSymbolPairs
import dev.mutwakil.androidide.lsp.api.ILanguageServer
import dev.mutwakil.androidide.lsp.api.ILanguageServerRegistry
import dev.mutwakil.androidide.lsp.kotlin.KotlinLanguageServer
import com.itsaky.androidide.treesitter.kotlin.TSLanguageKotlin
import io.github.rosemoe.sora.lang.Language.INTERRUPTION_LEVEL_STRONG
import io.github.rosemoe.sora.util.MyCharacter
import io.github.rosemoe.sora.widget.SymbolPairMatch

/**
 * [TreeSitterLanguage] implementation for Kotlin.
 *
 * @author Akash Yadav
 */
open class KotlinLanguage(context: Context) :
  TreeSitterLanguage(context, TSLanguageKotlin.getInstance(), TS_TYPE_KT) {

  companion object {

    val FACTORY = Factory { KotlinLanguage(it) }
    const val TS_TYPE_KT = "kt"
    const val TS_TYPE_KTS = "kts"
  }

  override val languageServer: ILanguageServer?
    get() = ILanguageServerRegistry.getDefault().getServer(KotlinLanguageServer.SERVER_ID)

  override fun checkIsCompletionChar(c: Char): Boolean {
    return MyCharacter.isJavaIdentifierPart(c) || c == '.'
  }

  override fun getInterruptionLevel(): Int {
    return INTERRUPTION_LEVEL_STRONG
  }

  override fun getSymbolPairs(): SymbolPairMatch {
    return KotlinSymbolPairs()
  }

  override fun createNewlineHandlers(): Array<TSBracketsHandler> {
    return arrayOf(TSCStyleBracketsHandler(this))
  }

  internal open class KotlinSymbolPairs : CommonSymbolPairs() {
    init {
      super.putPair('<', SymbolPair("<", ">"))
    }
  }
}
