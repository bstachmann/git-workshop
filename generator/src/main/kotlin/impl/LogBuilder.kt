package impl

import impl.LogOutputFormat.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import kotlinx.html.b
import kotlinx.html.br
import kotlinx.html.code
import kotlinx.html.pre
import kotlinx.html.stream.appendHTML
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser

class LogBuilder(
        val options: LogBuilderOptions = LogBuilderOptions(),
        val gitSamplesRootDir: File
) {

    private val fullLogFileName = ".full-log.md"

    private var activeCollectors = resetCollectors()

    var collectedLogs = mutableListOf<Pair<String, Set<String>>>()

    val nav_order = mutableMapOf<String, Int>()

    fun createDir(dirName: String, where: String) = shell("mkdir $dirName", where)

    fun cd(dirName: String, where: String) = shell("cd $dirName", where)

    fun createFile(name: String, where: String) = shell("# created file '$name'", where)

    fun editFile(where: String, message: String) = shell("# $message", where)

    fun shell(
            cmd: String,
            where: String?,
            outputLines: List<String> = emptyList(),
            errorLines: List<String> = emptyList()
    ) {
        val builder = StringBuilder()
        builder.appendHTML().pre {
            val w = if (where == ".") "" else where + " "
            code {
                +"$w$ "
                b { +cmd }
                br()
                br()
                (outputLines + errorLines).forEach {
                    +it
                    br()
                }
                br()
            }
        }

        addRawLine("")
        addRawLine(builder.toString())
        addRawLine("")
    }

    fun doc(message: String) {
        message.trimIndent().lines().forEach { addRawLine(it) }
        addRawLine("")
    }

    fun startLoggingTo(name: String) = activeCollectors.add(name)

    fun stopLoggingTo(name: String) = activeCollectors.remove(name)

    fun addRawLine(s: String) = collectedLogs.add(s to activeCollectors.toSet())

    fun writeDocs(rootDir: File): Any =
            when (options.outputFormat) {
                HTML -> writeHtmlFiles(rootDir)
                MARKDOWN -> writeMarkdownFiles(rootDir)
                BOTH -> {
                    writeHtmlFiles(rootDir)
                    writeMarkdownFiles(rootDir)
                }
            }

    fun writeMarkdownFiles(rootDir: File) {
        val name2writer = mutableMapOf<String, BufferedWriter>()
        collectedLogs.forEach { (line, names) ->
            names.forEach { name ->
                val type =
                        when ("""aufgabe|loesung""".toRegex().find(name)?.value) {
                            "aufgabe" -> "parent: ${"Aufgaben" en "Exercises"}\n"
                            "loesung" -> "parent: ${"Lösungen" en "Solutions"}\n"
                            else -> ""
                        }

                name2writer
                        .computeIfAbsent(name) { logName ->
                            val title =
                                    """(aufgabe|loesung)\-(.*)\.md"""
                                            .toRegex()
                                            .matchEntire(name)
                                            ?.groupValues
                                            ?.get(2)
                                            ?: logName
                            BufferedWriter(FileWriter(File(rootDir, logName))).also {
                                it.write(
                                        """
                                    ---
                                    layout: page
                                    title: <code>${title}</code>
                                    ${type}
                                    nav_order: ${nav_order.get(name) ?: 999}
                                    ---
                                    
                                 """.trimIndent()
                                )
                            }
                        }
                        .apply {
                            write(line)
                            write("\n")
                        }
            }
        }
        name2writer.values.forEach { it.close() }
    }

    fun writeHtmlFiles(rootDir: File) {
        val header =
                """
            <head>
            <meta charset="utf-8">
            <style>
            pre {
                color: lightgreen;
                background-color: black;
                padding: 0px;
                border: 2px solid black;
                margin: 0px;
            }
            code {
                color: lightgreen;
                background-color: black;
                padding: 1px;
            }
            code b {
                color: lime;
            }
            </style>
            </head>
            
        """.trimIndent()

        collectedLogs
                .flatMap { (line, names) -> names.map { name -> name to line } }
                .groupBy { it.first }
                .entries
                .map { (name, lines) -> name to lines.map { it.second }.joinToString("\n") }
                .map { (name, markdown) ->
                    val htmlBody = markdown2html(markdown)
                    val nameWithoutExtension = File(name).nameWithoutExtension
                    File(rootDir, "$nameWithoutExtension.html").writeText(header + htmlBody)
                }
    }

    private fun markdown2html(markdown: String): String {
        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(markdown)
        val html = HtmlGenerator(markdown, parsedTree, flavour).generateHtml()
        return html
    }

    fun write(rootDir: File, name: String, content: String) = File(rootDir, name).writeText(content)

    fun of(name: String) = collectedLogs.filter { (_, ns) -> ns.contains(name) }.map { (s, _) -> s }

    fun reset() {
        activeCollectors = resetCollectors()
        collectedLogs = mutableListOf()
    }

    private fun resetCollectors(): MutableSet<String> {
        return if (options.createFullLog) mutableSetOf(fullLogFileName) else mutableSetOf()
    }

    fun suppressLogging(commands: () -> Unit) {
        val tmpCollectors = activeCollectors
        activeCollectors = mutableSetOf()
        commands()
        activeCollectors = tmpCollectors
    }
}
