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

package dev.mutwakil.androidide.plugins.tasks

import dev.mutwakil.androidide.build.config.FDroidConfig
import dev.mutwakil.androidide.plugins.util.DownloadUtils
import dev.mutwakil.androidide.plugins.util.ELFUtils
import dev.mutwakil.androidide.build.config.isFDroidBuild
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * @author Akash Yadav
 */
abstract class SetupAapt2Task : DefaultTask() {

  /**
   * The output directory.
   */
  @get:OutputDirectory
  abstract val outputDirectory: DirectoryProperty

  companion object {

    private val AAPT2_CHECKSUMS = mapOf(
      "arm64-v8a" to "db737b3bbee99dd8a9e56108cc05d032597874d3f8ac557a69f3c5de5efaf57f",
      "armeabi-v7a" to "ab227d776134dc4837c8dc03f3a6e7f69d856b9518e0d404d159005f21e2b904"
//      "x86_64" to "4861171c1efcffe41f4466937e6a392b243ffb014813b4e60f0b77bb46ab254d"
    )

    private const val DEFAULT_VERSION = "35.0.2"
    private const val AAPT2_DOWNLOAD_URL = "https://github.com/AndroidIDE-Dev/platform-tools/releases/download/v%1\$s/aapt2-%2\$s"

    /**
     * Computes the SHA-256 checksum of the given file, formatted the same way as
     * [DownloadUtils.doDownload] (zero-padded lowercase hex, via BigInteger).
     */
    private fun sha256Of(file: File): String {
      val digest = MessageDigest.getInstance("SHA-256")
      digest.update(file.readBytes())
      var checksum = BigInteger(1, digest.digest()).toString(16)
      while (checksum.length < 64) {
        checksum = "0$checksum"
      }
      return checksum
    }
  }

  @TaskAction
  fun setupAapt2() {

    // When building for F-Droid, simply copy the aapt2 file
    if (project.isFDroidBuild) {
      val arch = FDroidConfig.fDroidBuildArch!!

      val file = outputDirectory.file("${arch}/libaapt2.so").get().asFile

      val aapt2File = requireNotNull(FDroidConfig.aapt2Files[arch]) {
        "F-Droid build is enabled but path to AAPT2 file for $arch is not set."
      }

      val aapt2 = File(aapt2File)

      require(aapt2.exists() && aapt2.isFile) {
        "F-Droid AAPT2 file does not exist or is not a file: $aapt2"
      }

      // Skip re-copying if the existing output already matches the source file's checksum.
      if (file.exists() && file.isFile && sha256Of(file) == sha256Of(aapt2)) {
        logger.info("Existing aapt2 at $file already matches source, skipping copy")
        assertAapt2Arch(file, ELFUtils.ElfAbi.forName(arch)!!)
        return
      }

      file.parentFile.mkdirs()

      logger.info("Copying $aapt2 to $file")
      aapt2.copyTo(file, overwrite = true)
      assertAapt2Arch(file, ELFUtils.ElfAbi.forName(arch)!!)
      return
    }

    // When not building for F-Droid, download aapt2 files from GitHub
    AAPT2_CHECKSUMS.forEach { (arch, checksum) ->
      val file = outputDirectory.file("${arch}/libaapt2.so").get().asFile

      // NOTE: we deliberately do NOT delete `file` or its parent directory here.
      // DownloadUtils.doDownload() already checks whether `file` exists and whether its
      // checksum matches `checksum`; if it matches, it returns immediately without touching
      // the network. Deleting the file beforehand (as the old code did) defeats that check
      // and forces a re-download every time, breaking offline builds.
      val remoteUrl = AAPT2_DOWNLOAD_URL.format(DEFAULT_VERSION, arch)
      DownloadUtils.doDownload(file, remoteUrl, checksum, logger)
      assertAapt2Arch(file, ELFUtils.ElfAbi.forName(arch)!!)
    }
  }

  private fun assertAapt2Arch(aapt2: File, elfAbi: ELFUtils.ElfAbi) {
    val fileAbi = ELFUtils.getElfAbi(aapt2)
    check(fileAbi == elfAbi) {
      "Mismatched ABI for aapt2 binary. Required $elfAbi but found $fileAbi"
    }
  }
}
