package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.gitmas() {

    createAufgabenFolge("gitmas") {

        createIntro(
            """Fröhliche Weihnachten!""",
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

            """
        )

        createAufgabe(
            "Und jetzt ein Weihnachtsbaum", """
                Branche und Merge so, dass ˋgit log --graph --onelineˋ
                einen Weihnachtsbaum ausgibt.
            """
        ) {
            createRepo("myrepo") { 
                createFileAndCommit("hallo", message = "!")
                val words = "We wish you a merry Christmas and a happy new year".split(" ").reversed()
                words.forEachIndexed { i, _  ->
                    git("switch -c b${i} main")
                    createFileAndCommit("f${i}", message = "!")
                }
                words.forEachIndexed { i, w ->
                    val targetBranch = if( i < words.size-1 ) "b${i+1}" else "main"
                    git("switch ${targetBranch}")
                    git("merge --no-ff b${i} -m '${w}'")
                }
                markdown("## Merry GITmas")
                git("log --all --oneline --topo-order --graph -${words.size+1} main")
            }
        }

    }
}