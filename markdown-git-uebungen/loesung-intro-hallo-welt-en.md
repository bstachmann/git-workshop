---
layout: page
title: <code>intro-hallo-welt-en</code>
parent: Solutions

nav_order: 1
---
## Solution zu Step 0 - START

## Solution zu Step 1 - The first repo

Create your first repository with the following commands:

    $ git init myrepo
    $ cd myrepo
    $ echo 'welt' >hallo    # creates a file
    $ git add hallo
    $ git commit -m 'Hello World!'
    $ git log


<pre><code>$ <b>git init -b main myrepo </b><br><br>Initialized empty Git repository in /workspaces/git-workshop/build/git-uebungen-en/loesungen/intro-hallo-welt/myrepo/.git/<br><br></code></pre>



<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>echo 'welt' &gt;hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -m 'Hallo Welt!'</b><br><br>[main (root-commit) 48dd4eb] Hallo Welt!<br> 1 file changed, 1 insertion(+)<br> create mode 100644 hallo<br><br></code></pre>


Congratulations: You see your first commit in your first Git repository!


<pre><code>myrepo $ <b>git log</b><br><br>commit 48dd4eb91e6605e068edb66c2653303502812e3b<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Hallo Welt!<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution zu Step 2 - ⭐ And another commit

Edit the file 'hallo' and create a new commit.
With the `-am` option, you don't need to call `git add hallo` again.
Then look at the log.

    $ git commit -am 'Here we go again!'
    $ git log


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b># Edit file hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am 'Es geht weiter!'</b><br><br>[main c3a1c04] Es geht weiter!<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>myrepo $ <b>git log</b><br><br>commit c3a1c04f58ca34e8e7ba0ed339dd7735d0c03ae6<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Es geht weiter!<br><br>commit 48dd4eb91e6605e068edb66c2653303502812e3b<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Hallo Welt!<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution zu Step 3 - ⭐ Where is the repository

Examine the directory.
Where is the Git repository located? What does it contain?

    $ ll -a
    $ ll .git/


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>ll -a</b><br><br>total 16K<br>drwxr-xr-x 3 vscode vscode 4.0K  .<br>drwxr-xr-x 3 vscode vscode 4.0K  ..<br>drwxr-xr-x 7 vscode vscode 4.0K  .git<br>-rw-r--r-- 1 vscode vscode   10  hallo<br><br></code></pre>



<pre><code>myrepo $ <b>ll -a .git/</b><br><br>total 48K<br>drwxr-xr-x  7 vscode vscode 4.0K  .<br>drwxr-xr-x  3 vscode vscode 4.0K  ..<br>-rw-r--r--  1 vscode vscode   16  COMMIT_EDITMSG<br>-rw-r--r--  1 vscode vscode   21  HEAD<br>-rw-r--r--  1 vscode vscode   92  config<br>-rw-r--r--  1 vscode vscode   73  description<br>drwxr-xr-x  2 vscode vscode 4.0K  hooks<br>-rw-r--r--  1 vscode vscode  137  index<br>drwxr-xr-x  2 vscode vscode 4.0K  info<br>drwxr-xr-x  3 vscode vscode 4.0K  logs<br>drwxr-xr-x 10 vscode vscode 4.0K  objects<br>drwxr-xr-x  4 vscode vscode 4.0K  refs<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-intro-hallo-welt-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

