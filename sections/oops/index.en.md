### Oops - Interruption!

Unfinished changes can be saved at any time with `stash`.

    git stash
    git stash -u
    git stash --all
    git stash -m "bugfix started"
    git stash pop


---

### Oops - Faulty Commit


    git revert  HEAD~3


---


### Oops - Accidentally Changed

Caution: Files will be overwritten!

File accidentally changed

    git restore foo

Restore an old version of a file

    git restore -s HEAD~3 -- foo

Reset the entire workspace

    git stash -u

