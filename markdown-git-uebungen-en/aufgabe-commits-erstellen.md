---
layout: page
title: <code>commits-erstellen</code>
parent: Exercises

nav_order: 999
---
# Exercise - Creating Commits


## Tips

* `git add <file/directory>`
   Before a commit, changes must be registered with `add` in the staging area
   (also called the index).
* The directory name `.` (which stands for *current directory*) can also be specified.
  The command is then applied to all files in the current directory and also subdirectories.
* `git commit -m 'My two cents'` Creates a commit with all
   changes registered in the staging area.
* `git commit -a` Registers all changes to files already versioned in Git
  in the staging area, so you can save the separate
  `add` call.
* The options `-a` and `-m` can also be combined: `git commit -am "Comment"`
* `git log --follow -- <file-name>`
   Shows the history of a file, even across renames.

# Setup

In the `repo` directory, a Git project is waiting
to be edited.


<h2>Step 0 - START <!-- UEB/Creating Commits/0 --></h2>


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 1 - Commit - with Staging <!-- UEB/Creating Commits/1 --></h2>

Start in directory `git-uebungen/aufgaben/commits-erstellen/repo`.

Edit the file `hallo-welt`,
add it to the index with `git add` (staging)
and create a commit with these changes.

<h2>Step 2 - Commit - automatic staging <!-- UEB/Creating Commits/2 --></h2>

Start in directory `git-uebungen/aufgaben/commits-erstellen/repo`.

Edit the file `hallo-welt` again
and create another commit,
but this time with `-a`.

<h2>Step 3 - Commit - new file <!-- UEB/Creating Commits/3 --></h2>

Start in directory `git-uebungen/aufgaben/commits-erstellen/repo`.

Create `new-world` and confirm it with a commit.

<h2>Step 4 - Commit - delete file <!-- UEB/Creating Commits/4 --></h2>

Start in directory `git-uebungen/aufgaben/commits-erstellen/repo`.

Delete `hallo-welt` and confirm this with a commit.

<h2>Step 5 - ⭐ Add - recursively add files <!-- UEB/Creating Commits/5 --></h2>

Start in directory `git-uebungen/aufgaben/commits-erstellen/repo`.

Create a file `superneu` and a directory `sub` with a
file `auchneu`, add both with *one* add call and then create
a commit.

<h2>Step 6 - ⭐ Commit - move/rename file <!-- UEB/Creating Commits/6 --></h2>

Start in directory `git-uebungen/aufgaben/commits-erstellen/repo`.

Rename the file `hello-world` to `renamed-world`
and confirm this with a commit.

<h2>Step 7 - ⭐ Rename detection <!-- UEB/Creating Commits/7 --></h2>

Start in directory `git-uebungen/aufgaben/commits-erstellen/repo`.

Rename the file `datei1` to `datei2` with `git mv`.
Make sure that the *Rename Detection* does not recognize this.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-commits-erstellen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

