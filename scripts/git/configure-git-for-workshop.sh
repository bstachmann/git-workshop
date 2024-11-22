#!/bin/bash
echo ">>> Setup default git configs for workshop" 

git config --global pull.rebase false 
git config --global merge.conflictStyle diff3 
git config --global init.defaultBranch main  
git config --global protocol.file.allow always
