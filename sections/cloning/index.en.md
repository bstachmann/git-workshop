### Cloning

The clone command allows repositories to be cloned.
All objects (blobs, commits, branches, tags) are copied.
A workspace is initialized with the `HEAD` state.

```
$ git clone https://<server>/<path>/git-training-protocol.git
```

---

Why does\
the cloned repository\
contain the entire history of the project?

---

## Repository URLs

Specify where a Git repository is located.

```
myrepos/sample                    # Local path to the repo
myrepos/sample.git                # Local path to a bare repo

ssh://me@myserver/sample.git      # SSH
me@myserver:sample.git            # also SSH

https://me@myserver/sample.git    # HTTPS
```


Notes:

There are more possibilities.



---


### Cloning

The clone command allows repositories to be cloned. All
objects (blobs, commits, branches, tags) are copied.

```
$ git clone https://<server>/<path>/git-training-protocol.git
```

---

### Cloning - Bare Repository

 * Bare repository: `clone --bare` creates a repository without a workspace

---


### Cloning - Performance

 * Local clones (fast)
 * Tip: `--reference` (Faster cloning for large repos)



---

<iframe src="markdown-git-uebungen/aufgabe-repository-klonen.html" width="100%" height="600px" ></iframe>

---

## Remote Repositories

Show where the repository was cloned from (`origin`)

```bash
git remote -v

git remote add my-backup /backup/sample-repo.git
```
