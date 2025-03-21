---
layout: page
title: <code>intro-commandline</code>
parent: Aufgaben

nav_order: 0
---
# Übung - Das `git`-Kommando!

In der ersten Übung geht es darum,
die (Git-) Bash-Kommandozeile und vor allem
das `git`-Kommando kennenzulernen.

## Tipps

* Für Windows-Nutzer:
  - Nutzen sie die **Git-Bash**-Kommandozeile dann können sie Beispiele
    genau wie hier angegeben ausführen.
  - Verwenden sie '/' statt '\', für Verzeichnispfade.
  - Wenn Sie mit der Windows-Kommandozeile `CMD` arbeiten,
    müssen sie ggf. kleinere Änderungen vornehmen,
    damit die Beispiele funktionieren.

* Bash-Kommandos
  - `cd <verzeichnisname>`, wechselt in ein anderes Verzeichnis.
  - `cd ..`, wechselt in das übergeordente Verzeichnis.
    Eine Ebene hoch!
  - `ls` zeigt die Namen der Dateien und Unterverzeichnisse im aktuellen Verzeichnisse.
  - `ll` Wie `ls` nur mit mehr Details.
  - `less`. Inhalt einer Datei anzeigen. Scrollen mit Pfeiltasten. Mit Taste `q` beenden.
  - `pwd` zeigt das aktuelle Arbeitsverzeichnis an. Auf Windows: `pwd -W` (Großbuchstabe)

* Git-Kommandos
  - `git version` zeigt welche Version von Git installiert ist.
  - `git help <kommando>` zeigt Hilfe.
  - `git config <property>` zeigt Wert aus der Konfiguration an. 
  - `git config set --global <property> <new-value>` 
    setzt einen Wert in der Konfiguration.
  - `git config core.editor notepad` konfiguriert Notepad als Editor für Git.
  - Wenn die Ausgabe mehr Zeilen hat, als Terminalfenster hoch ist,
    wird die Ausgabe in einem Viewer (`less`) dargestellt.
    Man kann dann mit Pfeiltasten rauf- und runter scrollen.
    Den `less` modus beendet man mit der Taste `q`.

* Befehl `start <file>` (Ubuntu: `xdg-open`, Mac Os: `open`) 
  öffnet die angegebene Datei mit der verknüpften Standardanwendung.
  `start .` öffnet den Datei-Explorer im aktuellen Verzeichnis.

[Kurze Intro zur Kommandozeile](../installation/kommandozeile)

<h2>Schritt 0 - START <!-- UEB/Das `git`-Kommando!/0 --></h2>

<h2>Schritt 1 - Navigation in Übungsverzeichnisse <!-- UEB/Das `git`-Kommando!/1 --></h2>

Starte im Verzeichnis `git-uebungen`.

(aus dem entpackten Zip-File)

Navigiere in das Unterverzeichnis `aufgaben/intro-commandline/hallo`
und sieh Dir den Inhalt der dort liegenden Datei an.
Nutze die Tab-Completion, um nicht so viel tippen zu müssen.
Navigiere dann wieder zurück ins übergeordnete 
Verzeichnis `intro-commandline`.

<h2>Schritt 2 - Git-Version prüfen <!-- UEB/Das `git`-Kommando!/2 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline`.

Gib aus, welche Version von Git installiert ist.

<h2>Schritt 3 - Hilfe <!-- UEB/Das `git`-Kommando!/3 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline`.

Zeige die Hilfeseite zum `log`-Befehl an.


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Schritt 4 - `less` und lange Ausgaben <!-- UEB/Das `git`-Kommando!/4 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline/repo`.

Wenn Sie `git log` ausführen, sollen 99 Commits angezeigt werden.
Weil diese nicht in ein Terminalfenster passt,
wird der `less`-Viewer geöffnet. Schliessen sie ihn.
Nutzen sie dann `less some-file.txt` um eine Datei im `less`-Modus anzusehen.

<h2>Schritt 5 - Git konfigurieren <!-- UEB/Das `git`-Kommando!/5 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline/repo`.

Prüfe die User-Konfiguration:

    $ git config user.name
    $ git config user.email
    $ git config pull.rebase
    $ git config merge.conflictStyle
    $ git config --global init.defaultBranch 

Konfiguriere Sie Benutzername und -Email, 
sofern noch nicht gesetzt:

    $ git config --global user.name mein-name
    $ git config --global user.email meine-email

Die folgenden Konfigurationen wurden beim Aufzeichnen der 
Musterlösung genutzt.
Es ist empfehlenswert sie für diesen Workshop setzen:

    $ git config --global pull.rebase false 
    $ git config --global merge.conflictStyle diff3
    $ git config --global init.defaultBranch main


<h2>Schritt 6 - ⭐ Historie <!-- UEB/Das `git`-Kommando!/6 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline/repo`.

Blättern sie die 🡅-Taste mehrfach und drücken dann enter,
um einen der vorigen Befehle erneut auszuführen.
Tippen sie `strg+r` und geben sie dann `conflict`ein,
um den Befehl zum Setzen von `merge.conflictStyle` erneut auszuführen.

<h2>Schritt 7 - ⭐ Git-Editor konfigurieren <!-- UEB/Das `git`-Kommando!/7 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline/repo`.

Konfigurieren Sie einen Editor für git.
[Tipps dazu](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config).f
Testen Sie dann mit `git config -e`, ob es geklappt hat.

<h2>Schritt 8 - ⭐ Arbeitsverzeichnis <!-- UEB/Das `git`-Kommando!/8 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline/repo`.

Geben Sie aus, in welchem Arbeitzverzeichnis Sie sich gerade befinden.
Für Windows-User: Testen sie den Befehl auch mit der Option `-W`.

<h2>Schritt 9 - ⭐ Anwendungen öfnen <!-- UEB/Das `git`-Kommando!/9 --></h2>

Starte im Verzeichnis `git-uebungen/aufgaben/intro-commandline/repo`.

Öffnen Sie die Datei `some-file.txt` mit der Standaranwendung.
Öffnen Sie einen Datei-Explorer im aktuellen Arbeitsverzeichnis.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Lösung](loesung-intro-commandline.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

