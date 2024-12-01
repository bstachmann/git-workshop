
## Der Werkzeugkasten

Git gibt keine bestimmte *Arbeitsweise* vor.

Es bietet eine Reihe von *Werkzeugen*,
die unterschiedlich eingesetzt werden.

Welche Tools man wann einsetzt,
bestimmt den *Workflow im Team*.

Die folgenden Werkzeuge sind entscheidend:


---


## Branch

 ![Branch Nachher](abb-branches-beispiel-nachher.png)

---

## Merge

![Branch Merge](abb-branches-beispiel-merge.png)

* Erzeugt neues Commit
* Zwei Parents


---

## Cherry-Pick (Vorher)

![Branch Nachher](abb-branches-beispiel-nachher.png)

---

## Cherry-Pick (Nachher)

 ![Rebase nachher](abb-branches-beispiel-cherry-pick.png)

  * Kopiert Commits
  * Kein struktureller Zusammenhang zwischen kopierten Commits.

---

## Rebase (vorher)

  ![Rebase vorher](abb-branches-beispiel-rebase-vorher.png)

---

## Rebase (nachher)

  ![Rebase nachher](abb-branches-beispiel-rebase-nachher.png)

 * Kopiert Commits
 * Sieht dann nachher so aus,<br/>
   als wären die Commits verschoben.


---


### Achtung! -  Rebase verändert die Historie.

* OK, für lokale Änderungen.
* OK, für Features-Branches in geschlossenen Teams.
* Nicht OK, sonst.


---


## Tags

![Tags](tags.png)

(Annotated) Tags markieren Commits zu wichtigen Meileinsteinen, z.B. Releases.


---

## History-Tree

![History-Tree](abb-1st-parent-history-0.png)

---

**Merges** zeigen Integrationen, <BR/>
**Rebases** und **Cherry-Picks** verbergen sie.
<BR/>

Mit der Wahl der Werkzeuge bestimmt man,<BR/>
welche Integrationen das History-Tree zeigt.

---

1st-Parent-History
------------------

![1st-Parent-History](abb-1st-parent-history-2.png)

**1st-Parent** dient als Heuristik für Branch-Zugehörigkeit

---

## Werkzeugkasten

### für Workflows

| Werkzeuge             |
|-----------------------|
| Branch                |
| Merge                 |
| Rebase                |
| Cherry-Pick           |
| Tag                   |
| History tree          |
