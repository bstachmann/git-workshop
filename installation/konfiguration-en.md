---
layout: page
title: Configuring Git
nav_order: 10
parent: Installation (en)
permalink: /installation-en/konfigurieren
---

### Configure Git

Check if username and email are already set.

```bash
    $ git config --global user.name
    davinci
    $ git config --global user.email
    leonardo.davinci@italia.it
```

If not, enter your data like this:

```bash
    $ git config --global user.name <my-name>
    $ git config --global user.email <my-email>
```

### (Optional) Configure default branch name

```bash
 git config --global init.defaultBranch main
```
### (Optional) Configure merge behavior

For the exercises I recommend the following settings,
so that your output corresponds to those in the recorded sample solutions.

```bash
    $ git config --global pull.rebase false    
    $ git config --global merge.conflictStyle diff3
```

### (Optional) Text editor

Configure editor for commit messages etc., here e.g. `notepad`:

```bash
    $ git config --global core.editor notepad
```

Tip: [Example configurations for popular editors](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config). Scroll down a bit on the page.


### (Optional) Select merge and diff tool


And if you have Tortoisegit installed:

```bash
    $ git config --global merge.tool tortoisemerge

    $ git config --global diff.tool tortoisediff
    $ git config --global difftool.tortoisediff.cmd "TortoiseGitMerge \$LOCAL \$REMOTE"
```

More about this on [stackoverflow](https://stackoverflow.com/questions/16493368/can-tortoisemerge-be-used-as-a-difftool-with-windows-git-bash)