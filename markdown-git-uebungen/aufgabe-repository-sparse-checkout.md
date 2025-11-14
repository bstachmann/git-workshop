---
layout: page
title: <code>repository-sparse-checkout</code>
parent: Aufgaben

nav_order: 999
---
# Übung - Sparse Checkout


## Tipps

 * `git clone --sparse`: Klont ein Repository, ohne den Workspace zu füllen.
 * `git sparse-checkout init --cone`: Konfiguriert den cone-Modus für bessere Performance.
 * `git sparse-checkout add fileDirOrPattern`: Dateien bzw. Verzeichnisse hinzufügen,
    die beim nächsten Checkout geladen werden sollen.
    Beim nächsten Checkout wird alles geholt.
 * `git sparse-checkout list`: Aktuelle Sparse-Checkout-Konfiguration ansehen.
 * `git sparse-checkout disable`: Sparse-Checkout wieder abschalten.

## Setup

Ein Git-Repository namens `repo` wurde bereits erstellt.
Es enthält Dateien auf dem Top-Level und in zwei Unterverzeichnissen.

### Verzeichnisse

 * `./` Haupverzeichnis für diese Übung 
   - `repo/` Bereits vorhandenes Repository.
  

<h2>Schritt 0 - START <!-- UEB/Sparse Checkout/0 --></h2>

<h2>Schritt 1 - Sparse-Klon durchführen <!-- UEB/Sparse Checkout/1 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-sparse-checkout`.

Erstelle einen Sparse-Klon von `repo` mit dem Namen `myrepo`,
überprüfe, dass nur Top-Level-Dateien in den Workspace geholt wurden.

<h2>Schritt 2 - Verzeichnis hinzufügen <!-- UEB/Sparse Checkout/2 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-sparse-checkout`.

Füge das Verzeichnis `component-a` hinzu .
Überprüfe die neue Konfiguration.
Validiere, dass `component-a` jetzt da ist.

<h2>Schritt 3 - Sparse Checkout deaktivieren <!-- UEB/Sparse Checkout/3 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-sparse-checkout`.

| Deaktiviere Sparse-Checkout und führe erneut ein Checkout durch.
| Validiere, dass jetzt alle Dateien da sind.

<h2>Schritt 4 - Klonen und auschecken <!-- UEB/Sparse Checkout/4 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/repository-sparse-checkout`.

Klone `myrepo`, schränke auf `component-a` ein
und mache ein Checkout. Nutze die `--cone`-Option.

[Zur Lösung](loesung-repository-sparse-checkout.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

