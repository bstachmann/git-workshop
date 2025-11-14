package de.kapitel26.gitsamplebuilder

import java.io.File

fun main() {
    for (lang_suffix in listOf("", "-en")) {
        val targetDir = File("markdown-git-uebungen$lang_suffix")
        targetDir.deleteRecursively()
        val srcDir = File("build/git-uebungen$lang_suffix/loesungen")
        copy(srcDir, targetDir)
    }
}

fun copy(src: File, targetDir: File) {
    if (src.isFile && src.name.matches("(aufgabe|loesung)-.*\\.md".toRegex())) {
        src.copyTo(File(targetDir, src.name), overwrite = false)
    } else if (src.isDirectory) {
        src.listFiles().forEach { copy(it, targetDir) }
    }
}
