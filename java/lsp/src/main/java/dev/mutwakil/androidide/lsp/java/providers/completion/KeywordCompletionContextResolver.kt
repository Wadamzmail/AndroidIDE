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

package dev.mutwakil.androidide.lsp.java.providers.completion

import dev.mutwakil.androidide.lsp.java.compiler.CompileTask
import openjdk.source.tree.ClassTree
import openjdk.source.tree.CompilationUnitTree
import openjdk.source.tree.MethodTree
import openjdk.source.util.TreePath

/**
 * Resolves the Java grammar context used by keyword completion.
 *
 * The Java parser is intentionally permissive while source is incomplete, so
 * there are many cursor positions for which the AST has no useful node. This
 * resolver uses the source around the cursor as the primary signal and the
 * compiler TreePath as a final fallback.
 *
 * The resolver is deliberately conservative: when a keyword cannot be shown
 * with reasonable confidence, the context returns an empty candidate list and
 * lets the normal identifier/type/member providers do their job.
 */
internal object KeywordCompletionContextResolver {

  /**
   * A context carries both a readable name and the exact keyword candidates.
   * Keeping candidates on the context lets declaration headers remove already
   * used clauses such as a second `implements` or an illegal `extends`.
   */
  data class Context(
    val name: String,
    val candidateKeywords: Array<String>,
  ) {

    override fun toString(): String = name
  }

  @Suppress("UNUSED_PARAMETER")
  fun resolve(
    task: CompileTask,
    path: TreePath,
    source: String,
    cursor: Long,
  ): Context {
    val end = cursor.toInt().coerceIn(0, source.length)
    val prefix = source.substring(0, end)
    val cleanPrefix = stripCommentsAndLiterals(prefix)
    val tokens = tokenize(cleanPrefix)

    if (tokens.isNotEmpty()) {
      resolveLexically(cleanPrefix, tokens)?.let { return it }
    }

    return resolveFromTreePath(path)
      ?: context("TOP_LEVEL", TOP_LEVEL_KEYWORDS)
  }

  fun Context.keywords(): Array<String> = candidateKeywords

  private fun resolveLexically(
    source: String,
    tokens: List<Token>,
  ): Context? {
    val braces = mutableListOf<BraceFrame>()
    val parens = mutableListOf<Int>()
    val brackets = mutableListOf<Int>()

    for (index in tokens.indices) {
      when (tokens[index].text) {
        "(" -> parens.add(index)
        ")" -> if (parens.isNotEmpty()) {
          parens.removeAt(parens.lastIndex)
        }

        "[" -> brackets.add(index)
        "]" -> if (brackets.isNotEmpty()) {
          brackets.removeAt(brackets.lastIndex)
        }

        "{" -> braces.add(
          BraceFrame(
            kind = classifyBrace(
              tokens = tokens,
              braceIndex = index,
              outer = braces.lastOrNull(),
            ),
            tokenIndex = index,
          ),
        )

        "}" -> if (braces.isNotEmpty()) {
          braces.removeAt(braces.lastIndex)
        }
      }
    }

    val currentBrace = braces.lastOrNull()

    if (currentBrace != null) {
      return when (currentBrace.kind) {
        BraceKind.MODULE_BODY -> resolveModuleBody(
          tokens,
          currentBrace.tokenIndex,
        )

        BraceKind.SWITCH_BODY -> resolveSwitchBody(
          source,
          tokens,
          currentBrace.tokenIndex,
        )

        BraceKind.CLASS_BODY -> resolveClassBody(
          tokens,
          currentBrace.tokenIndex,
        )

        BraceKind.EXPRESSION -> context(
          "EXPRESSION",
          EXPRESSION_KEYWORDS,
        )

        BraceKind.METHOD_BODY,
        BraceKind.INITIALIZER,
        BraceKind.BLOCK,
        BraceKind.LAMBDA_BODY,
        -> resolveCodeBlock(
          tokens = tokens,
          parens = parens,
          brackets = brackets,
          currentBrace = currentBrace,
        )
      }
    }

    resolveModuleHeader(tokens)?.let { return it }
    resolveDeclarationHeader(tokens)?.let { return it }
    resolveTopLevel(tokens)?.let { return it }

    return null
  }

  private fun classifyBrace(
    tokens: List<Token>,
    braceIndex: Int,
    outer: BraceFrame?,
  ): BraceKind {
    val start = findHeaderStart(tokens, braceIndex)
    val header = tokens.subList(start, braceIndex)

    if (header.isEmpty()) {
      return when (outer?.kind) {
        BraceKind.CLASS_BODY -> BraceKind.INITIALIZER

        BraceKind.MODULE_BODY,
        BraceKind.SWITCH_BODY,
        BraceKind.METHOD_BODY,
        BraceKind.INITIALIZER,
        BraceKind.BLOCK,
        BraceKind.LAMBDA_BODY,
        BraceKind.EXPRESSION,
        -> BraceKind.BLOCK

        null -> BraceKind.BLOCK
      }
    }

    if (isModuleHeader(header)) {
      return BraceKind.MODULE_BODY
    }

    if (containsTypeDeclarationKeyword(header)) {
      return BraceKind.CLASS_BODY
    }

    if (endsWithArrow(header)) {
      return BraceKind.LAMBDA_BODY
    }

    if (isAnonymousClassHeader(header)) {
      return BraceKind.CLASS_BODY
    }

    if (containsSwitchNearHeaderEnd(header)) {
      return BraceKind.SWITCH_BODY
    }

    if (isControlBlockHeader(header)) {
      return BraceKind.BLOCK
    }

    if (isMethodBodyHeader(header)) {
      return BraceKind.METHOD_BODY
    }

    if (isExpressionBrace(header)) {
      return BraceKind.EXPRESSION
    }

    return when (outer?.kind) {
      BraceKind.CLASS_BODY -> BraceKind.INITIALIZER

      BraceKind.MODULE_BODY,
      BraceKind.SWITCH_BODY,
      BraceKind.METHOD_BODY,
      BraceKind.INITIALIZER,
      BraceKind.BLOCK,
      BraceKind.LAMBDA_BODY,
      BraceKind.EXPRESSION,
      -> BraceKind.BLOCK

      null -> BraceKind.BLOCK
    }
  }

