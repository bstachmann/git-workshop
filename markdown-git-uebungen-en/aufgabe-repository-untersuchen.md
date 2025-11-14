---
layout: page
title: <code>repository-untersuchen</code>
parent: Exercises

nav_order: 999
---
# Exercise - Investigating the repository

This is about finding out what is in a repository.

## Tips

* `git log` shows all commits that are in the current branch.
  - `--oneline` makes the output more compact.
* `git show <some-commit>` shows details about a commit
* With `~` you can address predecessors of a commit,
  e.g. `HEAD~2` is the predecessor of the predecessor of `HEAD`.
* `git branch` and `git tag` list existing branches and tags.
* With `git switch <branch-name>` you can switch to other branches.
* With `git switch --detach <commit>` you can switch to any version.
* With `git restore -s <commit> -- <file-or-path>` you can get *contents* of any version
  of files/paths into the workspace. It does not switch to the specified commit,
  but only fetches file contents into the workspace. The affected files
  are displayed as `modified` and can be committed.
   
# Setup

In the `repo` directory, a Git project is waiting
to be examined.


<h2>Step 0 - START <!-- UEB/Investigating the repository/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Show branches <!-- UEB/Investigating the repository/1 --></h2>

Start in directory `git-uebungen/aufgaben/repository-untersuchen/repo`.

Show which branches exist.
Now show the commit graph across all branches.

<h2>Step 2 - Switch branch <!-- UEB/Investigating the repository/2 --></h2>

Start in directory `git-uebungen/aufgaben/repository-untersuchen/repo`.

Switch to the `feature-a` branch.
Look at the content of the `bar` file in the `foo` directory.
Switch back to `main`.

<h2>Step 3 - Show tags <!-- UEB/Investigating the repository/3 --></h2>

Start in directory `git-uebungen/aufgaben/repository-untersuchen/repo`.

Show all tags.

<h2>Step 4 - ⭐ Investigate contents of past versions <!-- UEB/Investigating the repository/4 --></h2>

Start in directory `git-uebungen/aufgaben/repository-untersuchen/repo`.

Show which files exist in the workspace.
Show which files existed in the previous commit.
Switch to the previous commit and examine what the workspace looks like then.

Then switch back to `main`.

<h2>Step 5 - ⭐ Restore old state of a single file. <!-- UEB/Investigating the repository/5 --></h2>

Start in directory `git-uebungen/aufgaben/repository-untersuchen/repo`.

The file `hallo-welt` was edited after `release1.0`.
The customer does not like it. Restore the old state with
a new commit.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-repository-untersuchen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

