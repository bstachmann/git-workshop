#!/bin/bash
echo ">>> Start all servers for a workshop" 

nohup bundle exec jekyll serve -H localhost >_log/server-jekyll.log &
nohup gradle run >_log/server-workshop-website-jekyll.log &
nohup gradle progress  >_log/server-progress-monitor.log &

