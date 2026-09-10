/*
 *  This file is part of AndroidCodeStudio.
 *
 *  AndroidCodeStudio is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidCodeStudio is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidCodeStudio.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.mutwakil.androidide.activities.IdeConfigurations

import dev.mutwakil.androidide.IDEprovider.IDEProvider as IDELibProvider
import dev.mutwakil.androidide.ideprovider.models.IDEConfig
import dev.mutwakil.androidide.ideprovider.utils.DownloadCallback
import dev.mutwakil.androidide.utils.Environment
import java.io.File
import kotlinx.coroutines.runBlocking

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 *
 * Interface reflection for AndroidIDE (Android Code Studio Build System Provider) Powered by the AndroidIDE
 * library
 */
object IdeCommandInterface {

  /** IDR download directory */
  private val IDE_DOWNLOAD_DIR = File("${Environment.HOME}/androidide")
  private val IDE_TEMP_DIR = File("${Environment.TMP_DIR}")

  /** Lazy initialization of AndroidIDE library provider */
  private val ideLibProvider: IDELibProvider by lazy {
    IDELibProvider(downloadDir = IDE_DOWNLOAD_DIR, tempDir = IDE_TEMP_DIR, enableLogging = false)
  }

  /** Supported architectures for AndroidIDE packages */
  enum class Architecture(val value: String) {
    ARM64_V8A("arm64-v8a"),
    X86_64("x86_64"),
    ARM_V7A("armeabi-v7a"),
  }

  /** Available fields that can be retrieved from manifest */
  enum class ManifestField(val value: String) {
    VERSION("version"),
    URL("url"),
    FILENAME("filename"),
    SHA256("sha256"),
  }

  /** Result wrapper for AndroidIDE command execution */
  data class IdeResult(
      val success: Boolean,
      val output: String,
      val errorOutput: String,
      val exitCode: Int,
  )

  /** Package information from manifest */
  data class PackageInfo(
      val id: String,
      val architecture: String,
      val version: String,
      val filename: String,
      val url: String,
      val sha256: String,
  )

  /** AndroidIDE command builder for fluent API */
  class IdeCommandBuilder {
    private var manifestUrl: String? = null
    private var architecture: Architecture? = null
    private var packageId: String? = null
    private var version: String? = null
    private var field: ManifestField? = null
    private var directUrl: String? = null
    private var shouldDownload: Boolean = false
    private var shouldListVersions: Boolean = false
    private var shouldShowHelp: Boolean = false

    fun readFrom(manifestUrl: String): IdeCommandBuilder {
      this.manifestUrl = manifestUrl
      return this
    }

    fun getForArch(architecture: Architecture): IdeCommandBuilder {
      this.architecture = architecture
      return this
    }

    fun getField(field: ManifestField): IdeCommandBuilder {
      this.field = field
      return this
    }

    fun withPackageId(packageId: String): IdeCommandBuilder {
      this.packageId = packageId
      return this
    }

    fun withVersion(version: String): IdeCommandBuilder {
      this.version = version
      return this
    }

    fun listVersions(): IdeCommandBuilder {
      this.shouldListVersions = true
      return this
    }

    fun downloadFromUrl(url: String): IdeCommandBuilder {
      this.directUrl = url
      return this
    }

    fun enableDownload(): IdeCommandBuilder {
      this.shouldDownload = true
      return this
    }

    fun showHelp(): IdeCommandBuilder {
      this.shouldShowHelp = true
      return this
    }

    /** Execute the built command */
    fun execute(): IdeResult {
      return try {
        if (shouldShowHelp) {
          return IdeResult(success = true, output = getHelpText(), errorOutput = "", exitCode = 0)
        }

        if (shouldListVersions) {
          return executeListVersions()
        }

        if (shouldDownload) {
          return executeDownload()
        }

        if (field != null) {
          return executeGetField()
        }

        if (directUrl != null) {
          return IdeResult(success = true, output = directUrl!!, errorOutput = "", exitCode = 0)
        }

        IdeResult(
            success = false,
            output = "",
            errorOutput = "No valid operation specified",
            exitCode = 1,
        )
      } catch (e: Exception) {
        IdeResult(success = false, output = "", errorOutput = "Error: ${e.message}", exitCode = 1)
      }
    }

