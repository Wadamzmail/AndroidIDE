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

package dev.mutwakil.androidide.tooling.impl.progress

import dev.mutwakil.androidide.tooling.events.StatusEvent
import dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationOperationResult.PluginApplicationResult
import dev.mutwakil.androidide.tooling.events.download.FileDownloadFinishEvent
import dev.mutwakil.androidide.tooling.events.download.FileDownloadProgressEvent
import dev.mutwakil.androidide.tooling.events.download.FileDownloadStartEvent
import dev.mutwakil.androidide.tooling.events.internal.DefaultFinishEvent
import dev.mutwakil.androidide.tooling.events.internal.DefaultOperationDescriptor
import dev.mutwakil.androidide.tooling.events.internal.DefaultOperationResult
import dev.mutwakil.androidide.tooling.events.internal.DefaultProgressEvent
import dev.mutwakil.androidide.tooling.events.internal.DefaultStartEvent
import dev.mutwakil.androidide.tooling.events.task.TaskFinishEvent
import dev.mutwakil.androidide.tooling.events.task.TaskProgressEvent
import dev.mutwakil.androidide.tooling.events.task.TaskStartEvent
import dev.mutwakil.androidide.tooling.events.test.TestFinishEvent
import dev.mutwakil.androidide.tooling.events.test.TestOperationResult
import dev.mutwakil.androidide.tooling.events.test.TestProgressEvent
import dev.mutwakil.androidide.tooling.events.test.TestStartEvent
import dev.mutwakil.androidide.tooling.events.transform.TransformFinishEvent
import dev.mutwakil.androidide.tooling.events.transform.TransformOperationDescriptor.SubjectDescriptor
import dev.mutwakil.androidide.tooling.events.transform.TransformOperationResult
import dev.mutwakil.androidide.tooling.events.transform.TransformStartEvent
import dev.mutwakil.androidide.tooling.events.work.WorkItemFinishEvent
import dev.mutwakil.androidide.tooling.events.work.WorkItemOperationResult
import dev.mutwakil.androidide.tooling.events.work.WorkItemProgressEvent
import dev.mutwakil.androidide.tooling.events.work.WorkItemStartEvent
import dev.mutwakil.androidide.tooling.model.PluginIdentifier
import org.gradle.tooling.events.OperationDescriptor
import org.gradle.tooling.events.ProgressEvent
import org.gradle.tooling.events.configuration.ProjectConfigurationFinishEvent
import org.gradle.tooling.events.configuration.ProjectConfigurationOperationDescriptor
import org.gradle.tooling.events.configuration.ProjectConfigurationOperationResult
import org.gradle.tooling.events.configuration.ProjectConfigurationProgressEvent
import org.gradle.tooling.events.configuration.ProjectConfigurationStartEvent
import org.gradle.tooling.events.configuration.ProjectConfigurationSuccessResult
import org.gradle.tooling.events.download.FileDownloadOperationDescriptor
import org.gradle.tooling.events.download.FileDownloadResult
import org.gradle.tooling.events.task.TaskExecutionResult
import org.gradle.tooling.events.task.TaskFailureResult
import org.gradle.tooling.events.task.TaskOperationDescriptor
import org.gradle.tooling.events.task.TaskOperationResult
import org.gradle.tooling.events.task.TaskSkippedResult
import org.gradle.tooling.events.task.TaskSuccessResult
import org.gradle.tooling.events.test.TestOperationDescriptor
import org.gradle.tooling.events.test.TestSuccessResult
import org.gradle.tooling.events.transform.TransformOperationDescriptor
import org.gradle.tooling.events.transform.TransformSuccessResult
import org.gradle.tooling.events.work.WorkItemOperationDescriptor
import org.gradle.tooling.events.work.WorkItemSuccessResult
import org.gradle.tooling.model.ProjectIdentifier

