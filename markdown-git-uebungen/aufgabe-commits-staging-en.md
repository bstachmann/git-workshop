---
layout: page
title: <code>commits-staging-en</code>
parent: Exercises

nav_order: 7
---
# Exercise - Staging

Es geht um den *Stage-Bereich* (auch Index genannt).
Jede Änderung (bearbeitete, neue oder gelöschte Dateien) 
wird muss als "Snapshot" im Stage-Bereich registriert werden
(z.B. mit `git add`),
bevor Sie in ein Commit übernommen werden kann.

## Tipps

* `git add <datei/verzeichnis>` 
   überträgt den aktuellen Stand einer Datei in den Stage-Bereich.
*  Ändert man eine Datei nach dem `add`, hat sie
   im Workspace einen anderen Stand als in der Stage.
* `git status`, `git diff` und `git diff --staged` zeigen dies.
* `git restore --staged <file>` nimmt ein Staging zurück.
* `git restore <file>` stellt eine Datei im Workspace wieder her.
   **Achtung**: Die lokale Änderungen werden dabei überschreiben!
* mit `-s <revision>` können auch beliebige andere Stände von Dateien und Verzeichnisse
  geholt werden.
* `git stash -u` entfernt alle Änderungen (und unversioniert Dateien)
  aus dem Workspace (und sichert diese im Stash).
        
# Setup

Im Verzeichnis `repo` wartet ein Git-Projekt darauf,
bearbeitet zu werden. 


<h2>Step 0 - START <!-- UEB/Staging/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Staging <!-- UEB/Staging/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Ersetze in der Datei `demo`,
`Fit` durch `Git`.
Füge sie dann zum Stage-Bereich hinzu.
Ersetze dann `doof` durch `toll`.
Lasse dir den Status und die Diffs
für Workspace und Stage zeigen.

<h2>Step 2 - Restore - Staging zurücknehmen <!-- UEB/Staging/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Die letzte Änderung soll doch noch nicht in das nächste Commit übernommen werden,
nehme sie zurück. 

<h2>Step 3 - Restore - Änderung ganz zurücknehmen <!-- UEB/Staging/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Die Änderungen an `demo` sollen ganz zurückgenommen werden.
Lasse Dir nachher Status und Diffs anzeigen.

<h2>Step 4 - ⭐ Restore - Älteren Inhalt einer Datei zurückholen <!-- UEB/Staging/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Die Datei `beispiel` wurde dreimal bearbeitet.
Hole den mittleren Stand zurück und erstelle ein Commit.

<h2>Step 5 - ⭐ Restore - Zurückholen älterer Verzeichnisversionen <!-- UEB/Staging/5 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Im Folder `ufer` wurde ein Spiel gespielt.
Stelle die Spielstände nach, 
indem Du `restore` auf das `ufer`-Verzeichnis anwendest.

Tipp: `ll ufer/*` zeigt die Verzeichnisse des Spiels.

Tipp: Beim `restore` werden unversionierte Dateien nicht abgeräumt.
Man kann sie mit dem `stash`-Befehl abräumen.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


To the exercise(loesung-commits-staging.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

To the overview(../../ueberblick.html){:style="visibility: hidden"}

