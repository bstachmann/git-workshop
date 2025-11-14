---
layout: page
title: <code>modularisierung-subtrees</code>
parent: Solutions

nav_order: 999
---
## Solution to Step 0 - START

## Solution to Step 1 - Integrating modules as subtrees

Integrate the modules `frontend.git` and `backend.git`
using `subtree add`.
Then examine the resulting directory structure.


<pre><code>application $ <b>git subtree add --prefix=frontend ../frontend.git main</b><br><br>git fetch ../frontend.git main<br>From ../frontend<br> * branch            main       -&gt; FETCH_HEAD<br>Added dir 'frontend'<br><br></code></pre>



<pre><code>application $ <b>git subtree add --prefix=backend ../backend.git main</b><br><br>git fetch ../backend.git main<br>From ../backend<br> * branch            main       -&gt; FETCH_HEAD<br>Added dir 'backend'<br><br></code></pre>



<pre><code>application $ <b>git ls-tree -r HEAD</b><br><br>100644 blob 36fe7538890f39b90ff7dee1d1f97ba3e3a9350c	README<br>100644 blob 36fe7538890f39b90ff7dee1d1f97ba3e3a9350c	backend/service.java<br>100644 blob 36fe7538890f39b90ff7dee1d1f97ba3e3a9350c	frontend/main.ts<br><br></code></pre>


## Solution to Step 2 - Adopting changes from a module

Go to the `backend` repo, change the `service.java` file, commit and push.
Look at the resulting commit (`show --stat`)
Go to the `application` repo and fetch the changes using `subtree pull`.
Look at the transferred commit.


<pre><code>$ <b>cd backend</b><br><br><br></code></pre>



<pre><code>backend $ <b># Edit file service.java at line 7 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>backend $ <b>git commit -am &quot;`service.java`: Edit file service.java at line 7 on branch main by bjoern. &quot;</b><br><br>[main 45a3d13] : Edit file service.java at line 7 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: service.java: command not found<br><br></code></pre>



<pre><code>backend $ <b>git show --stat </b><br><br>commit 45a3d1300877eb63e155cc2d9e48c0e9c6dd9d40<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file service.java at line 7 on branch main by bjoern.<br><br> service.java | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>backend $ <b>git push</b><br><br>To ../backend.git<br>   005d8aa..45a3d13  main -&gt; main<br><br></code></pre>



<pre><code>backend $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd application</b><br><br><br></code></pre>



<pre><code>application $ <b>git subtree pull --prefix=backend ../backend.git main</b><br><br>Merge made by the 'ort' strategy.<br> backend/service.java | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From ../backend<br> * branch            main       -&gt; FETCH_HEAD<br><br></code></pre>



<pre><code>application $ <b>git show --stat </b><br><br>commit 5212dee0f6c96681e7d5f9bb60780d4c1b474223<br>Merge: 8453b78 45a3d13<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Merge commit '45a3d1300877eb63e155cc2d9e48c0e9c6dd9d40'<br><br> backend/service.java | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 3 - Transferring changes to a module

Go to `application`, change `frontend/main.ts` and commit.
Transfer the change to `frontend.git` using `subtree push`.
Look at the transferred commit in `frontend.git`.


<pre><code>$ <b>cd application</b><br><br><br></code></pre>



<pre><code>frontend $ <b># Edit file frontend/main.ts at line 3 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>application $ <b>git commit -am &quot;`frontend/main.ts`: Edit file frontend/main.ts at line 3 on branch main by bjoern. &quot;</b><br><br>[main ec22756] : Edit file frontend/main.ts at line 3 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: frontend/main.ts: Permission denied<br><br></code></pre>



<pre><code>application $ <b>git subtree push --prefix=frontend ../frontend.git main</b><br><br>git push using:  ../frontend.git main<br>1/8 (0) [0]<br>2/8 (0) [0]<br>3/8 (0) [0]<br>3/8 (1) [1]<br>3/8 (1) [2]<br>4/8 (1) [2]<br>5/8 (2) [2]<br>5/8 (3) [3]<br>6/8 (3) [3]<br>7/8 (4) [3]<br>7/8 (5) [4]<br>8/8 (5) [4]<br>To ../frontend.git<br>   03baf80..9353bac  9353bac2fbbe00cace23ed6a85fae2c02d7ebe58 -&gt; main<br><br></code></pre>



<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd frontend.git</b><br><br><br></code></pre>



<pre><code>frontend.git $ <b>git show --stat </b><br><br>commit 9353bac2fbbe00cace23ed6a85fae2c02d7ebe58<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file frontend/main.ts at line 3 on branch main by bjoern.<br><br> main.ts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>frontend.git $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 4 - Cloning the parent repo

Clone `application` to `myapplication`.
Examine the `HEAD` directory structure,
and the commit graph.


<pre><code>$ <b>git clone application myapplication</b><br><br>Cloning into 'myapplication'...<br>done.<br><br></code></pre>



<pre><code>$ <b>cd myapplication</b><br><br><br></code></pre>


You can see that the embeddings appear as normal files and directories in the `HEAD` tree


<pre><code>myapplication $ <b>git ls-tree -r HEAD .</b><br><br>100644 blob 36fe7538890f39b90ff7dee1d1f97ba3e3a9350c	README<br>100644 blob 6429de2def6cf09854047acb14ee781e65462881	backend/service.java<br>100644 blob ab09e17b67ee7ec9f019c779211387d58e69f214	frontend/main.ts<br><br></code></pre>


In the commit graph you can see, where the data comes from.


<pre><code>myapplication $ <b>git log --graph --oneline --stat</b><br><br>* ec22756 : Edit file frontend/main.ts at line 3 on branch main by bjoern.<br>|  frontend/main.ts | 2 +-<br>|  1 file changed, 1 insertion(+), 1 deletion(-)<br>*   5212dee Merge commit '45a3d1300877eb63e155cc2d9e48c0e9c6dd9d40'<br>|\  <br>| * 45a3d13 : Edit file service.java at line 7 on branch main by bjoern.<br>| |  service.java | 2 +-<br>| |  1 file changed, 1 insertion(+), 1 deletion(-)<br>* | 8453b78 Add 'backend/' from commit '005d8aaf310fef036b86d5f6cae09f9ac8477669'<br>|\| <br>| * 005d8aa Created file service.java on branch main by bjoern.<br>|    service.java | 12 ++++++++++++<br>|    1 file changed, 12 insertions(+)<br>*   3c353b4 Add 'frontend/' from commit '03baf805ce0819e534d14835f60a2267a465bc98'<br>|\  <br>| * 03baf80 Created file main.ts on branch main by bjoern.<br>|    main.ts | 12 ++++++++++++<br>|    1 file changed, 12 insertions(+)<br>* 74f11b3 Created file README on branch main by bjoern.<br>   README | 12 ++++++++++++<br>   1 file changed, 12 insertions(+)<br><br></code></pre>



<pre><code>myapplication $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-modularisierung-subtrees-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