  private fun resolveClassBody(
    tokens: List<Token>,
    classBraceIndex: Int,
  ): Context {
    val segment = currentSegment(
      tokens = tokens,
      startIndex = classBraceIndex + 1,
    )

    if (segment.isEmpty()) {
      return context("CLASS_BODY", CLASS_BODY_KEYWORDS)
    }

    if (isAnnotationContext(segment)) {
      return context("ANNOTATION", emptyArray())
    }

    resolveDeclarationHeader(segment)?.let { return it }

    val openParen = findLastUnclosedParen(segment)

    if (openParen != null && looksLikeMethodPrefix(segment, openParen)) {
      return resolveMethodParameters(segment, openParen)
    }

    if (looksLikeCompletedMethodHeader(segment)) {
      return resolveMethodAfterParameters(segment)
    }

    if (allAreModifiers(segment)) {
      return context("CLASS_MEMBER_START", CLASS_BODY_KEYWORDS)
    }

    if (segment.size == 1 &&
      (segment[0].text in PRIMITIVE_TYPES || segment[0].text == "void")
    ) {
      return context("CLASS_MEMBER_START", CLASS_BODY_KEYWORDS)
    }

    return context("NONE", emptyArray())
  }

  private fun resolveCodeBlock(
    tokens: List<Token>,
    parens: List<Int>,
    brackets: List<Int>,
    currentBrace: BraceFrame,
  ): Context {
    val openParen = parens.lastOrNull()
    if (openParen != null && openParen > currentBrace.tokenIndex) {
      resolveParenthesized(tokens, openParen)?.let { return it }
    }

    if (brackets.isNotEmpty() && brackets.last() > currentBrace.tokenIndex) {
      return context("EXPRESSION", EXPRESSION_KEYWORDS)
    }

    val segment = currentSegment(
      tokens = tokens,
      startIndex = currentBrace.tokenIndex + 1,
    )

    if (segment.isEmpty()) {
      return context("STATEMENT", STATEMENT_KEYWORDS)
    }

    if (isAnnotationContext(segment)) {
      return context("ANNOTATION", emptyArray())
    }

    when (lastText(segment)) {
      "new" -> return context("NEW_TYPE", NEW_TYPE_KEYWORDS)

      "instanceof",
      "extends",
      "implements",
      "permits",
      "throws",
      -> return context("REFERENCE_TYPE", emptyArray())
    }

    if (isExpressionPosition(segment)) {
      return context("EXPRESSION", EXPRESSION_KEYWORDS)
    }

    if (isCompletedLocalDeclarationPrefix(segment)) {
      return context("NONE", emptyArray())
    }

    if (isLocalDeclarationStart(segment)) {
      return context("LOCAL_DECLARATION", LOCAL_DECLARATION_KEYWORDS)
    }

    if (isStatementStart(segment)) {
      return context("STATEMENT", STATEMENT_KEYWORDS)
    }

    return context("NONE", emptyArray())
  }

  private fun resolveParenthesized(
    tokens: List<Token>,
    openParen: Int,
  ): Context? {
    val previous = tokens.getOrNull(openParen - 1)?.text
      ?: return context("EXPRESSION", EXPRESSION_KEYWORDS)

    val content = tokens.drop(openParen + 1)
    val current = currentCommaOrSemicolonPart(content)

    return when (previous) {
      "for" -> {
        val semicolonCount = content.count { it.text == ";" }

        when {
          semicolonCount > 0 || containsTopLevelColon(current) -> {
            context("EXPRESSION", EXPRESSION_KEYWORDS)
          }

          current.isEmpty() || lastText(current) == "final" -> {
            context("FOR_HEADER", FOR_HEADER_KEYWORDS)
          }

          startsWithLocalType(current) ||
            current.firstOrNull()?.text == "final" -> {
            context("NONE", emptyArray())
          }

          else -> context("EXPRESSION", EXPRESSION_KEYWORDS)
        }
      }

      "catch" -> {
        if (current.isEmpty() || lastText(current) == "final") {
          context("CATCH_PARAMETER", CATCH_PARAMETER_KEYWORDS)
        } else {
          context("NONE", emptyArray())
        }
      }

      "try" -> {
        when {
          current.isEmpty() || lastText(current) == "final" -> {
            context("RESOURCE", RESOURCE_KEYWORDS)
          }

          startsWithLocalType(current) ||
            current.firstOrNull()?.text == "final" ||
            lastText(current) == "var" -> {
            context("NONE", emptyArray())
          }

          else -> context("EXPRESSION", EXPRESSION_KEYWORDS)
        }
      }

      "if",
      "while",
      "synchronized",
      "switch",
      -> context("EXPRESSION", EXPRESSION_KEYWORDS)

      else -> null
    }
  }

