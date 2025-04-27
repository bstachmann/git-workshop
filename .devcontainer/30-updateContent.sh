#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 

echo ">>> Configure git for corrent creation of uebungen" 

scripts/git/configure-git-for-workshop.sh

echo ">>> Build generated pages (uebungen) and servers." 

./gradlew build distUebungenMarkdown
./scripts/copy-git-uebungen-to-workspace.sh

echo ">>> Update installation an clean up website" 

bundle update
bundle install
bundle exec jekyll clean build

