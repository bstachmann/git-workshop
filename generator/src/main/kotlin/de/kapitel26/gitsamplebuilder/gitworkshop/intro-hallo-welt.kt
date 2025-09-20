package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.halloWelt() {

    createAufgabenFolge("hallo-welt") {
        createIntro(
                """Hallo Git!""" en """Hello Git!""",
                """
                Hier geht es darum, ein Gefühl dafür zu bekommen,
                wie die Git-Kommandozeile funktioniert.
                Führen Sie die vorgegebenen Kommandos aus und schauen Sie,
                was passiert.
                Was die Kommandos genau tun, erfahren Sie im Verlauf des Seminars.

                ## Kurze Info zu den ersten Git-Befehlen
                
                * `git init` Erstellt ein neues Git-Repository.
                * `git add <datei(en)>` Datei(-änderungen) für das nächsten Commit hinzufügen.
                * `git commit -m <beschreibung>` Erstellt ein Commit.
                * `git log` zeigt Commits an.

            """ en
                        """
                This is about getting a feel for how the Git command line works.
                Execute the given commands and see what happens.
                You will learn what the commands do in detail during the course.

                ## Brief info on the first Git commands
                
                * `git init` Creates a new Git repository.
                * `git add <file(s)>` Add file changes for the next commit.
                * `git commit -m <description>` Creates a commit.
                * `git log` shows commits.

            """
        )

        createAufgabe(
                "Das erste Repo" en "The first repo",
                """
                Erstellen sie ihr erstes Repository mit den folgenden Befehlen:
                
                    $ git init myrepo
                    $ cd myrepo
                    $ echo 'welt' >hallo    # erzeugt eine Datei
                    $ git add hallo
                    $ git commit -m 'Hallo Welt!'
                    $ git log
        """ en
                        """
                Create your first repository with the following commands:
                
                    $ git init myrepo
                    $ cd myrepo
                    $ echo 'welt' >hallo    # creates a file
                    $ git add hallo
                    $ git commit -m 'Hello World!'
                    $ git log
        """
        ) {
            createRepo("myrepo") {
                bash("echo 'welt' >hallo")
                git("add hallo")
                git("commit -m 'Hallo Welt!'")
                markdown(
                        "Glückwunsch: Sieh sehen Ihr erstes Commit in Ihrem ersten Git-Repository!" en
                                "Congratulations: You see your first commit in your first Git repository!"
                )
                git("log")
            }
        }

        createAufgabe(
                "⭐ Und noch ein Commit" en "⭐ And another commit",
                """
            Bearbeiten Sie die Datei 'hallo' und erstellen ein neues commit.
            Mit der Option `-am` brauchen Sie 'git add hallo` nicht erneut aufrufen.
            Schauen Sie dann das log an.

                $ git commit -am 'Es geht weiter!'
                $ git log
        """ en
                        """
            Edit the file 'hallo' and create a new commit.
            With the `-am` option, you don't need to call `git add hallo` again.
            Then look at the log.

                $ git commit -am 'Here we go again!'
                $ git log
        """
        ) {
            inRepo("myrepo") {
                edit("hallo") { content = "bearbeitet" }
                git("commit -am 'Es geht weiter!'")
                git("log")
            }
        }
        createAufgabe(
                "⭐ Wo liegt das Repository" en "⭐ Where is the repository",
                """
            Untersuchen Sie das Verzeichnis.
            Wo liegt wohl das Git-Repository? Was enthält es?

                $ ll -a
                $ ll .git/
        """ en
                        """
            Examine the directory.
            Where is the Git repository located? What does it contain?

                $ ll -a
                $ ll .git/
        """
        ) {
            inRepo("myrepo") {
                ll("-a")
                ll("-a .git/")
            }
        }
    }
}
