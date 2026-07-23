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

import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  `kotlin-dsl`
}

repositories {
  google()
  gradlePluginPortal()
  mavenCentral()
}

tasks.withType<KotlinCompile> {
  compilerOptions {
    jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
  }
}

dependencies {
  implementation(projects.buildLogic.common)
  implementation(projects.buildLogic.desugaring)
  implementation(projects.buildLogic.propertiesParser)

  implementation("com.android.tools.build:gradle:${libs.versions.agp.asProvider().get()}")
  implementation(libs.maven.publish)

  implementation(libs.common.jkotlin)
  implementation(libs.common.antlr4)
  implementation(libs.google.gson)
  implementation(libs.google.java.format)
  implementation(libs.google.protobuf.gradle)
}

gradlePlugin {
  plugins {
    create("dev.mutwakil.androidide.build") {
      id = "dev.mutwakil.androidide.build"
      implementationClass = "dev.mutwakil.androidide.plugins.AndroidIDEPlugin"
    }
    create("dev.mutwakil.androidide.core-app") {
      id = "dev.mutwakil.androidide.core-app"
      implementationClass = "dev.mutwakil.androidide.plugins.AndroidIDECoreAppPlugin"
    }
    create("dev.mutwakil.androidide.build.propsparser") {
      id = "dev.mutwakil.androidide.build.propsparser"
      implementationClass = "dev.mutwakil.androidide.plugins.PropertiesParserPlugin"
    }
    create("dev.mutwakil.androidide.build.lexergenerator") {
      id = "dev.mutwakil.androidide.build.lexergenerator"
      implementationClass = "dev.mutwakil.androidide.plugins.LexerGeneratorPlugin"
    }
    create("dev.mutwakil.androidide.build.external-assets") {
      id = "dev.mutwakil.androidide.build.external-assets"
      implementationClass = "dev.mutwakil.androidide.plugins.ExternalAssetsPlugin"
    }
  }
}

tasks.withType<KotlinCompile> {
  compilerOptions {
    apiVersion.set(KotlinVersion.KOTLIN_2_1)
    languageVersion.set(KotlinVersion.KOTLIN_2_1)
    jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    compilerOptions.freeCompilerArgs.add("-Xuse-fir-lt=false")
  }
}
