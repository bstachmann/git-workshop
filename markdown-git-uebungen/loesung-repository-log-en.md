---
layout: page
title: <code>repository-log-en</code>
parent: Solutions

nav_order: 2
---
## Solution zu Step 0 - START

## Solution zu Step 1 - Verzeichnisstruktur

Untersuche das Projektverzeichnis.
Welche Dateien gibt es im Workspace? Welche Verzeichnisse?
Wo liegt das Repository?


<pre><code>repo $ <b>ll </b><br><br>total 16K<br>drwxr-xr-x 2 vscode vscode 4.0K  foo<br>-rw-r--r-- 1 vscode vscode   12  hallo-welt<br>-rw-r--r-- 1 vscode vscode  375  nachher<br>-rw-r--r-- 1 vscode vscode    0  restaurant<br>-rw-r--r-- 1 vscode vscode  181  und-tschuess<br><br></code></pre>



<pre><code>repo $ <b>ll foo</b><br><br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 338  bar<br><br></code></pre>



<pre><code>repo $ <b>ll .git</b><br><br>total 40K<br>-rw-r--r--  1 vscode vscode   52  COMMIT_EDITMSG<br>-rw-r--r--  1 vscode vscode   21  HEAD<br>-rw-r--r--  1 vscode vscode   92  config<br>-rw-r--r--  1 vscode vscode   73  description<br>drwxr-xr-x  2 vscode vscode 4.0K  hooks<br>-rw-r--r--  1 vscode vscode  477  index<br>drwxr-xr-x  2 vscode vscode 4.0K  info<br>drwxr-xr-x  3 vscode vscode 4.0K  logs<br>drwxr-xr-x 53 vscode vscode 4.0K  objects<br>drwxr-xr-x  4 vscode vscode 4.0K  refs<br><br></code></pre>


Man sieht: Das Projekt enthält einige Dateien, ein Unterverzeichnis
und natürlich auch ein `.git`-Verzeichnis, welches das Repository beherbergt.

## Solution zu Step 2 - Commits ansehen

Sieh Dir die Commits. 
Achte dabei auf die angezeigten Branches und Tags.


<pre><code>repo $ <b>git log --oneline</b><br><br>bcd8ce5 Created file und-tschuess on branch main by bjoern.<br>ec6319f : Edit file bar at line 5 on branch main by bjoern.<br>03e1bea : Edit file bar at line 1 on branch main by bjoern.<br>95fb57f Edited file hallo-welt on branch main by bjoern.<br>6121b42 Eine Zeile verschieben<br>85f5f20 Noch ein paar neue Zeilen<br>0144fe4 Verschiebe eine  Zeile<br>1178ed1 Created file restaurant on branch main by bjoern.<br>eaa5d5c Kopiere eine Zeile aus 'bar'<br>f9dc882 Erg?nze eine Zeile<br>3592a48 Benenne die Datei im<br>76dd3c1 Erg?nze zwei zeilen<br>5498956 Beginne mit leerer Datei<br>e51b518 Created file bar on branch main by bjoern.<br>7b2a390 Created file hallo-welt on branch main by bjoern.<br><br></code></pre>


## Solution zu Step 3 - Head-Commit untersuchen

Zeige Details zur aktuellen Version,
die im Workspace ausgecheckt ist.


Hier die aktuelle Version `HEAD`:


<pre><code>repo $ <b>git show</b><br><br>commit bcd8ce58de4e1dd12a9c5765f3db1aa791ecf988<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file und-tschuess on branch main by bjoern.<br><br>diff --git a/und-tschuess b/und-tschuess<br>new file mode 100644<br>index 0000000..36fe753<br>--- /dev/null<br>+++ b/und-tschuess<br>@@ -0,0 +1,12 @@<br>+line 0 created<br>+line 1 created<br>+line 2 created<br>+line 3 created<br>+line 4 created<br>+line 5 created<br>+line 6 created<br>+line 7 created<br>+line 8 created<br>+line 9 created<br>+line 10 created<br>+line 11 created<br>\ No newline at end of file<br><br></code></pre>


## Solution zu Step 4 - Vergangene Commits untersuchen

Zeige Details zum Release1.0,
und dann zur Vorgängerversion des Releases 1.0


Hier kommt die 1.0:


<pre><code>repo $ <b>git show release1.0</b><br><br>commit 6121b424ada668dd7b85af1c928fd8e113e1e4ad<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Eine Zeile verschieben<br><br>diff --git a/nachher b/nachher<br>index c35fa99..32b0886 100644<br>--- a/nachher<br>+++ b/nachher<br>@@ -4,6 +4,6 @@ Nach der Umbenennung<br> Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br> Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br> Und eine, die nichts damit zu tun hat.<br>-Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br> dazwischen.<br>+Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br> Ende<br>\ No newline at end of file<br><br></code></pre>



