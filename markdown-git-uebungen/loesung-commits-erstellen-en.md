---
layout: page
title: <code>commits-erstellen-en</code>
parent: Solutions

nav_order: 6
---
## Solution to Step 0 - START

## Solution to Step 1 - Commit - with Staging

Edit the file `hallo-welt`,
add it to the index with `git add` (staging)
and create a commit with these changes.


<pre><code>repo $ <b># Edit file hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git add hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -m 'Erste Änderung'</b><br><br>[main 7472c9a] Erste ?nderung<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>repo $ <b>git show</b><br><br>commit 7472c9afd84a9c8b77a5581c15b41220b0c50209<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Erste ?nderung<br><br>diff --git a/hallo-welt b/hallo-welt<br>index a92550c..dfb4ae8 100644<br>--- a/hallo-welt<br>+++ b/hallo-welt<br>@@ -1 +1 @@<br>-Hallo Welt<br>\ No newline at end of file<br>+Hallo Welt!<br>\ No newline at end of file<br><br></code></pre>


## Solution to Step 2 - Commit - automatic staging

Edit the file `hallo-welt` again
and create another commit,
but this time with `-a`.


<pre><code>repo $ <b># Edit file hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Zweite Änderung'</b><br><br>[main 478ab67] Zweite ?nderung<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>


With the `-a` option, you can save the `add` call:


<pre><code>repo $ <b>git log --oneline</b><br><br>478ab67 Zweite ?nderung<br>7472c9a Erste ?nderung<br>8d91794 Created file datei1 on branch main by bjoern.<br>331ed0e Created file hello-world on branch main by bjoern.<br>f55db71 Created file hallo-welt on branch main by bjoern.<br><br></code></pre>


## Solution to Step 3 - Commit - new file

Create `new-world` and confirm it with a commit.


<pre><code>repo $ <b># created file 'new-world'</b><br><br><br></code></pre>



<pre><code>repo $ <b># Edit file new-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git add new-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -m 'Neue Datei'</b><br><br>[main 767f657] Neue Datei<br> 1 file changed, 1 insertion(+)<br> create mode 100644 new-world<br><br></code></pre>


## Solution to Step 4 - Commit - delete file

Delete `hallo-welt` and confirm this with a commit.


<pre><code>repo $ <b>rm hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Datei löschen'</b><br><br>[main b4d22e4] Datei l?schen<br> 1 file changed, 1 deletion(-)<br> delete mode 100644 hallo-welt<br><br></code></pre>


## Solution to Step 5 - ⭐ Add - recursively add files

Create a file `superneu` and a directory `sub` with a
file `auchneu`, add both with *one* add call and then create
a commit.


<pre><code>repo $ <b># created file 'superneu'</b><br><br><br></code></pre>



<pre><code>repo $ <b>mkdir sub</b><br><br><br></code></pre>



<pre><code>sub $ <b>cd sub</b><br><br><br></code></pre>



<pre><code>sub $ <b># created file 'auchneu'</b><br><br><br></code></pre>



<pre><code>sub $ <b>cd ..</b><br><br><br></code></pre>


 `.` stands for: *current directory*."
All files in it and below it will be added.


<pre><code>repo $ <b>git add .</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Neue Dateien'</b><br><br>[main 601dbf4] Neue Dateien<br> 2 files changed, 24 insertions(+)<br> create mode 100644 sub/auchneu<br> create mode 100644 superneu<br><br></code></pre>


## Solution to Step 6 - ⭐ Commit - move/rename file

Rename the file `hello-world` to `renamed-world`
and confirm this with a commit.


<pre><code>repo $ <b>mv hello-world renamed-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git add renamed-world</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Umbenennen'</b><br><br>[main dee82fa] Umbenennen<br> 1 file changed, 0 insertions(+), 0 deletions(-)<br> rename hello-world =&gt; renamed-world (100%)<br><br></code></pre>


Note: If we had used `git mv` instead of `mv`, the separate `git add` would not have been necessary.


<pre><code>repo $ <b>git log --follow --oneline -- renamed-world</b><br><br>dee82fa Umbenennen<br>331ed0e Created file hello-world on branch main by bjoern.<br><br></code></pre>


## Solution to Step 7 - ⭐ Rename detection

Rename the file `datei1` to `datei2` with `git mv`.
Make sure that the *Rename Detection* does not recognize this.


<pre><code>repo $ <b>git mv datei1 datei2</b><br><br><br></code></pre>



<pre><code>repo $ <b># Edit file datei2</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Böse umbenennen'</b><br><br>[main e768993] B?se umbenennen<br> 2 files changed, 1 insertion(+), 12 deletions(-)<br> delete mode 100644 datei1<br> create mode 100644 datei2<br><br></code></pre>



<pre><code>repo $ <b>git log --follow --oneline -- datei2</b><br><br>e768993 B?se umbenennen<br><br></code></pre>


[To the exercise](aufgabe-commits-erstellen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

