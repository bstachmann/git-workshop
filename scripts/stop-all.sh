#!/bin/bash
echo ">>> Stopping all servers for a workshop" 

lsof -ti :8080,4000 | xargs -I {} kill {}

