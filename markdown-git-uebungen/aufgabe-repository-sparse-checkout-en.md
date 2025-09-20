---
layout: page
title: <code>repository-sparse-checkout-en</code>
parent: Exercises

nav_order: 5
---
# Exercise - Sparse Checkout


## Tips

 * `git clone --sparse`: Clones a repository without populating the workspace.
 * `git sparse-checkout init --cone`: Configures cone mode for better performance.
 * `git sparse-checkout add fileDirOrPattern`: Add files or directories
    to be loaded on the next checkout.
    Everything will be fetched on the next checkout.
 * `git sparse-checkout list`: View the current sparse-checkout configuration.
 * `git sparse-checkout disable`: Disable sparse-checkout again.

## Setup

A Git repository named `repo` has already been created.
It contains files at the top level and in two subdirectories.

### Directories

 * `./` Main directory for this exercise
   - `repo/` Existing repository.
  

<h2>Step 0 - START <!-- UEB/Sparse Checkout/0 --></h2>

<h2>Step 1 - Perform sparse clone <!-- UEB/Sparse Checkout/1 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Create a sparse clone of `repo` named `myrepo`,
verify that only top-level files have been fetched into the workspace.

<h2>Step 2 - Add directory <!-- UEB/Sparse Checkout/2 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Add the directory `component-a`.
Check the new configuration.
Validate that `component-a` is now present.

<h2>Step 3 - Disable sparse checkout <!-- UEB/Sparse Checkout/3 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

| Disable sparse-checkout and perform a checkout again.
| Validate that all files are now present.

<h2>Step 4 - Clone and checkout <!-- UEB/Sparse Checkout/4 --></h2>

Start in directory `git-uebungen/aufgaben/<unknown>`.

Clone `myrepo`, restrict to `component-a`
and do a checkout. Use the `--cone` option.

[To the solution](loesung-repository-sparse-checkout-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

