## The *Stage* Area 

(aka *Index*)

Git collects changes in the Stage area.
`git add` "parks" them there
until they are used in a commit.

    Workspace   -add->   Stage   -commit->   Repository

This means if you change files after `add`,
these changes will not be included in the commit.


Notes:

In the "default state," the Stage corresponds to the HEAD state.


---


### Tips for Staging

Difference between Workspace and Stage:

    git diff

Difference between Stage and `HEAD`:

    git diff --staged

Reset Stage to the `HEAD` state:

    git restore --staged <file>

Reset Workspace to the Stage state:

    git restore <file>


---

<iframe src="markdown-git-uebungen/aufgabe-commits-staging.html" width="100%" height="600px" ></iframe>


