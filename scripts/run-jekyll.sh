#!/bin/bash
echo ">>> Start jekyll server for static content" 

sleep 5
echo $$ >_log/jekyll.pid
bundle exec jekyll serve -H localhost 
