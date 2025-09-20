---
layout: page
title: <code>modularisierung-submodules-en</code>
parent: Solutions

nav_order: 16
---
## Solution to Step 0 - START

## Solution to Step 1 - Integrating modules as submodules

Integrate the modules `frontend.git` and `backend.git`
using `submodule add`.
Then examine the resulting directory structure.


<pre><code>application $ <b>git submodule add  ../frontend.git frontend</b><br><br>Cloning into '/workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/application/frontend'...<br>done.<br><br></code></pre>



<pre><code>application $ <b>git submodule add  ../backend.git backend</b><br><br>Cloning into '/workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/application/backend'...<br>done.<br><br></code></pre>


You can see that the modules are embedded as independent Git repositories with a separate `.git` directory.


<pre><code>application $ <b>ll frontend backend</b><br><br>backend:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  service.java<br><br>frontend:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  main.ts<br><br></code></pre>


Attention! The submodules have been added, but a commit is still missing.


<pre><code>application $ <b>git status</b><br><br>On branch main<br>Changes to be committed:<br>  (use &quot;git restore --staged &lt;file&gt;...&quot; to unstage)<br>	new file:   .gitmodules<br>	new file:   backend<br>	new file:   frontend<br><br><br></code></pre>



<pre><code>application $ <b>git commit -m 'add frontend and backend'</b><br><br>[main f5a4fc3] add frontend and backend<br> 3 files changed, 8 insertions(+)<br> create mode 100644 .gitmodules<br> create mode 160000 backend<br> create mode 160000 frontend<br><br></code></pre>


## Solution to Step 2 - Adopting changes from a module

Go to the `backend` repo, change the `service.java` file, commit and push.
Look at the resulting commit (`show --stat`)
Go to the `application/backend` repo and fetch the changes using `pull`.
Look at the transferred commit.


<pre><code>$ <b>cd backend</b><br><br><br></code></pre>



<pre><code>backend $ <b># Edit file service.java at line 8 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>backend $ <b>git commit -am &quot;`service.java`: Edit file service.java at line 8 on branch main by bjoern. &quot;</b><br><br>[main 5465a06] : Edit file service.java at line 8 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: service.java: command not found<br><br></code></pre>



<pre><code>backend $ <b>git show --stat </b><br><br>commit 5465a0638bf7e6f63a41baded2cf6cf770d6b659<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file service.java at line 8 on branch main by bjoern.<br><br> service.java | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>backend $ <b>git push</b><br><br>To ../backend.git<br>   005d8aa..5465a06  main -&gt; main<br><br></code></pre>



<pre><code>backend $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd application</b><br><br><br></code></pre>



<pre><code>application $ <b>cd backend</b><br><br><br></code></pre>



<pre><code>backend $ <b>git pull</b><br><br>Updating 005d8aa..5465a06<br>Fast-forward<br> service.java | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>From /workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/backend<br>   005d8aa..5465a06  main       -&gt; origin/main<br><br></code></pre>



<pre><code>backend $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>application $ <b>git add backend</b><br><br><br></code></pre>



<pre><code>application $ <b>git commit -am 'updated backend'</b><br><br>[main eaf467e] updated backend<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 3 - Transferring changes to a module

Go to `subtrees/frontend`, change `main.ts` and commit.
Transfer the change to `frontend.git` using `push`.
Look at the transferred commit in `frontend.git`.


<pre><code>$ <b>cd application</b><br><br><br></code></pre>



<pre><code>application $ <b>cd frontend</b><br><br><br></code></pre>



<pre><code>frontend $ <b># Edit file main.ts at line 5 on branch main by bjoern.</b><br><br><br></code></pre>



<pre><code>frontend $ <b>git commit -am &quot;`main.ts`: Edit file main.ts at line 5 on branch main by bjoern. &quot;</b><br><br>[main 357f243] : Edit file main.ts at line 5 on branch main by bjoern.<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br>/bin/bash: line 1: main.ts: command not found<br><br></code></pre>



<pre><code>frontend $ <b>git push</b><br><br>To /workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/frontend.git<br>   03baf80..357f243  main -&gt; main<br><br></code></pre>



<pre><code>frontend $ <b>cd ..</b><br><br><br></code></pre>


Don't forget: commit changes in the parent repository.


<pre><code>application $ <b>git add frontend</b><br><br><br></code></pre>



<pre><code>application $ <b>git commit -m 'new version of frontend'</b><br><br>[main 8a4ffa3] new version of frontend<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>application $ <b>cd ..</b><br><br><br></code></pre>



<pre><code>$ <b>cd frontend.git</b><br><br><br></code></pre>



<pre><code>frontend.git $ <b>git show --stat </b><br><br>commit 357f243ea0f6d3c6f832fb0e0f41743e44376a61<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file main.ts at line 5 on branch main by bjoern.<br><br> main.ts | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br></code></pre>



<pre><code>frontend.git $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 4 - Cloning the parent repo

Clone `application` to `myapplication`.
Examine the directory structure.
Don't forget to run `submodule update`.


<pre><code>$ <b>git clone application myapplication</b><br><br>Cloning into 'myapplication'...<br>done.<br><br></code></pre>



<pre><code>$ <b>cd myapplication</b><br><br><br></code></pre>


The module directories are there but still empty:


<pre><code>myapplication $ <b>ll frontend backend</b><br><br>backend:<br>total 0<br><br>frontend:<br>total 0<br><br></code></pre>


Now we fetch the modules:


<pre><code>myapplication $ <b>git submodule update --init</b><br><br>Submodule path 'backend': checked out '5465a0638bf7e6f63a41baded2cf6cf770d6b659'<br>Submodule path 'frontend': checked out '357f243ea0f6d3c6f832fb0e0f41743e44376a61'<br>Submodule 'backend' (/workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/backend.git) registered for path 'backend'<br>Submodule 'frontend' (/workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/frontend.git) registered for path 'frontend'<br>Cloning into '/workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/myapplication/backend'...<br>done.<br>Cloning into '/workspaces/git-workshop/build/git-uebungen-en/loesungen/modularisierung-submodules/myapplication/frontend'...<br>done.<br><br></code></pre>



<pre><code>myapplication $ <b>ll frontend backend</b><br><br>backend:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 249  service.java<br><br>frontend:<br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 244  main.ts<br><br></code></pre>



<pre><code>myapplication $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-modularisierung-submodules-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

