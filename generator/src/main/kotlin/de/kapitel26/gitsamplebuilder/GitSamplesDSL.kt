package de.kapitel26.gitsamplebuilder

import impl.*
import java.io.File as IOFile

class CommandLineException(val failedProcess: Process, message: String) : RuntimeException(message)

fun buildGitSamples(
        sampleName: String,
        sampleDir: String = "build/git-samples",
        suffix: String = "aufgabe",
        commands: Dir.() -> Unit
) =
        buildGitSamples(
                IOFile(sampleDir, "$sampleName.$suffix"),
                LogBuilderOptions(outputFormat = LogOutputFormat.MARKDOWN, createFullLog = true)
        ) { commands() }

fun buildGitSamples(
        gitSamplesRootDir: java.io.File,
        options: LogBuilderOptions = LogBuilderOptions(),
        commands: Dir.() -> Unit
) {
        Dir(gitSamplesRootDir, LogBuilder(options, gitSamplesRootDir), SolutionCollector())
                .apply { clear() }
                .run(commands)
}

fun createCollectionOfSamples(
        dirName: String,
        options: LogBuilderOptions = LogBuilderOptions(),
        commands: CollectionOfSamples.() -> Unit
) {
        for (language in listOf("de", "en")) {
                BuildParameters.language = language
                println("Building samples in language: $language")

                CollectionOfSamples(
                                IOFile("build", "$dirName${BuildParameters.language_suffix}"),
                                options
                        )
                        .apply { clear() }
                        .apply { createDir("aufgaben") }
                        .apply { createDir("loesungen") }
                        .run(commands)
        }
}
