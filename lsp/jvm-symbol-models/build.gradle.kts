import com.google.protobuf.gradle.id
import dev.mutwakil.androidide.plugins.conf.configureProtoc

plugins {
	id("java-library")
	id("org.jetbrains.kotlin.jvm")
	alias(libs.plugins.protobuf)
}

configureProtoc(protobuf = protobuf, protocVersion = libs.versions.protobuf.asProvider())

protobuf {
	plugins {
		id("kotlin-ext") {
			artifact = "dev.hsbrysk:protoc-gen-kotlin-ext:${libs.versions.protoc.gen.kotlin.ext.get()}:jdk8@jar"
		}
	}
	generateProtoTasks {
		all().forEach { task ->
			task.plugins {
				id("kotlin-ext") {
					outputSubDir = "kotlin"
				}
			}
			task.builtins {
				getByName("java") {
					option("lite")
				}
			}
		}
	}
}

dependencies {
	api(libs.google.protobuf.java)
	api(libs.google.protobuf.kotlin)
}
