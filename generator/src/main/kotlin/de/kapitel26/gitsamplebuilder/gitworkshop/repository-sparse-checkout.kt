package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.sparseCeckout() {
    createAufgabenFolge("sparse-checkout") {
        createIntro(
                "Sparse Checkout",
                """

                ## Tipps
                
                 * `git clone --sparse`: Klont ein Repository, ohne den Workspace zu füllen.
                 * `git sparse-checkout init --cone`: Konfiguriert den cone-Modus für bessere Performance.
                 * `git sparse-checkout add fileDirOrPattern`: Dateien bzw. Verzeichnisse hinzufügen,
                    die beim nächsten Checkout geladen werden sollen.
                    Beim nächsten Checkout wird alles geholt.
                 * `git sparse-checkout list`: Aktuelle Sparse-Checkout-Konfiguration ansehen.
                 * `git sparse-checkout disable`: Sparse-Checkout wieder abschalten.

                ## Setup
                
                Ein Git-Repository namens `repo` wurde bereits erstellt.
                Es enthält Dateien auf dem Top-Level und in zwei Unterverzeichnissen.

                ### Verzeichnisse

                 * `${rootDir.name}/` Haupverzeichnis für diese Übung 
                   - `repo/` Bereits vorhandenes Repository.
                  
            """ en
                        """

                ## Tips
                
                 * `git clone --sparse`: Clones a repository without populating the workspace.
                 * `git sparse-checkout init --cone`: Configures cone mode for better performance.
                 * `git sparse-checkout add fileDirOrPattern`: Add files or directories
                    to be loaded on the next checkout.
                    Everything will be fetched on the next checkout.
                 * `git sparse-checkout list`: View the current sparse-checkout configuration.
                 * `git sparse-checkout disable`: Disable sparse-checkout again.

                ## Setup
                
                A Git repository named `repo` has already been created.
                It contains files at the top level and in two subdirectories.

                ### Directories

                 * `${rootDir.name}/` Main directory for this exercise
                   - `repo/` Existing repository.
                  
            """
        ) {
            createRepo("repo") {
                createFileAndCommit("README.md")
                createDir("component-a") { createFileAndCommit("foo") }
                createDir("component-b") { createFileAndCommit("bar") }
            }
        }

        createAufgabe(
                "repository-sparse-checkout",
                "Sparse-Klon durchführen" en "Perform sparse clone",
                """
                | Erstelle einen Sparse-Klon von `repo` mit dem Namen `myrepo`,
                | überprüfe, dass nur Top-Level-Dateien in den Workspace geholt wurden.
                """.trimMargin() en
                        """
                | Create a sparse clone of `repo` named `myrepo`,
                | verify that only top-level files have been fetched into the workspace.
                """.trimMargin()
        ) {
            git("clone --sparse repo myrepo")
            inRepo("myrepo") { ll() }
        }

        createAufgabe(
                "repository-sparse-checkout",
                "Verzeichnis hinzufügen" en "Add directory",
                """
            | Füge das Verzeichnis `component-a` hinzu .
            | Überprüfe die neue Konfiguration.
            | Validiere, dass `component-a` jetzt da ist.
            """.trimMargin() en
                        """
            | Add the directory `component-a`.
            | Check the new configuration.
            | Validate that `component-a` is now present.
            """.trimMargin()
        ) {
            inRepo("myrepo") {
                git("sparse-checkout add component-a")
                git("sparse-checkout list")
                git("checkout")
                ll()
            }
        }

        createAufgabe(
                "repository-sparse-checkout",
                "Sparse Checkout deaktivieren" en "Disable sparse checkout",
                """
            | Deaktiviere Sparse-Checkout und führe erneut ein Checkout durch.
            | Validiere, dass jetzt alle Dateien da sind.
            """ en
                        """
            | Disable sparse-checkout and perform a checkout again.
            | Validate that all files are now present.
            """
        ) {
            inRepo("myrepo") {
                git("sparse-checkout disable")
                git("checkout")
                ll()
            }
        }

        createAufgabe(
                "repository-sparse-checkout",
                "Klonen und auschecken" en "Clone and checkout",
                """
                | Klone `myrepo`, schränke auf `component-a` ein
                | und mache ein Checkout. Nutze die `--cone`-Option.
                """.trimMargin() en
                        """
                | Clone `myrepo`, restrict to `component-a`
                | and do a checkout. Use the `--cone` option.
                """.trimMargin()
        ) {
            git("clone --sparse repo myclone")
            inRepo("myclone") {
                git("sparse-checkout init --cone")
                git("sparse-checkout add component-a")
                git("checkout")
                ll()
            }
        }

        //        createAufgabe(
        //            "Beispiel von Slide mit --no-checkout",
        //            """
        //                    """
        //        ) {
        //            git("clone --no-checkout repo myrepo2")
        //
        //            inRepo("myrepo2") {
        //                markdown(
        //                    "Man sieht hier das Problem mit --no-checkout, weil der Workspace leer
        // ist, " +
        //                            "sieht git hier lauter Löschungen."
        //                )
        //                git("status")
        //                git("sparse-checkout init --cone")
        //                git("sparse-checkout add component-a/foo")
        //                git("checkout")
        //                markdown("Man sieht, dass das `checkout` dann auch nicht wie erhofft
        // wirkt.")
        //                ll("-R")
        //                git("status")
        //            }
        //        }

    }
}
