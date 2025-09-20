---
layout: page
title: <code>modularisierung-submodules-en</code>
parent: Exercises

nav_order: 16
---
# Exercise - Modularization with Submodules


This is about how to create a comprehensive
repository in Git that embeds content from several
other repositories.

Git offers two different approaches for this:
One of them is `git submodule`.
We will try both here for the following use cases:

* Integrating modules as submodules
* Adopting changes from a module
* Transferring changes to a module
* Cloning the parent repo

### Submodules

With a submodule, Git repositories are nested within each other.
The parent repo then remembers for each child repo (*submodule*)


 1. where to clone from (URL) and
 2. which revision is needed.

Since the submodules are independent Git repositories in their directories,
you can work there with the usual commands like `switch`, `pull` or `commit`.
If you want to apply the changes in the parent repo,
you do this with a *top-level* commit.

 * `git submodule add <source-repository> <target-directory>`:> Initial embedding. *Afterwards* a commit is required.
 * `git submodule update --init`:> Fetches or updates. Required after cloning.



## Setup

Two separate repositories `frontend` and `backend` are available.
These are to be embedded in a parent repo `application`.

```
application/
|- frontend/
|- backend/
```

  

<h2>Step 0 - START <!-- UEB/Modularization with Submodules/0 --></h2>


<pre><code>$ <b>cd application</b><br><br><br></code></pre>


<h2>Step 1 - Integrating modules as submodules <!-- UEB/Modularization with Submodules/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Integrate the modules `frontend.git` and `backend.git`
using `submodule add`.
Then examine the resulting directory structure.


<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


<h2>Step 2 - Adopting changes from a module <!-- UEB/Modularization with Submodules/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Go to the `backend` repo, change the `service.java` file, commit and push.
Look at the resulting commit (`show --stat`)
Go to the `application/backend` repo and fetch the changes using `pull`.
Look at the transferred commit.

<h2>Step 3 - Transferring changes to a module <!-- UEB/Modularization with Submodules/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Go to `subtrees/frontend`, change `main.ts` and commit.
Transfer the change to `frontend.git` using `push`.
Look at the transferred commit in `frontend.git`.

<h2>Step 4 - Cloning the parent repo <!-- UEB/Modularization with Submodules/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Clone `application` to `myapplication`.
Examine the directory structure.
Don't forget to run `submodule update`.

[To the solution](loesung-modularisierung-submodules-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

