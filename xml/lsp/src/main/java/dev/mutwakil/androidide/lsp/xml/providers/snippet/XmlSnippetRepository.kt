package dev.mutwakil.androidide.lsp.xml.providers.snippet

import dev.mutwakil.androidide.lsp.snippets.ISnippet
import dev.mutwakil.androidide.lsp.snippets.SnippetRegistry

object XmlSnippetRepository {

    val snippets: Map<IXmlSnippetScope, List<ISnippet>>
        get() = XML_SNIPPET_SCOPES.associateWith { scope ->
            SnippetRegistry.getSnippets("xml",scope.filename)
        }

    fun init() {
        SnippetRegistry.initBuiltIn("xml", XML_SNIPPET_SCOPES)
    }
}
