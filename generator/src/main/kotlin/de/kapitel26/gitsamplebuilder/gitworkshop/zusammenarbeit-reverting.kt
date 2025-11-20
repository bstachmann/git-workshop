package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.reverting() {
    createAufgabenFolge("reverting") {
        createIntro(
                "Reverting",
                """
                Git ermöglicht es Änderungen, 
                die in einem früheren Commits gemacht wurden,
                durch ein neues Commit wieder rückgängig zu machen.
               
                ## Infos
                
                * `git revert <commit>` erstellt ein neues Commit, 
                  welches die Änderungen eines früheren Commmits wieder
                  rückgängig macht.

                * Bei einem Merge-Commit
                  muss man zusätzlich Angeben auf welchen Merge-Parent
                  sich die Ermittlung der Änderungen beziehen soll:<br/>
                  `git revert -m 1 <merge-commit>` 

                * Bei weiter zurückliegenden Commits kann es zu Konflikten kommen
                  (weil betroffene Dateien in späteren Commits weiter bearbeitet wurden).
                  Diese müssen dann wie bei Merge-Konflikten aufgelöst werden.

                ## Zum Beispielsetup
                
                Im Beispielrepository wurde eine Datei umbennant,
                das entsprechende Commit ist mit `umbenennung` getagged.

                Außerdem wurde ein Feature-Branch per Merge integriert.
                Das Merge-Commit ist mit `feature-merge` getagged.

                Beide Änderungen sollen zurückgenommen werden.
            """ en
                        """
                Git allows changes
                made in an earlier commit
                to be undone by a new commit.
               
                ## Info
                
                * `git revert <commit>` creates a new commit,
                  which undoes the changes of an earlier commit.

                * With a merge commit
                  you must also specify to which merge parent
                  the determination of the changes should refer:<br/>
                  `git revert -m 1 <merge-commit>` 

                * With commits further back, conflicts can occur
                  (because affected files were further edited in later commits).
                  These must then be resolved like merge conflicts.

                ## Example setup
                
                In the example repository, a file was renamed,
                the corresponding commit is tagged with `umbenennung`.

                In addition, a feature branch was integrated via merge.
                The merge commit is tagged with `feature-merge`.

                Both changes are to be undone.
            """
        ) {
            createRepo {
                createFileAndCommit("README.md")

                startBranch("feature") { createFileAndCommit("from-feature") }

                git("mv README.md liesmich")
                git("commit -m 'umbenennen'")
                git("tag umbenennung")

                git("merge feature")
                git("tag feature-merge")

                onBranch("feature") {
                    editAndCommit("from-feature", 1, message = "Weiterentwicklung")
                }
            }
        }

        inRepo {
            createAufgabe(
                    "zusammenarbeit-reverting",
                    "Einzelnes Commit rückgängig machen." en "Undo a single commit.",
                    """
                    In der Historie wurde die Datei `README.md` in `liesmich`
                    umbenannt. Mache diese Änderung rückgängig.
                    Tipp: Das Commit ist als `umbenennung` getagged.
                    """ en
                            """
                    In the history, the file `README.md` was renamed to `liesmich`.
                    Undo this change.
                    Tip: The commit is tagged as `umbenennung`.
                    """
            ) {
                bash("ls")
                git("revert umbenennung")
                bash("ls")
            }

            createAufgabe(
                    "zusammenarbeit-reverting",
                    "Merge-Commit rückgängig machen." en "Undo merge commit.",
                    """
                    In der Historie wurde ein Feature-Branch per Merge integriert.file . Mache dies änderung rückgängig.
                    Tipp: Das Merge-Commit ist als `feature-merge` getagged. 
                    Tipp: Am verschinden der Datei `from-feature` kann man den Erfolg erkennen.
                    """ en
                            """
                    In the history, a feature branch was integrated via merge.file . Undo this change.
                    Tip: The merge commit is tagged as `feature-merge`.
                    Tip: The success can be recognized by the disappearance of the file `from-feature`.
                    """
            ) {
                bash("ls")

                git("revert -m 1 feature-merge")

                bash("ls")
                git("tag merge-reverted")
            }

            createAufgabe(
                    "zusammenarbeit-reverting",
                    "Feature-Branch kaputt!?" en "Feature branch broken!?",
                    """
                    Ein Revert wird oft genutzt, um ein Feature kurzfristig zurückzunehmen,
                    z. B. wegen eine Produktionsproblems.
                    Später möchte man den Feature-Branch korrigieren und dann erneut integrieren. 
                    Das geht nicht so ohne weiteres.

                    Im Beispiel hat der Branch `feature` eine Weiterentwicklung erfahren.
                    Versuche ihn erneut zu Mergen.
                    Untersuche die Fehlermeldung und den Commit-Graphen.
                    Tipp: Das gescheiterte Merge kann mit `git merge --abort` abgebrochen werden.
                    """ en
                            """
                    A revert is often used to temporarily roll back a feature,
                    e.g. due to a production problem.
                    Later you want to correct the feature branch and then integrate it again.
                    This is not so easy.

                    In the example, the `feature` branch has undergone further development.
                    Try to merge it again.
                    Examine the error message and the commit graph.
                    Tip: The failed merge can be aborted with `git merge --abort`.
                    """
            ) {
                git("merge feature", acceptableExitCodes = setOf(1))
                git("merge --abort")
                git("log --oneline --graph")
                markdown(
                        """
                    Das Merge scheitert, weil Git Commits,
                    die schon in der Historie enthalten sind,
                    nicht erneut merged.
                    Dies betrifft im Beispiel jenes Commit, 
                    das die Datei `from-feature` erzeugt.
                    Es ist in der Historie enthalten und
                    in einem späteren Commit (Dem Revert) wurde die Datei gelöscht.
                    Der Mergekonflikt meldet also, dass die Datei auf der einen
                    Seite bearbeitet und auf der Anderen gelöscht wurde.
                """ en
                                """
                    The merge fails because Git commits
                    that are already in the history
                    are not merged again.
                    In the example, this affects the commit
                    that creates the file `from-feature`.
                    It is contained in the history and
                    in a later commit (the revert) the file was deleted.
                    The merge conflict therefore reports that the file on one
                    side was edited and on the other was deleted.
                """
                )
            }

            createAufgabe(
                    "zusammenarbeit-reverting",
                    "Merge-Revert wieder rückgängig machen." en "Undo merge revert again.",
                    """
                    Der Trick ist, das Revert-Commit selbst zu reverten,
                    dann sind jene Änderungen wieder da,
                    auf denen die Weiterentwicklung des Features basiert.

                    Tipp: Das Commit ist als `feature-merge` getagged.
                    """ en
                            """
                    The trick is to revert the revert commit itself,
                    then those changes are back
                    on which the further development of the feature is based.

                    Tip: The commit is tagged as `feature-merge`.
                    """
            ) {
                git("revert merge-reverted")
                git("merge feature")

                git("log --oneline --graph")
                git("log --oneline from-feature")
            }
        }
    }
}
