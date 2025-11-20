package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.repositoryUntersuchen() {

    createAufgabenFolge("untersuchen") {
        createIntro(
                "Repository untersuchen" en "Investigating the repository",
                """
                Hier geht es darum, herauszufinden, was in einem Repository enthalten ist.

                ## Tipps
                
                * `git log` zeigt alles Commits, die im aktuellen Branch enthalten sind.
                  - `--oneline` macht die Ausgabe kompakter.
                * `git show <some-commit>` zeigt Details zu einem Commit
                * Mit `~` Adressiert man Vorgänger eines Commits, 
                  z. B. ist `HEAD~2` der Vorvorgänger von `HEAD`.
                * `git branch` und `git tag` listen vorhandene Branches und Tags auf.
                * Mit `git switch <branch-name>` kann man auf andere Branches wechseln.
                * Mit `git switch --detach <commit>` kann man auf beliebige Versionen wechseln.
                * Mit `git restore -s <commit> -- <datei-oder-pfad>` kann man *Inhalte* beliebiger Versionen 
                  von Dateien/Pfaden in den Workspace holten. Es wird dabei nicht auf das angegebenen Commit
                  gewechselt, sondern nur Dateiinhalte in den Workspace geholt. Die betroffenen Dateien 
                  werden als `modified` angezeigt und können Commited werden.
                   
                # Setup
    
                Im Verzeichnis `repo` wartet ein Git-Projekt darauf,
                untersucht zu werden. 

            """ en
                        """
                This is about finding out what is in a repository.

                ## Tips
                
                * `git log` shows all commits that are in the current branch.
                  - `--oneline` makes the output more compact.
                * `git show <some-commit>` shows details about a commit
                * With `~` you can address predecessors of a commit,
                  e.g. `HEAD~2` is the predecessor of the predecessor of `HEAD`.
                * `git branch` and `git tag` list existing branches and tags.
                * With `git switch <branch-name>` you can switch to other branches.
                * With `git switch --detach <commit>` you can switch to any version.
                * With `git restore -s <commit> -- <file-or-path>` you can get *contents* of any version
                  of files/paths into the workspace. It does not switch to the specified commit,
                  but only fetches file contents into the workspace. The affected files
                  are displayed as `modified` and can be committed.
                   
                # Setup
    
                In the `repo` directory, a Git project is waiting
                to be examined.

            """
        ) {
            createRepo {
                createFileAndCommit("hallo-welt") { content = "Hallo Welt!" }
                createDir("foo") {
                    createFileAndCommit("bar") {
                        edit(1, content = "Eine wirklich ziemlich lange Zeile in der Datei 'bar'")
                    }
                    createFileAndCommit("vorher", "Beginne mit leerer Datei") { content = "" }
                    editAndCommit("vorher", "Ergänze zwei zeilen") {
                        edit(0, content = "Diese Zeilen wurden also ganz am Anfang geschrieben.")
                        edit(1, content = "Und das ist wohl doch sehr lange her. Wie man sieht.")
                    }
                }

                git("mv foo/vorher nachher")
                git("commit -m 'Benenne die Datei im'")

                editAndCommit("nachher", "Ergänze eine Zeile") {
                    edit(2, content = "Nach der Umbenennung")
                }

                editAndCommit("nachher", "Kopiere eine Zeile aus 'bar'") {
                    edit(3, content = "Eine wirklich ziemlich lange Zeile in der Datei 'bar'")
                }

                createFileAndCommit("restaurant") {
                    content = "Eine sehr lange Zeile aus 'restaurant', die verschoben wird."
                }

                inFile("restaurant") { content = "" }
                inFile("nachher") {
                    edit(
                            4,
                            content = "Eine sehr lange Zeile aus 'restaurant', die verschoben wird."
                    )
                    edit(5, content = "Und eine, die nichts damit zu tun hat.")
                }
                git("commit -am 'Verschiebe eine  Zeile'")
                editAndCommit("nachher", "Noch ein paar neue Zeilen") {
                    edit(
                            6,
                            content =
                                    "Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll."
                    )
                    edit(7, content = "dazwischen.")
                    edit(8, content = "Ende")
                }
                editAndCommit("nachher", "Eine Zeile verschieben") {
                    edit(6, content = "dazwischen.")
                    edit(
                            7,
                            content =
                                    "Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll."
                    )
                    edit(8, content = "Ende")
                }

                git("tag release1.0")
                editAndCommit("hallo-welt") { content = "Hello World!" }
                inDir("foo") {
                    startBranch("feature-a") {
                        editAndCommit("bar") { content = "Jawoll, das ist hier feature-a!\n" }
                    }

                    editAndCommit("bar", 1)
                    git("branch some-old-branch")
                    editAndCommit("bar", 5)
                }
                git("tag release1.1")
                createFileAndCommit("und-tschuess")
            }
        }

        inRepo {
            createAufgabe(
                "repository-untersuchen",
                "Branches zeigen" en "Show branches",
                    """
                    Zeige an, welche Branches es gibt.
                    Zeige jetzt den Commit-Graphen über alle Branches an.
                """ en
                            """
                    Show which branches exist.
                    Now show the commit graph across all branches.
                """
            ) {
                git("branch -vv")
                markdown(
                        "Im Commit-Graphen sieht man, wo die Branches und Tag stehen:" en
                                "In the commit graph you can see where the branches and tags are:"
                )
                git("log --decorate --oneline --graph --all")
            }

            createAufgabe(
                    "repository-untersuchen",
                    "Branch wechseln" en "Switch branch",
                    """
                    Wechsle auf den Branch `feature-a`.
                    Sieh Dir den Inhalt der Datei `bar` im Verzeichnis `foo` an.
                    Wechsle zurück auf `main`.
                """ en
                            """
                    Switch to the `feature-a` branch.
                    Look at the content of the `bar` file in the `foo` directory.
                    Switch back to `main`.
                """
            ) { onBranch("feature-a") { bash("cat foo/bar") } }

            createAufgabe(
                    "repository-untersuchen",
                    "Tags zeigen" en "Show tags",
                    """
                    Zeige alle Tags an.
                """ en
                            """
                    Show all tags.
                """
            ) { git("tag") }

            createAufgabe(
                    "repository-untersuchen",
                    "⭐ Inhalte vergangener Versionen untersuchen" en
                            "⭐ Investigate contents of past versions",
                    """
                    Lasse dir anzeigen, welche Dateien es im Workspace gibt.
                    Lasse Dir anzeigen welche Dateien es in vorigen Commit gab.            
                    Wechsle zum vorigen Commit, und untersuche, wie der Workspace dannn aussieht.

                    Wechsle dann wieder auf `main` zurück.
                """ en
                            """
                    Show which files exist in the workspace.
                    Show which files existed in the previous commit.
                    Switch to the previous commit and examine what the workspace looks like then.

                    Then switch back to `main`.
                """
            ) {
                markdown(
                        "\n\nDiese Dateien gibt es auf `main`:" en
                                "\n\nThese files exist on `main`:"
                )
                ll()
                markdown(
                        "\n\nDiese Dateien gab es in `HEAD~1`:" en
                                "\n\nThese files existed in `HEAD~1`:"
                )
                git("ls-tree HEAD~1")
                markdown(
                        "\n\nUnd jetzt holen wir genau diese Version in den Workspace:" en
                                "\n\nAnd now we get exactly this version into the workspace:"
                )
                git("switch --detach HEAD~1")
                ll()
                git("switch main")
            }

            createAufgabe(
                    "repository-untersuchen",
                    "⭐ Hole alten Stand einer einzelnen Datei zurück." en
                            "⭐ Restore old state of a single file.",
                    """
                    Die Datei `hallo-welt` wurde nach dem `release1.0` bearbeitet.
                    Dem Kunden gefällt das nicht. Stelle den alten Zustand mit
                    einem neuen Commit wieder her. 
                """ en
                            """
                    The file `hallo-welt` was edited after `release1.0`.
                    The customer does not like it. Restore the old state with
                    a new commit.
                """
            ) {
                markdown("In `release1.0` sah es os aus:" en "In `release1.0` it looked like this:")
                git("show release1.0:hallo-welt")
                markdown("Jetzt sieh es so aus:" en "Now it looks like this:")
                git("show HEAD:hallo-welt")
                markdown("Gezieltes zurückholen:" en "Targeted restore:")
                git("restore -s release1.0 hallo-welt")
                git("commit -am 'Zurückgeholt'")
                markdown(
                        "Im Commit-Graphen sieht man, wo die Branches und Tag stehen:" en
                                "In the commit graph you can see where the branches and tags are:"
                )
                markdown("Jetzt sieh es so wieder so aus:" en "Now it looks like this again:")
                git("show HEAD:hallo-welt")
            }
        }
    }
}
