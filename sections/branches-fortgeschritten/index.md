## Upstream configuration

---

Die Befehle `push` und `pull` erwarten\
zwei Parameter `<repository>` und `<branch>` (bzw. refspec).

    git pull origin main

Für parameterlosen Aufruf `git pull` kann main ein *upstream configuration* eintragen: 

```ini
[branch "main"]
	remote = origin
	merge = refs/heads/main
```

---

Man muss *upstream configuration* in der Regel nicht eintragen.

Wenn man einen *remote Branch* benutzt, erstellt `git switch <branchname>` diese automatisch.

Erstellt man einen neuen Branch, kann dies beim ersten Push forcieren:

```bash
git push --set-upstream <repo> <branch>
```

---

## Branches verwalten

```bash
    # Welche branches wurden schon integriert?
    git checkout master
    git branch --merged

    # Branch löschen
    git branch -d some-branch
```

[Aufräumen von Branches](https://kapitel26.github.io/git/2014/03/31/alte-branches-archivieren.rb.html)
[Mirroring](https://kapitel26.github.io/git/2014/04/04/branches-aufrauemen.rb.html)


---

### Übung

<h2><a href="markdown-git-uebungen/aufgabe-zusammenarbeit-branching-fortgeschritten.html" target="_blank">Branches<a></h2>

<h2><a href="markdown-git-uebungen/aufgabe-zusammenarbeit-reverting.html" target="_blank">Reverting of Merges<a></h2>


