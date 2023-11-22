package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.tags() {
    createAufgabenFolge("tags") {

        createIntro(
            """Tags""",
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
                   - `git push --tags` überträgt Tags
                * Empfehlung: Tags, die man mit Anderen teilt (push),
                  sollte man nicht mehr ändern.
                  Git warnt, bevor man geänderte Tags überträgt.
                  Notfalls kann man die Übertragung mit `-f` forcieren.
                            
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
                "Tags erstellen", """
                    Erstelle ein einfaches Tag `simple1` auf `HEAD` und
                    ein annotated Tag `annotated1` auf `HEAD~1`.
                    Sieh zuerst das Log und dann beide Tags einzeln an (`git show an`).
                """
            ) {
                    git("tag simple1")
                    git("tag annotated1 HEAD~1 -m 'Mit Beschreibung'")
                    git("log --oneline --decorate")
                    git("show simple1 --no-patch")
                    markdown("Beim *annotated Tag* werden zusätzlich Beschreibung und Metadaten angezeigt:")
                    git("show annotated1 --no-patch")
            }

            createAufgabe(
                "Tags holen", """
                    Einfach per pull.
                """
            ) {
                git("pull")
            }                    


            createAufgabe(
                "Tags pushen", """
                    Beim einfachen `git push` werden keine Tags übertragen.
                    Übertrage zunächste gezielt das Tag `simple1` mit einem Push
                    und danach alle weiteren Tags mit einem weiteren Push
                """
            ) {
                git("push")
                git("push origin simple1")
                git("push --tags")
            }

            createAufgabe(
                "Manipulieren", """
                    Überschreibe das Tag `v0.1`, so dass es auf den`HEAD` zeigt.
                    Pushe das Tag.
                    Gehe in das Verzeichnis `../anderer-klon` und hole das Tag mit pull.
                    Schaue ins Log, um zu überprüfen, dass das Tag aktualisiert wurde.
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