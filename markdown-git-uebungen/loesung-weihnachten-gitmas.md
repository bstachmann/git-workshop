---
layout: page
title: <code>weihnachten-gitmas</code>
parent: Lösungen

nav_order: 19
---
## Lösung zu Schritt 1 - Und jetzt ein Weihnachtsbaum

Hier geht es darum durch Branchen und mergen 
Git-Graphen zu erzeugen, der wie ein
Weihnachtsbaum aussieht.


<pre><code>$ <b>git init -b main myrepo </b><br><br>Initialized empty Git repository in /workspace/git-workshop/build/git-uebungen/loesungen/weihnachten-gitmas/myrepo/.git/<br><br></code></pre>



<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b># created file 'hallo'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file hallo on branch main by bjoern. &quot;</b><br><br>[main (root-commit) 4c2d137] Created file hallo on branch main by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 hallo<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b0 main</b><br><br>Switched to a new branch 'b0'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f0'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f0</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f0 on branch b0 by bjoern. &quot;</b><br><br>[b0 1f3da0e] Created file f0 on branch b0 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f0<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b1 main</b><br><br>Switched to a new branch 'b1'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f1'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f1</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f1 on branch b1 by bjoern. &quot;</b><br><br>[b1 6258f69] Created file f1 on branch b1 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f1<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b2 main</b><br><br>Switched to a new branch 'b2'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f2'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f2</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f2 on branch b2 by bjoern. &quot;</b><br><br>[b2 36665c3] Created file f2 on branch b2 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f2<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b3 main</b><br><br>Switched to a new branch 'b3'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f3'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f3</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f3 on branch b3 by bjoern. &quot;</b><br><br>[b3 8e3bcf1] Created file f3 on branch b3 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f3<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b4 main</b><br><br>Switched to a new branch 'b4'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f4'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f4</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f4 on branch b4 by bjoern. &quot;</b><br><br>[b4 22c6c31] Created file f4 on branch b4 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f4<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b5 main</b><br><br>Switched to a new branch 'b5'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f5'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f5</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f5 on branch b5 by bjoern. &quot;</b><br><br>[b5 e3e1a04] Created file f5 on branch b5 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f5<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b6 main</b><br><br>Switched to a new branch 'b6'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f6'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f6</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f6 on branch b6 by bjoern. &quot;</b><br><br>[b6 95ec7de] Created file f6 on branch b6 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f6<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b7 main</b><br><br>Switched to a new branch 'b7'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f7'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f7</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f7 on branch b7 by bjoern. &quot;</b><br><br>[b7 095a3fb] Created file f7 on branch b7 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f7<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b8 main</b><br><br>Switched to a new branch 'b8'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f8'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f8</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f8 on branch b8 by bjoern. &quot;</b><br><br>[b8 4f0e7e8] Created file f8 on branch b8 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f8<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b9 main</b><br><br>Switched to a new branch 'b9'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f9'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f9</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f9 on branch b9 by bjoern. &quot;</b><br><br>[b9 4973788] Created file f9 on branch b9 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f9<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b10 main</b><br><br>Switched to a new branch 'b10'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f10'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f10</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;Created file f10 on branch b10 by bjoern. &quot;</b><br><br>[b10 46ec5ee] Created file f10 on branch b10 by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f10<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b1</b><br><br>Switched to branch 'b1'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b0 -m 'year'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f0<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b2</b><br><br>Switched to branch 'b2'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b1 -m 'new'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> 2 files changed, 24 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b3</b><br><br>Switched to branch 'b3'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b2 -m 'happy'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> 3 files changed, 36 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b4</b><br><br>Switched to branch 'b4'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b3 -m 'a'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> f3 | 12 ++++++++++++<br> 4 files changed, 48 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br> create mode 100644 f3<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b5</b><br><br>Switched to branch 'b5'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b4 -m 'and'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> f3 | 12 ++++++++++++<br> f4 | 12 ++++++++++++<br> 5 files changed, 60 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br> create mode 100644 f3<br> create mode 100644 f4<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b6</b><br><br>Switched to branch 'b6'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b5 -m 'Christmas'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> f3 | 12 ++++++++++++<br> f4 | 12 ++++++++++++<br> f5 | 12 ++++++++++++<br> 6 files changed, 72 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br> create mode 100644 f3<br> create mode 100644 f4<br> create mode 100644 f5<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b7</b><br><br>Switched to branch 'b7'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b6 -m 'merry'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> f3 | 12 ++++++++++++<br> f4 | 12 ++++++++++++<br> f5 | 12 ++++++++++++<br> f6 | 12 ++++++++++++<br> 7 files changed, 84 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br> create mode 100644 f3<br> create mode 100644 f4<br> create mode 100644 f5<br> create mode 100644 f6<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b8</b><br><br>Switched to branch 'b8'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b7 -m 'a'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> f3 | 12 ++++++++++++<br> f4 | 12 ++++++++++++<br> f5 | 12 ++++++++++++<br> f6 | 12 ++++++++++++<br> f7 | 12 ++++++++++++<br> 8 files changed, 96 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br> create mode 100644 f3<br> create mode 100644 f4<br> create mode 100644 f5<br> create mode 100644 f6<br> create mode 100644 f7<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b9</b><br><br>Switched to branch 'b9'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b8 -m 'you'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> f3 | 12 ++++++++++++<br> f4 | 12 ++++++++++++<br> f5 | 12 ++++++++++++<br> f6 | 12 ++++++++++++<br> f7 | 12 ++++++++++++<br> f8 | 12 ++++++++++++<br> 9 files changed, 108 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br> create mode 100644 f3<br> create mode 100644 f4<br> create mode 100644 f5<br> create mode 100644 f6<br> create mode 100644 f7<br> create mode 100644 f8<br><br></code></pre>



