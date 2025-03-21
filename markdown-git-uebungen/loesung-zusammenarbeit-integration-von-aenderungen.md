---
layout: page
title: <code>zusammenarbeit-integration-von-aenderungen</code>
parent: Lösungen

nav_order: 12
---
## Lösung zu Schritt 0 - START

## Lösung zu Schritt 1 - Fast-Forward beim Pull

Im einfachste Fall haben wir selber gar nichts gemacht,
und wollen nur die Änderungen von Anja übernehmen.

Führe ein Pull durch.

Lasse Dir Status und den Commit-Graphen zeigen.


<pre><code>fast-forward $ <b>git pull</b><br><br>Updating 47053b2..8598867<br>Fast-forward<br> average.kts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From ../origin-for-merge-samples<br>   47053b2..8598867  main       -&gt; origin/main<br><br></code></pre>


Git signalisiert, dass ein Fast-Forward durchgeführt wurde.

Der Graph zeigt, dass keine Verzweigung entstanden ist und kein Merge notwendig war.


<pre><code>fast-forward $ <b>git log --graph --oneline --decorate</b><br><br>* 8598867 (HEAD -&gt; main, origin/main, origin/HEAD) Verwende double Werte statt int<br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>


## Lösung zu Schritt 2 - Merge erzwingen beim Pull

Auch dieses haben wir nichtnichts gemacht,
und wollen nur die Änderungen von Anja übernehmen.

Führe ein Pull mit `--no-ff` durch.

Lasse Dir Status und den Commit-Graphen zeigen.


<pre><code>no-ff $ <b>git pull --no-ff</b><br><br>Merge made by the 'ort' strategy.<br> average.kts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From ../origin-for-merge-samples<br>   47053b2..8598867  main       -&gt; origin/main<br><br></code></pre>


Git signalisiert, dass kein Fast-Forward durchgeführt wurde.

Der Graph zeigt, dass ein Merge enstanden ist.


<pre><code>no-ff $ <b>git log --graph --oneline --decorate</b><br><br>*   be3b61b (HEAD -&gt; main) Merge branch 'main' of ../origin-for-merge-samples<br>|\  <br>| * 8598867 (origin/main, origin/HEAD) Verwende double Werte statt int<br>|/  <br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>


## Lösung zu Schritt 3 - Integration bei Änderungen in verschiedenen Dateien

1. Bearbeite die Datei `README.md`.
   - Erstelle ein Commit dazu.
   - Prüfe mit `git show`, ob das Commit OK ist.
2. Versuche ein Push
   - Dies wird scheitern, denn Deine Kollegin Bea 
     hat die in der Zwischenzeit die Datei `average.kts`
     bearbeitet und gepushed.
3. Integriere mit Pull
4. Untersuche das Ergebnis, z. B.
   - den Commit-Graphen an
   - die Änderungen, die Anja gemacht hat 
   - die Commits, die Anja gemacht hat


<pre><code>changes-in-different-files $ <b># Edit file README.md</b><br><br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git commit -am &quot;Commited file README.md on branch main by bjoern &quot;</b><br><br>[main cc16e28] Commited file README.md on branch main by bjoern<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git show</b><br><br>commit cc16e28115d01b0553942e880ce01ec0be06b066<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Commited file README.md on branch main by bjoern<br><br>diff --git a/README.md b/README.md<br>index 8b6805c..28cf676 100644<br>--- a/README.md<br>+++ b/README.md<br>@@ -1 +1 @@<br>-Hallo Wolt!<br>+Hallo Welt!<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git push</b><br><br>To ../origin-for-merge-samples.git<br> ! [rejected]        main -&gt; main (fetch first)<br>error: failed to push some refs to '../origin-for-merge-samples.git'<br>hint: Updates were rejected because the remote contains work that you do not<br>hint: have locally. This is usually caused by another repository pushing to<br>hint: the same ref. If you want to integrate the remote changes, use<br>hint: 'git pull' before pushing again.<br>hint: See the 'Note about fast-forwards' in 'git push --help' for details.<br><br></code></pre>


Diese Meldung zeigt, dass im `origin` Änderungen vorliegen,
die wir noch nicht integriert haben.


<pre><code>changes-in-different-files $ <b>git pull</b><br><br>Merge made by the 'ort' strategy.<br> average.kts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From ../origin-for-merge-samples<br>   47053b2..8598867  main       -&gt; origin/main<br><br></code></pre>


Git hat die Änderungen geholt und ein Merge-Commit erzeugt.


<pre><code>changes-in-different-files $ <b>git log --oneline --graph</b><br><br>*   ad227b4 Merge branch 'main' of ../origin-for-merge-samples<br>|\  <br>| * 8598867 Verwende double Werte statt int<br>* | cc16e28 Commited file README.md on branch main by bjoern<br>|/  <br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git diff HEAD^1...HEAD^2</b><br><br>diff --git a/average.kts b/average.kts<br>index 4cd02bf..5ff5b2b 100644<br>--- a/average.kts<br>+++ b/average.kts<br>@@ -1,6 +1,6 @@<br> if(args.isEmpty())<br>     throw RuntimeException(&quot;No arguments given!&quot;)<br> <br>-val s = args.map{ it.toInt() }.sum()<br>+val s = args.map{ it.toDouble() }.sum()<br> <br> println(&quot;The average is ${s/args.size}&quot;)<br><br></code></pre>



