package util

import java.io.File
import java.lang.ProcessBuilder.Redirect.PIPE

fun openFileInLocalVscode(filepath: String)  {
    val file = File(filepath)
    if(!file.exists() || file.isAbsolute())
        throw IllegalArgumentException("Invalide filepath ${filepath}")

    performInLocalBash("code $filepath")    
}

fun performInLocalBash(command: String) {

    val processBuilder = ProcessBuilder("/bin/bash", "-c", command)
    // processBuilder.directory(rootDir)
    processBuilder.redirectOutput(PIPE)
    processBuilder.redirectError(PIPE)

    val process = processBuilder.start()
    process.waitFor()

    val outputLines = process.inputStream.bufferedReader().readLines()
    val errorLines = process.errorStream.bufferedReader().readLines()

    outputLines.forEach {  l -> println(l) }
    errorLines.forEach {  l -> println("ERR $l") }

    if(process.exitValue() != 0) {
        throw RuntimeException("Command `$command` exited with ${process.exitValue()}")
    }
}

