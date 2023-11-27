---
layout: page
title: <code>repository-untersuchen</code>
parent: Aufgaben

nav_order: 3
---
# Übung - Repository untersuchen

Hier geht es darum, herauszufinden, was in einem Repository enthalten ist.

## Tipps

* `git log` zeigt alles Commits, die im aktuellen Branch enthalten sind.
  - `--oneline` macht die Ausgabe kompakter.
* `git show <some-commit>` zeigt Details zu einem Commit
* Mit `~` Adressiert man Vorgänger eines Commits, 
  z. B. ist `HEAD~2` der Vorvorgänger von `HEAD`.
* `git branch` und `git tag` listen vorhandene Branches und Tags auf.
* Mit `git switch <branch-name>` kann man auf andere Branches wechseln.
* Mit `git switch --detach <commit>` kann man auf beliebige Versionen wechseln.
* Mit `git restore -s <commit> -- <datei-oder-pfad>` kann man *Inhalte* beliebiger Versionen 
  von Dateien/Pfaden in den Workspace holten. Es wird dabei nicht auf das angegebenen Commit
  gewechselt, sondern nur Dateiinhalte in den Workspace geholt. Die betroffenen Dateien 
  werden als `modified` angezeigt und können Commited werden.
   
# Setup

Im Verzeichnis `repo` wartet ein Git-Projekt darauf,
untersucht zu werden. 



<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<!--UEB-Repository untersuchen--><h2>Schritt 1 - Branches zeigen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-untersuchen/repo`.

Zeige an, welche Branches es gibt.
Zeige jetzt den Commit-Graphen über alle Branches an.

<!--UEB-Repository untersuchen--><h2>Schritt 2 - Branch wechseln</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-untersuchen/repo`.

Wechsle auf den Branch `feature-a`.
Sieh Dir den Inhalt der Datei `bar` im Verzeichnis `foo` an.
Wechsle zurück auf `main`.

<!--UEB-Repository untersuchen--><h2>Schritt 3 - Tags zeigen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-untersuchen/repo`.

Zeige alle Tags an.

<!--UEB-Repository untersuchen--><h2>Schritt 4 - ⭐ Inhalte vergangener Versionen untersuchen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-untersuchen/repo`.

Lasse dir anzeigen, welche Dateien es im Workspace gibt.
Lasse Dir anzeigen welche Dateien es in vorigen Commit gab.            
Wechsle zum vorigen Commit, und untersuche, wie der Workspace dannn aussieht.

Wechsle dann wieder auf `main` zurück.

<!--UEB-Repository untersuchen--><h2>Schritt 5 - ⭐ Hole alten Stand einer einzelnen Datei zurück.</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-untersuchen/repo`.

Die Datei `hallo-welt` wurde nach dem `release1.0` bearbeitet.
Dem Kunden gefällt das nicht. Stelle den alten Zustand mit
einem neuen Commit wieder her. 


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Lösung](loesung-repository-untersuchen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