<pre><code>myrepo $ <b>git switch b10</b><br><br>Switched to branch 'b10'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b9 -m 'wish'</b><br><br>Merge made by the 'ort' strategy.<br> f0 | 12 ++++++++++++<br> f1 | 12 ++++++++++++<br> f2 | 12 ++++++++++++<br> f3 | 12 ++++++++++++<br> f4 | 12 ++++++++++++<br> f5 | 12 ++++++++++++<br> f6 | 12 ++++++++++++<br> f7 | 12 ++++++++++++<br> f8 | 12 ++++++++++++<br> f9 | 12 ++++++++++++<br> 10 files changed, 120 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f2<br> create mode 100644 f3<br> create mode 100644 f4<br> create mode 100644 f5<br> create mode 100644 f6<br> create mode 100644 f7<br> create mode 100644 f8<br> create mode 100644 f9<br><br></code></pre>



<pre><code>myrepo $ <b>git switch main</b><br><br>Switched to branch 'main'<br><br></code></pre>



<pre><code>myrepo $ <b>git merge --no-ff b10 -m 'We'</b><br><br>Merge made by the 'ort' strategy.<br> f0  | 12 ++++++++++++<br> f1  | 12 ++++++++++++<br> f10 | 12 ++++++++++++<br> f2  | 12 ++++++++++++<br> f3  | 12 ++++++++++++<br> f4  | 12 ++++++++++++<br> f5  | 12 ++++++++++++<br> f6  | 12 ++++++++++++<br> f7  | 12 ++++++++++++<br> f8  | 12 ++++++++++++<br> f9  | 12 ++++++++++++<br> 11 files changed, 132 insertions(+)<br> create mode 100644 f0<br> create mode 100644 f1<br> create mode 100644 f10<br> create mode 100644 f2<br> create mode 100644 f3<br> create mode 100644 f4<br> create mode 100644 f5<br> create mode 100644 f6<br> create mode 100644 f7<br> create mode 100644 f8<br> create mode 100644 f9<br><br></code></pre>


## Merry **git**mas


<pre><code>myrepo $ <b>git log --all --oneline --topo-order --graph -12 main</b><br><br>*   00ba08e We<br>|\  <br>| *   c9e6cd5 wish<br>| |\  <br>| | *   ad3770d you<br>| | |\  <br>| | | *   6f86e21 a<br>| | | |\  <br>| | | | *   d403422 merry<br>| | | | |\  <br>| | | | | *   73c70e9 Christmas<br>| | | | | |\  <br>| | | | | | *   347cbd4 and<br>| | | | | | |\  <br>| | | | | | | *   c9b82db a<br>| | | | | | | |\  <br>| | | | | | | | *   5f61dec happy<br>| | | | | | | | |\  <br>| | | | | | | | | *   abc992d new<br>| | | | | | | | | |\  <br>| | | | | | | | | | *   e7fc5ca year<br>| | | | | | | | | | |\  <br>| | | | | | | | | | | * 1f3da0e Created file f0 on branch b0 by bjoern.<br>| |_|_|_|_|_|_|_|_|_|/  <br>|/| | | | | | | | | |   <br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Aufgabe](aufgabe-weihnachten-gitmas.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

