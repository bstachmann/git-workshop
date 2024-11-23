#!/bin/bash
echo ">>> Start website server for a workshop" 

echo $$ >_log/website.pid
./gradlew run >_log/server-workshop-website.log 2>&1

