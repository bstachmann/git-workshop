---
layout: page
title: <code>zusammenarbeit-integration-von-aenderungen-en</code>
parent: Exercises

nav_order: 12
---
# Exercise - Integration of changes


When multiple developers work independently on the same project,
their changes must be integrated from time to time.
This is called *merging*.

Integration can be done in Git with the commands `pull`, `merge`
and `rebase`.

This often leads to *merge conflicts*.

In this exercise, we show integration via `pull`,
because this is very typical for working with Git.

However, the merging and handling of conflicts works
very similarly with `merge` and `rebase`.

## Info

* `git pull` integrates the local branch with its "upstream" counterpart,
   here: `main` and `origin/main`

## Tips

* `git config --global merge.conflictStyle diff3` improves the display of conflicts.
* `git pull` fetches and integrates changes equivalent to `git fetch` + `git merge`)
* `git log --graph` shows the commit graph
* `git diff main origin/main` shows the changes of the others
* `git log main..origin/main` shows the commits of the others
* `HEAD^1` and `HEAD^2` denote the first and second predecessor,
  of the current `HEAD` commit.
* `git diff HEAD^1...HEAD^2` shows the "foreign" changes
* `git log HEAD^1..HEAD^2` shows the "foreign" commits
* After a merge conflict:
  1. Edit conflict files
  2. then don't forget `git add`
  3. Complete the merge with `git commit`
  
  
## Initial situation

Your colleague Anja has started working on a project.
Now you join and take over tasks.
But Anja has also continued to work in parallel.
Integrate the new changes from Anja.


<h2>Step 0 - START <!-- UEB/Integration of changes/0 --></h2>


<pre><code>$ <b>cd fast-forward</b><br><br><br></code></pre>


<h2>Step 1 - Fast-forward on pull <!-- UEB/Integration of changes/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

In the simplest case, we have done nothing ourselves,
and just want to take over Anja's changes.

Perform a pull.

Show the status and the commit graph.


<pre><code>fast-forward $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd no-ff</b><br><br><br></code></pre>


<h2>Step 2 - Force merge on pull <!-- UEB/Integration of changes/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Again, we have done nothing,
and just want to take over Anja's changes.

Perform a pull with `--no-ff`.

Show the status and the commit graph.


<pre><code>no-ff $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd changes-in-different-files</b><br><br><br></code></pre>


<h2>Step 3 - Integration with changes in different files <!-- UEB/Integration of changes/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

1. Edit the file `README.md`.
   - Create a commit for it.
   - Check with `git show` if the commit is OK.
2. Try a push
   - This will fail because your colleague Bea
     has edited and pushed the file `average.kts`
     in the meantime.
3. Integrate with pull
4. Examine the result, e.g.
   - the commit graph
   - the changes Anja made
   - the commits Anja made


<pre><code>changes-in-different-files $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd changes-in-same-files</b><br><br><br></code></pre>


<h2>Step 4 - Integration with changes in the same file <!-- UEB/Integration of changes/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

In this case, we are editing the same file
that Anja also edited.
A conflict will occur,
which we have to resolve.

1. We have already prepared and committed a change that leads to a conflict.
   Examine it with `git show`.
2. Perform a pull.
3. Show the status and resolve the conflict.


<pre><code>changes-in-same-files $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-integration-von-aenderungen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

