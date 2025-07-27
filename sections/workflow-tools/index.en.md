## The Toolbox

Git does not prescribe a specific *workflow*.

It offers a range of *tools*,
which can be used in different ways.

Which tools are used and when
determines the *team workflow*.

The following tools are crucial:


---


## Branch

 ![Branch After](abb-branches-beispiel-nachher.png)

---

## Merge

![Branch Merge](abb-branches-beispiel-merge.png)

* Creates a new commit
* Two parents


---

## Cherry-Pick (Before)

![Branch After](abb-branches-beispiel-nachher.png)

---

## Cherry-Pick (After)

 ![Rebase After](abb-branches-beispiel-cherry-pick.png)

  * Copies commits
  * No structural connection between copied commits.

---

## Rebase (Before)

  ![Rebase Before](abb-branches-beispiel-rebase-vorher.png)

---

## Rebase (After)

  ![Rebase After](abb-branches-beispiel-rebase-nachher.png)

 * Copies commits
 * Appears as if the commits were moved.


---


### Warning! -  Rebase changes history.

* OK for local changes.
* OK for feature branches in closed teams.
* Not OK otherwise.


---


## Tags

![Tags](tags.png)

(Annotated) Tags mark commits for important milestones, e.g., releases.


---

## History Tree

![History Tree](abb-1st-parent-history-0.png)

---

**Merges** show integrations, <BR/>
**Rebases** and **Cherry-Picks** hide them.
<BR/>

The choice of tools determines,<BR/>
which integrations the history tree shows.

---

## Toolbox

### for Workflows

| Tools                |
|----------------------|
| Branch               |
| Merge                |
| Rebase               |
| Cherry-Pick          |
| Tag                  |
| History tree         |
