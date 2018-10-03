# Repository

_________________________________________

## Lernziel

```
    log / show / diff
```

 * Repository
 * Dezentralität, Klon
 * Revision Hashes

## Zentral vs. Dezentral

 * ![Zentral vs. dezentral](abb/zentral-dezentral.jpg)
 * Warum Git? 6-8

_________________________________________
## Was ist drin, im Repository?

 * `log` 15: Zeigt die Historie, die zum aktuellen Commit geführt hat.
 * `--oneline`
     - `log -3` Ausgabe limitieren
     - `log <file>`
   - Aktuelle Version und Vorgänger: `HEAD`, `HEAD~1`, `HEAD~2`
 * *Revision Hashes* werden als Prüfsumme von Dateinhalten und Struktur, Autor, Zeitpunkt, Commit-Kommentar und Parent-Revision gebildet.

_________________________________________

##  Weitere Befehle zum untersuchen der Historie

   - `show` zeigt Details zu einer Version
      - `git show 9f5c3`
      - `show 1a8a24a:protokoll.md`
   - `ls-tree`
   - `checkout` von Revisionen 22 (26,38)
_________________________________________

##  Weitere Befehle zum Untersuchen der Historie

   - `diff`
      - `diff 9f5c3`, vergleicht mit HEAD
      - `diff 1a8a2 9f5c3`, 2 Versionen vergleichen
      - `diff 1a8a2 9f5c3  -- inhalt.md`, nur eine Datei
      - `diff --word-diff`
   - `difftool`

_________________________________________

## Elementare Begriffe

Mitreden, wo es um Git geht
   * Repository
   * Workspace
   * Klon
   * Commit
   * Revision, Revision-Hash
   * `master`