  private fun resolveSwitchBody(
    source: String,
    tokens: List<Token>,
    switchBraceIndex: Int,
  ): Context {
    if (isInsideSwitchLabel(source)) {
      return context("SWITCH_LABEL", SWITCH_LABEL_KEYWORDS)
    }

    val segment = currentSegment(
      tokens = tokens,
      startIndex = switchBraceIndex + 1,
    )

    val switchKeywords = if (isSwitchExpression(tokens, switchBraceIndex)) {
      SWITCH_EXPRESSION_KEYWORDS
    } else {
      SWITCH_STATEMENT_KEYWORDS
    }

    if (segment.isEmpty()) {
      return context("SWITCH", switchKeywords)
    }

    if (hasTopLevelSwitchLabelColon(segment)) {
      return context("SWITCH", switchKeywords)
    }

    if (hasTopLevelSwitchRuleArrow(segment)) {
      return context("SWITCH_RULE_BODY", SWITCH_RULE_BODY_KEYWORDS)
    }

    if (isExpressionPosition(segment)) {
      return context("EXPRESSION", EXPRESSION_KEYWORDS)
    }

    return context("SWITCH", switchKeywords)
  }

  private fun resolveModuleBody(
    tokens: List<Token>,
    moduleBraceIndex: Int,
  ): Context {
    val segment = currentSegment(
      tokens = tokens,
      startIndex = moduleBraceIndex + 1,
    )

    if (segment.isEmpty()) {
      return context("MODULE_DIRECTIVE", MODULE_DIRECTIVE_KEYWORDS)
    }

    val first = segment.first().text
    val rest = segment.drop(1)

    return when (first) {
      "requires" -> {
        if (rest.isEmpty()) {
          context("MODULE_REQUIRES", arrayOf("transitive"))
        } else {
          context("NONE", emptyArray())
        }
      }

      "exports",
      "opens",
      -> {
        if (rest.isNotEmpty() && !containsKeyword(rest, "to")) {
          context("MODULE_TO", arrayOf("to"))
        } else {
          context("NONE", emptyArray())
        }
      }

      "provides" -> {
        if (rest.isNotEmpty() && !containsKeyword(rest, "with")) {
          context("MODULE_WITH", arrayOf("with"))
        } else {
          context("NONE", emptyArray())
        }
      }

      "uses" -> context("NONE", emptyArray())

      "to",
      "with",
      "transitive",
      -> context("NONE", emptyArray())

      else -> context("MODULE_DIRECTIVE", MODULE_DIRECTIVE_KEYWORDS)
    }
  }

  private fun resolveModuleHeader(
    tokens: List<Token>,
  ): Context? {
    val segment = currentSegment(tokens, 0)
    val moduleIndex = lastIndexOfText(segment, "module")

    if (moduleIndex == -1) {
      return null
    }

    val after = segment.drop(moduleIndex + 1)

    if (after.isEmpty()) {
      return context("MODULE_HEADER", emptyArray())
    }

    return context("MODULE_HEADER", emptyArray())
  }

  private fun resolveDeclarationHeader(
    tokens: List<Token>,
  ): Context? {
    if (tokens.isEmpty()) {
      return null
    }

    val declarationKind = findDeclarationKind(tokens) ?: return null

    if (!hasDeclarationName(tokens, declarationKind)) {
      return context(
        "${declarationKind.name}_DECLARATION",
        emptyArray(),
      )
    }

    if (isInsideTypeArgumentList(tokens)) {
      return context("REFERENCE_TYPE", emptyArray())
    }

    if (declarationKind == DeclarationKind.RECORD) {
      val openParen = findLastUnclosedParen(tokens)
      if (openParen != null) {
        return resolveRecordComponents(tokens, openParen)
      }
    }

    if (isTypeClausePosition(tokens, "extends") ||
      isTypeClausePosition(tokens, "implements") ||
      isTypeClausePosition(tokens, "permits")
    ) {
      return context("REFERENCE_TYPE", emptyArray())
    }

    return when (declarationKind) {
      DeclarationKind.CLASS -> resolveClassDeclarationHeader(tokens)
      DeclarationKind.INTERFACE -> resolveInterfaceDeclarationHeader(tokens)
      DeclarationKind.ENUM -> resolveEnumDeclarationHeader(tokens)
      DeclarationKind.RECORD -> resolveRecordDeclarationHeader(tokens)
      DeclarationKind.ANNOTATION -> context("ANNOTATION_TYPE", emptyArray())
    }
  }

  private fun resolveClassDeclarationHeader(
    tokens: List<Token>,
  ): Context {
    val sealed = containsKeyword(tokens, "sealed")
    val hasExtends = containsKeyword(tokens, "extends")
    val hasImplements = containsKeyword(tokens, "implements")
    val hasPermits = containsKeyword(tokens, "permits")

    return when {
      hasPermits -> context("CLASS_PERMITS", emptyArray())

      hasImplements -> {
        if (sealed) {
          context("CLASS_AFTER_IMPLEMENTS", arrayOf("permits"))
        } else {
          context("CLASS_AFTER_IMPLEMENTS", emptyArray())
        }
      }

      hasExtends -> {
        if (sealed) {
          context(
            "CLASS_AFTER_EXTENDS",
            arrayOf("implements", "permits"),
          )
        } else {
          context("CLASS_AFTER_EXTENDS", arrayOf("implements"))
        }
      }

      sealed -> context(
        "SEALED_CLASS_HEADER",
        arrayOf("extends", "implements", "permits"),
      )

      else -> context(
        "CLASS_HEADER",
        arrayOf("extends", "implements"),
      )
    }
  }

  private fun resolveInterfaceDeclarationHeader(
    tokens: List<Token>,
  ): Context {
    val sealed = containsKeyword(tokens, "sealed")
    val hasExtends = containsKeyword(tokens, "extends")
    val hasPermits = containsKeyword(tokens, "permits")

    return when {
      hasPermits -> context("INTERFACE_PERMITS", emptyArray())

      hasExtends -> {
        if (sealed) {
          context("INTERFACE_AFTER_EXTENDS", arrayOf("permits"))
        } else {
          context("INTERFACE_AFTER_EXTENDS", emptyArray())
        }
      }

      sealed -> context(
        "SEALED_INTERFACE_HEADER",
        arrayOf("extends", "permits"),
      )

      else -> context(
        "INTERFACE_HEADER",
        arrayOf("extends"),
      )
    }
  }