/** @author Akash Yadav */
class EventTransformer {
	companion object {
		// ------------------------ COMMON -------------------------
		private fun operationDescriptor(descriptor: OperationDescriptor?): dev.mutwakil.androidide.tooling.events.OperationDescriptor? =
			when (descriptor) {
				null -> {
					null
				}

				is ProjectConfigurationOperationDescriptor -> {
					projectConfigurationDescriptor(descriptor)
				}

				is FileDownloadOperationDescriptor -> {
					fileDownloadDescriptor(descriptor)
				}

				is TaskOperationDescriptor -> {
					taskDescriptor(descriptor)
				}

				is TransformOperationDescriptor -> {
					transformDescriptor(descriptor)
				}

				is WorkItemOperationDescriptor -> {
					workDescriptor(descriptor)
				}

				else -> {
					DefaultOperationDescriptor(name = descriptor.name, displayName = descriptor.displayName)
				}
			}

	/*
	 * Direct dependencies as task paths only. Converting them to descriptors recursed through the
	 * whole task graph, and JSON copies a shared subtree once per path to it: a single task event
	 * for the CoGo app reached 23.7 MB and ran the IDE's message reader out of heap.
	 */
		private fun dependencyPaths(dependencies: Set<OperationDescriptor?>): Set<String> =
			dependencies.filterNotNull().mapTo(LinkedHashSet()) { dependency ->
				(dependency as? TaskOperationDescriptor)?.taskPath ?: dependency.name
			}

		// ----------------- PROJECT CONFIGURATION --------------------
		@JvmStatic
		fun projectConfigurationStart(
			event: ProjectConfigurationStartEvent,
		): dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationProgressEvent =
			dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationStartEvent(
				displayName = event.displayName,
				eventTime = event.eventTime,
				descriptor = projectConfigurationDescriptor(event.descriptor),
			)

		@JvmStatic
		fun projectConfigurationProgress(
			event: ProjectConfigurationProgressEvent,
		): dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationProgressEvent =
			dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationProgressEvent(
				displayName = event.displayName,
				eventTime = event.eventTime,
				descriptor = projectConfigurationDescriptor(event.descriptor),
			)

		@JvmStatic
		fun projectConfigurationFinish(
			event: ProjectConfigurationFinishEvent,
		): dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationProgressEvent =
			dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationFinishEvent(
				displayName = event.displayName,
				eventTime = event.eventTime,
				descriptor = projectConfigurationDescriptor(event.descriptor),
				result = projectConfigurationResult(event.result),
			)

		private fun projectConfigurationResult(
			result: ProjectConfigurationOperationResult,
		): dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationOperationResult =
			dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationOperationResult(
				pluginApplicationResults =
					result.pluginApplicationResults.map {
						PluginApplicationResult(
							plugin = PluginIdentifier(it.plugin?.displayName ?: "Unknown plugin"),
							it.totalConfigurationTime.toMillis(),
						)
					},
				startTime = result.startTime,
				endTime = result.endTime,
				success = result is ProjectConfigurationSuccessResult,
			)

		private fun projectConfigurationDescriptor(
			descriptor: ProjectConfigurationOperationDescriptor,
		): dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationOperationDescriptor =
			dev.mutwakil.androidide.tooling.events.configuration.ProjectConfigurationOperationDescriptor(
				project = projectIdentifier(descriptor.project),
				name = descriptor.name,
				displayName = descriptor.displayName,
			)

		private fun projectIdentifier(project: ProjectIdentifier): dev.mutwakil.androidide.tooling.model.ProjectIdentifier =
			dev.mutwakil.androidide.tooling.model.ProjectIdentifier(
				projectPath = project.projectPath,
				buildIdentifier =
					dev.mutwakil.androidide.tooling.model
						.BuildIdentifier(project.buildIdentifier.rootDir),
			)

		// ---------------------- FILE DOWNLOAD ---------------------------------
		@JvmStatic
		fun fileDownloadStart(event: org.gradle.tooling.events.download.FileDownloadStartEvent): FileDownloadStartEvent =
			FileDownloadStartEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = fileDownloadDescriptor(event.descriptor),
			)

