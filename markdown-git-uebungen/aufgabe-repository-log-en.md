---
layout: page
title: <code>repository-log-en</code>
parent: Exercises

nav_order: 2
---
# Exercise - Repository - Log

The log represents the history of the project
as a sequence of commits.
Each commit represents a state of all files in the project.
Here you will practice examining and reading the log.


## Tips

* `git log` shows all commits that are in the current branch.
  - `--oneline` makes the output more compact.
  - `--stat` shows how many files were changed in which file.
* `git show <some-commit>` shows details about a commit
* With `~` you can address predecessors of a commit,
  e.g. `HEAD~2` is the predecessor of the predecessor of `HEAD`.
* `git ls-tree -r <commit>` lists all files that are versioned in the specified
  commit.
* With `blame` you can find out in which commit lines were last edited.
  - `-M` detects moves within a file.
  - `-w` recognizes lines again, even if whitespace has been changed.
  - `--show-number` shows previous line numbers.
  - `-C` detects copies/moves from files in the same commit in which the line was edited,
    `-C -C -C` even from any file.

# Setup

In the `repo` directory, a Git project is waiting
to be examined.


<h2>Step 0 - START <!-- UEB/Repository - Log/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Directory structure <!-- UEB/Repository - Log/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Examine the project directory.
What files are there in the workspace? What directories?
Where is the repository?

<h2>Step 2 - View commits <!-- UEB/Repository - Log/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Look at the commits.
Pay attention to the displayed branches and tags.

<h2>Step 3 - Examine head commit <!-- UEB/Repository - Log/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Show details about the current version
that is checked out in the workspace.

<h2>Step 4 - Examine past commits <!-- UEB/Repository - Log/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Show details for Release 1.0,
and then for the predecessor version of Release 1.0

<h2>Step 5 - ⭐ Examine contents of past versions <!-- UEB/Repository - Log/5 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Show which files and directories
existed in the previous commit.

Output the content of the file `bar` as it was in the previous commit.

<h2>Step 6 - ⭐ View commits: file statistics <!-- UEB/Repository - Log/6 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Look at the commits.
Have the statistics displayed,
i.e. how many lines were changed in which file.

<h2>Step 7 - ⭐ Determine origin of lines <!-- UEB/Repository - Log/7 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

The goal is to determine the following for the file `nachher`:

* For each line, show in which commit it was last edited.
* Lines were moved within the file. Which ones?
* Lines were also moved and copied from other files. Which ones?


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-repository-log-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

