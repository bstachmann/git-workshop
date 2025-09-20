---
layout: page
title: <code>zusammenarbeit-rebasing-en</code>
parent: Solutions

nav_order: 15
---
## Solution to Step 0 - START

## Solution to Step 1 - Feature-Branch per Rebase aktualiseren.

Auf dem main gibt es Neuerungen.

Lasse Dir den Commit-Graphen über alle Branches zeigen.

Aktualisiere Deinen Feature-Branch.

Lasse Dir den Commit-Graphen über alle Branches zeigen.


<pre><code>repo $ <b>git log --graph --all --decorate --oneline</b><br><br>* 796a63e (HEAD -&gt; feature) : Feature weitermachen.<br>* e65c718 : Feature anfangen.<br>| * 57f8edc (main) : Neuerung auf dem main<br>|/  <br>* 097f971 Created file bar on branch main by bjoern.<br>* 9799da6 Created file foo on branch main by bjoern.<br><br></code></pre>



<pre><code>repo $ <b>git rebase main</b><br><br>Rebasing (1/2)<br>Rebasing (2/2)<br>Successfully rebased and updated refs/heads/feature.<br><br></code></pre>



<pre><code>repo $ <b>git log --graph --all --decorate --oneline</b><br><br>* 7d06138 (HEAD -&gt; feature) : Feature weitermachen.<br>* a40b485 : Feature anfangen.<br>* 57f8edc (main) : Neuerung auf dem main<br>* 097f971 Created file bar on branch main by bjoern.<br>* 9799da6 Created file foo on branch main by bjoern.<br><br></code></pre>


[To the exercise](aufgabe-zusammenarbeit-rebasing-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

