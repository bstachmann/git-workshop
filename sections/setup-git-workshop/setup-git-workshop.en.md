**Hello dear Git workshop participants,**

It is a good idea to prepare your working environment before the workshop so that we don't spend too much time on setup topics at the beginning and can dive into the really exciting content faster. I have summarized a few steps here that you can carry out in advance.

> Feel free to contact me via email or Teams if you encounter problems during setup.
> But: Don't panic! If necessary, we can still manage it on the first morning.

### 1. Install Git

First of all, we need Git, of course. Install it (https://git-scm.com/downloads), or have it installed (if your computer is managed by someone else). If you are installing on Windows, the installer will offer you several options to choose from. Just take the default options unless you have specific requirements for the installation.

### 1b. (Windows only) Open Git-Bash

Press the Windows key and then type `Git-Bash` (or click on the icon left by the installer). A terminal for Git-Bash should open. *Info*: We will use `bash` for the (command line) examples in this workshop because it works well on Windows, Linux, and Mac OS. Experienced users are, of course, welcome to use their favorite shell, e.g., `zsh` or `powershell`.

### 2. Check Git version

Open a terminal and type `git version`. If Git outputs a different version number for you, no problem: The main thing is that Git is there.


```bash 
    $ git version
    git version 2.27.0
```


### 3. Set up a working directory

Now set up a directory where you can work during the workshop:

```bash
    $ mkdir gitworkshop
    $ cd gitworkshop
```

Tip for Windows users: With `start .` you can also open a File Explorer window for this directory.

### 4. Download and unpack exercises

You can download the exercises as a ZIP file (https://github.com/bstachmann/git-workshop/releases/latest/download/git-uebungen.zip), place it in the directory mentioned above, and unpack it there. There should then be a folder `git-uebungen` with subfolders for `aufgaben` and `loesungen`:

    $ ls -1 git-uebungen
    aufgaben
    index.html
    loesungen

### 5. Clone a Git project

Try cloning the workshop project:

    $ git clone https://github.com/bstachmann/git-workshop.git

Note: Sometimes there can be firewall or other network problems if you are in a corporate network.

Best regards,

Bjørn Stachmann







