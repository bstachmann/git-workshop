package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.subtrees() {
    createAufgabenFolge("subtrees") {
        createIntro(
                "Modularisierung mit Subtrees" en "Modularization with Subtrees",
                """

                Es geht darum, wie man in Git ein übergreifendes
                Repository erstellt, dass Inhalte aus mehreren
                anderen Repository einbettet.
                
                Git bietet dazu zwei unterschiedliche Ansätze:
                Einer ist `git subtree`.
                Wir werden hier beide für folgende Anwendungsfälle erprobe:
                
                * Module als Subtree einbinden
                * Änderung aus einem Modul übernehmen
                * Änderung in ein Modul übertragen
                * Übergeordnetes Repo klonen
                
                ### Subtrees
                
                Bei diesem Ansatz werden Commits aus dem aus dem untergeordeten
                Repository übertragen und per `merge` integriert, 
                ganz ähnlich wie beim normalen `pull`.
                Die Besonderheit ist, dass Zur Integraion 
                dabei eine sogenanntes `subtree`-Merge erfolgt, 
                bei dem die Dateien in eine vorgegebenes Zielverzeichnis (`prefix`) verschoben werden.
                
                 * `subtree add --prefix=<Zielverzeichnis> <Quellrepository>`: Initales einbetten.
                 * `subtree pull --prefix=<Zielverzeichnis> <Quellrepository>`: Aktualisieren aus dem Quellrepository.
                 * `subtree push--prefix=<Zielverzeichnis> <Quellrepository>`: Übertragen ins Quellrepository.
                
                Tipp: Wer nicht mag,
                dass Subtree alle Commit aus dem Quellrepository holt,
                kann die Option `--squash` nutzen.

                ## Setup
                
                Zwei separate Repositorys `frontend` und `backend` sind vorhanden.
                Diese sollen in ein übergeordnetes Repo `application` eingebettet werden.

                ```
                application/
                |- frontend/
                |- backen/
                ```
                  
            """ en
                        """

                This is about how to create a comprehensive
                repository in Git that embeds content from several
                other repositories.
                
                Git offers two different approaches for this:
                One is `git subtree`.
                We will try both here for the following use cases:
                
                * Integrating modules as subtrees
                * Adopting changes from a module
                * Transferring changes to a module
                * Cloning the parent repo
                
                ### Subtrees
                
                In this approach, commits from the subordinate
                repository are transferred and integrated via `merge`,
                very similar to a normal `pull`.
                The special feature is that for integration,
                a so-called `subtree` merge takes place,
                in which the files are moved to a specified target directory (`prefix`).
                
                 * `subtree add --prefix=<target-directory> <source-repository>`: Initial embedding.
                 * `subtree pull --prefix=<target-directory> <source-repository>`: Update from the source repository.
                 * `subtree push--prefix=<target-directory> <source-repository>`: Transfer to the source repository.
                
                Tip: If you don't like
                that subtree fetches all commits from the source repository,
                you can use the `--squash` option.

                ## Setup
                
                Two separate repositories `frontend` and `backend` are available.
                These are to be embedded in a parent repo `application`.

                ```
                application/
                |- frontend/
                |- backend/
                ```
                  
            """
        ) {
            createRepo("frontend.git", "--bare") { createClone("../frontend") }
            createRepo("backend.git", "--bare") { createClone("../backend") }

            inRepo("frontend") {
                createFileAndCommit("main.ts")
                git("push")
            }

            inRepo("backend") {
                createFileAndCommit("service.java")
                git("push")
            }

            createRepo("application") { createFileAndCommit("README") }
        }

        inRepo("application") {
            createAufgabe(
                    "modularisierung-subtrees",
                    "Module als Subtree einbinden" en "Integrating modules as subtrees",
                    """
                    Binde die Module `frontend.git` und `backend.git`
                    per `subtree add` ein.
                    Untersuche dann die entstandene Verzeichnisstruktur.
                    """ en
                            """
                    Integrate the modules `frontend.git` and `backend.git`
                    using `subtree add`.
                    Then examine the resulting directory structure.
                    """
            ) {
                git("subtree add --prefix=frontend ../frontend.git main")
                git("subtree add --prefix=backend ../backend.git main")
                git("ls-tree -r HEAD")
            }
        }

        createAufgabe(
                "modularisierung-subtrees",
                "Änderung aus einem Modul übernehmen" en "Adopting changes from a module",
                """
                    Gehe in das Repo `backend` ändere die Datei `service.java`, committe und pushe.
                    Sie Dir das entstandene Commit an (`show --stat`)
                    Gehe in das Repo `application` und hole die Änderungen per `subtree pull` ab.
                    Sieh Dir das übertragene Commit an.
                    """ en
                        """
                    Go to the `backend` repo, change the `service.java` file, commit and push.
                    Look at the resulting commit (`show --stat`)
                    Go to the `application` repo and fetch the changes using `subtree pull`.
                    Look at the transferred commit.
                    """
        ) {
            inRepo("backend") {
                editAndCommit("service.java", 7)
                git("show --stat ")
                git("push")
            }

            inRepo("application") {
                git("subtree pull --prefix=backend ../backend.git main")
                git("show --stat ")
            }
        }

        createAufgabe(
                "modularisierung-subtrees",
                "Änderung in ein Modul übertragen" en "Transferring changes to a module",
                """
                    Gehe in `application` ändere `frontend/main.ts` und committe.
                    Übertrage die Änderung per `subtree push` nach `frontend.git`.
                    Sieh Dir das übertragene Commit in `frontend.git` an.
                    """ en
                        """
                    Go to `application`, change `frontend/main.ts` and commit.
                    Transfer the change to `frontend.git` using `subtree push`.
                    Look at the transferred commit in `frontend.git`.
                    """
        ) {
            inRepo("application") {
                editAndCommit("frontend/main.ts", 3)
                git("subtree push --prefix=frontend ../frontend.git main")
            }

            inRepo("frontend.git") { git("show --stat ") }
        }

        createAufgabe(
                "modularisierung-subtrees",
                "Übergeordnetes Repo klonen" en "Cloning the parent repo",
                """
                    Klone `application` zu `myapplication`.
                    Untersuche die `HEAD` Verzeichnisstruktur,
                    und den Commit-graphen.
                    """ en
                        """
                    Clone `application` to `myapplication`.
                    Examine the `HEAD` directory structure,
                    and the commit graph.
                    """
        ) {
            git("clone application myapplication")

            inRepo("myapplication") {
                markdown(
                        "Man sieht, dass die Einbettungen" +
                                " als normale Dateien und Verzeichnisse" +
                                " im `HEAD`-Tree erscheinen" en
                                "You can see that the embeddings" +
                                        " appear as normal files and directories" +
                                        " in the `HEAD` tree"
                )
                git("ls-tree -r HEAD .")
                markdown(
                        "Im Commit-Graphen sieht man," + " woher die Daten kommen." en
                                "In the commit graph you can see," + " where the data comes from."
                )
                git("log --graph --oneline --stat")
            }
        }
    }
}
