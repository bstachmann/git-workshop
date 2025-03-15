

# Ups, ein Bug!


## Was tun?

---


Typisch: **Bugfix-Branch**

![Bugfix Branch](bugfix-branch.png)

 1. Zur fehlerhaften Version:`git switch <tag>`
 1. Branch erstellen: `git switch -c <bug-id>`
 1. Bug fixen, testen reviewen.
 1. Merge auf Hauptbranch
 1. Neues Tag: `git tag -a <new-version>`


---


### Git ermöglicht Merge-Ketten

![Merge-Ketten](abb-merge-ketten.png)

Merge-Ketten gehen von älteren (upstream) Branches zu neueren Branches.

Durch Merges werden alle Änderungen von einem Branch zum nächsten übertragen.

#### Preisfrage: Warum geht das nicht andersherum?


---


## Backporting

In die andere Richtung,
will man nicht alle Änderungen mitnehmen.

Selektive Übernahme einzelner Änderungen mit `git cherry-pick`.

Entkoppelt Releases.

Management erforderlich: Was wurde wo angewandt?


---


## Variante: Forward Fixing

 1. Fix auf dem Hauptbranch, z.B. `main`
 1. Dann erneutes Release

Oft im Zusammenhang mit *Continuous Delivery*-Workflows

 * Vorteil: Nur ein Release-Flow, keine Ausnahmen
 * Nachteil: Alle aktuellen Änderungen werden mit ausgeliefert

