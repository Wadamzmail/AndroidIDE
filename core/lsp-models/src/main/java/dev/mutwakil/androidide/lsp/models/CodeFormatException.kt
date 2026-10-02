package dev.mutwakil.androidide.lsp.models

class CodeFormatException(
    message: String,
    cause: Throwable,
) : Exception(message, cause)