  private fun resolveEnumDeclarationHeader(
    tokens: List<Token>,
  ): Context {
    return if (containsKeyword(tokens, "implements")) {
      context("ENUM_AFTER_IMPLEMENTS", emptyArray())
    } else {
      context("ENUM_HEADER", arrayOf("implements"))
    }
  }

  private fun resolveRecordDeclarationHeader(
    tokens: List<Token>,
  ): Context {
    return if (containsKeyword(tokens, "implements")) {
      context("RECORD_AFTER_IMPLEMENTS", emptyArray())
    } else {
      context("RECORD_HEADER", arrayOf("implements"))
    }
  }

  private fun resolveRecordComponents(
    tokens: List<Token>,
    openParen: Int,
  ): Context {
    val content = currentCommaOrSemicolonPart(tokens.drop(openParen + 1))

    if (content.isEmpty()) {
      return context("RECORD_COMPONENT", RECORD_COMPONENT_KEYWORDS)
    }

    if (content.firstOrNull()?.text == "@") {
      return context("ANNOTATION", emptyArray())
    }

    if (content.firstOrNull()?.text in PRIMITIVE_TYPES) {
      return context("NONE", emptyArray())
    }

    if (content.firstOrNull()?.kind == TokenKind.IDENTIFIER) {
      return context("NONE", emptyArray())
    }

    return context("RECORD_COMPONENT", RECORD_COMPONENT_KEYWORDS)
  }

  private fun resolveMethodParameters(
    tokens: List<Token>,
    openParen: Int,
  ): Context {
    val content = currentCommaOrSemicolonPart(tokens.drop(openParen + 1))

    if (content.isEmpty()) {
      return context("PARAMETER", PARAMETER_KEYWORDS)
    }

    if (content.firstOrNull()?.text == "@") {
      return context("ANNOTATION", emptyArray())
    }

    if (content.firstOrNull()?.text == "final") {
      return if (content.size == 1) {
        context("PARAMETER", PARAMETER_KEYWORDS)
      } else {
        context("NONE", emptyArray())
      }
    }

    if (content.firstOrNull()?.text in PRIMITIVE_TYPES) {
      return context("NONE", emptyArray())
    }

    if (content.firstOrNull()?.kind == TokenKind.IDENTIFIER) {
      return context("NONE", emptyArray())
    }

    return context("PARAMETER", PARAMETER_KEYWORDS)
  }

  private fun resolveMethodAfterParameters(
    tokens: List<Token>,
  ): Context {
    val closeParen = findLastText(tokens, ")") ?: return context(
      "METHOD_DECLARATION",
      arrayOf("throws"),
    )

    val throwsIndex = lastIndexOfText(tokens, "throws")

    if (throwsIndex > closeParen) {
      return context("REFERENCE_TYPE", emptyArray())
    }

    return context("METHOD_DECLARATION", arrayOf("throws"))
  }

  private fun resolveTopLevel(
    tokens: List<Token>,
  ): Context? {
    val segment = currentSegment(tokens, 0)

    if (segment.isEmpty()) {
      return context("TOP_LEVEL", TOP_LEVEL_KEYWORDS)
    }

    if (isAnnotationContext(segment)) {
      return context("ANNOTATION", emptyArray())
    }

    when (segment.firstOrNull()?.text) {
      "package" -> return context("PACKAGE", emptyArray())
      "import" -> return context("IMPORT", emptyArray())
    }

    return context("TOP_LEVEL", TOP_LEVEL_KEYWORDS)
  }

  private fun isExpressionPosition(
    tokens: List<Token>,
  ): Boolean {
    if (tokens.isEmpty()) {
      return false
    }

    val first = tokens.first().text
    val last = lastText(tokens)

    if (first == "return" ||
      first == "throw" ||
      first == "yield" ||
      first == "assert"
    ) {
      return true
    }

    return last in EXPRESSION_CONTINUATION_TOKENS
  }

  private fun isCompletedLocalDeclarationPrefix(
    tokens: List<Token>,
  ): Boolean {
    if (tokens.isEmpty()) {
      return false
    }

    val first = tokens.first().text

    if (first == "final" && tokens.size > 1) {
      return true
    }

    if (first == "var") {
      return true
    }

    if (first in PRIMITIVE_TYPES && tokens.size > 1) {
      return true
    }

    return first != "final" &&
      first != "if" &&
      first != "for" &&
      first != "while" &&
      first != "switch" &&
      first != "try" &&
      first != "catch" &&
      first != "finally" &&
      first != "else" &&
      first != "do" &&
      first != "synchronized" &&
      first != "return" &&
      first != "throw" &&
      first != "break" &&
      first != "continue" &&
      first != "assert" &&
      tokens.size > 0 &&
      first != "new" &&
      first != "this" &&
      first != "super"
  }

  private fun isLocalDeclarationStart(
    tokens: List<Token>,
  ): Boolean {
    if (tokens.size != 1) {
      return false
    }

    val first = tokens.first().text

    return first == "final" ||
      first == "var" ||
      first in PRIMITIVE_TYPES
  }

  private fun isStatementStart(
    tokens: List<Token>,
  ): Boolean {
    val first = tokens.firstOrNull()?.text ?: return true

    return first in STATEMENT_STARTERS ||
      first == "final" ||
      first == "var" ||
      first in PRIMITIVE_TYPES ||
      first == "class" ||
      first == "interface" ||
      first == "enum" ||
      first == "record"
  }

