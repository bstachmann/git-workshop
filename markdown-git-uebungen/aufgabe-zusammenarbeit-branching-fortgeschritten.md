---
layout: page
title: <code>zusammenarbeit-branching-fortgeschritten</code>
parent: Aufgaben

nav_order: 13
---
# Übung - Branching (fortgeschritten)



## Infos

* `git branch` 

## Tipps

* `git switch -c <name>` erzeugt einen neuen Branch und aktiviert 
  diesen sogleich.
* `git branch -vv` zeigt Details zu den lokalen Branches
* `git switch <name>` wechselt den aktiven Branch
* `git merge <branch>` integriert die Änderungen von `branch` und erstellt ein Commit
   auf dem aktiven Branch.
* 

  
## Ausgangssituation


<h2>Schritt 0 - START <!-- UEB/Branching (fortgeschritten)/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Schritt 1 - Branch erstellen <!-- UEB/Branching (fortgeschritten)/1 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Erstelle einen Branch `feature-a`, bearbeite die Datei `foo`
und erstelle ein Commit.
Wechsle dann zurück auf den `main` und bearbeite dort `bar`.
Zeige den Commit-Graphen.

<h2>Schritt 2 - Branch mergen <!-- UEB/Branching (fortgeschritten)/2 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Merge `feature-a` auf den `main`und
zeige den Commit-Graphen.

<h2>Schritt 3 - ⭐ Merge analysieren <!-- UEB/Branching (fortgeschritten)/3 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Zeige, welche Commits vom `main` im Merge hinzugekommen sind.
Zeige, welche Commits von `feature-a` im Merge hinzugekommen sind.
Zeige ebenfalls die Änderungen (Diffs) für beide Seiten.

<h2>Schritt 4 - ⭐ Merge analysieren <!-- UEB/Branching (fortgeschritten)/4 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Zeige, welche Commits vom `main` im Merge hinzugekommen sind.
Zeige, welche Commits von `feature-a` im Merge hinzugekommen sind.
Zeige ebenfalls die Änderungen (Diffs) für beide Seiten.

<h2>Schritt 5 - Remote Branches untersuchen <!-- UEB/Branching (fortgeschritten)/5 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.




<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Lösung](loesung-zusammenarbeit-branching-fortgeschritten.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

