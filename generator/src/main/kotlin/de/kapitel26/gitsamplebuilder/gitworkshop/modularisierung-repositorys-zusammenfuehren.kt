package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.repositorysZusammenfuehren() {
    createAufgabenFolge("repositorys-zusammenfuehren") {
        createIntro(
                "Kleine Projekte zusammenfuehren" en "Merging small projects",
                """
                Zwei bisher unabhängige Repositorys sollen,
                unter Erhaltung der Historie zu einem 
                großen Repository zusammengeführt werden.
                
                ## Tipps
              
                 * Mit `fetch` (und `pull`) kann man auch Historie aus fremden Repositorys ohne gemeinsame Histories
                 mit dem aktuellen Repository holen (Stichwort *unrelated histories*).
                 * `merge` (und `pull`) verweigern normalerweise das Integrieren von *unrelated histories*
                   - Mit `--allow-unrelated-histories` kann man dies jedoch erzwingen.
                 * `git mv` verschiebt Dateien und Verzeichnisse, z. B. `git mv datei1 date1 zielverzeichnis`.
                 *  `subtree add --prefix=<Zielverzeichnis> <Quellrepository> <Quellbranch oder Version>`: Einbetten eines anderen Repositorys in ein Unterverzeichnis.
                    - Fall man nicht die ganze Historie übernehmen möchte, kann man `--squash` angeben.
                    - **Achtung:** `subtree add ` führt einen Merge auf `HEAD` durch und  
                      kann daher nicht in einem leeren Repository ohne Commits ausgeführt werden.

                ## Setup
     
                Zwei Repositorys
                 
                 * `backend.git`
                 * `ui.git` 
    
                sind bereits vorhanden.
 
            """ en
                        """
                Two previously independent repositories are to be
                merged into one large repository while preserving
                their history.
                
                ## Tips
              
                 * With `fetch` (and `pull`), you can also fetch history from foreign repositories without a common history
                 with the current repository (keyword *unrelated histories*).
                 * `merge` (and `pull`) normally refuse to integrate *unrelated histories*
                   - However, you can force this with `--allow-unrelated-histories`.
                 * `git mv` moves files and directories, e.g., `git mv file1 file1 targetdirectory`.
                 *  `subtree add --prefix=<target-directory> <source-repository> <source-branch-or-version>`: Embed another repository in a subdirectory.
                    - If you don't want to take over the entire history, you can specify `--squash`.
                    - **Attention:** `subtree add` performs a merge on `HEAD` and
                      therefore cannot be executed in an empty repository without commits.

                ## Setup
     
                Two repositories
                 
                 * `backend.git`
                 * `ui.git` 
    
                are already present.
 
            """
        ) {
            createRepo("backend.git", "--bare") { createClone("../backend") }
            createRepo("ui.git", "--bare") { createClone("../ui") }

            inRepo("backend") {
                createDir("src") { createFileAndCommit("Backend.java") }
                createDir("test") { createFileAndCommit("BackendTest.java") }
                git("push")
            }

            inRepo("ui") {
                createDir("src") { createFileAndCommit("UI.java") }
                createDir("test") { createFileAndCommit("UITest.java") }
                git("push")
            }
        }

        createAufgabe(
                "Zusammenführen `git subtree`" en "Merge `git subtree`",
                """
                
                 1. Erstelle ein Repo `application` mit einem Commit.
                 2. Füge `backend.git` in einem Unterverzeichnis `backend` hinzu.
                 3. Füge `ui.git` in einem Unterverzeichnis `ui` hinzu.
                 4. Untersuche Verzeichnissstruktur und Commit-Graphen
                    """ en
                        """
                
                 1. Create a repo `application` with one commit.
                 2. Add `backend.git` in a subdirectory `backend`.
                 3. Add `ui.git` in a subdirectory `ui`.
                 4. Examine the directory structure and commit graph
                    """
        ) {
            createRepo("application") {
                markdown(
                        "Wir erzeugen ein erstes Commmit, damit der `subtree`-Befehl ausgeführt werden kann." en
                                "We create a first commit so that the `subtree` command can be executed."
                )
                createFileAndCommit("README")
                markdown(
                        "Dann fügen wir die Repos mit `subtree` hinzu:" en
                                "Then we add the repos with `subtree`:"
                )
                git("subtree add --prefix=backend ../backend.git main")
                git("subtree add --prefix=ui ../ui.git main")

                markdown(
                        "Man sieht ui und backend wurden mitsamt Historie zusammengeführt:" en
                                "You can see that ui and backend have been merged including their history:"
                )
                git("ls-tree -r --name-only HEAD")
                git("log --oneline --graph")
            }
        }

        createAufgabe(
                "Zusammenführen mit `fetch`, `mv` und `merge`" en
                        "Merge with `fetch`, `mv` and `merge`",
                """
            UI und Backend sollen in einem neuen Klon `gesamt` zusammengeführt werden.
            Folge den Anweisungen im Kapitel *"Kleine Projekte zusammenführen"*.
            Untersuche dann Verzeichnissstruktur und Commit-Graphen
            """ en
                        """
            UI and backend should be merged in a new clone `gesamt`.
            Follow the instructions in the chapter *"Merging small projects"*.
            Then examine the directory structure and commit graph.
            """
        ) {
            git("clone backend gesamt")
            inRepo("gesamt") {
                markdown(
                        "Backend-Dateien in Unterverzeichnis verschieben:" en
                                "Move backend files to subdirectory:"
                )
                bash("mkdir backend")
                git("mv src test backend")
                git("commit -m 'backend-Verzeichnis angelegt'")

                markdown(
                        "Inhalt des UI-Repository in einen lokalen Branch `uimain` holen:" en
                                "Fetch content of the UI repository into a local branch `uimain`:"
                )
                git("remote add ui ../ui/")
                git("fetch ui")
                git("switch -c uimain ui/main")

                markdown(
                        "UI-Dateien in Unterverzeichnis verschieben:" en
                                "Move UI files to subdirectory:"
                )
                bash("mkdir ui")
                git("mv src test ui")
                git("commit -m 'ui-Verzeichnis angelegt'")

                markdown("`uimain` integrieren:" en "Integrate `uimain`:")
                git("switch main")
                git("merge uimain --allow-unrelated-histories")

                markdown(
                        "Man sieht ui und backend wurden mitsamt Historie zusammengeführt:" en
                                "You can see that ui and backend have been merged including their history:"
                )
                git("ls-tree -r --name-only HEAD")
                git("log --oneline --graph")
            }
        }
    }
}
