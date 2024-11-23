#!/bin/bash
echo ">>> Start all servers for a workshop" 

mkdir -p _log

./scripts/run-jekyll.sh &
./scripts/run-progress-monitor.sh &
./scripts/run-workshop-website.sh &
