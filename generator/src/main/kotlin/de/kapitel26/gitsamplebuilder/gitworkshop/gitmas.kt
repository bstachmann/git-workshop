package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples
import impl.en

fun CollectionOfSamples.gitmas() {

    createAufgabenFolge("gitmas") {
        createIntro(
                "Fröhliche Weihnachten!" en "Merry Christmas!",
                """
                Auch Git kann ein Weihnachtliches Tool sein.

                Hier geht es darum durch Branchen und mergen 
                Git-Graphen zu erzeugen, der wie ein
                Weihnachtsbaum aussieht.

                Lasse Deiner Kreativität freien Lauf, oder folge diesen **Tipps:**

                 * Zweige eine Reihe von Branches von ˋmainˋ ab
                 * Mache ein Commit auf jedem der Branches, damit es was zu mergen gibt.
                 * Gehe auf den zweiten Branch und merge den ersten. Gehe dann auf den dritten ...
                 * Dann merge den letzten Branch nach ˋmainˋ.
                 * Wenn Du scripten kannst, z.B. mit Bash oder Python: ˋforˋ-Schleifen sind nützlich.

            """ en
                        """
                Git can also be a Christmas tool.

                This is about creating a Git graph that looks like a
                Christmas tree by branching and merging.

                Let your creativity run wild, or follow these **tips:**

                 * Branch a series of branches from ˋmainˋ
                 * Make a commit on each of the branches so there is something to merge.
                 * Go to the second branch and merge the first. Then go to the third...
                 * Then merge the last branch to ˋmainˋ.
                 * If you can script, e.g. with Bash or Python: ˋforˋ loops are useful.

            """
        )

        createAufgabe(
                "Und jetzt ein Weihnachtsbaum" en "And now a Christmas tree",
                """
                Branche und Merge so, dass ˋgit log --graph --onelineˋ
                einen Weihnachtsbaum ausgibt.
            """ en
                        """
                Branch and merge so that ˋgit log --graph --onelineˋ
                outputs a Christmas tree.
            """
        ) {
            createRepo("myrepo") {
                createFileAndCommit("hallo", message = "!")
                val words =
                        "We wish you a merry Christmas and a happy new year".split(" ").reversed()
                words.forEachIndexed { i, _ ->
                    git("switch -c b${i} main")
                    createFileAndCommit("f${i}", message = "!")
                }
                words.forEachIndexed { i, w ->
                    val targetBranch = if (i < words.size - 1) "b${i+1}" else "main"
                    git("switch ${targetBranch}")
                    git("merge --no-ff b${i} -m '${w}'")
                }
                markdown("## Merry GITmas")
                git("log --all --oneline --topo-order --graph -${words.size+1} main")
            }
        }
    }
}
