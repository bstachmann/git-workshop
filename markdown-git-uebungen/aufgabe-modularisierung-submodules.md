---
layout: page
title: <code>modularisierung-submodules</code>
parent: Aufgaben

nav_order: 16
---
# Übung - Modularisierung mit Submodules


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

  

<!--UEB-Modularisierung mit Submodules--><h2>Schritt 0 - START</h2>


<pre><code>$ <b>cd application</b><br><br><br></code></pre>


<!--UEB-Modularisierung mit Submodules--><h2>Schritt 1 - Module als Submodule einbinden</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules/application`.

Binde die Module `frontend.git` und `backend.git`
per `submodule add` ein.
Untersuche dann die entstandene Verzeichnisstruktur.


<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


<!--UEB-Modularisierung mit Submodules--><h2>Schritt 2 - Änderung aus einem Modul übernehmen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules`.

Gehe in das Repo `backend` ändere die Datei `service.java`, committe und pushe.
Sie Dir das entstandene Commit an (`show --stat`)
Gehe in das Repo `application/backend` und hole die Änderungen per `pull` ab.
Sieh Dir das übertragene Commit an.

<!--UEB-Modularisierung mit Submodules--><h2>Schritt 3 - Änderung in ein Modul übertragen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules`.

Gehe in `subtrees/frontend` ändere `main.ts` und committe.
Übertrage die Änderung per `push` nach `frontend.git`.
Sieh Dir das übertragene Commit in `frontend.git` an.

<!--UEB-Modularisierung mit Submodules--><h2>Schritt 4 - Übergeordnetes Repo klonen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules`.

Klone `application` zu `myapplication`.
Untersuche die Verzeichnisstruktur.
Vergiß nicht, ein `submodule update` auszuführen.

[Zur Lösung](loesung-modularisierung-submodules.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

