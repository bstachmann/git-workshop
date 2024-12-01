# To Do

## Workshop am 9.12.2024

 * [ ] Modularisierung
    - [x] Vortrag über große Repos und Modularisierung hinzufügen
    - [x] Demo: Submodules, Subtrees
    - Tabelle Trade-Off Modularisierung
 * [x] Relases 
    - [x] Release erstellen
    - [x] inkl. Patches auf Release
 * [x] Kurz: Pull-Request und Reviews
 * [ ] Pipelines (PR, main, asynchron)
 * [x] Workflow auf einem Branch gemeinsam arbeiten
 * [ ] Achtung: Commits beziehen sich immer auf das ganze Repo

-----

# Allgemein

 * Trade-Off tabellen
   - Merge vs. Rebase vs. Squash-Merge
   - Trunk vs. Feature
   - Cherry-Pick vs. Merge Chains
   - Add+Commit+Push oder selective Stage and push
 * Beispiele (insbesondere submodule, subtree) nach fachlichen Beispielen benennen (nicht abstrakt)
 * "Branches sind Zeiger auf Commits" das Bild ist echt doof. (Branchname irreführend)
 * ein paarmal sollte "git branch" durch switch ersetzt werden
 * In der branches fortgeschritten Hinweise auf dff ... und log .. in Tipps
 * Integration von änderungen: Spezialfälle nach hinten 
 * Dateiname stimmt nicht mehr : https://bstachmann.github.io/git-workshop/installation/uebungen
 * in uebungsbeschreibung: Anwendungen öfnnen 
 * Übungschrit "Arbeitsverzeichnisse anzeigen" falscher Name
 * Timing: Was ist git big 10:30 Repository bis 12:00
 *repository-log Übung: show HEAD:datei.txt erläutern in Tipps
 * repository-untersuchen: Enthält noch Tipps zur vorigen übung
 * diff slides im nach vorne und zusammen ziehen (nich in refs)
 * checkin/step-0 für den tracker
 * Remote Tracking Branches nach "Push Pull"
   - git branch -a
   - ersten fetch zeigen,
   - git branch -a (evtl auch übung)
 * In Agenda branches Abschnitt doppelt
 * Integration von Änderungen Übung braucht Optionals
 * Idee: Optionals immer ans Ende bringen
 * Interaktivere übungen (Pairint, Gegenseitig erklären)
 * Miro nutzen?
 * Repos sprechende namen  submodules
 * In Submodule uebung steht immer noch subtree drinsti * Commit-Messages, Editor and Editor-Konfig -> übung
 * Übung zu --squash, Bonusübung zu Orphan-Branches
 * Bonusaufgaben immer am Ende
 * Optionals für Integration von änderung: Löschen von Dateien, Umbenennen/Verschieben
 * branches bild malen
 * slide für restore befehl
 * übung repository-log feingranularer
 * Pull-fetch übung: Ein paar Optionale einbauen.
 * In übung Branching: die asymmetrischen Diffs mit einbauen
 * Stating schritt zwei: Vorletzte Änderung zurücknehmen.
 * Übungsreihenfolge im Source anpassen
 * config pull-rebase for den integrationsübungen checken.
 * Für jede übung einen Checkin-Schritt, damit man sieht, dass es losgeht
 * Tabelle mit Teilnehmernamen zu Schritten
 * Bessere beispiel fÜr Pull-Requests
 * commit optionen
 * To Do status erklaeren
  ( Beispiel für Scriptautomatisierung)
 * editor-config in der ersten übung checken 
 * Übung Klonen. Repos aus repository unterschuchen nutzen. und dann als 4. Aufgabe die Remote refs untersuchen.
 * Klone Abschnitt entrümplen (viel Duplikation) * Schritt 0 bei übungen -> mit cd ../../asdf hinweis
 * Bilder für Revison
 * Für die Repo untersuchen Aufgabe: öffentliches Beispielrepo als Bonusaufgabe
 * diff --stat in übung
 * Stylesheet - Inline-Code schwarzgrün
 * Kommandozeilen intro: https://bstachmann.github.io/git-workshop/installation/kommandozeile.html + ll -a
 * Linkliste zu Informationen (Hilfe, Cheat-Sheet etc.) über git in Website aufnehmen und auf einer Slide verlinken
 * Übung hallo Git: Link auf Hilfe zur Kommandozeile. Config erst abfragen, dann setzen
 * log und show-demos im intro-hallo-welt repo zeigen
 * Übung im Abschnitt Repository splitten, damit der Vortragsblock nicht so lang ist.
 * Ein paarmal steht übung wo demo stehen sollte
 * --decorate streichen
 * git merge beispiele -> in dem Repo merge als default für
 * Git-Merge -> add vor dem commit
 * partial checkout nach hinten
 * restore aus Repository raus
 * übuungen im Repository chapter auftrennen
 * Quick-Fixes
 * Branch create and --
 * switch/restore  in repository-untersuchen und in slides
 * Progress server -> "bin dabei" links, den man setzt wenn man startet
 * übungsgenerator: Pfad zum übungsrepo vollständig anzeigen, z.B. build/git-uebungen/aufgaben/zusammenarbeit-push-fetch-pull
 * Tipps zum push-fetch-pull (umbenennen nach push-fetch)
 * übung zu subtrees und submodules trennen.
 * Übung zu subtrees und submodules trennen.
 * Setup-Hinweise in Übungsaufgaben
   - bessere Anleitung, evtl. Video zum setup
   - Aufgaben funktionieren 1:1 nur wenn man Git-Bash verwendet
     Bei Dateinamen am besten / verwenden statt \
   - Git Windows CMD (Git CMD) sind Details anders
     nur mit \ klappt die Tab-completion für Pfade
     aber einige Git-Befehle mögen keine \es
  * Config und setup Übung in Intro-Block einbauen
  * evtl. Blog-Post zu file-Annotations oder file-Properties
  * übung heiss push fetch pull, obwohl nur pull und fetch gemacht wird
  * SVG-Beispiel zu push rejected um Pull ergänzen.
  * Progess tool toggled beim Refresh



   ## Notizen

## repo-log

>Wechsle zum vorigen Commit, und untersuche, wie der Workspace dannn aussieht. Wechsle dann wieder auf master zurück.
löshc


ls-tree nicht tab-completion

ll -a

Deutlicher auf gross W



## Ideen zur Interaktion
 * eine tolle neue Idee

 * Schlagabstausch
   - 2 Teams
     * Pro Argumente im Austausch
 * Stichwortbingo
   -Schlagworte aus dem Repostory-Abchnitt    
 * 0. Kurze Intro, 1st Übung, 2nd recherchieren, 3rd erklären (mehrere Teams)
   - z. B. switch
   - z. B. restore
   - z. B. revert

## Sonstige Ideen

Ausblick: Automatisierung
    

