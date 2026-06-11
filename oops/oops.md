---
layout: page
title: Oops?!
nav_order: 83
has_children: false
---

Ein paar Kommandos braucht man nur selten,
aber genau dann dringend wenn etwas schief gegangen ist.

## Dinge, die öfter mal passieren

**"Uncommittete" Änderungen stehen im Weg**, 
z.B. vor einen Branch-Wechsel oder einem Merge.

    git stash -u

Die Änderungen können später mit `git stash show -p` angezeigt werden 
und mit `git stash pop` zurückgeholt werden.

**Ein falsches Commit gemacht (und gepushed)**, 
z.B. wenn vergessen, eine neue Datei hinzuzufügen, 
oder etwas committed wurd, das gar nicht dauerhaft sein sollte. 

    git revert <fehlerhaftes-commit

`revert` erstellt ein *neues Commit*, 
das die Änderung eines vorherigen Commits umkehrt.

**Ein falsches Commit gemacht (noch nicht gepushed)**,
z.B. wenn vergessen wurd, eine neue Datei hinzuzufügen,
eine wichtige Änderung noch nicht gemacht war, 
oder die Commit-Message fehlerhaft war. 

    git add <datei>  # Falls die Datei fehlte oder nachbearbeitet wurde
    git commit --amend

**Versehentlich `git add` gemacht**: Mit `git add` werden Änderungen für das nächste commit vorgemerkt.
Falls die Änderungen noch gar nicht committed werden sollen:

    git restore --staged

Anmerkung: Hier wird nur die *Stage* zurückgesetzt, 
Workspace-Dateien bleben unberührt.

**Lokale Dateiänderungen rückgängig machen (noch nicht committed)**

    git stash -u

Anmerkung: Die Änderungen werden als *Stash* gesichert, 
und können ggf. von dort wieder zurückgeholt werden.

**Einzelne Commits löschen (noch nicht gepushed)**:

    git rebase --interactive

Das `rebase` wird einen Editor mit einer Liste 
von noch nicht gepushten Commits öffnen.
Dort die Zeilen mit ungewollten Commits löschen und dann den Editor schließem.

## Eventuell nützlich, wenn etwas sehr schiefgegangen ist

**Das Reflog**: Git speichert ein Log für jede Änderung am `HEAD` 
und an allen Branches

**Interaktives Rebasing**: Ermöglicht es auch längere Sequenzen umzuschreiben.

**`filter-repo`**, ist (externes) Tool, mit dem fortgeschrittene Manipulationen,
wie z.B. Löschen einzelner Dateien aus der Historie durchführen kann.




