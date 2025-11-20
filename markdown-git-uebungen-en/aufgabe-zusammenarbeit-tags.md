---
layout: page
title: <code>zusammenarbeit-tags</code>
parent: Exercises

nav_order: 999
---
# Exercise - Tags


## Tips

* Create tags
  - `git tag 'my-first-tag'`
  - optionally a revision can be specified (default: `HEAD`)
* Simple tags are just names for commits
* For releases, one uses *annotated tags*, which carry a description and metadata.
  The following options are helpful:
  - `-a` ensures the creation of an *annotated tag*.
  - `-m 'And here comes text'` for the description
* Tags are not automatically transferred on *push*.
   - You can either specify individual tags, e.g. `git push origin v1.0 v1.1`
   - `git push --tags` transfers tags
* Tags are usually transferred on pull.
  With `--tags` you can have all tags transferred.
* Recommendation: Tags that you share with others (push),
  should not be changed anymore.
  Git warns before transferring changed tags.
  If necessary, you can force the transfer with `-f`.
            
## Setup
                  

<h2>Step 0 - START <!-- UEB/zusammenarbeit-tags/0 --></h2>


<pre><code>$ <b>cd mein-klon</b><br><br><br></code></pre>


<h2>Step 1 - Create tags <!-- UEB/zusammenarbeit-tags/1 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

Create a simple tag `simple1` on `HEAD` and
an annotated tag `annotated1` on `HEAD~1`.
First look at the log and then at both tags individually (`git show an`).

<h2>Step 2 - Fetch tags <!-- UEB/zusammenarbeit-tags/2 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

Simply by pull.

<h2>Step 3 - Push tags <!-- UEB/zusammenarbeit-tags/3 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

A simple `git push` does not transfer tags.
First, specifically transfer the tag `simple1` with a push
and then all other tags with another push

<h2>Step 4 - Manipulate <!-- UEB/zusammenarbeit-tags/4 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-tags/mein-klon`.

Overwrite the tag `v0.1` so that it points to `HEAD`.
Push the tag.
Go to the directory `../anderer-klon` and fetch the tag with pull.
Look at the log to verify that the tag has been updated.


<pre><code>mein-klon $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-tags.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

