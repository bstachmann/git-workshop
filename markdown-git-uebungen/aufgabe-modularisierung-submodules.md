---
layout: page
title: <code>modularisierung-submodules</code>
parent: Aufgaben

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

Zwei Repositorys `mod-a` und `mod-b` sind vorhanden.
Diese sollen in das übergeordnete repo `submodules` eingebettet werden.

  


<pre><code>$ <b>cd submodules</b><br><br><br></code></pre>


<!--UEB-Modularisierung mit Submodules--><h2>Schritt 1 - Module als Submodule einbinden</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules/submodules`.

Binde die Module `mod-a.git` und `mod-b.git`
per `submodule add` ein.
Untersuche dann die entstandene Verzeichnisstruktur.


<pre><code>submodules $ <b>cd ..</b><br><br><br></code></pre>


<!--UEB-Modularisierung mit Submodules--><h2>Schritt 2 - Subtree: Änderung aus einem Modul übernehmen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules`.

Gehe in das Repo `mod-b` ändere die Datei `berta`, committe und pushe.
Sie Dir das entstandene Commit an (`show --stat`)
Gehe in das Repo `submodules/mod-b` und hole die Änderungen per `pull` ab.
Sieh Dir das übertragene Commit an.

<!--UEB-Modularisierung mit Submodules--><h2>Schritt 3 - Änderung in ein Modul übertragen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules`.

Gehe in `subtrees/mod-a` ändere `anton` und committe.
Übertrage die Änderung per `push` nach `mod-a.git`.
Sieh Dir das übertragene Commit in `mod-a.git` an.

<!--UEB-Modularisierung mit Submodules--><h2>Schritt 4 - Übergeordnetes Repo klonen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/modularisierung-submodules`.

Klone `submodules` zu `mysubmodules`.
Untersuche die Verzeichnisstruktur.
Vergiß nicht, ein `submodule update` auszuführen.

[Zur Lösung](loesung-modularisierung-submodules.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

