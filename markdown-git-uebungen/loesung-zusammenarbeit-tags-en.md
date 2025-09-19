---
layout: page
title: <code>zusammenarbeit-tags-en</code>
parent: Lösungen

nav_order: 10
---
## Solution zu Step 0 - START

## Solution zu Step 1 - Tags erstellen

Erstelle ein einfaches Tag `simple1` auf `HEAD` und
ein annotated Tag `annotated1` auf `HEAD~1`.
Sieh zuerst das Log und dann beide Tags einzeln an (`git show an`).


<pre><code>mein-klon $ <b>git tag simple1</b><br><br><br></code></pre>



<pre><code>mein-klon $ <b>git tag annotated1 HEAD~1 -m 'Mit Beschreibung'</b><br><br><br></code></pre>



<pre><code>mein-klon $ <b>git log --oneline --decorate</b><br><br>af500f3 (HEAD -&gt; main, tag: simple1, origin/main, origin/HEAD) : Just editing<br>d4d7875 (tag: v0.1, tag: annotated1) Initial edit before cloning<br><br></code></pre>



<pre><code>mein-klon $ <b>git show simple1 --no-patch</b><br><br>commit af500f303ef2cc7b770c560190d4072d2c879972<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Just editing<br><br></code></pre>


Beim *annotated Tag* werden zusätzlich Beschreibung und Metadaten angezeigt:


<pre><code>mein-klon $ <b>git show annotated1 --no-patch</b><br><br>tag annotated1<br>Tagger: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>Mit Beschreibung<br><br>commit d4d7875a179ac89a40ed04b1e6cf33a5111fcedf<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Initial edit before cloning<br><br></code></pre>


## Solution zu Step 2 - Tags holen

Einfach per pull.


<pre><code>mein-klon $ <b>git pull</b><br><br>Updating af500f3..06d348f<br>Fast-forward<br> foobar | 8 ++++----<br> 1 file changed, 4 insertions(+), 4 deletions(-)<br>From ../blessed<br>   af500f3..06d348f  main       -&gt; origin/main<br> * [new tag]         v0.2       -&gt; v0.2<br> * [new tag]         v0.3       -&gt; v0.3<br> * [new tag]         v1.0       -&gt; v1.0<br><br></code></pre>


## Solution zu Step 3 - Tags pushen

Beim einfachen `git push` werden keine Tags übertragen.
Übertrage zunächste gezielt das Tag `simple1` mit einem Push
und danach alle weiteren Tags mit einem weiteren Push


<pre><code>mein-klon $ <b>git push</b><br><br>Everything up-to-date<br><br></code></pre>



<pre><code>mein-klon $ <b>git push origin simple1</b><br><br>To ../blessed.git<br> * [new tag]         simple1 -&gt; simple1<br><br></code></pre>



<pre><code>mein-klon $ <b>git push --tags</b><br><br>To ../blessed.git<br> * [new tag]         annotated1 -&gt; annotated1<br><br></code></pre>


## Solution zu Step 4 - Manipulieren

Überschreibe das Tag `v0.1`, so dass es auf den`HEAD` zeigt.
Pushe das Tag.
Gehe in das Verzeichnis `../anderer-klon` und hole das Tag mit pull.
Schaue ins Log, um zu überprüfen, dass das Tag aktualisiert wurde.


<pre><code>mein-klon $ <b># Something else</b><br><br><br></code></pre>



<pre><code>mein-klon $ <b>git commit -am &quot;`foobar`: Something else &quot;</b><br><br>[main 038ab4f] : Something else<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: foobar: command not found<br><br></code></pre>



<pre><code>mein-klon $ <b>git tag v0.1 -f -m 'Moved later on'</b><br><br>Updated tag 'v0.1' (was 3765c1c)<br><br></code></pre>



<pre><code>mein-klon $ <b>git push origin v0.1</b><br><br>To ../blessed.git<br> ! [rejected]        v0.1 -&gt; v0.1 (already exists)<br>error: failed to push some refs to '../blessed.git'<br>hint: Updates were rejected because the tag already exists in the remote.<br><br></code></pre>



<pre><code>mein-klon $ <b>git push -f origin v0.1 </b><br><br>To ../blessed.git<br> + 3765c1c...1f8ce21 v0.1 -&gt; v0.1 (forced update)<br><br></code></pre>



<pre><code>mein-klon $ <b>git log --oneline --decorate -3</b><br><br>038ab4f (HEAD -&gt; main, tag: v0.1) : Something else<br>06d348f (origin/main, origin/HEAD) : Do something<br>27e367e (tag: v1.0) : Improve even more<br><br></code></pre>



<pre><code>.. $ <b>cd anderer-klon</b><br><br><br></code></pre>



<pre><code>anderer-klon $ <b>git log --oneline --decorate</b><br><br>06d348f (HEAD -&gt; main, origin/main) : Do something<br>27e367e (tag: v1.0) : Improve even more<br>ccb6eea : Improve it<br>b9ffddc (tag: v0.3) : First edit after cloning<br>af500f3 : Just editing<br>d4d7875 (tag: v0.2, tag: v0.1) Initial edit before cloning<br><br></code></pre>



<pre><code>anderer-klon $ <b>git pull</b><br><br>Already up to date.<br>From ../blessed<br> * [new tag]         annotated1 -&gt; annotated1<br> * [new tag]         simple1    -&gt; simple1<br><br></code></pre>



<pre><code>anderer-klon $ <b>git pull --tags</b><br><br>From ../blessed<br> ! [rejected]        v0.1       -&gt; v0.1  (would clobber existing tag)<br><br></code></pre>



<pre><code>anderer-klon $ <b>git pull -f --tags</b><br><br>Already up to date.<br>From ../blessed<br> t [tag update]      v0.1       -&gt; v0.1<br><br></code></pre>



<pre><code>anderer-klon $ <b>git log --oneline --decorate</b><br><br>06d348f (HEAD -&gt; main, origin/main, origin/HEAD) : Do something<br>27e367e (tag: v1.0) : Improve even more<br>ccb6eea : Improve it<br>b9ffddc (tag: v0.3) : First edit after cloning<br>af500f3 (tag: simple1) : Just editing<br>d4d7875 (tag: v0.2, tag: annotated1) Initial edit before cloning<br><br></code></pre>



<pre><code>anderer-klon $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-zusammenarbeit-tags-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

