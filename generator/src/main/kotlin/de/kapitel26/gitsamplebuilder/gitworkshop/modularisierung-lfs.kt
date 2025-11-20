package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.lfs() {

    createAufgabenFolge("lfs") {
        createIntro(
                """Git LFS""" en """Git LFS""",
                """
                Hier geht es um das [Git LFS (Large File System)](https://git-lfs.github.com/),
                das es ermöglicht große Artefakte, z. B. Bilder, Filme, Audio, 
                mit Git zu versionieren aber außerhalb des Repositorys zu speichern,
                so dass nicht bei jedem Clone alle Bilder geladen werden,
                sonden nur die für ein `checkout` jeweils benötigten.

                ## Installaction
                
                Installation unter debian/ubuntu:

                    $ sudo apt-get update
                    $ sudo apt-get install git-lfs

                ## Tipps
                
                * `git lfs install` richtet LFS in einem Repository ein.
                * `git lfs-track <pattern>` legt fest welche Dateien im LFS gespeichert werden sollen.\
                  Diese Einstellung wird in der Datei `.gitattributes` hinterlegt, 
                  die man mitversionieren sollte.
                * `git lfs ls-files` zeigt, welche Dateien im `HEAD` durch LFS verwaltet werden.\
                   Mit `--all` werden auch Dateien aus der Historie angezeigt.
                * `git lfs logs` zeigt Details, falls mal etwas schief geht.   


            """ en
                        """
                This is about [Git LFS (Large File System)](https://git-lfs.github.com/),
                which makes it possible to version large artifacts, e.g. images, movies, audio,
                with Git but store them outside the repository,
                so that not all images are loaded with every clone,
                but only those required for a `checkout`.

                ## Installation
                
                Installation on debian/ubuntu:

                    $ sudo apt-get update
                    $ sudo apt-get install git-lfs

                ## Tips
                
                * `git lfs install` sets up LFS in a repository.
                * `git lfs-track <pattern>` specifies which files should be stored in LFS.\
                  This setting is stored in the `.gitattributes` file,
                  which should be versioned.
                * `git lfs ls-files` shows which files in `HEAD` are managed by LFS.\
                   With `--all`, files from the history are also displayed.
                * `git lfs logs` shows details if something goes wrong.


            """
        ) {
            createRepo("repo.git", "--bare") {
                createClone("../repo") {
                    createFileAndCommit("README.md")
                    git("push")
                }
            }
        }

        inRepo() {
            createAufgabe(
                    "LFS einrichten" en "Set up LFS",
                    """
                    Richte LFS in für `png`-Dateien ein und pushe das Ergebnis.
                    Erzeuge dann eine `png`-Datei (muss kein echtes Bild sein)
                    und pushe erneut.
            """ en
                            """
                    Set up LFS for `png` files and push the result.
                    Then create a `png` file (doesn't have to be a real image)
                    and push again.
            """
            ) {
                git("lfs install")
                git("lfs track \"*.png\"")
                git("add .gitattributes")
                git("commit -m 'configure lfs'")
                git("push")

                createFileAndCommit(
                        "bild.png",
                ) { content = "erstes-fake-bild" }
                markdown(
                        """Schaut man sich das Diff des letzten Commits an,
                    | erkennt man, dass im Repository statt der eigentlichen Daten nur ein 
                    | Verweis gespeichert ist.""" en
                                """If you look at the diff of the last commit,
                    | you can see that only a reference is stored in the repository instead of the actual data.""".trimMargin()
                )
                git("show --oneline")

                git("push")
            }
        }

        createAufgabe(
                "Ein LFS-Repo klonen" en "Clone an LFS repo",
                """
                Klone das Repository.
                Schaue die `png`-Datei an. 
        """ en
                        """
                Clone the repository.
                Look at the `png` file.
        """
        ) {
            git("clone repo.git myclone")
            inRepo("myclone") { bash("cat bild.png") }
        }
        createAufgabe(
                "Noch ein Bild" en "Another picture",
                """
                Ändere das `png` in `repo` und pushe das Ergebnis. 
                Untersuche in `myclone` welche Dateien von LFS verwaltet werden.
        """ en
                        """
                Change the `png` in `repo` and push the result.
                Examine in `myclone` which files are managed by LFS.
        """
        ) {
            inRepo {
                inFile("bild.png") {
                    content = "zweites-fake-bild"
                    commit("überarbeitetes bild" en "revised picture")
                }
                git("push")
            }
            inRepo("myclone") {
                git("pull")
                git("lfs ls-files")
                git("lfs ls-files --all")
            }
        }

        createAufgabe(
                "Auf alte Versionen wechseln" en "Switch to old versions",
                """
                Erstelle einen neuen Klon `myclone2` und checke dort `main~2` aus.
                Schau Dir die `png`-Datei an.  
        """ en
                        """
                Create a new clone `myclone2` and check out `main~2` there.
                Look at the `png` file.
        """
        ) {
            git("clone repo.git myclone2")
            inRepo("myclone2") {
                git("-c advice.detachedHead=false checkout main~1")
                markdown(
                        "Beim Checkout wurde das bild nacheholt." en
                                "The picture was fetched during checkout."
                )
                bash("cat bild.png")
            }
        }

        createAufgabe(
                "Trouble",
                """
                Erstelle einen neuen Klon `myclone3`
                Entferne jetzt Hauptrepository durch `rm -rf repo.git` und versuche auf 
                dann in `myclone3` auf `main~2` zu wechseln. Was passiert?                
        """ en
                        """
                Create a new clone `myclone3`
                Now remove the main repository with `rm -rf repo.git` and then try to
                switch to `main~2` in `myclone3`. What happens?
        """
        ) {
            git("clone repo.git myclone3")

            bash("rm -rf repo.git repo.moved")

            inRepo("myclone3") {
                git("checkout HEAD~1", acceptableExitCodes = setOf(128))
                git("lfs logs last")
            }
        }
    }
}
