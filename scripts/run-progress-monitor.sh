#!/bin/bash
echo ">>> Start all progress monitor" 

echo $$ >_log/progress-monitor.pid
sleep 10
./gradlew progress 

