package impl

class File(val location: java.io.File, val log: LogBuilder, val solutionCollector: SolutionCollector) {

    var content: String
        get() = location.readText()
        set(value) {
            log.editFile(dirName(), "Edit file ${location.name}")
            location.writeText(value)
        }

    fun createSampleFileContent(): String =
            (0..11).joinToString("\n") { "line $it created" }

    fun edit(line: Int, message: String = "Edit file ${location.name}") = edit(line..line, message)

    fun edit(linesToEdit: IntRange, message: String = "edited") {
        location
                .apply { log.editFile(dirName(), message) }
                .readLines()
                .mapIndexed { index, s ->
                    if (index in linesToEdit)
                        "line $index $message / $s"
                    else
                        s
                }
                .joinToString("\n")
                .also { location.writeText(it) }
    }

    fun replace(searchFor: String, replaceWith: String) {
        location
                .apply { log.editFile(dirName(), "Edit $name replacing $searchFor with $replaceWith") }
                .readText()
                .replace(searchFor, replaceWith)
                .also { location.writeText(it) }
    }

    fun replaceRegex(searchFor: Regex, replaceWith: String) {
        location
                .apply { log.editFile(dirName(), "Edit $name replacing pattern with $replaceWith") }
                .readText()
                .replace(searchFor, replaceWith)
                .also { location.writeText(it) }
    }


    private fun dirName() = location.parentFile.name

    fun lines() = location.readLines()

    fun commit(message: String? = null) = GitContext(Dir(location.parentFile, log, solutionCollector)).commit(location.name, message)
}