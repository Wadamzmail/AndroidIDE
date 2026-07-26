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

package dev.mutwakil.androidide.plugins

import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.Variant
import dev.mutwakil.androidide.build.config.MVN_GROUP_ID
import dev.mutwakil.androidide.build.config.downloadVersion
import dev.mutwakil.androidide.plugins.tasks.AddAndroidJarToAssetsTask
import dev.mutwakil.androidide.plugins.tasks.AddFileToAssetsTask
import dev.mutwakil.androidide.plugins.tasks.GenerateInitScriptTask
import dev.mutwakil.androidide.plugins.tasks.GradleWrapperGeneratorTask
import dev.mutwakil.androidide.plugins.tasks.SetupAapt2Task
import dev.mutwakil.androidide.plugins.util.SdkUtils.getAndroidJar
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.bundling.Jar
import org.gradle.configurationcache.extensions.capitalized
import org.gradle.kotlin.dsl.register

/**
 * Handles asset copying and generation.
 *
 * @author Akash Yadav
 */
class AndroidIDEAssetsPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            val wrapperGeneratorTaskProvider = tasks.register(
                "generateGradleWrapper",
                GradleWrapperGeneratorTask::class.java
            )

            val androidComponentsExtension = extensions.getByType(
                ApplicationAndroidComponentsExtension::class.java
            )

            val setupAapt2TaskTaskProvider =
                tasks.register("setupAapt2", SetupAapt2Task::class.java)

            val addAndroidJarTaskProvider = tasks.register(
                "addAndroidJarToAssets",
                AddAndroidJarToAssetsTask::class.java
            ) {
                androidJar = androidComponentsExtension.getAndroidJar(assertExists = true)
            }

            androidComponentsExtension.onVariants { variant ->

                val variantNameCapitalized = variant.name.capitalized()

                variant.sources.jniLibs?.addGeneratedSourceDirectory(
                    setupAapt2TaskTaskProvider,
                    SetupAapt2Task::outputDirectory
                )

                variant.sources.assets?.addGeneratedSourceDirectory(
                    wrapperGeneratorTaskProvider,
                    GradleWrapperGeneratorTask::outputDirectory
                )

                variant.sources.assets?.addGeneratedSourceDirectory(
                    addAndroidJarTaskProvider,
                    AddAndroidJarToAssetsTask::outputDirectory
                )

                // Init script generator
                val generateInitScript = tasks.register(
                    "generate${variantNameCapitalized}InitScript",
                    GenerateInitScriptTask::class.java
                ) {
                    // mavenGroupId.set(BuildConfig.PACKAGE_NAME)
                    mavenGroupId.set(MVN_GROUP_ID)
                    downloadVersion.set(this@run.downloadVersion)
                }

                variant.sources.assets?.addGeneratedSourceDirectory(
                    generateInitScript,
                    GenerateInitScriptTask::outputDir
                )

                registerAndroidIDEPluginApiJarCopierTask(variant,variantNameCapitalized)

                // Tooling API JAR copier
                val copyToolingApiJar = tasks.register(
                    "copy${variantNameCapitalized}ToolingApiJar",
                    AddFileToAssetsTask::class.java
                ) {
                    val implPath = ":tooling:impl"
                    val toolingApi = checkNotNull(rootProject.findProject(implPath)) {
                        "Cannot find the Tooling Impl module with project path: '$implPath'"
                    }
                    dependsOn(toolingApi.tasks.getByName("copyJar"))

                    val toolingApiJar =
                        toolingApi.layout.buildDirectory.file("libs/tooling-api-all.jar")

                    inputFile.set(toolingApiJar)
                    baseAssetsPath.set("data/common")
                }

                variant.sources.assets?.addGeneratedSourceDirectory(
                    copyToolingApiJar,
                    AddFileToAssetsTask::outputDirectory
                )
            }
        }
    }
}

private fun Project.registerAndroidIDEPluginApiJarCopierTask(
    variant: Variant,
    variantName: String,
) {
    evaluationDependsOn(":tooling:plugin")
    addProjectArtifactToAssets<AddFileToAssetsTask>(
        variant = variant,
        taskName = "copy${variantName}AndroidIDEPluginJar",
        projectPath = ":tooling:plugin",
        projectTask = "jar",
    ) { project ->
        project.tasks.named("jar", Jar::class.java).flatMap { it.archiveFile }
    }
}

private inline fun <reified T : AddFileToAssetsTask> Project.addProjectArtifactToAssets(
    variant: Variant,
    taskName: String,
    projectPath: String,
    projectTask: String,
    baseAssetsPath: String = "data/common",
    crossinline onGetInputFile: (Project) -> Provider<RegularFile>,
) {
    val copyArtifactTask =
        tasks.register<T>(taskName) {
            val project =
                project.rootProject.findProject(projectPath)
                    ?: throw GradleException("Project with path '$projectPath' not found")

            val task = project.tasks.getByName(projectTask)
            dependsOn(task)

            val inputFile = onGetInputFile(project)
            this.inputFile.set(inputFile)
            this.baseAssetsPath.set(baseAssetsPath)
        }

    variant.sources.assets?.addGeneratedSourceDirectory(
        copyArtifactTask,
        AddFileToAssetsTask::outputDirectory,
    )
}