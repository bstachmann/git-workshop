---
layout: page
title: <code>intro-commandline</code>
parent: Exercises

nav_order: 999
---
# Exercise - The `git` command!

In the first exercise, the goal is to get to know
the (Git) Bash command line and especially
the `git` command.

## Tips

* For Windows users:
  - Use the **Git-Bash** command line, then you can run examples
    exactly as shown here.
  - Use '/' instead of '\' for directory paths.
  - If you are working with the Windows command line `CMD`,
    you may need to make minor changes
    for the examples to work.

* Bash commands
  - `cd <directoryname>`, changes to another directory.
  - `cd ..`, changes to the parent directory.
    One level up!
  - `ls` shows the names of the files and subdirectories in the current directory.
  - `ll` Like `ls` but with more details.
  - `less`. Display the content of a file. Scroll with arrow keys. Quit with the `q` key.
  - `pwd` shows the current working directory. On Windows: `pwd -W` (uppercase)

* Git commands
  - `git version` shows which version of Git is installed.
  - `git help <command>` shows help.
  - `git config <property>` shows the value from the configuration.
  - `git config set --global <property> <new-value>`
    sets a value in the configuration.
  - `git config core.editor notepad` configures Notepad as the editor for Git.
  - If the output has more lines than the terminal window is high,
    the output is displayed in a viewer (`less`).
    You can then scroll up and down with the arrow keys.
    You exit the `less` mode with the `q` key.

* Command `start <file>` (Ubuntu: `xdg-open`, Mac Os: `open`)
  opens the specified file with the associated default application.
  `start .` opens the file explorer in the current directory.

[Short intro to the command line](../installation/commandline)

<h2>Step 0 - START <!-- UEB/intro-commandline/0 --></h2>

<h2>Step 1 - Navigation in exercise directories <!-- UEB/intro-commandline/1 --></h2>

Start in directory `git-uebungen`.

(from the unzipped zip file)

Navigate to the subdirectory `aufgaben/intro-commandline/hallo`
and look at the content of the file located there.
Use tab completion to avoid typing so much.
Then navigate back to the parent
directory `intro-commandline`.

<h2>Step 2 - Check Git version <!-- UEB/intro-commandline/2 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline`.

Print which version of Git is installed.

<h2>Step 3 - Help <!-- UEB/intro-commandline/3 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline`.

Show the help page for the `log` command.


<pre><code>$ <b>cd repo</b><br><br><br></code></pre>


<h2>Step 4 - `less` and long outputs <!-- UEB/intro-commandline/4 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline/repo`.

When you run `git log`, 99 commits should be displayed.
Because this does not fit in a terminal window,
the `less` viewer is opened. Close it.
Then use `less some-file.txt` to view a file in `less` mode.

<h2>Step 5 - Configure Git <!-- UEB/intro-commandline/5 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline/repo`.

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


<h2>Step 6 - ⭐ History <!-- UEB/intro-commandline/6 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline/repo`.

Press the 🡅 key several times and then press enter,
to execute one of the previous commands again.
Type `ctrl+r` and then enter `conflict`,
to re-run the command to set `merge.conflictStyle`.

<h2>Step 7 - ⭐ Configure Git editor <!-- UEB/intro-commandline/7 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline/repo`.

Configure an editor for git.
[Tips on this](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config).f
Then test with `git config -e` to see if it worked.

<h2>Step 8 - ⭐ Working directory <!-- UEB/intro-commandline/8 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline/repo`.

Print out which working directory you are currently in.
For Windows users: also test the command with the `-W` option.

<h2>Step 9 - ⭐ Open applications <!-- UEB/intro-commandline/9 --></h2>

Start in directory `git-uebungen/aufgaben/intro-commandline/repo`.

Open the file `some-file.txt` with the default application.
Open a file explorer in the current working directory.


<pre><code>repo $ <b>cd ..</b><br><br><br></code></pre>


[To the solution](loesung-intro-commandline.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

