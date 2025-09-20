---
layout: page
title: <code>commits-staging-en</code>
parent: Exercises

nav_order: 7
---
# Exercise - Staging

This is about the *stage area* (also called the index).
Every change (edited, new, or deleted files)
must be registered as a "snapshot" in the stage area
(e.g., with `git add`),
before it can be included in a commit.

## Tips

* `git add <file/directory>`
   transfers the current state of a file to the stage area.
* If you change a file after `add`, it has
   a different state in the workspace than in the stage.
* `git status`, `git diff`, and `git diff --staged` show this.
* `git restore --staged <file>` undoes a staging.
* `git restore <file>` restores a file in the workspace.
   **Attention**: The local changes will be overwritten!
* With `-s <revision>`, any other states of files and directories
  can be fetched.
* `git stash -u` removes all changes (and untracked files)
  from the workspace (and saves them in the stash).
        
# Setup

In the `repo` directory, a Git project is waiting
to be edited.


<h2>Step 0 - START <!-- UEB/Staging/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Staging <!-- UEB/Staging/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

In the file `demo`, replace
`Fit` with `Git`.
Then add it to the stage area.
Then replace `doof` with `toll`.
Show the status and diffs
for the workspace and stage.

<h2>Step 2 - Restore - Staging zurücknehmen <!-- UEB/Staging/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

The last change should not be included in the next commit yet,
so undo it.

<h2>Step 3 - Restore - Änderung ganz zurücknehmen <!-- UEB/Staging/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

The changes to `demo` should be completely undone.
Show the status and diffs afterwards.

<h2>Step 4 - ⭐ Restore - Älteren Inhalt einer Datei zurückholen <!-- UEB/Staging/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

The file `beispiel` was edited three times.
Restore the middle state and create a commit.

<h2>Step 5 - ⭐ Restore - Zurückholen älterer Verzeichnisversionen <!-- UEB/Staging/5 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

A game was played in the `ufer` folder.
Recreate the game states
by applying `restore` to the `ufer` directory.

Tip: `ll ufer/*` shows the directories of the game.

Tip: When using `restore`, untracked files are not removed.
You can remove them with the `stash` command.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-commits-staging-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

