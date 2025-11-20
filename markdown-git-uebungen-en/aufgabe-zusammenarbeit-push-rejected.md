---
layout: page
title: <code>zusammenarbeit-push-rejected</code>
parent: Exercises

nav_order: 999
---
# Exercise - Dealing with "Push Reject"

 
When multiple developers work on the same project,
the message `error: failed to push some refs ...`
often occurs during `git push`,
the so-called *Push Reject*.

**This is not a bad thing.**
It simply means that in the `origin` repository
commits were found
that are not yet integrated locally.

You can fetch and integrate the changes with `git pull`.

Or you can first fetch the changes with `git fetch`
to examine them, and later decide
what you want to do with them.

## Tips

 * `git push`: Transfers commits to `origin`.
 * `git fetch`: Fetches commits, but does not change the workspace and local branch
 * `git pull`: Fetches and **integrates** commits.
 * `git log A..B` shows "what B did".\
    Or more precisely: Those commits from the history of `B`
    that are not yet contained in `A`.
 * `git diff A B` shows the differences between A and B\
   (symmetrical diff)
 * `git diff A...B` shows the changes of side B.\
    Or more precisely: The diff between the last common ancestor and B.\
    (asymmetrical diff)

## Setup

 * You are working on a project `apollo`,
   that was created by your colleague Anja.
 * You are supposed to improve the file `frontend.java`,
   while Anja continues to work on the file `backend.java`.

If Anja uploads her changes before you,
you will experience a *Push Reject*.

### Directories

 * `./` Main directory for this exercise
   - `blessed-apollo.git/` The shared (blessed) repository is here.
   - `anjas-apollo/` Anja works here.
   - `my-apollo/` **You work here.**

<h2>Step 0 - START <!-- UEB/zusammenarbeit-push-rejected/0 --></h2>


<pre><code>$ <b>cd my-apollo</b><br><br><br></code></pre>


<h2>Step 1 - Create local commit(s) <!-- UEB/zusammenarbeit-push-rejected/1 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-push-rejected/my-apollo`.

Edit the file `frontend.java` and create (at least) one commit with the changes.
Then check with `git status` if the workspace is clean.

<h2>Step 2 - Try to push <!-- UEB/zusammenarbeit-push-rejected/2 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-push-rejected/my-apollo`.

Now try to push your changes.

<h2>Step 3 - (optional) Analyze problem <!-- UEB/zusammenarbeit-push-rejected/3 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-push-rejected/my-apollo`.

First fetch the changes without integrating (`fetch`),
and let *Anja's* changes be shown to you.
 
 * Which commits did Anja make (`log`)?
 * What are the differences between your and Anja's version (symmetrical `diff`)?
 * What changes did Anja make (asymmetrical `diff`)?

<h2>Step 4 - Integrate foreign changes <!-- UEB/zusammenarbeit-push-rejected/4 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-push-rejected/my-apollo`.

Integrate the changes with pull and then look at the commit graph.

<h2>Step 5 - Push again <!-- UEB/zusammenarbeit-push-rejected/5 --></h2>

Start in directory `git-uebungen/aufgaben/zusammenarbeit-push-rejected/my-apollo`.

                    


<pre><code>my-apollo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-zusammenarbeit-push-rejected.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

