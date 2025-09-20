package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.submodules() {
    createAufgabenFolge("submodules") {
        createIntro(
                "Modularisierung mit Submodules" en "Modularization with Submodules",
                """

                Es geht darum, wie man in Git ein übergreifendes
                Repository erstellt, dass Inhalte aus mehreren
                anderen Repository einbettet.
                
                Git bietet dazu zwei unterschiedliche Ansätze:
                Eine davon ist `git submodule`.
                Wir werden hier beide für folgende Anwendungsfälle erprobe:
                
                * Module als Submodule einbinden
                * Änderung aus einem Modul übernehmen
                * Änderung in ein Modul übertragen
                * Übergeordnetes Repo klonen
                
                ### Submodules
                
                Bei einem Submodule werden Git-Repositorys ineinander geschachtelt.
                Das übergeordnete Repo merkt sich dann für jedes untergeordnete Repo (*submodule*)
            
                
                 1. von wo geklont werden soll (URL) und
                 2. welche Revison benötigt wird.
                
                Da die Submodules in ihren Verzeichnissen eigenständige Git-Repositorys sind,
                kann man dort mit den üblichen Befehlen wie `switch`, `pull` oder auch `commit` arbeiten.
                Wenn man die Änderungen im übergeordneten Repo übernehmen möchen,
                tut dies durch ein *top-level*-commit.
                
                 * `git submodule add  <Quellrepository> <Zielverzeichnis>`:> Initales einbetten. *Danach* Commit erforderlich.
                 * `git submodule update --init`:> Holt beziehungsweise aktualisiert. Nach dem Klonen erforderlich. 
            
                

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
                One of them is `git submodule`.
                We will try both here for the following use cases:
                
                * Integrating modules as submodules
                * Adopting changes from a module
                * Transferring changes to a module
                * Cloning the parent repo
                
                ### Submodules
                
                With a submodule, Git repositories are nested within each other.
                The parent repo then remembers for each child repo (*submodule*)
            
                
                 1. where to clone from (URL) and
                 2. which revision is needed.
                
                Since the submodules are independent Git repositories in their directories,
                you can work there with the usual commands like `switch`, `pull` or `commit`.
                If you want to apply the changes in the parent repo,
                you do this with a *top-level* commit.
                
                 * `git submodule add <source-repository> <target-directory>`:> Initial embedding. *Afterwards* a commit is required.
                 * `git submodule update --init`:> Fetches or updates. Required after cloning.
            
                

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
                    "Module als Submodule einbinden" en "Integrating modules as submodules",
                    """
                    Binde die Module `frontend.git` und `backend.git`
                    per `submodule add` ein.
                    Untersuche dann die entstandene Verzeichnisstruktur.
                    """ en
                            """
                    Integrate the modules `frontend.git` and `backend.git`
                    using `submodule add`.
                    Then examine the resulting directory structure.
                    """
            ) {
                git("submodule add  ../frontend.git frontend")
                git("submodule add  ../backend.git backend")
                markdown(
                        "Man sieht, dass die Module als eigenständige" +
                                " Git-Repositorys mit separatem `.git`-Verzeichnis" +
                                " eingebettet wurden." en
                                "You can see that the modules are embedded as independent" +
                                        " Git repositories with a separate `.git` directory."
                )
                ll("frontend backend")
                markdown(
                        "Achtung! Die submodule wurden hinzugefügt, aber es fehlt noch ein Commit." en
                                "Attention! The submodules have been added, but a commit is still missing."
                )
                git("status")
                git("commit -m 'add frontend and backend'")
            }
        }

        createAufgabe(
                "Änderung aus einem Modul übernehmen" en "Adopting changes from a module",
                """
                    Gehe in das Repo `backend` ändere die Datei `service.java`, committe und pushe.
                    Sie Dir das entstandene Commit an (`show --stat`)
                    Gehe in das Repo `application/backend` und hole die Änderungen per `pull` ab.
                    Sieh Dir das übertragene Commit an.
                    """ en
                        """
                    Go to the `backend` repo, change the `service.java` file, commit and push.
                    Look at the resulting commit (`show --stat`)
                    Go to the `application/backend` repo and fetch the changes using `pull`.
                    Look at the transferred commit.
                    """
        ) {
            inRepo("backend") {
                editAndCommit("service.java", 8)
                git("show --stat ")
                git("push")
            }

            inRepo("application") {
                inRepo("backend") { git("pull") }
                git("add backend")
                git("commit -am 'updated backend'")
            }
        }

        createAufgabe(
                "Änderung in ein Modul übertragen" en "Transferring changes to a module",
                """
                    Gehe in `subtrees/frontend` ändere `main.ts` und committe.
                    Übertrage die Änderung per `push` nach `frontend.git`.
                    Sieh Dir das übertragene Commit in `frontend.git` an.
                    """ en
                        """
                    Go to `subtrees/frontend`, change `main.ts` and commit.
                    Transfer the change to `frontend.git` using `push`.
                    Look at the transferred commit in `frontend.git`.
                    """
        ) {
            inRepo("application") {
                inRepo("frontend") {
                    editAndCommit("main.ts", 5)
                    git("push")
                }
                markdown(
                        "Nicht vergessen: Änderungen am im übergeordenten Repository committen." en
                                "Don't forget: commit changes in the parent repository."
                )
                git("add frontend")
                git("commit -m 'new version of frontend'")
            }

            inRepo("frontend.git") { git("show --stat ") }
        }

        createAufgabe(
                "Übergeordnetes Repo klonen" en "Cloning the parent repo",
                """
                    Klone `application` zu `myapplication`.
                    Untersuche die Verzeichnisstruktur.
                    Vergiß nicht, ein `submodule update` auszuführen.
                    """ en
                        """
                    Clone `application` to `myapplication`.
                    Examine the directory structure.
                    Don't forget to run `submodule update`.
                    """
        ) {
            git("clone application myapplication")

            inRepo("myapplication") {
                markdown(
                        "Die Modulverzeichnisse sind da aber noch leer:" en
                                "The module directories are there but still empty:"
                )
                ll("frontend backend")
                markdown("Jetzt holen wir die Module:" en "Now we fetch the modules:")
                git("submodule update --init")
                ll("frontend backend")
            }
        }
    }
}
