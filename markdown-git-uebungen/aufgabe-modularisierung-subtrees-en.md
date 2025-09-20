---
layout: page
title: <code>modularisierung-subtrees-en</code>
parent: Exercises

nav_order: 17
---
# Exercise - Modularisierung mit Subtrees


Es geht darum, wie man in Git ein übergreifendes
Repository erstellt, dass Inhalte aus mehreren
anderen Repository einbettet.

Git bietet dazu zwei unterschiedliche Ansätze:
Einer ist `git subtree`.
Wir werden hier beide für folgende Anwendungsfälle erprobe:

* Module als Subtree einbinden
* Änderung aus einem Modul übernehmen
* Änderung in ein Modul übertragen
* Übergeordnetes Repo klonen

### Subtrees

Bei diesem Ansatz werden Commits aus dem aus dem untergeordeten
Repository übertragen und per `merge` integriert, 
ganz ähnlich wie beim normalen `pull`.
Die Besonderheit ist, dass Zur Integraion 
dabei eine sogenanntes `subtree`-Merge erfolgt, 
bei dem die Dateien in eine vorgegebenes Zielverzeichnis (`prefix`) verschoben werden.

 * `subtree add --prefix=<Zielverzeichnis> <Quellrepository>`: Initales einbetten.
 * `subtree pull --prefix=<Zielverzeichnis> <Quellrepository>`: Aktualisieren aus dem Quellrepository.
 * `subtree push--prefix=<Zielverzeichnis> <Quellrepository>`: Übertragen ins Quellrepository.

Tipp: Wer nicht mag,
dass Subtree alle Commit aus dem Quellrepository holt,
kann die Option `--squash` nutzen.

## Setup

Zwei separate Repositorys `frontend` und `backend` sind vorhanden.
Diese sollen in ein übergeordnetes Repo `application` eingebettet werden.

```
application/
|- frontend/
|- backen/
```
  

<h2>Step 0 - START <!-- UEB/Modularisierung mit Subtrees/0 --></h2>


<pre><code>$ <b>cd application</b><br><br><br></code></pre>


<h2>Step 1 - Module als Subtree einbinden <!-- UEB/Modularisierung mit Subtrees/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Binde die Module `frontend.git` und `backend.git`
per `subtree add` ein.
Untersuche dann die entstandene Verzeichnisstruktur.


<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


<h2>Step 2 - Änderung aus einem Modul übernehmen <!-- UEB/Modularisierung mit Subtrees/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Gehe in das Repo `backend` ändere die Datei `service.java`, committe und pushe.
Sie Dir das entstandene Commit an (`show --stat`)
Gehe in das Repo `application` und hole die Änderungen per `subtree pull` ab.
Sieh Dir das übertragene Commit an.

<h2>Step 3 - Änderung in ein Modul übertragen <!-- UEB/Modularisierung mit Subtrees/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Gehe in `application` ändere `frontend/main.ts` und committe.
Übertrage die Änderung per `subtree push` nach `frontend.git`.
Sieh Dir das übertragene Commit in `frontend.git` an.

<h2>Step 4 - Übergeordnetes Repo klonen <!-- UEB/Modularisierung mit Subtrees/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Klone `application` zu `myapplication`.
Untersuche die `HEAD` Verzeichnisstruktur,
und den Commit-graphen.

To the exercise(loesung-modularisierung-subtrees.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

To the overview(../../ueberblick.html){:style="visibility: hidden"}

