---
layout: page
title: <code>modularisierung-subtrees-en</code>
parent: Exercises

nav_order: 17
---
# Exercise - Modularization with Subtrees


This is about how to create a comprehensive
repository in Git that embeds content from several
other repositories.

Git offers two different approaches for this:
One is `git subtree`.
We will try both here for the following use cases:

* Integrating modules as subtrees
* Adopting changes from a module
* Transferring changes to a module
* Cloning the parent repo

### Subtrees

In this approach, commits from the subordinate
repository are transferred and integrated via `merge`,
very similar to a normal `pull`.
The special feature is that for integration,
a so-called `subtree` merge takes place,
in which the files are moved to a specified target directory (`prefix`).

 * `subtree add --prefix=<target-directory> <source-repository>`: Initial embedding.
 * `subtree pull --prefix=<target-directory> <source-repository>`: Update from the source repository.
 * `subtree push--prefix=<target-directory> <source-repository>`: Transfer to the source repository.

Tip: If you don't like
that subtree fetches all commits from the source repository,
you can use the `--squash` option.

## Setup

Two separate repositories `frontend` and `backend` are available.
These are to be embedded in a parent repo `application`.

```
application/
|- frontend/
|- backend/
```
  

<h2>Step 0 - START <!-- UEB/Modularization with Subtrees/0 --></h2>


<pre><code>$ <b>cd application</b><br><br><br></code></pre>


<h2>Step 1 - Integrating modules as subtrees <!-- UEB/Modularization with Subtrees/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Integrate the modules `frontend.git` and `backend.git`
using `subtree add`.
Then examine the resulting directory structure.


<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


<h2>Step 2 - Adopting changes from a module <!-- UEB/Modularization with Subtrees/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Go to the `backend` repo, change the `service.java` file, commit and push.
Look at the resulting commit (`show --stat`)
Go to the `application` repo and fetch the changes using `subtree pull`.
Look at the transferred commit.

<h2>Step 3 - Transferring changes to a module <!-- UEB/Modularization with Subtrees/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Go to `application`, change `frontend/main.ts` and commit.
Transfer the change to `frontend.git` using `subtree push`.
Look at the transferred commit in `frontend.git`.

<h2>Step 4 - Cloning the parent repo <!-- UEB/Modularization with Subtrees/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Clone `application` to `myapplication`.
Examine the `HEAD` directory structure,
and the commit graph.

[To the exercise](loesung-modularisierung-subtrees-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

