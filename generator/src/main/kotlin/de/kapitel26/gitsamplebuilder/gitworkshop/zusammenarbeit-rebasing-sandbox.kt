package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.rebasingSandbox() {
    createAufgabenFolge("rebasing") {
        createIntro("Rebasing Sandbox", """

            """ en """

            """) {
            createRepo("repo-rebase") {
                createFileAndCommit("hello") { content = "hallo welt" }

                startBranch("feature") {
                    editAndCommit("hello", "Uppercase hello") { content = "Hallo Welt" }
                }

                createFileAndCommit("bar")

                createClone("../repo-merge")
            }
        }

        createAufgabe(
                "zusammenarbeit-rebasing-sandbox",
                "Feature-Branch per Rebase aktualiseren." en "Update feature branch via rebase.",
                """
                    """ en """
                    """
        ) {
            inRepo("repo-rebase") {
                // rebase onto main, but keep feature
                startBranch("f-tmp", "feature") { git("rebase main") }
                git("rebase f-tmp")
                git("branch -d f-tmp")

                editAndCommit("hello", "Add !") { content = "Hallo Welt!" }

                git("switch feature")
                createFile("wurst")
                git("add wurst")
                git("commit --amend -m 'Amended'")
                git("log --graph --all --decorate --oneline")
                git("rebase main", acceptableExitCodes = setOf(1))
                bash("cat hello")
            }
        }

        createAufgabe(
                "zusammenarbeit-rebasing-sandbox",
                "Feature-Branch per Merge aktualiseren." en "Update feature branch via merge.",
                """
                    """ en """
                    """
        ) {
            inRepo("repo-merge") {
                onBranch("feature") {}

                git("merge feature")

                editAndCommit("hello", "Add !") { content = "Hallo Welt!" }

                git("log --graph --all --decorate --oneline")

                git("switch feature")
                git("merge main", acceptableExitCodes = setOf(0))
                bash("cat hello")
            }
        }
    }
}
