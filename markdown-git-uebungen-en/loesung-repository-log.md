---
layout: page
title: <code>repository-log</code>
parent: Solutions

nav_order: 999
---
## Solution to Step 0 - START

## Solution to Step 1 - Directory structure

Examine the project directory.
What files are there in the workspace? What directories?
Where is the repository?


<pre><code>repo $ <b>ll </b><br><br>total 16K<br>drwxr-xr-x 2 vscode vscode 4.0K  foo<br>-rw-r--r-- 1 vscode vscode   12  hallo-welt<br>-rw-r--r-- 1 vscode vscode  375  nachher<br>-rw-r--r-- 1 vscode vscode    0  restaurant<br>-rw-r--r-- 1 vscode vscode  181  und-tschuess<br><br></code></pre>



<pre><code>repo $ <b>ll foo</b><br><br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 338  bar<br><br></code></pre>



<pre><code>repo $ <b>ll .git</b><br><br>total 40K<br>-rw-r--r--  1 vscode vscode   52  COMMIT_EDITMSG<br>-rw-r--r--  1 vscode vscode   92  config<br>-rw-r--r--  1 vscode vscode   73  description<br>-rw-r--r--  1 vscode vscode   21  HEAD<br>drwxr-xr-x  2 vscode vscode 4.0K  hooks<br>-rw-r--r--  1 vscode vscode  477  index<br>drwxr-xr-x  2 vscode vscode 4.0K  info<br>drwxr-xr-x  3 vscode vscode 4.0K  logs<br>drwxr-xr-x 54 vscode vscode 4.0K  objects<br>drwxr-xr-x  4 vscode vscode 4.0K  refs<br><br></code></pre>


You can see: The project contains some files, a subdirectory
and of course a `.git` directory, which houses the repository.

## Solution to Step 2 - View commits

Look at the commits.
Pay attention to the displayed branches and tags.


<pre><code>repo $ <b>git log --oneline</b><br><br>68be303 Created file und-tschuess on branch main by bjoern.<br>6a70b5c : Edit file bar at line 5 on branch main by bjoern.<br>a5fc3f7 : Edit file bar at line 1 on branch main by bjoern.<br>272dd25 Edited file hallo-welt on branch main by bjoern.<br>f7824a5 Eine Zeile verschieben<br>0be4bbe Noch ein paar neue Zeilen<br>480a5cf Verschiebe eine  Zeile<br>5c0c9ae Created file restaurant on branch main by bjoern.<br>aa145b9 Kopiere eine Zeile aus 'bar'<br>9e96dc7 Ergänze eine Zeile<br>96ef7f4 Benenne die Datei im<br>faf8ba9 Ergänze zwei zeilen<br>5498956 Beginne mit leerer Datei<br>e51b518 Created file bar on branch main by bjoern.<br>7b2a390 Created file hallo-welt on branch main by bjoern.<br><br></code></pre>


## Solution to Step 3 - Examine head commit

Show details about the current version
that is checked out in the workspace.


Here is the current version `HEAD`:


<pre><code>repo $ <b>git show</b><br><br>commit 68be303d3c1a0bfab263879b530d617560d3f4c1<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file und-tschuess on branch main by bjoern.<br><br>diff --git a/und-tschuess b/und-tschuess<br>new file mode 100644<br>index 0000000..36fe753<br>--- /dev/null<br>+++ b/und-tschuess<br>@@ -0,0 +1,12 @@<br>+line 0 created<br>+line 1 created<br>+line 2 created<br>+line 3 created<br>+line 4 created<br>+line 5 created<br>+line 6 created<br>+line 7 created<br>+line 8 created<br>+line 9 created<br>+line 10 created<br>+line 11 created<br>\ No newline at end of file<br><br></code></pre>


## Solution to Step 4 - Examine past commits

Show details for Release 1.0,
and then for the predecessor version of Release 1.0


Here comes 1.0:


<pre><code>repo $ <b>git show release1.0</b><br><br>commit f7824a5ff32f15f3c890c6b9ba2bff984692e221<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Eine Zeile verschieben<br><br>diff --git a/nachher b/nachher<br>index c35fa99..32b0886 100644<br>--- a/nachher<br>+++ b/nachher<br>@@ -4,6 +4,6 @@ Nach der Umbenennung<br> Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br> Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br> Und eine, die nichts damit zu tun hat.<br>-Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br> dazwischen.<br>+Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br> Ende<br>\ No newline at end of file<br><br></code></pre>



