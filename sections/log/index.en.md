### Revision Hashes

The version numbers of Git

Versions in Git can be addressed via their revision hashes
or via symbolic names (Refs).

```bash
    # Revision Hashes
    git show f6be3b8913aa0ff3daa2be27bd55032316545545
    git show f6be3b      # can be abbreviated

    # Refs
    git show HEAD        # "current" version
    git show master      # a branch
    git show v1.0.0      # a tag
```

---

## The Log

---

### The `log` command shows the commits

```bash
    $ git log --oneline

    909af6d (HEAD -> master) Fix obsolete text on page
    02d3329 fix typo in link
    38efbcb Enable offline use
    28e7071 Enable offline use
    6721664 Overwork repository chapter
    2ca78c1 Remove duplicated slides
    330fd73 Fix missing git before command
    ...
```
Insight: The repository we cloned contains the entire project history.

---

Except for the very first one, all commits have a parent.
The set of all ancestors of a commit, e.g., `master,` is called **the log**.
It includes all commits that contributed to the creation of the current commit.

`git log master`

---

The log command offers numerous options. Here are some useful examples:

```bash
    # log shows the history
    git log HEAD
    git log HEAD -- README    # history of a file
    git log --oneline HEAD
    git log --graph HEAD

    git show HEAD~2          # second-to-last commit
```

Tip: With `~` you can address ancestors.

---

### The Commit Graph

The log can contain branches and merges,
e.g., when multiple developers worked in parallel.

```
* | 5c65d40 Notes for review
* | 040bb7d Added schedule for early birds
|/  
* b1fae20 Fixup
* 4137535 Add some tasks
* 8f900ba Refactor: Split git intro 
*   351872f Merge branch 'master' 
|\  
| * c81fde8 Update index.en.md
* | 9bf4c61 Add workshop: Git basics and best practices
|/  
* 5f58070 Modify link to edit files on github
```

---

The `--graph` option can represent this:

```bash
    git log --graph             # display graphs
    git log --graph --oneline   #  
    git log --graph --all       #

```

---

### Comparing Commits with Diff

The diff command can compare the files (trees) of any commits.

```bash
    # diff compares two commits
    git diff HEAD~4 HEAD
    git diff 1a8a2 9f5c3 -- content.md   # single file
    git diff 1a8a2 9f5c3 --stat         # overview
    git diff 1a8a2 9f5c3 --word-diff    # word-wise comparison for texts
    git diff 1a8a2 9f5c3 -b             # ignore whitespace changes
    git diff HEAD~3                     # compare with HEAD

    # use external tool
    git difftool HEAD~4 HEAD
```

---

### `git blame`: Who did it?

Shows, for each line, in which commit it was last edited.

```
38da02ef foo (bjoern 2021-04-02 14:54:30 +0000 1) First line
9bb1b769 foo (bjoern 2021-07-29 17:03:01 +0000 2) Second line
21c9ad44 foo (bjoern 2021-07-29 17:15:19 +0000 3) End
```

 * `-M -C -C -C` Shows the "origin commit" for copied/moved lines from other files. 
 * `-w` recognizes lines despite whitespace changes.

---

<iframe src="markdown-git-uebungen/aufgabe-repository-log.html" width="100%" height="600px" ></iframe>



