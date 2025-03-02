package de.kapitel26.gitsamplebuilder.gitworkshop

import de.kapitel26.gitsamplebuilder.createCollectionOfSamples
import impl.LogBuilderOptions
import impl.LogOutputFormat
import util.performInLocalBash
import util.openFileInLocalVscode

fun main() {
    println("This is the sandbox")

    // buildSomeUebungen()
    performInLocalBash("ls -lah README.md")
    openFileInLocalVscode("README.md")
    // openFileInLocalVscode("/root/README.md")
}

fun buildSomeUebungen() {

    createCollectionOfSamples("gitworkshop-sandbox", LogBuilderOptions(outputFormat = LogOutputFormat.HTML)) {

        thema("beispiel") {

            // halloWelt()
            // rebasingSandbox()
            //repositoryUntersuchen()
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

