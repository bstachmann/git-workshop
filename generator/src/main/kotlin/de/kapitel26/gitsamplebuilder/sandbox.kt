package de.kapitel26.gitsamplebuilder.gitworkshop

import de.kapitel26.gitsamplebuilder.createCollectionOfSamples
import impl.LogBuilderOptions
import impl.LogOutputFormat
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class LanguageContext(val language: String) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<LanguageContext>
}

fun main() {
    println("This is the sandbox")

    buildSomeUebungen()
    // performInLocalBash("ls -lah README.md")
    // openFileInLocalVscode("README.md")
    // openFileInLocalVscode("/root/README.md")

    // Infixing().testInfix()
}

class Infixing {

    var target_language = "de"

    fun testInfix() {
        runBlocking {
            withContext(LanguageContext("de")) {
                var result = "Hallo Welt" fake_en "Hello World"
                println(result)
            }
            withContext(LanguageContext("en")) {
                var result = "Hallo Welt" fake_en "Hello World"
                println(result)
            }
            withContext(LanguageContext("de")) {
                var result = "Hallo Welt" fake_en "Hello World"
                println(result)
            }
        }
    }
}

infix suspend fun String.fake_en(en_text: String): String {
    val lang = kotlin.coroutines.coroutineContext[LanguageContext]?.language ?: "de"
    return if (lang == "en") en_text else this
}

object BuildParameters {
    var target_language = ThreadLocal<String>().apply { set("de") }
}

infix fun String.en(en_text: String): String {
    val lang = BuildParameters.target_language.get() ?: "de"
    return if (lang == "en") en_text else this
}

fun buildSomeUebungen() {

    for (language in listOf("de", "en")) {
        BuildParameters.target_language.set(language)
        println("Building samples in language: $language")

        createCollectionOfSamples(
                "gitworkshop-sandbox $language",
                LogBuilderOptions(outputFormat = LogOutputFormat.HTML)
        ) {
            thema("sandkasten" en "sandbox") {
                createAufgabenFolge("moin" en ("hello")) {
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
