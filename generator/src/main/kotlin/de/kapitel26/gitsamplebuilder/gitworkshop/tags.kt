package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.tags() {
    createAufgabenFolge("tags") {

        createIntro(
            """Tags""",
            """

                ## Tipps

                * `git tag <name> <revision>` 
                *  Tags werden beim *Push* nicht automatisch Übertragen.
                   Man gibt entweder einzelne Tags an, oder `--tags` um alle Tags zu übertragen.  
                    `git push origin v1.0 v1.1`
                    `git push --tags`
                
                TODO tag, annotated, push/pull, describe
            
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
                    Sieh das erst das Log und dann eide Tags mit `git show an`.
                """
            ) {
                    git("tag simple1")
                    git("tag annotated1 HEAD~1 -m 'Mit Beschreibung'")
                    git("show simple1 --no-patch")
                    git("show annotated1 --no-patch")
                    git("log --oneline --decorate")
            }

            createAufgabe(
                "Tags pullen", """
                    TODO.
                """
            ) {
                git("pull")
            }                    


            createAufgabe(
                "Tags pushen", """
                    TODO.
                """
            ) {
                git("push")
                git("push origin simple1")
                git("push --tags")
            }

            createAufgabe(
                "Manipulieren", """
                    TODO.
                """
            ) {
                editAndCommit("foobar", 8, "Something else")
                git("tag v0.1 -f -m 'Moved later on'")
                git("push origin v0.1", acceptableExitCodes = setOf(1))
                git("push -f origin v0.1 ")
                git("log --oneline --decorate")
                inRepo("../anderer-klon") {
                    git("log --oneline --decorate")
                    git("pull")
                    git("log --oneline --decorate")
                    git("pull --tags", acceptableExitCodes = setOf(1))
                    git("pull -f --tags")
                    git("log --oneline --decorate")
                }
            }
        }
    }    
}