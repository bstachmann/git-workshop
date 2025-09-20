---
layout: page
title: <code>zusammenarbeit-push-fetch-pull-en</code>
parent: Exercises

nav_order: 9
---
# Exercise - Fetch and Pull


## Tips

* `git fetch` fetches changes without integrating
* `git status` shows differences on the current branch
* `git branch -r` shows which remote branches exist.
* `git pull` integrates (first fetch, then merge)
* `git log --graph --oneline` shows the graph with merges

## Setup
                  

<h2>Step 0 - START <!-- UEB/Fetch and Pull/0 --></h2>


<pre><code>$ <b>cd mein-klon</b><br><br><br></code></pre>


<h2>Step 1 - Fetch changes <!-- UEB/Fetch and Pull/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Fetch the two new commits from the `origin` repository
without changing the local `main`.

<h2>Step 2 - Examine changes <!-- UEB/Fetch and Pull/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Show the status,
and then examine
which commits are present in the `main` of the `origin` repository,
which have not yet been integrated into the local `main`.

<h2>Step 3 - Integrate changes <!-- UEB/Fetch and Pull/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Integrate the latest commits from the `origin` repository
into the local `main`.


<pre><code>mein-klon $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-push-fetch-pull-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

