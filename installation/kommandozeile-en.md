---
layout: page
title: Command Line
description: Working with Bash
nav_order: 30
parent: Installation (en)
permalink: /installation-en/kommandozeile
---

Git is designed as a command line tool. There are excellent graphical user interfaces for Git.
But these ultimately just execute the underlying command line commands.
To understand Git well, it is therefore recommended to learn the central Git commands.

## Open Shell/Terminal

 * Windows: WIN+d "Git-Bash"
 * MacOs: CMD+Space "Terminal"
 * Ubuntu: SUPER "Terminal"

## Navigation and overview in directories

 * `.` current directory
 * `..` parent directory

```bash
 # List files and subdirectories
 $ ll
 $ ll foo/
 $ ll -a     # also show hidden files

 # Show current directory
 $ pwd

 ## Go to parent directory
 $ cd ..

 ## Go to subdirectory
 $ cd foo

 ## Create directory
 $ mkdir mydirectory

```

## Autocomplete and command history

Often it's enough to type a few characters and then let it complete

 * 1x Tab key: Completes command/file path/branch/... if unambiguous.
 * 2x Tab key: Shows options if not unambiguous.

With the **up/down arrow keys** you can **retrieve previous commands** and possibly edit them and then execute them again with the Enter key.

Pro tip: With ctrl+r you can search in previous commands. With Enter you can accept the search result, with another ctrl+r you can search again, with the esc key you can cancel the search.

## Scrolling in long outputs

When Git commands produce long outputs, you enter a scroll/pager mode.

```bash
 $ git log
...
commit 71ca726ddcbbedc901e8a8b1cc3a5b5a346c96b5
Author: bstachmann <bstachmann@yahoo.de>
Date:   Thu Mar 17 19:25:00 2022 +0000

    Directory Listings updated.

:
```
You can recognize the scroll mode by the "`:`" in the last line.

 * Up/Down key for scrolling
 * **q** key to exit

## Git-Bash on Windows

```bash
    # Output current path in Windows syntax
    $ pwd -W

    # Open explorer
    $ start . 
    $ start index.html
```