		@JvmStatic
		fun fileDownloadProgress(event: org.gradle.tooling.events.download.FileDownloadProgressEvent): FileDownloadProgressEvent =
			FileDownloadProgressEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = fileDownloadDescriptor(event.descriptor),
			)

		@JvmStatic
		fun fileDownloadFinish(event: org.gradle.tooling.events.download.FileDownloadFinishEvent): FileDownloadFinishEvent =
			FileDownloadFinishEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = fileDownloadDescriptor(event.descriptor),
				result = fileDownloadResult(event.result),
			)

		private fun fileDownloadResult(result: FileDownloadResult): dev.mutwakil.androidide.tooling.events.download.FileDownloadResult =
			dev.mutwakil.androidide.tooling.events.download.FileDownloadResult(
				bytesDownloaded = result.bytesDownloaded,
				startTime = result.startTime,
				endTime = result.endTime,
			)

		private fun fileDownloadDescriptor(
			descriptor: FileDownloadOperationDescriptor,
		): dev.mutwakil.androidide.tooling.events.download.FileDownloadOperationDescriptor =
			dev.mutwakil.androidide.tooling.events.download.FileDownloadOperationDescriptor(
				descriptor.uri,
				descriptor.name,
				descriptor.displayName,
			)

		// -------------------- TASK -------------------------------
		@JvmStatic
		fun taskStart(event: org.gradle.tooling.events.task.TaskStartEvent): TaskStartEvent =
			TaskStartEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = taskDescriptor(event.descriptor),
			)

		@JvmStatic
		fun taskProgress(event: org.gradle.tooling.events.task.TaskProgressEvent): TaskProgressEvent =
			TaskProgressEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = taskDescriptor(event.descriptor),
			)

		@JvmStatic
		fun taskFinish(event: org.gradle.tooling.events.task.TaskFinishEvent): TaskFinishEvent =
			TaskFinishEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = taskDescriptor(event.descriptor),
				result = taskResult(event.result),
			)

		private fun taskResult(result: TaskOperationResult): dev.mutwakil.androidide.tooling.events.task.TaskOperationResult {
			// The order of conditions must not change here.

			if (result is TaskSuccessResult) {
				return dev.mutwakil.androidide.tooling.events.task.TaskSuccessResult(
					result.isUpToDate,
					result.isFromCache,
					result.startTime,
					result.endTime,
					result.isIncremental,
					result.executionReasons,
				)
			}

			if (result is TaskFailureResult) {
				return dev.mutwakil.androidide.tooling.events.task.TaskFailureResult(
					result.startTime,
					result.endTime,
				)
			}

			if (result is TaskExecutionResult) {
				return dev.mutwakil.androidide.tooling.events.task.TaskExecutionResult(
					result.startTime,
					result.endTime,
					result.isIncremental,
					result.executionReasons,
				)
			}

			if (result is TaskSkippedResult) {
				return dev.mutwakil.androidide.tooling.events.task.TaskSkippedResult(
					result.skipMessage,
					result.startTime,
					result.endTime,
				)
			}

			return dev.mutwakil.androidide.tooling.events.task.TaskOperationResult(
				startTime = result.startTime,
				endTime = result.endTime,
			)
		}

		private fun taskDescriptor(descriptor: TaskOperationDescriptor): dev.mutwakil.androidide.tooling.events.task.TaskOperationDescriptor =
			dev.mutwakil.androidide.tooling.events.task.TaskOperationDescriptor(
				dependencies = dependencyPaths(descriptor.dependencies),
				originPlugin = PluginIdentifier(descriptor.originPlugin?.displayName ?: "Unknown plugin"),
				taskPath = descriptor.taskPath,
				name = descriptor.name,
				displayName = descriptor.displayName,
			)

		// ----------------------- TEST -------------------------
		@JvmStatic
		fun testStart(event: org.gradle.tooling.events.test.TestStartEvent): TestStartEvent =
			TestStartEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				operationDescriptor = testDescriptor(event.descriptor),
			)

		@JvmStatic
		fun testProgress(event: org.gradle.tooling.events.test.TestProgressEvent): TestProgressEvent =
			TestProgressEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = testDescriptor(event.descriptor),
			)

		@JvmStatic
		fun testFinish(event: org.gradle.tooling.events.test.TestFinishEvent): TestFinishEvent =
			TestFinishEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				operationDescriptor = testDescriptor(event.descriptor),
				result = testResult(event.result),
			)

		private fun testResult(result: org.gradle.tooling.events.test.TestOperationResult): TestOperationResult =
			TestOperationResult(
				startTime = result.startTime,
				endTime = result.endTime,
				success = result is TestSuccessResult,
			)

		private fun testDescriptor(descriptor: TestOperationDescriptor): dev.mutwakil.androidide.tooling.events.test.TestOperationDescriptor =
			dev.mutwakil.androidide.tooling.events.test.TestOperationDescriptor(
				name = descriptor.name,
				displayName = descriptor.displayName,
			)

		// ----------------------- TRANSFORM -------------------------
		@JvmStatic
		fun transformStart(event: org.gradle.tooling.events.transform.TransformStartEvent): TransformStartEvent =
			TransformStartEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = transformDescriptor(event.descriptor),
			)

		@JvmStatic
		fun transformProgress(event: org.gradle.tooling.events.transform.TransformProgressEvent): TransformStartEvent =
			TransformStartEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = transformDescriptor(event.descriptor),
			)

		@JvmStatic
		fun transformFinish(event: org.gradle.tooling.events.transform.TransformFinishEvent): TransformFinishEvent =
			TransformFinishEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				operationDescriptor = transformDescriptor(event.descriptor),
				result = transformResult(event.result),
			)

		private fun transformResult(result: org.gradle.tooling.events.transform.TransformOperationResult): TransformOperationResult =
			TransformOperationResult(
				success = result is TransformSuccessResult,
				startTime = result.startTime,
				endTime = result.endTime,
			)

		private fun transformDescriptor(
			descriptor: TransformOperationDescriptor,
		): dev.mutwakil.androidide.tooling.events.transform.TransformOperationDescriptor =
			dev.mutwakil.androidide.tooling.events.transform.TransformOperationDescriptor(
				name = descriptor.name,
				displayName = descriptor.displayName,
				subject = SubjectDescriptor(descriptor.subject.displayName),
				transformer =
					dev.mutwakil.androidide.tooling.events.transform.TransformOperationDescriptor
						.TransformerDescriptor(descriptor.transformer.displayName),
				dependencies = dependencyPaths(descriptor.dependencies),
			)

		// ----------------------- WORK ITEM -------------------------
		@JvmStatic
		fun workStart(event: org.gradle.tooling.events.work.WorkItemStartEvent): WorkItemStartEvent =
			WorkItemStartEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = workDescriptor(event.descriptor),
			)

		@JvmStatic
		fun workProgress(event: org.gradle.tooling.events.work.WorkItemProgressEvent): WorkItemProgressEvent =
			WorkItemProgressEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = workDescriptor(event.descriptor),
			)

		@JvmStatic
		fun workFinish(event: org.gradle.tooling.events.work.WorkItemFinishEvent): WorkItemFinishEvent =
			WorkItemFinishEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				operationDescriptor = workDescriptor(event.descriptor),
				result = workResult(event.result),
			)

		private fun workResult(result: org.gradle.tooling.events.work.WorkItemOperationResult): WorkItemOperationResult =
			WorkItemOperationResult(
				success = result is WorkItemSuccessResult,
				startTime = result.startTime,
				endTime = result.endTime,
			)

		private fun workDescriptor(
			descriptor: WorkItemOperationDescriptor,
		): dev.mutwakil.androidide.tooling.events.work.WorkItemOperationDescriptor =
			dev.mutwakil.androidide.tooling.events.work.WorkItemOperationDescriptor(
				name = descriptor.name,
				displayName = descriptor.displayName,
				className = descriptor.className,
			)

		// ---------------------------- STATUS ---------------------------------
		fun statusEvent(event: org.gradle.tooling.events.StatusEvent): StatusEvent =
			StatusEvent(
				total = event.total,
				progress = event.progress,
				unit = event.unit,
				displayName = event.displayName,
				eventTime = event.eventTime,
				descriptor = operationDescriptor(event.descriptor)!!,
			)

		// ----------------------- DEFAULT ----------------------------------
		fun progress(event: ProgressEvent): dev.mutwakil.androidide.tooling.events.ProgressEvent =
			DefaultProgressEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = operationDescriptor(event.descriptor)!!,
			)

		fun start(event: org.gradle.tooling.events.StartEvent): dev.mutwakil.androidide.tooling.events.ProgressEvent =
			DefaultStartEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = operationDescriptor(event.descriptor)!!,
			)

		fun finish(event: org.gradle.tooling.events.FinishEvent): dev.mutwakil.androidide.tooling.events.ProgressEvent =
			DefaultFinishEvent(
				eventTime = event.eventTime,
				displayName = event.displayName,
				descriptor = operationDescriptor(event.descriptor)!!,
				result = DefaultOperationResult(event.result.startTime, event.result.endTime),
			)
	}
}