<!-- .slide: data-background-image="sections/monorepo/monorepo.png" -->


# MONOREPO TODO


---


### Wie viele
 
Dev Teams   
Files  
Lines of Code  
# **?**

notes:

Schätzen Sie!

über ihr **gesamtes Unternehnmen**

Dev Teams: Wer hat mehr als 2, 5, 10, 20, 50, 100, 500 

Files: Wer hat mehr als 1000, 10.000, 500.000, 1.000.000

Lines of Code: Wer hat mehr als 100.000, 1 Mio., 10 Mio., 100 Mio. 


---

# Think Big! <br/><br/><br/><br/>

<!-- .slide: data-background-image="sections/monorepo/tyranno-watching.png" -->


---

Kleines Gedankenexperiment:

## Tun Sie all das in
# **1 Repo**!



---

... zu groß 
... zu träge 
... bürokratisch
... ständige Konflikte 
... und wo bleibt die Teamautonomie   
... voll unagil
... was geht mich das Zeug aus den anderen Abteilungen an
... zentralistisch
... jedes Klonen dauert ewig
...


---

aber manche machen das, z .B.

 * Google
 * Facebook
 * Microsoft
 * Twitter

### Sind die denn komplett verrückt?


---


Ein **Monorepo** unterstützt

 * Large Scale **Refactorings**
 * **API** Migrationen
 * **Analysen** \
   Vulnerability, Defects, Usage, Data Lineage
 * **Aufräumen**

notes:

 * Umstellen auf Major Releases von C++, PHP
 * Wann kann ich ein API abschalten?
 * Nicht alle Großen machen das: Amazon, Netflix

---
## Voraussetzungen

 1. **1** Repo für Alles™
 2. Trunk Based Development
 3. Commitment auf Stabilität von `main`   
 4. Skalierbare Build-Pipeline 

> Google ist versioniert!


notes:

Erfordert:

 1. Technologie, Invest und Team.
 2. Nur der `main`-Stand ist relevant 
 3. Erfordert Reife in Governance.
 3. Tooling (z.B. Bazel).


---

<div style = "font-family: 'Times New Roman';">

> QUOD LICET JOVI \
> NON LICET BOVI

</div>

Die Riesen dürfen und können das. \
Sollen wir, die Zwerge, nachziehen?

notes:

Diese Frage lassen wir offen.


---

## Monorepo

| **👎**   | **👍**                      |
|:-------------:|:-------------:|
| Hoher Invest in<br/>Infrastruktur + Team   | Large Scale Refactoring |
| Governance Maturity<br/>notwendig   | übergreifende Analysen |
| Zentrale<br/>Abhängigkeit           | Housekeeping (APIs/Code) |

notes:

Knifflige Entscheidung, weil \
kurzfristiger Invest hoch, \
Nutzen aber in langristigen Aspekten liegt.


---


<!-- .slide: data-background-image="sections/monorepo/gross.png" -->


Wenn Sie Monorepo aufbauen,  
werden sie ein großes Repo bekommen,

## aber was heißt hier eigentlich

# GROß?


---


### Dimensionen von "groß"

 * Viele Dateien
 * Viele Bytes
 * Viele Leute
 * Viele Änderungen


---


Jede Dimension birgt ihre eigenen Herausforderungen.


---


![Überblick Probleme](ueberblick-probleme.png)


===

<!-- .slide: data-background-image="sections/monorepo/viele-dateien.png" -->

## Viele Dateien!<br/><br/><br/>


---


## Viele Dateien - Probleme


 * `checkout` langsam!
 * IDE glüht!
 * `status` langsam!


notes:

 * Performance des Filesystems beim initialen Auschecken und Branch wechseln
   - `checkout` und andere Befehle, die den Workspace manipulieren.
 * Performance der IDE bei vielen offenen Projekten
 * Performance von Git beim Status-Befehl


---


#### Viele Dateien - `checkout` langsam!

### Abhilfe: Sparse Checkout

Filtern, welche Dateien\
in den Workspace geholt werden.

