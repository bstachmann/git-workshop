#!/bin/bash
echo ">>> DEVCONTAINER running $0 in $(pwd) as $(whoami) on $(hostname)" 

nohup bash -c 'scripts/run-all.sh &'

