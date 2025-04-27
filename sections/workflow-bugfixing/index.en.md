# Oops, a Bug!


## What to Do?

---


Typical: **Bugfix Branch**

![Bugfix Branch](bugfix-branch.png)

 1. Switch to the faulty version: `git switch <tag>`
 1. Create a branch: `git switch -c <bug-id>`
 1. Fix the bug, test, review.
 1. Merge to the main branch
 1. Create a new tag: `git tag -a <new-version>`


---


### Git Enables Merge Chains

![Merge Chains](abb-merge-ketten.png)

Merge chains go from older (upstream) branches to newer branches.

Through merges, all changes are transferred from one branch to the next.

#### Question: Why doesn't it work the other way around?


---


## Backporting

In the other direction,
not all changes are to be taken.

Selective adoption of individual changes with `git cherry-pick`.

Decouples releases.

Management required: What was applied where?


---


## Variant: Forward Fixing

 1. Fix on the main branch, e.g., `main`
 1. Then release again

Often in connection with *Continuous Delivery* workflows

 * Advantage: Only one release flow, no exceptions
 * Disadvantage: All current changes are delivered

