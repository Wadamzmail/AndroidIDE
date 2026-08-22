package dev.mutwakil.androidide.compose.preview.domain.model

import dev.mutwakil.androidide.compose.preview.PreviewConfig

data class ParsedPreviewSource(
    val packageName: String,
    val className: String?,
    val previewConfigs: List<PreviewConfig>,
)
