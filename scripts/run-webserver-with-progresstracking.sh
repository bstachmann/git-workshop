#!/bin/bash
echo ">>> Start all progress monitor" 

sleep 15 # without that the file /workspaces/git-workshop/build/git-uebungen/aufgaben.json cannot be read. dunno why
echo $$ >_log/webserver-with-progresstracking.pid
./gradlew progress 

