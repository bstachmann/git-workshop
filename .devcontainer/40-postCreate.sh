#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 

echo ">>> Configure git" 

scripts/git/configure-git-for-workshop.sh

echo ">>> Get revealjs sources" 

git submodule update --init revealjs


echo ">>> Build generated pages (uebungen) and servers." 

./gradlew build distUebungenMarkdown



