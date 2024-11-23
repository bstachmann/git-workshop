#!/bin/bash
echo ">>> Start all servers for a workshop" 

echo $$ >_log/jekyll.pid &&  bundle exec jekyll serve -H localhost 2>&1 >_log/server-jekyll.log
