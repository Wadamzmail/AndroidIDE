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
    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions{
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

val ktAndroidRepo = "https://github.com/Wadamzmail/kotlin-android"
val ktAndroidVersion = "2.3.255"
val ktAndroidTag = "v${ktAndroidVersion}-10ea4a8"
val ktAndroidJarName = "analysis-api-standalone-embeddable-for-ide-${ktAndroidVersion}-SNAPSHOT.jar"

externalAssets {
    jarDependency("kt-android") {
        configuration = "api"
        source =
            AssetSource.External(
                url = uri("$ktAndroidRepo/releases/download/$ktAndroidTag/$ktAndroidJarName"),
                sha256Checksum = "6bff98cf6b24af82692c0635ccee52640c59dd5e0a8116fa557890e244e6af6d",
            )
    }
}