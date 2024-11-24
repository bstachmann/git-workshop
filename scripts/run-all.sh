#!/bin/bash
echo ">>> Start all servers for a workshop" 

nohup ./scripts/run-jekyll.sh &
nohup ./scripts/run-progress-monitor.sh &
nohup ./scripts/run-workshop-website.sh &
