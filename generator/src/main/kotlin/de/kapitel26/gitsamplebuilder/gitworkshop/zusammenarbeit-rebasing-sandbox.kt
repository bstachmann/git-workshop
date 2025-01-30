package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.rebasingSandbox() {
    createAufgabenFolge("rebasing") {

        createIntro(
            """Rebasing Sandbox""",
            """

            """
        ) {
            createRepo("repo-rebase") {
                createFileAndCommit("hello") { content = """
                    def fac(n):
                        if n == 1:
                            return 1
                        else:
                            return n*fac(n-1)

                    def demo():
                        print("Demo")
                        print(f'fac(6) = {fac(6)}')

                    if __name__ == '__main__':
                        demo()

                """.trimIndent()
                }

                startBranch("feature") {
                    editAndCommit("hello", "Uppercase hello") { content = "Hallo Welt" }
                }

                createFileAndCommit("bar")

                createClone("../repo-merge")
            }
        }

        createAufgabe(
            "Feature-Branch per Rebase aktualiseren.",
            """
                    """
        ) {

            inRepo("repo-rebase") {
                // rebase onto main, but keep feature
                startBranch("f-tmp", "feature") {
                    git("rebase main")
                }
                git("rebase f-tmp")
                git("branch -d f-tmp")

                editAndCommit("hello", "Add !") { content = "Hallo Welt!" }


                git("switch feature")
                createFile("wurst")
                git("add wurst")
                git("commit --amend -m 'Amended'")
                git("log --graph --all --decorate --oneline")
                git("rebase main", acceptableExitCodes = setOf(1))
                bash("cat hello")

            }
        }

        createAufgabe(
            "Feature-Branch per Merge aktualiseren.",
            """
                    """
        ) {
            inRepo("repo-merge") {
                onBranch("feature") {}

                git("merge feature")

                editAndCommit("hello", "Add !") { content = "Hallo Welt!" }

                git("log --graph --all --decorate --oneline")

                git("switch feature")
                git("merge main", acceptableExitCodes = setOf(0))
                bash("cat hello")

            }
        }
    }
}
