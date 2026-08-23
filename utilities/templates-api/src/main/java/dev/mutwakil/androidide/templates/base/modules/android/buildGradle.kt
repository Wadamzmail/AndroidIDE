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

package dev.mutwakil.androidide.templates.base.modules.android

import dev.mutwakil.androidide.templates.Language.Kotlin
import dev.mutwakil.androidide.templates.ModuleType
import dev.mutwakil.androidide.templates.base.AndroidModuleTemplateBuilder
import dev.mutwakil.androidide.templates.base.ModuleTemplateBuilder
import dev.mutwakil.androidide.templates.base.modules.dependencies

private const val compose_kotlinCompilerExtensionVersion = "1.5.1"

private val AndroidModuleTemplateBuilder.androidPlugin: String
  get() {
    return if (data.type == ModuleType.AndroidLibrary) "com.android.library"
    else "com.android.application"
  }

fun AndroidModuleTemplateBuilder.buildGradleSrc(isComposeModule: Boolean
): String {
  return if (data.useKts) buildGradleSrcKts(
    isComposeModule) else buildGradleSrcGroovy(isComposeModule)
}

private fun AndroidModuleTemplateBuilder.buildGradleSrcKts(
  isComposeModule: Boolean
): String {
  return """
plugins {
    id("$androidPlugin")
    ${ktPlugin()}
    ${composePlugin()}
}

android {
    namespace = "${data.packageName}"
    compileSdk { version = release(${data.versions.compileSdk.api}) { minorApiLevel = 0 } }
    
    // disable linter
    lint {
        checkReleaseBuilds = false
    }
    
    defaultConfig {
        applicationId = "${data.packageName}"
        minSdk = ${data.versions.minSdk.api}
        targetSdk = ${data.versions.targetSdk.api}
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = ${data.versions.javaSource()}
        targetCompatibility = ${data.versions.javaTarget()}
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        ${if (!isComposeModule) "viewBinding = true" else ""}
        ${if (isComposeModule) "compose = true" else ""}
    }
    ${if(isComposeModule) composeConfigKts() else ""}
}
${ktJvmTarget()}
${dependencies()}
"""
}

private fun AndroidModuleTemplateBuilder.buildGradleSrcGroovy(
  isComposeModule: Boolean
): String {
  return """
plugins {
    id '$androidPlugin'
    ${ktPlugin()}
    ${composePlugin()} 
}

android {
    namespace = '${data.packageName}'
    compileSdk = ${data.versions.compileSdk.api}
    
    // disable linter
    lint {
        checkReleaseBuilds = false
    }
    
    defaultConfig {
        applicationId = "${data.packageName}"
        minSdk = ${data.versions.minSdk.api}
        targetSdk = ${data.versions.targetSdk.api}
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            minifyEnabled = true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility = ${data.versions.javaSource()}
        targetCompatibility = ${data.versions.javaTarget()}
    }

    buildFeatures {
        ${if (!isComposeModule) "viewBinding = true" else ""}
        ${if (isComposeModule) "compose = true" else ""}
    }
    ${if(isComposeModule) composeConfigGroovy() else ""}
}
${ktJvmTarget()}
${dependencies()}
"""
}

fun composeConfigGroovy(): String
= """
    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
            excludes += 'META-INF/kotlinx_coroutines_core.version'
            
            pickFirsts += [
             "nonJvmMain/default/linkdata/package_androidx/0_androidx.knm",
             "nonJvmMain/default/linkdata/root_package/0_.knm",
             "nonJvmMain/default/linkdata/module", 
             "nativeMain/default/linkdata/root_package/0_.knm", 
             "nativeMain/default/linkdata/module", 
             "commonMain/default/linkdata/root_package/0_.knm", 
             "commonMain/default/linkdata/module", 
             "commonMain/default/linkdata/package_androidx/0_androidx.knm", 
             "META-INF/kotlin-project-structure-metadata.json" 
            ]

            merges += [
             "commonMain/default/manifest",
             "nonJvmMain/default/manifest",
             "nativeMain/default/manifest"
            ]
        }
    }
""".trim()

fun composeConfigKts(): String
  = """
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/kotlinx_coroutines_core.version")
            
            pickFirsts.add("nonJvmMain/default/linkdata/package_androidx/0_androidx.knm")
            pickFirsts.add("nonJvmMain/default/linkdata/root_package/0_.knm")
            pickFirsts.add("nonJvmMain/default/linkdata/module")

            pickFirsts.add("nativeMain/default/linkdata/root_package/0_.knm")
            pickFirsts.add("nativeMain/default/linkdata/module")

            pickFirsts.add("commonMain/default/linkdata/root_package/0_.knm")
            pickFirsts.add("commonMain/default/linkdata/module")
            pickFirsts.add("commonMain/default/linkdata/package_androidx/0_androidx.knm")

            pickFirsts.add("META-INF/kotlin-project-structure-metadata.json")

            merges.add("commonMain/default/manifest")
            merges.add("nonJvmMain/default/manifest")
            merges.add("nativeMain/default/manifest")
        }
    }
""".trim()

private fun ModuleTemplateBuilder.ktJvmTarget(): String {
  if (data.language != Kotlin) {
    return ""
  }

  return if (data.useKts) ktJvmTargetKts() else ktJvmTargetGroovy()
}

private fun ModuleTemplateBuilder.ktJvmTargetKts(): String {
  return """
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions.jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_${data.versions.javaTarget}
}
"""
}

private fun ModuleTemplateBuilder.ktJvmTargetGroovy(): String {
  return """
tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).configureEach {
  compilerOptions {
    jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_${data.versions.javaTarget}
  }
}
"""
}

private fun AndroidModuleTemplateBuilder.ktPlugin(): String {
  if (data.language != Kotlin) {
    return ""
  }

  return if (data.useKts) ktPluginKts() else ktPluginGroovy()
}

private fun ktPluginKts(): String {
  return """id("kotlin-android")"""
}

private fun ktPluginGroovy(): String {
  return "id 'kotlin-android'"
}

private fun AndroidModuleTemplateBuilder.composePlugin(): String {
  if (data.language != Kotlin) {
    return ""
  }
  
  if(!isComposeModule) return ""

  return if (data.useKts) composePluginKts() else composePluginGroovy()
}

private fun composePluginKts(): String {
  return """id("org.jetbrains.kotlin.plugin.compose")"""
}

private fun composePluginGroovy(): String{
  return "id 'org.jetbrains.kotlin.plugin.compose'"
}
