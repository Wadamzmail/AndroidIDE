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

val ktAndroidRepo = "https://github.com/appdevforall/kotlin-android"
val ktAndroidVersion = "2.3.255"
val ktAndroidTag = "v${ktAndroidVersion}-d4599b9"
val ktAndroidJarName = "analysis-api-standalone-embeddable-for-ide-${ktAndroidVersion}-SNAPSHOT.jar"

externalAssets {
    jarDependency("kt-android") {
        configuration = "api"
        source =
            AssetSource.External(
                url = uri("$ktAndroidRepo/releases/download/$ktAndroidTag/$ktAndroidJarName"),
                sha256Checksum = "608263b39cf2297ae684981cd4da8194572d95178dda7623588ecd577461eeca",
            )
    }
}