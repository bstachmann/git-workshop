# Continuous Integration

---

## Learning Objective

 * **The problem** with **merges**
 * **Classic** branching and release models
 * Concept: **Continuous Integration**
 * The **challenges** of **CI**
 * What is needed for **successful CI**?

---

<!-- .slide: data-background-image="continuous-integration/complicated-merge-resolution.png" -->

## Hell? Hell? Hell?

# `git merge`

---

## Exercise: A Tricky Merge

In the history, there is a tricky merge.
Repeat the merge and try to resolve some of the conflicts.
What do you notice?

```bash
# Preparation
git show --stat interesting-merge
git config --global merge.conflictstyle diff3

# Perform the merge again
git checkout interesting-merge^1
git merge interesting-merge^2

git mergetool  # or use your IDE
```

---

### Where do the problems come from?

 * The same files are edited\
   (overlapping tasks/responsibilities)
 * Changes can be merged,\
   but they don't fit together.
 * Moves/renames
   * of files
   * within files
 * Whitespace changes

### The longer you wait, the worse it gets!

---

**Classic branching and release models**\
can be implemented well with Git, and provide

 * independent feature development
 * parallel development during the release phase
 * maintaining multiple releases
 * distributing patches across multiple releases

(see e.g., [GitFlow](https://nvie.com/posts/a-successful-git-branching-model/))

### but nothing comes for free

---

You pay for this with **long-lived branches**,\
which lead to merges between distant changes, often resulting in

 * difficulties in integration
 * stressful release phases
 * stagnation due to fear of changes

---

## But then ...

> ... usually each person integrates at least daily ...
>
>  Martin Fowler, 2006

https://martinfowler.com/articles/continuousIntegration.html

---

## Frequent Integration

 * Everyone integrates *every day*
   1. Start on the current `master`
   1. Develop
   1. Bring it to `master` (direct `commit`, `merge`, or `rebase`)
 * The `master` is always kept functional
 * The `master` is the measure of all things

---

## Advantages of CI

 * Makes **problems small** and manageable.
 * The participants are still **reachable**.
 * **Refactorings** only need to consider **`master`**.
 * If necessary, you can **discard and redo everything**.
 * You can **deliver at any time**.

Sounds good, but ...

### as mentioned, nothing comes for free ...

---

## ... can't things go wrong?

---

## Challenges in CI

 * Broken Build
 * Bug
 * Broken Contract
 * Half-finished work
 * When old versions are needed

---

## Broken Build

> Everyone should be able to start a feature/bugfix\
> from `master` at any time.

 * Automate the build!
   * Every `master` commit triggers a build
 * Standardize the build environment!
   * Reduce dependencies on local installations
   * Against: Works on my machine.
   * Through centralization, automated setup, and/or containers.
 * Fix the `master` immediately!
   * Second highest priority after **production outages**
 * Keep the build process fast! (<< 15 minutes)
 * Protect the `master`!
 * Last to merge loses!

---

## Errors Introduced

> The `master` should always be functional.

 * Test with every build!
   - Unit tests, integration tests, possibly load and performance tests.
 * Test in a clone of the production environment!
   - Every difference between PROD and TEST is an additional risk.

### How much testing is enough?

> Do you dare to release the `master`\
> blindly to production?

Notes:

Benefit: You always have a usable version (release readiness)

---

## Broken API/Contract

> Don't force your colleagues to (immediate) changes!

 * Branch by Abstraction
   - Ensure existing code remains functional
   - Use inheritance, configuration, feature toggles
   - Use deprecation markers
   - Tip: Test the old and new implementation in parallel and compare results.
     - Possibly run the new implementation in PROD in parallel before using its results.

Notes:

Example: Switching from Double to Fraction

---

## Half-finished Work

> The `master` is always release-ready!
> Unfinished features must not compromise this!

 * Aim for an MVP first!
   - Minimum Viable Product:\
     A simple implementation for a valuable part of the intended benefit.
 * Use feature toggling!

---

## When Old Versions Are Needed

 * Stay backward compatible!
 * Use forward-fixing!
   - Avoid fixing production issues by rolling out old versions.
 * Use blue/green or incremental rollouts!
 * Make it easy to use and integrate the latest version!

---

## Excursus: Trunk Based Development

https://trunkbaseddevelopment.com/

---

## Excursus: Git and Gradle

[Git and Gradle](https://kapitel26.github.io/git/2014/05/20/git-und-gradle.html)

---

### So, What Do We Need? (Part 1)

## Workflow/Rules

 * Frequent integration on `master` (workflow)
 * Fix the `master` immediately!
 * Keep the build process fast!
 * Last to merge loses!
 * Stay backward compatible!
 * Make it easy to use and integrate the latest version!

---

### So, What Do We Need? (Part 2)

## Build & Deployment

 * Automate the build!
 * Standardize the build environment!
 * Keep the build process fast!
 * Protect the `master`
 * Test with every build!
 * Test in a clone of the production environment!
 * Use blue/green or incremental rollouts!

---

### So, What Do We Need? (Part 3)

## Techniques/Skills/Patterns

 * Branch by Abstraction
 * Aim for an MVP first!
 * Use feature toggling!
 * Use forward-fixing!

