
## Branch

 * Branches sind lokal, werden nicht direkt übertragen
 * Remote Tracking Branches sind Stellvertreter
    git branch -r
 * Pull holt Änderungen von einem Remote Branch in den aktiven Branch
 * Push überschreibt einen Branch in einem andern Repository
   (sofern erlaubt).

---

---

### Erinnerung: Ref - Zeiger auf ein Commit

Branches sind Zeiger auf Commits, z. B. `myfeature`, `master`


---

### Remote Refs

*Remote Refs* repräsentieren den Stand der *Refs*, insbesondere Branches,
im einem anderen Repository beim Klonen bzw. der letzen Synchronisation).

```bash
git show master               # lokaler Stand
git show origin/master        # origin nach letztem Synch
```


---

### Remote Refs - Ahead/Behind

*Remote Refs* ermöglichen, lokale Stände mit fernen Repository zu vergleichen.

```bash
    $ git status

    On branch master
    Your branch is ahead of 'origin/master' by 1 commits.

    $ git diff master origin/master

    $ git log origin/master..master   # ahead
    $ git log master..origin/master   # behind
```





---

## Branch

```bash
git pull other-repo other-branch
git push other-repo other-branch
```

Wenn ein *upstream* konfiguriert ist, kann man die Parameter weglassen

```bash
git push --set-upstream origin new-branch

git pull
git push
```


