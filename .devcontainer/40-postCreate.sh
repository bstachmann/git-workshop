#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 

echo ">>> Configuring Shell prompt"

echo "export PROMPT_DIRTRIM=2" >>/home/vscode/.bashrc


echo ">>> Get revealjs sources" 

git submodule update --init revealjs
