## Tags pushen

Tags werden beim Push nicht automatisch übertragen.
Sie müssen explizit veröffentlicht werden.

```bash
    git push orgin v1.0
    git push --tags
```

## Tags pullen

Beim Pull werden nur die Tags zu den Commits die übertragen werden geholt.
Möchte man alle Tags holen muss man `--tags` angeben.

---

## Tags nicht verändern

**Empfehlung**: Tags, die man mit anderen geteilt hat, nicht mehr verändern.
Für Markierungen die aktualisiert werden sollen entweder einfach Branches nutze (`latest-success`)
oder Tagnamen mit Timestamp versehen (`success-20231030203501`). 
`describe` kann das jeweils letzte Tag ermitteln:

```bash
    git describe --tags --match="success-*"
```

---

### Übung

<h2><a href="markdown-git-uebungen/aufgabe-zusammenarbeit-tags.html" target="_blank">Tags<a></h2>
