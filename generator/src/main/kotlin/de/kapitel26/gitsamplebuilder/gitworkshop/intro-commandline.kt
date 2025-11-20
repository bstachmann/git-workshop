package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.commandline() {

    createAufgabenFolge("commandline") {
        createIntro(
                "Das `git`-Kommando!" en "The `git` command!",
                """
                In der ersten Übung geht es darum,
                die (Git-) Bash-Kommandozeile und vor allem
                das `git`-Kommando kennenzulernen.

                ## Tipps
                
                * Für Windows-Nutzer:
                  - Nutzen sie die **Git-Bash**-Kommandozeile dann können sie Beispiele
                    genau wie hier angegeben ausführen.
                  - Verwenden sie '/' statt '\', für Verzeichnispfade.
                  - Wenn Sie mit der Windows-Kommandozeile `CMD` arbeiten,
                    müssen sie ggf. kleinere Änderungen vornehmen,
                    damit die Beispiele funktionieren.

                * Bash-Kommandos
                  - `cd <verzeichnisname>`, wechselt in ein anderes Verzeichnis.
                  - `cd ..`, wechselt in das übergeordente Verzeichnis.
                    Eine Ebene hoch!
                  - `ls` zeigt die Namen der Dateien und Unterverzeichnisse im aktuellen Verzeichnisse.
                  - `ll` Wie `ls` nur mit mehr Details.
                  - `less`. Inhalt einer Datei anzeigen. Scrollen mit Pfeiltasten. Mit Taste `q` beenden.
                  - `pwd` zeigt das aktuelle Arbeitsverzeichnis an. Auf Windows: `pwd -W` (Großbuchstabe)

                * Git-Kommandos
                  - `git version` zeigt welche Version von Git installiert ist.
                  - `git help <kommando>` zeigt Hilfe.
                  - `git config <property>` zeigt Wert aus der Konfiguration an. 
                  - `git config set --global <property> <new-value>` 
                    setzt einen Wert in der Konfiguration.
                  - `git config core.editor notepad` konfiguriert Notepad als Editor für Git.
                  - Wenn die Ausgabe mehr Zeilen hat, als Terminalfenster hoch ist,
                    wird die Ausgabe in einem Viewer (`less`) dargestellt.
                    Man kann dann mit Pfeiltasten rauf- und runter scrollen.
                    Den `less` modus beendet man mit der Taste `q`.

                * Befehl `start <file>` (Ubuntu: `xdg-open`, Mac Os: `open`) 
                  öffnet die angegebene Datei mit der verknüpften Standardanwendung.
                  `start .` öffnet den Datei-Explorer im aktuellen Verzeichnis.

                [Kurze Intro zur Kommandozeile](../installation/kommandozeile)
            """ en
                        """
                In the first exercise, the goal is to get to know
                the (Git) Bash command line and especially
                the `git` command.

                ## Tips
                
                * For Windows users:
                  - Use the **Git-Bash** command line, then you can run examples
                    exactly as shown here.
                  - Use '/' instead of '\' for directory paths.
                  - If you are working with the Windows command line `CMD`,
                    you may need to make minor changes
                    for the examples to work.

                * Bash commands
                  - `cd <directoryname>`, changes to another directory.
                  - `cd ..`, changes to the parent directory.
                    One level up!
                  - `ls` shows the names of the files and subdirectories in the current directory.
                  - `ll` Like `ls` but with more details.
                  - `less`. Display the content of a file. Scroll with arrow keys. Quit with the `q` key.
                  - `pwd` shows the current working directory. On Windows: `pwd -W` (uppercase)

                * Git commands
                  - `git version` shows which version of Git is installed.
                  - `git help <command>` shows help.
                  - `git config <property>` shows the value from the configuration.
                  - `git config set --global <property> <new-value>`
                    sets a value in the configuration.
                  - `git config core.editor notepad` configures Notepad as the editor for Git.
                  - If the output has more lines than the terminal window is high,
                    the output is displayed in a viewer (`less`).
                    You can then scroll up and down with the arrow keys.
                    You exit the `less` mode with the `q` key.

                * Command `start <file>` (Ubuntu: `xdg-open`, Mac Os: `open`)
                  opens the specified file with the associated default application.
                  `start .` opens the file explorer in the current directory.

                [Short intro to the command line](../installation/commandline)
            """
        ) {
            createDir("hallo") { createFile("herzlich-willkommen.txt", "Moin!") }

            createRepo() {
                createFileAndCommit("some-file.txt")
                (1..99).forEach {
                    editAndCommit("some-file.txt", message = "Edit nr ${it}") {
                        edit(0, content = "Editet in Commit ${it}")
                    }
                }
            }
        }

        createAufgabe(
                "intro-commandline",
                "Navigation in Übungsverzeichnisse" en "Navigation in exercise directories",
                """
            (aus dem entpackten Zip-File)

            Navigiere in das Unterverzeichnis `aufgaben/intro-commandline/hallo`
            und sieh Dir den Inhalt der dort liegenden Datei an.
            Nutze die Tab-Completion, um nicht so viel tippen zu müssen.
            Navigiere dann wieder zurück ins übergeordnete 
            Verzeichnis `intro-commandline`.
            """ en
                        """
            (from the unzipped zip file)

            Navigate to the subdirectory `aufgaben/intro-commandline/hallo`
            and look at the content of the file located there.
            Use tab completion to avoid typing so much.
            Then navigate back to the parent
            directory `intro-commandline`.
            """,
                startPath = "git-uebungen"
        ) {
            inDir("../..", showDirectoryChange = false) {
                log.shell(
                        "ls",
                        "git-uebungen",
                        listOf(
                                "aufgaben  aufgaben.json  loesungen  ueberblick.html  ueberblick.md"
                        ),
                        emptyList()
                )
                log.shell("cd aufgaben", "git-uebungen", emptyList(), emptyList())
                inDir("aufgaben", showDirectoryChange = false) {
                    log.shell("cd intro-commandline", "aufgaben", emptyList(), emptyList())
                    inDir("intro-commandline", showDirectoryChange = false) {
                        inDir("hallo") { bash("ls") }
                    }
                }
            }
        }

        createAufgabe(
                "intro-commandline",
                "Git-Version prüfen" en "Check Git version",
                """
            Gib aus, welche Version von Git installiert ist.
        """ en
                        """
            Print which version of Git is installed.
        """
        ) { bash("git version") }

        createAufgabe(
                "intro-commandline",
                "Hilfe" en "Help",
                """
                Zeige die Hilfeseite zum `log`-Befehl an.
        """ en
                        """
                Show the help page for the `log` command.
        """
        ) {
            val output =
                    """
                GIT-LOG(1)                                                        Git Manual                                                        GIT-LOG(1)

                NAME
                    git-log - Show commit logs
                ...
            """.trimIndent()
            log.shell("git help log", rootDir.name, output.lines(), emptyList())
        }

        inRepo() {
            createAufgabe(
                    "intro-commandline",
                    "`less` und lange Ausgaben" en "`less` and long outputs",
                    """
                    Wenn Sie `git log` ausführen, sollen 99 Commits angezeigt werden.
                    Weil diese nicht in ein Terminalfenster passt,
                    wird der `less`-Viewer geöffnet. Schliessen sie ihn.
                    Nutzen sie dann `less some-file.txt` um eine Datei im `less`-Modus anzusehen.
            """ en
                            """
                    When you run `git log`, 99 commits should be displayed.
                    Because this does not fit in a terminal window,
                    the `less` viewer is opened. Close it.
                    Then use `less some-file.txt` to view a file in `less` mode.
            """
            ) {
                val output =
                        """
                    commit 5e14e1dc688e7a2cd02c9ccad3dedf397d407e2e (HEAD -> main)
                    Author: bjoern <kapitel26blog@gmail.com>
                    Date:   Thu Jul 29 00:00:00 2021 +0000
                    
                        : Edit file some-file.txt at line 3 on branch main by bjoern.
                    
                    commit 41984e9ac879b9b56c8e91228a8d5887bca228fd
                    Author: bjoern <kapitel26blog@gmail.com>
                    Date:   Thu Jul 29 00:00:00 2021 +0000
                    
                        : Edit file some-file.txt at line 3 on branch main by bjoern.
                    
                    commit 99399d263ccc8fe4a1bc59a49c93147b17115518
                    Author: bjoern <kapitel26blog@gmail.com>
                    Date:   Thu Jul 29 00:00:00 2021 +0000
                    
                        : Edit file some-file.txt at line 3 on branch main by bjoern.
                    
                    commit df80cb240781a015f2f0ad62a48fc42964fdfe8b
                    Author: bjoern <kapitel26blog@gmail.com>
                    Date:   Thu Jul 29 00:00:00 2021 +0000
                    
                        : Edit file some-file.txt at line 3 on branch main by bjoern.
                    :
                """.trimIndent()
                log.shell("git log", rootDir.name, output.lines(), emptyList())
                markdown("Quit with `q`")
                bash("cat some-file.txt", commandRepresentation = "less some-file.txt")
                markdown("Quit with `q`")
            }

            createAufgabe(
                    "intro-commandline",
                    "Git konfigurieren" en "Configure Git",
                    """
                    Prüfe die User-Konfiguration:

                        $ git config user.name
                        $ git config user.email
                        $ git config pull.rebase
                        $ git config merge.conflictStyle
                        $ git config --global init.defaultBranch 

                    Konfiguriere Sie Benutzername und -Email, 
                    sofern noch nicht gesetzt:
                    
                        $ git config --global user.name mein-name
                        $ git config --global user.email meine-email
                    
                    Die folgenden Konfigurationen wurden beim Aufzeichnen der 
                    Musterlösung genutzt.
                    Es ist empfehlenswert sie für diesen Workshop setzen:

                        $ git config --global pull.rebase false 
                        $ git config --global merge.conflictStyle diff3
                        $ git config --global init.defaultBranch main

            """ en
                            """
                    Check the user configuration:

                        $ git config user.name
                        $ git config user.email
                        $ git config pull.rebase
                        $ git config merge.conflictStyle
                        $ git config --global init.defaultBranch

                    Configure your username and email,
                    if not already set:
                    
                        $ git config --global user.name my-name
                        $ git config --global user.email my-email
                    
                    The following configurations were used when recording the
                    sample solution.
                    It is recommended to set them for this workshop:

                        $ git config --global pull.rebase false
                        $ git config --global merge.conflictStyle diff3
                        $ git config --global init.defaultBranch main

            """
            ) {
                log.shell(
                        "git config --global user.name mein-name",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
                log.shell(
                        "git config --global user.email meine-email",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
                log.shell(
                        "git config --global pull.rebase false ",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
                log.shell(
                        "git config --global merge.conflictStyle diff3",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
                log.shell(
                        "git config --global init.defaultBranch main",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
            }

            createAufgabe(
                    "intro-commandline",
                    "⭐ Historie" en "⭐ History",
                    """
                    Blättern sie die 🡅-Taste mehrfach und drücken dann enter,
                    um einen der vorigen Befehle erneut auszuführen.
                    Tippen sie `strg+r` und geben sie dann `conflict`ein,
                    um den Befehl zum Setzen von `merge.conflictStyle` erneut auszuführen.
                """ en
                            """
                    Press the 🡅 key several times and then press enter,
                    to execute one of the previous commands again.
                    Type `ctrl+r` and then enter `conflict`,
                    to re-run the command to set `merge.conflictStyle`.
                """
            ) {
                log.shell(
                        "git config --global user.email meine-email",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
                log.shell(
                        "git config --global merge.conflictStyle diff3",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
            }

            createAufgabe(
                    "intro-commandline",
                    "⭐ Git-Editor konfigurieren" en "⭐ Configure Git editor",
                    """
                Konfigurieren Sie einen Editor für git.
                [Tipps dazu](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config).f
                Testen Sie dann mit `git config -e`, ob es geklappt hat.
                """ en
                            """
                Configure an editor for git.
                [Tips on this](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config).f
                Then test with `git config -e` to see if it worked.
                """
            ) {
                log.shell(
                        "git config --global core.editor notepad",
                        rootDir.name,
                        emptyList(),
                        emptyList()
                )
                log.shell("git config -e", rootDir.name, emptyList(), emptyList())
            }

            createAufgabe(

                    "⭐ Arbeitsverzeichnis" en "⭐ Working directory",
                    """
                Geben Sie aus, in welchem Arbeitzverzeichnis Sie sich gerade befinden.
                Für Windows-User: Testen sie den Befehl auch mit der Option `-W`.
                """ en
                            """
                Print out which working directory you are currently in.
                For Windows users: also test the command with the `-W` option.
                """
            ) { bash("pwd") }

            createAufgabe(
                    "intro-commandline",
                    "⭐ Anwendungen öfnen" en "⭐ Open applications",
                    """
                Öffnen Sie die Datei `some-file.txt` mit der Standaranwendung.
                Öffnen Sie einen Datei-Explorer im aktuellen Arbeitsverzeichnis.
                """ en
                            """
                Open the file `some-file.txt` with the default application.
                Open a file explorer in the current working directory.
                """
            ) {
                log.shell("start some-file.txt", rootDir.name, emptyList(), emptyList())
                log.shell("start .", rootDir.name, emptyList(), emptyList())
            }
        }
    }
}
