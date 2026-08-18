package dev.mutwakil.androidide.tooling.impl.serial

import dev.mutwakil.androidide.project.AndroidModels
import dev.mutwakil.androidide.project.GradleModels
import dev.mutwakil.androidide.project.GradleProject
import dev.mutwakil.androidide.project.GradleTask
import dev.mutwakil.androidide.project.JavaModels
import org.gradle.tooling.model.GradleProject
import org.gradle.tooling.model.GradleTask

fun GradleProject.asProtoModel(
    androidProject: AndroidModels.AndroidProject? = null,
    javaProject: JavaModels.JavaProject? = null,
): GradleModels.GradleProject =
    GradleProject(
        name = this.name,
        description = this.description,
        path = this.path,
        projectDirPath = projectDirectory.absolutePath,
        buildDirPath = buildDirectory.absolutePath,
        buildScriptPath = buildScript.sourceFile.absolutePath,
        taskList = tasks.map { task -> task.asProtoModel() },
        androidProject = androidProject,
        javaProject = javaProject,
    )

fun GradleTask.asProtoModel() =
    GradleTask(
        name = this.name,
        path = this.path,
        isPublic = this.isPublic,
        group = this.group,
        description = this.description,
        displayName = this.displayName,
        projectPath = this.project.path,
    )