---
layout: page
title: <code>repository-klonen</code>
parent: Lösungen

nav_order: 4
---
## Lösung zu Schritt 0 - START

## Lösung zu Schritt 1 - Klon durchführen

Erstelle einen Klon von `myfirstrepo` mit dem Namen `myfirstclone`.


<pre><code>$ <b>git clone myfirstrepo myfirstclone</b><br><br>Cloning into 'myfirstclone'...<br>done.<br><br></code></pre>


## Lösung zu Schritt 2 - Klon untersuchen

Schaue die Commits an und
zeige den Origin des Klons `myfirstclone`.
`origin` steht in der Regel für jenes Repository,
von dem geklont wurde.
Zeige dann den Status.


<pre><code>$ <b>cd myfirstclone</b><br><br><br></code></pre>



<pre><code>myfirstclone $ <b>git log --oneline</b><br><br>097f971 Created file bar on branch main by bjoern.<br>9799da6 Created file foo on branch main by bjoern.<br><br></code></pre>



<pre><code>myfirstclone $ <b>git remote -v</b><br><br>origin	/workspaces/git-workshop/build/git-uebungen/loesungen/repository-klonen/myfirstrepo (fetch)<br>origin	/workspaces/git-workshop/build/git-uebungen/loesungen/repository-klonen/myfirstrepo (push)<br><br></code></pre>



<pre><code>myfirstclone $ <b>cd ..</b><br><br><br></code></pre>


## Lösung zu Schritt 3 - Im Klon arbeiten

Erstelle ein Commit und zeige dann den Status.


<pre><code>$ <b>cd myfirstclone</b><br><br><br></code></pre>



<pre><code>myfirstclone $ <b># Edit file foo at line 3 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>myfirstclone $ <b>git commit -am &quot;`foo`: Edit file foo at line 3 on branch main by bjoern. &quot;</b><br><br>[main b654c9e] : Edit file foo at line 3 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: foo: command not found<br><br></code></pre>



<pre><code>myfirstclone $ <b>git status</b><br><br>On branch main<br>Your branch is ahead of 'origin/main' by 1 commit.<br>  (use &quot;git push&quot; to publish your local commits)<br><br>nothing to commit, working tree clean<br><br></code></pre>



<pre><code>myfirstclone $ <b>cd ..</b><br><br><br></code></pre>


[Zur Aufgabe](aufgabe-repository-klonen.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

