## Tags

Tags are names for commits, such as:

 * `v1.3.2` as a release name (Semantic Versioning)
 * `tested-2023-10-30-20-12-16` to mark tested versions
 * `good`, `bad` as temporary markers for debugging

---

## `git tag`

**Lightweight tags** are simply names for commits.

```bash
    git tag v.1.0
    git tag b7ee6339d12 v0.7
```

**Annotated Tags** contain additional metadata (tagger, date, description, and optionally PGP signature)

```bash
    git tag v.1.1 --annotate -m "Description"
    git tag v1.2 --annotate --sign
```

**Recommendation**: Use *annotated tags* for releases, *lightweight tags* for local temporary tags, e.g., for development or debugging.

---

## Pitfall: Do Not Modify Tags

*Tags* are designed in Git as *fixed* names for commits.

*Mutable* names for commits are called *branches* in Git.

Git commands (`tag`, `push`, `pull`) warn before overwriting tags.
You can override this with the `-f` option (if you know what you're doing).

