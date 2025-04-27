### Reminder: Ref - Pointer to a Commit

Branches are pointers to commits, e.g., `myfeature`, `master`.

---

### Remote Refs

#### Knowing what's happening in other clones

*Remote Refs* represent the state of *Refs* in other repositories.

```bash
git show master               # local state
git show origin/master        # origin after last sync
```

*Remote Refs* are updated during `clone`, `fetch`, and `pull`.

If multiple remotes are declared (not just `origin`), there are also multiple sets of *Remote Refs*.

---

### Remote Refs - Ahead/Behind

*Remote Refs* allow comparing local states with remote repositories.

```bash
    $ git status

    On branch master
    Your branch is ahead of 'origin/master' by 1 commit.

    $ git diff master origin/master

    $ git log origin/master..master   # ahead
    $ git log master..origin/master   # behind
```




