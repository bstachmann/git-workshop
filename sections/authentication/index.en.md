### Access to Other Repositories

For `clone`, `fetch`, `pull`, and `push`, access to other repositories is required.
Three types of access are common:

| Protocol | Authentication |
|-----------|-------------------|
| `file:`   | Filesystem, permission through the operating system |
| `ssh:`    | Secure Shell, authentication with ssh certificates, network communication encrypted |
| `https:`  | Secure Web, authentication via password, network communication encrypted |
    

---


### `ssh:` Caching Credentials

On Linux and MacOS systems, private keys are usually cached in memory by the `ssh-agent` of *OpenSSH*. If not already active, an agent can be started with `eval $(ssh-agent)`.

On Windows systems, [Putty](https://www.chiark.greenend.org.uk/~sgtatham/putty/) is often used for SSH access and caching private keys.


---


### `https:` Caching Credentials

Via configuration, Git can [delegate password handling](https://git-scm.com/docs/gitcredentials), e.g.,

```bash
$ git config credential.helper 'cache'
```

---

 * [`git-credential-store`](https://git-scm.com/docs/git-credential-store) stores passwords unencrypted on disk. Insecure if the volume is not encrypted.
 * [`git-credential-cache`](https://git-scm.com/docs/git-credential-cache) stores passwords in memory.
 * [`git-credential-manager`](https://github.com/GitCredentialManager/git-credential-manager)
   - For Windows: Can be selected in the standard Git installer.
