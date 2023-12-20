package de.kapitel26.gitsamplebuilder.gitworkshop

import impl.CollectionOfSamples

fun CollectionOfSamples.gitmas() {

    createAufgabenFolge("gitmas") {

        createIntro(
            """Fröhliche Weihnachten!""",
            """
                Auch Git kann ein Weihnachtliches Tool sein.
            """
        )

        createAufgabe(
                "Und jetzt ein Weihnachtsbaum", """
                Hier geht es darum durch Branchen und mergen 
                Git-Graphen zu erzeugen, der wie ein
                Weihnachtsbaum aussieht.
            """
        ) {
            createRepo("myrepo") { 
                createFileAndCommit("hallo")
                val words = "We wish you a merry Christmas and a happy new year".split(" ").reversed()
                words.forEachIndexed { i, _  ->
                    git("switch -c b${i} main")
                    createFileAndCommit("f${i}")
                }
                words.forEachIndexed { i, w ->
                    val targetBranch = if( i < words.size-1 ) "b${i+1}" else "main"
                    git("switch ${targetBranch}")
                    git("merge --no-ff b${i} -m '${w}'")
                }
                markdown("## Merry **git**mas")
                git("log --all --oneline --topo-order --graph -${words.size+1} main")
            }
        }

    }
}