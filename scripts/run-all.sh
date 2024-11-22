#!/bin/bash
echo ">>> Start all servers for a workshop" 

mkdir -p _log

bundle exec jekyll serve -H localhost 2>&1 >_log/server-jekyll.log &
gradle run >_log/server-workshop-website-jekyll.log 2>&1 &
gradle progress  >_log/server-progress-monitor.log 2>&1 &

