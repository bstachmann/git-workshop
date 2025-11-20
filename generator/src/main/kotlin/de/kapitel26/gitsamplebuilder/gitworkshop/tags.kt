package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.tags() {
    createAufgabenFolge("tags") {
        createIntro(
                "Tags",
                """

                ## Tipps

                * Tags erstellen
                  - `git tag `mein-erstes-tag`
                  - optional darf eine Revision angegeben werden (Default: `HEAD`)
                * Einfache Tags sind nur Namen für Commits
                * Für Releases nutzt man *annotated Tags*, diesen tragen eine Beschreibung und Metadaten. 
                  Folgende Optionen sind hilfreich:
                  - `-a` sorgt für die Erstellung eines *annotated Tags*.
                  - `-m 'Und hier kommt Text'` für die Beschreibung                    
                * Tags werden beim *Push* nicht automatisch Übertragen.
                   - Man gibt entweder einzelne Tags an, z.B. `git push origin v1.0 v1.1`
                   - `git push --tags` überträgt tags
                * Beim Pull werden Tags in der Regel mit übertragen. 
                  Mit `--tags` kann man alle Tags übertragen lassen.
                * Empfehlung: Tags, die man mit Anderen teilt (push),
                  sollte man nicht mehr ändern.
                  Git warnt, bevor man geänderte Tags überträgt.
                  Notfalls kann man die Übertragung mit `-f` forcieren.
                            
                ## Setup
                                  
            """ en
                        """

                ## Tips

                * Create tags
                  - `git tag 'my-first-tag'`
                  - optionally a revision can be specified (default: `HEAD`)
                * Simple tags are just names for commits
                * For releases, one uses *annotated tags*, which carry a description and metadata.
                  The following options are helpful:
                  - `-a` ensures the creation of an *annotated tag*.
                  - `-m 'And here comes text'` for the description
                * Tags are not automatically transferred on *push*.
                   - You can either specify individual tags, e.g. `git push origin v1.0 v1.1`
                   - `git push --tags` transfers tags
                * Tags are usually transferred on pull.
                  With `--tags` you can have all tags transferred.
                * Recommendation: Tags that you share with others (push),
                  should not be changed anymore.
                  Git warns before transferring changed tags.
                  If necessary, you can force the transfer with `-f`.
                            
                ## Setup
                                  
            """
        ) {
            createRepo("blessed.git", "--bare") {
                createClone("../anderer-klon") {
                    createFileAndCommit("foobar", "Initial edit before cloning")
                    git("tag v0.1 -m 'initial'")
                    git("push --tags")
                    editAndCommit("foobar", 5, "Just editing")
                    git("push")
                }

                createClone("../mein-klon")
            }

            inRepo("anderer-klon") {
                git("tag v0.2  HEAD~1 -m 'A commit that was already pushed'")
                editAndCommit("foobar", 3, "First edit after cloning")
                git("tag v0.3 -m 'still unstable'")
                editAndCommit("foobar", 6, "Improve it")
                editAndCommit("foobar", 9, "Improve even more")
                git("tag v1.0 -m 'first release'")
                git("push --tags")
                editAndCommit("foobar", 1, "Do something")
                git("push")
            }
        }

        inRepo("mein-klon") {
            createAufgabe(
                    "Tags erstellen" en "Create tags",
                    """
                    Erstelle ein einfaches Tag `simple1` auf `HEAD` und
                    ein annotated Tag `annotated1` auf `HEAD~1`.
                    Sieh zuerst das Log und dann beide Tags einzeln an (`git show an`).
                """ en
                            """
                    Create a simple tag `simple1` on `HEAD` and
                    an annotated tag `annotated1` on `HEAD~1`.
                    First look at the log and then at both tags individually (`git show an`).
                """
            ) {
                git("tag simple1")
                git("tag annotated1 HEAD~1 -m 'Mit Beschreibung'")
                git("log --oneline --decorate")
                git("show simple1 --no-patch")
                markdown(
                        "Beim *annotated Tag* werden zusätzlich Beschreibung und Metadaten angezeigt:" en
                                "With the *annotated tag*, the description and metadata are also displayed:"
                )
                git("show annotated1 --no-patch")
            }

            createAufgabe(
                    "Tags holen" en "Fetch tags",
                    """
                    Einfach per pull.
                """ en
                            """
                    Simply by pull.
                """
            ) { git("pull") }

            createAufgabe(
                    "Tags pushen" en "Push tags",
                    """
                    Beim einfachen `git push` werden keine Tags übertragen.
                    Übertrage zunächste gezielt das Tag `simple1` mit einem Push
                    und danach alle weiteren Tags mit einem weiteren Push
                """ en
                            """
                    A simple `git push` does not transfer tags.
                    First, specifically transfer the tag `simple1` with a push
                    and then all other tags with another push
                """
            ) {
                git("push")
                git("push origin simple1")
                git("push --tags")
            }

            createAufgabe(
                    "Manipulieren" en "Manipulate",
                    """
                    Überschreibe das Tag `v0.1`, so dass es auf den`HEAD` zeigt.
                    Pushe das Tag.
                    Gehe in das Verzeichnis `../anderer-klon` und hole das Tag mit pull.
                    Schaue ins Log, um zu überprüfen, dass das Tag aktualisiert wurde.
                """ en
                            """
                    Overwrite the tag `v0.1` so that it points to `HEAD`.
                    Push the tag.
                    Go to the directory `../anderer-klon` and fetch the tag with pull.
                    Look at the log to verify that the tag has been updated.
                """
            ) {
                editAndCommit("foobar", 8, "Something else")
                git("tag v0.1 -f -m 'Moved later on'")
                git("push origin v0.1", acceptableExitCodes = setOf(1))
                git("push -f origin v0.1 ")
                git("log --oneline --decorate -3")
                inRepo("../anderer-klon") {
                    git("log --oneline --decorate")
                    git("pull")
                    git("pull --tags", acceptableExitCodes = setOf(1))
                    git("pull -f --tags")
                    git("log --oneline --decorate")
                }
            }
        }
    }
}
