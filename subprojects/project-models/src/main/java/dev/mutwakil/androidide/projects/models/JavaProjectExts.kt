package dev.mutwakil.androidide.projects.models

import dev.mutwakil.androidide.project.JavaModels
import java.io.File

val JavaModels.JavaSourceDirectoryOrBuilder.directory: File
	get() = File(directoryPath)

val JavaModels.JavaDependencyOrBuilder.jarFile: File
	get() = File(jarFilePath)
