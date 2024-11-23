#!/bin/bash
echo ">>> Start all progress monitor" 

echo $$ >_log/progress.pid
gradle progress  >_log/server-progress-monitor.log 2>&1 &

