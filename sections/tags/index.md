## Tags

Tag sind Namen für Commits, wie zum Beispiel

 * `v1.3.2` als Releaseanme (Semantic Versioning)
 * `tested-2023-10-30-20-12-16` zur Markierung getesteter Versionen
 * `good`, `bad` als temporäre Markierungen zum Debuggen

---

## `git tag`

Das erstellen von Tags ist einfache

```bash
    git tag v.1.0
    git tag b7ee6339d12 v0.7
```

Neben diesen einfachen (light weight) Tags gibt es auch *annotated* Tags, 
denen man Beschreibung oder digitale Signaturen anfügen kann.

```bash
    git tag v.1.1 --annotate -m "Beschreibung"
    git tag v1.2 --annotate --sign
```

**Empfehlung**: Nutze *light weight*-Tags für temporäre Tags.
*Annotated*-Tags für Releases.

---

## Fallstricke

Tags werden beim Push nicht automatisch übertragen.
Sie müssen explizit veröffentlicht werden.

```bash
    git push orgin v1.0
    git push --tags
```

Beim Pull werden nur die Tags zu den Commits die übertragen werden geholt.
Möchte man alle Tags holen muss man `--tags` angeben.

---

## Tags nicht verändern

**Empfehlung**: Tags, nachdem man sie gepushed hat, nicht mehr verändern.
Für Markierungen die aktualisiert werden sollen entweder einfach Branches nutze (`latest-success`)
oder Tagnamen mit Timestamp versehen (`success-20231030203501`). 
`describe` kann das jeweils letzte Tag ermitteln:

```bash
    git describe --tags --match="success-*"
```
