package dev.mutwakil.androidide.lsp.java.providers.completion

import dev.mutwakil.androidide.lsp.java.compiler.CompileTask
import openjdk.source.tree.ClassTree
import openjdk.source.tree.CompilationUnitTree
import openjdk.source.tree.MethodTree
import openjdk.source.tree.Tree
import openjdk.source.util.TreePath

internal object KeywordCompletionContextResolver {

  enum class Context {
    TOP_LEVEL,
    CLASS_BODY,
    METHOD_BODY,
    DECLARATION,
    TYPE,
    SWITCH,
    SWITCH_LABEL,
    EXPRESSION,
  }

  fun resolve(
    task: CompileTask,
    path: TreePath,
    source: String,
    cursor: Long,
  ): Context {
    val astContext = resolveFromTreePath(path)

    if (astContext != null && astContext != Context.TOP_LEVEL) {
      return resolveSourceContext(
        source = source,
        cursor = cursor,
        fallback = astContext,
      )
    }

    return resolveSourceContext(
      source = source,
      cursor = cursor,
      fallback = astContext ?: Context.TOP_LEVEL,
    )
  }

  private fun resolveFromTreePath(path: TreePath): Context? {
    var current: TreePath? = path

    while (current != null) {
      when (current.leaf) {
        is MethodTree -> return Context.METHOD_BODY
        is ClassTree -> return Context.CLASS_BODY
        is CompilationUnitTree -> return Context.TOP_LEVEL
      }

      current = current.parentPath
    }

    return null
  }

  private fun resolveSourceContext(
    source: String,
    cursor: Long,
    fallback: Context,
  ): Context {
    val end = cursor.toInt().coerceIn(0, source.length)
    val prefix = source.substring(0, end)

    val cleanPrefix = stripCommentsAndLiterals(prefix)

    if (isInsideSwitch(cleanPrefix)) {
      if (looksLikeSwitchLabel(cleanPrefix)) {
        return Context.SWITCH_LABEL
      }

      return Context.SWITCH
    }

    if (isAfterKeyword(cleanPrefix, "throws")) {
      return Context.TYPE
    }

    if (isAfterKeyword(cleanPrefix, "extends")) {
      return Context.TYPE
    }

    if (isAfterKeyword(cleanPrefix, "implements")) {
      return Context.TYPE
    }

    if (isAfterKeyword(cleanPrefix, "permits")) {
      return Context.TYPE
    }

    if (isAfterKeyword(cleanPrefix, "instanceof")) {
      return Context.TYPE
    }

    if (isAfterKeyword(cleanPrefix, "new")) {
      return Context.TYPE
    }

    if (isInsideAnnotation(cleanPrefix)) {
      return Context.EXPRESSION
    }

    val braceContext = resolveBraceContext(cleanPrefix)

    if (braceContext != null) {
      return braceContext
    }

    if (looksLikeDeclarationHeader(cleanPrefix)) {
      return Context.DECLARATION
    }

    return fallback
  }

  private fun resolveBraceContext(source: String): Context? {
    val braces = mutableListOf<Brace>()

    var index = 0

    while (index < source.length) {
      val c = source[index]

      when (c) {
        '{' -> {
          braces.add(
            Brace(
              index = index,
              header = source.substring(
                maxOf(0, findHeaderStart(source, index)),
                index,
              ),
            ),
          )
        }

        '}' -> {
          if (braces.isNotEmpty()) {
            braces.removeAt(braces.lastIndex)
          }
        }
      }

      index++
    }

    if (braces.isEmpty()) {
      return null
    }

    val current = braces.last()
    val header = current.header.trim()

    if (isTypeDeclarationHeader(header)) {
      return Context.CLASS_BODY
    }

    if (isMethodHeader(header)) {
      return Context.METHOD_BODY
    }

    return Context.METHOD_BODY
  }

  private fun isTypeDeclarationHeader(header: String): Boolean {
    return TYPE_DECLARATION_PATTERN.containsMatchIn(header)
  }

  private fun isMethodHeader(header: String): Boolean {
    if (!header.contains('(') || !header.contains(')')) {
      return false
    }

    if (TYPE_DECLARATION_PATTERN.containsMatchIn(header)) {
      return false
    }

    return true
  }

  private fun looksLikeDeclarationHeader(source: String): Boolean {
    val line = source.substringAfterLast('\n').trim()

    if (line.isEmpty()) {
      return false
    }

    if (line.matches(MODIFIER_PATTERN)) {
      return true
    }

    return line.matches(DECLARATION_PATTERN)
  }

  private fun isInsideSwitch(source: String): Boolean {
    var switchDepth = 0
    var braceDepth = 0

    val tokens = TOKEN_PATTERN.findAll(source)

    for (match in tokens) {
      val token = match.value

      when (token) {
        "switch" -> {
          switchDepth++
        }

        "{" -> {
          braceDepth++
        }

        "}" -> {
          braceDepth--
        }
      }
    }

    return switchDepth > 0 && braceDepth > 0
  }

  private fun looksLikeSwitchLabel(source: String): Boolean {
    val line = source.substringAfterLast('\n').trimStart()

    return line.startsWith("case ") ||
      line == "case" ||
      line.startsWith("default")
  }

  private fun isInsideAnnotation(source: String): Boolean {
    val line = source.substringAfterLast('\n').trim()

    return line.startsWith("@") &&
      !line.contains(' ')
  }

  private fun isAfterKeyword(
    source: String,
    keyword: String,
  ): Boolean {
    return Regex(
      """(?:^|\s|\()$keyword\s*$"""
    ).containsMatchIn(source)
  }