And here is its predecessor:


<pre><code>repo $ <b>git show release1.0~1</b><br><br>commit 0be4bbe385655d6eae9c7b3b858b542d6ec9011d<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Noch ein paar neue Zeilen<br><br>diff --git a/nachher b/nachher<br>index dc66148..c35fa99 100644<br>--- a/nachher<br>+++ b/nachher<br>@@ -3,4 +3,7 @@ Und das ist wohl doch sehr lange her. Wie man sieht.<br> Nach der Umbenennung<br> Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br> Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>-Und eine, die nichts damit zu tun hat.<br>\ No newline at end of file<br>+Und eine, die nichts damit zu tun hat.<br>+Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>+dazwischen.<br>+Ende<br>\ No newline at end of file<br><br></code></pre>


## Solution to Step 5 - ⭐ Examine contents of past versions

Show which files and directories
existed in the previous commit.

Output the content of the file `bar` as it was in the previous commit.


These files existed in `HEAD~1`:


<pre><code>repo $ <b>git ls-tree -r HEAD~1</b><br><br>100644 blob 758676bb62f2032d5a62747409e185a756f5bf93	foo/bar<br>100644 blob c57eff55ebc0c54973903af5f72bac72762cf4f4	hallo-welt<br>100644 blob 32b08868b00465cca451251689dda4c9d83b2d85	nachher<br>100644 blob e69de29bb2d1d6434b8b29ae775ad8c2e48c5391	restaurant<br><br></code></pre>



And here is the content of `bar`:


<pre><code>repo $ <b>git show HEAD~1:foo/bar</b><br><br>line 0 created<br>line 1 Edit file bar at line 1 on branch main by bjoern. / Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>line 2 created<br>line 3 created<br>line 4 created<br>line 5 Edit file bar at line 5 on branch main by bjoern. / line 5 created<br>line 6 created<br>line 7 created<br>line 8 created<br>line 9 created<br>line 10 created<br>line 11 created<br><br></code></pre>


## Solution to Step 6 - ⭐ View commits: file statistics

Look at the commits.
Have the statistics displayed,
i.e. how many lines were changed in which file.


<pre><code>repo $ <b>git log --stat</b><br><br>commit 68be303d3c1a0bfab263879b530d617560d3f4c1<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file und-tschuess on branch main by bjoern.<br><br> und-tschuess | 12 ++++++++++++<br> 1 file changed, 12 insertions(+)<br><br>commit 6a70b5cfc5496d039d35049225e981336d71df8c<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file bar at line 5 on branch main by bjoern.<br><br> foo/bar | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit a5fc3f725eaf3607231e66b5ed92862d17a77996<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file bar at line 1 on branch main by bjoern.<br><br> foo/bar | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit 272dd25328588261b44fbf5a7d7e55859172387b<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Edited file hallo-welt on branch main by bjoern.<br><br> hallo-welt | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit f7824a5ff32f15f3c890c6b9ba2bff984692e221<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Eine Zeile verschieben<br><br> nachher | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit 0be4bbe385655d6eae9c7b3b858b542d6ec9011d<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Noch ein paar neue Zeilen<br><br> nachher | 5 ++++-<br> 1 file changed, 4 insertions(+), 1 deletion(-)<br><br>commit 480a5cf16b90f25d3ea34d929f5b6671c747b871<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Verschiebe eine  Zeile<br><br> nachher    | 4 +++-<br> restaurant | 1 -<br> 2 files changed, 3 insertions(+), 2 deletions(-)<br><br>commit 5c0c9ae6ac2eb35b98ee99475de27c8f0865210b<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file restaurant on branch main by bjoern.<br><br> restaurant | 1 +<br> 1 file changed, 1 insertion(+)<br><br>commit aa145b90565f4bcfe74608147eb5bef0ad2bc013<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Kopiere eine Zeile aus 'bar'<br><br> nachher | 3 ++-<br> 1 file changed, 2 insertions(+), 1 deletion(-)<br><br>commit 9e96dc75ffa257cb367e5bea5e10f8718f2bd7ca<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Ergänze eine Zeile<br><br> nachher | 3 ++-<br> 1 file changed, 2 insertions(+), 1 deletion(-)<br><br>commit 96ef7f4b56d36e5e19fd12d25592115d78a477a2<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Benenne die Datei im<br><br> foo/vorher =&gt; nachher | 0<br> 1 file changed, 0 insertions(+), 0 deletions(-)<br><br>commit faf8ba9902490c2bd922b88ae96556c969a2d7f5<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Ergänze zwei zeilen<br><br> foo/vorher | 2 ++<br> 1 file changed, 2 insertions(+)<br><br>commit 5498956d515bfa8324589c53be34845af8d4f77d<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Beginne mit leerer Datei<br><br> foo/vorher | 0<br> 1 file changed, 0 insertions(+), 0 deletions(-)<br><br>commit e51b51846db756759e189fc371af222b22db74c7<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file bar on branch main by bjoern.<br><br> foo/bar | 12 ++++++++++++<br> 1 file changed, 12 insertions(+)<br><br>commit 7b2a3906cd8ee826ad7d207b53a2103f9b2416d7<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file hallo-welt on branch main by bjoern.<br><br> hallo-welt | 1 +<br> 1 file changed, 1 insertion(+)<br><br></code></pre>


