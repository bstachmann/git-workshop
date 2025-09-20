---
layout: page
title: <code>commits-staging-en</code>
parent: Solutions

nav_order: 7
---
## Solution to Step 0 - START

## Solution to Step 1 - Staging

In the file `demo`, replace
`Fit` with `Git`.
Then add it to the stage area.
Then replace `doof` with `toll`.
Show the status and diffs
for the workspace and stage.

Replace `Fit` with `Git`.


<pre><code>repo $ <b># Edit file demo</b><br><br><br></code></pre>



<pre><code>repo $ <b>git add demo</b><br><br><br></code></pre>


Replace `doof` with `toll`.


<pre><code>repo $ <b># Edit file demo</b><br><br><br></code></pre>



<pre><code>repo $ <b>git status</b><br><br>On branch main<br>Changes to be committed:<br>  (use &quot;git restore --staged &lt;file&gt;...&quot; to unstage)<br>	modified:   demo<br><br>Changes not staged for commit:<br>  (use &quot;git add &lt;file&gt;...&quot; to update what will be committed)<br>  (use &quot;git restore &lt;file&gt;...&quot; to discard changes in working directory)<br>	modified:   demo<br><br><br></code></pre>


The file `demo` is listed in both `Changes to be committed:` and `Changes not staged for commit`.


<pre><code>repo $ <b>git diff</b><br><br>diff --git a/demo b/demo<br>index 94cc8b3..70971ae 100644<br>--- a/demo<br>+++ b/demo<br>@@ -1,3 +1,3 @@<br> Git<br> ist<br>-doof.<br>+toll.<br><br></code></pre>


You can see that the stage area has a different diff than the workspace.


<pre><code>repo $ <b>git diff --staged</b><br><br>diff --git a/demo b/demo<br>index af77d0b..94cc8b3 100644<br>--- a/demo<br>+++ b/demo<br>@@ -1,3 +1,3 @@<br>-Fit<br>+Git<br> ist<br> doof.<br><br></code></pre>


## Solution to Step 2 - Restore - Staging zurücknehmen

The last change should not be included in the next commit yet,
so undo it.


<pre><code>repo $ <b>git restore --staged demo</b><br><br><br></code></pre>



<pre><code>repo $ <b>git status</b><br><br>On branch main<br>Changes not staged for commit:<br>  (use &quot;git add &lt;file&gt;...&quot; to update what will be committed)<br>  (use &quot;git restore &lt;file&gt;...&quot; to discard changes in working directory)<br>	modified:   demo<br><br>no changes added to commit (use &quot;git add&quot; and/or &quot;git commit -a&quot;)<br><br></code></pre>



<pre><code>repo $ <b>git diff</b><br><br>diff --git a/demo b/demo<br>index af77d0b..70971ae 100644<br>--- a/demo<br>+++ b/demo<br>@@ -1,3 +1,3 @@<br>-Fit<br>+Git<br> ist<br>-doof.<br>+toll.<br><br></code></pre>


After undoing, the stage area is empty again.


<pre><code>repo $ <b>git diff --staged</b><br><br><br></code></pre>


## Solution to Step 3 - Restore - Änderung ganz zurücknehmen

The changes to `demo` should be completely undone.
Show the status and diffs afterwards.


<pre><code>repo $ <b>git status</b><br><br>On branch main<br>Changes not staged for commit:<br>  (use &quot;git add &lt;file&gt;...&quot; to update what will be committed)<br>  (use &quot;git restore &lt;file&gt;...&quot; to discard changes in working directory)<br>	modified:   demo<br><br>no changes added to commit (use &quot;git add&quot; and/or &quot;git commit -a&quot;)<br><br></code></pre>



<pre><code>repo $ <b>git restore demo</b><br><br><br></code></pre>



<pre><code>repo $ <b>git status</b><br><br>On branch main<br>nothing to commit, working tree clean<br><br></code></pre>



<pre><code>repo $ <b>git diff</b><br><br><br></code></pre>



<pre><code>repo $ <b>git diff --staged</b><br><br><br></code></pre>


Now the changes are completely gone.

## Solution to Step 4 - ⭐ Restore - Älteren Inhalt einer Datei zurückholen

