#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 


echo ">>> Starting jekyll server" 

nohup bundle exec jekyll serve -H localhost >_log/server-jekyll.log &
nohup gradle run >_log/server-workshop-website-jekyll.log &
nohup gradle progress  >_log/server-progress-monitor.log &

