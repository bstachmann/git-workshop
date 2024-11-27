#!/bin/bash
echo ">>> Start jekyll server for static content" 

echo $$ >_log/jekyll.pid
#sleep 2
bundle exec jekyll serve -H localhost 
