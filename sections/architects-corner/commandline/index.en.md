#### Architects Corner


## The Command Line


---


### Git is not a Client-Server System

Traditional version control systems:

 1. Server
    * Manages the archive version history on the server
    * Running process/daemon
 1. Client (possibly multiple)
    * Manages the workspace (working files) on the client
 1. Continuous communication between client and server


---


### Git is a Command-Line Tool

A **repository** in Git consists of files
stored in a directory (usually `.git`). 

Git consists of more than 100 command-line commands* that can manipulate and query this repository.

Git is passive: There is no continuously running process (daemon).

*Don't Panic: In everyday use, you need <10*


---

**Does this mean I have to work with the command line from now on?**

No, there are numerous graphical user interfaces for desktop and web. Nevertheless, you should know Git's command line:

 * **All** Git functionalities are accessible this way
 * Some tasks are very **efficient**
 * **Tips and guides** usually show commands
 * Commands make it easy to **automate** processes.

Experienced Git users often use both.