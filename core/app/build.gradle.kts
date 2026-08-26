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

@file:Suppress("UnstableApiUsage")

import dev.mutwakil.androidide.build.config.BuildConfig
import dev.mutwakil.androidide.desugaring.utils.JavaIOReplacements.applyJavaIOReplacements
import dev.mutwakil.androidide.plugins.AndroidIDEAssetsPlugin

plugins {
    id("dev.mutwakil.androidide.core-app")
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dev.mutwakil.androidide.desugaring")
}

apply {
    plugin(AndroidIDEAssetsPlugin::class.java)
}

buildscript {
    dependencies {
        classpath(libs.logging.logback.core)
        classpath(libs.composite.desugaringCore)
    }
}

android {
    namespace = BuildConfig.PACKAGE_NAME

    defaultConfig {
        applicationId = BuildConfig.PACKAGE_NAME
        vectorDrawables.useSupportLibrary = true
    }

    androidResources {
        generateLocaleConfig = true
    }

    buildTypes {
        release {
            isShrinkResources = true
            manifestPlaceholders["sentryDsn"] = ""
        }
        debug {
            manifestPlaceholders["sentryDsn"] = ""
        }
    }

    lint {
        abortOnError = false
        disable.addAll(arrayOf("VectorPath", "NestedWeights", "ContentDescription", "SmallSp"))
    }

    packaging {
        resources {
            excludes += "META-INF/DEPENDENCIES"
            excludes += "META-INF/gradle/incremental.annotation.processors"

            pickFirsts += "kotlin/internal/internal.kotlin_builtins"
            pickFirsts += "kotlin/reflect/reflect.kotlin_builtins"
            pickFirsts += "kotlin/kotlin.kotlin_builtins"
            pickFirsts += "kotlin/coroutines/coroutines.kotlin_builtins"
            pickFirsts += "kotlin/ranges/ranges.kotlin_builtins"
            pickFirsts += "kotlin/concurrent/atomics/atomics.kotlin_builtins"
            pickFirsts += "kotlin/collections/collections.kotlin_builtins"
            pickFirsts += "kotlin/annotation/annotation.kotlin_builtins"

            pickFirsts += "META-INF/FastDoubleParser-LICENSE"
            pickFirsts += "META-INF/thirdparty-LICENSE"
            pickFirsts += "META-INF/FastDoubleParser-NOTICE"
            pickFirsts += "META-INF/thirdparty-NOTICE"
        }

        jniLibs {
            useLegacyPackaging = false
        }
    }
}

kapt {
    arguments {
        arg("eventBusIndex", "${BuildConfig.PACKAGE_NAME}.events.AppEventsIndex")
    }
}

desugaring {
    replacements {
        includePackage(
            "org.eclipse.jgit",
        )

        applyJavaIOReplacements()
    }
}

configurations.configureEach {
    exclude(group = "org.jetbrains.kotlin", module = "kotlin-android-extensions-runtime")
}

dependencies {
    implementation(libs.androidx.room.ktx)
    debugImplementation(libs.common.leakcanary)

    // Annotation processors
    kapt(libs.common.glide.ap)
    kapt(libs.google.auto.service)
    kapt(projects.annotation.processors)
    kapt(libs.androidx.room.compiler)

    implementation(libs.common.editor)
    implementation(libs.common.utilcode)
    implementation(libs.common.glide)
    implementation(libs.common.jsoup)
    implementation(libs.common.kotlin.coroutines.android)
    implementation(libs.common.retrofit)
    implementation(libs.common.retrofit.gson)
    implementation(libs.common.charts)
    implementation(libs.common.hiddenApiBypass)
    implementation(libs.aapt2.common)

    implementation(libs.google.auto.service.annotations)
    implementation(libs.google.gson)
    implementation(libs.google.guava)

    // Git
    implementation(libs.git.jgit)

    // AndroidX
    implementation(libs.androidx.splashscreen)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.androidx.drawer)
    implementation(libs.androidx.grid)
    implementation(libs.androidx.nav.fragment)
    implementation(libs.androidx.nav.ui)
    implementation(libs.androidx.preference)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.transition)
    implementation(libs.androidx.vectors)
    implementation(libs.androidx.animated.vectors)
    implementation(libs.androidx.work)
    implementation(libs.androidx.work.ktx)
    implementation(libs.google.material)
    implementation(libs.google.flexbox)
    implementation(libs.androidx.localbroadcastmanager)
    implementation(libs.androidx.legacy)

    // Kotlin
    implementation(libs.androidx.core.ktx)
    implementation(libs.common.kotlin)

    // Dependencies in composite build
    implementation(libs.composite.appintro)
    implementation(libs.composite.desugaringCore)
    implementation(libs.composite.javapoet)

    // Local projects here
    implementation(projects.core.actions)
    implementation(projects.core.common)
    implementation(projects.core.indexingApi)
    implementation(projects.core.indexingCore)
    implementation(projects.core.lspApi)
    implementation(projects.core.resources)
    implementation(projects.editor.impl)
    implementation(projects.editor.lexers)
    implementation(projects.event.eventbus)
    implementation(projects.event.eventbusAndroid)
    implementation(projects.event.eventbusEvents)
    implementation(projects.java.javacServices)
    implementation(projects.java.lsp)
    implementation(projects.logging.idestats)
    implementation(projects.logging.logsender)
    implementation(projects.termux.application)
    implementation(projects.termux.view)
    implementation(projects.termux.emulator)
    implementation(projects.termux.shared)
    implementation(projects.tooling.api)
    implementation(projects.tooling.pluginConfig)
    implementation(projects.utilities.buildInfo)
    implementation(projects.utilities.lookup)
    implementation(projects.utilities.preferences)
    implementation(projects.utilities.templatesApi)
    implementation(projects.utilities.templatesImpl)
    implementation(projects.utilities.treeview)
    implementation(projects.utilities.uidesigner)
    implementation(projects.utilities.xmlInflater)
    implementation(projects.xml.aaptcompiler)
    implementation(projects.xml.lsp)
    implementation(projects.xml.utils)
    implementation(projects.lsp.kotlin)
    implementation(projects.subprojects.kotlinAnalysisApi)
    implementation(projects.subprojects.composePreview)
    implementation(projects.subprojects.projects)
	implementation(projects.subprojects.projectModels)
	implementation(projects.subprojects.gitCore)
	implementation(projects.subprojects.layoutEditor)

    // This is to build the tooling-api-impl project before the app is built
    // So we always copy the latest JAR file to assets
    compileOnly(projects.tooling.impl)

    implementation(projects.logging.logsender)

    // Sentry Android SDK (core + replay for quality configuration)
//  implementation(libs.sentry.core)
//  implementation(libs.sentry.android.core)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    testImplementation(projects.testing.unitTest)
    androidTestImplementation(projects.testing.androidTest)
}
