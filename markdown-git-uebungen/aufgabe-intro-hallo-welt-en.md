---
layout: page
title: <code>intro-hallo-welt-en</code>
parent: Exercises

nav_order: 1
---
# Exercise - Hallo Git!

Hier geht es darum, ein Gefühl dafür zu bekommen,
wie die Git-Kommandozeile funktioniert.
Führen Sie die vorgegebenen Kommandos aus und schauen Sie,
was passiert.
Was die Kommandos genau tun, erfahren Sie im Verlauf des Seminars.

## Kurze Info zu den ersten Git-Befehlen

* `git init` Erstellt ein neues Git-Repository.
* `git add <datei(en)>` Datei(-änderungen) für das nächsten Commit hinzufügen.
* `git commit -m <beschreibung>` Erstellt ein Commit.
* `git log` zeigt Commits an.


<h2>Step 0 - START <!-- UEB/Hallo Git!/0 --></h2>

<h2>Step 1 - Das erste Repo <!-- UEB/Hallo Git!/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Erstellen sie ihr erstes Repository mit den folgenden Befehlen:

    $ git init myrepo
    $ cd myrepo
    $ echo 'welt' >hallo    # erzeugt eine Datei
    $ git add hallo
    $ git commit -m 'Hallo Welt!'
    $ git log

<h2>Step 2 - ⭐ Und noch ein Commit <!-- UEB/Hallo Git!/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Bearbeiten Sie die Datei 'hallo' und erstellen ein neues commit.
Mit der Option `-am` brauchen Sie 'git add hallo` nicht erneut aufrufen.
Schauen Sie dann das log an.

    $ git commit -am 'Es geht weiter!'
    $ git log

<h2>Step 3 - ⭐ Wo liegt das Repository <!-- UEB/Hallo Git!/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Untersuchen Sie das Verzeichnis.
Wo liegt wohl das Git-Repository? Was enthält es?

    $ ll -a
    $ ll .git/

To the exercise(loesung-intro-hallo-welt.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

To the overview(../../ueberblick.html){:style="visibility: hidden"}

