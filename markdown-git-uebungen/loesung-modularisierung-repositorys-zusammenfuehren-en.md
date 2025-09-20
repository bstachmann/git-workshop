---
layout: page
title: <code>modularisierung-repositorys-zusammenfuehren-en</code>
parent: Solutions

nav_order: 18
---
## Solution to Step 0 - START

## Solution to Step 1 - Merge `git subtree`


1. Create a repo `application` with one commit.
2. Add `backend.git` in a subdirectory `backend`.
3. Add `ui.git` in a subdirectory `ui`.
4. Examine the directory structure and commit graph


<pre><code>$ <b>git init -b main application </b><br><br>Initialized empty Git repository in /workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-repositorys-zusammenfuehren/application/.git/<br><br></code></pre>



<pre><code>$ <b>cd application</b><br><br><br></code></pre>


We create a first commit so that the `subtree` command can be executed.


<pre><code>application $ <b># created file 'README'</b><br><br><br></code></pre>



<pre><code>application $ <b>git add README</b><br><br><br></code></pre>



<pre><code>application $ <b>git commit -am &quot;Created file README on branch main by bjoern. &quot;</b><br><br>[main (root-commit) 74f11b3] Created file README on branch main by bjoern.<br> 1 file changed, 12 insertions(+)<br> create mode 100644 README<br><br></code></pre>


Then we add the repos with `subtree`:


<pre><code>application $ <b>git subtree add --prefix=backend ../backend.git main</b><br><br>git fetch ../backend.git main<br>From ../backend<br> * branch            main       -&gt; FETCH_HEAD<br>Added dir 'backend'<br><br></code></pre>



<pre><code>application $ <b>git subtree add --prefix=ui ../ui.git main</b><br><br>git fetch ../ui.git main<br>From ../ui<br> * branch            main       -&gt; FETCH_HEAD<br>Added dir 'ui'<br><br></code></pre>


You can see that ui and backend have been merged including their history:


<pre><code>application $ <b>git ls-tree -r --name-only HEAD</b><br><br>README<br>backend/src/Backend.java<br>backend/test/BackendTest.java<br>ui/src/UI.java<br>ui/test/UITest.java<br><br></code></pre>



<pre><code>application $ <b>git log --oneline --graph</b><br><br>*   f04721f Add 'ui/' from commit '5791af8bb65732c78dd9802fdac6bfe0aa218ced'<br>|\  <br>| * 5791af8 Created file UITest.java on branch main by bjoern.<br>| * 292845b Created file UI.java on branch main by bjoern.<br>*   05a8fee Add 'backend/' from commit '4abbae294702c64cd9532bf814f7cb76db9fb963'<br>|\  <br>| * 4abbae2 Created file BackendTest.java on branch main by bjoern.<br>| * 9ed7ede Created file Backend.java on branch main by bjoern.<br>* 74f11b3 Created file README on branch main by bjoern.<br><br></code></pre>



<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 2 - Merge with `fetch`, `mv` and `merge`

UI and backend should be merged in a new clone `gesamt`.
Follow the instructions in the chapter *"Merging small projects"*.
Then examine the directory structure and commit graph.


<pre><code>$ <b>git clone backend gesamt</b><br><br>Cloning into 'gesamt'...<br>done.<br><br></code></pre>



<pre><code>$ <b>cd gesamt</b><br><br><br></code></pre>


Move backend files to subdirectory:


<pre><code>gesamt $ <b>mkdir backend</b><br><br><br></code></pre>



<pre><code>gesamt $ <b>git mv src test backend</b><br><br><br></code></pre>



<pre><code>gesamt $ <b>git commit -m 'backend-Verzeichnis angelegt'</b><br><br>[main 0487992] backend-Verzeichnis angelegt<br> 2 files changed, 0 insertions(+), 0 deletions(-)<br> rename {src =&gt; backend/src}/Backend.java (100%)<br> rename {test =&gt; backend/test}/BackendTest.java (100%)<br><br></code></pre>


Fetch content of the UI repository into a local branch `uimain`:


<pre><code>gesamt $ <b>git remote add ui ../ui/</b><br><br><br></code></pre>



<pre><code>gesamt $ <b>git fetch ui</b><br><br>From ../ui<br> * [new branch]      main       -&gt; ui/main<br><br></code></pre>



<pre><code>gesamt $ <b>git switch -c uimain ui/main</b><br><br>branch 'uimain' set up to track 'ui/main'.<br>Switched to a new branch 'uimain'<br><br></code></pre>


Move UI files to subdirectory:


<pre><code>gesamt $ <b>mkdir ui</b><br><br><br></code></pre>



<pre><code>gesamt $ <b>git mv src test ui</b><br><br><br></code></pre>



<pre><code>gesamt $ <b>git commit -m 'ui-Verzeichnis angelegt'</b><br><br>[uimain 43e14db] ui-Verzeichnis angelegt<br> 2 files changed, 0 insertions(+), 0 deletions(-)<br> rename {src =&gt; ui/src}/UI.java (100%)<br> rename {test =&gt; ui/test}/UITest.java (100%)<br><br></code></pre>


Integrate `uimain`:


<pre><code>gesamt $ <b>git switch main</b><br><br>Your branch is ahead of 'origin/main' by 1 commit.<br>  (use &quot;git push&quot; to publish your local commits)<br>Switched to branch 'main'<br><br></code></pre>



<pre><code>gesamt $ <b>git merge uimain --allow-unrelated-histories</b><br><br>Merge made by the 'ort' strategy.<br> ui/src/UI.java      | 12 ++++++++++++<br> ui/test/UITest.java | 12 ++++++++++++<br> 2 files changed, 24 insertions(+)<br> create mode 100644 ui/src/UI.java<br> create mode 100644 ui/test/UITest.java<br><br></code></pre>


You can see that ui and backend have been merged including their history:


<pre><code>gesamt $ <b>git ls-tree -r --name-only HEAD</b><br><br>backend/src/Backend.java<br>backend/test/BackendTest.java<br>ui/src/UI.java<br>ui/test/UITest.java<br><br></code></pre>



<pre><code>gesamt $ <b>git log --oneline --graph</b><br><br>*   dc42d8d Merge branch 'uimain'<br>|\  <br>| * 43e14db ui-Verzeichnis angelegt<br>| * 5791af8 Created file UITest.java on branch main by bjoern.<br>| * 292845b Created file UI.java on branch main by bjoern.<br>* 0487992 backend-Verzeichnis angelegt<br>* 4abbae2 Created file BackendTest.java on branch main by bjoern.<br>* 9ed7ede Created file Backend.java on branch main by bjoern.<br><br></code></pre>



<pre><code>gesamt $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-modularisierung-repositorys-zusammenfuehren-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

