---
layout: page
title: <code>modularisierung-subtrees</code>
parent: Aufgaben

nav_order: 17
---
# Übung - Modularisierung mit Subtrees


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
  

<!--UEB-Modularisierung mit Subtrees--><h2>Schritt 0 - START</h2>


<pre><code>$ <b>cd application</b><br><br><br></code></pre>


<!--UEB-Modularisierung mit Subtrees--><h2>Schritt 1 - Module als Subtree einbinden</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-subtrees/application`.

Binde die Module `frontend.git` und `backend.git`
per `subtree add` ein.
Untersuche dann die entstandene Verzeichnisstruktur.


<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


<!--UEB-Modularisierung mit Subtrees--><h2>Schritt 2 - Änderung aus einem Modul übernehmen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-subtrees`.

Gehe in das Repo `backend` ändere die Datei `service.java`, committe und pushe.
Sie Dir das entstandene Commit an (`show --stat`)
Gehe in das Repo `application` und hole die Änderungen per `subtree pull` ab.
Sieh Dir das übertragene Commit an.

<!--UEB-Modularisierung mit Subtrees--><h2>Schritt 3 - Änderung in ein Modul übertragen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-subtrees`.

Gehe in `application` ändere `frontend/main.ts` und committe.
Übertrage die Änderung per `subtree push` nach `frontend.git`.
Sieh Dir das übertragene Commit in `frontend.git` an.

<!--UEB-Modularisierung mit Subtrees--><h2>Schritt 4 - Übergeordnetes Repo klonen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-subtrees`.

Klone `application` zu `myapplication`.
Untersuche die `HEAD` Verzeichnisstruktur,
und den Commit-graphen.

[Zur Lösung](loesung-modularisierung-subtrees.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

