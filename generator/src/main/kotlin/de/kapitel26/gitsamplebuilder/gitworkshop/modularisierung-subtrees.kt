package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.subtrees() {
    createAufgabenFolge("subtrees") {

        createIntro(
                """Modularisierung mit Subtrees""",
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
                
                Zwei Repositorys `frontend` und `backend` sind vorhanden.
                Diese sollen 

                ### Verzeichnisse

                 * `${rootDir.name}/` Haupverzeichnis für diese Übung 
                   - `myfirstrepo/` Bereits vorhandenes Repository.
                  
                  
            """
        ) {
            createRepo("frontend.git", "--bare") { createClone("../frontend") }
            createRepo("backend.git", "--bare") { createClone("../backend") }

            inRepo("frontend") {
                createFileAndCommit("anton")
                git("push")
            }

            inRepo("backend") {
                createFileAndCommit("berta")
                git("push")
            }

            createRepo("subtrees") {
                createFileAndCommit("README")
            }
        }

        inRepo("subtrees") {
            createAufgabe(
                    "Module als Subtree einbinden",
                    """
                    Binde die Module `frontend.git` und `backend.git`
                    per `subtree add` ein.
                    Untersuche dann die entstandene Verzeichnisstruktur.
                    """
            ) {
                git("subtree add --prefix=frontend ../frontend.git main")
                git("subtree add --prefix=backend ../backend.git main")
                git("ls-tree -r HEAD")
            }
        }

        createAufgabe(
                "Änderung aus einem Modul übernehmen",
                """
                    Gehe in das Repo `backend` ändere die Datei `berta`, committe und pushe.
                    Sie Dir das entstandene Commit an (`show --stat`)
                    Gehe in das Repo `subtrees` und hole die Änderungen per `subtree pull` ab.
                    Sieh Dir das übertragene Commit an.
                    """
        ) {
            inRepo("backend") {
                editAndCommit("berta", 7)
                git("show --stat ")
                git("push")
            }

            inRepo("subtrees") {
                git("subtree pull --prefix=backend ../backend.git main")
                git("show --stat ")
            }
        }

        createAufgabe(
                "Änderung in ein Modul übertragen",
                """
                    Gehe in `subtrees` ändere `frontend/anton` und committe.
                    Übertrage die Änderung per `subtree push` nach `frontend.git`.
                    Sieh Dir das übertragene Commit in `frontend.git` an.
                    """
        ) {
            inRepo("subtrees") {

                editAndCommit("frontend/anton", 3)
                git("subtree push --prefix=frontend ../frontend.git main")
            }

            inRepo("frontend.git") {
                git("show --stat ")
            }
        }

        createAufgabe(
                "Übergeordnetes Repo klonen",
                """
                    Klone `subtrees` zu `mysubtrees`.
                    Untersuche die `HEAD` Verzeichnisstruktur,
                    und den Commit-graphen.
                    """
        ) {
            git("clone subtrees mysubtrees")

            inRepo("mysubtrees") {
                markdown("Man sieht, dass die Einbettungen" +
                        " als normale Dateien und Verzeichnisse" +
                        " im `HEAD`-Tree erscheinen")
                git("ls-tree -r HEAD .")
                markdown("Im Commit-Graphen sieht man," +
                        " woher die Daten kommen.")
                git("log --graph --oneline --stat")
            }
        }
    }
}
