package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.repositoryLog() {

    createAufgabenFolge("log") {
        createIntro(
                "Repository - Log" en "Repository - Log",
                """
                Das Log repräsentiert die Geschichte des Projekts
                als Folge von Commits.
                Jedes Commit repräsentiert einen Stand aller Dateien des Projekts.
                Hier wird geübt, das Log zu Untersuchen und zu Lesen.


                ## Tipps
                
                * `git log` zeigt alles Commits, die im aktuellen Branch enthalten sind.
                  - `--oneline` macht die Ausgabe kompakter.
                  - `--stat` zeigt wie viele Dateien in welcher Date geändert wurden.
                * `git show <some-commit>` zeigt Details zu einem Commit
                * Mit `~` Adressiert man Vorgänger eines Commits, 
                  z. B. ist `HEAD~2` der Vorvorgänger von `HEAD`.
                * `git ls-tree -r <commit>` listet alles Dateien auf, die im angegebenen
                  Commit versioniert sind.
                * Mit `blame` findet man heraus,in welchen Commit Zeilen zuletzt bearbeitet wurden.
                  - `-M` ermittelt Verschiebungen innerhalb einer Datei. 
                  - `-w` erkennt Zeilen wieder, auch wenn Whitespacing verändert wurde.
                  - `--show-number` zeigt vorherige Zeilennummern.
                  - `-C` ermittelt Kopien/Verschiebungen aus Dateien im selben  Commit, in dem die Zeile bearbeitet wurde,
                    `-C -C -C` sogar aus beliebigen Dateien.

                # Setup
    
                Im Verzeichnis `repo` wartet ein Git-Projekt darauf,
                untersucht zu werden. 

            """ en
                        """
                The log represents the history of the project
                as a sequence of commits.
                Each commit represents a state of all files in the project.
                Here you will practice examining and reading the log.


                ## Tips
                
                * `git log` shows all commits that are in the current branch.
                  - `--oneline` makes the output more compact.
                  - `--stat` shows how many files were changed in which file.
                * `git show <some-commit>` shows details about a commit
                * With `~` you can address predecessors of a commit,
                  e.g. `HEAD~2` is the predecessor of the predecessor of `HEAD`.
                * `git ls-tree -r <commit>` lists all files that are versioned in the specified
                  commit.
                * With `blame` you can find out in which commit lines were last edited.
                  - `-M` detects moves within a file.
                  - `-w` recognizes lines again, even if whitespace has been changed.
                  - `--show-number` shows previous line numbers.
                  - `-C` detects copies/moves from files in the same commit in which the line was edited,
                    `-C -C -C` even from any file.

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
                    startBranch("feature-a") { editAndCommit("bar", 7) }

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
                    "repository-log",
                    "Verzeichnisstruktur" en "Directory structure",
                    """
                    Untersuche das Projektverzeichnis.
                    Welche Dateien gibt es im Workspace? Welche Verzeichnisse?
                    Wo liegt das Repository?
        """ en
                            """
                    Examine the project directory.
                    What files are there in the workspace? What directories?
                    Where is the repository?
        """
            ) {
                ll()
                ll("foo")
                ll(".git")

                markdown(
                        """
                    Man sieht: Das Projekt enthält einige Dateien, ein Unterverzeichnis
                    und natürlich auch ein `.git`-Verzeichnis, welches das Repository beherbergt.
                """.trimIndent() en
                                """
                    You can see: The project contains some files, a subdirectory
                    and of course a `.git` directory, which houses the repository.
                """.trimIndent()
                )
            }

            createAufgabe(
                    "repository-log",
                    "Commits ansehen" en "View commits",
                    """
                    Sieh Dir die Commits. 
                    Achte dabei auf die angezeigten Branches und Tags.
                """ en
                            """
                    Look at the commits.
                    Pay attention to the displayed branches and tags.
                """
            ) { git("log --oneline") }

            createAufgabe(
                    "repository-log",
                    "Head-Commit untersuchen" en "Examine head commit",
                    """
                    Zeige Details zur aktuellen Version,
                    die im Workspace ausgecheckt ist.
                """ en
                            """
                    Show details about the current version
                    that is checked out in the workspace.
                """
            ) {
                markdown(
                        "\n\nHier die aktuelle Version `HEAD`:" en
                                "\n\nHere is the current version `HEAD`:"
                )
                git("show")
            }

            createAufgabe(
                    "repository-log",
                    "Vergangene Commits untersuchen" en "Examine past commits",
                    """
                    Zeige Details zum Release1.0,
                    und dann zur Vorgängerversion des Releases 1.0
                """ en
                            """
                    Show details for Release 1.0,
                    and then for the predecessor version of Release 1.0
                """
            ) {
                markdown("\n\nHier kommt die 1.0:" en "\n\nHere comes 1.0:")
                git("show release1.0")
                markdown("\n\nUnd hier der Vorgänger davon:" en "\n\nAnd here is its predecessor:")
                git("show release1.0~1")
            }

            createAufgabe(
                    "repository-log",
                    "⭐ Inhalte vergangener Versionen untersuchen" en
                            "⭐ Examine contents of past versions",
                    """
                    Lasse Dir anzeigen welche Dateien und Verzeichnisse
                    es im vorigen Commit gab.
                    
                    Gebe den Inhalt der Datei `bar` so aus,  wie er im vorigen Commit war.
                """ en
                            """
                    Show which files and directories
                    existed in the previous commit.
                    
                    Output the content of the file `bar` as it was in the previous commit.
                """
            ) {
                markdown(
                        "\n\nDiese Dateien gab es in `HEAD~1`:" en
                                "\n\nThese files existed in `HEAD~1`:"
                )
                git("ls-tree -r HEAD~1")
                markdown(
                        "\n\nUnd hier der Inhalt von `bar`:" en
                                "\n\nAnd here is the content of `bar`:"
                )
                git("show HEAD~1:foo/bar")
            }

            createAufgabe(
                    "repository-log",
                    "⭐ Commits ansehen: Datei-Statistik" en "⭐ View commits: file statistics",
                    """
                    Sieh Dir die Commits an. 
                    Lase dir dabei die Statistik anzeigen, 
                    d.h. wie viele Zeilen in welcher Datei geändert wurden.
                """ en
                            """
                    Look at the commits.
                    Have the statistics displayed,
                    i.e. how many lines were changed in which file.
                """
            ) { git("log --stat") }

            createAufgabe(
                    "repository-log",
                    "⭐ Herkunft von Zeilen ermitteln" en "⭐ Determine origin of lines",
                    """
                    Es geht darum für die Datei `nachher` Folgendes zu ermitteln:

                    * Für jede Zeile zeigen, in welchem Commit sie zuletzt bearbeitet wurde.
                    * Innerhalb der Datei wurden Zeilen verschoben. Welche?
                    * Es wurden auch Zeilen aus anderen Dateien verschoben und kopiert. Welche?
                """ en
                            """
                    The goal is to determine the following for the file `nachher`:

                    * For each line, show in which commit it was last edited.
                    * Lines were moved within the file. Which ones?
                    * Lines were also moved and copied from other files. Which ones?
                """
            ) {
                git("blame nachher -s -w")
                markdown(
                        "Man sieht, in welchem Commit die Zeilen zuletzt bearbeitet wurden, auch über Umbenennungen hinweg." en
                                "You can see in which commit the lines were last edited, even across renames."
                )
                git("blame nachher -s -w -M --show-number")
                markdown(
                        "Die Zeilennummern zeigen, welche Zeilen verschoben wurden." en
                                "The line numbers show which lines were moved."
                )
                git("blame nachher -s -w -M -C")
                markdown(
                        "Hier sieht eine Verschiebung aus der Datei `restaurant`." en
                                "Here you can see a move from the file `restaurant`."
                )
                git("blame nachher -s -w -M -C -C -C")
                markdown(
                        "Hier sieht man, dass Inhalte aus einer anderen Datei `foo/bar` kopiert wurden." en
                                "Here you can see that content was copied from another file `foo/bar`."
                )
            }
        }
    }
}
