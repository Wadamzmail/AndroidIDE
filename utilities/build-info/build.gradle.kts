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


import com.android.SdkConstants
import dev.mutwakil.androidide.build.config.AGP_VERSION_MINIMUM
import dev.mutwakil.androidide.build.config.BuildConfig
import dev.mutwakil.androidide.build.config.CI
import dev.mutwakil.androidide.build.config.FDroidConfig
import dev.mutwakil.androidide.build.config.MVN_GROUP_ID
import dev.mutwakil.androidide.build.config.ProjectConfig
import dev.mutwakil.androidide.build.config.VersionUtils
import dev.mutwakil.androidide.build.config.downloadVersion
import dev.mutwakil.androidide.build.config.publishingVersion
import dev.mutwakil.androidide.build.config.replaceContents
import dev.mutwakil.androidide.build.config.simpleVersionName

plugins {
  //noinspection JavaPluginLanguageLevel
  id("java-library")
  id("com.vanniktech.maven.publish.base")
}

description = "Information about the AndroidIDE build"

val buildInfoGenDir: Provider<Directory> = project.layout.buildDirectory.dir("generated/buildInfo")
  .also { 
    val dir = it.get().asFile
    if (!dir.exists()) {
      dir.mkdirs()
    }
  }

sourceSets { getByName("main").java.srcDir(buildInfoGenDir) }

tasks.create("generateBuildInfo") {
  val buildInfoPath = "dev/mutwakil/androidide/buildinfo/BuildInfo.java"
  val buildInfo = buildInfoGenDir.get().file(buildInfoPath)
  val buildInfoIn = project.file("src/main/java/${buildInfoPath}.in")

  doLast {
    buildInfoIn.replaceContents(
      dest = buildInfo.asFile,
      comment = "//",
      candidates =
      arrayOf(
        "INTERNAL_NAME" to BuildConfig.INTERNAL_NAME,
        "PACKAGE_NAME" to BuildConfig.PACKAGE_NAME,
        "MVN_GROUP_ID" to MVN_GROUP_ID,

        "VERSION_NAME" to rootProject.version.toString(),
        "VERSION_NAME_SIMPLE" to rootProject.simpleVersionName,
        "VERSION_NAME_PUBLISHING" to rootProject.publishingVersion,
        "VERSION_NAME_DOWNLOAD" to rootProject.downloadVersion,

        "FDROID_BUILD" to FDroidConfig.isFDroidBuild.toString(),
        "FDROID_BUILD_VERSION_NAME" to (FDroidConfig.fDroidVersionName ?: "null"),
        "FDROID_BUILD_VERSION_CODE" to (FDroidConfig.fDroidVersionCode ?: -1).toString(),

        "CI_BUILD" to CI.isCiBuild.toString(),
        "CI_GIT_BRANCH" to if (CI.isGitRepo) CI.branchName else "NOT-A-GIT-REPO",
        "CI_COMMIT_HASH" to if (CI.isGitRepo) CI.commitHash else "NOT-A-GIT-REPO",

        "REPO_HOST" to ProjectConfig.REPO_HOST,
        "REPO_OWNER" to ProjectConfig.REPO_OWNER,
        "REPO_NAME" to ProjectConfig.REPO_NAME,
        "PROJECT_SITE" to ProjectConfig.PROJECT_SITE,

        "AGP_VERSION_MININUM" to AGP_VERSION_MINIMUM,
        "AGP_VERSION_LATEST" to libs.versions.agp.tooling.get(),
        "AGP_VERSION_GRADLE_LATEST" to "9.7.0", //TODO: uncomment it after updating project AGP SdkConstants.GRADLE_LATEST_VERSION,

        "SNAPSHOTS_REPOSITORY" to VersionUtils.SONATYPE_SNAPSHOTS_REPO,
        "PUBLIC_REPOSITORY" to VersionUtils.SONATYPE_PUBLIC_REPO,
      )
    )
  }
}

tasks.withType<JavaCompile> { dependsOn("generateBuildInfo") }
tasks.withType<Jar> { dependsOn("generateBuildInfo") }

afterEvaluate {
  extensions.configure<PublishingExtension>("publishing") {
    publications.withType<MavenPublication>().configureEach {
      pom {
        description.set(project.description)
      }
    }
  }
}