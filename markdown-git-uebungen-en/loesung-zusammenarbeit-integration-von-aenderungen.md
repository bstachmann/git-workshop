---
layout: page
title: <code>zusammenarbeit-integration-von-aenderungen</code>
parent: Solutions

nav_order: 999
---
## Solution to Step 0 - START

## Solution to Step 1 - Fast-forward on pull

In the simplest case, we have done nothing ourselves,
and just want to take over Anja's changes.

Perform a pull.

Show the status and the commit graph.


<pre><code>fast-forward $ <b>git pull</b><br><br>Updating 47053b2..640cceb<br>Fast-forward<br> average.kts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From ../origin-for-merge-samples<br>   47053b2..640cceb  main       -&gt; origin/main<br><br></code></pre>


Git signals that a fast-forward was performed.

The graph shows that no branch was created and no merge was necessary.


<pre><code>fast-forward $ <b>git log --graph --oneline --decorate</b><br><br>* 640cceb (HEAD -&gt; main, origin/main, origin/HEAD) Use double values instead of int<br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>


## Solution to Step 2 - Force merge on pull

Again, we have done nothing,
and just want to take over Anja's changes.

Perform a pull with `--no-ff`.

Show the status and the commit graph.


<pre><code>no-ff $ <b>git pull --no-ff</b><br><br>Merge made by the 'ort' strategy.<br> average.kts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From ../origin-for-merge-samples<br>   47053b2..640cceb  main       -&gt; origin/main<br><br></code></pre>


Git signals that no fast-forward was performed.

The graph shows that a merge has occurred.


<pre><code>no-ff $ <b>git log --graph --oneline --decorate</b><br><br>*   f71f246 (HEAD -&gt; main) Merge branch 'main' of ../origin-for-merge-samples<br>|\  <br>| * 640cceb (origin/main, origin/HEAD) Use double values instead of int<br>|/  <br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>


## Solution to Step 3 - Integration with changes in different files

1. Edit the file `README.md`.
   - Create a commit for it.
   - Check with `git show` if the commit is OK.
2. Try a push
   - This will fail because your colleague Bea
     has edited and pushed the file `average.kts`
     in the meantime.
3. Integrate with pull
4. Examine the result, e.g.
   - the commit graph
   - the changes Anja made
   - the commits Anja made


<pre><code>changes-in-different-files $ <b># Edit file README.md</b><br><br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git commit -am &quot;Commited file README.md on branch main by bjoern &quot;</b><br><br>[main cc16e28] Commited file README.md on branch main by bjoern<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git show</b><br><br>commit cc16e28115d01b0553942e880ce01ec0be06b066<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Commited file README.md on branch main by bjoern<br><br>diff --git a/README.md b/README.md<br>index 8b6805c..28cf676 100644<br>--- a/README.md<br>+++ b/README.md<br>@@ -1 +1 @@<br>-Hallo Wolt!<br>+Hallo Welt!<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git push</b><br><br>To ../origin-for-merge-samples.git<br> ! [rejected]        main -&gt; main (fetch first)<br>error: failed to push some refs to '../origin-for-merge-samples.git'<br>hint: Updates were rejected because the remote contains work that you do not<br>hint: have locally. This is usually caused by another repository pushing to<br>hint: the same ref. If you want to integrate the remote changes, use<br>hint: 'git pull' before pushing again.<br>hint: See the 'Note about fast-forwards' in 'git push --help' for details.<br><br></code></pre>


This message shows that there are changes in `origin`
that we have not yet integrated.


<pre><code>changes-in-different-files $ <b>git pull</b><br><br>Merge made by the 'ort' strategy.<br> average.kts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From ../origin-for-merge-samples<br>   47053b2..640cceb  main       -&gt; origin/main<br><br></code></pre>


Git has fetched the changes and created a merge commit.


<pre><code>changes-in-different-files $ <b>git log --oneline --graph</b><br><br>*   7136fb0 Merge branch 'main' of ../origin-for-merge-samples<br>|\  <br>| * 640cceb Use double values instead of int<br>* | cc16e28 Commited file README.md on branch main by bjoern<br>|/  <br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git diff HEAD^1...HEAD^2</b><br><br>diff --git a/average.kts b/average.kts<br>index 4cd02bf..5ff5b2b 100644<br>--- a/average.kts<br>+++ b/average.kts<br>@@ -1,6 +1,6 @@<br> if(args.isEmpty())<br>     throw RuntimeException(&quot;No arguments given!&quot;)<br> <br>-val s = args.map{ it.toInt() }.sum()<br>+val s = args.map{ it.toDouble() }.sum()<br> <br> println(&quot;The average is ${s/args.size}&quot;)<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git log HEAD^2..HEAD^1</b><br><br>commit cc16e28115d01b0553942e880ce01ec0be06b066<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Commited file README.md on branch main by bjoern<br><br></code></pre>


