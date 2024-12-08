package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.submodules() {
    createAufgabenFolge("submodules") {

        createIntro(
                """Modularisierung mit Submodules""",
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

            createRepo("application") {
                createFileAndCommit("README")
            }

        }

        inRepo("application") {
            createAufgabe(
                    "Module als Submodule einbinden",
                    """
                    Binde die Module `frontend.git` und `backend.git`
                    per `submodule add` ein.
                    Untersuche dann die entstandene Verzeichnisstruktur.
                    """
            ) {
                git("submodule add  ../frontend.git frontend")
                git("submodule add  ../backend.git backend")
                markdown("Man sieht, dass die Module als eigenständige" +
                        " Git-Repositorys mit separatem `.git`-Verzeichnis" +
                        " eingebettet wurden.")
                ll("frontend backend")
                markdown("Achtung! Die submodule wurden hinzugefügt, aber es fehlt noch ein Commit.")
                git("status")
                git("commit -m 'add frontend and backend'")
            }
        }

        createAufgabe(
                "Änderung aus einem Modul übernehmen",
                """
                    Gehe in das Repo `backend` ändere die Datei `service.java`, committe und pushe.
                    Sie Dir das entstandene Commit an (`show --stat`)
                    Gehe in das Repo `application/backend` und hole die Änderungen per `pull` ab.
                    Sieh Dir das übertragene Commit an.
                    """
        ) {
            inRepo("backend") {
                editAndCommit("service.java", 8)
                git("show --stat ")
                git("push")
            }

            inRepo("application") {
                inRepo("backend") {
                    git("pull")
                }
                git("add backend")
                git("commit -am 'updated backend'")
            }
        }

        createAufgabe(
                "Änderung in ein Modul übertragen",
                """
                    Gehe in `subtrees/frontend` ändere `main.ts` und committe.
                    Übertrage die Änderung per `push` nach `frontend.git`.
                    Sieh Dir das übertragene Commit in `frontend.git` an.
                    """
        ) {
            inRepo("application") {
                inRepo("frontend") {
                    editAndCommit("main.ts", 5)
                    git("push")
                }
                markdown("Nicht vergessen: Änderungen am im übergeordenten Repository committen.")
                git("add frontend")
                git("commit -m 'new version of frontend'")
            }

            inRepo("frontend.git") {
                git("show --stat ")
            }
        }

        createAufgabe(
                "Übergeordnetes Repo klonen",
                """
                    Klone `application` zu `myapplication`.
                    Untersuche die Verzeichnisstruktur.
                    Vergiß nicht, ein `submodule update` auszuführen.
                    """
        ) {
            git("clone application myapplication")

            inRepo("myapplication") {
                markdown("Die Modulverzeichnisse sind da aber noch leer:")
                ll("frontend backend")
                markdown("Jetzt holen wir die Module:")
                git("submodule update --init")
                ll("frontend backend")
            }
        }
    }
}
