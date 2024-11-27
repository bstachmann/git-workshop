#!/bin/bash
echo ">>> Start website server for a workshop" 

echo $$ >_log/workshop-website.pid
#sleep 1
./gradlew run
