package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.klonen() {
    createAufgabenFolge("klonen") {
        createIntro(
                "Klonen von Repositorys" en "Cloning Repositories",
                """

                ## Tipps
                
                 * `git clone <original> <kopie>`: Klont ein Repository.
                 * `git remote -v`: Zeigt auf, welchen anderen Klone bekannt sind,
                   insbesondere `origin`.

                ## Setup
                
                Ein Git-Repository namens `myfirstrepo` wurde bereits erstellt.
                Es enthält zwei Commits.

                ### Verzeichnisse

                 * `${rootDir.name}/` Haupverzeichnis für diese Übung 
                   - `myfirstrepo/` Bereits vorhandenes Repository.
                  
            """ en
                        """

                ## Tips
                
                 * `git clone <original> <copy>`: Clones a repository.
                 * `git remote -v`: Shows which other clones are known,
                   especially `origin`.

                ## Setup
                
                A Git repository named `myfirstrepo` has already been created.
                It contains two commits.

                ### Directories

                 * `${rootDir.name}/` Main directory for this exercise
                   - `myfirstrepo/` Existing repository.
                  
            """
        ) {
            createRepo("myfirstrepo") {
                createFileAndCommit("foo")
                createFileAndCommit("bar")
            }
        }

        createAufgabe(
                "repository-klonen",
                "Klon durchführen" en "Perform clone",
                """Erstelle einen Klon von `myfirstrepo` mit dem Namen `myfirstclone`.""" en
                        """Create a clone of `myfirstrepo` named `myfirstclone`."""
        ) { git("clone myfirstrepo myfirstclone") }

        createAufgabe(
                "repository-klonen",
                "Klon untersuchen" en "Examine clone",
                """
                    Schaue die Commits an und
                    zeige den Origin des Klons `myfirstclone`.
                    `origin` steht in der Regel für jenes Repository,
                    von dem geklont wurde.
                    Zeige dann den Status.
                """ en
                        """
                    Look at the commits and
                    show the origin of the clone `myfirstclone`.
                    `origin` usually stands for the repository
                    from which it was cloned.
                    Then show the status.
                """
        ) {
            inRepo("myfirstclone") {
                git("log --oneline")
                git("remote -v")
            }
        }

        createAufgabe(  
                "repository-klonen",
                "Im Klon arbeiten" en "Work in the clone",
                """ Erstelle ein Commit und zeige dann den Status.""" en
                        """ Create a commit and then show the status."""
        ) {
            inRepo("myfirstclone") {
                editAndCommit("foo", 3)
                git("status")
            }
        }
    }
}
