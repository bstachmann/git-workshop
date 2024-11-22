#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 

echo ">>> Setup workaround to make git subtree run in this ubuntu devcontainer" 

sudo ln -s /usr/lib/git-core/git-subtree /usr/local/libexec/git-core/
sudo ln -s /usr/bin/echo /usr/local/bin/say


echo ">>> Setup logging dir" 

mkdir -p _log
