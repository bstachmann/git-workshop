---
layout: page
title: <code>repository-untersuchen</code>
parent: Lösungen

nav_order: 3
---
## Lösung zu Schritt 1 - Branches zeigen

Zeige an, welche Branches es gibt.
Zeige jetzt den Commit-Graphen über alle Branches an.


<pre><code>repo $ <b>git branch -vv</b><br><br>  feature-a       f0b1e69 Edited file bar on branch feature-a by bjoern.<br>* main            68be303 Created file und-tschuess on branch main by bjoern.<br>  some-old-branch a5fc3f7 : Edit file bar at line 1 on branch main by bjoern.<br><br></code></pre>


Im Commit-Graphen sieht man, wo die Branches und Tag stehen:


<pre><code>repo $ <b>git log --decorate --oneline --graph --all</b><br><br>* f0b1e69 (feature-a) Edited file bar on branch feature-a by bjoern.<br>| * 68be303 (HEAD -&gt; main) Created file und-tschuess on branch main by bjoern.<br>| * 6a70b5c (tag: release1.1) : Edit file bar at line 5 on branch main by bjoern.<br>| * a5fc3f7 (some-old-branch) : Edit file bar at line 1 on branch main by bjoern.<br>|/  <br>* 272dd25 Edited file hallo-welt on branch main by bjoern.<br>* f7824a5 (tag: release1.0) Eine Zeile verschieben<br>* 0be4bbe Noch ein paar neue Zeilen<br>* 480a5cf Verschiebe eine  Zeile<br>* 5c0c9ae Created file restaurant on branch main by bjoern.<br>* aa145b9 Kopiere eine Zeile aus 'bar'<br>* 9e96dc7 Ergänze eine Zeile<br>* 96ef7f4 Benenne die Datei im<br>* faf8ba9 Ergänze zwei zeilen<br>* 5498956 Beginne mit leerer Datei<br>* e51b518 Created file bar on branch main by bjoern.<br>* 7b2a390 Created file hallo-welt on branch main by bjoern.<br><br></code></pre>


## Lösung zu Schritt 2 - Branch wechseln

Wechsle auf den Branch `feature-a`.
Sieh Dir den Inhalt der Datei `bar` im Verzeichnis `foo` an.
Wechsle zurück auf `main`.


<pre><code>repo $ <b>git switch feature-a</b><br><br>Switched to branch 'feature-a'<br><br></code></pre>



<pre><code>repo $ <b>cat foo/bar</b><br><br>Jawoll, das ist hier feature-a!<br><br></code></pre>



<pre><code>repo $ <b>git switch main</b><br><br>Switched to branch 'main'<br><br></code></pre>


## Lösung zu Schritt 3 - Tags zeigen

Zeige alle Tags an.


<pre><code>repo $ <b>git tag</b><br><br>release1.0<br>release1.1<br><br></code></pre>


## Lösung zu Schritt 4 - ⭐ Inhalte vergangener Versionen untersuchen

Lasse dir anzeigen, welche Dateien es im Workspace gibt.
Lasse Dir anzeigen welche Dateien es in vorigen Commit gab.            
Wechsle zum vorigen Commit, und untersuche, wie der Workspace dannn aussieht.

Wechsle dann wieder auf `main` zurück.


Diese Dateien gibt es auf `main`:


<pre><code>repo $ <b>ll </b><br><br>total 12K<br>drwxr-xr-x 2 gitpod gitpod  17  foo<br>-rw-r--r-- 1 gitpod gitpod  12  hallo-welt<br>-rw-r--r-- 1 gitpod gitpod 375  nachher<br>-rw-r--r-- 1 gitpod gitpod   0  restaurant<br>-rw-r--r-- 1 gitpod gitpod 181  und-tschuess<br><br></code></pre>



Diese Dateien gab es in `HEAD~1`:


<pre><code>repo $ <b>git ls-tree HEAD~1</b><br><br>040000 tree c9e9241c3edae05c6f1c858a2170c45052dac10e	foo<br>100644 blob c57eff55ebc0c54973903af5f72bac72762cf4f4	hallo-welt<br>100644 blob 32b08868b00465cca451251689dda4c9d83b2d85	nachher<br>100644 blob e69de29bb2d1d6434b8b29ae775ad8c2e48c5391	restaurant<br><br></code></pre>



Und jetzt holen wir genau diese Version in den Workspace:


<pre><code>repo $ <b>git switch --detach HEAD~1</b><br><br>HEAD is now at 6a70b5c : Edit file bar at line 5 on branch main by bjoern.<br><br></code></pre>



<pre><code>repo $ <b>ll </b><br><br>total 8.0K<br>drwxr-xr-x 2 gitpod gitpod  17  foo<br>-rw-r--r-- 1 gitpod gitpod  12  hallo-welt<br>-rw-r--r-- 1 gitpod gitpod 375  nachher<br>-rw-r--r-- 1 gitpod gitpod   0  restaurant<br><br></code></pre>



<pre><code>repo $ <b>git switch main</b><br><br>Previous HEAD position was 6a70b5c : Edit file bar at line 5 on branch main by bjoern.<br>Switched to branch 'main'<br><br></code></pre>


## Lösung zu Schritt 5 - ⭐ Hole alten Stand einer einzelnen Datei zurück.

Die Datei `hallo-welt` wurde nach dem `release1.0` bearbeitet.
Dem Kunden gefällt das nicht. Stelle den alten Zustand mit
einem neuen Commit wieder her. 

In `release1.0` sah es os aus:


<pre><code>repo $ <b>git show release1.0:hallo-welt</b><br><br>Hallo Welt!<br><br></code></pre>


Jetzt sieh es so aus:


<pre><code>repo $ <b>git show HEAD:hallo-welt</b><br><br>Hello World!<br><br></code></pre>


Gezieltes zurückholen:


<pre><code>repo $ <b>git restore -s release1.0 hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Zurückgeholt'</b><br><br>[main 7566f2c] Zurückgeholt<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>


Im Commit-Graphen sieht man, wo die Branches und Tag stehen:

Jetzt sieh es so wieder so aus:


<pre><code>repo $ <b>git show HEAD:hallo-welt</b><br><br>Hallo Welt!<br><br></code></pre>


[Zur Aufgabe](aufgabe-repository-untersuchen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

