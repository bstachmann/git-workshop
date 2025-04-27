<!-- .slide: data-background-image="sections/large-repos-approaches/monorepo.png" -->

# MONOREPO

---

### How many
 
Dev Teams   
Files  
Lines of Code  
# **?**

notes:

Estimate!

across your **entire company**

Dev Teams: Who has more than 2, 5, 10, 20, 50, 100, 500 

Files: Who has more than 1,000, 10,000, 500,000, 1,000,000

Lines of Code: Who has more than 100,000, 1 million, 10 million, 100 million 

---

# Think Big! <br/><br/><br/><br/>

<!-- .slide: data-background-image="sections/large-repos-approaches/tyranno-watching.png" -->

---

A small thought experiment:

## Put all of this into
# **1 Repo**!

---

... too big 
... too slow 
... bureaucratic
... constant conflicts 
... and where is the team autonomy?   
... completely unagile
... why should I care about stuff from other departments?
... centralized
... every clone takes forever
...

---

but some do it, e.g.,

 * Google
 * Facebook
 * Microsoft
 * Twitter

### Are they completely crazy?

---

A **Monorepo** supports

 * Large Scale **Refactorings**
 * **API** Migrations
 * **Analyses** \
   Vulnerability, Defects, Usage, Data Lineage
 * **Cleanup**

notes:

 * Switching to major releases of C++, PHP
 * When can I turn off an API?
 * Not all big companies do this: Amazon, Netflix

---
## Requirements

 1. **1** Repo for Everything™
 2. Trunk Based Development
 3. Commitment to the stability of `main`   
 4. Scalable build pipeline 

> Google is versioned!

notes:

Requires:

 1. Technology, investment, and team.
 2. Only the `main` state is relevant 
 3. Requires governance maturity.
 3. Tooling (e.g., Bazel).

---

<div style = "font-family: 'Times New Roman';">

> QUOD LICET JOVI \
> NON LICET BOVI

</div>

The giants can and may do this. \
Should we, the dwarfs, follow suit?

notes:

We leave this question open.

---

## Monorepo

| **👎**   | **👍**                      |
|:-------------:|:-------------:|
| High investment in<br/>infrastructure + team   | Large Scale Refactoring |
| Governance maturity<br/>required   | Cross-cutting analyses |
| Central<br/>dependency           | Housekeeping (APIs/Code) |

notes:

A tricky decision because \
short-term investment is high, \
but the benefits lie in long-term aspects.





