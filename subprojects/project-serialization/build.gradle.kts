plugins {
	id("java-library")
	alias(libs.plugins.kotlin.jvm)
}

dependencies {
	api(projects.tooling.builderModelImpl)
	api(projects.subprojects.projectModels)
}
