package de.kapitel26.gitsamplebuilder.gitworkshop

import de.kapitel26.gitsamplebuilder.createCollectionOfSamples
import impl.LogBuilderOptions
import impl.LogOutputFormat

fun main() {

    createCollectionOfSamples("gitworkshop-sandbox", LogBuilderOptions(outputFormat = LogOutputFormat.HTML)) {

        thema("beispiel") {

            // repositoryUntersuchen()
            // commitsErstellen()
            // cloning()
            // pushFetchPull()
            // pushRejected()
            // integrationOfChanges()
            // rebasing()
            // branching()
            modules()
        }
    }
}

