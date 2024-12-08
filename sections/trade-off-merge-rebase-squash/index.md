### Merge vs. Rebase vs. Squash

 * **Merge** \
   Die Änderungen werden als Merge-Commit zusammengeführt
 * **Rebase** \
   Die Änderungen werden als Folge von Commits Commits kopiert
 * **Squash-Merge** \
   Die Änderungen werden in einem Commit *"zusammengedampft"*


---


| Tradeoff |  Merge  |  Rebase |  Squash |
|--|---------|---------|---------|
| Für Einsteiger | + | - | - |
| Duplikatprobleme<br/>vermeiden | + | - | - |
| Lineare Historie | - | + | + |
| Continuous<br/>Integration | - | + | + |
| Rename Detection | + | + | - |
| Nachvollziehbarkeit | + | - | - |

