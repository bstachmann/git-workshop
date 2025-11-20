package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.fetchAndPull() {
    createAufgabenFolge("push-fetch-pull") {
        createIntro(
                "Fetch und Pull" en "Fetch and Pull",
                """

                ## Tipps

                * `git fetch` holt Änderungen, ohne zu integrieren
                * `git status` zeigt unterschiede am aktuellen Branch
                * `git branch -r` zeigt, welche Branches es Remote gibt.
                * `git pull` integriert (erst Fetch, dann Merge)
                * `git log --graph --oneline` zeigt den Graphen mit Merges
                
                ## Setup
                                  
            """ en
                        """

                ## Tips

                * `git fetch` fetches changes without integrating
                * `git status` shows differences on the current branch
                * `git branch -r` shows which remote branches exist.
                * `git pull` integrates (first fetch, then merge)
                * `git log --graph --oneline` shows the graph with merges
                
                ## Setup
                                  
            """
        ) {
            createRepo("blessed.git", "--bare") {
                createClone("../anderer-klon") {
                    createFileAndCommit("foo", "Initial edit before cloning")
                    createFileAndCommit("bar", "Initial edit before cloning")
                    git("push")
                }

                createClone("../mein-klon")
            }
            inRepo("anderer-klon") {
                editAndCommit("foo", 3, "First edit after cloning")
                editAndCommit("foo", 7, "Second edit after cloning")
                git("push")
            }

            inRepo("mein-klon") { editAndCommit("bar", 3, "My local edit") }
        }

        inRepo("mein-klon") {
            createAufgabe(
                    "zusammenarbeit-push-fetch-pull",
                    "Änderungen holen" en "Fetch changes",
                    """
                    Hole die beiden neuen Commits vom `origin`-Repository,
                    ohne den lokalen `main` zu verändern.
        """ en
                            """
                    Fetch the two new commits from the `origin` repository
                    without changing the local `main`.
        """
            ) {
                git("fetch")
                markdown(
                        "Die Ausgabe zeigt, dass Änderungen auf dem Branch `main` geholt wurden." en
                                "The output shows that changes on the `main` branch have been fetched."
                )
                git("status")
            }

            createAufgabe(
                    "zusammenarbeit-push-fetch-pull",
                    "Änderungen untersuchen" en "Examine changes",
                    """
                    Lasse dir den Status zeigen,
                    und untersuche dann,
                    welche Commits im `main` des `origin`-Repository vorhanden sind,
                    welche im lokalen `main` noch nicht integriert wurden..
        """ en
                            """
                    Show the status,
                    and then examine
                    which commits are present in the `main` of the `origin` repository,
                    which have not yet been integrated into the local `main`.
        """
            ) {
                git("status")
                markdown(
                        """
                        Der Status zeigt, dass es im Origin-Repo
                        (auf dem Branch `main`) zwei Commits gibt,
                        die wir noch nicht integriert haben.
                    """ en
                                """
                        The status shows that there are two commits in the origin repo
                        (on the `main` branch)
                        that we have not yet integrated.
                    """
                )
                git("log main..origin/main")
                markdown(
                        """
                        Die `..`-Notation zeigt genau jene Commits,
                        die in `origing/main` aber noch nicht in `main` enthalten sind.
                        Etwas kürzer hätte man hier auch auch `git log ..origin/main` schreiben
                        könne, da wir `main` ja gerade `HEAD` ist.
                    """ en
                                """
                        The `..` notation shows exactly those commits
                        that are in `origin/main` but not yet in `main`.
                        A shorter way to write this would have been `git log ..origin/main`,
                        since `main` is currently `HEAD`.
                    """
                )
            }

            createAufgabe(
                    "zusammenarbeit-push-fetch-pull",
                    "Änderungen integrieren" en "Integrate changes",
                    """
                    Integriere die neuesten Commits vom `origin`-Repository
                    in den lokalen `main`.
        """ en
                            """
                    Integrate the latest commits from the `origin` repository
                    into the local `main`.
        """
            ) {
                git("pull")
                git("log --graph --oneline")
            }
        }
    }
}
