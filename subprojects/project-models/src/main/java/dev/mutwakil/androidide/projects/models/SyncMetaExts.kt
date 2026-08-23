package dev.mutwakil.androidide.projects.models

import dev.mutwakil.androidide.project.SyncMetaModels
import java.io.File

val SyncMetaModels.SyncMetaOrBuilder.rootProjectDir: File
	get() = File(this.rootProjectPath)

val SyncMetaModels.ProjectModelInfoOrBuilder.modelCacheFile: File
	get() = File(modelCachePath)

val SyncMetaModels.FileInfoOrBuilder.relativeFile: File
	get() = File(relativePath)

val SyncMetaModels.FileInfoOrBuilder.canonicalFile: File
	get() = File(canonicalPath)
