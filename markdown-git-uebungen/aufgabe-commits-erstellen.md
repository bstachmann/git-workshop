---
layout: page
title: <code>commits-erstellen</code>
parent: Aufgaben

nav_order: 999
---
# Übung - Commits erstellen


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


<h2>Schritt 0 - START <!-- UEB/commits-erstellen/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Schritt 1 - Commit - mit Staging <!-- UEB/commits-erstellen/1 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Bearbeite die Datei `hallo-welt`,
füge sie mit `git add` zum Index hinzu (Staging)
und erstelle ein Commit mit diesen Änderungen.

<h2>Schritt 2 - Commit - automatisches Staging <!-- UEB/commits-erstellen/2 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Bearbeite die Datei `hallo-welt` erneut
und erstelle wieder ein Commit,
dieses mal mal aber mit `-a`.

<h2>Schritt 3 - Commit - neue Datei <!-- UEB/commits-erstellen/3 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Erstelle `new-world` und bestätige sie mit einem Commit.

<h2>Schritt 4 - Commit - Datei löschen <!-- UEB/commits-erstellen/4 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Lösche `hallo-welt` und bestätige dies per Commit.

<h2>Schritt 5 - ⭐ Add - Dateien rekursiv hinzufügen <!-- UEB/commits-erstellen/5 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Lege eine Datei `superneu` und eine Verzeichnis `sub`mit einer
Datei `auchneu` an füge beide mit *einem* Add-Aufruf hinzu und erstelle
dann ein Commit.

<h2>Schritt 6 - ⭐ Commit - Datei verschieben/umbenennen <!-- UEB/commits-erstellen/6 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Benenne die Datei `hello-world` in `renamed-world` um
und bestätige dies durch ein Commit.

<h2>Schritt 7 - ⭐ Rename detection <!-- UEB/commits-erstellen/7 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Benenne die Datei `datei1` in `datei2` mit `git mv` um. 
Sorge dafür, dass die *Rename Detection* dies nicht erkennt.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Lösung](loesung-commits-erstellen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