    private fun executeListVersions(): IdeResult {
      return runBlocking {
        try {
          val jsonContent = ideLibProvider.downloadJson(manifestUrl!!, silent = true)
          val versions =
              ideLibProvider.listAvailableVersions(jsonContent, architecture!!.value, packageId)

          val output =
              if (versions.isEmpty()) {
                "No versions found for the specified criteria"
              } else {
                "Available versions:\n" + versions.joinToString("\n") { "  $it" }
              }

          IdeResult(success = true, output = output, errorOutput = "", exitCode = 0)
        } catch (e: Exception) {
          IdeResult(success = false, output = "", errorOutput = "Error: ${e.message}", exitCode = 1)
        }
      }
    }

    private fun executeDownload(): IdeResult {
      return runBlocking {
        try {
          val config =
              IDEConfig(
                  jsonUrl = manifestUrl,
                  architecture = architecture!!.value,
                  packageId = packageId,
                  version = version,
                  directUrl = directUrl,
                  shouldDownload = true,
              )

          val file =
              ideLibProvider.downloadPackage(
                  config,
                  object : DownloadCallback {
                    override fun onProgress(
                        bytesDownloaded: Long,
                        totalBytes: Long,
                        percentage: Int,
                    ) {
                      // Progress callback - could be used to update UI
                    }

                    override fun onComplete(file: File) {
                      // Download complete
                    }

                    override fun onError(error: Throwable) {
                      // Error during download
                    }
                  },
              )

          IdeResult(
              success = true,
              output = "Successfully downloaded: ${file.absolutePath}",
              errorOutput = "",
              exitCode = 0,
          )
        } catch (e: Exception) {
          IdeResult(success = false, output = "", errorOutput = "Error: ${e.message}", exitCode = 1)
        }
      }
    }

    private fun executeGetField(): IdeResult {
      return runBlocking {
        try {
          val config =
              IDEConfig(
                  jsonUrl = manifestUrl!!,
                  architecture = architecture!!.value,
                  packageId = packageId,
                  version = version,
                  getField = field!!.value,
              )

          val fieldValue = ideLibProvider.getField(config)

          IdeResult(success = true, output = fieldValue, errorOutput = "", exitCode = 0)
        } catch (e: Exception) {
          IdeResult(success = false, output = "", errorOutput = "Error: ${e.message}", exitCode = 1)
        }
      }
    }

    private fun getHelpText(): String {
      return """
               Android Code Studio Build System Provider - Download and manage build system packages

               Usage: ide [OPTIONS]

               Options:
                 -r, --read-from <url>     JSON manifest URL to read from
                 -a, --get-for <arch>      Architecture to get (e.g., arm64-v8a, x86_64)
                 -f, --get <field>         Field to retrieve (e.g., version, url, filename)
                 -i, --id <package_id>     Package ID to filter by (e.g., android-native-kit)
                 -v, --version <version>   Specific version to get (e.g., 28.2.13676358)
                 -l, --list-versions       List all available versions for given architecture and ID
                     --get <url>           Direct URL to download
                 -d, --download            Download the file and verify checksum
                 -h, --help                Show this help message

               Examples:
                 # List available versions for android-native-kit on arm64-v8a
                 ide -r https://example.com/manifest.json --get-for arm64-v8a -i android-native-kit --list-versions

                 # Get version for specific package and version
                 ide -r https://example.com/manifest.json --get-for arm64-v8a -i android-native-kit -v 28.2.13676358 -f version

                 # Download specific version of package
                 ide -r https://example.com/manifest.json --get-for arm64-v8a -i android-native-kit -v 29.0.14033849 --download
             """
                 .trimIndent()
    }

    /** Get the command arguments as array (for compatibility) */
    fun buildArgs(): Array<String> {
      val args = mutableListOf<String>()
      manifestUrl?.let { args.addAll(listOf("-r", it)) }
      architecture?.let { args.addAll(listOf("-a", it.value)) }
      field?.let { args.addAll(listOf("-f", it.value)) }
      packageId?.let { args.addAll(listOf("-i", it)) }
      version?.let { args.addAll(listOf("-v", it)) }
      if (shouldListVersions) args.add("--list-versions")
      directUrl?.let { args.addAll(listOf("--get", it)) }
      if (shouldDownload) args.add("-d")
      if (shouldShowHelp) args.add("-h")
      return args.toTypedArray()
    }
  }

