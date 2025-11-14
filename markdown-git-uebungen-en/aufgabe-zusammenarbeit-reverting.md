---
layout: page
title: <code>zusammenarbeit-reverting</code>
parent: Exercises

nav_order: 999
---
# Exercise - Reverting

Git allows changes
made in an earlier commit
to be undone by a new commit.

## Info

* `git revert <commit>` creates a new commit,
  which undoes the changes of an earlier commit.

* With a merge commit
  you must also specify to which merge parent
  the determination of the changes should refer:<br/>
  `git revert -m 1 <merge-commit>` 

* With commits further back, conflicts can occur
  (because affected files were further edited in later commits).
  These must then be resolved like merge conflicts.

## Example setup

In the example repository, a file was renamed,
the corresponding commit is tagged with `umbenennung`.

In addition, a feature branch was integrated via merge.
The merge commit is tagged with `feature-merge`.

Both changes are to be undone.

<h2>Step 0 - START <!-- UEB/Reverting/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Undo a single commit. <!-- UEB/Reverting/1 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-reverting/repo`.

In the history, the file `README.md` was renamed to `liesmich`.
Undo this change.
Tip: The commit is tagged as `umbenennung`.

<h2>Step 2 - Undo merge commit. <!-- UEB/Reverting/2 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-reverting/repo`.

In the history, a feature branch was integrated via merge.file . Undo this change.
Tip: The merge commit is tagged as `feature-merge`.
Tip: The success can be recognized by the disappearance of the file `from-feature`.

<h2>Step 3 - Feature branch broken!? <!-- UEB/Reverting/3 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-reverting/repo`.

A revert is often used to temporarily roll back a feature,
e.g. due to a production problem.
Later you want to correct the feature branch and then integrate it again.
This is not so easy.

In the example, the `feature` branch has undergone further development.
Try to merge it again.
Examine the error message and the commit graph.
Tip: The failed merge can be aborted with `git merge --abort`.

<h2>Step 4 - Undo merge revert again. <!-- UEB/Reverting/4 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-reverting/repo`.

The trick is to revert the revert commit itself,
then those changes are back
on which the further development of the feature is based.

Tip: The commit is tagged as `feature-merge`.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-reverting.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

