---
layout: page
title: <code>zusammenarbeit-branching-fortgeschritten</code>
parent: Exercises

nav_order: 999
---
# Exercise - Branching (advanced)



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


<h2>Step 0 - START <!-- UEB/zusammenarbeit-branching-fortgeschritten/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Create branch <!-- UEB/zusammenarbeit-branching-fortgeschritten/1 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Create a branch `feature-a`, edit the file `foo`
and create a commit.
Then switch back to `main` and edit `bar` there.
Show the commit graph.

<h2>Step 2 - Merge branch <!-- UEB/zusammenarbeit-branching-fortgeschritten/2 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Merge `feature-a` into `main` and
show the commit graph.

<h2>Step 3 - ⭐ Analyze merge <!-- UEB/zusammenarbeit-branching-fortgeschritten/3 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Show which commits from `main` were added in the merge.
Show which commits from `feature-a` were added in the merge.
Also show the changes (diffs) for both sides.

<h2>Step 4 - ⭐ Analyze merge <!-- UEB/zusammenarbeit-branching-fortgeschritten/4 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.

Show which commits from `main` were added in the merge.
Show which commits from `feature-a` were added in the merge.
Also show the changes (diffs) for both sides.

<h2>Step 5 - Examine remote branches <!-- UEB/zusammenarbeit-branching-fortgeschritten/5 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-branching-fortgeschritten/repo`.




<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-branching-fortgeschritten.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

