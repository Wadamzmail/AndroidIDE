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
package dev.mutwakil.androidide.lsp.xml

import androidx.annotation.RestrictTo
import dev.mutwakil.androidide.eventbus.events.editor.DocumentChangeEvent
import dev.mutwakil.androidide.lsp.api.ICompletionProvider
import dev.mutwakil.androidide.lsp.api.ILanguageClient
import dev.mutwakil.androidide.lsp.api.ILanguageServer
import dev.mutwakil.androidide.lsp.api.IServerSettings
import dev.mutwakil.androidide.lsp.models.CodeFormatResult
import dev.mutwakil.androidide.lsp.models.CompletionParams
import dev.mutwakil.androidide.lsp.models.CompletionResult
import dev.mutwakil.androidide.lsp.models.DefinitionParams
import dev.mutwakil.androidide.lsp.models.DefinitionResult
import dev.mutwakil.androidide.lsp.models.DiagnosticResult
import dev.mutwakil.androidide.lsp.models.ExpandSelectionParams
import dev.mutwakil.androidide.lsp.models.FormatCodeParams
import dev.mutwakil.androidide.lsp.models.LSPFailure
import dev.mutwakil.androidide.lsp.models.ReferenceParams
import dev.mutwakil.androidide.lsp.models.ReferenceResult
import dev.mutwakil.androidide.lsp.models.SignatureHelp
import dev.mutwakil.androidide.lsp.models.SignatureHelpParams
import dev.mutwakil.androidide.lsp.util.NoCompletionsProvider
import dev.mutwakil.androidide.lsp.xml.models.XMLServerSettings
import dev.mutwakil.androidide.lsp.xml.providers.AdvancedEditProvider.onContentChange
import dev.mutwakil.androidide.lsp.xml.providers.CodeFormatProvider
import dev.mutwakil.androidide.lsp.xml.providers.XmlCompletionProvider
import dev.mutwakil.androidide.models.Range
import dev.mutwakil.androidide.projects.api.Workspace
import dev.mutwakil.androidide.utils.DocumentUtils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.nio.file.Path

/**
 * Language server implementation for XML files.
 *
 * @author Akash Yadav
 */
class XMLLanguageServer : ILanguageServer {

  @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
  override var client: ILanguageClient? = null
    private set

  private var settings: IServerSettings? = null

  override val serverId: String = SERVER_ID

  init {
    EventBus.getDefault().register(this)
  }

  override fun shutdown() {
    if (EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().unregister(this)
    }
  }

  override fun connectClient(client: ILanguageClient?) {
    this.client = client
  }

  override fun applySettings(settings: IServerSettings?) {
    this.settings = settings
  }

  override fun setupWithProject(workspace: Workspace) {}
  override fun complete(params: CompletionParams?): CompletionResult {
    val completionProvider: ICompletionProvider = if (!getSettings().completionsEnabled()) {
      NoCompletionsProvider()
    } else {
      XmlCompletionProvider(getSettings())
    }
    return completionProvider.complete(params)
  }

  fun getSettings(): IServerSettings {
    if (settings == null) {
      settings = XMLServerSettings
    }
    return settings!!
  }

  override suspend fun findReferences(params: ReferenceParams): ReferenceResult {
    return ReferenceResult(emptyList())
  }

  override suspend fun findDefinition(params: DefinitionParams): DefinitionResult {
    return DefinitionResult(emptyList())
  }

  override suspend fun expandSelection(params: ExpandSelectionParams): Range {
    return params.selection
  }

  override suspend fun signatureHelp(params: SignatureHelpParams): SignatureHelp {
    return SignatureHelp(emptyList(), -1, -1)
  }

  override suspend fun analyze(file: Path): DiagnosticResult {
    return DiagnosticResult.NO_UPDATE
  }

  override fun formatCode(params: FormatCodeParams?): CodeFormatResult {
    return CodeFormatProvider().format(params)
  }

  @Subscribe(threadMode = ThreadMode.BACKGROUND)
  fun onDocumentChange(event: DocumentChangeEvent) {
    if (!DocumentUtils.isXmlFile(event.changedFile)) {
      return
    }
    onContentChange(event)
  }

  override fun handleFailure(failure: LSPFailure?): Boolean {
    return super<ILanguageServer>.handleFailure(failure)
  }

  companion object {

    const val SERVER_ID = "ide.lsp.xml"
  }
}