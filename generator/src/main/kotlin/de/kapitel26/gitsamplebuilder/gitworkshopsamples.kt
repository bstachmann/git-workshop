package de.kapitel26.gitsamplebuilder.gitworkshop

import de.kapitel26.gitsamplebuilder.createCollectionOfSamples
import impl.BuildParameters
import impl.LogBuilderOptions
import impl.LogOutputFormat.*

fun main() {
    buildGitUebungen()
}

fun buildGitUebungen() {

    for (language in listOf("de" /* , "en"*/)) {
        BuildParameters.language = language
        println("Building gitUebungen in language: $language")

        createCollectionOfSamples("git-uebungen", LogBuilderOptions(outputFormat = BOTH)) {
            thema("Intro") {
                commandline()
                halloWelt()
            }

            thema("Repository") {
                repositoryLog()
                repositoryUntersuchen()
                klonen()
                sparseCeckout()
            }

            thema("Commits") {
                erstellen()
                staging()
            }

            thema("Zusammenarbeit") {
                branching()
                fetchAndPull()
                tags()
                pushRejected()
                integrationVonAenderungen()
                branchingFortgeschritten()
                reverting()
                rebasing()
            }

            // Modules
            thema("Modularisierung") {
                submodules()
                subtrees()
                repositorysZusammenfuehren()
                // lfs()
            }

            thema("Weihnachten") { gitmas() }
        }
    }
}
