#!/bin/bash
echo ">>> Start website server for a workshop" 

echo $$ >_log/workshop-website.pid
./gradlew run
