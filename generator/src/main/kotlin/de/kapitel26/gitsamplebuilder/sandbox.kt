package de.kapitel26.gitsamplebuilder.gitworkshop

import de.kapitel26.gitsamplebuilder.createCollectionOfSamples
import impl.BuildParameters
import impl.LogBuilderOptions
import impl.LogOutputFormat
import impl.en
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

class LanguageContext(val language: String) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<LanguageContext>
}

fun main() {
    println("This is the sandbox")

    buildSomeUebungen()
    // performInLocalBash("ls -lah README.md")
    // openFileInLocalVscode("README.md")
    // openFileInLocalVscode("/root/README.md")
}

fun buildSomeUebungen() {

    for (language in listOf("de", "en")) {
        BuildParameters.language = language
        println("Building samples in language: $language")

        createCollectionOfSamples(
                "gitworkshop-sandbox${BuildParameters.language_suffix}",
                LogBuilderOptions(outputFormat = LogOutputFormat.HTML)
        ) {
            thema("sandkasten" en "sandbox") {
                createAufgabenFolge("moin" en "hello") {
                    createIntro("MOIN" en "HELLO", "MOIN MOIN" en "HELLO HELLO")
                    createAufgabe("Aufgabe" en "Task", "tu was" en "do something") {
                        markdown("und hier details" en "and here details")
                    }
                }
            }

            // halloWelt()
            // rebasingSandbox()
            // repositoryUntersuchen()
            // reverting()
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
