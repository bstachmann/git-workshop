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
                
                Zwei Repositorys `mod-a` und `mod-b` sind vorhanden.
                Diese sollen in das übergeordnete repo `submodules` eingebettet werden.
      
                  
            """
        ) {
            createRepo("mod-a.git", "--bare") { createClone("../mod-a") }
            createRepo("mod-b.git", "--bare") { createClone("../mod-b") }

            inRepo("mod-a") {
                createFileAndCommit("anton")
                git("push")
            }

            inRepo("mod-b") {
                createFileAndCommit("berta")
                git("push")
            }

            createRepo("subtrees") {
                createFileAndCommit("README")
            }

            createRepo("submodules") {
                createFileAndCommit("README")
            }

        }

        inRepo("submodules") {
            createAufgabe(
                    "Module als Submodule einbinden",
                    """
                    Binde die Module `mod-a.git` und `mod-b.git`
                    per `submodule add` ein.
                    Untersuche dann die entstandene Verzeichnisstruktur.
                    """
            ) {
                git("submodule add  ../mod-a.git mod-a")
                git("submodule add  ../mod-b.git mod-b")
                markdown("Man sieht, dass die Module als eigenständige" +
                        " Git-Repositorys mit separatem `.git`-Verzeichnis" +
                        " eingebettet wurden.")
                ll("mod-a mod-b")
                markdown("Achtung! Die submodule wurden hinzugefügt, aber es fehlt noch ein Commit.")
                git("status")
                git("commit -m 'add mod-a and mod-b'")
            }
        }

        createAufgabe(
                "Subtree: Änderung aus einem Modul übernehmen",
                """
                    Gehe in das Repo `mod-b` ändere die Datei `berta`, committe und pushe.
                    Sie Dir das entstandene Commit an (`show --stat`)
                    Gehe in das Repo `submodules/mod-b` und hole die Änderungen per `pull` ab.
                    Sieh Dir das übertragene Commit an.
                    """
        ) {
            inRepo("mod-b") {
                editAndCommit("berta", 8)
                git("show --stat ")
                git("push")
            }

            inRepo("submodules") {
                inRepo("mod-b") {
                    git("pull")
                }
                git("add mod-b")
                git("commit -am 'updated mod-b'")
            }
        }

        createAufgabe(
                "Änderung in ein Modul übertragen",
                """
                    Gehe in `subtrees/mod-a` ändere `anton` und committe.
                    Übertrage die Änderung per `push` nach `mod-a.git`.
                    Sieh Dir das übertragene Commit in `mod-a.git` an.
                    """
        ) {
            inRepo("submodules") {
                inRepo("mod-a") {
                    editAndCommit("anton", 5)
                    git("push")
                }
                markdown("Nicht vergessen: Änderungen am im übergeordenten Repository committen.")
                git("add mod-a")
                git("commit -m 'new version of mod-a'")
            }

            inRepo("mod-a.git") {
                git("show --stat ")
            }
        }

        createAufgabe(
                "Übergeordnetes Repo klonen",
                """
                    Klone `submodules` zu `mysubmodules`.
                    Untersuche die Verzeichnisstruktur.
                    Vergiß nicht, ein `submodule update` auszuführen.
                    """
        ) {
            git("clone submodules mysubmodules")

            inRepo("mysubmodules") {
                markdown("Die Modulverzeichnisse sind da aber noch leer:")
                ll("mod-a mod-b")
                markdown("Jetzt holen wir die Module:")
                git("submodule update --init")
                ll("mod-a mod-b")
            }
        }
    }
}
