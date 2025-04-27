

Git kann Verschiebungen von Dateien erkennen (*Rename Detection*).

Wie geht das?


---

Wenn in einem Commit,

 * eine Datei gelöscht wurde,
 * und eine neue Datei hinzugekommen ist, und
 * die Inhalte (fast) gleich sind,
 
geht Git davon aus, dass eine Datei verschoben wurde.

Die Option `--follow` am `log`-Befehl forciert die *rename detection*.


---


### Commit - Verschieben von Dateien

```
   mv hallo hello       
   git add .
   git commit -m "hallo -> hello"
```

Die Historie von `hello`:

   git log --follow -- hello
   
   

---


###  Tipp: Separate move from change

 1. Move
 1. Commit
 1. Change
 1. Commit


