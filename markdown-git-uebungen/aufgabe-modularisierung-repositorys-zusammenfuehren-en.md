---
layout: page
title: <code>modularisierung-repositorys-zusammenfuehren-en</code>
parent: Exercises

nav_order: 18
---
# Exercise - Kleine Projekte zusammenfuehren

Zwei bisher unabhängige Repositorys sollen,
unter Erhaltung der Historie zu einem 
großen Repository zusammengeführt werden.

## Tipps

 * Mit `fetch` (und `pull`) kann man auch Historie aus fremden Repositorys ohne gemeinsame Histories
 mit dem aktuellen Repository holen (Stichwort *unrelated histories*).
 * `merge` (und `pull`) verweigern normalerweise das Integrieren von *unrelated histories*
   - Mit `--allow-unrelated-histories` kann man dies jedoch erzwingen.
 * `git mv` verschiebt Dateien und Verzeichnisse, z. B. `git mv datei1 date1 zielverzeichnis`.
 *  `subtree add --prefix=<Zielverzeichnis> <Quellrepository> <Quellbranch oder Version>`: Einbetten eines anderen Repositorys in ein Unterverzeichnis.
    - Fall man nicht die ganze Historie übernehmen möchte, kann man `--squash` angeben.
    - **Achtung:** `subtree add ` führt einen Merge auf `HEAD` durch und  
      kann daher nicht in einem leeren Repository ohne Commits ausgeführt werden.

## Setup

Zwei Repositorys
 
 * `backend.git`
 * `ui.git` 

sind bereits vorhanden.


<h2>Step 0 - START <!-- UEB/Kleine Projekte zusammenfuehren/0 --></h2>

<h2>Step 1 - Zusammenführen `git subtree` <!-- UEB/Kleine Projekte zusammenfuehren/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.


1. Erstelle ein Repo `application` mit einem Commit.
2. Füge `backend.git` in einem Unterverzeichnis `backend` hinzu.
3. Füge `ui.git` in einem Unterverzeichnis `ui` hinzu.
4. Untersuche Verzeichnissstruktur und Commit-Graphen

<h2>Step 2 - Zusammenführen mit `fetch`, `mv` und `merge` <!-- UEB/Kleine Projekte zusammenfuehren/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

UI und Backend sollen in einem neuen Klon `gesamt` zusammengeführt werden.
Folge den Anweisungen im Kapitel *"Kleine Projekte zusammenführen"*.
Untersuche dann Verzeichnissstruktur und Commit-Graphen

[To the exercise](loesung-modularisierung-repositorys-zusammenfuehren-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

