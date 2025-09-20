---
layout: page
title: <code>zusammenarbeit-branching-en</code>
parent: Exercises

nav_order: 8
---
# Exercise - Branching



## Info

* `git branch` 

## Tips

* `git switch -c <name>` creates a new branch and activates
  it immediately.
* `git branch -vv` shows details about the local branches
* `git switch <name>` switches the active branch
* `git merge <branch>` integrates the changes from `branch` and creates a commit
   on the active branch.
* 

  
## Initial situation


<h2>Step 0 - START <!-- UEB/Branching/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Create branch <!-- UEB/Branching/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Create a branch `feature-a`, edit the file `foo`
and create a commit.
Then switch back to `main` and edit `bar` there.
Show the commit graph.

<h2>Step 2 - Merge branch <!-- UEB/Branching/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Merge `feature-a` into `main` and
show the commit graph.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-branching-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