  private fun resolveFromTreePath(
    path: TreePath,
  ): Context? {
    var current: TreePath? = path

    while (current != null) {
      when (current.leaf) {
        is MethodTree -> return context("METHOD_BODY", STATEMENT_KEYWORDS)
        is ClassTree -> return context("CLASS_BODY", CLASS_BODY_KEYWORDS)
        is CompilationUnitTree -> return context("TOP_LEVEL", TOP_LEVEL_KEYWORDS)
      }

      current = current.parentPath
    }

    return null
  }

  private fun findDeclarationKind(
    tokens: List<Token>,
  ): DeclarationKind? {
    var bestIndex = -1
    var bestKind: DeclarationKind? = null

    fun consider(
      kind: DeclarationKind,
      index: Int,
    ) {
      if (index > bestIndex) {
        bestIndex = index
        bestKind = kind
      }
    }

    val classIndex = lastIndexOfText(tokens, "class")
    if (classIndex != -1) consider(DeclarationKind.CLASS, classIndex)

    val interfaceIndex = lastIndexOfText(tokens, "interface")
    if (interfaceIndex != -1) {
      val kind = if (interfaceIndex > 0 &&
        tokens[interfaceIndex - 1].text == "@"
      ) {
        DeclarationKind.ANNOTATION
      } else {
        DeclarationKind.INTERFACE
      }
      consider(kind, interfaceIndex)
    }

    val enumIndex = lastIndexOfText(tokens, "enum")
    if (enumIndex != -1) consider(DeclarationKind.ENUM, enumIndex)

    val recordIndex = lastIndexOfText(tokens, "record")
    if (recordIndex != -1) consider(DeclarationKind.RECORD, recordIndex)

    return bestKind
  }

  private fun hasDeclarationName(
    tokens: List<Token>,
    kind: DeclarationKind,
  ): Boolean {
    val keyword = when (kind) {
      DeclarationKind.CLASS -> "class"
      DeclarationKind.INTERFACE,
      DeclarationKind.ANNOTATION,
      -> "interface"
      DeclarationKind.ENUM -> "enum"
      DeclarationKind.RECORD -> "record"
    }

    val index = lastIndexOfText(tokens, keyword)
    val next = tokens.getOrNull(index + 1)?.text ?: return false

    return isIdentifier(next)
  }

  private fun isTypeClausePosition(
    tokens: List<Token>,
    clause: String,
  ): Boolean {
    val index = lastIndexOfText(tokens, clause)
    if (index == -1) {
      return false
    }

    val after = tokens.drop(index + 1)

    if (after.isEmpty()) {
      return true
    }

    return when (lastText(after)) {
      ",",
      ".",
      "<",
      "?",
      "&",
      -> true
      else -> false
    }
  }

  private fun isInsideTypeArgumentList(
    tokens: List<Token>,
  ): Boolean {
    var depth = 0

    for (token in tokens) {
      when (token.text) {
        "<" -> depth++
        ">" -> if (depth > 0) depth--
      }
    }

    return depth > 0
  }

  private fun looksLikeMethodPrefix(
    tokens: List<Token>,
    openParen: Int,
  ): Boolean {
    val beforeParen = tokens.getOrNull(openParen - 1)?.text ?: return false

    if (!isIdentifier(beforeParen)) {
      return false
    }

    if (tokens.take(openParen).any {
        it.text == "=" ||
          it.text == "->" ||
          it.text == "new"
      }
    ) {
      return false
    }

    return !tokens.take(openParen).any {
      it.text == "if" ||
        it.text == "for" ||
        it.text == "while" ||
        it.text == "switch" ||
        it.text == "catch" ||
        it.text == "synchronized"
    }
  }

  private fun looksLikeCompletedMethodHeader(
    tokens: List<Token>,
  ): Boolean {
    val closeParen = findLastText(tokens, ")") ?: return false
    val openParen = findMatchingOpenParen(tokens, closeParen)

    if (openParen == -1) {
      return false
    }

    val beforeParen = tokens.getOrNull(openParen - 1)?.text ?: return false

    if (!isIdentifier(beforeParen)) {
      return false
    }

    if (tokens.take(openParen).any {
        it.text == "=" ||
          it.text == "->" ||
          it.text == "new"
      }
    ) {
      return false
    }

    return !tokens.take(openParen).any {
      it.text == "if" ||
        it.text == "for" ||
        it.text == "while" ||
        it.text == "switch" ||
        it.text == "catch" ||
        it.text == "synchronized"
    }
  }

  private fun allAreModifiers(
    tokens: List<Token>,
  ): Boolean {
    if (tokens.isEmpty()) {
      return false
    }

    var index = 0
    while (index < tokens.size) {
      if (tokens[index].text == "non" &&
        tokens.getOrNull(index + 1)?.text == "-" &&
        tokens.getOrNull(index + 2)?.text == "sealed"
      ) {
        index += 3
        continue
      }

      if (tokens[index].text !in MODIFIERS) {
        return false
      }

      index++
    }

    return true
  }

  private fun isAnnotationContext(
    tokens: List<Token>,
  ): Boolean {
    val at = lastIndexOfText(tokens, "@")
    if (at == -1) {
      return false
    }

    val declarationInterface = lastIndexOfText(tokens, "interface")
    if (declarationInterface > at) {
      return false
    }

    for (index in at + 1 until tokens.size) {
      when (tokens[index].text) {
        "(",
        "=",
        ",",
        ";",
        -> return false
      }
    }

    return true
  }

  private fun isModuleHeader(
    tokens: List<Token>,
  ): Boolean {
    val index = lastIndexOfText(tokens, "module")
    if (index == -1) {
      return false
    }

    return !tokens.drop(index + 1).any { it.text == ";" }
  }

  private fun containsTypeDeclarationKeyword(
    tokens: List<Token>,
  ): Boolean {
    return tokens.any {
      it.text == "class" ||
        it.text == "interface" ||
        it.text == "enum" ||
        it.text == "record"
    }
  }

