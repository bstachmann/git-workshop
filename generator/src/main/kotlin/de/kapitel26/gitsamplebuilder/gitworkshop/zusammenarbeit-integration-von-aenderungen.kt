package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.integrationVonAenderungen() {
    createAufgabenFolge("integration-von-aenderungen") {
        createIntro(
                "Integration von Änderungen" en "Integration of changes",
                """

                Wenn mehrere Entwickler unabhängig am selben Projekt arbeiten,
                müssen deren Änderungen von Zeit zu Zeit integriert werden.
                Dies nennt man *Merging*.
                
                Die Integration kann in Git mit den Befehlen `pull`, `merge`
                und `rebase` durchgeführt werden.

                Dabei kommt es immer mal wieder zu *Merge-Konflikten*.
                
                In dieser Übung zeigen wir die Integration per `pull`,
                weil dies sehr typisch für das Arbeiten mit Git ist.
                
                Die Zusammenführung und der Umgang mit Konflikten funktioniert
                aber bei `merge` und `rebase` ganz ähnlich..

                ## Infos
                
                * `git pull` integriert den lokalen Branch mit seinem "upstream" Gegenstück,
                   hier: `main` und `origin/main`

                ## Tipps
                
                * `git config --global merge.conflictStyle diff3` verbessert die Darstellung bei Konflikten.
                * `git pull` holt und integriert Änderungen Äquivalent zu `git fetch` + `git merge`)
                * `git log --graph` zeigt den Commit-Graphen
                * `git diff main origin/main` zeigt die Änderungen der Anderen
                * `git log main..origin/main` zeigt die Commits der Anderen
                * `HEAD^1` und `HEAD^2` bezeichnen den ersten bzw. zweiten Vorgänger,
                  des aktuellen `HEAD`-Commits.
                * `git diff HEAD^1...HEAD^2` zeigt die "fremden" Änderungen 
                * `git log HEAD^1..HEAD^2` zeigt die "fremden" Commits 
                * Nach einem Merge-Konflikt:
                  1. Konfliktdateien bearbeiten
                  2. dann `git add` nicht vergessen
                  3. Den Merge mit `git commit` abschließen
                  
                  
                ## Ausgangssituation
                
                Ihre Kollegin Anja hat die Arbeit an einem Projekt begonnen.
                Nun kommen Sie hinzu und übernehmen Aufgaben.
                Anja hat aber parallel ebenfalls weiter gearbeitet.
                Integrieren Sie die neuen Änderungen von Anja.

            """ en
                        """

                When multiple developers work independently on the same project,
                their changes must be integrated from time to time.
                This is called *merging*.
                
                Integration can be done in Git with the commands `pull`, `merge`
                and `rebase`.

                This often leads to *merge conflicts*.
                
                In this exercise, we show integration via `pull`,
                because this is very typical for working with Git.
                
                However, the merging and handling of conflicts works
                very similarly with `merge` and `rebase`.

                ## Info
                
                * `git pull` integrates the local branch with its "upstream" counterpart,
                   here: `main` and `origin/main`

                ## Tips
                
                * `git config --global merge.conflictStyle diff3` improves the display of conflicts.
                * `git pull` fetches and integrates changes equivalent to `git fetch` + `git merge`)
                * `git log --graph` shows the commit graph
                * `git diff main origin/main` shows the changes of the others
                * `git log main..origin/main` shows the commits of the others
                * `HEAD^1` and `HEAD^2` denote the first and second predecessor,
                  of the current `HEAD` commit.
                * `git diff HEAD^1...HEAD^2` shows the "foreign" changes
                * `git log HEAD^1..HEAD^2` shows the "foreign" commits
                * After a merge conflict:
                  1. Edit conflict files
                  2. then don't forget `git add`
                  3. Complete the merge with `git commit`
                  
                  
                ## Initial situation
                
                Your colleague Anja has started working on a project.
                Now you join and take over tasks.
                But Anja has also continued to work in parallel.
                Integrate the new changes from Anja.

            """
        ) {
            createRepo("origin-for-merge-samples.git", "--bare") {
                createClone("../anjas-repo") {
                    user("anja")

                    createFileAndCommit("README.md") { content = "Hallo Wolt!\n" }
                    createFileAndCommit("average.kts") {
                        content =
                                """
                    if(args.isEmpty())
                        throw RuntimeException("No arguments given!")
    
                    val s = args.map{ it.toInt() }.sum()
                    
                    println("The average is ${'$'}{s/args.size}")
                    
                """.trimIndent()
                    }
                    git("push")
                }

                createClone("../changes-in-different-files") {}

                createClone("../fast-forward") {}

                createClone("../no-ff") {}

                createClone("../changes-in-same-files") {
                    git("config merge.conflictStyle diff3")
                    inFile("average.kts") {
                        replace("val s = ", "val summe = ")
                        replace("{s/args.size}", replaceWith = "{summe/args.size}")
                        commit("Refactoring: s in summe umbenennen")
                    }
                }
            }
            inRepo("anjas-repo") {
                inFile("average.kts") {
                    replace("{ it.toInt() }", "{ it.toDouble() }")
                    commit("Verwende double Werte statt int" en "Use double values instead of int")
                }
                git("push")
            }
        }

        inRepo("fast-forward") {
            createAufgabe(
                    "Fast-Forward beim Pull" en "Fast-forward on pull",
                    """
                    Im einfachste Fall haben wir selber gar nichts gemacht,
                    und wollen nur die Änderungen von Anja übernehmen.
                    
                    Führe ein Pull durch.
                    
                    Lasse Dir Status und den Commit-Graphen zeigen.
                    """ en
                            """
                    In the simplest case, we have done nothing ourselves,
                    and just want to take over Anja's changes.
                    
                    Perform a pull.
                    
                    Show the status and the commit graph.
                    """
            ) {
                git("pull")

                markdown(
                        "Git signalisiert, dass ein Fast-Forward durchgeführt wurde." en
                                "Git signals that a fast-forward was performed."
                )
                markdown(
                        "Der Graph zeigt, dass keine Verzweigung entstanden ist und kein Merge notwendig war." en
                                "The graph shows that no branch was created and no merge was necessary."
                )

                git("log --graph --oneline --decorate")
            }
        }

        inRepo("no-ff") {
            createAufgabe(
                    "Merge erzwingen beim Pull" en "Force merge on pull",
                    """
                    Auch dieses haben wir nichtnichts gemacht,
                    und wollen nur die Änderungen von Anja übernehmen.
                    
                    Führe ein Pull mit `--no-ff` durch.
                    
                    Lasse Dir Status und den Commit-Graphen zeigen.
                    """ en
                            """
                    Again, we have done nothing,
                    and just want to take over Anja's changes.
                    
                    Perform a pull with `--no-ff`.
                    
                    Show the status and the commit graph.
                    """
            ) {
                git("pull --no-ff")

                markdown(
                        "Git signalisiert, dass kein Fast-Forward durchgeführt wurde." en
                                "Git signals that no fast-forward was performed."
                )
                markdown(
                        "Der Graph zeigt, dass ein Merge enstanden ist." en
                                "The graph shows that a merge has occurred."
                )

                git("log --graph --oneline --decorate")
            }
        }

        inRepo("changes-in-different-files") {
            createAufgabe(
                    "Integration bei Änderungen in verschiedenen Dateien" en
                            "Integration with changes in different files",
                    """
                        1. Bearbeite die Datei `README.md`.
                           - Erstelle ein Commit dazu.
                           - Prüfe mit `git show`, ob das Commit OK ist.
                        2. Versuche ein Push
                           - Dies wird scheitern, denn Deine Kollegin Bea 
                             hat die in der Zwischenzeit die Datei `average.kts`
                             bearbeitet und gepushed.
                        3. Integriere mit Pull
                        4. Untersuche das Ergebnis, z. B.
                           - den Commit-Graphen an
                           - die Änderungen, die Anja gemacht hat 
                           - die Commits, die Anja gemacht hat
                    """ en
                            """
                        1. Edit the file `README.md`.
                           - Create a commit for it.
                           - Check with `git show` if the commit is OK.
                        2. Try a push
                           - This will fail because your colleague Bea
                             has edited and pushed the file `average.kts`
                             in the meantime.
                        3. Integrate with pull
                        4. Examine the result, e.g.
                           - the commit graph
                           - the changes Anja made
                           - the commits Anja made
                    """
            ) {
                inFile("README.md") {
                    content = "Hallo Welt!\n"
                    commit()
                }

                git("show")

                git("push", setOf(1))

                markdown(
                        """
                    Diese Meldung zeigt, dass im `origin` Änderungen vorliegen,
                    die wir noch nicht integriert haben.
                """ en
                                """
                    This message shows that there are changes in `origin`
                    that we have not yet integrated.
                """
                )

                git("pull")

                markdown(
                        """
                    Git hat die Änderungen geholt und ein Merge-Commit erzeugt.
                """ en
                                """
                    Git has fetched the changes and created a merge commit.
                """
                )

                git("log --oneline --graph")
                git("diff HEAD^1...HEAD^2")
                git("log HEAD^2..HEAD^1")

                markdown(
                        """
                    Und jetzt können wir erneut ein Push versuchen.
                """ en
                                """
                    And now we can try a push again.
                """
                )

                git("push")
            }
        }

        inRepo("changes-in-same-files") {
            createAufgabe(
                    "Integration bei Änderungen in derselben Datei" en
                            "Integration with changes in the same file",
                    """
                    In diesem Fall bearbeiten wir dieselbe Datei,
                    die auch Anja bearbeitet hat.
                    Es wird zu einem Konflikt kommen, 
                    den wir aulösen müssen.
                    
                    1. Wir haben schon eine Änderung, die zu einem Konflikt führt,
                       vorbereitet und committed. Untersuche diese mit `git show`
                    2. Führe ein Pull durch.
                    3. Lasse Dir den Status zeigen und löse den Konflikt.
                    """ en
                            """
                    In this case, we are editing the same file
                    that Anja also edited.
                    A conflict will occur,
                    which we have to resolve.
                    
                    1. We have already prepared and committed a change that leads to a conflict.
                       Examine it with `git show`.
                    2. Perform a pull.
                    3. Show the status and resolve the conflict.
                    """
            ) {
                git("show")

                git("pull", acceptableExitCodes = setOf(1))

                markdown(
                        "Wie erwartet, ist es zu einem Konflikt gekommen." en
                                "As expected, a conflict has occurred."
                )

                git("status")

                markdown(
                        "In der Datei stehen Konfliktmarkierungen." en
                                "The file contains conflict markers."
                )
                bash("cat average.kts")

                inFile("average.kts") {
                    replaceRegex(
                            """\<\<\<.*\>\>\>""".toRegex(),
                            "val summe = args.map{ it.toDouble() }.sum()"
                    )
                }
                markdown(
                        "Nicht vergessen: Nach dem Bereinigen `git add` aufrufen." en
                                "Don't forget: call `git add` after cleaning up."
                )
                git("add average.kts")
                git("commit -m 'Änderungen von Anja integriert'")

                markdown(
                        "Und hier nochmal der entstandene Graph:" en
                                "And here again the resulting graph:"
                )
                git("log --graph --oneline")
            }
        }
    }
}
