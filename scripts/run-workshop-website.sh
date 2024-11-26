#!/bin/bash
echo ">>> Start website server for a workshop" 

echo $$ >_log/workshop-website.pid
sleep 5
./gradlew run
