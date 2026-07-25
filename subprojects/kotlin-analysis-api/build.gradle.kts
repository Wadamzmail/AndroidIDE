import dev.mutwakil.androidide.build.config.BuildConfig
import dev.mutwakil.androidide.plugins.extension.AssetSource

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dev.mutwakil.androidide.build.external-assets")
}

android {
    namespace = "${BuildConfig.PACKAGE_NAME}.kt.analysis"
    compileSdk = 36
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

val ktAndroidRepo = "https://github.com/AndroidIDE-Dev/kotlin-android"
val ktAndroidVersion = "2.3.255"
val ktAndroidTag = "v${ktAndroidVersion}-d9775f9"
val ktAndroidJarName = "analysis-api-standalone-embeddable-for-ide-${ktAndroidVersion}-SNAPSHOT.jar"

externalAssets {
    jarDependency("kt-android") {
        configuration = "api"
        source =
            AssetSource.External(
                url = uri("$ktAndroidRepo/releases/download/$ktAndroidTag/$ktAndroidJarName"),
                sha256Checksum = "2d2e819bca1c966725296a0f22ebc02d2b41397615dc79e97f26d5fec8d79b8e",
            )
    }
}