The file `beispiel` was edited three times.
Restore the middle state and create a commit.


<pre><code>repo $ <b>git log --oneline beispiel</b><br><br>2e48c2f sp?ter<br>4222f43 dazwischen<br>dfe79fa dazwischen<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~9 beispiel</b><br><br><br></code></pre>



<pre><code>repo $ <b>git diff</b><br><br>diff --git a/beispiel b/beispiel<br>index c571ad6..ab1b57f 100644<br>--- a/beispiel<br>+++ b/beispiel<br>@@ -1 +1 @@<br>-Und so endete es.<br>\ No newline at end of file<br>+Dann kam das mit dem Mittelteil.<br>\ No newline at end of file<br><br></code></pre>



<pre><code>repo $ <b>git commit -am &quot;Mittlerer Stand wiederhergestellt.&quot;</b><br><br>[main 27abb5e] Mittlerer Stand wiederhergestellt.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>


## Solution to Step 5 - ⭐ Restore - Zurückholen älterer Verzeichnisversionen

A game was played in the `ufer` folder.
Recreate the game states
by applying `restore` to the `ufer` directory.

Tip: `ll ufer/*` shows the directories of the game.

Tip: When using `restore`, untracked files are not removed.
You can remove them with the `stash` command.


<pre><code>repo $ <b>git log --oneline -- ufer/</b><br><br>40f54a9 Zug 7<br>a9882a6 Zug 6<br>954d812 Zug 5<br>77f4917 Zug 4<br>e1ee973 Zug 3<br>3fe29e6 Zug 2<br>6d31336 Zug 1<br>cf716f5 Starte spiel<br><br></code></pre>


Move 1


<pre><code>repo $ <b>git stash -u</b><br><br>No local changes to save<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~7 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>ufer/ost:<br>total 8.0K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br>ufer/west:<br>total 8.0K<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br><br></code></pre>


Move 2


<pre><code>repo $ <b>git stash -u</b><br><br>Saved working directory and index state WIP on main: 27abb5e Mittlerer Stand wiederhergestellt.<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~6 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>ufer/ost:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br>ufer/west:<br>total 12K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br><br></code></pre>


Move 3


<pre><code>repo $ <b>git stash -u</b><br><br>Saved working directory and index state WIP on main: 27abb5e Mittlerer Stand wiederhergestellt.<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~5 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>ufer/ost:<br>total 12K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br>ufer/west:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br><br></code></pre>


Move 4


<pre><code>repo $ <b>git stash -u</b><br><br>Saved working directory and index state WIP on main: 27abb5e Mittlerer Stand wiederhergestellt.<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~4 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>ufer/ost:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br><br>ufer/west:<br>total 12K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br></code></pre>


Move 5


<pre><code>repo $ <b>git stash -u</b><br><br>Saved working directory and index state WIP on main: 27abb5e Mittlerer Stand wiederhergestellt.<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~3 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>ufer/ost:<br>total 12K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br><br>ufer/west:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br></code></pre>


Move 6


<pre><code>repo $ <b>git stash -u</b><br><br>Saved working directory and index state WIP on main: 27abb5e Mittlerer Stand wiederhergestellt.<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~2 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>ufer/ost:<br>total 8.0K<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br><br>ufer/west:<br>total 8.0K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br></code></pre>


Move 7


<pre><code>repo $ <b>git stash -u</b><br><br>Saved working directory and index state WIP on main: 27abb5e Mittlerer Stand wiederhergestellt.<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~1 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>total 16K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br></code></pre>


Move 8


<pre><code>repo $ <b>git stash -u</b><br><br>No local changes to save<br><br></code></pre>



<pre><code>repo $ <b>git restore -s HEAD~0 ufer</b><br><br><br></code></pre>



<pre><code>repo $ <b>ll ufer/*</b><br><br>total 16K<br>-rw-r--r-- 1 vscode vscode 181  BAUER<br>-rw-r--r-- 1 vscode vscode 181  KOHL<br>-rw-r--r-- 1 vscode vscode 181  WOLF<br>-rw-r--r-- 1 vscode vscode 181  ZIEGE<br><br></code></pre>


[To the exercise](aufgabe-commits-staging-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