And now we can try a push again.


<pre><code>changes-in-different-files $ <b>git push</b><br><br>To ../origin-for-merge-samples.git<br>   640cceb..7136fb0  main -&gt; main<br><br></code></pre>


## Solution to Step 4 - Integration with changes in the same file

In this case, we are editing the same file
that Anja also edited.
A conflict will occur,
which we have to resolve.

1. We have already prepared and committed a change that leads to a conflict.
   Examine it with `git show`.
2. Perform a pull.
3. Show the status and resolve the conflict.


<pre><code>changes-in-same-files $ <b>git show</b><br><br>commit 1fac0522fadc13dbac62d35e6bdeadb3fddc9762<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Refactoring: s in summe umbenennen<br><br>diff --git a/average.kts b/average.kts<br>index 4cd02bf..7eb87f2 100644<br>--- a/average.kts<br>+++ b/average.kts<br>@@ -1,6 +1,6 @@<br> if(args.isEmpty())<br>     throw RuntimeException(&quot;No arguments given!&quot;)<br> <br>-val s = args.map{ it.toInt() }.sum()<br>+val summe = args.map{ it.toInt() }.sum()<br> <br>-println(&quot;The average is ${s/args.size}&quot;)<br>+println(&quot;The average is ${summe/args.size}&quot;)<br><br></code></pre>



<pre><code>changes-in-same-files $ <b>git pull</b><br><br>Auto-merging average.kts<br>CONFLICT (content): Merge conflict in average.kts<br>Automatic merge failed; fix conflicts and then commit the result.<br>From ../origin-for-merge-samples<br>   47053b2..7136fb0  main       -&gt; origin/main<br><br></code></pre>


As expected, a conflict has occurred.


<pre><code>changes-in-same-files $ <b>git status</b><br><br>On branch main<br>Your branch and 'origin/main' have diverged,<br>and have 1 and 3 different commits each, respectively.<br>  (use &quot;git pull&quot; if you want to integrate the remote branch with yours)<br><br>You have unmerged paths.<br>  (fix conflicts and run &quot;git commit&quot;)<br>  (use &quot;git merge --abort&quot; to abort the merge)<br><br>Changes to be committed:<br>	modified:   README.md<br><br>Unmerged paths:<br>  (use &quot;git add &lt;file&gt;...&quot; to mark resolution)<br>	both modified:   average.kts<br><br><br></code></pre>


The file contains conflict markers.


<pre><code>changes-in-same-files $ <b>cat average.kts</b><br><br>if(args.isEmpty())<br>    throw RuntimeException(&quot;No arguments given!&quot;)<br><br>&lt;&lt;&lt;&lt;&lt;&lt;&lt; HEAD<br>val summe = args.map{ it.toInt() }.sum()<br>||||||| 47053b2<br>val s = args.map{ it.toInt() }.sum()<br>=======<br>val s = args.map{ it.toDouble() }.sum()<br>&gt;&gt;&gt;&gt;&gt;&gt;&gt; 7136fb096caf572c0e9bdc2d2ff004dc4032193d<br><br>println(&quot;The average is ${summe/args.size}&quot;)<br><br></code></pre>



<pre><code>changes-in-same-files $ <b># Edit average.kts replacing pattern with val summe = args.map{ it.toDouble() }.sum()</b><br><br><br></code></pre>


Don't forget: call `git add` after cleaning up.


<pre><code>changes-in-same-files $ <b>git add average.kts</b><br><br><br></code></pre>



<pre><code>changes-in-same-files $ <b>git commit -m 'Änderungen von Anja integriert'</b><br><br>[main 8765039] Änderungen von Anja integriert<br><br></code></pre>


And here again the resulting graph:


<pre><code>changes-in-same-files $ <b>git log --graph --oneline</b><br><br>*   8765039 Änderungen von Anja integriert<br>|\  <br>| *   7136fb0 Merge branch 'main' of ../origin-for-merge-samples<br>| |\  <br>| | * 640cceb Use double values instead of int<br>| * | cc16e28 Commited file README.md on branch main by bjoern<br>| |/  <br>* / 1fac052 Refactoring: s in summe umbenennen<br>|/  <br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>


[To the exercise](aufgabe-zusammenarbeit-integration-von-aenderungen-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

