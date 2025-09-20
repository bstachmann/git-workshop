---
layout: page
title: <code>repository-untersuchen-en</code>
parent: Solutions

nav_order: 3
---
## Solution to Step 0 - START

## Solution to Step 1 - Branches zeigen

Zeige an, welche Branches es gibt.
Zeige jetzt den Commit-Graphen über alle Branches an.


<pre><code>repo $ <b>git branch -vv</b><br><br>  feature-a       9df530e Edited file bar on branch feature-a by bjoern.<br>* main            bcd8ce5 Created file und-tschuess on branch main by bjoern.<br>  some-old-branch 03e1bea : Edit file bar at line 1 on branch main by bjoern.<br><br></code></pre>


Im Commit-Graphen sieht man, wo die Branches und Tag stehen:


<pre><code>repo $ <b>git log --decorate --oneline --graph --all</b><br><br>* 9df530e (feature-a) Edited file bar on branch feature-a by bjoern.<br>| * bcd8ce5 (HEAD -&gt; main) Created file und-tschuess on branch main by bjoern.<br>| * ec6319f (tag: release1.1) : Edit file bar at line 5 on branch main by bjoern.<br>| * 03e1bea (some-old-branch) : Edit file bar at line 1 on branch main by bjoern.<br>|/  <br>* 95fb57f Edited file hallo-welt on branch main by bjoern.<br>* 6121b42 (tag: release1.0) Eine Zeile verschieben<br>* 85f5f20 Noch ein paar neue Zeilen<br>* 0144fe4 Verschiebe eine  Zeile<br>* 1178ed1 Created file restaurant on branch main by bjoern.<br>* eaa5d5c Kopiere eine Zeile aus 'bar'<br>* f9dc882 Erg?nze eine Zeile<br>* 3592a48 Benenne die Datei im<br>* 76dd3c1 Erg?nze zwei zeilen<br>* 5498956 Beginne mit leerer Datei<br>* e51b518 Created file bar on branch main by bjoern.<br>* 7b2a390 Created file hallo-welt on branch main by bjoern.<br><br></code></pre>


## Solution to Step 2 - Branch wechseln

Wechsle auf den Branch `feature-a`.
Sieh Dir den Inhalt der Datei `bar` im Verzeichnis `foo` an.
Wechsle zurück auf `main`.


<pre><code>repo $ <b>git switch feature-a</b><br><br>Switched to branch 'feature-a'<br><br></code></pre>



<pre><code>repo $ <b>cat foo/bar</b><br><br>Jawoll, das ist hier feature-a!<br><br></code></pre>



<pre><code>repo $ <b>git switch main</b><br><br>Switched to branch 'main'<br><br></code></pre>


## Solution to Step 3 - Tags zeigen

Zeige alle Tags an.


<pre><code>repo $ <b>git tag</b><br><br>release1.0<br>release1.1<br><br></code></pre>


## Solution to Step 4 - ⭐ Inhalte vergangener Versionen untersuchen

Lasse dir anzeigen, welche Dateien es im Workspace gibt.
Lasse Dir anzeigen welche Dateien es in vorigen Commit gab.            
Wechsle zum vorigen Commit, und untersuche, wie der Workspace dannn aussieht.

Wechsle dann wieder auf `main` zurück.


Diese Dateien gibt es auf `main`:


<pre><code>repo $ <b>ll </b><br><br>total 16K<br>drwxr-xr-x 2 vscode vscode 4.0K  foo<br>-rw-r--r-- 1 vscode vscode   12  hallo-welt<br>-rw-r--r-- 1 vscode vscode  375  nachher<br>-rw-r--r-- 1 vscode vscode    0  restaurant<br>-rw-r--r-- 1 vscode vscode  181  und-tschuess<br><br></code></pre>



Diese Dateien gab es in `HEAD~1`:


<pre><code>repo $ <b>git ls-tree HEAD~1</b><br><br>040000 tree c9e9241c3edae05c6f1c858a2170c45052dac10e	foo<br>100644 blob c57eff55ebc0c54973903af5f72bac72762cf4f4	hallo-welt<br>100644 blob 32b08868b00465cca451251689dda4c9d83b2d85	nachher<br>100644 blob e69de29bb2d1d6434b8b29ae775ad8c2e48c5391	restaurant<br><br></code></pre>



Und jetzt holen wir genau diese Version in den Workspace:


<pre><code>repo $ <b>git switch --detach HEAD~1</b><br><br>HEAD is now at ec6319f : Edit file bar at line 5 on branch main by bjoern.<br><br></code></pre>



<pre><code>repo $ <b>ll </b><br><br>total 12K<br>drwxr-xr-x 2 vscode vscode 4.0K  foo<br>-rw-r--r-- 1 vscode vscode   12  hallo-welt<br>-rw-r--r-- 1 vscode vscode  375  nachher<br>-rw-r--r-- 1 vscode vscode    0  restaurant<br><br></code></pre>



<pre><code>repo $ <b>git switch main</b><br><br>Previous HEAD position was ec6319f : Edit file bar at line 5 on branch main by bjoern.<br>Switched to branch 'main'<br><br></code></pre>


## Solution to Step 5 - ⭐ Hole alten Stand einer einzelnen Datei zurück.

Die Datei `hallo-welt` wurde nach dem `release1.0` bearbeitet.
Dem Kunden gefällt das nicht. Stelle den alten Zustand mit
einem neuen Commit wieder her. 

In `release1.0` sah es os aus:


<pre><code>repo $ <b>git show release1.0:hallo-welt</b><br><br>Hallo Welt!<br><br></code></pre>


Jetzt sieh es so aus:


<pre><code>repo $ <b>git show HEAD:hallo-welt</b><br><br>Hello World!<br><br></code></pre>


Gezieltes zurückholen:


<pre><code>repo $ <b>git restore -s release1.0 hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Zurückgeholt'</b><br><br>[main 5349b26] Zur?ckgeholt<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>


Im Commit-Graphen sieht man, wo die Branches und Tag stehen:

Jetzt sieh es so wieder so aus:


<pre><code>repo $ <b>git show HEAD:hallo-welt</b><br><br>Hallo Welt!<br><br></code></pre>


[To the exercise](aufgabe-repository-untersuchen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

