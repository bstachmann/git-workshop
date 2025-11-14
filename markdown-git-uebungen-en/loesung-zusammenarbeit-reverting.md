---
layout: page
title: <code>zusammenarbeit-reverting</code>
parent: Solutions

nav_order: 999
---
## Solution to Step 0 - START

## Solution to Step 1 - Undo a single commit.

In the history, the file `README.md` was renamed to `liesmich`.
Undo this change.
Tip: The commit is tagged as `umbenennung`.


<pre><code>repo $ <b>ls</b><br><br>from-feature<br>liesmich<br><br></code></pre>



<pre><code>repo $ <b>git revert umbenennung</b><br><br>[main 4a063fa] Revert &quot;umbenennen&quot;<br> Date: Thu Jul 29 00:00:00 2021 +0000<br> 1 file changed, 0 insertions(+), 0 deletions(-)<br> rename liesmich =&gt; README.md (100%)<br><br></code></pre>



<pre><code>repo $ <b>ls</b><br><br>from-feature<br>README.md<br><br></code></pre>


## Solution to Step 2 - Undo merge commit.

In the history, a feature branch was integrated via merge.file . Undo this change.
Tip: The merge commit is tagged as `feature-merge`.
Tip: The success can be recognized by the disappearance of the file `from-feature`.


<pre><code>repo $ <b>ls</b><br><br>from-feature<br>README.md<br><br></code></pre>



<pre><code>repo $ <b>git revert -m 1 feature-merge</b><br><br>[main 0cde08b] Revert &quot;Merge branch 'feature'&quot;<br> Date: Thu Jul 29 00:00:00 2021 +0000<br> 1 file changed, 12 deletions(-)<br> delete mode 100644 from-feature<br><br></code></pre>



<pre><code>repo $ <b>ls</b><br><br>README.md<br><br></code></pre>



<pre><code>repo $ <b>git tag merge-reverted</b><br><br><br></code></pre>


## Solution to Step 3 - Feature branch broken!?

A revert is often used to temporarily roll back a feature,
e.g. due to a production problem.
Later you want to correct the feature branch and then integrate it again.
This is not so easy.

In the example, the `feature` branch has undergone further development.
Try to merge it again.
Examine the error message and the commit graph.
Tip: The failed merge can be aborted with `git merge --abort`.


<pre><code>repo $ <b>git merge feature</b><br><br>CONFLICT (modify/delete): from-feature deleted in HEAD and modified in feature.  Version feature of from-feature left in tree.<br>Automatic merge failed; fix conflicts and then commit the result.<br><br></code></pre>



<pre><code>repo $ <b>git merge --abort</b><br><br><br></code></pre>



<pre><code>repo $ <b>git log --oneline --graph</b><br><br>* 0cde08b Revert &quot;Merge branch 'feature'&quot;<br>* 4a063fa Revert &quot;umbenennen&quot;<br>*   6001692 Merge branch 'feature'<br>|\  <br>| * 2caf490 Created file from-feature on branch feature by bjoern.<br>* | 48619ce umbenennen<br>|/  <br>* 50bb121 Created file README.md on branch main by bjoern.<br><br></code></pre>


The merge fails because Git commits
that are already in the history
are not merged again.
In the example, this affects the commit
that creates the file `from-feature`.
It is contained in the history and
in a later commit (the revert) the file was deleted.
The merge conflict therefore reports that the file on one
side was edited and on the other was deleted.

## Solution to Step 4 - Undo merge revert again.

The trick is to revert the revert commit itself,
then those changes are back
on which the further development of the feature is based.

Tip: The commit is tagged as `feature-merge`.


<pre><code>repo $ <b>git revert merge-reverted</b><br><br>[main d508eae] Reapply &quot;Merge branch 'feature'&quot;<br> Date: Thu Jul 29 00:00:00 2021 +0000<br> 1 file changed, 12 insertions(+)<br> create mode 100644 from-feature<br><br></code></pre>



<pre><code>repo $ <b>git merge feature</b><br><br>Merge made by the 'ort' strategy.<br> from-feature | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>repo $ <b>git log --oneline --graph</b><br><br>*   91dad09 Merge branch 'feature'<br>|\  <br>| * dc5cc98 : Weiterentwicklung<br>* | d508eae Reapply &quot;Merge branch 'feature'&quot;<br>* | 0cde08b Revert &quot;Merge branch 'feature'&quot;<br>* | 4a063fa Revert &quot;umbenennen&quot;<br>* | 6001692 Merge branch 'feature'<br>|\| <br>| * 2caf490 Created file from-feature on branch feature by bjoern.<br>* | 48619ce umbenennen<br>|/  <br>* 50bb121 Created file README.md on branch main by bjoern.<br><br></code></pre>



<pre><code>repo $ <b>git log --oneline from-feature</b><br><br>dc5cc98 : Weiterentwicklung<br>2caf490 Created file from-feature on branch feature by bjoern.<br><br></code></pre>


[To the exercise](aufgabe-zusammenarbeit-reverting-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

