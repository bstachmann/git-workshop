## What happens in Git with conflicting renames

Git reports during a merge if the two branches contain conflicting renames or moves. 

    $ git merge rename-and-edit2
    CONFLICT (rename/rename): 
    Rename "a.md"->"a1e.md" in branch "HEAD" 
    rename "a.md"->"a2e.md" in "rename-and-edit2"
    Automatic merge failed; fix conflicts and then commit the result.
    
The `status` command also shows the situation:
        
    $ git status
      ...
    Unmerged paths:
      (use "git add/rm <file>..." as appropriate to mark resolution)
    
    	both deleted:    a.md
    	added by us:     a1e.md
    	added by them:   a2e.md
      ...

Git leaves both variants.

    $ ll
    -rw-r--r-- 1 bjoern bjoern   96 Aug 24 20:12 a1e.md
    -rw-r--r-- 1 bjoern bjoern   95 Aug 24 20:12 a2e.md


To be safe, you should check 
whether the two files differ in content 
and merge the changes, if necessary, with an editor into the file
that should remain.


    git diff --no-index a1e.md a2e.md

You then decide which variant to keep and register it with `add`. 
The other and the previous one are deregistered with `rm`.

    $ git add a1e.md

    $ git rm a.md
    a.md: needs merge
    rm 'a.md'
    
    $ git rm a2e.md
    a2e.md: needs merge
    rm 'a2e.md'
    
Note: Although the `needs merge` message looks a bit like an error message, 
the deletions are also staged. The merge can be completed.

    $ git commit

