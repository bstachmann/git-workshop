---
layout: page
title: <code>zusammenarbeit-integration-von-aenderungen</code>
parent: Aufgaben

---
# Übung - Integration von Änderungen


Wenn mehrere Entwickler unabhängig am selben Projekt arbeiten,
müssen deren Änderungen von Zeit zu Zeit integriert werden.
Dies nennt man *Merging*.

Die Integration kann in Git mit den Befehlen `pull`, `merge`
und `rebase` durchgeführt werden.

Dabei kommt es immer mal wieder zu *Merge-Konflikten*.

In dieser Übung zeigen wir die Integration per `pull`,
weil dies sehr typisch für das Arbeiten mit Git ist.

Die Zusammenführung und der Umgang mit Konflikten funktioniert
aber bei `merge` und `rebase` ganz ähnlich..

## Infos

* `git pull` integriert den lokalen Branch mit seinem "upstream" Gegenstück,
   hier: `master` und `origin/master`

## Tipps

* `git pull` Holt und integriert Änderungen Äquivalent zu `git fetch` + `git merge`)
* `git log --graph` zeigt den Commit-Graphen
* `HEAD^1` und `HEAD^2` bezeichnen den ersten bzw. zweiten Vorgänger,
  des aktuellen `HEAD`-Commits.
* `git diff HEAD^1...HEAD^2` zeigt die "fremden" Änderungen 
* `git log HEAD^1..HEAD^2` zeigt die "fremden" Commits 
* Nach einem Merge-Konflikt:
  1. Konfliktdateien bearbeiten
  2. dann `git add` nicht vergessen
  3. Den Merge mit `git commit` abschließen
  
  
## Ausgangssituation

Ihre Kollegin Anja hat die Arbeit an einem Projekt begonnen.
Nun kommen Sie hinzu und übernehmen Aufgaben.
Anja hat aber parallel ebenfalls weiter gearbeitet.
Integrieren Sie die neuen Änderungen von Anja.



<pre><code>$ <b>cd anjas-repo</b><br><br><br></code></pre>



<pre><code>anjas-repo $ <b># Edit average.kts replacing { it.toInt() } with { it.toDouble() }</b><br><br><br></code></pre>



<pre><code>anjas-repo $ <b>git commit -am &quot;Verwende double Werte statt int &quot;</b><br><br>[master 8742dc0] Verwende double Werte statt int<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>anjas-repo $ <b>git push</b><br><br>To ../origin-for-merge-samples.git<br>   f0b8778..8742dc0  master -&gt; master<br><br></code></pre>



<pre><code>anjas-repo $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd fast-forward</b><br><br><br></code></pre>


## Schritt 1 - Fast-Forward beim Pull

Starte im Verzeichnis `aufgaben/fast-forward`.

Im einfachste Fall haben wir selber gar nichts gemacht,
und wollen nur die Änderungen von Anja übernehmen.

Führe ein Pull durch.

Lasse Dir Status und den Commit-Graphen zeigen.


<pre><code>fast-forward $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd no-ff</b><br><br><br></code></pre>


## Schritt 2 - Merge erzwingen beim Pull

Starte im Verzeichnis `aufgaben/no-ff`.

Auch dieses haben wir nichtnichts gemacht,
und wollen nur die Änderungen von Anja übernehmen.

Führe ein Pull mit `--no-ff` durch.

Lasse Dir Status und den Commit-Graphen zeigen.


<pre><code>no-ff $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd changes-in-different-files</b><br><br><br></code></pre>


## Schritt 3 - Integration bei Änderungen in verschiedenen Dateien

Starte im Verzeichnis `aufgaben/changes-in-different-files`.

1. Bearbeite die Datei `README.md`.
   - Erstelle ein Commit dazu.
   - Prüfe mit `git show`, ob das Commit OK ist.
2. Versuche ein Push
   - Dies wird scheitern, denn Deine Kollegin Bea 
     hat die in der Zwischenzeit die Datei `average.kts`
     bearbeitet und gepushed.
3. Integriere mit Pull
4. Untersuche das Ergebnis, z. B.
   - den Commit-Graphen an
   - die Änderungen, die Anja gemacht hat 
   - die Commits, die Anja gemacht hat


<pre><code>changes-in-different-files $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd changes-in-same-files</b><br><br><br></code></pre>


## Schritt 4 - Integration bei Änderungen in derselben Datei

Starte im Verzeichnis `aufgaben/changes-in-same-files`.

In diesem Fall bearbeiten wir dieselbe Datei,
die auch Anja bearbeitet hat.
Es wird zu einem Konflikt kommen, 
den wir aulösen müssen.

1. Wir haben schon eine Änderung, die zu einem Konflikt führt,
   vorbereitet und committed. Untersuche diese mit `git show`
2. Führe ein Pull durch.
3. Lasse Dir den Status zeigen und löse den Konflikt.


<pre><code>changes-in-same-files $ <b>cd ..</b><br><br><br></code></pre>


[Zur Lösung](loesung-zusammenarbeit-integration-von-aenderungen.md){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}