  private fun containsSwitchNearHeaderEnd(
    tokens: List<Token>,
  ): Boolean {
    val switchIndex = lastIndexOfText(tokens, "switch")
    return switchIndex != -1 && switchIndex >= tokens.size - 4
  }

  private fun isControlBlockHeader(
    tokens: List<Token>,
  ): Boolean {
    val first = tokens.firstOrNull()?.text ?: return false

    return first == "if" ||
      first == "for" ||
      first == "while" ||
      first == "do" ||
      first == "try" ||
      first == "catch" ||
      first == "finally" ||
      first == "synchronized" ||
      first == "else"
  }

  private fun isMethodBodyHeader(
    tokens: List<Token>,
  ): Boolean {
    val closeParen = findLastText(tokens, ")") ?: return false
    val openParen = findMatchingOpenParen(tokens, closeParen)

    if (openParen == -1) {
      return false
    }

    val beforeParen = tokens.getOrNull(openParen - 1)?.text ?: return false

    if (!isIdentifier(beforeParen)) {
      return false
    }

    return !tokens.take(openParen).any {
      it.text == "if" ||
        it.text == "for" ||
        it.text == "while" ||
        it.text == "switch" ||
        it.text == "catch" ||
        it.text == "synchronized" ||
        it.text == "new"
    }
  }

  private fun isAnonymousClassHeader(
    tokens: List<Token>,
  ): Boolean {
    val newIndex = lastIndexOfText(tokens, "new")
    if (newIndex == -1) {
      return false
    }

    val closeParen = findLastText(tokens, ")") ?: return false
    return closeParen > newIndex
  }

  private fun isExpressionBrace(
    tokens: List<Token>,
  ): Boolean {
    val last = lastText(tokens)

    return last == "=" ||
      last == "(" ||
      last == "," ||
      last == "->"
  }

  private fun endsWithArrow(
    tokens: List<Token>,
  ): Boolean {
    return lastText(tokens) == "->"
  }

  private fun isInsideSwitchLabel(
    source: String,
  ): Boolean {
    val lineStart = source.lastIndexOf('\n').let {
      if (it == -1) 0 else it + 1
    }
    val line = source.substring(lineStart).trimStart()

    if (!(line.startsWith("case") || line.startsWith("default"))) {
      return false
    }

    val labelStart = source.lastIndexOf("case")
      .coerceAtLeast(source.lastIndexOf("default"))

    val colon = source.lastIndexOf(':')
    val arrow = source.lastIndexOf("->")
    val delimiter = maxOf(colon, arrow)

    return delimiter <= labelStart
  }

  private fun hasTopLevelSwitchLabelColon(
    tokens: List<Token>,
  ): Boolean {
    return tokens.any { it.text == ":" }
  }

  private fun hasTopLevelSwitchRuleArrow(
    tokens: List<Token>,
  ): Boolean {
    return tokens.any { it.text == "->" }
  }

  private fun isSwitchExpression(
    tokens: List<Token>,
    switchBraceIndex: Int,
  ): Boolean {
    val before = tokens.subList(0, switchBraceIndex)
    val switchIndex = lastIndexOfText(before, "switch")

    if (switchIndex == -1) {
      return false
    }

    return when (tokens.getOrNull(switchIndex - 1)?.text) {
      "return",
      "=",
      "(",
      "[",
      ",",
      "?",
      ":",
      "->",
      "yield",
      "+",
      "-",
      "*",
      "/",
      -> true
      else -> false
    }
  }

  private fun currentCommaOrSemicolonPart(
    tokens: List<Token>,
  ): List<Token> {
    for (index in tokens.lastIndex downTo 0) {
      if (tokens[index].text == "," || tokens[index].text == ";") {
        return tokens.subList(index + 1, tokens.size)
      }
    }

    return tokens
  }

  private fun containsTopLevelColon(
    tokens: List<Token>,
  ): Boolean {
    var parenDepth = 0
    var bracketDepth = 0

    for (token in tokens) {
      when (token.text) {
        "(" -> parenDepth++
        ")" -> if (parenDepth > 0) parenDepth--
        "[" -> bracketDepth++
        "]" -> if (bracketDepth > 0) bracketDepth--
        ":" -> if (parenDepth == 0 && bracketDepth == 0) return true
      }
    }

    return false
  }

  private fun startsWithLocalType(
    tokens: List<Token>,
  ): Boolean {
    val first = tokens.firstOrNull()?.text ?: return false

    return first in PRIMITIVE_TYPES || first == "var"
  }

  private fun findHeaderStart(
    tokens: List<Token>,
    braceIndex: Int,
  ): Int {
    var parenDepth = 0
    var bracketDepth = 0

    for (index in braceIndex - 1 downTo 0) {
      when (tokens[index].text) {
        ")" -> parenDepth++
        "(" -> if (parenDepth > 0) parenDepth--
        "]" -> bracketDepth++
        "[" -> if (bracketDepth > 0) bracketDepth--

        ";",
        "{",
        "}",
        -> if (parenDepth == 0 && bracketDepth == 0) {
          return index + 1
        }
      }
    }

    return 0
  }

  private fun currentSegment(
    tokens: List<Token>,
    startIndex: Int,
  ): List<Token> {
    if (startIndex >= tokens.size) {
      return emptyList()
    }

    var parenDepth = 0
    var bracketDepth = 0

    for (index in tokens.lastIndex downTo startIndex) {
      when (tokens[index].text) {
        ")" -> parenDepth++
        "(" -> if (parenDepth > 0) parenDepth--
        "]" -> bracketDepth++
        "[" -> if (bracketDepth > 0) bracketDepth--

        ";",
        "{",
        "}",
        -> if (parenDepth == 0 && bracketDepth == 0) {
          return tokens.subList(index + 1, tokens.size)
        }
      }
    }

    return tokens.subList(startIndex, tokens.size)
  }

