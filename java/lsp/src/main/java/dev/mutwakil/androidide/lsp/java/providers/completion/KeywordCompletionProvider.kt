/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty
 *  of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.mutwakil.androidide.lsp.java.providers.completion

import dev.mutwakil.androidide.lsp.api.IServerSettings
import dev.mutwakil.androidide.lsp.java.compiler.CompileTask
import dev.mutwakil.androidide.lsp.java.compiler.JavaCompilerService
import dev.mutwakil.androidide.lsp.models.CompletionItem
import dev.mutwakil.androidide.lsp.models.CompletionResult
import dev.mutwakil.androidide.lsp.models.MatchLevel.NO_MATCH
import openjdk.source.util.TreePath
import java.nio.file.Path

/**
 * Provides keyword completions.
 *
 * @author Akash Yadav
 */
class KeywordCompletionProvider(
  completingFile: Path,
  cursor: Long,
  compiler: JavaCompilerService,
  settings: IServerSettings
) : IJavaCompletionProvider(cursor, completingFile, compiler, settings) {

  private var source: String = ""

  fun setSource(source: String) {
    this.source = source
  }

  override fun doComplete(
    task: CompileTask,
    path: TreePath,
    partial: String,
    endsWithParen: Boolean,
  ): CompletionResult {

    if (partial.isBlank()) {
      return CompletionResult.EMPTY
    }

    val context = KeywordCompletionContextResolver.resolve(
      task = task,
      path = path,
      source = source,
      cursor = cursor,
    )

    log.info(
      "Keyword completion context: {} at {}",
      context,
      cursor,
    )

    val keywords = KeywordCompletionContextResolver.run { context.keywords() }

    abortCompletionIfCancelled()

    val list = mutableListOf<CompletionItem>()

    for (keyword in keywords) {
      val matchLevel = matchLevel(keyword, partial)
      if (matchLevel == NO_MATCH) {
        continue
      }

      list.add(keyword(keyword, partial, 100))
    }

    return CompletionResult(list)
  }
}