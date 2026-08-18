import dev.mutwakil.androidide.build.config.BuildConfig

plugins {
	id("com.android.library")
	id("kotlin-android")
	id("kotlin-parcelize")
	id("kotlin-kapt")
}

android {
	namespace = "${BuildConfig.PACKAGE_NAME}.projects"
}

kapt {
	arguments {
		arg("eventBusIndex", "${BuildConfig.PACKAGE_NAME}.events.ProjectsApiEventsIndex")
	}
}

dependencies {
	kapt(projects.annotation.processors)
	kapt(libs.google.auto.service)

	api(projects.event.eventbus)
	api(projects.event.eventbusEvents)
	api(projects.subprojects.projectModels)
	api(projects.tooling.api)

	implementation(projects.core.common)
	implementation(projects.logging.logger)
	implementation(projects.utilities.lookup)
	implementation(projects.utilities.shared)
	implementation(projects.java.javacServices)
	implementation(projects.xml.utils)
	api(projects.lsp.indexing)

	implementation(libs.common.io)
	implementation(libs.common.kotlin.coroutines.android)
	implementation(libs.google.auto.service.annotations)
	implementation(libs.google.guava)

	testImplementation(projects.testing.gradleToolingTest)
}
