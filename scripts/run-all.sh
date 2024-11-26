#!/bin/bash
echo ">>> Start all servers for a workshop" 

nohup ./scripts/run-jekyll.sh >_log/jekyll.log 2>&1  &
nohup ./scripts/run-progress-monitor.sh >_log/progress-monitor.log 2>&1 &
nohup ./scripts/run-workshop-website.sh >_log/workshop-website.log 2>&1 &
