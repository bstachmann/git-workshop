Agile Projekt nutzen oft *Boards* die Arbeit zu koordinieren.

 ![Ein typisches Scrum-Board](task-board.png)


---

Die Entwickler arbeiten dann Story/Task/Bug-Karten ab. Es liegt nahe, für jede Karte einen Branch abzuzweigen.

![Einaches Feature-Branching](feature-branch.png)


---

Gibt es Neuerungen auf dem Hauptbranch, kann der *Feature Branch* durch ein *Update-Merge* auf den neuesten Stand gebracht werden.

![Aktualisierun des Feature Branch durch ein Update-Merge](update-merge.png)

---

Vor dem Merge in den Haupt-Branch steht meist *Quality Gateway* 
mit Reviews und Tests an.

![Einaches Feature-Branching](feature-branch.png)

---

Wenn ein Feature fertig gestellt ist, wird es in den Hauptbranch integriert. 

![Integration eine Features auf den Hauptbranch](integration-merge.png)

---

Es ist möglich, vorab Zwischenergebnisse auf den **Hauptbranch** zu bringen.
Es empfiehlt sich dann das unfertige Feature durch **Feature-Toggles** vor
ungeplanter Benutzung zu schützen.
