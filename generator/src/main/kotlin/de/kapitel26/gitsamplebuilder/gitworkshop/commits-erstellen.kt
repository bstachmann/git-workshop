package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.erstellen() {

    createAufgabenFolge("erstellen") {

        createIntro(
                """Commits erstellen""",
                """

                ## Tipps
                
                * `git add <datei/verzeichnis>` 
                   Vor einem Commit müssen Änderungen mit `add` im Staging-Bereich 
                   (auch Index genannt) registriert werden
                * Als Verzeichnisname darf auch `.` (steht für *aktuelles Verzeichnis*) angegeben werden.
                  Dann wird der Befehl auf alle Dateien im aktuellen Verzeichnis und auch Unterverzeichnissen angewandt/
                * `git commit -m 'Mein Senf'` Erstellt ein Commit mit allen 
                   im Staging-Bereich registrierten Änderungen.
                * `git commit -a` Registriert alle Änderungen an bereits in Git versionierten 
                  Dateien im Staging-Bereich, so dass man sich den separaten
                  `add`-Aufruf sparen kann.
                * Die optionen `-a` und `-m` dürfen auch kombiniert werden: `git commit -am "Kommentar"`
                * `git log --follow -- <file-name>`
                   Zeigt die Historie einer Datei auch über Umbenennungen hinweg.

                # Setup
    
                Im Verzeichnis `repo` wartet ein Git-Projekt darauf,
                bearbeitet zu werden. 

            """
        ) {
            createRepo {
                createFileAndCommit("hallo-welt") { content = "Hallo Welt" }
                createFileAndCommit("hello-world") { content = "Hello world!" }
                createFileAndCommit("datei1")
            }
        }

        inRepo {

            createAufgabe(
                    "Commit - mit Staging", """
                    Bearbeite die Datei `hallo-welt`,
                    füge sie mit `git add` zum Index hinzu (Staging)
                    und erstelle ein Commit mit diesen Änderungen.
             """) {
                inFile("hallo-welt") { content = "Hallo Welt!" }
                git("add hallo-welt")
                git("commit -m 'Erste Änderung'")
                git("show")
            }

            createAufgabe(
                    "Commit - automatisches Staging", """
                    Bearbeite die Datei `hallo-welt` erneut
                    und erstelle wieder ein Commit,
                    dieses mal mal aber mit `-a`.
             """) {

                inFile("hallo-welt") { content = "Hallo Welt!!" }
                git("commit -am 'Zweite Änderung'")
                markdown("Mit der Option `-a` kann man sich den `add`-Aufruf sparen:")
                git("log --oneline")
            }

            createAufgabe(
                    "Commit - neue Datei", """
                    Erstelle `new-world` und bestätige sie mit einem Commit.
             """) {

                createFile("new-world") { content = "New World!" }
                git("add new-world")
                git("commit -m 'Neue Datei'")
            }

            createAufgabe(
                    "Commit - Datei löschen", """
                    Lösche `hallo-welt` und bestätige dies per Commit.
             """) {

                bash("rm hallo-welt")
                git("commit -am 'Datei löschen'")
            }

            createAufgabe(
                    "⭐ Add - Dateien rekursiv hinzufügen", """
                    Lege eine Datei `superneu` und eine Verzeichnis `sub`mit einer
                    Datei `auchneu` an füge beide mit *einem* Add-Aufruf hinzu und erstelle
                    dann ein Commit.
             """) {
                createFile("superneu") 
                createDir("sub") { 
                    createFile("auchneu") 
                }
                markdown("""
                    `.` steht für: *aktuelles Verzeichnis*."
                   Alle Dateien darin und auch darunter werden hinzugefügt.
                """)
                git("add .")
                git("commit -am 'Neue Dateien'")
            }

            // dateien erstellen und bearbeiten editor konfigurieren

            createAufgabe(
                    "⭐ Commit - Datei verschieben/umbenennen", """
                    Benenne die Datei `hello-world` in `renamed-world` um
                    und bestätige dies durch ein Commit.
             """) {

                bash("mv hello-world renamed-world")
                git("add renamed-world")
                git("commit -am 'Umbenennen'")
                markdown("Anmerkung: Wenn wir `git mv`  statt `mv` genutzt" +
                        " hätten, dann wäre das separate `git add` nicht nötig gewesen.")
                git("log --follow --oneline -- renamed-world")
            }

            createAufgabe(
                    "⭐ Rename detection", """
                    Benenne die Datei `datei1` in `datei2` mit `git mv` um. 
                    Sorge dafür, dass die *Rename Detection* dies nicht erkennt.
             """) {

                git("mv datei1 datei2")
                inFile("datei2") { content = "Dieser Inhalt hat nichts mit dem vorigen Inhalt zu tun." }
                git("commit -am 'Böse umbenennen'")
                git("log --follow --oneline -- datei2")
            }        
        }
    }
}