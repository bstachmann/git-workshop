# Renames, Moves, and Copies

---

## Rename Detection

The data model of Git knows nothing about renames...

---

...but Git will find them if you want:

```bash
    git log --find-renames=90% -- some-files
    git log -M -- some-file
    git log -M99% -- some-file

    git log --find-copies=90% -- some-files
    git log -C -- some-files
    git log -C --find-copies-harder

    git annotate -C -M some-file
    git merge
```

