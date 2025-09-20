---
layout: page
title: <code>commits-erstellen-en</code>
parent: Solutions

nav_order: 6
---
## Solution zu Step 0 - START

## Solution zu Step 1 - Commit - mit Staging

Bearbeite die Datei `hallo-welt`,
füge sie mit `git add` zum Index hinzu (Staging)
und erstelle ein Commit mit diesen Änderungen.


<pre><code>repo $ <b># Edit file hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git add hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -m 'Erste Änderung'</b><br><br>[main 7472c9a] Erste ?nderung<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>repo $ <b>git show</b><br><br>commit 7472c9afd84a9c8b77a5581c15b41220b0c50209<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Erste ?nderung<br><br>diff --git a/hallo-welt b/hallo-welt<br>index a92550c..dfb4ae8 100644<br>--- a/hallo-welt<br>+++ b/hallo-welt<br>@@ -1 +1 @@<br>-Hallo Welt<br>\ No newline at end of file<br>+Hallo Welt!<br>\ No newline at end of file<br><br></code></pre>


## Solution zu Step 2 - Commit - automatisches Staging

Bearbeite die Datei `hallo-welt` erneut
und erstelle wieder ein Commit,
dieses mal mal aber mit `-a`.


<pre><code>repo $ <b># Edit file hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Zweite Änderung'</b><br><br>[main 478ab67] Zweite ?nderung<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>


Mit der Option `-a` kann man sich den `add`-Aufruf sparen:


<pre><code>repo $ <b>git log --oneline</b><br><br>478ab67 Zweite ?nderung<br>7472c9a Erste ?nderung<br>8d91794 Created file datei1 on branch main by bjoern.<br>331ed0e Created file hello-world on branch main by bjoern.<br>f55db71 Created file hallo-welt on branch main by bjoern.<br><br></code></pre>


## Solution zu Step 3 - Commit - neue Datei

Erstelle `new-world` und bestätige sie mit einem Commit.


<pre><code>repo $ <b># created file 'new-world'</b><br><br><br></code></pre>



<pre><code>repo $ <b># Edit file new-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git add new-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -m 'Neue Datei'</b><br><br>[main 767f657] Neue Datei<br> 1 file changed, 1 insertion(+)<br> create mode 100644 new-world<br><br></code></pre>


## Solution zu Step 4 - Commit - Datei löschen

Lösche `hallo-welt` und bestätige dies per Commit.


<pre><code>repo $ <b>rm hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Datei löschen'</b><br><br>[main b4d22e4] Datei l?schen<br> 1 file changed, 1 deletion(-)<br> delete mode 100644 hallo-welt<br><br></code></pre>


## Solution zu Step 5 - ⭐ Add - Dateien rekursiv hinzufügen

Lege eine Datei `superneu` und eine Verzeichnis `sub`mit einer
Datei `auchneu` an füge beide mit *einem* Add-Aufruf hinzu und erstelle
dann ein Commit.


<pre><code>repo $ <b># created file 'superneu'</b><br><br><br></code></pre>



<pre><code>repo $ <b>mkdir sub</b><br><br><br></code></pre>



<pre><code>sub $ <b>cd sub</b><br><br><br></code></pre>



<pre><code>sub $ <b># created file 'auchneu'</b><br><br><br></code></pre>



<pre><code>sub $ <b>cd ..</b><br><br><br></code></pre>


 `.` steht für: *aktuelles Verzeichnis*."
Alle Dateien darin und auch darunter werden hinzugefügt.


<pre><code>repo $ <b>git add .</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Neue Dateien'</b><br><br>[main 601dbf4] Neue Dateien<br> 2 files changed, 24 insertions(+)<br> create mode 100644 sub/auchneu<br> create mode 100644 superneu<br><br></code></pre>


## Solution zu Step 6 - ⭐ Commit - Datei verschieben/umbenennen

Benenne die Datei `hello-world` in `renamed-world` um
und bestätige dies durch ein Commit.


<pre><code>repo $ <b>mv hello-world renamed-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git add renamed-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Umbenennen'</b><br><br>[main dee82fa] Umbenennen<br> 1 file changed, 0 insertions(+), 0 deletions(-)<br> rename hello-world =&gt; renamed-world (100%)<br><br></code></pre>


Anmerkung: Wenn wir `git mv`  statt `mv` genutzt hätten, dann wäre das separate `git add` nicht nötig gewesen.


<pre><code>repo $ <b>git log --follow --oneline -- renamed-world</b><br><br>dee82fa Umbenennen<br>331ed0e Created file hello-world on branch main by bjoern.<br><br></code></pre>


## Solution zu Step 7 - ⭐ Rename detection

Benenne die Datei `datei1` in `datei2` mit `git mv` um. 
Sorge dafür, dass die *Rename Detection* dies nicht erkennt.


<pre><code>repo $ <b>git mv datei1 datei2</b><br><br><br></code></pre>



<pre><code>repo $ <b># Edit file datei2</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Böse umbenennen'</b><br><br>[main e768993] B?se umbenennen<br> 2 files changed, 1 insertion(+), 12 deletions(-)<br> delete mode 100644 datei1<br> create mode 100644 datei2<br><br></code></pre>



<pre><code>repo $ <b>git log --follow --oneline -- datei2</b><br><br>e768993 B?se umbenennen<br><br></code></pre>


[To the exercise](aufgabe-commits-erstellen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

