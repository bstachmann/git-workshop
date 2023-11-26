## Tags

Tag sind Namen für Commits, wie zum Beispiel

 * `v1.3.2` als Releaseanme (Semantic Versioning)
 * `tested-2023-10-30-20-12-16` zur Markierung getesteter Versionen
 * `good`, `bad` als temporäre Markierungen zum Debuggen

---

## `git tag`

**Light weight tags** sind einfach Namen für Commits.

```bash
    git tag v.1.0
    git tag b7ee6339d12 v0.7
```

**Annotated Tags** enthalten zusätzliche Metadaten (Tagger, Datum, Beschreibung und ggf. PGP-Signatur)

```bash
    git tag v.1.1 --annotate -m "Beschreibung"
    git tag v1.2 --annotate --sign
```

**Empfehlung**: Nutze *annotated Tags* für Releases, *light weight Tags* für lokale temporäre Tags, z.B. zum Enwickeln oder Debuggen.

---

## Fallstrick: Tags (besser nicht) ändern

*Tags* sind sind Git als *feststehende* Namen für Commits konzipiert.

*Veränderliche* Namen für Commits nennt man in Git *Branches*

Git-Befehle (`tag`, `push`, `pull`) warnen bevor tags überschrieben werden.
Man dies mit der Option `-f` übergehen (wenn man weiß, was man tut)

