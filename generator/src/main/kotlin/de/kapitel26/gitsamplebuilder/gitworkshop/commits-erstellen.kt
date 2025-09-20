package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.erstellen() {

    createAufgabenFolge("erstellen") {
        createIntro(
                "Commits erstellen" en "Creating Commits",
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

            """ en
                        """

                ## Tips
                
                * `git add <file/directory>`
                   Before a commit, changes must be registered with `add` in the staging area
                   (also called the index).
                * The directory name `.` (which stands for *current directory*) can also be specified.
                  The command is then applied to all files in the current directory and also subdirectories.
                * `git commit -m 'My two cents'` Creates a commit with all
                   changes registered in the staging area.
                * `git commit -a` Registers all changes to files already versioned in Git
                  in the staging area, so you can save the separate
                  `add` call.
                * The options `-a` and `-m` can also be combined: `git commit -am "Comment"`
                * `git log --follow -- <file-name>`
                   Shows the history of a file, even across renames.

                # Setup
    
                In the `repo` directory, a Git project is waiting
                to be edited.

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
                    "Commit - mit Staging" en "Commit - with Staging",
                    """
                    Bearbeite die Datei `hallo-welt`,
                    füge sie mit `git add` zum Index hinzu (Staging)
                    und erstelle ein Commit mit diesen Änderungen.
             """ en
                            """
                    Edit the file `hallo-welt`,
                    add it to the index with `git add` (staging)
                    and create a commit with these changes.
             """
            ) {
                inFile("hallo-welt") { content = "Hallo Welt!" }
                git("add hallo-welt")
                git("commit -m 'Erste Änderung'")
                git("show")
            }

            createAufgabe(
                    "Commit - automatisches Staging" en "Commit - automatic staging",
                    """
                    Bearbeite die Datei `hallo-welt` erneut
                    und erstelle wieder ein Commit,
                    dieses mal mal aber mit `-a`.
             """ en
                            """
                    Edit the file `hallo-welt` again
                    and create another commit,
                    but this time with `-a`.
             """
            ) {
                inFile("hallo-welt") { content = "Hallo Welt!!" }
                git("commit -am 'Zweite Änderung'")
                markdown(
                        "Mit der Option `-a` kann man sich den `add`-Aufruf sparen:" en
                                "With the `-a` option, you can save the `add` call:"
                )
                git("log --oneline")
            }

            createAufgabe(
                    "Commit - neue Datei" en "Commit - new file",
                    """
                    Erstelle `new-world` und bestätige sie mit einem Commit.
             """ en
                            """
                    Create `new-world` and confirm it with a commit.
             """
            ) {
                createFile("new-world") { content = "New World!" }
                git("add new-world")
                git("commit -m 'Neue Datei'")
            }

            createAufgabe(
                    "Commit - Datei löschen" en "Commit - delete file",
                    """
                    Lösche `hallo-welt` und bestätige dies per Commit.
             """ en
                            """
                    Delete `hallo-welt` and confirm this with a commit.
             """
            ) {
                bash("rm hallo-welt")
                git("commit -am 'Datei löschen'")
            }

            createAufgabe(
                    "⭐ Add - Dateien rekursiv hinzufügen" en "⭐ Add - recursively add files",
                    """
                    Lege eine Datei `superneu` und eine Verzeichnis `sub`mit einer
                    Datei `auchneu` an füge beide mit *einem* Add-Aufruf hinzu und erstelle
                    dann ein Commit.
             """ en
                            """
                    Create a file `superneu` and a directory `sub` with a
                    file `auchneu`, add both with *one* add call and then create
                    a commit.
             """
            ) {
                createFile("superneu")
                createDir("sub") { createFile("auchneu") }
                markdown(
                        """
                    `.` steht für: *aktuelles Verzeichnis*."
                   Alle Dateien darin und auch darunter werden hinzugefügt.
                """ en
                                """
                    `.` stands for: *current directory*."
                   All files in it and below it will be added.
                """
                )
                git("add .")
                git("commit -am 'Neue Dateien'")
            }

            // dateien erstellen und bearbeiten editor konfigurieren

            createAufgabe(
                    "⭐ Commit - Datei verschieben/umbenennen" en "⭐ Commit - move/rename file",
                    """
                    Benenne die Datei `hello-world` in `renamed-world` um
                    und bestätige dies durch ein Commit.
             """ en
                            """
                    Rename the file `hello-world` to `renamed-world`
                    and confirm this with a commit.
             """
            ) {
                bash("mv hello-world renamed-world")
                git("add renamed-world")
                git("commit -am 'Umbenennen'")
                markdown(
                        "Anmerkung: Wenn wir `git mv`  statt `mv` genutzt" +
                                " hätten, dann wäre das separate `git add` nicht nötig gewesen." en
                                "Note: If we had used `git mv` instead of `mv`," +
                                        " the separate `git add` would not have been necessary."
                )
                git("log --follow --oneline -- renamed-world")
            }

            createAufgabe(
                    "⭐ Rename detection",
                    """
                    Benenne die Datei `datei1` in `datei2` mit `git mv` um. 
                    Sorge dafür, dass die *Rename Detection* dies nicht erkennt.
             """ en
                            """
                    Rename the file `datei1` to `datei2` with `git mv`.
                    Make sure that the *Rename Detection* does not recognize this.
             """
            ) {
                git("mv datei1 datei2")
                inFile("datei2") {
                    content = "Dieser Inhalt hat nichts mit dem vorigen Inhalt zu tun."
                }
                git("commit -am 'Böse umbenennen'")
                git("log --follow --oneline -- datei2")
            }
        }
    }
}
