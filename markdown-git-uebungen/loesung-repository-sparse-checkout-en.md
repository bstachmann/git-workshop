---
layout: page
title: <code>repository-sparse-checkout-en</code>
parent: Lösungen

nav_order: 5
---
## Solution zu Step 0 - START

## Solution zu Step 1 - Sparse-Klon durchführen

Erstelle einen Sparse-Klon von `repo` mit dem Namen `myrepo`,
überprüfe, dass nur Top-Level-Dateien in den Workspace geholt wurden.


<pre><code>$ <b>git clone --sparse repo myrepo</b><br><br>Cloning into 'myrepo'...<br>done.<br><br></code></pre>



<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>ll </b><br><br>total 4.0K<br>-rw-r--r-- 1 vscode vscode 181  README.md<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution zu Step 2 - Verzeichnis hinzufügen

Füge das Verzeichnis `component-a` hinzu .
Überprüfe die neue Konfiguration.
Validiere, dass `component-a` jetzt da ist.


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git sparse-checkout add component-a</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git sparse-checkout list</b><br><br>component-a<br><br></code></pre>



<pre><code>myrepo $ <b>git checkout</b><br><br>Your branch is up to date with 'origin/main'.<br><br></code></pre>



<pre><code>myrepo $ <b>ll </b><br><br>total 8.0K<br>-rw-r--r-- 1 vscode vscode  181  README.md<br>drwxr-xr-x 2 vscode vscode 4.0K  component-a<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution zu Step 3 - Sparse Checkout deaktivieren

| Deaktiviere Sparse-Checkout und führe erneut ein Checkout durch.
| Validiere, dass jetzt alle Dateien da sind.


<pre><code>$ <b>cd myrepo</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git sparse-checkout disable</b><br><br><br></code></pre>



<pre><code>myrepo $ <b>git checkout</b><br><br>Your branch is up to date with 'origin/main'.<br><br></code></pre>



<pre><code>myrepo $ <b>ll </b><br><br>total 12K<br>-rw-r--r-- 1 vscode vscode  181  README.md<br>drwxr-xr-x 2 vscode vscode 4.0K  component-a<br>drwxr-xr-x 2 vscode vscode 4.0K  component-b<br><br></code></pre>



<pre><code>myrepo $ <b>cd ..</b><br><br><br></code></pre>


## Solution zu Step 4 - Klonen und auschecken

Klone `myrepo`, schränke auf `component-a` ein
und mache ein Checkout. Nutze die `--cone`-Option.


<pre><code>$ <b>git clone --sparse repo myclone</b><br><br>Cloning into 'myclone'...<br>done.<br><br></code></pre>



<pre><code>$ <b>cd myclone</b><br><br><br></code></pre>



<pre><code>myclone $ <b>git sparse-checkout init --cone</b><br><br><br></code></pre>



<pre><code>myclone $ <b>git sparse-checkout add component-a</b><br><br><br></code></pre>



<pre><code>myclone $ <b>git checkout</b><br><br>Your branch is up to date with 'origin/main'.<br><br></code></pre>



<pre><code>myclone $ <b>ll </b><br><br>total 8.0K<br>-rw-r--r-- 1 vscode vscode  181  README.md<br>drwxr-xr-x 2 vscode vscode 4.0K  component-a<br><br></code></pre>



<pre><code>myclone $ <b>cd ..</b><br><br><br></code></pre>


[To the exercise](aufgabe-repository-sparse-checkout-en.html){:style="position: fixed; right: 10px; top:60px" .btn .btn-purple}

[To the overview](../../ueberblick-en.html){:style="visibility: hidden"}

