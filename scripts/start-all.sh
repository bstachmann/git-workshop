#!/bin/bash
echo ">>> Start all servers for a workshop" 

nohup ./scripts/run-jekyll.sh >_log/jekyll.log 2>&1  &
nohup ./scripts/run-webserver-with-progresstracking.sh >_log/webserver-with-progresstracking.log 2>&1 &

echo ">>> Servers launched. It may take a while until they are live."
