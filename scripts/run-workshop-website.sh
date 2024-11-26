#!/bin/bash
echo ">>> Start website server for a workshop" 

sleep 5
echo $$ >_log/workshop-website.pid
./gradlew run
