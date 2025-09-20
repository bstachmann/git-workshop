---
layout: page
title: <code>repository-klonen-en</code>
parent: Solutions

nav_order: 4
---
## Solution to Step 0 - START

## Solution to Step 1 - Perform clone

Create a clone of `myfirstrepo` named `myfirstclone`.


<pre><code>$ <b>git clone myfirstrepo myfirstclone</b><br><br>Cloning into 'myfirstclone'...<br>done.<br><br></code></pre>


## Solution to Step 2 - Examine clone

Look at the commits and
show the origin of the clone `myfirstclone`.
`origin` usually stands for the repository
from which it was cloned.
Then show the status.


<pre><code>$ <b>cd myfirstclone</b><br><br><br></code></pre>



<pre><code>myfirstclone $ <b>git log --oneline</b><br><br>097f971 Created file bar on branch main by bjoern.<br>9799da6 Created file foo on branch main by bjoern.<br><br></code></pre>



<pre><code>myfirstclone $ <b>git remote -v</b><br><br>origin	/workspaces/git-workshop/build/git-uebungen-en/loesungen/repository-klonen/myfirstrepo (fetch)<br>origin	/workspaces/git-workshop/build/git-uebungen-en/loesungen/repository-klonen/myfirstrepo (push)<br><br></code></pre>



<pre><code>myfirstclone $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 3 - Work in the clone

Create a commit and then show the status.


<pre><code>$ <b>cd myfirstclone</b><br><br><br></code></pre>



<pre><code>myfirstclone $ <b># Edit file foo at line 3 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>myfirstclone $ <b>git commit -am &quot;`foo`: Edit file foo at line 3 on branch main by bjoern. &quot;</b><br><br>[main b654c9e] : Edit file foo at line 3 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: foo: command not found<br><br></code></pre>



<pre><code>myfirstclone $ <b>git status</b><br><br>On branch main<br>Your branch is ahead of 'origin/main' by 1 commit.<br>  (use &quot;git push&quot; to publish your local commits)<br><br>nothing to commit, working tree clean<br><br></code></pre>



<pre><code>myfirstclone $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-repository-klonen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

