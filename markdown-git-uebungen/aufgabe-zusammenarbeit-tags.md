---
layout: page
title: <code>zusammenarbeit-tags</code>
parent: Aufgaben

nav_order: 10
---
# Übung - Tags


## Tipps

* Tags erstellen
  - `git tag `mein-erstes-tag`
  - optional darf eine Revision angegeben werden (Default: `HEAD`)
* Einfache Tags sind nur Namen für Commits
* Für Releases nutzt man *annotated Tags*, diesen tragen eine Beschreibung und Metadaten. 
  Folgende Optionen sind hilfreich:
  - `-a` sorgt für die Erstellung eines *annotated Tags*.
  - `-m 'Und hier kommt Text'` für die Beschreibung                    
* Tags werden beim *Push* nicht automatisch Übertragen.
   - Man gibt entweder einzelne Tags an, z.B. `git push origin v1.0 v1.1`
   - `git push --tags` überträgt Tags
* Empfehlung: Tags, die man mit Anderen teilt (push),
  sollte man nicht mehr ändern.
  Git warnt, bevor man geänderte Tags überträgt.
  Notfalls kann man die Übertragung mit `-f` forcieren.
            
## Setup
                  


<pre><code>$ <b>cd mein-klon</b><br><br><br></code></pre>


<!--UEB-Tags--><h2>Schritt 1 - Tags erstellen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

Erstelle ein einfaches Tag `simple1` auf `HEAD` und
ein annotated Tag `annotated1` auf `HEAD~1`.
Sieh zuerst das Log und dann beide Tags einzeln an (`git show an`).

<!--UEB-Tags--><h2>Schritt 2 - Tags holen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

Einfach per pull.

<!--UEB-Tags--><h2>Schritt 3 - Tags pushen</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

Beim einfachen `git push` werden keine Tags übertragen.
Übertrage zunächste gezielt das Tag `simple1` mit einem Push
und danach alle weiteren Tags mit einem weiteren Push

<!--UEB-Tags--><h2>Schritt 4 - Manipulieren</h2>

Starte im Verzeichnis `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

Überschreibe das Tag `v0.1`, so dass es auf den`HEAD` zeigt.
Pushe das Tag.
Gehe in das Verzeichnis `../anderer-klon` und hole das Tag mit pull.
Schaue ins Log, um zu überprüfen, dass das Tag aktualisiert wurde.


<pre><code>mein-klon $ <b>cd ..</b><br><br><br></code></pre>


[Zur Lösung](loesung-zusammenarbeit-tags.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

