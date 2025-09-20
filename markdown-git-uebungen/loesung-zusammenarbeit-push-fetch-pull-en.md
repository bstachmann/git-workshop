---
layout: page
title: <code>zusammenarbeit-push-fetch-pull-en</code>
parent: Solutions

nav_order: 9
---
## Solution to Step 0 - START

## Solution to Step 1 - Fetch changes

Fetch the two new commits from the `origin` repository
without changing the local `main`.


<pre><code>mein-klon $ <b>git fetch</b><br><br>From ../blessed<br>   6014eb9..0b4e6c2  main       -&gt; origin/main<br><br></code></pre>


The output shows that changes on the `main` branch have been fetched.


<pre><code>mein-klon $ <b>git status</b><br><br>On branch main<br>Your branch and 'origin/main' have diverged,<br>and have 1 and 2 different commits each, respectively.<br>  (use &quot;git pull&quot; if you want to integrate the remote branch with yours)<br><br>nothing to commit, working tree clean<br><br></code></pre>


## Solution to Step 2 - Examine changes

Show the status,
and then examine
which commits are present in the `main` of the `origin` repository,
which have not yet been integrated into the local `main`.


<pre><code>mein-klon $ <b>git status</b><br><br>On branch main<br>Your branch and 'origin/main' have diverged,<br>and have 1 and 2 different commits each, respectively.<br>  (use &quot;git pull&quot; if you want to integrate the remote branch with yours)<br><br>nothing to commit, working tree clean<br><br></code></pre>


The status shows that there are two commits in the origin repo
(on the `main` branch)
that we have not yet integrated.


<pre><code>mein-klon $ <b>git log main..origin/main</b><br><br>commit 0b4e6c2d582e300fd5ebc1cbe17e7a3f6641f02c<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Second edit after cloning<br><br>commit 47ce9cff6da38bc51b508a0d9b238d4d3da1da9e<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : First edit after cloning<br><br></code></pre>


The `..` notation shows exactly those commits
that are in `origin/main` but not yet in `main`.
A shorter way to write this would have been `git log ..origin/main`,
since `main` is currently `HEAD`.

## Solution to Step 3 - Integrate changes

Integrate the latest commits from the `origin` repository
into the local `main`.


<pre><code>mein-klon $ <b>git pull</b><br><br>Merge made by the 'ort' strategy.<br> foo | 4 ++--<br> 1 file changed, 2 insertions(+), 2 deletions(-)<br><br></code></pre>



<pre><code>mein-klon $ <b>git log --graph --oneline</b><br><br>*   b94c0a2 Merge branch 'main' of ../blessed<br>|\  <br>| * 0b4e6c2 : Second edit after cloning<br>| * 47ce9cf : First edit after cloning<br>* | 4554415 : My local edit<br>|/  <br>* 6014eb9 Initial edit before cloning<br>* de06cfe Initial edit before cloning<br><br></code></pre>


[To the exercise](aufgabe-zusammenarbeit-push-fetch-pull-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

