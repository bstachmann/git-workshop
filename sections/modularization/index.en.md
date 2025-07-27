# Modules

<!-- .slide: data-background-image="sections/modularization/modules.png" data-background-opacity="0.6" -->

---

## Learning Goals

```
    init / subtree / submodule
```

 * Overview of modularization scenarios.
   - Monorepo / Many Repos + external dependency management / Submodules / Subtrees
 * Submodules
   - Extracting a subdirectory as a submodule repo
   - Working with the submodule
 * Subtrees
   - Extracting a subdirectory into a subtree repo
   - Working with the subtree
 * Integrating another repo (e.g., subtree/submodule) as a subdirectory.

---

<!-- .slide: data-background-image="07/modules.png" -->

### But there is also...

### ... **`git submodule`** ... and
### **`git subtree`** ... as well.
### **Does it help?**

---

### Git supports two types of modularization

 * Submodules
   
   ```git submodule init/add/update```
   
 * Subtrees
   
   ```git subtree add/pull/push```

notes:

Example: Data scientists use utility modules


---


### Example

The `UNDER` should be used as a module in `OVER`.

```bash
   OVER/
   |-- foo              # File at top level
   |-- UNDER/
       |-- bar          # File from "UNDER"    
```


---


### Submodules

> like soft links

The parent repo only knows the **URL** and a **commit hash** 
of the subordinate.

```bash
   OVER/
   |-- .git/
   |   |-- ...Git stuff...
   |-- foo
   |-- UNDER/                  # OVER knows URL + commit hash
       |-- .git/               # Separate repo
       |   |-- ...Git stuff...
       |-- bar                 # Not in the log of "OVER"
```


---

### Separate histories with submodules

Log of `UNDER`:

```bash
3a0aff17 edit bar again
8e1508df edit bar
f05e91fa create bar
fe6cf6d7 init UNDER
```


Log of `OVER`:

```bash
8952f352 update module UNDER to 3a0aff17
8952f352 add module UNDER at 8e1508df
3a0aff17 create foo
8e1508df init OVER
```

---


### Subtrees

> Copy commits

Commits are copied from the subordinate repo into the parent repo,
shifting the contents by one directory level.

```bash
   OVER/
   |-- .git/
   |   |-- ...Git stuff...
   |-- foo
   |-- UNDER/       # "UNDER/bar" is a file in "OVER"          
       |-- bar      # Commits modifying "bar"
                    # were copied.
```


---

### Copied commits with subtrees


Log of `UNDER`:

```bash
3a0aff17 edit bar again
8e1508df edit bar
f05e91fa create bar
fe6cf6d7 init UNDER
```

Log of `OVER`:

```bash
79e91afa edit bar again      # copied from "UNDER"
9b31c60f edit bar            # copied from "UNDER"
ce889e8e create bar          # copied from "UNDER"
a6d3e59d init UNDER          # copied from "UNDER"
3a0aff17 create foo
8e1508df init OVER
```

---


### Submodules and Subtrees integrate other repos into subdirectories.

 * *Advantages*
   - Large repo for integration
   - Small repos for work
 
 * *Disadvantages*
   - High complexity, error-prone
   - Labor-intensive synchronization

notes:


---

<iframe src="markdown-git-uebungen/aufgabe-modularisierung-submodules.html" width="100%" height="600px" ></iframe>

---

<iframe src="markdown-git-uebungen/aufgabe-modularisierung-subtrees.html" width="100%" height="600px" ></iframe>


---

<iframe src="markdown-git-uebungen/aufgabe-modularisierung-repositorys-zusammenfuehren.html" width="100%" height="600px" ></iframe>

---

Discussion of the advantages and disadvantages of various modularization strategies.

[Lecture on modularization with submodules](https://kapitel26.github.io/assets/2010-10-20-submodules-subtrees-lehmanns/Lehmannsvortrag.pdf)



