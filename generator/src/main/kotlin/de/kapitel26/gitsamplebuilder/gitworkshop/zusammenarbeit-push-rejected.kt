package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.pushRejected() {
    createAufgabenFolge("push-rejected") {
        val projectName = "apollo"
        val blessedRepo = "blessed-$projectName.git"
        val anjasClone = "anjas-$projectName"
        val myClone = "my-$projectName"
        val anjasFile = "backend.java"
        val myFile = "frontend.java"

        createIntro(
                "Umgang mit \"Push Reject\"" en "Dealing with \"Push Reject\"",
                """
                 
                Wenn mehrere Entwickler am selben Projekt arbeiten,
                kommt es beim `git push` häufig zu der Meldung
                `error: failed to push some refs ...`,
                dem sogenannten *Push Reject*.
                
                **Das ist nicht schlimm.** 
                Es bedeutet lediglich, dass im `origin`-Repository
                Commits gefunden wurden, 
                die lokal noch nicht integriert sind.

                Man mit `git pull` kann man die Änderungen holen und integrieren.
                
                Oder man kann mit `git fetch` die Änderungen zunächst nur abholen,
                um sie zu untersuchen, und später zu entscheiden,
                was man damit machen möchte.

                ## Tipps
                
                 * `git push`: Überträgt Commits zum `origin`.
                 * `git fetch`: Holt Commit, ändert aber Workspace und lokalen Branch nicht
                 * `git pull`: Holt und **integriert** Commits.
                 * `git log A..B` zeigt "was B gemacht hat".\
                    Oder etwas genauer: Jenes Commits aus der Historie von `B`, 
                    die noch nicht in `A` enthalten sind.
                 * `git diff A B` zeigt die Unterschiede zwischen A und B\
                   (symmetrisches Diff)
                 * `git diff A...B` zeigt die Änderungen der Seite B.\
                    Oder etwas genauer: Das Diff zwischen dem letzen gemeinsamen Vorgänger zu B.\
                    (asymmetrisches Diff)

                ## Setup
    
                 * Du arbeitest an einem Projekt `$projectName`,
                   das von Deiner Kollegin Anja erstellt wurde.
                 * Du sollst die Datei `$myFile` verbessern,
                   während Anja an der Datei `$anjasFile` weiterarbeitet.

                Wenn Anja ihre Änderungen vor Dir hochlädt,
                wirst Du einen *Push Reject* erfahren.
                
                ### Verzeichnisse

                 * `${rootDir.name}/` Haupverzeichnis für diese Übung 
                   - `$blessedRepo/` Das geteilte (blessed) Repository liegt hier.
                   - `$anjasClone/` Hier arbeitet Anja.  
                   - `$myClone/` **Du arbeitest hier.**
            """ en
                        """
                 
                When multiple developers work on the same project,
                the message `error: failed to push some refs ...`
                often occurs during `git push`,
                the so-called *Push Reject*.
                
                **This is not a bad thing.**
                It simply means that in the `origin` repository
                commits were found
                that are not yet integrated locally.

                You can fetch and integrate the changes with `git pull`.
                
                Or you can first fetch the changes with `git fetch`
                to examine them, and later decide
                what you want to do with them.

                ## Tips
                
                 * `git push`: Transfers commits to `origin`.
                 * `git fetch`: Fetches commits, but does not change the workspace and local branch
                 * `git pull`: Fetches and **integrates** commits.
                 * `git log A..B` shows "what B did".\
                    Or more precisely: Those commits from the history of `B`
                    that are not yet contained in `A`.
                 * `git diff A B` shows the differences between A and B\
                   (symmetrical diff)
                 * `git diff A...B` shows the changes of side B.\
                    Or more precisely: The diff between the last common ancestor and B.\
                    (asymmetrical diff)

                ## Setup
    
                 * You are working on a project `$projectName`,
                   that was created by your colleague Anja.
                 * You are supposed to improve the file `$myFile`,
                   while Anja continues to work on the file `$anjasFile`.

                If Anja uploads her changes before you,
                you will experience a *Push Reject*.
                
                ### Directories

                 * `${rootDir.name}/` Main directory for this exercise
                   - `$blessedRepo/` The shared (blessed) repository is here.
                   - `$anjasClone/` Anja works here.
                   - `$myClone/` **You work here.**
            """
        ) {
            createRepo(blessedRepo, "--bare") {
                createClone("../$anjasClone") {
                    user("anja")
                    createFileAndCommit(anjasFile)
                    createFileAndCommit(myFile)
                    git("push")
                }

                createClone("../$myClone")
            }

            inRepo(anjasClone) {
                editAndCommit(anjasFile, 1)
                editAndCommit(anjasFile, 5)
                git("push")
            }
        }

        inRepo(myClone) {
            createAufgabe(
                    "Lokal Commit(s) erstellen" en "Create local commit(s)",
                    """
                    Bearbeite die Datei `$myFile` und erstelle (mindestens) ein Commit mit den Änderungen.
                    Überprüfe danach mit `git status`, ob der Workspace sauber ist.
                    """ en
                            """
                    Edit the file `$myFile` and create (at least) one commit with the changes.
                    Then check with `git status` if the workspace is clean.
                    """
            ) {
                editAndCommit(myFile, 1)
                markdown(
                        "Und jetzt noch eben prüfen, ob `working tree clean` ist." en
                                "And now just check if the `working tree is clean`."
                )
                git("status")
            }

            createAufgabe(
                    "Push versuchen" en "Try to push",
                    """Versuche jetzt Deine Änderungen zu pushen.""" en
                            """Now try to push your changes."""
            ) {
                git("push", setOf(1))
                markdown(
                        """
                    Wie Du siehst, der Push wurde verweigert. 
                    Anscheinend war Anja schneller,
                    und hat ihre Änderungen zuerst nach `$blessedRepo` gepushed.
                """ en
                                """
                    As you can see, the push was rejected.
                    Apparently Anja was faster
                    and pushed her changes to `$blessedRepo` first.
                """
                )
            }

            createAufgabe(
                    "(optional) Problem analysieren" en "(optional) Analyze problem",
                    """
                    Hole zunächt die Änderungen, ohne zu integrieren (`fetch`),
                    und lasse Dir die Änderungen von *Anja* zeigen.
                     
                     * Welche Commits hat Anja gemacht (`log`)?
                     * Welche Unterschiede gibt es zweichen deiner und Anjas Version (symmetrisches `diff`)?
                     * Welche Änderungen hat Anja gemacht (asymmetrisches `diff`)?
                    """ en
                            """
                    First fetch the changes without integrating (`fetch`),
                    and let *Anja's* changes be shown to you.
                     
                     * Which commits did Anja make (`log`)?
                     * What are the differences between your and Anja's version (symmetrical `diff`)?
                     * What changes did Anja make (asymmetrical `diff`)?
                    """
            ) {
                markdown(
                        "`fetch` holt die Daten, ohne den Workspace oder Deine lokalen Branches zu verändern." en
                                "`fetch` fetches the data without changing the workspace or your local branches."
                )
                git("fetch")
                markdown(
                        "Die Ausgabe zeigt, dass neue Commit für den `origin/main` geholt wurden" en
                                "The output shows that new commits have been fetched for `origin/main`"
                )
                markdown(
                        "Die `..`-Notation zeigt, welche Commits hinzugekommen sind:" en
                                "The `..` notation shows which commits have been added:"
                )
                git("log --oneline main..origin/main")
                markdown(
                        """
                    Das normale (symmetrische) Diff zeig alle Unterschiede. 
                    Sowohl das, was du gemacht hast, als auch das, was Anja gemacht hat:"
                """ en
                                """
                    The normal (symmetrical) diff shows all differences.
                    Both what you did and what Anja did:"
                """
                )
                git("diff --stat HEAD origin/main")
                markdown(
                        """
                    Das asymmetrische Diff `...` zeigt nur jene Änderungen,
                    die Anja gemacht hat
                    (bezogen auf den letzten gemeinsamen Vorgänger):"
                """ en
                                """
                    The asymmetrical diff `...` only shows those changes
                    that Anja made
                    (relative to the last common ancestor):"
                """
                )
                git("diff --stat HEAD...origin/main")
            }

            createAufgabe(
                    "Fremde Änderungen integrieren" en "Integrate foreign changes",
                    """
                    Integriere die Änderungen mit Pull und sieh Dir dann den Commit-Graphen an.
                    """ en
                            """
                    Integrate the changes with pull and then look at the commit graph.
                    """
            ) {
                git("pull")
                markdown(
                        """
                    Da *Anja* eine andere Datei (`$anjasFile`) bearbeitet hat als Du (`$myFile`),
                    konnten ihre Änderungen problemlos integriert werden.
                    Man sieht, dass ein neues Commit entstanden ist,
                    welches die Stränge zusammenführt.
                """ en
                                """
                    Since *Anja* edited a different file (`$anjasFile`) than you (`$myFile`),
                    her changes could be integrated without any problems.
                    You can see that a new commit has been created,
                    which merges the branches.
                """
                )
                git("log --graph --oneline")

                markdown(
                        "#### Achtung: Beim `pull` kann es Merge-Konflikte geben ..." en
                                "#### Attention: `pull` can cause merge conflicts ..."
                )
                markdown(
                        """
                    ... wenn beide Seiten dieselben Stellen bearbeitet haben.
                    Das Auflösen von Merge-Konflikten ist Thema eines folgenden Kapitels.
                """.trimIndent() en
                                """
                    ... if both sides have edited the same places.
                    Resolving merge conflicts is the topic of a subsequent chapter.
                """.trimIndent()
                )
            }

            createAufgabe(
                    "Erneut pushen" en "Push again",
                    """
                    
                    """ en
                            """
                    
                    """
            ) {
                git("push")
                markdown(
                        """
                    Und siehe da: Jetzt klappt's.
                """ en
                                """
                    And lo and behold: Now it works.
                """
                )

                markdown(
                        "#### Achtung: Falls schon wieder jemand schneller war ..." en
                                "#### Attention: If someone was faster again ..."
                )
                markdown(
                        """
                    ... und nach $blessedRepo gepushed hat,
                    kann es nochmal ein *Push Reject* geben,
                    und wir versuchen erneut ein `pull`, dann ein `push`,
                    solange, bis es klapp.
                """ en
                                """
                    ... and has pushed to $blessedRepo,
                    there can be another *Push Reject*,
                    and we try again a `pull`, then a `push`,
                    as long as it works.
                """
                )
            }
        }
    }
}
