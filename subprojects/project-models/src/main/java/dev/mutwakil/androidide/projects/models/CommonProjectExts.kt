package dev.mutwakil.androidide.projects.models

import dev.mutwakil.androidide.project.JavaCompilerSettings

val DEFAULT_COMPILER_SETTINGS =
	JavaCompilerSettings(
		sourceCompatibility = "RELEASE_11",
		targetCompatibility = "RELEASE_11",
	)
