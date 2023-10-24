## Upstream configuration

---

Die Befehle ˋpushˋ und ˋpullˋ erwarten\
zwei Parameter ˋ<repository>ˋ und ˋ<branch>ˋ (bzw. refspec).

    git pull origin main

Für parameterlosen Aufruf ˋgit pullˋ kann main ein *upstream configuration* eintragen: 

ˋˋˋini
[branch "main"]
	remote = origin
	merge = refs/heads/main
ˋˋˋ

---

Man muss *upstream configuration* in der Regel nicht eintragen.

Wenn man einen *remote Branch* benutzt, erstellt ˋgit switch <branchname>ˋ diese automatisch.

Erstellt man einen neuen Branch, kann dies beim ersten Push forcieren:

ˋˋˋ
git push --set-upstream <repo> <branch>
ˋˋˋ

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


