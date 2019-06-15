package de.kapitel26.gitsamplebuilder

import de.kapitel26.gitsamplebuilder.impl.CollectionOfSamples
import de.kapitel26.gitsamplebuilder.impl.Dir
import de.kapitel26.gitsamplebuilder.impl.File
import de.kapitel26.gitsamplebuilder.impl.Repo
import kotlin.streams.toList
import java.io.File as IOFile

abstract class AbstracDir<T>(
        val rootDir: IOFile,
        val baseName: String = rootDir.name,
        val log: LogBuilder = LogBuilder()
) {
    fun logAsMarkdown() = log.toMarkdown()

    fun clearLog() = log.clear()


    fun flushLogToFile(fileName: String = "setup-log.md") {
        if (fileName.endsWith(".md"))
            flushLogToMarkdownFile(fileName)
        else
            throw IllegalArgumentException("File type not supported for $fileName")
    }

    fun flushLogToMarkdownFile(fileName: String = "setup-log.md") {
        createOrAppendToFile(fileName, logAsMarkdown().joinToString("\n"))
        clearLog()
    }

    private fun createOrAppendToFile(name: String, content: String? = null, commands: File.() -> Unit = {}) =
            File(IOFile(rootDir, name), log)
                    .apply {
                        if (!location.exists()) {
                            log.createFile(name, content)
                            location.writeText(content ?: createSampleFileContent())
                        } else {
                            log.appendToFile(name, content)
                            location.appendText(content ?: createSampleFileContent())
                        }
                    }
                    .run(commands)

    fun doc(message: String) {
        log.doc(message)
    }

    fun createDir(dirName: String, commands: (Dir.() -> Unit)? = null) =
            IOFile(rootDir, dirName)
                    .apply { if (exists()) throw IllegalStateException("Dir $this not expected to exist!") }
                    .apply { mkdirs() }
                    .apply { log.createDir(dirName) }
                    .run { Dir(this, log = log) }
                    .run {
                        if (commands != null) {
                            log.cd(dirName)
                            commands()
                            log.cd("..")
                        }
                    }

}

