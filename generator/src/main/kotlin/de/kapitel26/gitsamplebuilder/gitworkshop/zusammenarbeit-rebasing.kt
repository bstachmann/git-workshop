package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.rebasing() {
    createAufgabenFolge("rebasing") {
        createIntro(
                "Rebasing",
                """

                
                Rebasing ist, neben dem Merging, eine weitere Möglichkeit,
                Änderung zu integrieren.

                ## Infos
                
                * `git rebase` 

                ## Tipps
                
                * `git rebase`
                  
                ## Ausgangssituation

            """ en
                        """

                
                Rebasing is, besides merging, another way
                to integrate changes.

                ## Info
                
                * `git rebase` 

                ## Tips
                
                * `git rebase`
                  
                ## Initial situation

            """
        ) {
            createRepo {
                createFileAndCommit("foo")
                createFileAndCommit("bar")

                startBranch("feature") {
                    editAndCommit("foo", 3, "Feature anfangen.")
                    editAndCommit("foo", 5, "Feature weitermachen.")
                }

                editAndCommit("bar", 1, "Neuerung auf dem main")

                git("switch feature")
            }
        }

        inRepo {
            createAufgabe(
                    "zusammenarbeit-rebasing",
                    "Feature-Branch per Rebase aktualiseren." en
                            "Update feature branch via rebase.",
                    """
                    Auf dem main gibt es Neuerungen.
                    
                    Lasse Dir den Commit-Graphen über alle Branches zeigen.
 
                    Aktualisiere Deinen Feature-Branch.
                    
                    Lasse Dir den Commit-Graphen über alle Branches zeigen.
                    """ en
                            """
                    There are new features on main.
                    
                    Show the commit graph across all branches.
 
                    Update your feature branch.
                    
                    Show the commit graph across all branches.
                    """
            ) {
                git("log --graph --all --decorate --oneline")

                git("rebase main")

                git("log --graph --all --decorate --oneline")
            }
        }
    }
}