<pre><code>changes-in-different-files $ <b>git log HEAD^2..HEAD^1</b><br><br>commit cc16e28115d01b0553942e880ce01ec0be06b066<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Commited file README.md on branch main by bjoern<br><br></code></pre>


Und jetzt können wir erneut ein Push versuchen.


<pre><code>changes-in-different-files $ <b>git push</b><br><br>To ../origin-for-merge-samples.git<br>   8598867..ad227b4  main -&gt; main<br><br></code></pre>


## Lösung zu Schritt 4 - Integration bei Änderungen in derselben Datei

In diesem Fall bearbeiten wir dieselbe Datei,
die auch Anja bearbeitet hat.
Es wird zu einem Konflikt kommen, 
den wir aulösen müssen.

1. Wir haben schon eine Änderung, die zu einem Konflikt führt,
   vorbereitet und committed. Untersuche diese mit `git show`
2. Führe ein Pull durch.
3. Lasse Dir den Status zeigen und löse den Konflikt.


<pre><code>changes-in-same-files $ <b>git show</b><br><br>commit 1fac0522fadc13dbac62d35e6bdeadb3fddc9762<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Refactoring: s in summe umbenennen<br><br>diff --git a/average.kts b/average.kts<br>index 4cd02bf..7eb87f2 100644<br>--- a/average.kts<br>+++ b/average.kts<br>@@ -1,6 +1,6 @@<br> if(args.isEmpty())<br>     throw RuntimeException(&quot;No arguments given!&quot;)<br> <br>-val s = args.map{ it.toInt() }.sum()<br>+val summe = args.map{ it.toInt() }.sum()<br> <br>-println(&quot;The average is ${s/args.size}&quot;)<br>+println(&quot;The average is ${summe/args.size}&quot;)<br><br></code></pre>



<pre><code>changes-in-same-files $ <b>git pull</b><br><br>Auto-merging average.kts<br>CONFLICT (content): Merge conflict in average.kts<br>Automatic merge failed; fix conflicts and then commit the result.<br>From ../origin-for-merge-samples<br>   47053b2..ad227b4  main       -&gt; origin/main<br><br></code></pre>


Wie erwartet, ist es zu einem Konflikt gekommen.


<pre><code>changes-in-same-files $ <b>git status</b><br><br>On branch main<br>Your branch and 'origin/main' have diverged,<br>and have 1 and 3 different commits each, respectively.<br>  (use &quot;git pull&quot; if you want to integrate the remote branch with yours)<br><br>You have unmerged paths.<br>  (fix conflicts and run &quot;git commit&quot;)<br>  (use &quot;git merge --abort&quot; to abort the merge)<br><br>Changes to be committed:<br>	modified:   README.md<br><br>Unmerged paths:<br>  (use &quot;git add &lt;file&gt;...&quot; to mark resolution)<br>	both modified:   average.kts<br><br><br></code></pre>


In der Datei stehen Konfliktmarkierungen.


<pre><code>changes-in-same-files $ <b>cat average.kts</b><br><br>if(args.isEmpty())<br>    throw RuntimeException(&quot;No arguments given!&quot;)<br><br>&lt;&lt;&lt;&lt;&lt;&lt;&lt; HEAD<br>val summe = args.map{ it.toInt() }.sum()<br>||||||| 47053b2<br>val s = args.map{ it.toInt() }.sum()<br>=======<br>val s = args.map{ it.toDouble() }.sum()<br>&gt;&gt;&gt;&gt;&gt;&gt;&gt; ad227b4cd09e983d92048dfdcea0b912b645b25d<br><br>println(&quot;The average is ${summe/args.size}&quot;)<br><br></code></pre>



<pre><code>changes-in-same-files $ <b># Edit average.kts replacing pattern with val summe = args.map{ it.toDouble() }.sum()</b><br><br><br></code></pre>


Nicht vergessen: Nach dem Bereinigen `git add` aufrufen.


<pre><code>changes-in-same-files $ <b>git add average.kts</b><br><br><br></code></pre>



<pre><code>changes-in-same-files $ <b>git commit -m 'Änderungen von Anja integriert'</b><br><br>[main 74f79e8] ?nderungen von Anja integriert<br><br></code></pre>


Und hier nochmal der entstandene Graph:


<pre><code>changes-in-same-files $ <b>git log --graph --oneline</b><br><br>*   74f79e8 ?nderungen von Anja integriert<br>|\  <br>| *   ad227b4 Merge branch 'main' of ../origin-for-merge-samples<br>| |\  <br>| | * 8598867 Verwende double Werte statt int<br>| * | cc16e28 Commited file README.md on branch main by bjoern<br>| |/  <br>* / 1fac052 Refactoring: s in summe umbenennen<br>|/  <br>* 47053b2 Created file average.kts on branch main by anja .<br>* 75dfc35 Created file README.md on branch main by anja .<br><br></code></pre>


[Zur Aufgabe](aufgabe-zusammenarbeit-integration-von-aenderungen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