abstract class AbstracWorkingDir<T>(
        rootDir: java.io.File,
        log: LogBuilder
) : AbstracDir<T>(rootDir, log = log) {

    fun inDir(dirName: String, commands: Dir.() -> Unit) =
            IOFile(rootDir, dirName)
                    .apply { if (!exists()) throw IllegalStateException("Dir $this is expected to exist!") }
                    .run { Dir(this, log = log) }
                    .run {
                        log.cd(dirName)
                        commands()
                        log.cd("..")
                    }

    fun clear() {
        rootDir.deleteRecursively()
        rootDir.mkdirs()
    }

    fun createFile(name: String, content: String? = null, commands: File.() -> Unit = {}): Unit =
            File(IOFile(rootDir, name), log)
                    .apply { if (location.exists()) throw IllegalStateException("File $this is not expected to exist!") }
                    .apply { log.createFile(name, content) }
                    .apply { location.writeText(content ?: createSampleFileContent()) }
                    .run(commands)


    fun inFile(name: String = "file", commands: File.() -> Unit = {}) =
            File(IOFile(rootDir, name), log)
                    .apply { if (!location.exists()) throw IllegalStateException("File $this is expected to exist!") }
                    .run(commands)


    fun execute(command: String): List<String> {
        val process = executeRaw(command, false)
        val outputLines = process.inputStream.bufferedReader().lines().toList()
        outputLines.forEach { log.addRawLine("    $it") }
        val errorLines = process.errorStream.bufferedReader().lines().toList()
        errorLines.forEach { log.addRawLine("    $it") }
        return outputLines
    }

    fun executeSplitted(vararg command: String): List<String> = exeuteSplittedRaw(false, *command).inputStream.bufferedReader().lines().toList()

    fun show(command: String): Process = executeRaw(command, true)


    fun executeRaw(command: String, inheritStdout: Boolean): Process {
        val splittedCommandLineArguments = command.split("""\s+""".toRegex()).toTypedArray()
        return exeuteSplittedRaw(inheritStdout, *splittedCommandLineArguments)
    }

    fun exeuteSplittedRaw(inheritStdout: Boolean, vararg splittedCommandLineArguments: String): Process {
        log.shell(splittedCommandLineArguments.joinToString(" "))
        val processBuilder = ProcessBuilder(*splittedCommandLineArguments)

        processBuilder.directory(rootDir)

        processBuilder.redirectError(ProcessBuilder.Redirect.PIPE)
        if (inheritStdout) {
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
        }

        val process = processBuilder.start()

        val exitCode = process.waitFor()
        if (exitCode != 0)
            throw CommandlineException(process, "Failed with exit code $exitCode: ${splittedCommandLineArguments.joinToString(" ")}")
        return process
    }


    fun git(gitCommand: String): List<String> = execute("git $gitCommand")

    fun git(vararg commandLineArguments: String): List<String> = executeSplitted(*(listOf("git") + commandLineArguments).toTypedArray())

    fun createRepo(newRepoName: String = "repo", vararg args: String, commands: (Repo.() -> Unit)? = null): Unit {
        git("init", newRepoName, *args)
        Repo(IOFile(rootDir, newRepoName).absoluteFile, log, commands)
    }

    fun createClonedRepo(originalRepo: String, clonedRepo: String, commands: (Repo.() -> Unit)? = {}) {
        git("clone $originalRepo $clonedRepo")
        inRepo(clonedRepo, commands)
    }


    fun inRepo(repoName: String = "repo", commands: (Repo.() -> Unit)? = null): Unit =
            IOFile(rootDir, repoName).absoluteFile
                    .apply { if (!exists()) throw IllegalStateException("Repo $this not expected to exist!") }
                    .run {
                        if (commands != null)
                            Repo(this, log, commands)
                    }


    fun inRepo(repo: Repo, function: Repo.() -> Unit) {
        Repo(repo.rootDir, log, function)
    }

    fun listFilenames(): List<String> = execute("ls -A")

    fun edit(filename: String, lineNumber: Int, message: String = "edited") =
            inFile(filename) { edit(lineNumber..lineNumber, message) }
}

class LogBuilder {

    val markdownLines: MutableList<String> = mutableListOf()
    var id2appender = mutableMapOf<String, (String) -> Unit>("collector" to { s -> markdownLines.add(s) })

    fun clear() = markdownLines.clear()

    fun toMarkdown(): List<String> = markdownLines.toList()

    fun createDir(dirName: String) = shell("mkdir $dirName")

    fun cd(dirName: String) = shell("cd $dirName")

    fun createFile(name: String, content: String?) = shell("# created file '$name'")

    fun appendToFile(name: String, content: String?) = shell("# append to file '$name'")

    fun editFile(name: String?, linesToEdit: IntRange, message: String) =
            shell("# $message file '$name' at $linesToEdit")

    fun shell(cmd: String) = addRawLine("    $ $cmd")

    fun doc(message: String) {
        message.trimIndent().lines().forEach { addRawLine(it) }
        addRawLine("")
    }

    fun addRawLine(s: String) = id2appender.values.forEach { it(s) }
}

class CommandlineException(val failedProcess: Process, message: String) : RuntimeException(message)


fun buildGitSamples(sampleName: String, sampleDir: String = "build/git-samples", suffix: String = "aufgabe", commands: Dir.() -> Unit) =
        buildGitSamples(IOFile(sampleDir, "$sampleName.$suffix")) {
            clearLog()
            commands()
        }

fun buildGitSamples(rootDir: IOFile, commands: Dir.() -> Unit) {
    Dir(rootDir)
            .apply { clear() }
            .run(commands)
}

fun createCollectionOfSamples(dirName: String, commands: CollectionOfSamples.() -> Unit) {
    CollectionOfSamples(IOFile("build", dirName))
            .apply { clear() }
            .run(commands)
}