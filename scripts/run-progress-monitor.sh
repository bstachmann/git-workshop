#!/bin/bash
echo ">>> Start all progress monitor" 

sleep 5
echo $$ >_log/progress-monitor.pid
./gradlew progress 

