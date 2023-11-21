package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.tags() {
    createAufgabenFolge("tags") {

        createIntro(
            """Tags""",
            """

                ## Tipps

                * `git tag`
                
                TODO
            
                ## Setup
                                  
            """
        ) {
            createRepo("blessed.git", "--bare") {

                createClone("../anderer-klon") {
                    createFileAndCommit("foobar", "Initial edit before cloning")
                    git("tag v0.1 -m 'initial'")
                    git("push")
                }

                createClone("../mein-klon")
            }

            inRepo("anderer-klon") {
                editAndCommit("foobar", 3, "First edit after cloning")
                git("tag v0.2 -m 'still unstable'")
                editAndCommit("foobar", 6, "Improve it")
                editAndCommit("foobar", 9, "Improve even more")
                git("tag v1.0 -m 'first release'")
                editAndCommit("foobar", 1, "Do something")
                git("push")
            }
        }

        inRepo("mein-klon") {

            createAufgabe(
                "Tags nach dem Klonen", """
                    TODO.
        """
            ) {
                git("tag")
                git("pull")
                git("tag")
            }
        }
    }
}