  private fun findMatchingOpenParen(
    tokens: List<Token>,
    closeParen: Int,
  ): Int {
    var depth = 0

    for (index in closeParen downTo 0) {
      when (tokens[index].text) {
        ")" -> depth++
        "(" -> {
          depth--
          if (depth == 0) {
            return index
          }
        }
      }
    }

    return -1
  }

  private fun findLastUnclosedParen(
    tokens: List<Token>,
  ): Int? {
    val stack = mutableListOf<Int>()

    for (index in tokens.indices) {
      when (tokens[index].text) {
        "(" -> stack.add(index)
        ")" -> if (stack.isNotEmpty()) {
          stack.removeAt(stack.lastIndex)
        }
      }
    }

    return stack.lastOrNull()
  }

  private fun findLastText(
    tokens: List<Token>,
    text: String,
  ): Int? {
    for (index in tokens.lastIndex downTo 0) {
      if (tokens[index].text == text) {
        return index
      }
    }

    return null
  }

  private fun lastIndexOfText(
    tokens: List<Token>,
    text: String,
  ): Int = findLastText(tokens, text) ?: -1

  private fun lastText(
    tokens: List<Token>,
  ): String = tokens.lastOrNull()?.text.orEmpty()

  private fun containsKeyword(
    tokens: List<Token>,
    keyword: String,
  ): Boolean {
    if (keyword != "non-sealed") {
      return tokens.any { it.text == keyword }
    }

    return tokens.indices.any { index ->
      tokens[index].text == "non" &&
        tokens.getOrNull(index + 1)?.text == "-" &&
        tokens.getOrNull(index + 2)?.text == "sealed"
    }
  }

  private fun isIdentifier(
    value: String,
  ): Boolean {
    if (value.isEmpty() || !Character.isJavaIdentifierStart(value[0])) {
      return false
    }

    for (index in 1 until value.length) {
      if (!Character.isJavaIdentifierPart(value[index])) {
        return false
      }
    }

    return true
  }

  private fun stripCommentsAndLiterals(
    source: String,
  ): String {
    val result = StringBuilder(source.length)

    var index = 0
    var lineComment = false
    var blockComment = false
    var string = false
    var character = false
    var textBlock = false
    var escaped = false

    while (index < source.length) {
      val c = source[index]
      val next = if (index + 1 < source.length) source[index + 1] else '\u0000'
      val next2 = if (index + 2 < source.length) source[index + 2] else '\u0000'

      if (lineComment) {
        if (c == '\n' || c == '\r') {
          lineComment = false
          result.append(c)
        } else {
          result.append(' ')
        }
        index++
        continue
      }

      if (blockComment) {
        if (c == '*' && next == '/') {
          result.append("  ")
          index += 2
          blockComment = false
        } else {
          result.append(if (c == '\n' || c == '\r') c else ' ')
          index++
        }
        continue
      }

      if (textBlock) {
        if (c == '"' && next == '"' && next2 == '"') {
          result.append("   ")
          index += 3
          textBlock = false
        } else {
          result.append(if (c == '\n' || c == '\r') c else ' ')
          index++
        }
        continue
      }

      if (string) {
        if (escaped) {
          escaped = false
          result.append(' ')
        } else if (c == '\\') {
          escaped = true
          result.append(' ')
        } else if (c == '"') {
          string = false
          result.append(' ')
        } else {
          result.append(if (c == '\n' || c == '\r') c else ' ')
        }
        index++
        continue
      }

      if (character) {
        if (escaped) {
          escaped = false
          result.append(' ')
        } else if (c == '\\') {
          escaped = true
          result.append(' ')
        } else if (c == '\'') {
          character = false
          result.append(' ')
        } else {
          result.append(if (c == '\n' || c == '\r') c else ' ')
        }
        index++
        continue
      }

      if (c == '/' && next == '/') {
        result.append("  ")
        index += 2
        lineComment = true
        continue
      }

      if (c == '/' && next == '*') {
        result.append("  ")
        index += 2
        blockComment = true
        continue
      }

      if (c == '"' && next == '"' && next2 == '"') {
        result.append("   ")
        index += 3
        textBlock = true
        continue
      }

      if (c == '"') {
        result.append(' ')
        index++
        string = true
        continue
      }

      if (c == '\'') {
        result.append(' ')
        index++
        character = true
        continue
      }

      result.append(c)
      index++
    }

    return result.toString()
  }

  private fun tokenize(
    source: String,
  ): List<Token> {
    val result = mutableListOf<Token>()
    var index = 0

    while (index < source.length) {
      val c = source[index]

      if (c.isWhitespace()) {
        index++
        continue
      }

      if (Character.isJavaIdentifierStart(c)) {
        val start = index++

        while (
          index < source.length &&
          Character.isJavaIdentifierPart(source[index])
        ) {
          index++
        }

        result.add(
          Token(
            text = source.substring(start, index),
            start = start,
            end = index,
            kind = TokenKind.IDENTIFIER,
          ),
        )
        continue
      }

      if (c.isDigit()) {
        val start = index++

        while (
          index < source.length &&
          (source[index].isLetterOrDigit() || source[index] == '_')
        ) {
          index++
        }

        result.add(
          Token(
            text = source.substring(start, index),
            start = start,
            end = index,
            kind = TokenKind.NUMBER,
          ),
        )
        continue
      }

      val operator = longestOperatorAt(source, index)

      if (operator != null) {
        result.add(
          Token(
            text = operator,
            start = index,
            end = index + operator.length,
            kind = TokenKind.SYMBOL,
          ),
        )
        index += operator.length
        continue
      }

      result.add(
        Token(
          text = c.toString(),
          start = index,
          end = index + 1,
          kind = TokenKind.SYMBOL,
        ),
      )
      index++
    }

    return result
  }

