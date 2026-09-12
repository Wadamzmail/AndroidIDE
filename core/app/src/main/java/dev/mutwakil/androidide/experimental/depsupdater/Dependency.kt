package dev.mutwakil.androidide.experimental.depsupdater

data class Dependency(
    val group: String,
    val name: String,
    val currentVersion: String,
    val latestVersion: String? = null,
    val hasUpdate: Boolean = false,
    val catalogReference: String? = null,
    val variableReference: String? = null
)