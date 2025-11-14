---
layout: page
title: <code>repository-untersuchen</code>
parent: Solutions

nav_order: 999
---
## Solution to Step 0 - START

## Solution to Step 1 - Show branches

Show which branches exist.
Now show the commit graph across all branches.


<pre><code>repo $ <b>git branch -vv</b><br><br>  feature-a       f0b1e69 Edited file bar on branch feature-a by bjoern.<br>* main            68be303 Created file und-tschuess on branch main by bjoern.<br>  some-old-branch a5fc3f7 : Edit file bar at line 1 on branch main by bjoern.<br><br></code></pre>


In the commit graph you can see where the branches and tags are:


<pre><code>repo $ <b>git log --decorate --oneline --graph --all</b><br><br>* f0b1e69 (feature-a) Edited file bar on branch feature-a by bjoern.<br>| * 68be303 (HEAD -&gt; main) Created file und-tschuess on branch main by bjoern.<br>| * 6a70b5c (tag: release1.1) : Edit file bar at line 5 on branch main by bjoern.<br>| * a5fc3f7 (some-old-branch) : Edit file bar at line 1 on branch main by bjoern.<br>|/  <br>* 272dd25 Edited file hallo-welt on branch main by bjoern.<br>* f7824a5 (tag: release1.0) Eine Zeile verschieben<br>* 0be4bbe Noch ein paar neue Zeilen<br>* 480a5cf Verschiebe eine  Zeile<br>* 5c0c9ae Created file restaurant on branch main by bjoern.<br>* aa145b9 Kopiere eine Zeile aus 'bar'<br>* 9e96dc7 Ergänze eine Zeile<br>* 96ef7f4 Benenne die Datei im<br>* faf8ba9 Ergänze zwei zeilen<br>* 5498956 Beginne mit leerer Datei<br>* e51b518 Created file bar on branch main by bjoern.<br>* 7b2a390 Created file hallo-welt on branch main by bjoern.<br><br></code></pre>


## Solution to Step 2 - Switch branch

Switch to the `feature-a` branch.
Look at the content of the `bar` file in the `foo` directory.
Switch back to `main`.


<pre><code>repo $ <b>git switch feature-a</b><br><br>Switched to branch 'feature-a'<br><br></code></pre>



<pre><code>repo $ <b>cat foo/bar</b><br><br>Jawoll, das ist hier feature-a!<br><br></code></pre>



<pre><code>repo $ <b>git switch main</b><br><br>Switched to branch 'main'<br><br></code></pre>


## Solution to Step 3 - Show tags

Show all tags.


<pre><code>repo $ <b>git tag</b><br><br>release1.0<br>release1.1<br><br></code></pre>


## Solution to Step 4 - ⭐ Investigate contents of past versions

Show which files exist in the workspace.
Show which files existed in the previous commit.
Switch to the previous commit and examine what the workspace looks like then.

Then switch back to `main`.


These files exist on `main`:


<pre><code>repo $ <b>ll </b><br><br>total 16K<br>drwxr-xr-x 2 vscode vscode 4.0K  foo<br>-rw-r--r-- 1 vscode vscode   12  hallo-welt<br>-rw-r--r-- 1 vscode vscode  375  nachher<br>-rw-r--r-- 1 vscode vscode    0  restaurant<br>-rw-r--r-- 1 vscode vscode  181  und-tschuess<br><br></code></pre>



These files existed in `HEAD~1`:


<pre><code>repo $ <b>git ls-tree HEAD~1</b><br><br>040000 tree c9e9241c3edae05c6f1c858a2170c45052dac10e	foo<br>100644 blob c57eff55ebc0c54973903af5f72bac72762cf4f4	hallo-welt<br>100644 blob 32b08868b00465cca451251689dda4c9d83b2d85	nachher<br>100644 blob e69de29bb2d1d6434b8b29ae775ad8c2e48c5391	restaurant<br><br></code></pre>



And now we get exactly this version into the workspace:


<pre><code>repo $ <b>git switch --detach HEAD~1</b><br><br>HEAD is now at 6a70b5c : Edit file bar at line 5 on branch main by bjoern.<br><br></code></pre>



<pre><code>repo $ <b>ll </b><br><br>total 12K<br>drwxr-xr-x 2 vscode vscode 4.0K  foo<br>-rw-r--r-- 1 vscode vscode   12  hallo-welt<br>-rw-r--r-- 1 vscode vscode  375  nachher<br>-rw-r--r-- 1 vscode vscode    0  restaurant<br><br></code></pre>



<pre><code>repo $ <b>git switch main</b><br><br>Previous HEAD position was 6a70b5c : Edit file bar at line 5 on branch main by bjoern.<br>Switched to branch 'main'<br><br></code></pre>


## Solution to Step 5 - ⭐ Restore old state of a single file.

The file `hallo-welt` was edited after `release1.0`.
The customer does not like it. Restore the old state with
a new commit.

In `release1.0` it looked like this:


<pre><code>repo $ <b>git show release1.0:hallo-welt</b><br><br>Hallo Welt!<br><br></code></pre>


Now it looks like this:


<pre><code>repo $ <b>git show HEAD:hallo-welt</b><br><br>Hello World!<br><br></code></pre>


Targeted restore:


<pre><code>repo $ <b>git restore -s release1.0 hallo-welt</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am 'Zurückgeholt'</b><br><br>[main 7566f2c] Zurückgeholt<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>


In the commit graph you can see where the branches and tags are:

Now it looks like this again:


<pre><code>repo $ <b>git show HEAD:hallo-welt</b><br><br>Hallo Welt!<br><br></code></pre>


[To the exercise](aufgabe-repository-untersuchen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

