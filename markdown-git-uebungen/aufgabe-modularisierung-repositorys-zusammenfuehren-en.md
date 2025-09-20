---
layout: page
title: <code>modularisierung-repositorys-zusammenfuehren-en</code>
parent: Exercises

nav_order: 18
---
# Exercise - Merging small projects

Two previously independent repositories are to be
merged into one large repository while preserving
their history.

## Tips

 * With `fetch` (and `pull`), you can also fetch history from foreign repositories without a common history
 with the current repository (keyword *unrelated histories*).
 * `merge` (and `pull`) normally refuse to integrate *unrelated histories*
   - However, you can force this with `--allow-unrelated-histories`.
 * `git mv` moves files and directories, e.g., `git mv file1 file1 targetdirectory`.
 *  `subtree add --prefix=<target-directory> <source-repository> <source-branch-or-version>`: Embed another repository in a subdirectory.
    - If you don't want to take over the entire history, you can specify `--squash`.
    - **Attention:** `subtree add` performs a merge on `HEAD` and
      therefore cannot be executed in an empty repository without commits.

## Setup

Two repositories
 
 * `backend.git`
 * `ui.git` 

are already present.


<h2>Step 0 - START <!-- UEB/Merging small projects/0 --></h2>

<h2>Step 1 - Merge `git subtree` <!-- UEB/Merging small projects/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.


1. Create a repo `application` with one commit.
2. Add `backend.git` in a subdirectory `backend`.
3. Add `ui.git` in a subdirectory `ui`.
4. Examine the directory structure and commit graph

<h2>Step 2 - Merge with `fetch`, `mv` and `merge` <!-- UEB/Merging small projects/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

UI and backend should be merged in a new clone `gesamt`.
Follow the instructions in the chapter *"Merging small projects"*.
Then examine the directory structure and commit graph.

[To the solution](loesung-modularisierung-repositorys-zusammenfuehren-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