  private fun longestOperatorAt(
    source: String,
    index: Int,
  ): String? {
    for (operator in OPERATORS_BY_LENGTH) {
      if (source.startsWith(operator, index)) {
        return operator
      }
    }

    return null
  }

  private fun context(
    name: String,
    keywords: Array<String>,
  ): Context = Context(name, keywords)

  private data class Token(
    val text: String,
    val start: Int,
    val end: Int,
    val kind: TokenKind,
  )

  private enum class TokenKind {
    IDENTIFIER,
    NUMBER,
    SYMBOL,
  }

  private enum class BraceKind {
    CLASS_BODY,
    METHOD_BODY,
    SWITCH_BODY,
    INITIALIZER,
    BLOCK,
    LAMBDA_BODY,
    EXPRESSION,
    MODULE_BODY,
  }

  private enum class DeclarationKind {
    CLASS,
    INTERFACE,
    ENUM,
    RECORD,
    ANNOTATION,
  }

  private data class BraceFrame(
    val kind: BraceKind,
    val tokenIndex: Int,
  )

  private val MODIFIERS = setOf(
    "public",
    "protected",
    "private",
    "static",
    "final",
    "abstract",
    "native",
    "synchronized",
    "transient",
    "volatile",
    "strictfp",
    "default",
    "sealed",
  )

  private val PRIMITIVE_TYPES = setOf(
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
  )

  private val STATEMENT_STARTERS = setOf(
    "assert",
    "if",
    "for",
    "while",
    "do",
    "switch",
    "try",
    "else",
    "catch",
    "finally",
    "synchronized",
    "return",
    "throw",
    "break",
    "continue",
    "new",
    "this",
    "super",
  )

  private val EXPRESSION_CONTINUATION_TOKENS = setOf(
    "=",
    "+",
    "-",
    "*",
    "/",
    "%",
    "&&",
    "||",
    "&",
    "|",
    "^",
    "!",
    "~",
    "?",
    ":",
    ",",
    "(",
    "[",
    "==",
    "!=",
    "<",
    ">",
    "<=",
    ">=",
    "+=",
    "-=",
    "*=",
    "/=",
    "%=",
    "->",
  )

  private val TOP_LEVEL_KEYWORDS = arrayOf(
    "package",
    "import",
    "public",
    "abstract",
    "final",
    "strictfp",
    "sealed",
    "non-sealed",
    "class",
    "interface",
    "enum",
    "record",
    "module",
    "open",
  )

  private val CLASS_BODY_KEYWORDS = arrayOf(
    "public",
    "protected",
    "private",
    "static",
    "final",
    "transient",
    "volatile",
    "native",
    "synchronized",
    "abstract",
    "strictfp",
    "default",
    "sealed",
    "non-sealed",
    "class",
    "interface",
    "enum",
    "record",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
    "void",
  )

  private val PARAMETER_KEYWORDS = arrayOf(
    "final",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
  )

  private val RECORD_COMPONENT_KEYWORDS = arrayOf(
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
  )

  private val LOCAL_DECLARATION_KEYWORDS = arrayOf(
    "final",
    "var",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
  )

  private val FOR_HEADER_KEYWORDS = arrayOf(
    "final",
    "var",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
  )

  private val RESOURCE_KEYWORDS = arrayOf(
    "final",
    "var",
  )

  private val CATCH_PARAMETER_KEYWORDS = arrayOf(
    "final",
  )

  private val NEW_TYPE_KEYWORDS = arrayOf(
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
  )

  private val STATEMENT_KEYWORDS = arrayOf(
    "assert",
    "if",
    "for",
    "while",
    "do",
    "switch",
    "try",
    "synchronized",
    "return",
    "throw",
    "break",
    "continue",
    "new",
    "this",
    "super",
    "final",
    "var",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
    "class",
    "interface",
    "enum",
    "record",
  )

  private val EXPRESSION_KEYWORDS = arrayOf(
    "new",
    "this",
    "super",
    "switch",
    "true",
    "false",
    "null",
  )

  private val SWITCH_STATEMENT_KEYWORDS = arrayOf(
    "case",
    "default",
    "break",
    "continue",
    "throw",
    "return",
    "new",
    "this",
    "super",
    "true",
    "false",
    "null",
  )

  private val SWITCH_EXPRESSION_KEYWORDS = arrayOf(
    "case",
    "default",
    "yield",
    "break",
    "continue",
    "throw",
    "return",
    "new",
    "this",
    "super",
    "true",
    "false",
    "null",
  )

  private val SWITCH_RULE_BODY_KEYWORDS = arrayOf(
    "throw",
    "yield",
    "return",
    "break",
    "continue",
    "if",
    "for",
    "while",
    "try",
    "synchronized",
    "new",
    "this",
    "super",
    "true",
    "false",
    "null",
  )

  private val SWITCH_LABEL_KEYWORDS = arrayOf(
    "case",
    "default",
  )

  private val MODULE_DECLARATION_KEYWORDS = arrayOf(
    "module",
  )

  private val MODULE_DIRECTIVE_KEYWORDS = arrayOf(
    "requires",
    "exports",
    "opens",
    "uses",
    "provides",
  )

  private val OPERATORS_BY_LENGTH = arrayOf(
    ">>>=",
    "<<=",
    ">>=",
    "===",
    "...",
    "->",
    "::",
    "++",
    "--",
    "+=",
    "-=",
    "*=",
    "/=",
    "%=",
    "&=",
    "|=",
    "^=",
    "==",
    "!=",
    "<=",
    ">=",
    "&&",
    "||",
    "<<",
    ">>>",
    ">>",
  )
}
