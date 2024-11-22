#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 


echo ">>> Get revealjs sources" 

git submodule update --init revealjs


# echo "Run web server"
# gradle run  &


# echo run progress server
# gradle progress &


# echo "Build website & Webserver on 4000"
# ./run-website-build.sh 
# ./run-server.sh &
# echo "Übungen"
# mkdir -p build/git-uebungen/aufgaben 
# cd build/git-uebungen/aufgaben 
ls
