## Upstream Configuration

---

The commands `push` and `pull` expect\
two parameters `<repository>` and `<branch>` (or refspec).

    git pull origin main

For a parameterless call `git pull`, an *upstream configuration* can be set:

```ini
[branch "main"]
	remote = origin
	merge = refs/heads/main
```

---

You usually don't need to set *upstream configuration* manually.

When using a *remote branch*, `git switch <branchname>` automatically creates it.

When creating a new branch, this can be enforced during the first push:

```bash
git push --set-upstream <repo> <branch>
```

---

## Managing Branches

```bash
    # Which branches have already been merged?
    git switch master
    git branch --merged

    # Delete a branch
    git branch -d some-branch
```

[Cleaning up Branches](https://kapitel26.github.io/git/2014/03/31/alte-branches-archivieren.rb.html)
[Mirroring](https://kapitel26.github.io/git/2014/04/04/branches-aufrauemen.rb.html)


---

<iframe src="markdown-git-uebungen/aufgabe-zusammenarbeit-branching-fortgeschritten.html" width="100%" height="600px" ></iframe>



---

<iframe src="markdown-git-uebungen/aufgabe-zusammenarbeit-reverting.html" width="100%" height="600px" ></iframe>