  /** Create a new IDE command builder */
  fun newCommand(): IdeCommandBuilder = IdeCommandBuilder()

  /** List available versions for a package */
  fun listVersions(manifestUrl: String, architecture: Architecture, packageId: String): IdeResult {
    return newCommand()
        .readFrom(manifestUrl)
        .getForArch(architecture)
        .withPackageId(packageId)
        .listVersions()
        .execute()
  }

  /** Get specific field value for a package */
  fun getPackageField(
      manifestUrl: String,
      architecture: Architecture,
      packageId: String,
      field: ManifestField,
      version: String? = null,
  ): IdeResult {
    val command =
        newCommand()
            .readFrom(manifestUrl)
            .getForArch(architecture)
            .withPackageId(packageId)
            .getField(field)

    version?.let { command.withVersion(it) }

    return command.execute()
  }

  /** Download a package with verification */
  fun downloadPackage(
      manifestUrl: String,
      architecture: Architecture,
      packageId: String,
      version: String? = null,
  ): IdeResult {
    val command =
        newCommand()
            .readFrom(manifestUrl)
            .getForArch(architecture)
            .withPackageId(packageId)
            .enableDownload()

    version?.let { command.withVersion(it) }

    return command.execute()
  }

  /** Download directly from URL */
  fun downloadFromUrl(url: String): IdeResult {
    return newCommand().downloadFromUrl(url).enableDownload().execute()
  }

  /** Check if IDE is available (library is always available) */
  fun isIdeAvailable(): Boolean {
    return try {
      IDE_DOWNLOAD_DIR.exists() || IDE_DOWNLOAD_DIR.mkdirs()
    } catch (e: Exception) {
      false
    }
  }

  /** Get IDE help output */
  fun getHelp(): IdeResult {
    return newCommand().showHelp().execute()
  }
}

/** Updated IdeProvider using the new command interface */
object IdeProvider {

  const val REPO_HOST = "github.com"
  const val REPO_OWNER = "AndroidCSOfficial"
  const val REPO_NAME = "android-code-studio"
  const val IDE_BUILD_SYSTEM_REPONAME = "ide-build-system"
  const val IDE_BUILD_SYSTEM_REPOURL = "https://$REPO_HOST/$REPO_OWNER/$IDE_BUILD_SYSTEM_REPONAME"

  /** Manifest url getter function */
  val getManifestUrl: String = "${IDE_BUILD_SYSTEM_REPOURL}/raw/refs/heads/main/ide-manifest.json"

  /** Enhanced IDE runner with proper command interface */
  fun ideRunner(
      packageId: String,
      artifactVersion: String? = null,
      arch: IdeCommandInterface.Architecture,
  ): IdeCommandInterface.IdeResult {
    return if (artifactVersion != null) {
      IdeCommandInterface.downloadPackage(
          manifestUrl = getManifestUrl,
          architecture = arch,
          packageId = packageId,
          version = artifactVersion,
      )
    } else {
      IdeCommandInterface.downloadPackage(
          manifestUrl = getManifestUrl,
          architecture = arch,
          packageId = packageId,
      )
    }
  }

  /** List available versions for a package */
  fun listAvailableVersions(
      packageId: String,
      arch: IdeCommandInterface.Architecture,
  ): IdeCommandInterface.IdeResult {
    return IdeCommandInterface.listVersions(
        manifestUrl = getManifestUrl,
        architecture = arch,
        packageId = packageId,
    )
  }

  /** Get package version information */
  fun getPackageVersion(
      packageId: String,
      arch: IdeCommandInterface.Architecture,
      version: String? = null,
  ): IdeCommandInterface.IdeResult {
    return IdeCommandInterface.getPackageField(
        manifestUrl = getManifestUrl,
        architecture = arch,
        packageId = packageId,
        field = IdeCommandInterface.ManifestField.VERSION,
        version = version,
    )
  }

  /** Get package URL */
  fun getPackageUrl(
      packageId: String,
      arch: IdeCommandInterface.Architecture,
      version: String? = null,
  ): IdeCommandInterface.IdeResult {
    return IdeCommandInterface.getPackageField(
        manifestUrl = getManifestUrl,
        architecture = arch,
        packageId = packageId,
        field = IdeCommandInterface.ManifestField.URL,
        version = version,
    )
  }
}