  private fun stripCommentsAndLiterals(source: String): String {
    val result = StringBuilder(source.length)

    var i = 0
    var inLineComment = false
    var inBlockComment = false
    var inString = false
    var inChar = false
    var escaped = false

    while (i < source.length) {
      val c = source[i]
      val next = if (i + 1 < source.length) source[i + 1] else '\u0000'

      if (inLineComment) {
        if (c == '\n' || c == '\r') {
          inLineComment = false
          result.append(c)
        } else {
          result.append(' ')
        }

        i++
        continue
      }

      if (inBlockComment) {
        if (c == '*' && next == '/') {
          result.append("  ")
          i += 2
          inBlockComment = false
        } else {
          result.append(if (c == '\n' || c == '\r') c else ' ')
          i++
        }

        continue
      }

      if (inString) {
        if (escaped) {
          escaped = false
          result.append(' ')
        } else if (c == '\\') {
          escaped = true
          result.append(' ')
        } else if (c == '"') {
          inString = false
          result.append(' ')
        } else {
          result.append(if (c == '\n' || c == '\r') c else ' ')
        }

        i++
        continue
      }

      if (inChar) {
        if (escaped) {
          escaped = false
          result.append(' ')
        } else if (c == '\\') {
          escaped = true
          result.append(' ')
        } else if (c == '\'') {
          inChar = false
          result.append(' ')
        } else {
          result.append(if (c == '\n' || c == '\r') c else ' ')
        }

        i++
        continue
      }

      if (c == '/' && next == '/') {
        result.append("  ")
        i += 2
        inLineComment = true
        continue
      }

      if (c == '/' && next == '*') {
        result.append("  ")
        i += 2
        inBlockComment = true
        continue
      }

      if (c == '"') {
        result.append(' ')
        i++
        inString = true
        continue
      }

      if (c == '\'') {
        result.append(' ')
        i++
        inChar = true
        continue
      }

      result.append(c)
      i++
    }

    return result.toString()
  }

  private fun findHeaderStart(
    source: String,
    braceIndex: Int,
  ): Int {
    var parenDepth = 0
    var index = braceIndex - 1

    while (index >= 0) {
      when (source[index]) {
        ')' -> parenDepth++
        '(' -> {
          if (parenDepth > 0) {
            parenDepth--
          }
        }

        ';' -> {
          if (parenDepth == 0) {
            return index + 1
          }
        }

        '{', '}' -> {
          if (parenDepth == 0) {
            return index + 1
          }
        }
      }

      index--
    }

    return 0
  }

  fun Context.keywords(): Array<String> {
    return when (this) {
      Context.TOP_LEVEL -> TOP_LEVEL_KEYWORDS
      Context.CLASS_BODY -> CLASS_BODY_KEYWORDS
      Context.METHOD_BODY -> METHOD_BODY_KEYWORDS
      Context.DECLARATION -> DECLARATION_KEYWORDS
      Context.TYPE -> TYPE_KEYWORDS
      Context.SWITCH -> SWITCH_KEYWORDS
      Context.SWITCH_LABEL -> SWITCH_LABEL_KEYWORDS
      Context.EXPRESSION -> EXPRESSION_KEYWORDS
    }
  }

  private data class Brace(
    val index: Int,
    val header: String,
  )

  private const val KEYWORD_PATTERN =
    """\b(?:switch|class|interface|enum|record|if|for|while|try|catch|finally|synchronized|do|new)\b"""

  private val TOKEN_PATTERN = Regex(
    """[A-Za-z_$][A-Za-z0-9_$]*|[{}()]"""
  )

  private val TYPE_DECLARATION_PATTERN = Regex(
    """\b(class|interface|enum|record|@interface)\b"""
  )

  private val MODIFIER_PATTERN = Regex(
    """(?:(?:public|protected|private|static|final|abstract|native|synchronized|transient|volatile|strictfp|default|sealed|non-sealed)\s*)+"""
  )

  private val DECLARATION_PATTERN = Regex(
    """(?:(?:public|protected|private|static|final|abstract|native|synchronized|transient|volatile|strictfp|default|sealed|non-sealed)\s*)*(?:class|interface|enum|record)\s*"""
  )

  private val TOP_LEVEL_KEYWORDS = arrayOf(
    "package",
    "import",
    "public",
    "private",
    "protected",
    "abstract",
    "static",
    "final",
    "strictfp",
    "sealed",
    "non-sealed",
    "class",
    "interface",
    "enum",
    "record",
  )

  private val CLASS_BODY_KEYWORDS = arrayOf(
    "public",
    "private",
    "protected",
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
    "extends",
    "implements",
    "permits",
    "void",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
    "true",
    "false",
    "null",
  )

  private val DECLARATION_KEYWORDS = arrayOf(
    "public",
    "private",
    "protected",
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
    "non-sealed",
    "class",
    "interface",
    "enum",
    "record",
  )

  private val METHOD_BODY_KEYWORDS = arrayOf(
    "new",
    "this",
    "super",
    "assert",
    "try",
    "catch",
    "finally",
    "throw",
    "return",
    "break",
    "case",
    "continue",
    "default",
    "do",
    "while",
    "for",
    "switch",
    "if",
    "else",
    "instanceof",
    "var",
    "final",
    "class",
    "interface",
    "enum",
    "record",
    "void",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
    "true",
    "false",
    "null",
  )

  private val TYPE_KEYWORDS = arrayOf(
    "class",
    "interface",
    "enum",
    "record",
    "void",
    "boolean",
    "byte",
    "char",
    "short",
    "int",
    "long",
    "float",
    "double",
    "var",
  )

  private val SWITCH_KEYWORDS = arrayOf(
    "case",
    "default",
    "yield",
    "break",
    "continue",
    "if",
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

  private val EXPRESSION_KEYWORDS = arrayOf(
    "new",
    "this",
    "super",
    "true",
    "false",
    "null",
  )
}