Und hier der Vorgänger davon:


<pre><code>repo $ <b>git show release1.0~1</b><br><br>commit 85f5f20735da688fc2c565b19bb14ddc77beaf01<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Noch ein paar neue Zeilen<br><br>diff --git a/nachher b/nachher<br>index dc66148..c35fa99 100644<br>--- a/nachher<br>+++ b/nachher<br>@@ -3,4 +3,7 @@ Und das ist wohl doch sehr lange her. Wie man sieht.<br> Nach der Umbenennung<br> Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br> Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>-Und eine, die nichts damit zu tun hat.<br>\ No newline at end of file<br>+Und eine, die nichts damit zu tun hat.<br>+Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>+dazwischen.<br>+Ende<br>\ No newline at end of file<br><br></code></pre>


## Solution zu Step 5 - ⭐ Inhalte vergangener Versionen untersuchen

Lasse Dir anzeigen welche Dateien und Verzeichnisse
es im vorigen Commit gab.

Gebe den Inhalt der Datei `bar` so aus,  wie er im vorigen Commit war.


Diese Dateien gab es in `HEAD~1`:


<pre><code>repo $ <b>git ls-tree -r HEAD~1</b><br><br>100644 blob 758676bb62f2032d5a62747409e185a756f5bf93	foo/bar<br>100644 blob c57eff55ebc0c54973903af5f72bac72762cf4f4	hallo-welt<br>100644 blob 32b08868b00465cca451251689dda4c9d83b2d85	nachher<br>100644 blob e69de29bb2d1d6434b8b29ae775ad8c2e48c5391	restaurant<br><br></code></pre>



Und hier der Inhalt von `bar`:


<pre><code>repo $ <b>git show HEAD~1:foo/bar</b><br><br>line 0 created<br>line 1 Edit file bar at line 1 on branch main by bjoern. / Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>line 2 created<br>line 3 created<br>line 4 created<br>line 5 Edit file bar at line 5 on branch main by bjoern. / line 5 created<br>line 6 created<br>line 7 created<br>line 8 created<br>line 9 created<br>line 10 created<br>line 11 created<br><br></code></pre>


## Solution zu Step 6 - ⭐ Commits ansehen: Datei-Statistik

Sieh Dir die Commits an. 
Lase dir dabei die Statistik anzeigen, 
d.h. wie viele Zeilen in welcher Datei geändert wurden.


<pre><code>repo $ <b>git log --stat</b><br><br>commit bcd8ce58de4e1dd12a9c5765f3db1aa791ecf988<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file und-tschuess on branch main by bjoern.<br><br> und-tschuess | 12 ++++++++++++<br> 1 file changed, 12 insertions(+)<br><br>commit ec6319f9be4f5cb3dd0663035bd13231f88c0a34<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file bar at line 5 on branch main by bjoern.<br><br> foo/bar | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit 03e1beabb9af3352369f06cdf4134cac014e735e<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file bar at line 1 on branch main by bjoern.<br><br> foo/bar | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit 95fb57f74c287e4353f5cbc77d01ab8493c92651<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Edited file hallo-welt on branch main by bjoern.<br><br> hallo-welt | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit 6121b424ada668dd7b85af1c928fd8e113e1e4ad<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Eine Zeile verschieben<br><br> nachher | 2 +-<br> 1 file changed, 1 insertion(+), 1 deletion(-)<br><br>commit 85f5f20735da688fc2c565b19bb14ddc77beaf01<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Noch ein paar neue Zeilen<br><br> nachher | 5 ++++-<br> 1 file changed, 4 insertions(+), 1 deletion(-)<br><br>commit 0144fe470559cf1bfb830cc5a50bb8ee8fc9cbb8<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Verschiebe eine  Zeile<br><br> nachher    | 4 +++-<br> restaurant | 1 -<br> 2 files changed, 3 insertions(+), 2 deletions(-)<br><br>commit 1178ed14bb7fb9a2ef33c2dae320b8b0c0f07913<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file restaurant on branch main by bjoern.<br><br> restaurant | 1 +<br> 1 file changed, 1 insertion(+)<br><br>commit eaa5d5c103fb13ff3a47f241af066eed3d776a01<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Kopiere eine Zeile aus 'bar'<br><br> nachher | 3 ++-<br> 1 file changed, 2 insertions(+), 1 deletion(-)<br><br>commit f9dc88232745c99806ea9643503d3f4413686dfa<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Erg?nze eine Zeile<br><br> nachher | 3 ++-<br> 1 file changed, 2 insertions(+), 1 deletion(-)<br><br>commit 3592a48ece41fde23388fd5a45a6ac2a9e9bc620<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Benenne die Datei im<br><br> foo/vorher =&gt; nachher | 0<br> 1 file changed, 0 insertions(+), 0 deletions(-)<br><br>commit 76dd3c1ab5213b696bebe0bb6358f9c2478f3c9e<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Erg?nze zwei zeilen<br><br> foo/vorher | 2 ++<br> 1 file changed, 2 insertions(+)<br><br>commit 5498956d515bfa8324589c53be34845af8d4f77d<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Beginne mit leerer Datei<br><br> foo/vorher | 0<br> 1 file changed, 0 insertions(+), 0 deletions(-)<br><br>commit e51b51846db756759e189fc371af222b22db74c7<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file bar on branch main by bjoern.<br><br> foo/bar | 12 ++++++++++++<br> 1 file changed, 12 insertions(+)<br><br>commit 7b2a3906cd8ee826ad7d207b53a2103f9b2416d7<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    Created file hallo-welt on branch main by bjoern.<br><br> hallo-welt | 1 +<br> 1 file changed, 1 insertion(+)<br><br></code></pre>


