---
layout: page
title: <code>zusammenarbeit-push-rejected-en</code>
parent: Solutions

nav_order: 11
---
## Solution to Step 0 - START

## Solution to Step 1 - Create local commit(s)

Edit the file `frontend.java` and create (at least) one commit with the changes.
Then check with `git status` if the workspace is clean.


<pre><code>my-apollo $ <b># Edit file frontend.java at line 1 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>my-apollo $ <b>git commit -am &quot;`frontend.java`: Edit file frontend.java at line 1 on branch main by bjoern. &quot;</b><br><br>[main b09dd4a] : Edit file frontend.java at line 1 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: frontend.java: command not found<br><br></code></pre>


And now just check if the `working tree is clean`.


<pre><code>my-apollo $ <b>git status</b><br><br>On branch main<br>Your branch is ahead of 'origin/main' by 1 commit.<br>  (use &quot;git push&quot; to publish your local commits)<br><br>nothing to commit, working tree clean<br><br></code></pre>


## Solution to Step 2 - Try to push

Now try to push your changes.


<pre><code>my-apollo $ <b>git push</b><br><br>To ../blessed-apollo.git<br> ! [rejected]        main -&gt; main (fetch first)<br>error: failed to push some refs to '../blessed-apollo.git'<br>hint: Updates were rejected because the remote contains work that you do not<br>hint: have locally. This is usually caused by another repository pushing to<br>hint: the same ref. If you want to integrate the remote changes, use<br>hint: 'git pull' before pushing again.<br>hint: See the 'Note about fast-forwards' in 'git push --help' for details.<br><br></code></pre>


As you can see, the push was rejected.
Apparently Anja was faster
and pushed her changes to `blessed-apollo.git` first.

## Solution to Step 3 - (optional) Analyze problem

First fetch the changes without integrating (`fetch`),
and let *Anja's* changes be shown to you.
 
 * Which commits did Anja make (`log`)?
 * What are the differences between your and Anja's version (symmetrical `diff`)?
 * What changes did Anja make (asymmetrical `diff`)?

`fetch` fetches the data without changing the workspace or your local branches.


<pre><code>my-apollo $ <b>git fetch</b><br><br>From ../blessed-apollo<br>   e9477ea..3076d39  main       -&gt; origin/main<br><br></code></pre>


The output shows that new commits have been fetched for `origin/main`

The `..` notation shows which commits have been added:


<pre><code>my-apollo $ <b>git log --oneline main..origin/main</b><br><br>3076d39 : Edit file backend.java at line 5 on branch main by anja .<br>eccdd50 : Edit file backend.java at line 1 on branch main by anja .<br><br></code></pre>


The normal (symmetrical) diff shows all differences.
Both what you did and what Anja did:"


<pre><code>my-apollo $ <b>git diff --stat HEAD origin/main</b><br><br> backend.java  | 6 ++++--<br> frontend.java | 2 +-<br> 2 files changed, 5 insertions(+), 3 deletions(-)<br><br></code></pre>


The asymmetrical diff `...` only shows those changes
that Anja made
(relative to the last common ancestor):"


<pre><code>my-apollo $ <b>git diff --stat HEAD...origin/main</b><br><br> backend.java | 6 ++++--<br> 1 file changed, 4 insertions(+), 2 deletions(-)<br><br></code></pre>


## Solution to Step 4 - Integrate foreign changes

Integrate the changes with pull and then look at the commit graph.


<pre><code>my-apollo $ <b>git pull</b><br><br>Merge made by the 'ort' strategy.<br> backend.java | 6 ++++--<br> 1 file changed, 4 insertions(+), 2 deletions(-)<br><br></code></pre>


Since *Anja* edited a different file (`backend.java`) than you (`frontend.java`),
her changes could be integrated without any problems.
You can see that a new commit has been created,
which merges the branches.


<pre><code>my-apollo $ <b>git log --graph --oneline</b><br><br>*   afa9054 Merge branch 'main' of ../blessed-apollo<br>|\  <br>| * 3076d39 : Edit file backend.java at line 5 on branch main by anja .<br>| * eccdd50 : Edit file backend.java at line 1 on branch main by anja .<br>* | b09dd4a : Edit file frontend.java at line 1 on branch main by bjoern.<br>|/  <br>* e9477ea Created file frontend.java on branch main by anja .<br>* f2169d3 Created file backend.java on branch main by anja .<br><br></code></pre>


#### Attention: `pull` can cause merge conflicts ...

... if both sides have edited the same places.
Resolving merge conflicts is the topic of a subsequent chapter.

## Solution to Step 5 - Push again

                    


<pre><code>my-apollo $ <b>git push</b><br><br>To ../blessed-apollo.git<br>   3076d39..afa9054  main -&gt; main<br><br></code></pre>


And lo and behold: Now it works.

#### Attention: If someone was faster again ...

... and has pushed to blessed-apollo.git,
there can be another *Push Reject*,
and we try again a `pull`, then a `push`,
as long as it works.

[To the exercise](aufgabe-zusammenarbeit-push-rejected-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

