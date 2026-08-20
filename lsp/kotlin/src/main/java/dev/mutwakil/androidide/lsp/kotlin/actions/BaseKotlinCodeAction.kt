package dev.mutwakil.androidide.lsp.kotlin.actions

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.StringRes
import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.ActionItem
import dev.mutwakil.androidide.actions.EditorActionItem
import dev.mutwakil.androidide.actions.get
import dev.mutwakil.androidide.actions.hasRequiredData
import dev.mutwakil.androidide.actions.markInvisible
import dev.mutwakil.androidide.actions.requireContext
import dev.mutwakil.androidide.actions.requireFile
import dev.mutwakil.androidide.lsp.api.ILanguageClient
import dev.mutwakil.androidide.lsp.kotlin.KotlinLanguageServer
import dev.mutwakil.androidide.lsp.kotlin.diagnostic.DiagnosticAction
import dev.mutwakil.androidide.lsp.kotlin.diagnostic.KotlinDiagnosticExtra
import dev.mutwakil.androidide.lsp.kotlin.diagnostic.asAction
import dev.mutwakil.androidide.lsp.models.DiagnosticItem
import dev.mutwakil.androidide.lsp.models.DiagnosticsInSelection
import dev.mutwakil.androidide.utils.DocumentUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

abstract class BaseKotlinCodeAction : EditorActionItem {
	override var visible: Boolean = true
	override var enabled: Boolean = true
	override var icon: Drawable? = null
	override var requiresUIThread: Boolean = false
	override var location: ActionItem.Location = ActionItem.Location.EDITOR_CODE_ACTIONS

	@get:StringRes
	protected abstract var titleTextRes: Int

	protected val logger: Logger = LoggerFactory.getLogger(javaClass)

	override fun prepare(data: ActionData) {
		super.prepare(data)
		if (!data.hasRequiredData(
				Context::class.java,
				KotlinLanguageServer::class.java,
				File::class.java,
			)
		) {
			markInvisible()
			return
		}

		val context = data.requireContext()
		val file = data.requireFile()
		val isKtFile = DocumentUtils.isKotlinFile(file.toPath())

		if (titleTextRes != -1) {
			label = context.getString(titleTextRes)
		}

		visible = isKtFile
		enabled = isKtFile
	}

	protected val ActionData.languageClient: ILanguageClient?
		get() =
			get<KotlinLanguageServer>()
				?.client

	internal inline fun <reified T : DiagnosticAction> DiagnosticItem.ktExtra(): KotlinDiagnosticExtra<T>? =
		(extra as? KotlinDiagnosticExtra<*>)?.asAction<T>()

	/**
	 * Find the first [DiagnosticItem] in the current selection matching the given [predicate].
	 * Prefers [DiagnosticsInSelection] (any matching diagnostic in the selected area); falls back
	 * to the at-selection-start [DiagnosticItem] when no container is present.
	 */
	protected inline fun ActionData.findFirstDiagnosticItem(predicate: (DiagnosticItem) -> Boolean): DiagnosticItem? =
		get<DiagnosticsInSelection>()
			?.let { return it.diagnostics.firstOrNull(predicate) }
			?: get<DiagnosticItem>()?.takeIf(predicate)

	/**
	 * Find the first in-selection [DiagnosticItem] whose extra carries a [T] action, paired with the
	 * typed [KotlinDiagnosticExtra]. Carries the type evidence through so callers don't re-extract.
	 */
	internal inline fun <reified T : DiagnosticAction> ActionData.findDiagnosticExtra(): Pair<DiagnosticItem, KotlinDiagnosticExtra<T>>? {
		val item = findFirstDiagnosticItem { it.ktExtra<T>() != null } ?: return null
		return item to item.ktExtra<T>()!!
	}
}
