---
layout: page
title: <code>zusammenarbeit-branching-en</code>
parent: Solutions

nav_order: 8
---
## Solution to Step 0 - START

## Solution to Step 1 - Create branch

Create a branch `feature-a`, edit the file `foo`
and create a commit.
Then switch back to `main` and edit `bar` there.
Show the commit graph.


<pre><code>repo $ <b>git switch -c feature-a HEAD</b><br><br>Switched to a new branch 'feature-a'<br><br></code></pre>



<pre><code>repo $ <b># Edit file foo at line 7 on branch feature-a by bjoern.</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am &quot;`foo`: Edit file foo at line 7 on branch feature-a by bjoern. &quot;</b><br><br>[feature-a 300f5e9] : Edit file foo at line 7 on branch feature-a by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: foo: command not found<br><br></code></pre>



<pre><code>repo $ <b>git switch main</b><br><br>Your branch is up to date with 'origin/main'.<br>Switched to branch 'main'<br><br></code></pre>



<pre><code>repo $ <b># Edit file bar at line 3 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>repo $ <b>git commit -am &quot;`bar`: Edit file bar at line 3 on branch main by bjoern. &quot;</b><br><br>[main b5cd7e9] : Edit file bar at line 3 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: bar: command not found<br><br></code></pre>



<pre><code>repo $ <b>git log --all --oneline --graph --decorate</b><br><br>* 300f5e9 (feature-a) : Edit file foo at line 7 on branch feature-a by bjoern.<br>| * b5cd7e9 (HEAD -&gt; main) : Edit file bar at line 3 on branch main by bjoern.<br>|/  <br>* 6014eb9 (origin/main) Initial edit before cloning<br>* de06cfe Initial edit before cloning<br><br></code></pre>


## Solution to Step 2 - Merge branch

Merge `feature-a` into `main` and
show the commit graph.


<pre><code>repo $ <b>git merge feature-a</b><br><br>Merge made by the 'ort' strategy.<br> foo | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>repo $ <b>git log --all --oneline --graph --decorate</b><br><br>*   c00b978 (HEAD -&gt; main) Merge branch 'feature-a'<br>|\  <br>| * 300f5e9 (feature-a) : Edit file foo at line 7 on branch feature-a by bjoern.<br>* | b5cd7e9 : Edit file bar at line 3 on branch main by bjoern.<br>|/  <br>* 6014eb9 (origin/main) Initial edit before cloning<br>* de06cfe Initial edit before cloning<br><br></code></pre>


[To the exercise](aufgabe-zusammenarbeit-branching-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

