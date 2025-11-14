---
layout: page
title: <code>intro-commandline</code>
parent: Solutions

nav_order: 999
---
## Solution to Step 0 - START

## Solution to Step 1 - Navigation in exercise directories

(from the unzipped zip file)

Navigate to the subdirectory `aufgaben/intro-commandline/hallo`
and look at the content of the file located there.
Use tab completion to avoid typing so much.
Then navigate back to the parent
directory `intro-commandline`.


<pre><code>git-uebungen $ <b>ls</b><br><br>aufgaben  aufgaben.json  loesungen  ueberblick.html  ueberblick.md<br><br></code></pre>



<pre><code>git-uebungen $ <b>cd aufgaben</b><br><br><br></code></pre>



<pre><code>aufgaben $ <b>cd intro-commandline</b><br><br><br></code></pre>



<pre><code>intro-commandline $ <b>cd hallo</b><br><br><br></code></pre>



<pre><code>hallo $ <b>ls</b><br><br>herzlich-willkommen.txt<br><br></code></pre>



<pre><code>hallo $ <b>cd ..</b><br><br><br></code></pre>


## Solution to Step 2 - Check Git version

Print which version of Git is installed.


<pre><code>$ <b>git version</b><br><br>git version 2.51.1<br><br></code></pre>


## Solution to Step 3 - Help

Show the help page for the `log` command.


<pre><code>$ <b>git help log</b><br><br>GIT-LOG(1)                                                        Git Manual                                                        GIT-LOG(1)<br><br>NAME<br>    git-log - Show commit logs<br>...<br><br></code></pre>


## Solution to Step 4 - `less` and long outputs

When you run `git log`, 99 commits should be displayed.
Because this does not fit in a terminal window,
the `less` viewer is opened. Close it.
Then use `less some-file.txt` to view a file in `less` mode.


<pre><code>repo $ <b>git log</b><br><br>commit 5e14e1dc688e7a2cd02c9ccad3dedf397d407e2e (HEAD -&gt; main)<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file some-file.txt at line 3 on branch main by bjoern.<br><br>commit 41984e9ac879b9b56c8e91228a8d5887bca228fd<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file some-file.txt at line 3 on branch main by bjoern.<br><br>commit 99399d263ccc8fe4a1bc59a49c93147b17115518<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file some-file.txt at line 3 on branch main by bjoern.<br><br>commit df80cb240781a015f2f0ad62a48fc42964fdfe8b<br>Author: bjoern &lt;kapitel26blog@gmail.com&gt;<br>Date:   Thu Jul 29 00:00:00 2021 +0000<br><br>    : Edit file some-file.txt at line 3 on branch main by bjoern.<br>:<br><br></code></pre>


Quit with `q`


<pre><code>repo $ <b>less some-file.txt</b><br><br>Editet in Commit 99<br>line 1 created<br>line 2 created<br>line 3 created<br>line 4 created<br>line 5 created<br>line 6 created<br>line 7 created<br>line 8 created<br>line 9 created<br>line 10 created<br>line 11 created<br><br></code></pre>


Quit with `q`

## Solution to Step 5 - Configure Git

Check the user configuration:

    $ git config user.name
    $ git config user.email
    $ git config pull.rebase
    $ git config merge.conflictStyle
    $ git config --global init.defaultBranch

Configure your username and email,
if not already set:

    $ git config --global user.name my-name
    $ git config --global user.email my-email

The following configurations were used when recording the
sample solution.
It is recommended to set them for this workshop:

    $ git config --global pull.rebase false
    $ git config --global merge.conflictStyle diff3
    $ git config --global init.defaultBranch main



<pre><code>repo $ <b>git config --global user.name mein-name</b><br><br><br></code></pre>



<pre><code>repo $ <b>git config --global user.email meine-email</b><br><br><br></code></pre>



<pre><code>repo $ <b>git config --global pull.rebase false </b><br><br><br></code></pre>



<pre><code>repo $ <b>git config --global merge.conflictStyle diff3</b><br><br><br></code></pre>



<pre><code>repo $ <b>git config --global init.defaultBranch main</b><br><br><br></code></pre>


## Solution to Step 6 - ⭐ History

Press the 🡅 key several times and then press enter,
to execute one of the previous commands again.
Type `ctrl+r` and then enter `conflict`,
to re-run the command to set `merge.conflictStyle`.


<pre><code>repo $ <b>git config --global user.email meine-email</b><br><br><br></code></pre>



<pre><code>repo $ <b>git config --global merge.conflictStyle diff3</b><br><br><br></code></pre>


## Solution to Step 7 - ⭐ Configure Git editor

Configure an editor for git.
[Tips on this](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config).f
Then test with `git config -e` to see if it worked.


<pre><code>repo $ <b>git config --global core.editor notepad</b><br><br><br></code></pre>



<pre><code>repo $ <b>git config -e</b><br><br><br></code></pre>


## Solution to Step 8 - ⭐ Working directory

Print out which working directory you are currently in.
For Windows users: also test the command with the `-W` option.


<pre><code>repo $ <b>pwd</b><br><br>/workspaces/git-workshop/build/git-uebungen-en/loesungen/intro-commandline/repo<br><br></code></pre>


## Solution to Step 9 - ⭐ Open applications

Open the file `some-file.txt` with the default application.
Open a file explorer in the current working directory.


<pre><code>repo $ <b>start some-file.txt</b><br><br><br></code></pre>



<pre><code>repo $ <b>start .</b><br><br><br></code></pre>


[To the exercise](aufgabe-intro-commandline-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

