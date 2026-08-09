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

package dev.mutwakil.androidide.templates.base.root

import dev.mutwakil.androidide.templates.Language
import dev.mutwakil.androidide.templates.base.ProjectTemplateBuilder

internal fun ProjectTemplateBuilder.buildGradleSrcKts(): String {
  return """
    // Top-level build file where you can add configuration options common to all sub-projects/modules.
    plugins {
        id("com.android.application") version "${data.version.gradlePlugin}" apply false
        id("com.android.library") version "${data.version.gradlePlugin}" apply false
        ${ktPlugin()}
        ${composePlugin()} 
    }

    tasks.register<Delete>("clean") {
        delete(rootProject.buildDir)
    }
  """.trimIndent()
}

internal fun ProjectTemplateBuilder.buildGradleSrcGroovy(): String {
  return """
    // Top-level build file where you can add configuration options common to all sub-projects/modules.
    plugins {
        id 'com.android.application' version '${data.version.gradlePlugin}' apply false
        id 'com.android.library' version '${data.version.gradlePlugin}' apply false 
        ${ktPlugin()}
        ${composePlugin()} 
    }

    task clean(type: Delete) {
        delete rootProject.buildDir
    }
  """.trimIndent()
}

private fun ProjectTemplateBuilder.ktPlugin() = if (data.language == Language.Kotlin) {
  if (data.useKts) ktPluginKts() else ktPluginGroovy()
} else ""

private fun ProjectTemplateBuilder.ktPluginKts(): String {
  return """id("org.jetbrains.kotlin.android") version "${data.version.kotlin}" apply false"""
}

private fun ProjectTemplateBuilder.ktPluginGroovy(): String {
  return "id 'org.jetbrains.kotlin.android' version '${data.version.kotlin}' apply false"
}

private fun ProjectTemplateBuilder.composePlugin() = if (data.language == Language.Kotlin) {
  if (data.useKts) composePluginKts() else composePluginGroovy()
} else ""

private fun ProjectTemplateBuilder.composePluginKts(): String {
  return """id("org.jetbrains.kotlin.plugin.compose") version "${data.version.kotlin}" apply false"""
}

private fun ProjectTemplateBuilder.composePluginGroovy(): String {
  return "id 'org.jetbrains.kotlin.plugin.compose' version '${data.version.kotlin}' apply false"
}