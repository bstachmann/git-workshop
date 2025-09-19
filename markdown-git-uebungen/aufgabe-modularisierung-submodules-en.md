---
layout: page
title: <code>modularisierung-submodules-en</code>
parent: Aufgaben

nav_order: 16
---
# Exercise - Modularisierung mit Submodules


Es geht darum, wie man in Git ein übergreifendes
Repository erstellt, dass Inhalte aus mehreren
anderen Repository einbettet.

Git bietet dazu zwei unterschiedliche Ansätze:
Eine davon ist `git submodule`.
Wir werden hier beide für folgende Anwendungsfälle erprobe:

* Module als Submodule einbinden
* Änderung aus einem Modul übernehmen
* Änderung in ein Modul übertragen
* Übergeordnetes Repo klonen

### Submodules

Bei einem Submodule werden Git-Repositorys ineinander geschachtelt.
Das übergeordnete Repo merkt sich dann für jedes untergeordnete Repo (*submodule*)


 1. von wo geklont werden soll (URL) und
 2. welche Revison benötigt wird.

Da die Submodules in ihren Verzeichnissen eigenständige Git-Repositorys sind,
kann man dort mit den üblichen Befehlen wie `switch`, `pull` oder auch `commit` arbeiten.
Wenn man die Änderungen im übergeordneten Repo übernehmen möchen,
tut dies durch ein *top-level*-commit.

 * `git submodule add  <Quellrepository> <Zielverzeichnis>`:> Initales einbetten. *Danach* Commit erforderlich.
 * `git submodule update --init`:> Holt beziehungsweise aktualisiert. Nach dem Klonen erforderlich. 



## Setup

Zwei separate Repositorys `frontend` und `backend` sind vorhanden.
Diese sollen in ein übergeordnetes Repo `application` eingebettet werden.

```
application/
|- frontend/
|- backen/
```

  

<h2>Step 0 - START <!-- UEB/Modularisierung mit Submodules/0 --></h2>


<pre><code>$ <b>cd application</b><br><br><br></code></pre>


<h2>Step 1 - Module als Submodule einbinden <!-- UEB/Modularisierung mit Submodules/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Binde die Module `frontend.git` und `backend.git`
per `submodule add` ein.
Untersuche dann die entstandene Verzeichnisstruktur.


<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


<h2>Step 2 - Änderung aus einem Modul übernehmen <!-- UEB/Modularisierung mit Submodules/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Gehe in das Repo `backend` ändere die Datei `service.java`, committe und pushe.
Sie Dir das entstandene Commit an (`show --stat`)
Gehe in das Repo `application/backend` und hole die Änderungen per `pull` ab.
Sieh Dir das übertragene Commit an.

<h2>Step 3 - Änderung in ein Modul übertragen <!-- UEB/Modularisierung mit Submodules/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Gehe in `subtrees/frontend` ändere `main.ts` und committe.
Übertrage die Änderung per `push` nach `frontend.git`.
Sieh Dir das übertragene Commit in `frontend.git` an.

<h2>Step 4 - Übergeordnetes Repo klonen <!-- UEB/Modularisierung mit Submodules/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Klone `application` zu `myapplication`.
Untersuche die Verzeichnisstruktur.
Vergiß nicht, ein `submodule update` auszuführen.

To the exercise(loesung-modularisierung-submodules.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

To the overview(../../ueberblick.html){:style="visibility: hidden"}

