#!/bin/bash

_parse_git_branch() {
    git branch 2>/dev/null | grep '^*' | colrm 1 2
}

# Export the prompt showing only the branch name and the final prompt symbol
# Note: If not in a git repo, it will gracefully just show "$ "
export PS1="\[\033[1;36m\]\$(_parse_git_branch)\[\033[00m\] \$ "
