# Tips & Tricks


---


## Learning Goals

```
    add / reset
```

 * Use `.gitignore` to exclude files
 * Staging or "the index"
 * Troubleshooting.
   Various scenarios.


---

## Keep Files Untracked
   - `.gitignore` 21


---

## Staging

   - `diff --staged`
   - `reset`
   - Selective Staging (Hunks)

---

## Fix Commits Retroactively

```bash
# Change commit message
git commit --amend

# Add forgotten file
git add forgotten

# Retry the commit
git reset HEAD~1
```

---

## Miscellaneous

   - `reset --hard HEAD`
   - `reflog` 27
     - `log --walk-reflogs`