## Solution zu Step 7 - ⭐ Herkunft von Zeilen ermitteln

Es geht darum für die Datei `nachher` Folgendes zu ermitteln:

* Für jede Zeile zeigen, in welchem Commit sie zuletzt bearbeitet wurde.
* Innerhalb der Datei wurden Zeilen verschoben. Welche?
* Es wurden auch Zeilen aus anderen Dateien verschoben und kopiert. Welche?


<pre><code>repo $ <b>git blame nachher -s -w</b><br><br>76dd3c1a foo/vorher 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>76dd3c1a foo/vorher 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>f9dc8823 nachher    3) Nach der Umbenennung<br>eaa5d5c1 nachher    4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>0144fe47 nachher    5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>0144fe47 nachher    6) Und eine, die nichts damit zu tun hat.<br>85f5f207 nachher    7) dazwischen.<br>6121b424 nachher    8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>85f5f207 nachher    9) Ende<br><br></code></pre>


Man sieht, in welchem Commit die Zeilen zuletzt bearbeitet wurden, auch über Umbenennungen hinweg.


<pre><code>repo $ <b>git blame nachher -s -w -M --show-number</b><br><br>76dd3c1a foo/vorher 1 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>76dd3c1a foo/vorher 2 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>f9dc8823 nachher    3 3) Nach der Umbenennung<br>eaa5d5c1 nachher    4 4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>0144fe47 nachher    5 5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>0144fe47 nachher    6 6) Und eine, die nichts damit zu tun hat.<br>85f5f207 nachher    8 7) dazwischen.<br>85f5f207 nachher    7 8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>85f5f207 nachher    9 9) Ende<br><br></code></pre>


Die Zeilennummern zeigen, welche Zeilen verschoben wurden.


<pre><code>repo $ <b>git blame nachher -s -w -M -C</b><br><br>76dd3c1a foo/vorher 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>76dd3c1a foo/vorher 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>f9dc8823 nachher    3) Nach der Umbenennung<br>eaa5d5c1 nachher    4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>1178ed14 restaurant 5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>0144fe47 nachher    6) Und eine, die nichts damit zu tun hat.<br>85f5f207 nachher    7) dazwischen.<br>85f5f207 nachher    8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>85f5f207 nachher    9) Ende<br><br></code></pre>


Hier sieht eine Verschiebung aus der Datei `restaurant`.


<pre><code>repo $ <b>git blame nachher -s -w -M -C -C -C</b><br><br>76dd3c1a foo/vorher 1) Diese Zeilen wurden also ganz am Anfang geschrieben.<br>76dd3c1a foo/vorher 2) Und das ist wohl doch sehr lange her. Wie man sieht.<br>f9dc8823 nachher    3) Nach der Umbenennung<br>e51b5184 foo/bar    4) Eine wirklich ziemlich lange Zeile in der Datei 'bar'<br>1178ed14 restaurant 5) Eine sehr lange Zeile aus 'restaurant', die verschoben wird.<br>0144fe47 nachher    6) Und eine, die nichts damit zu tun hat.<br>85f5f207 nachher    7) dazwischen.<br>85f5f207 nachher    8) Eine ebenfalls recht lange Zeile, die demnächst auch verschoben werden soll.<br>85f5f207 nachher    9) Ende<br><br></code></pre>


Hier sieht man, dass Inhalte aus einer anderen Datei `foo/bar` kopiert wurden.

[To the exercise](aufgabe-repository-log-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

