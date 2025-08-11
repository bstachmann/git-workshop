package de.kapitel26.gitsamplebuilder.gitworkshop

import de.kapitel26.gitsamplebuilder.createCollectionOfSamples
import impl.LogBuilderOptions
import impl.LogOutputFormat

fun main() {
    println("This is the sandbox")

    // buildSomeUebungen()
    // performInLocalBash("ls -lah README.md")
    // openFileInLocalVscode("README.md")
    // openFileInLocalVscode("/root/README.md")

    Infixing().testInfix()
}

class Infixing {

    var target_language = "de"

    infix fun String.en(en_text: String): String {
        if (target_language == "en") return en_text else return this
    }

    fun testInfix() {
        var result = "Hallo Welt" en "Hello World"
        println(result)
        target_language = "en"
        result = "Hallo Welt" en "Hello World"
        println(result)
        target_language = "de"
        result = "Hallo Welt" en "Hello World"
        println(result)
    }
}

fun buildSomeUebungen() {

    createCollectionOfSamples(
            "gitworkshop-sandbox",
            LogBuilderOptions(outputFormat = LogOutputFormat.HTML)
    ) {
        thema("beispiel") {

            // halloWelt()
            // rebasingSandbox()
            // repositoryUntersuchen()
            reverting()
            // commitsErstellen()
            // staging()
            // cloning()
            // fetchAndPull()
            // pushRejected()
            // integrationOfChanges()
            // rebasing()
            // branching()
            // modules()
            // repositorysZusammenfuehren()
            // sparseCeckouts()
        }
    }
}
