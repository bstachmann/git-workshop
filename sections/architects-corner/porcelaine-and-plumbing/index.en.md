#### Architects Corner

## Porcelain and Plumbing


---


## How to Make Software Extensible?


---


Git relies on [Porcelain & Plumbing](https://git-scm.com/book/en/v2/Git-Internals-Plumbing-and-Porcelain), instead of plugins.



---


* `plumbing`
  - fundamental
  - read/edit data structures
* `porcelain`
  - user-friendly, powerful
  - e.g., `log`, `commit`, `merge`, ... 
  - based on `plumbing`
* even `plumbing` is 
  - standardized
  - enables extensions


