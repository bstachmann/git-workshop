---
layout: page
title: <code>zusammenarbeit-branching-fortgeschritten-en</code>
parent: Exercises

nav_order: 13
---
# Exercise - Branching (fortgeschritten)



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


<h2>Step 0 - START <!-- UEB/Branching (fortgeschritten)/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Branch erstellen <!-- UEB/Branching (fortgeschritten)/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Erstelle einen Branch `feature-a`, bearbeite die Datei `foo`
und erstelle ein Commit.
Wechsle dann zurück auf den `main` und bearbeite dort `bar`.
Zeige den Commit-Graphen.

<h2>Step 2 - Branch mergen <!-- UEB/Branching (fortgeschritten)/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Merge `feature-a` auf den `main`und
zeige den Commit-Graphen.

<h2>Step 3 - ⭐ Merge analysieren <!-- UEB/Branching (fortgeschritten)/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Zeige, welche Commits vom `main` im Merge hinzugekommen sind.
Zeige, welche Commits von `feature-a` im Merge hinzugekommen sind.
Zeige ebenfalls die Änderungen (Diffs) für beide Seiten.

<h2>Step 4 - ⭐ Merge analysieren <!-- UEB/Branching (fortgeschritten)/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Zeige, welche Commits vom `main` im Merge hinzugekommen sind.
Zeige, welche Commits von `feature-a` im Merge hinzugekommen sind.
Zeige ebenfalls die Änderungen (Diffs) für beide Seiten.

<h2>Step 5 - Remote Branches untersuchen <!-- UEB/Branching (fortgeschritten)/5 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.




<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-branching-fortgeschritten-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

