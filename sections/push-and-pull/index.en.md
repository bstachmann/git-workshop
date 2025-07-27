### Learning Goals (Commands)

```bash
    git fetch
    git pull
    git push
```

---

### Synchronization

```bash
    git fetch      # remote -> local
    git push       # local -> remote
```

Delta transfer

   1. Compares remote ref with the current state
   1. Determines missing commits, trees, and blobs and transfers these objects
   1. Updates remote refs

Notes:

You can also sync with unrelated repositories.

---

How does synchronization work?

---

After cloning, everything is the same.

![After Clone](repo-push-1.png)

---

New commits should be transferred via `push`.

![Before push](repo-push-2.png)

---

Commits have been transferred and refs updated.

![After push](repo-push-3.png)

---

### Push

#### Transfers from the *active branch* to the remote repository.

```bash
git push
```

Or more specifically:

```bash
git push origin master
```

Note: `origin master` (remote + local branch) not `origin/master`

---

### Fetch

#### Fetches *all branches* from the remote repository.

Synchronizes and updates remote refs.

Workspace and active branch remain unchanged.

```bash
    git fetch
    git fetch origin
```

---

### Pull

A combination command

```bash
git pull
```

 1. Fetch changes (`git fetch`)
 1. Apply changes to the current branch \
    (`git merge`, next chapter).

---

<iframe src="markdown-git-uebungen/aufgabe-zusammenarbeit-push-fetch-pull.html" width="100%" height="600px" ></iframe>

---

### Push rejected

---

![Push reject 1](push-reject-1.png)

[Push Reject](repo-push-rejected.svg)

---

![Push reject 2](push-reject-2.png)

---

### Push rejected

> Rule of thumb: Never destroy history!

All commits that were previously in the branch's history must still be there afterward.

Technically: When pushing, the new commit must be a descendant of the previous one!

-> The conflict must now be resolved locally!

---

<iframe src="markdown-git-uebungen/aufgabe-zusammenarbeit-push-rejected.html" width="100%" height="600px" ></iframe>


