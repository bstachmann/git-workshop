
### Erinnerung: Ref - Zeiger auf ein Commit

Branches sind Zeiger auf Commits, z. B. `myfeature`, `master`


---

### Remote Refs

#### Wissen was in anderen Klonen los ist

*Remote Refs* repräsentieren den Stand der *Refs* 
in anderen Repos. 

```bash
git show master               # lokaler Stand
git show origin/master        # origin nach letztem Synch
```

*Remote Refs* werden bei ˋcloneˋ, ˋfetchˋ und ˋpullˋ aktualisiert.

Sind mehrere Remotes (nicht nur ˋoriginˋ) deklariert, 
gibt es auch mehrere Sätze von *Remote Refs*.


---

### Remote Refs - Ahead/Behind

*Remote Refs* ermöglichen, lokale Stände mit fernen Repository zu vergleichen.

```bash
    $ git status

    On branch master
    Your branch is ahead of 'origin/master' by 1 commits.

    $ git diff master origin/master

    $ git log origin/master..master   # ahead
    $ git log master..origin/master   # behind
```




