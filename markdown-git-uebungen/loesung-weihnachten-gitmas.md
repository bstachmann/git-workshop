---
layout: page
title: <code>weihnachten-gitmas</code>
parent: Lösungen

nav_order: 999
---
## Lösung zu Schritt 0 - START

## Lösung zu Schritt 1 - Und jetzt ein Weihnachtsbaum

Branche und Merge so, dass ˋgit log --graph --onelineˋ
einen Weihnachtsbaum ausgibt.


<pre><code>$ <b>git init -b main myrepo </b><br><br>Initialized empty Git repository in /workspaces/git-workshop/build/git-uebungen/loesungen/weihnachten-gitmas/myrepo/.git/<br><br></code></pre>



<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b># created file 'hallo'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add hallo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[main (root-commit) 0c7fe61] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 hallo<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b0 main</b><br><br>Switched to a new branch 'b0'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f0'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f0</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b0 92bdfa4] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f0<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b1 main</b><br><br>Switched to a new branch 'b1'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f1'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f1</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b1 09a0faa] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f1<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b2 main</b><br><br>Switched to a new branch 'b2'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f2'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f2</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b2 77ed93c] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f2<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b3 main</b><br><br>Switched to a new branch 'b3'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f3'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f3</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b3 1828786] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f3<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b4 main</b><br><br>Switched to a new branch 'b4'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f4'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f4</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b4 e044cda] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f4<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b5 main</b><br><br>Switched to a new branch 'b5'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f5'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f5</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b5 429f9d2] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f5<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b6 main</b><br><br>Switched to a new branch 'b6'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f6'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f6</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b6 9349527] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f6<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b7 main</b><br><br>Switched to a new branch 'b7'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f7'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f7</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b7 b6d8b78] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f7<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b8 main</b><br><br>Switched to a new branch 'b8'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f8'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f8</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b8 63a5a99] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f8<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b9 main</b><br><br>Switched to a new branch 'b9'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f9'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f9</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b9 3ae2b19] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f9<br><br></code></pre>



<pre><code>myrepo $ <b>git switch -c b10 main</b><br><br>Switched to a new branch 'b10'<br><br></code></pre>



<pre><code>myrepo $ <b># created file 'f10'</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git add f10</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git commit -am &quot;! &quot;</b><br><br>[b10 3ff1aae] !<br> 1 file changed, 12 insertions(+)<br> create mode 100644 f10<br><br></code></pre>



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


## Merry GITmas


<pre><code>myrepo $ <b>git log --all --oneline --topo-order --graph -12 main</b><br><br>*   529f0a7 We<br>|\  <br>| *   284b561 wish<br>| |\  <br>| | *   2cf3fe2 you<br>| | |\  <br>| | | *   0a0ac72 a<br>| | | |\  <br>| | | | *   3a5c254 merry<br>| | | | |\  <br>| | | | | *   852c32d Christmas<br>| | | | | |\  <br>| | | | | | *   80f41ba and<br>| | | | | | |\  <br>| | | | | | | *   fc0d499 a<br>| | | | | | | |\  <br>| | | | | | | | *   8f370b1 happy<br>| | | | | | | | |\  <br>| | | | | | | | | *   2adf7c5 new<br>| | | | | | | | | |\  <br>| | | | | | | | | | *   8795cf6 year<br>| | | | | | | | | | |\  <br>| | | | | | | | | | | * 92bdfa4 !<br>| |_|_|_|_|_|_|_|_|_|/  <br>|/| | | | | | | | | |   <br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


[Zur Aufgabe](aufgabe-weihnachten-gitmas.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[Zum Überblick](../../ueberblick.html){:style="visibility: hidden"}

