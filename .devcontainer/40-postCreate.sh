#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 


echo ">>> Get revealjs sources" 

git submodule update --init revealjs


echo ">>> Build generated pages (uebungen) and servers." 

gradle build

echo ">>> Build website" 

bundle exec jekyll build


