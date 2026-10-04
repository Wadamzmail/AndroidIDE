package dev.mutwakil.androidide.tooling.impl

import com.google.common.truth.Truth.assertThat
import dev.mutwakil.androidide.tooling.api.messages.InitializeProjectParams
import dev.mutwakil.androidide.tooling.api.messages.result.InitializeResult
import dev.mutwakil.androidide.tooling.api.messages.result.TaskExecutionResult
import dev.mutwakil.androidide.tooling.api.messages.result.isSuccessful
import dev.mutwakil.androidide.tooling.api.sync.ProjectSyncHelper
import dev.mutwakil.androidide.tooling.impl.sync.RootModelBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.spyk
import io.mockk.unmockkAll
import io.mockk.verify
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.ProjectConnection
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @author Akash Yadav
 */
@RunWith(JUnit4::class)
class ToolingApiServerImplTest {

	private fun testInitParams(
		directory: String = "/does/not/exist",
		forceSync: Boolean = false,
	) = InitializeProjectParams(
		directory = directory, needsGradleSync = forceSync
	)

	private data class MockServer(
		val server: ToolingApiServerImpl,
		val connector: GradleConnector,
		val connection: ProjectConnection
	)
	
	@After
	fun tearDown() {
		// These tests mock singletons. Left in place they follow the JVM into the next test class.
		unmockkAll()
	}

	private fun mockkToolingServer(): MockServer {
		val server = spyk(ToolingApiServerImpl())
		val connector = mockk<GradleConnector>(relaxed = true)
		val connection = mockk<ProjectConnection>(relaxed = true)

		// ensure that we do not start actual Gradle build
		every {
			server.getOrConnectProject(
				projectDir = any(), forceConnect = true, initParams = any(), gradleDist = any()
			)
		} returns (connector to connection)

		return MockServer(server, connector, connection)
	}

	@Test
	fun `GIVEN any initialization params WHEN project init fails THEN report as failure`() {

		mockkObject(RootModelBuilder)
		every {
			// Simulate a Gradle sync failure
			RootModelBuilder.build(
				any(), any()
			)
		} throws RuntimeException("intentional failure")

		val (server) = mockkToolingServer()

		every {
			// ensure we don't fail on non-existent project directory
			server.validateProjectDirectory(any())
		} returns null

		val result = server.initialize(testInitParams()).get(5, TimeUnit.SECONDS)
		assertThat(result).isNotNull()
		assertThat(result.isSuccessful).isFalse()
		assertThat(result).isInstanceOf(InitializeResult.Failure::class.java)

		// unknown error because of the mocked runtime exception
		assertThat((result as InitializeResult.Failure).failure).isEqualTo(TaskExecutionResult.Failure.UNKNOWN)
	}

	@Test
	fun `GIVEN force sync not requested WHEN sync files are unreadable THEN sync anyway`() {

		val initParams = testInitParams(forceSync = false)
		val cacheFile = ProjectSyncHelper.cacheFileForProject(File(initParams.directory))

		mockkObject(RootModelBuilder)
		every {
			// simulate a successful cache write
			RootModelBuilder.build(
				any(), any()
			)
		} returns cacheFile

		mockkObject(ProjectSyncHelper)
		every {
			// simulate unreadable cache files
			ProjectSyncHelper.areSyncFilesReadable(any(), any())
		} returns false

		val (server) = mockkToolingServer()

		every {
			// ensure we don't fail on non-existent project directory
			server.validateProjectDirectory(any())
		} returns null

		val result = server.initialize(initParams).get(5, TimeUnit.SECONDS)
		assertThat(result).isNotNull()
		assertThat(result.isSuccessful).isTrue()
		assertThat(result).isInstanceOf(InitializeResult.Success::class.java)
		assertThat((result as InitializeResult.Success).cacheFile).isEqualTo(cacheFile)

		verify(exactly = 1) {
			// ensure gradle sync was requested
			RootModelBuilder.build(initParams, any())
		}
	}
	
	@Test
	fun `GIVEN readable sync files WHEN the stored schema version is stale THEN sync anyway`() {
		val initParams = testInitParams(forceSync = false)
		val cacheFile = ProjectSyncHelper.cacheFileForProject(File(initParams.directory))

		mockkObject(RootModelBuilder)
		every { RootModelBuilder.build(any(), any()) } returns cacheFile

		mockkObject(ProjectSyncHelper)

		// The overload the server actually calls, so the stub does not ride on internal delegation.
		every { ProjectSyncHelper.areSyncFilesReadable(any<File>()) } returns true
		every { ProjectSyncHelper.areSyncFilesReadable(any(), any()) } returns true

		// The cache is present and readable, and only the stored schema version rules it out.
		every { ProjectSyncHelper.isSyncMetaVersionCurrent(any()) } returns false

		val (server) = mockkToolingServer()
		every { server.validateProjectDirectory(any()) } returns null

		val result = server.initialize(initParams).get(5, TimeUnit.SECONDS)
		assertThat(result).isInstanceOf(InitializeResult.Success::class.java)
		assertThat((result as InitializeResult.Success).cacheFile).isEqualTo(cacheFile)

		verify(exactly = 1) { RootModelBuilder.build(initParams, any()) }
	}
}