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
package dev.mutwakil.androidide.handlers.system.installer

import android.util.Log
import dev.mutwakil.androidide.utils.Environment
import java.io.BufferedInputStream
import java.io.File
import java.io.IOException
import java.io.InputStream

/**
 * Installer for packages downloaded by ACS provider.
 *
 * Detects archives using their magic bytes rather than relying on
 * the file extension.
 *
 * Supported formats:
 * - TAR
 * - ZIP
 * - XZ
 * - GZIP
 * - BZIP2
 *
 * TAR archives compressed with XZ/GZIP/BZIP2 are extracted using
 * the tar binary available in Environment.BIN_DIR.
 */
class IPackageInstaller {

  companion object {
    private const val TAG = "IPackageInstaller"

    private const val TYPE_UNKNOWN = 0
    private const val TYPE_TAR = 1
    private const val TYPE_ZIP = 2
    private const val TYPE_XZ = 3
    private const val TYPE_GZIP = 4
    private const val TYPE_BZIP2 = 5

    private const val XZ_1 = 0xFD
    private const val XZ_2 = 0x37
    private const val XZ_3 = 0x7A
    private const val XZ_4 = 0x58
    private const val XZ_5 = 0x5A
    private const val XZ_6 = 0x00

    private const val GZIP_1 = 0x1F
    private const val GZIP_2 = 0x8B

    private const val BZIP2_1 = 0x42 // B
    private const val BZIP2_2 = 0x5A // Z
    private const val BZIP2_3 = 0x68 // h

    private const val ZIP_1 = 0x50 // P
    private const val ZIP_2 = 0x4B // K
    private const val ZIP_3 = 0x03
    private const val ZIP_4 = 0x04
  }

  enum class ArchiveType {
    TAR,
    ZIP,
    XZ,
    GZIP,
    BZIP2,
    UNKNOWN
  }

  /**
   * Detect archive type using magic bytes.
   *
   * This does not rely on the filename or extension.
   */
  @Throws(IOException::class)
  fun detectArchiveType(filePath: String): ArchiveType {
    val file = File(filePath)

    if (!file.exists()) {
      throw IOException("File does not exist: $filePath")
    }

    if (!file.isFile) {
      throw IOException("Path is not a file: $filePath")
    }

    BufferedInputStream(file.inputStream()).use { input ->
      val header = ByteArray(512)

      var totalRead = 0

      while (totalRead < header.size) {
        val read = input.read(header, totalRead, header.size - totalRead)

        if (read == -1) {
          break
        }

        totalRead += read
      }

      if (totalRead >= 6 &&
          unsigned(header[0]) == XZ_1 &&
          unsigned(header[1]) == XZ_2 &&
          unsigned(header[2]) == XZ_3 &&
          unsigned(header[3]) == XZ_4 &&
          unsigned(header[4]) == XZ_5 &&
          unsigned(header[5]) == XZ_6
      ) {
        return ArchiveType.XZ
      }

      if (totalRead >= 2 &&
          unsigned(header[0]) == GZIP_1 &&
          unsigned(header[1]) == GZIP_2
      ) {
        return ArchiveType.GZIP
      }

      if (totalRead >= 3 &&
          unsigned(header[0]) == BZIP2_1 &&
          unsigned(header[1]) == BZIP2_2 &&
          unsigned(header[2]) == BZIP2_3
      ) {
        return ArchiveType.BZIP2
      }

      if (totalRead >= 4 &&
          unsigned(header[0]) == ZIP_1 &&
          unsigned(header[1]) == ZIP_2 &&
          unsigned(header[2]) == ZIP_3 &&
          unsigned(header[3]) == ZIP_4
      ) {
        return ArchiveType.ZIP
      }

      /*
       * TAR has no unique magic bytes at offset 0.
       *
       * POSIX TAR stores "ustar" at offset 257.
       */
      if (totalRead >= 263) {
        val ustar =
            header[257] == 'u'.code.toByte() &&
                header[258] == 's'.code.toByte() &&
                header[259] == 't'.code.toByte() &&
                header[260] == 'a'.code.toByte() &&
                header[261] == 'r'.code.toByte()

        if (ustar) {
          return ArchiveType.TAR
        }
      }

      /*
       * Some old TAR implementations may not contain "ustar".
       *
       * Check whether the TAR header checksum looks valid.
       */
      if (totalRead >= 512 && isValidTarHeader(header)) {
        return ArchiveType.TAR
      }
    }

    return ArchiveType.UNKNOWN
  }

