import dev.mutwakil.androidide.build.config.BuildConfig
import java.util.zip.ZipFile

plugins {
    id("com.android.library")
    id("kotlin-android")
    alias(libs.plugins.kotlin.compose)
}

val composeVersion = "1.11.2"
val material3Version = "1.4.0"
val composeCompilerVersion = "2.3.21"

val composeCompilerJars: Configuration by configurations.creating {
    isTransitive = false
}

val composeAarsForPreview: Configuration by configurations.creating {
    isTransitive = false
}

dependencies {

    composeCompilerJars("org.jetbrains.kotlin:kotlin-compose-compiler-plugin-embeddable:$composeCompilerVersion")

    composeAarsForPreview("androidx.compose.runtime:runtime-android:$composeVersion")
    composeAarsForPreview("androidx.compose.ui:ui-android:$composeVersion")
    composeAarsForPreview("androidx.compose.ui:ui-graphics-android:$composeVersion")
    composeAarsForPreview("androidx.compose.ui:ui-text-android:$composeVersion")
    composeAarsForPreview("androidx.compose.ui:ui-unit-android:$composeVersion")
    composeAarsForPreview("androidx.compose.ui:ui-geometry-android:$composeVersion")
    composeAarsForPreview("androidx.compose.animation:animation-android:$composeVersion")
    composeAarsForPreview("androidx.compose.animation:animation-core-android:$composeVersion")
    composeAarsForPreview("androidx.compose.foundation:foundation-android:$composeVersion")
    composeAarsForPreview("androidx.compose.foundation:foundation-layout-android:$composeVersion")
    composeAarsForPreview("androidx.compose.material3:material3-android:$material3Version")
    composeAarsForPreview("androidx.compose.ui:ui-tooling-preview-android:$composeVersion")
    composeAarsForPreview("androidx.activity:activity-compose:1.12.4")
    composeAarsForPreview("androidx.activity:activity-ktx:1.12.4")
    composeAarsForPreview("androidx.activity:activity:1.12.4")
    composeAarsForPreview("androidx.lifecycle:lifecycle-runtime:2.10.0")
    composeAarsForPreview("androidx.lifecycle:lifecycle-common:2.10.0")
    composeAarsForPreview("androidx.lifecycle:lifecycle-viewmodel:2.10.0")
    composeAarsForPreview("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.10.0")
    composeAarsForPreview("androidx.savedstate:savedstate:1.5.0")
    composeAarsForPreview("androidx.core:core:1.18.0")
    composeAarsForPreview("androidx.core:core-ktx:1.18.0")
    composeAarsForPreview("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.11.0")
    composeAarsForPreview("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")
}

val copyComposeCompilerPlugin by tasks.registering(Copy::class) {
    from(composeCompilerJars)
    into(layout.buildDirectory.dir("compose-jars"))

    rename { originalName ->
        when {
            originalName.startsWith("kotlin-compose-compiler-plugin-embeddable-") -> "compose-compiler-plugin.jar"
            else -> originalName
        }
    }
}

val extractComposeClasses by tasks.registering {
    dependsOn(copyComposeCompilerPlugin)

    val outputDir = layout.buildDirectory.dir("compose-jars")

    doLast {
        val outDir = outputDir.get().asFile
        outDir.mkdirs()

        composeAarsForPreview.files.forEach { file ->
            when {
                file.name.endsWith(".aar") -> {
                    ZipFile(file).use { aar ->
                        val classesEntry = aar.getEntry("classes.jar")
                        if (classesEntry != null) {
                            val targetName = file.nameWithoutExtension + ".jar"
                            val targetFile = File(outDir, targetName)
                            aar.getInputStream(classesEntry).use { input ->
                                targetFile.outputStream().use { output ->
                                    input.copyTo(output)
                                }
                            }
                            println("Extracted classes.jar from ${file.name} -> $targetName")
                        }
                    }
                }
                file.name.endsWith(".jar") -> {
                    val targetFile = File(outDir, file.name)
                    file.copyTo(targetFile, overwrite = true)
                    println("Copied JAR: ${file.name}")
                }
            }
        }
    }
}

fun resolveD8Jar(): File {
    val buildToolsDir = File(android.sdkDirectory, "build-tools")
    return buildToolsDir.listFiles()
        ?.filter { it.isDirectory }
        ?.sortedByDescending { it.name }
        ?.firstNotNullOfOrNull { File(it, "lib/d8.jar").takeIf { jar -> jar.exists() } }
        ?: throw GradleException("D8 jar not found in $buildToolsDir")
}

fun resolveAndroidJar(): File {
    val platformsDir = File(android.sdkDirectory, "platforms")
    return platformsDir.listFiles()
        ?.filter { it.isDirectory }
        ?.sortedByDescending { it.name }
        ?.firstNotNullOfOrNull { File(it, "android.jar").takeIf { jar -> jar.exists() } }
        ?: throw GradleException("android.jar not found in $platformsDir")
}

val compileRuntimeDex by tasks.registering {
    dependsOn(extractComposeClasses)

    val jarsDir = layout.buildDirectory.dir("compose-jars")
    val dexOutputDir = layout.buildDirectory.dir("compose-jars/dex")

    doLast {
        val outDir = dexOutputDir.get().asFile.apply { mkdirs() }
        val runtimeJars = jarsDir.get().asFile.listFiles { file: File ->
            file.extension == "jar" && file.name != "compose-compiler-plugin.jar"
        }?.toList() ?: throw GradleException("No runtime JARs found to compile to DEX")

        project.javaexec {
            classpath = files(resolveD8Jar())
            mainClass.set("com.android.tools.r8.D8")
            maxHeapSize = "1g"
            args = buildList {
                add("--release")
                add("--min-api"); add("21")
                add("--lib"); add(resolveAndroidJar().absolutePath)
                add("--output"); add(outDir.absolutePath)
                runtimeJars.forEach { add(it.absolutePath) }
            }
        }

        File(outDir, "classes.dex").let {
            if (it.exists()) it.renameTo(File(outDir, "compose-runtime.dex"))
        }
    }
}

val packageComposeJars by tasks.registering(Zip::class) {
    dependsOn(compileRuntimeDex)

    from(layout.buildDirectory.dir("compose-jars"))
    archiveFileName.set("compose-jars.zip")
    destinationDirectory.set(file("src/main/assets/compose"))

    doFirst {
        file("src/main/assets/compose").mkdirs()
    }
}

tasks.named("preBuild") {
    dependsOn(packageComposeJars)
}

android {
    namespace = "${BuildConfig.PACKAGE_NAME}.compose.preview"

    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.runtime)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.common.kotlin.coroutines.android)

    implementation(projects.core.common)
    implementation(projects.editor.impl)
    implementation(projects.editor.api)
    implementation(projects.core.resources)
    implementation(projects.logging.logger)
    implementation(projects.subprojects.projects)
}
