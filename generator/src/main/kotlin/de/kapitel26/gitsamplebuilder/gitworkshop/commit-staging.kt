package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.staging() {

    createAufgabenFolge("staging") {
        createIntro(
                "Staging",
                """
                Es geht um den *Stage-Bereich* (auch Index genannt).
                Jede Änderung (bearbeitete, neue oder gelöschte Dateien) 
                wird muss als "Snapshot" im Stage-Bereich registriert werden
                (z.B. mit `git add`),
                bevor Sie in ein Commit übernommen werden kann.

                ## Tipps
                
                * `git add <datei/verzeichnis>` 
                   überträgt den aktuellen Stand einer Datei in den Stage-Bereich.
                *  Ändert man eine Datei nach dem `add`, hat sie
                   im Workspace einen anderen Stand als in der Stage.
                * `git status`, `git diff` und `git diff --staged` zeigen dies.
                * `git restore --staged <file>` nimmt ein Staging zurück.
                * `git restore <file>` stellt eine Datei im Workspace wieder her.
                   **Achtung**: Die lokale Änderungen werden dabei überschreiben!
                * mit `-s <revision>` können auch beliebige andere Stände von Dateien und Verzeichnisse
                  geholt werden.
                * `git stash -u` entfernt alle Änderungen (und unversioniert Dateien)
                  aus dem Workspace (und sichert diese im Stash).
                        
                # Setup
    
                Im Verzeichnis `repo` wartet ein Git-Projekt darauf,
                bearbeitet zu werden. 

            """ en
                        """
                This is about the *stage area* (also called the index).
                Every change (edited, new, or deleted files)
                must be registered as a "snapshot" in the stage area
                (e.g., with `git add`),
                before it can be included in a commit.

                ## Tips
                
                * `git add <file/directory>`
                   transfers the current state of a file to the stage area.
                * If you change a file after `add`, it has
                   a different state in the workspace than in the stage.
                * `git status`, `git diff`, and `git diff --staged` show this.
                * `git restore --staged <file>` undoes a staging.
                * `git restore <file>` restores a file in the workspace.
                   **Attention**: The local changes will be overwritten!
                * With `-s <revision>`, any other states of files and directories
                  can be fetched.
                * `git stash -u` removes all changes (and untracked files)
                  from the workspace (and saves them in the stash).
                        
                # Setup
    
                In the `repo` directory, a Git project is waiting
                to be edited.

            """
        ) {
            createRepo {
                createFileAndCommit("demo") { content = "Fit\nist\ndoof.\n" }
                createFileAndCommit("beispiel", message = "dazwischen") {
                    content = "So war es zuerst."
                }
                editAndCommit("beispiel", message = "dazwischen") {
                    content = "Dann kam das mit dem Mittelteil."
                }
                editAndCommit("beispiel", message = "später") { content = "Und so endete es." }

                createDir("ufer") {
                    createDir("west") {
                        createFile("BAUER")
                        createFile("KOHL")
                        createFile("ZIEGE")
                        createFile("WOLF")
                    }
                    createDir("ost")
                }
                git("add ufer")
                git("commit -m'Starte spiel'")
                inDir("ufer") {
                    listOf(
                                    "west/ZIEGE west/BAUER ost/",
                                    "ost/BAUER west/",
                                    "west/WOLF west/BAUER ost/",
                                    "ost/ZIEGE ost/BAUER west/",
                                    "west/KOHL west/BAUER ost/",
                                    "ost/BAUER west/",
                                    "west/ZIEGE west/BAUER ost/"
                            )
                            .forEachIndexed { i, s ->
                                git(" mv $s")
                                git("commit -am 'Zug ${i+1}'")
                            }
                }
            }
        }

        inRepo {
            createAufgabe(
                    "commit-staging",
                    "Staging",
                    """
                    Ersetze in der Datei `demo`,
                    `Fit` durch `Git`.
                    Füge sie dann zum Stage-Bereich hinzu.
                    Ersetze dann `doof` durch `toll`.
                    Lasse dir den Status und die Diffs
                    für Workspace und Stage zeigen.
             """ en
                            """
                    In the file `demo`, replace
                    `Fit` with `Git`.
                    Then add it to the stage area.
                    Then replace `doof` with `toll`.
                    Show the status and diffs
                    for the workspace and stage.
             """
            ) {
                markdown("Ersetze `Fit` durch `Git`." en "Replace `Fit` with `Git`.")
                inFile("demo") { content = "Git\n" + "ist\n" + "doof.\n" }
                git("add demo")
                markdown("Ersetze `doof` durch `toll`." en "Replace `doof` with `toll`.")
                inFile("demo") { content = "Git\n" + "ist\n" + "toll.\n" }
                git("status")
                markdown(
                        "Die Datei `demo` wird sowohl in `Changes to be committed:` als auch in `Changes not staged for commit` geführt." en
                                "The file `demo` is listed in both `Changes to be committed:` and `Changes not staged for commit`."
                )
                git("diff")
                markdown(
                        "Man sieht, dass der Stage-Bereich ein anderes Diff hat, als der Workspace." en
                                "You can see that the stage area has a different diff than the workspace."
                )
                git("diff --staged")
            }

            createAufgabe(
                    "commit-staging",
                    "Restore - Staging zurücknehmen",
                    """
                    Die letzte Änderung soll doch noch nicht in das nächste Commit übernommen werden,
                    nehme sie zurück. 
             """ en
                            """
                    The last change should not be included in the next commit yet,
                    so undo it.
             """
            ) {
                git("restore --staged demo")
                git("status")
                git("diff")
                markdown(
                        "Nach dem zurücknehmen ist der Stage-Bereich wieder leer." en
                                "After undoing, the stage area is empty again."
                )
                git("diff --staged")
            }

            createAufgabe(
                    "commit-staging",
                    "Restore - Änderung ganz zurücknehmen",
                    """
                    Die Änderungen an `demo` sollen ganz zurückgenommen werden.
                    Lasse Dir nachher Status und Diffs anzeigen.
             """ en
                            """
                    The changes to `demo` should be completely undone.
                    Show the status and diffs afterwards.
             """
            ) {
                git("status")
                git("restore demo")
                git("status")
                git("diff")
                git("diff --staged")
                markdown(
                        "Jetzt sind die Änderungen ganz weg." en
                                "Now the changes are completely gone."
                )
            }

            createAufgabe(
                    "commit-staging",
                    "⭐ Restore - Älteren Inhalt einer Datei zurückholen",
                    """
                    Die Datei `beispiel` wurde dreimal bearbeitet.
                    Hole den mittleren Stand zurück und erstelle ein Commit.
             """ en
                            """
                    The file `beispiel` was edited three times.
                    Restore the middle state and create a commit.
             """
            ) {
                git("log --oneline beispiel")
                git("restore -s HEAD~9 beispiel")
                git("diff")
                git("commit -am \"Mittlerer Stand wiederhergestellt.\"")
            }

            createAufgabe(
                    "commit-staging",
                    "⭐ Restore - Zurückholen älterer Verzeichnisversionen",
                    """
                    Im Folder `ufer` wurde ein Spiel gespielt.
                    Stelle die Spielstände nach, 
                    indem Du `restore` auf das `ufer`-Verzeichnis anwendest.
                    
                    Tipp: `ll ufer/*` zeigt die Verzeichnisse des Spiels.
                    
                    Tipp: Beim `restore` werden unversionierte Dateien nicht abgeräumt.
                    Man kann sie mit dem `stash`-Befehl abräumen.
             """ en
                            """
                    A game was played in the `ufer` folder.
                    Recreate the game states
                    by applying `restore` to the `ufer` directory.
                    
                    Tip: `ll ufer/*` shows the directories of the game.
                    
                    Tip: When using `restore`, untracked files are not removed.
                    You can remove them with the `stash` command.
             """
            ) {
                git("log --oneline -- ufer/")
                (1..8).forEach { i ->
                    markdown("Zug $i" en "Move $i")
                    git("stash -u")
                    git("restore -s HEAD~${8-i} ufer")
                    ll("ufer/*")
                }
            }
        }
    }
}
