import dev.mutwakil.androidide.build.config.BuildConfig

plugins {
	id("com.android.library")
	id("kotlin-android")
}

android {
	namespace = "${BuildConfig.PACKAGE_NAME}.lsp.indexing"
}

dependencies {
	api(libs.androidx.annotation)
	api(libs.androidx.sqlite.ktx)
	api(libs.androidx.sqlite.framework)
	api(libs.kotlinx.coroutines.core)

	api(projects.logging.logger)

	testImplementation(projects.testing.unitTest)
	testImplementation(libs.tests.kotlinx.coroutines)
}
