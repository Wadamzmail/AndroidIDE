package dev.mutwakil.androidide.lsp.kotlin.completion

import dev.mutwakil.androidide.lsp.edits.IEditHandler
import dev.mutwakil.androidide.lsp.models.Command
import dev.mutwakil.androidide.lsp.models.CompletionItem
import dev.mutwakil.androidide.lsp.models.CompletionItemKind
import dev.mutwakil.androidide.lsp.models.ICompletionData
import dev.mutwakil.androidide.lsp.models.InsertTextFormat
import dev.mutwakil.androidide.lsp.models.MatchLevel
import dev.mutwakil.androidide.lsp.models.TextEdit

class KotlinCompletionItem(
	ideLabel: String,
	detail: String,
	insertText: String?,
	insertTextFormat: InsertTextFormat?,
	sortText: String?,
	command: Command?,
	completionKind: CompletionItemKind,
	matchLevel: MatchLevel,
	additionalTextEdits: List<TextEdit>?,
	data: ICompletionData?,
	editHandler: IEditHandler = BaseKotlinEditHandler()
) : CompletionItem(
	ideLabel,
	detail,
	insertText,
	insertTextFormat,
	sortText,
	command,
	completionKind,
	matchLevel,
	additionalTextEdits,
	data,
	editHandler
) {

	constructor() : this(
		"", // label
		"", // detail
		null, // insertText
		null, // insertTextFormat
		null, // sortText
		null, // command
		CompletionItemKind.NONE, // kind
		MatchLevel.NO_MATCH, // match level
		ArrayList(), // additionalEdits
		null // data
	)
}