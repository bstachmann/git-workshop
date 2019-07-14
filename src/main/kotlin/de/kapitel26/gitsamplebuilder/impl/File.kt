package de.kapitel26.gitsamplebuilder.impl

class File(val location: java.io.File, val log: LogBuilder) {

    fun createSampleFileContent(): String =
            (0..11).joinToString("\n") { "line $it created" }

    fun edit(line: Int, message: String = "edited") = edit(line..line, message)

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

    private fun dirName() = location.parentFile.name

    fun lines() = location.readLines()
}