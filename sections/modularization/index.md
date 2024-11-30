# Module

<!-- .slide: data-background-image="sections/modularization/modules.png" data-background-opacity="0.6" -->

---

## Lernziele

```
    init / subtree / submodule
```

 * Überblick Modularisierungsszenarien.
   - Monorepo / Many Repos + ext. Dependendency Management / Submodules / Subtrees
 * Submodules
   - extrahieren eines Unterverzeichnisses als Submodule-Rep
   - arbeiten mit dem Submodule
 * Subtrees
   - extrahieren eines Unterverzeichnisses in  Subtree-Repo
   - arbeiten mit dem Subtree
 * Integrieren eines anderen Repos (z. B. subtree/submodule) als Unterverzeichnis.

---

<!-- .slide: data-background-image="07/modules.png" -->

### Aber es gibt doch auch...

### ... **`git submodule`** ... und
### **`git subtree`** ... gibt es doch auch.
### **Hilft das?**

---

### Git unterstützt zwei Arten der Modularisierung

 * Submodules
   
   ```git submodule init/add/update```
   
 * Subtrees
   
   ```git subtree add/pull/push```

notes:

Beispiel: Data Scientisten nutzen Untility-Module


---


### Beispiel

Das `UNTER` soll als Modul in `OBER` genutzt werden.

```bash
   OBER/
   |-- foo              # Datei auf Top-Level
   |-- UNTER/
       |-- bar          # Datei aus "UNTER"    
```


---


### Submodules

> wie Soft-Links

Das übergeordnete Repo kennt nur die **URL** und ein **Commit-Hash** 
aus dem Untergeordneten.

```bash
   OBER/
   |-- .git/
   |   |-- ...Git-Kram...
   |-- foo
   |-- UNTER/                  # OBER kennt URL + Commit-Hash
       |-- .git/               # Separates Repo
       |   |-- ...Git-Kram...
       |-- bar                 # Nicht im log von "OBER"
```


---

### Separate Historien bei Submodules

Log von `UNTER`:

```bash
3a0aff17 edit bar again
8e1508df edit bar
f05e91fa create bar
fe6cf6d7 init UNTER
```


Log von `OBER`:

```bash
8952f352 update module UNTER to 3a0aff17
8952f352 add module UNTER at 8e1508df
3a0aff17 create foo
8e1508df init OBER
```

---


### Subtrees

> Commits kopieren

Commits werden vom untergeordenten Repo in das Übergeordnete kopiert,
wobei die Inhalte um eine Verzeichnisebene verschoben werden.

```bash
   OBER/
   |-- .git/
   |   |-- ...Git-Kram...
   |-- foo
   |-- UNTER/       # "UNTER/bar" ist Datei in "OBER"          
       |-- bar      # Commits, die "bar" modifizieren
                    # wurden kopiert.
```


---

### Kopierte Commits bei Subtrees


Log von `UNTER`:

```bash
3a0aff17 edit bar again
8e1508df edit bar
f05e91fa create bar
fe6cf6d7 init UNTER
```

Log von `OBER`:

```bash
79e91afa edit bar again      # kopiert aus "UNTER"
9b31c60f edit bar            # kopiert aus "UNTER"
ce889e8e create bar          # kopiert aus "UNTER"
a6d3e59d init UNTER          # kopiert aus "UNTER"
3a0aff17 create foo
8e1508df init OBER
```

---


### Submodule und Subtree binden weitere Repos in Unterverzeichnisse ein.

 * *Vorteile*
   - großes Repo zum Integrieren
   - kleine Repos zum Arbeiten
 
 * *Nachteile*
   - hohe Komplexität, Fehleranfälligkeit
   - aufwändige Synchronisation

notes:



---

[Vortrag zur Modularisierung mit Submodules](https://kapitel26.github.io/assets/2010-10-20-submodules-subtrees-lehmanns/Lehmannsvortrag.pdf)



---

### Übung

<h2><a href="markdown-git-uebungen/aufgabe-modularisierung-submodules.html" target="_blank">Submodules<a></h2>


---

### Übung

<h2><a href="markdown-git-uebungen/aufgabe-modularisierung-subtrees.html" target="_blank">Subtrees<a></h2>


---

### Übung

<h2><a href="markdown-git-uebungen/aufgabe-modularisierung-repositorys-zusammenfuehren.html" target="_blank">Repositorys zusammenführen<a></h2>



