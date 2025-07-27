Git stores version states \
in **commits** \
(also called revisions)

---

A **commit** contains a

**Tree** ("Snapshot" of all project files)

and **Metadata**

 * Description (commit message)
 * Timestamp of the change
 * Author (and possibly committer)
 * **Parent(s)** - Reference to previous version(s)

---

## `git show`

Displays information about a commit.

```bash
$ git show           # Shows the current commit

commit 612a0ee90fedcfcfce170e568ba9607f41655f0c (HEAD -> master)
Author: bjoern <kapitel26blog@gmail.com>
Date:   Thu Jul 29 00:00:00 2021 +0000

    Created file und-tschuess on branch master by bjoern.

diff --git a/und-tschuess b/und-tschuess
new file mode 100644
index 0000000..36fe753

 ...

```

Shows revision hash, **metadata** (author, timestamp, message, etc.), and then lists all changes to the predecessor (**diff**).

---

With `--stat`, `git show` only displays the number of changed lines per file,
but not the contents.

```bash
$ git show --stat
commit 612a0ee90fedcfcfce170e568ba9607f41655f0c (HEAD -> master)
Author: bjoern <kapitel26blog@gmail.com>
Date:   Thu Jul 29 00:00:00 2021 +0000

    Created file und-tschuess on branch master by bjoern.

 und-tschuess | 12 ++++++++++++
 1 file changed, 12 insertions
```

`--oneline` shortens the metadata to one line:

```bash
$ git show --stat --oneline
612a0ee (HEAD -> master) Created file und-tschuess on branch master by bjoern.
 und-tschuess | 12 ++++++++++++
 1 file changed, 12 insertions(+)
```

---

**Revision Hash** - the "version number" in Git \
Checksum over all the above information.

---

### `HEAD`

Refers to the current commit,\
is the default value for many commands\
and can often be omitted.

```bash
    git show HEAD                # Info about the HEAD commit
    git show                     # Same
```

---

## Commands to Inspect Commits

```bash
    git show HEAD:README         # Content of a file
    git show --pretty=raw HEAD   # What Git has in the DB

    # ls-tree lists directories for inspection
    git ls-tree -r HEAD
    git ls-tree --abbrev HEAD src/main/java
```

---

## Addressing Ancestors with **`~`**

Every commit (except the first) has a parent commit.

```bash
$ git show HEAD~    # Parent of HEAD
$ git show HEAD~2   # Parent of the parent of HEAD

$ git show fb3982~2   # Parent of the parent of fb3982
```


