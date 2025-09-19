package de.kapitel26.gitsamplebuilder

import java.io.File

fun main() {
    val targetDir = File("markdown-git-uebungen")

    targetDir.deleteRecursively()
    for (lang_suffix in listOf("", "-en")) {
        val srcDir = File("build/git-uebungen$lang_suffix/loesungen")
        copy(srcDir, targetDir)
    }
}

fun copy(src: File, targetDir: File) {
    println("Checking $src to $targetDir ... ")
    if (src.isFile && src.name.matches("(aufgabe|loesung)-.*\\.md".toRegex())) {
        println("Copying $src to $targetDir ... ")
        src.copyTo(File(targetDir, src.name), overwrite = false)
    } else if (src.isDirectory) {
        src.listFiles().forEach { copy(it, targetDir) }
    }
}
