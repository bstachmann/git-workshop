package impl

import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.serialization.jackson.*
import java.io.File

class CollectionOfSamples(rootDir: File, options: LogBuilderOptions) :
        AbstractDir<CollectionOfSamples>(
                rootDir,
                log = LogBuilder(options, rootDir),
                solutionCollector = SolutionCollector()
        ) {

    var aufgabenNamen: MutableList<String> = mutableListOf()
    var thema: String? = null

    fun clear() {
        rootDir.deleteRecursively()
        rootDir.mkdirs()
    }

    fun createAufgabenFolge(name: String, commands: Dir.() -> Unit) {
        val fullName = thema?.let { "${it.lowercase()}-$name" } ?: "$name"
        val lang_suffix = BuildParameters.language_suffix
        log.nav_order.put("aufgabe-$fullName$lang_suffix.md", aufgabenNamen.size)
        log.nav_order.put("loesung-$fullName$lang_suffix.md", aufgabenNamen.size)
        aufgabenNamen.add(fullName)

        createSample("loesungen/$fullName") {
            inDir(".") {
                logTo("aufgabe-$fullName$lang_suffix.md") {
                    commands()
                    markdown(
                            ("[Zur Lösung]" en "[To the exercise]") +
                                    "(loesung-$fullName${lang_suffix}.html){:style=\"position: fixed; right: 10px; top:60px\" .btn .btn-purple}"
                    )
                    markdown(
                            ("[Zum Überblick]" en "[To the overview]") +
                                    "(../../ueberblick${lang_suffix}.html){:style=\"visibility: hidden\"}"
                    )
                }
            }
            writeDocs()

            executeProcess("cp", "-a", rootDir.absolutePath, "../../aufgaben/")

            applyLoesungen(fullName)
            writeDocs()
        }

        reset()

        logTo("ueberblick.md") {
            aufgabenNamen.forEach { name ->
                markdown(
                        " * [$name](loesungen/$name/aufgabe-$name.html) [${"Lösung" en "Solution"}](loesungen/$name/loesung-$name.html)"
                )
            }
        }
        writeDocs()

        write(
                "aufgaben${BuildParameters.language_suffix}.json",
                ObjectMapper().writeValueAsString(solutionCollector.aufgabenUndSchritte)
        )
    }

    fun createSample(sampleName: String, commands: (Dir.() -> Unit)? = null) {
        log.collectedLogs.clear()
        createDir(sampleName, commands)
    }

    fun thema(thema: String, commands: CollectionOfSamples.() -> Unit) {
        val previousThema = this.thema
        this.thema = thema
        commands()
        this.thema = previousThema
    }
}
