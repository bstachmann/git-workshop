### Learning Objective (Commands)

```bash
    # Create commits
    git status
    git diff
    git commit

    # Add changes (Staging, Index)
    git add
    git commit -a

    # Mark commits with tags
    git tag

    # Oops!
    git stash
    git revert
```

---

### The Workspace

Includes all files and directories of the project

 * **Versioned files**
   Files already known in the latest Git revision of the project,
   called `HEAD`.
 * **Unversioned files**
   New files that Git "does not yet know".
 * **Ignored files**
   Files that should not be versioned at all (keyword: `.gitignore`)

---

### `git status`

Shows what is happening in the workspace:

  * Which is the *active branch*?
  * Have files (relative to `HEAD`)
    - been deleted?
    - been edited?
    - been newly created?
  * Additionally: Merge conflicts, sync status

Notes:

 * Directories are summarized
 * Also shows changes relative to HEAD or Index

---

### Tip

Before important operations,

always check if the status is *clean*:

```bash
    $ git status
      ...
    nothing to commit, working tree clean
```

Notes:

 * Hints about stash
 * TODO: Hint about prompts

---

### Active Branch

 * A branch is a pointer to a commit
 * (At most) 1 branch is active
 * Default `master`
 * New commit: Pointer of the active branch is updated.

---

## `git commit`

 * Creates a new commit
 * Sets `HEAD` to the new commit
 * Sets the active branch to the new commit

---

### Commit - Modified Files

Single file:

    git commit <file>

All modified files that are already versioned:

    git commit -a

And directly with a message:

    git commit -am "Edit some files."

---

### Commit - New Files

New files are not automatically included in `commit -a`. They must first be staged.

    git add <file>

    git add <dir>

    git add .

Then commit as usual.

    git commit

---

### Commit - Deleted Files

    rm my-file # Or via file explorer

Deletions are included in `-a`:

    git commit -am 'deleted my-file'

There is also a Git command for deletion:

    git rm my-file
    git commit -am 'deleted my-file'

---

## Directories

Directories are not explicitly versioned in Git.

They are (in the *Tree*) represented when files are added.

A directory must contain at least one file.

If necessary, create a hidden file, e.g., `.gitkeep`,
to enforce a directory.

