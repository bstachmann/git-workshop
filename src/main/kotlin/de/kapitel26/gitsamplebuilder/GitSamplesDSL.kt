package de.kapitel26.gitsamplebuilder

import de.kapitel26.gitsamplebuilder.impl.Dir
import de.kapitel26.gitsamplebuilder.impl.File
import de.kapitel26.gitsamplebuilder.impl.Repo
import kotlin.streams.toList
import java.io.File as IOFile

abstract class AbstractDir<T>(
        val rootDir: IOFile,
        val baseName: String = rootDir.name,
        val log: LogBuilder = LogBuilder()
) {


    fun createDir(dirName: String, commands: (Dir.() -> Unit)? = null): Unit =
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

    fun dir(dirName: String, commands: Dir.() -> Unit): Unit =
            IOFile(rootDir, dirName)
                    .apply { if (!exists()) throw IllegalStateException("Dir $this is expected to exist!") }
                    .run { Dir(this) }
                    .run(commands)

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

    fun file(name: String = "file", commands: File.() -> Unit = {}) =
            File(IOFile(rootDir, name), log)
                    .apply { if (!location.exists()) throw IllegalStateException("File $this is expected to exist!") }
                    .run(commands)


    fun execute(command: String): List<String> = executeRaw(command, false).inputStream.bufferedReader().lines().toList()

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

        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)
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

    fun createRepo(newRepoName: String = "repo", commands: (Repo.() -> Unit)? = null): Unit {
        git("init", newRepoName)
        Repo(IOFile(rootDir, newRepoName).absoluteFile, log, commands)
    }

    fun repo(newRepoName: String = "repo", commands: (Repo.() -> Unit)? = null): Unit =
            IOFile(rootDir, newRepoName).absoluteFile
                    .apply { if (!exists()) throw IllegalStateException("Repo $this not expected to exist!") }
                    .run {
                        if (commands != null) {
                            log.cd(newRepoName)
                            Repo(this, log, commands)
                            log.cd("..")
                        }
                    }

    fun bareRepo(newRepBasename: String = "server", function: de.kapitel26.gitsamplebuilder.AbstractDir<T>.() -> Unit): Repo {
        val tmpDirName = ".$newRepBasename"
        createDir(tmpDirName) {
            git("init")
            function()
        }

        val serverRepoName = "$newRepBasename.git"
        git("clone --bare $tmpDirName $serverRepoName")
        return Repo(IOFile(rootDir, serverRepoName).absoluteFile, log)
    }

    fun inRepo(repo: Repo, function: Repo.() -> Unit) {
        Repo(repo.rootDir, log, function)
    }

    fun list(): List<String> = execute("ls -A")


    abstract fun duplicatedSample(suffix: String, function: T.() -> Unit): T

    fun edit(filename: String, lineNumber: Int, message: String = "edited") =
            file(filename) { edit(lineNumber..lineNumber, message) }

    fun logAsMarkdown() = log.toMarkdown()

    fun clearLog() {
        log.clear()
    }

}

class LogBuilder {

    val markdownLines: MutableList<String> = mutableListOf()

    fun clear() = markdownLines.clear()

    fun toMarkdown(): List<String> = markdownLines.toList()

    fun createDir(dirName: String) = shell("mkdir $dirName")

    fun cd(dirName: String) = shell("cd $dirName")

    fun createFile(name: String, content: String?) = shell("# created file '$name'")

    fun editFile(name: String?, linesToEdit: IntRange, message: String) =
            shell("# $message file '$name' at $linesToEdit")

    fun shell(cmd: String) = markdownLines.add("    $ $cmd")

}

class CommandlineException(val failedProcess: Process, message: String) : RuntimeException(message)


fun buildGitSamples(sampleName: String, sampleDir: String = "build/git-samples", commands: Dir.() -> Unit) =
        buildGitSamples(IOFile(sampleDir, sampleName), commands)


fun buildGitSamples(rootDir: IOFile, commands: Dir.() -> Unit) {
    Dir(rootDir)
            .apply { clear() }
            .run(commands)
}