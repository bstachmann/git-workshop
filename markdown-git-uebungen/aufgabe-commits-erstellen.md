---
layout: page
title: <code>commits-erstellen</code>
parent: Aufgaben

nav_order: 6
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



<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<!--UEB-Commits erstellen--><h2>Schritt 1 - Commit - mit Staging</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Bearbeite die Datei `hallo-welt`,
füge sie mit `git add` zum Index hinzu (Staging)
und erstelle ein Commit mit diesen Änderungen.

<!--UEB-Commits erstellen--><h2>Schritt 2 - Commit - automatisches Staging</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Bearbeite die Datei `hallo-welt` erneut
und erstelle wieder ein Commit,
dieses mal mal aber mit `-a`.

<!--UEB-Commits erstellen--><h2>Schritt 3 - Commit - neue Datei</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Erstelle `new-world` und bestätige sie mit einem Commit.

<!--UEB-Commits erstellen--><h2>Schritt 4 - Commit - Datei löschen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Lösche `hallo-welt` und bestätige dies per Commit.

<!--UEB-Commits erstellen--><h2>Schritt 5 - ⭐ Add - Dateien rekursiv hinzufügen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Lege eine Datei `superneu` und eine Verzeichnis `sub`mit einer
Datei `auchneu` an füge beide mit *einem* Add-Aufruf hinzu und erstelle
dann ein Commit.

<!--UEB-Commits erstellen--><h2>Schritt 6 - ⭐ Commit - Datei verschieben/umbenennen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Benenne die Datei `hello-world` in `renamed-world` um
und bestätige dies durch ein Commit.

<!--UEB-Commits erstellen--><h2>Schritt 7 - ⭐ Rename detection</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/commits-erstellen/repo`.

Benenne die Datei `datei1` in `datei2` mit `git mv` um. 
Sorge dafür, dass die *Rename Detection* dies nicht erkennt.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Lösung](loesung-commits-erstellen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

