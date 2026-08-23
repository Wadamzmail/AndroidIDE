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

import dev.mutwakil.androidide.build.config.BuildConfig

plugins {
	id("com.android.library")
	id("kotlin-android")
	id("kotlin-kapt")
	alias(libs.plugins.kotlin.compose)
}

android {
	namespace = "${BuildConfig.PACKAGE_NAME}.lsp.kotlin"

	// The refactoring bottom sheets are Compose (ADR 0009); they live here rather than in a UI
	// module because `editor` depends on this module, not the reverse (ADR 0012).
	buildFeatures {
		compose = true
	}

	kotlin.compilerOptions {
		freeCompilerArgs.addAll("-Xcontext-parameters")
	}
}

kapt {
	arguments {
		arg("eventBusIndex", "${BuildConfig.PACKAGE_NAME}.events.LspKotlinEventsIndex")
	}
}

dependencies {
	kapt(projects.annotation.processors)

	implementation(projects.core.actions)
	implementation(projects.core.lspApi)
	implementation(projects.lsp.jvmSymbolIndex)
	implementation(projects.core.lspModels)
	implementation(projects.editor.api)
	implementation(projects.event.eventbusEvents)
	implementation(projects.subprojects.kotlinAnalysisApi)
	implementation(projects.utilities.shared)

//	implementation(projects.core.projects)
	implementation(projects.subprojects.projects)
	implementation(projects.subprojects.projectModels)

	implementation(libs.common.jsonrpc)
	implementation(libs.common.kotlin)
	implementation(libs.common.kotlin.coroutines.core)
	implementation(libs.common.kotlin.coroutines.android)
	implementation(projects.subprojects.commonCompose)
//	implementation(libs.sentry.android.core)

	compileOnly(projects.core.common)

	testImplementation(projects.testing.lspTest)
	testImplementation(libs.tests.kotlinx.coroutines)
}
