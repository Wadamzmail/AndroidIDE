package dev.mutwakil.androidide.tooling.impl.util

import dev.mutwakil.androidide.tooling.api.messages.GradleBuildParams
import dev.mutwakil.androidide.tooling.impl.LoggingOutputStream
import dev.mutwakil.androidide.tooling.impl.Main
import dev.mutwakil.androidide.tooling.impl.progress.ForwardingProgressListener
import org.gradle.tooling.ConfigurableLauncher
import org.slf4j.LoggerFactory
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

private val logger = LoggerFactory.getLogger("GradleBuildExts")

fun ConfigurableLauncher<*>.configureFrom(
	buildParams: GradleBuildParams? = null
) {
	val out = LoggingOutputStream()
	setStandardError(out)
	setStandardOutput(out)
	setStandardInput(ByteArrayInputStream("NoOp".toByteArray(StandardCharsets.UTF_8)))
	addProgressListener(ForwardingProgressListener(), Main.progressUpdateTypes())

	Main.client?.also { client ->
		val clientGradleArgs = client.getBuildArguments().get().filter(String::isNotBlank)
		logger.debug("Client Gradle args: {}", clientGradleArgs)
		addArguments(clientGradleArgs)
	}

	if (buildParams != null) {
		val gradleArgs = buildParams.gradleArgs.filter(String::isNotBlank)
		logger.debug("Build Gradle args: {}", gradleArgs)

		val jvmArgs = buildParams.jvmArgs.filter(String::isNotBlank)
		logger.debug("Build JVM args: {}", jvmArgs)

		addArguments(gradleArgs)
		addJvmArguments(jvmArgs)
	}
}