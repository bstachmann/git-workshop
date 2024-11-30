#!/bin/bash
echo ">>> Setup default git configs for workshop" 

sudo git config --system pull.rebase false 
sudo git config --system merge.conflictStyle diff3 
sudo git config --system init.defaultBranch main  
sudo git config --system protocol.file.allow always
