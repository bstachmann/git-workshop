## Pushing Tags

Tags are not automatically transferred during a push.
They must be explicitly published.

```bash
    git push origin v1.0
    git push --tags
```

## Pulling Tags

When pulling, only the tags for the commits being transferred are fetched.
To fetch all tags, you must specify `--tags`.

---

## Do Not Modify Tags

**Recommendation**: Do not modify tags that have been shared with others.
For markers that need to be updated, either use branches (`latest-success`)
or tag names with timestamps (`success-20231030203501`).
`describe` can determine the latest tag:

```bash
    git describe --tags --match="success-*"
```

---

<iframe src="markdown-git-uebungen/aufgabe-zusammenarbeit-tags.html" width="100%" height="600px" ></iframe>

