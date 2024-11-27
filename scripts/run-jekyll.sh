#!/bin/bash
echo ">>> Start jekyll server for static content" 

echo $$ >_log/jekyll.pid
bundle exec jekyll serve -H localhost 
