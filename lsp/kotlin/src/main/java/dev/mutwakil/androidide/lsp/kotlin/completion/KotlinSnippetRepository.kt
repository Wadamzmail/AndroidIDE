package dev.mutwakil.androidide.lsp.kotlin.completion

import dev.mutwakil.androidide.lsp.snippets.ISnippet
import dev.mutwakil.androidide.lsp.snippets.SnippetParser
import dev.mutwakil.androidide.lsp.snippets.SnippetRegistry

object KotlinSnippetRepository {
	val snippets: Map<KotlinSnippetScope, List<ISnippet>>
		get() = KotlinSnippetScope.entries.associateWith { scope ->
			SnippetRegistry.getSnippets("kt", scope.filename)
		}

	fun init() {
		SnippetRegistry.initBuiltIn("kt", KotlinSnippetScope.entries)
	}
}