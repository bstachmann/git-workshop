---
layout: page
title: <code>intro-hallo-welt-en</code>
parent: Exercises

nav_order: 1
---
# Exercise - Hello Git!

This is about getting a feel for how the Git command line works.
Execute the given commands and see what happens.
You will learn what the commands do in detail during the course.

## Brief info on the first Git commands

* `git init` Creates a new Git repository.
* `git add <file(s)>` Add file changes for the next commit.
* `git commit -m <description>` Creates a commit.
* `git log` shows commits.


<h2>Step 0 - START <!-- UEB/Hello Git!/0 --></h2>

<h2>Step 1 - The first repo <!-- UEB/Hello Git!/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Create your first repository with the following commands:

    $ git init myrepo
    $ cd myrepo
    $ echo 'welt' >hallo    # creates a file
    $ git add hallo
    $ git commit -m 'Hello World!'
    $ git log

<h2>Step 2 - ⭐ And another commit <!-- UEB/Hello Git!/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Edit the file 'hallo' and create a new commit.
With the `-am` option, you don't need to call `git add hallo` again.
Then look at the log.

    $ git commit -am 'Here we go again!'
    $ git log

<h2>Step 3 - ⭐ Where is the repository <!-- UEB/Hello Git!/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Examine the directory.
Where is the Git repository located? What does it contain?

    $ ll -a
    $ ll .git/

[To the exercise](loesung-intro-hallo-welt-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

