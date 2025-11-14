---
layout: page
title: <code>repository-sparse-checkout</code>
parent: Solutions

nav_order: 999
---
## Solution to Step 0 - START

## Solution to Step 1 - Perform sparse clone

Create a sparse clone of `repo` named `myrepo`,
verify that only top-level files have been fetched into the workspace.


<pre><code>$ <b>git clone --sparse repo myrepo</b><br><br>Cloning into 'myrepo'...<br>done.<br><br></code></pre>



<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>ll </b><br><br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  README.md<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 2 - Add directory

Add the directory `component-a`.
Check the new configuration.
Validate that `component-a` is now present.


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git sparse-checkout add component-a</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git sparse-checkout list</b><br><br>component-a<br><br></code></pre>



<pre><code>myrepo $ <b>git checkout</b><br><br>Your branch is up to date with 'origin/main'.<br><br></code></pre>



<pre><code>myrepo $ <b>ll </b><br><br>total 8.0K<br>drwxr-xr-x 2 vscode vscode 4.0K  component-a<br>-rw-r--r-- 1 vscode vscode  181  README.md<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 3 - Disable sparse checkout

| Disable sparse-checkout and perform a checkout again.
| Validate that all files are now present.


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git sparse-checkout disable</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git checkout</b><br><br>Your branch is up to date with 'origin/main'.<br><br></code></pre>



<pre><code>myrepo $ <b>ll </b><br><br>total 12K<br>drwxr-xr-x 2 vscode vscode 4.0K  component-a<br>drwxr-xr-x 2 vscode vscode 4.0K  component-b<br>-rw-r--r-- 1 vscode vscode  181  README.md<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 4 - Clone and checkout

Clone `myrepo`, restrict to `component-a`
and do a checkout. Use the `--cone` option.


<pre><code>$ <b>git clone --sparse repo myclone</b><br><br>Cloning into 'myclone'...<br>done.<br><br></code></pre>



<pre><code>$ <b>cd myclone</b><br><br><br></code></pre>



<pre><code>myclone $ <b>git sparse-checkout init --cone</b><br><br><br></code></pre>



<pre><code>myclone $ <b>git sparse-checkout add component-a</b><br><br><br></code></pre>



<pre><code>myclone $ <b>git checkout</b><br><br>Your branch is up to date with 'origin/main'.<br><br></code></pre>



<pre><code>myclone $ <b>ll </b><br><br>total 8.0K<br>drwxr-xr-x 2 vscode vscode 4.0K  component-a<br>-rw-r--r-- 1 vscode vscode  181  README.md<br><br></code></pre>



<pre><code>myclone $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-repository-sparse-checkout-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

