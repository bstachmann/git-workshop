#!/bin/bash
echo ">>> Start all progress monitor" 

echo $$ >_log/progress-monitor.pid
#sleep 20
./gradlew progress 