  /**
   * Extract any supported archive.
   *
   * The archive type is detected using magic bytes.
   */
  @Throws(IOException::class)
  fun extractArchive(filePath: String, outputDir: String) {
    val archiveFile = File(filePath)
    val outputDirectory = File(outputDir).canonicalFile

    validateInputFile(archiveFile)
    prepareOutputDirectory(outputDirectory)

    val type = detectArchiveType(archiveFile.absolutePath)

    Log.d(
        TAG,
        "Detected archive type: $type for ${archiveFile.name}",
    )

    when (type) {
      ArchiveType.TAR -> {
        extractTar(
            archiveFile,
            outputDirectory,
        )
      }

      ArchiveType.ZIP -> {
        extractZip(
            archiveFile,
            outputDirectory,
        )
      }

      ArchiveType.XZ -> {
        extractTarCompressed(
            archiveFile,
            outputDirectory,
            Compression.XZ,
        )
      }

      ArchiveType.GZIP -> {
        extractTarCompressed(
            archiveFile,
            outputDirectory,
            Compression.GZIP,
        )
      }

      ArchiveType.BZIP2 -> {
        extractTarCompressed(
            archiveFile,
            outputDirectory,
            Compression.BZIP2,
        )
      }

      ArchiveType.UNKNOWN -> {
        throw IOException(
            "Unsupported or unknown archive format: ${archiveFile.absolutePath}",
        )
      }
    }

    verifyExtraction(outputDirectory)

    Log.d(TAG, "Archive extraction successful!")
  }

  /**
   * Backward-compatible method.
   *
   * Existing code calling extractXzArchive() will still work.
   */
  @Throws(IOException::class, IllegalArgumentException::class)
  fun extractXzArchive(
      xzFilePath: String,
      outputDir: String,
  ) {
    extractArchive(xzFilePath, outputDir)
  }

  /**
   * Simple API that returns true/false instead of throwing.
   */
  fun extractArchiveSimple(
      filePath: String,
      outputDir: String,
  ): Boolean {
    return try {
      extractArchive(filePath, outputDir)
      true
    } catch (e: Exception) {
      Log.e(TAG, "Archive extraction failed", e)
      false
    }
  }

  /**
   * Backward-compatible simple XZ method.
   */
  fun extractXzArchiveSimple(
      xzFilePath: String,
      outputDir: String,
  ): Boolean {
    return extractArchiveSimple(
        xzFilePath,
        outputDir,
    )
  }

  private enum class Compression {
    XZ,
    GZIP,
    BZIP2,
  }

  private fun extractTar(
      archiveFile: File,
      outputDirectory: File,
  ) {
    runTar(
        archiveFile = archiveFile,
        outputDirectory = outputDirectory,
        compressionFlag = null,
    )
  }

  private fun extractTarCompressed(
      archiveFile: File,
      outputDirectory: File,
      compression: Compression,
  ) {
    /*
     * tar options:
     *
     * -xvf  TAR
     * -xJvf XZ
     * -xzvf GZIP
     * -xjvf BZIP2
     */
    val compressionFlag =
        when (compression) {
          Compression.XZ -> "J"
          Compression.GZIP -> "z"
          Compression.BZIP2 -> "j"
        }

    runTar(
        archiveFile = archiveFile,
        outputDirectory = outputDirectory,
        compressionFlag = compressionFlag,
    )
  }

  private fun runTar(
      archiveFile: File,
      outputDirectory: File,
      compressionFlag: String?,
  ) {
    val tarBinary = File(
        Environment.BIN_DIR,
        "tar",
    )

    validateExecutable(
        tarBinary,
        "tar",
    )

    val options =
        if (compressionFlag == null) {
          "-xvf"
        } else {
          "-x${compressionFlag}vf"
        }

    Log.d(
        TAG,
        "Running tar with options: $options",
    )

    val processBuilder =
        ProcessBuilder(
            tarBinary.absolutePath,
            options,
            archiveFile.absolutePath,
            "-C",
            outputDirectory.absolutePath,
        )

    configureEnvironment(processBuilder)

    executeProcess(
        processBuilder,
        "tar",
    )
  }

  /**
   * Extract ZIP using the unzip binary.
   */
  private fun extractZip(
      archiveFile: File,
      outputDirectory: File,
  ) {
    val unzipBinary = File(
        Environment.BIN_DIR,
        "unzip",
    )

    validateExecutable(
        unzipBinary,
        "unzip",
    )

    Log.d(
        TAG,
        "Starting ZIP extraction...",
    )

    /*
     * -o = overwrite existing files
     * -q = quiet
     */
    val processBuilder =
        ProcessBuilder(
            unzipBinary.absolutePath,
            "-o",
            archiveFile.absolutePath,
            "-d",
            outputDirectory.absolutePath,
        )

    configureEnvironment(processBuilder)

    executeProcess(
        processBuilder,
        "unzip",
    )
  }

  private fun configureEnvironment(
      processBuilder: ProcessBuilder,
  ) {
    val env = processBuilder.environment()

    env["HOME"] =
        Environment.HOME.absolutePath

    env["PREFIX"] =
        Environment.PREFIX.absolutePath

    env["PATH"] =
        "${Environment.BIN_DIR.absolutePath}:/system/bin"

    env["LD_LIBRARY_PATH"] =
        Environment.LIB_DIR.absolutePath

    env["TMPDIR"] =
        Environment.TMP_DIR.absolutePath
  }

