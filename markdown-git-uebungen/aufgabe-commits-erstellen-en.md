---
layout: page
title: <code>commits-erstellen-en</code>
parent: Exercises

nav_order: 6
---
# Exercise - Commits erstellen


## Tipps

* `git add <datei/verzeichnis>` 
   Vor einem Commit müssen Änderungen mit `add` im Staging-Bereich 
   (auch Index genannt) registriert werden
* Als Verzeichnisname darf auch `.` (steht für *aktuelles Verzeichnis*) angegeben werden.
  Dann wird der Befehl auf alle Dateien im aktuellen Verzeichnis und auch Unterverzeichnissen angewandt/
* `git commit -m 'Mein Senf'` Erstellt ein Commit mit allen 
   im Staging-Bereich registrierten Änderungen.
* `git commit -a` Registriert alle Änderungen an bereits in Git versionierten 
  Dateien im Staging-Bereich, so dass man sich den separaten
  `add`-Aufruf sparen kann.
* Die optionen `-a` und `-m` dürfen auch kombiniert werden: `git commit -am "Kommentar"`
* `git log --follow -- <file-name>`
   Zeigt die Historie einer Datei auch über Umbenennungen hinweg.

# Setup

Im Verzeichnis `repo` wartet ein Git-Projekt darauf,
bearbeitet zu werden. 


<h2>Step 0 - START <!-- UEB/Commits erstellen/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Commit - mit Staging <!-- UEB/Commits erstellen/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Bearbeite die Datei `hallo-welt`,
füge sie mit `git add` zum Index hinzu (Staging)
und erstelle ein Commit mit diesen Änderungen.

<h2>Step 2 - Commit - automatisches Staging <!-- UEB/Commits erstellen/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Bearbeite die Datei `hallo-welt` erneut
und erstelle wieder ein Commit,
dieses mal mal aber mit `-a`.

<h2>Step 3 - Commit - neue Datei <!-- UEB/Commits erstellen/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Erstelle `new-world` und bestätige sie mit einem Commit.

<h2>Step 4 - Commit - Datei löschen <!-- UEB/Commits erstellen/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Lösche `hallo-welt` und bestätige dies per Commit.

<h2>Step 5 - ⭐ Add - Dateien rekursiv hinzufügen <!-- UEB/Commits erstellen/5 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Lege eine Datei `superneu` und eine Verzeichnis `sub`mit einer
Datei `auchneu` an füge beide mit *einem* Add-Aufruf hinzu und erstelle
dann ein Commit.

<h2>Step 6 - ⭐ Commit - Datei verschieben/umbenennen <!-- UEB/Commits erstellen/6 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Benenne die Datei `hello-world` in `renamed-world` um
und bestätige dies durch ein Commit.

<h2>Step 7 - ⭐ Rename detection <!-- UEB/Commits erstellen/7 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Benenne die Datei `datei1` in `datei2` mit `git mv` um. 
Sorge dafür, dass die *Rename Detection* dies nicht erkennt.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](loesung-commits-erstellen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

