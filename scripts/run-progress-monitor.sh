#!/bin/bash
echo ">>> Start all servers for a workshop" 

echo $$ >_log/progress.pid && gradle progress  >_log/server-progress-monitor.log 2>&1 &

