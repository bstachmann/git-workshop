# Rename Detection

---

## What is Rename Detection?

Git's data model does not inherently track renames, but it can detect them when needed.

---

## Commands for Rename Detection

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


