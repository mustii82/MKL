package mkl.helper

import mkl.global.variables.fileSeperator
import java.io.File

/**
 * SuperFile uses always the correct FileSeperator for the running System.
 */

private fun String.convertToSystemFilePath(writtenSeperator: String) = this.replace("/", fileSeperator)

class SuperFile(uncorrectedFilePath: String, val writtenSeperator: String = "/") :
    File(uncorrectedFilePath.convertToSystemFilePath(writtenSeperator)) {

    val filePath = uncorrectedFilePath.convertToSystemFilePath(writtenSeperator)

    fun getFileFolder(): String = filePath.substringBeforeLast("/")

    fun getFileName(): String = filePath.substringAfterLast("/")

    fun getFileNameWithoutExtension(): String = filePath.substringBeforeLast(".")

    fun getFileExtension(): String = filePath.substringAfterLast(".")

}