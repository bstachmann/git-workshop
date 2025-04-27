## `git diff`

Compares the *trees* (file and directory structures) of two commits,
and shows the differences.

```bash
$ git diff <commit1> <commit2>           
```

If only one commit is specified, it is compared with the workspace.

```bash
$ git diff <commit>             
```

Without a commit, the workspace is compared with `HEAD`.
Local changes are shown.

```bash
$ git diff
```

---

### `git-diff` Output Format

Exact description of the differences. Machine-readable.
Human-readable (to some extent).

```diff
diff --git a/average.kts b/average.kts
index 4cd02bf..7eb87f2 100644
--- a/average.kts
+++ b/average.kts
@@ -1,6 +1,6 @@
 if(args.isEmpty())
     throw RuntimeException("No arguments given!")
 
-val s = args.map{ it.toInt() }.sum()
+val summe = args.map{ it.toInt() }.sum()
 
-println("The average is ${s/args.size}")
+println("The average is ${summe/args.size}")
```

---

### Alternative Diff Formats

* With `--word-diff`, changes to texts are displayed more clearly.

* With `--stat`, only the number of changed lines is shown, not the contents.

* With `git difftool`, external diff tools (e.g., `kdiff3`) can be opened.


