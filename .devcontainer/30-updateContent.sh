#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 

echo ">>> Update installation an clean up website" 
bundle update
bundle install
bundle exec jekyll clean build