notes:

 * `git clone` mit  `--sparse` \
   [aktiviert Sparse Checkout](https://git-scm.com/docs/git-clone#Documentation/git-clone.txt---sparse)
 * `git sparse-checkout add/list/set/...` \
   [bearbeitet](https://git-scm.com/docs/git-sparse-checkout) die [Konfiguration](https://git-scm.com/docs/git-sparse-checkout#_sparse_checkout) in \
   `$GIT_DIR/info/sparse-checkout`.


---


#### Viele Dateien - `checkout` langsam!

### Abhilfe: Sparse Checkout

```bash
# Sparse Checkout einrichten
git clone --sparse repo myclone
cd myclone
git sparse-checkout init --cone
git sparse-checkout add component-a
git checkout

# Sparse Checkout abschalten
git sparse-checkout disable
```


notes:


TODO Anmerkungen zu Usage von Sparse-Checkout


---


#### Viele Dateien - IDE glüht!

### Abhilfe

 * *Sparse Checkout* hilft oft auch hier

 * Monorepo `!=` Monolith

   Modulverzeichnise können/sollten  
   separate IDE-Projekte sein.


---

#### Viele Dateien - `status` langsam!

### Abhilfe: Watchman

 * [Watchman](https://facebook.github.io/watchman/) von Facebook
   lauscht auf File-System-Events und hält einen Cache.
 * Über [Hook](https://github.com/git/git/blob/master/templates/hooks--fsmonitor-watchman.sample) in Git integrieren
 * Erster `status`-Aufruf startet Daemon,  
   Nachfolgende nutzen den Watchman-Cache.


```bash
git config core.fsmonitor .git/hooks/query-watchman
```

---


![ueberblick-viele-dateien.png](ueberblick-viele-dateien.png)


---

<!-- .slide: data-background-image="sections/monorepo/viele-bytes.png" -->


## Viele Bytes!<br/><br/><br/>


---


## Viele Bytes - Probleme

 * **langsamer Transfer**  
   `clone` langsam  
   Bottleneck ist meist das Netz.  
   Platten sind schnell und billig.

 * **Big Binaries**  
   `fetch`, `checkout` langsam

notes:

- Typsische Problem:
  Build-Server muss lange auf clone warten

- Oft sind es die großen Binärdateien die Ursache
  Dann sind `fetch` und `checkout` auch langsam.

---

#### Viele Bytes - langsamer Transfer

### Abhilfe: Shallow Clone

 ```bash
 git clone --depth 1 <linux-url>
 git fetch --deepen 100
 ```
* Weniger Commits holen

<br/>

| Linux-Kernel | `depth=1`   | `depth=100`  | Voll     |
|--------------|-----------|------------|----------|
|              | 200 MB    | 900 MB     | 2.800 MB |  

notes:

Deepen 100: 885MB (125.000 Commits)

TODO Umgang mit Merge-Parents

---

#### Viele Bytes - langsamer Transfer

### Partial Clone

```
git clone --filter=blob:none --depth=1 <linux-url>
```

* z.B. keine Blobs, nur bestimmte Dateitypen, nur bestimmte Verzeichnisse laden. 
* Transparentes Nachladen beim Checkout
* __Klappt noch nicht mit allen Servern__

notes:

GitHub und GitLab klappt
BitBucket nicht
Ohne --depth=1 1GB nicht verständlich

---


#### Viele Bytes - langsamer Transfer

### Abhilfe: Worktree


 ```bash
 git worktree add ../workspace2 feature-a
 ```

 * Mehrere Workspace auf geteiltem Repo.
 * Nur ein *Object Store* für alle Worktrees
 * Fetch ist nur einmal notwendig.


---


#### Viele Bytes - langsamer Transfer

### Abhilfe: Klonen mit Referenz-Repo

  ```bash
 git clone --reference <local-repo-url> <repo-url>
 ```

 * Objekt aus dem Referenz-Repo  
   müssen nicht übertragen werden
 * Für Build-Server,  
   der mit frischem Klon anfangen soll


---


#### Viele Bytes - Big Binaries

### Abhilfe: Git LFS (Large File System)


![abb-lfs-ueberblick.png](abb-lfs-ueberblick.png)


notes:

Hilft zwar, ist aber nicht ohne Tücken.

(Mercurial nennt das ein "Feature of last Resort")


---


#### Viele Bytes - Big Binaries

### Abhilfe: Große Dateien ablehnen

```bash
git rev-list --objects ${oldref}..${newref} |
  git cat-file |
      --batch-check='%(objectname) %(objecttype) %(objectsize) %(rest)' |
  awk -v maxbytes="$maxbytes" '$3 > maxbytes { print $4 }'
 ```
 * [`pre-receive`-Hook](https://github.com/amacneil/git-banish-large-files) lehnt Commits mit großen Dateien ab



---


#### Viele Bytes - Big Binaries

### Abhilfe: Mit BFG Dateien entfernen


![BFG.png](BFG.png)


```bash
java -jar bfg.jar --strip-blobs-bigger-than 100M repo.git
 ```

Mögliche Alternative: Das Pythonscript [filter-repo](https://github.com/newren/git-filter-repo)

notes:

Hinweis:

(Fast) Alle Commits werden neu erstellt und bekommen neue Hashes.

Deshalb:

 1. Mit BFG Neues Repo erstellen
 2. Altes Repo deaktivieren (read-only)
 3. Alle Projektmitglieder zum neu Klonen auffordern.


---

<img src="sections/monorepo/ueberblick-viele-bytes.png" width="90%" style="border: 0px; box-shadow: none;">


---


<!-- .slide: data-background-image="sections/monorepo/viele-leute.png" -->


## Viele Leute!<br/><br/>


---


## Viele Leute - Probleme

 * Push-Reject
 * Ich will das Zeug nicht sehen
 * Branch Garbage


---


### Viele Leute - Push-Reject


```
 ! [rejected]            master -> master (fetch first)
error: failed to push some refs to 'file:///Users/rene/temp/linux.shallow.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```

Git macht keine serverseitigen Merges.

Push-Reject verhindert, dass durch Merges Versionsstände
im Server-Repo entstehen, die es nie in einem 
Entwickler-Repo gegeben hat.

notes:

Hier sollte man nicht vergessen, dass Push-Rejects  im Grunde erstmal richtig sind.


---


#### Viele Leute - Push Reject

### Abhilfe: Branch oder Fork 
      
![abb-feature-branches-ueberblick.png](abb-feature-branches-ueberblick.png)


---

#### Viele Leute - Push Reject

### Abhilfe: Branch oder Fork 
      

* Ermöglicht, bis zur Integration unabhängig zu arbeiten
* Nachteile:
  - Probleme treten erst bei Integration auf
  - Langläufer machen CI/CD unmöglich


---


#### Viele Leute - Push Reject

### Abhilfe: Pull-Requests

Integration über Pull-Requests

![abb-feature-branches-pr-mergen.png](abb-feature-branches-pr-mergen.png)


notes:

Pull-Request bedeutet Server-Seitiges mergen.

Wenn man einfach willenlos auf "Mergen" klickt, umgeht man die Schutzwirkung die von Push-Rejects intendiert ist.

Pull-Request sollten mit Reviews und Buil-Pipeline-Integration genutzt werden.


---


#### Viele Leute - Zu viele Branches

### Abhilfe: Ordnung schaffen

Präfixe je Module oder Team definieren:  
`/team-a/feature/4711`

```bash
git branch -r --list /teams/*
git branch -r --list */feature/*
```
  
---


#### Viele Leute - Zu viele Branches

### Abhilfe: Branches aufräumen

* Automatisches `fetch --prune`
  
```bash
git config fetch.prune true
```

  * Alte Branches finden

```bash
git branch -r --no-merged

git log --no-merges -n 1 --format="%ci" <branch>
```


---

![ueberblick-viele-leute.png](ueberblick-viele-leute.png)


---


<!-- .slide: data-background-image="sections/monorepo/viele-commits.png" -->

## Viele Commits<br/><br/><br/><br/>


---

## Linux Kernel


Knapp eine Millionen Commits.

Das Logging der letzten **10 Commits** dauert\
**9 Sekunden**.

```
time git log --graph --oneline -10
```

notes:

Das Problem ist der Graph, ohne --graph geht es schnell

https://devblogs.microsoft.com/devops/a-deep-dive-into-git-performance-using-trace2/
https://git-scm.com/docs/commit-graph

---


![log-graph.png](log-graph.png)_


---

## Langsame Operationen

 * Historie als Graph anzeigen
 * Merge-Base ermitteln
   * Merge, Rebase
   * Status
 * Wo ist das Commit enthalten?

```
git log --graph --oneline -10
git merge feature/42
git branch --contains <hash>
```

notes: 

There are two main costs here:

    1. Decompressing and parsing commits.

    2. Walking the entire graph to satisfy topological order constraints.

---


## Commit-Graph

 * Seperater Index für Commits
   * OID
   * Parents
   * Commit Date
   * Tree OID
   * Generation Number

```
# Nur Pack-Files indizieren
git commit-graph write 
# Alle Commits indizieren
git show-ref -s | git commit-graph write --stdin-commits
# Bei jedem Fetch aktualisieren
git config fetch.writeCommitGraph true
```

notes:

Generation Number ist die Anzahl der Commits/Parents bis zur Wurzel
* Dadurch kann man leicht feststellen ob zwei Commits nicht voreinander liegen
---

## Linux Kernel mit Commit-Graph


Das Logging der letzten 10 Commits des Linux Kernels 
dauert mit Commit-Graph 0,3 Sekunden.

```
time git log --graph --oneline -10
```


---


![ueberblick-viele-commits.png](ueberblick-viele-commits.png)


---

![ueberblick-loesungen.png](ueberblick-loesungen.png)


---


## ... und wenn **das** nicht reicht?


(Git hat Grenzen und skaliert nicht für beliebig große Repos)


---


## Dann ...

 * ... entwickelt man ein **File-System** speziell für Git-Monorepos (**Microsoft**).
 * ... erstellt man Plugins für ein **modulares VCS** (Mercurial bei **Facebook**).
 * ... baut man einfach ein **eigenes VCS** (**Google**).


notes:
 
 TODO noch ein paar Speaker notes mit Fakten zu den Drei Varianten hinzufügen.


