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

package dev.mutwakil.androidide.plugins.util

import org.gradle.api.GradleException
import org.gradle.api.logging.Logger
import java.io.File
import java.math.BigInteger
import java.net.HttpURLConnection
import java.net.URL
import java.security.DigestInputStream
import java.security.MessageDigest

/**
 * @author Akash Yadav
 */
object DownloadUtils {

  /**
   * Download the file from the given [url] to the [destination] file. Use [sha256Checksum] to verify
   * file integrity.
   */
  fun downloadFile(
    url: URL,
    destination: File,
    sha256Checksum: String,
    logger: Logger
  ) {
    val digest = MessageDigest.getInstance("SHA-256")

    if (destination.exists()) {
      if (destination.isFile) {
        if (digest.sha256(destination) == sha256Checksum) {
          logger.info("File {} already exists and has not been tampered.", destination)
          return
        }

        logger.quiet("Checksum mismatch. Deleting {}.", destination)
        destination.delete()
      } else {
        destination.deleteRecursively()
      }
    }

    logger.quiet("Downloading {} to {}.", url, destination)

    val connection = url.openConnection() as HttpURLConnection
    connection.instanceFollowRedirects = true

    val digestStream = DigestInputStream(connection.inputStream, digest)
    digestStream.use { input ->
      destination.outputStream().use { output ->
        input.copyTo(output)
      }
    }

    var checksum = BigInteger(1, digest.digest()).toString(16)
    if (checksum.length < 64) {
      checksum = "0".repeat(64 - checksum.length) + checksum
    }

    if (checksum != sha256Checksum) {
      logger.error("Checksum mismatch. expected={} actual={}.", sha256Checksum, checksum)
      throw GradleException("Unable to download file $url. Checksum mismatch. expected=$sha256Checksum actual=$checksum.")
    }
  }
  /**
   * Download the file at given [URL][remoteUrl] to the given [local file][file] and verify the
   * SHA-256 checksum of the downloaded file with the [expected checksum][expectedChecksum].
   */
  fun doDownload(
    file: File,
    remoteUrl: String,
    expectedChecksum: String,
    logger: Logger
  ) {

    logger.info("Download $remoteUrl to $file having checksum ${expectedChecksum}...")

    val digest = MessageDigest.getInstance("SHA-256")

    if (file.exists()) {
      logger.debug("{} already exists. Checking checksum...", file)

      digest.update(file.readBytes())
      var checksum = BigInteger(1, digest.digest()).toString(16)
      while (checksum.length < 64) {
        checksum = "0$checksum"
      }

      if (checksum == expectedChecksum) {
        logger.info("$file is already downloaded and valid. Skipping download.")
        return
      } else {
        logger.info(
          "Deleting old $file with invalid checksum: $checksum expected: $expectedChecksum")
        file.delete()
      }
    }

    logger.info("File does not exist. Downloading ${remoteUrl}...")

    file.parentFile.mkdirs()

    val connection = URL(remoteUrl).openConnection() as HttpURLConnection
    connection.instanceFollowRedirects = true

    file.outputStream().buffered().use { out ->
      DigestInputStream(connection.inputStream, digest).transferTo(out)
      out.flush()
    }

    var checksum = BigInteger(1, digest.digest()).toString(16)
    while (checksum.length < 64) {
      checksum = "0$checksum"
    }

    if (checksum != expectedChecksum) {
      file.delete()
      throw GradleException(
        "Wrong checksum for $remoteUrl: expected: $expectedChecksum, actual: $checksum")
    }
  }
}