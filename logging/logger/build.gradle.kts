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


import dev.mutwakil.androidide.plugins.NoDesugarPlugin
import groovy.util.Node

@Suppress("JavaPluginLanguageLevel")
plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("com.vanniktech.maven.publish.base")
    id("kotlin-kapt")
}

apply {
    plugin(NoDesugarPlugin::class.java)
}

description = "AndroidIDE Logging Framework"

dependencies {
    compileOnly(projects.utilities.frameworkStubs)
    kapt(libs.google.auto.service)

    api(libs.logging.logback.core)
    api(libs.tooling.slf4j)
    api(libs.logging.logback.classic) {
        // logback classic depends on upstream logback-core
        // we exclude it and use our own from logback-android
        exclude(group = "ch.qos.logback", module = "logback-core")
    }

    implementation(projects.utilities.buildInfo)

    testImplementation(libs.tests.junit)
    testImplementation(libs.tests.google.truth)
    implementation(kotlin("stdlib-jdk8"))
    implementation(libs.google.auto.service.annotations)

}

afterEvaluate {
    extensions.configure<PublishingExtension>("publishing") {
        publications.withType<MavenPublication>().configureEach {
            pom {
                description.set(project.description)
            }
        }
    }
}

mavenPublishing {
    pom {
        withXml {
            val dependenciesNode = asNode().get("dependencies") as? groovy.util.NodeList
            val dependencies = dependenciesNode?.firstOrNull() as? Node

            dependencies?.children()?.removeIf { node ->
                val dependency = node as Node
                val groupId = dependency.get("groupId") as groovy.util.NodeList
                val artifactId = dependency.get("artifactId") as groovy.util.NodeList

                groupId.text() == "dev.mutwakil.androidide.build" || artifactId.text() == "kotlin-stdlib-jdk8"
            }
        }
    }
}