## Solution to Step 7 - ⭐ Determine origin of lines

The goal is to determine the following for the file `nachher`:

* For each line, show in which commit it was last edited.
* Lines were moved within the file. Which ones?
* Lines were also moved and copied from other files. Which ones?


<pre><code>repo $ <b>git blame nachher -s -w</b><br><br>faf8ba99 foo/vorher 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>faf8ba99 foo/vorher 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>9e96dc75 nachher    3) Nach der Umbenennung<br>aa145b90 nachher    4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>480a5cf1 nachher    5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>480a5cf1 nachher    6) Und eine, die nichts damit zu tun hat.<br>0be4bbe3 nachher    7) dazwischen.<br>f7824a5f nachher    8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>0be4bbe3 nachher    9) Ende<br><br></code></pre>


You can see in which commit the lines were last edited, even across renames.


<pre><code>repo $ <b>git blame nachher -s -w -M --show-number</b><br><br>faf8ba99 foo/vorher 1 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>faf8ba99 foo/vorher 2 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>9e96dc75 nachher    3 3) Nach der Umbenennung<br>aa145b90 nachher    4 4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>480a5cf1 nachher    5 5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>480a5cf1 nachher    6 6) Und eine, die nichts damit zu tun hat.<br>0be4bbe3 nachher    8 7) dazwischen.<br>0be4bbe3 nachher    7 8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>0be4bbe3 nachher    9 9) Ende<br><br></code></pre>


The line numbers show which lines were moved.


<pre><code>repo $ <b>git blame nachher -s -w -M -C</b><br><br>faf8ba99 foo/vorher 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>faf8ba99 foo/vorher 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>9e96dc75 nachher    3) Nach der Umbenennung<br>aa145b90 nachher    4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>5c0c9ae6 restaurant 5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>480a5cf1 nachher    6) Und eine, die nichts damit zu tun hat.<br>0be4bbe3 nachher    7) dazwischen.<br>0be4bbe3 nachher    8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>0be4bbe3 nachher    9) Ende<br><br></code></pre>


Here you can see a move from the file `restaurant`.


<pre><code>repo $ <b>git blame nachher -s -w -M -C -C -C</b><br><br>faf8ba99 foo/vorher 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>faf8ba99 foo/vorher 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>9e96dc75 nachher    3) Nach der Umbenennung<br>e51b5184 foo/bar    4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>5c0c9ae6 restaurant 5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>480a5cf1 nachher    6) Und eine, die nichts damit zu tun hat.<br>0be4bbe3 nachher    7) dazwischen.<br>0be4bbe3 nachher    8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>0be4bbe3 nachher    9) Ende<br><br></code></pre>


Here you can see that content was copied from another file `foo/bar`.

[To the exercise](aufgabe-repository-log-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

