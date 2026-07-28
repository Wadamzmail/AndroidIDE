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

package dev.mutwakil.androidide.plugins.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction


/**
 * Keywords: [init.gradle, gradle, gradle plugin, initscript, 2.7.1, 8.5.1]
 * This code generates init.gradle script that is reponsible for all project gradle repos and
 * gradle plugin classpath.
 * Generates the Gradle init script for AndroidIDE.
 * This script is also stored at
 * ~/AndroidIDE/app/build/intermediates/assets/debug/mergeDebugAssets/data/common
 *
 * I have replaced itsaky gradle plugin with a local jar.
 */
abstract class GenerateInitScriptTask : DefaultTask() {

  @get:Input
  abstract val downloadVersion: Property<String>

  @get:Input
  abstract val mavenGroupId: Property<String>

  @get:OutputDirectory
  abstract val outputDir: DirectoryProperty

  @TaskAction
  fun generate() {

    val outFile = this.outputDir.file("data/common/androidide.init.gradle")
      .also {
        it.get().asFile.parentFile.mkdirs()
      }

    outFile.get().asFile.bufferedWriter().use {

      it.write(
        """
      initscript {
          repositories {
              
              flatDir {
                    // TODO: issue with dirs requiring two params to work
                    //       when the first one is the only one required,
                    //       second value is just a dummy value
                    dirs '/data/data/dev.mutwakil.androidide/files/home/.androidide/plugin', 'plugin'
              }
              
              // mavenCentral()
              // google()
          }

          dependencies {
              classpath  name: 'androidide-gradle-plugin'
          }
      }
      
      apply plugin: dev.mutwakil.androidide.gradle.AndroidIDEInitScriptPlugin
    """
          .trimIndent()
      )
    }
  }

}