  private fun executeProcess(
      processBuilder: ProcessBuilder,
      commandName: String,
  ) {
    val process = processBuilder.start()

    val stdoutLines =
        mutableListOf<String>()

    val stderrLines =
        mutableListOf<String>()

    val stdoutReader =
        Thread {
          try {
            process.inputStream
                .bufferedReader()
                .useLines { lines ->
                  lines.forEach { line ->
                    stdoutLines.add(line)
                    Log.d(
                        TAG,
                        "$commandName stdout: $line",
                    )
                  }
                }
          } catch (e: Exception) {
            Log.e(
                TAG,
                "Error reading $commandName stdout",
                e,
            )
          }
        }

    val stderrReader =
        Thread {
          try {
            process.errorStream
                .bufferedReader()
                .useLines { lines ->
                  lines.forEach { line ->
                    stderrLines.add(line)
                    Log.e(
                        TAG,
                        "$commandName stderr: $line",
                    )
                  }
                }
          } catch (e: Exception) {
            Log.e(
                TAG,
                "Error reading $commandName stderr",
                e,
            )
          }
        }

    stdoutReader.start()
    stderrReader.start()

    val exitCode = process.waitFor()

    stdoutReader.join(5000)
    stderrReader.join(5000)

    if (exitCode != 0) {
      val errorMessage =
          "$commandName extraction failed " +
              "with exit code: $exitCode\n" +
              "stdout:\n" +
              stdoutLines.joinToString("\n") +
              "\nstderr:\n" +
              stderrLines.joinToString("\n")

      Log.e(
          TAG,
          errorMessage,
      )

      throw IOException(errorMessage)
    }
  }

  private fun validateInputFile(
      file: File,
  ) {
    if (!file.exists()) {
      throw IllegalArgumentException(
          "Archive file does not exist: ${file.absolutePath}",
      )
    }

    if (!file.isFile) {
      throw IllegalArgumentException(
          "Path is not a file: ${file.absolutePath}",
      )
    }

    if (!file.canRead()) {
      throw IllegalArgumentException(
          "Archive file is not readable: ${file.absolutePath}",
      )
    }
  }

  private fun prepareOutputDirectory(
      directory: File,
  ) {
    if (!directory.exists()) {
      val created = directory.mkdirs()

      Log.d(
          TAG,
          "Created output directory: $created",
      )
    }

    if (!directory.isDirectory) {
      throw IllegalArgumentException(
          "Output path is not a directory: ${directory.absolutePath}",
      )
    }

    if (!directory.canWrite()) {
      throw IllegalArgumentException(
          "Output directory is not writable: ${directory.absolutePath}",
      )
    }
  }

  private fun validateExecutable(
      file: File,
      name: String,
  ) {
    if (!file.exists()) {
      throw IOException(
          "$name binary not found at: ${file.absolutePath}",
      )
    }

    if (!file.isFile) {
      throw IOException(
          "$name path is not a file: ${file.absolutePath}",
      )
    }

    if (!file.canExecute()) {
      throw IOException(
          "$name binary is not executable: ${file.absolutePath}",
      )
    }
  }

  private fun verifyExtraction(
      outputDirectory: File,
  ) {
    val extractedFiles =
        outputDirectory.listFiles()

    Log.d(
        TAG,
        "Files in output directory: " +
            "${extractedFiles?.size ?: 0}",
    )

    extractedFiles?.forEach { file ->
      Log.d(
          TAG,
          "  - ${file.name} " +
              "(${if (file.isDirectory) "dir" else "file"})",
      )
    }

    if (extractedFiles.isNullOrEmpty()) {
      throw IOException(
          "Extraction completed but no files found " +
              "in output directory",
      )
    }
  }

  /**
   * Check a TAR header checksum.
   *
   * This allows detection of old TAR files which don't
   * contain the POSIX "ustar" magic.
   */
  private fun isValidTarHeader(
      header: ByteArray,
  ): Boolean {
    if (header.size < 512) {
      return false
    }

    /*
     * TAR checksum occupies bytes 148..155.
     *
     * During checksum calculation those bytes are treated
     * as spaces.
     */
    var storedChecksum = 0L

    for (i in 148 until 156) {
      val value = unsigned(header[i])

      if (value >= '0'.code && value <= '7'.code) {
        storedChecksum =
            storedChecksum * 8 +
                (value - '0'.code)
      }
    }

    var calculatedChecksum = 0L

    for (i in header.indices) {
      val value =
          if (i in 148 until 156) {
            0x20
          } else {
            unsigned(header[i])
          }

      calculatedChecksum += value
    }

    return storedChecksum != 0L &&
        storedChecksum == calculatedChecksum
  }

  private fun unsigned(
      value: Byte,
  ): Int {
    return value.toInt() and 0xFF
  }
}