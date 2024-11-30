---
layout: page
title: <code>intro-hallo-welt</code>
parent: Lösungen

nav_order: 1
---
## Lösung zu Schritt 1 - Das erste Repo

Erstellen sie ihr erstes Repository mit den folgenden Befehlen:

    $ git init myrepo
    $ cd myrepo
    $ echo 'welt' >hallo    # erzeugt eine Datei
    $ git add hallo
    $ git commit -m 'Hallo Welt!'
    $ git log


<pre><code>$ <b>git init -b main myrepo </b><br><br>Initialized empty Git repository in /workspaces/git-workshop/build/git-uebungen/loesungen/intro-hallo-welt/myrepo/.git/<br><br></code></pre>



<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>echo 'welt' &gt;hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -m 'Hallo Welt!'</b><br><br>[main (root-commit) 48dd4eb] Hallo Welt!<br> 1 file changed, 1 insertion(+)<br> create mode 100644 hallo<br><br></code></pre>


Glückwunsch: Sieh sehen Ihr erstes Commit in Ihrem ersten Git-Repository!


<pre><code>myrepo $ <b>git log</b><br><br>commit 48dd4eb91e6605e068edb66c2653303502812e3b<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Hallo Welt!<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Lösung zu Schritt 2 - ⭐ Und noch ein Commit

Bearbeiten Sie die Datei 'hallo' und erstellen ein neues commit.
Mit der Option `-am` brauchen Sie 'git add hallo` nicht erneut aufrufen.
Schauen Sie dann das log an.

    $ git commit -am 'Es geht weiter!'
    $ git log


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b># Edit file hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am 'Es geht weiter!'</b><br><br>[main c3a1c04] Es geht weiter!<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>myrepo $ <b>git log</b><br><br>commit c3a1c04f58ca34e8e7ba0ed339dd7735d0c03ae6<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Es geht weiter!<br><br>commit 48dd4eb91e6605e068edb66c2653303502812e3b<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Hallo Welt!<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Lösung zu Schritt 3 - ⭐ Wo liegt das Repository

Untersuchen Sie das Verzeichnis.
Wo liegt wohl das Git-Repository? Was enthält es?

    $ ll -a
    $ ll .git/


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>ll -a</b><br><br>total 16K<br>drwxrwxrwx+ 3 vscode vscode 4.0K  .<br>drwxrwxrwx+ 3 vscode vscode 4.0K  ..<br>drwxrwxrwx+ 8 vscode vscode 4.0K  .git<br>-rw-rw-rw-  1 vscode vscode   10  hallo<br><br></code></pre>



<pre><code>myrepo $ <b>ll -a .git/</b><br><br>total 52K<br>drwxrwxrwx+  8 vscode vscode 4.0K  .<br>drwxrwxrwx+  3 vscode vscode 4.0K  ..<br>-rw-rw-rw-   1 vscode vscode   16  COMMIT_EDITMSG<br>-rw-rw-rw-   1 vscode vscode   21  HEAD<br>drwxrwxrwx+  2 vscode vscode 4.0K  branches<br>-rw-rw-rw-   1 vscode vscode   92  config<br>-rw-rw-rw-   1 vscode vscode   73  description<br>drwxrwxrwx+  2 vscode vscode 4.0K  hooks<br>-rw-rw-rw-   1 vscode vscode  137  index<br>drwxrwxrwx+  2 vscode vscode 4.0K  info<br>drwxrwxrwx+  3 vscode vscode 4.0K  logs<br>drwxrwxrwx+ 10 vscode vscode 4.0K  objects<br>drwxrwxrwx+  4 vscode vscode 4.0K  refs<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Aufgabe](aufgabe-intro-hallo-welt.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

