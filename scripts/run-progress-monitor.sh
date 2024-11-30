#!/bin/bash
echo ">>> Start all progress monitor" 

echo $$ >_log/progress-monitor.pid
sleep 15 # without that the file /workspaces/git-workshop/build/git-uebungen/aufgaben.json cannot be read. dunno why
./gradlew progress 

