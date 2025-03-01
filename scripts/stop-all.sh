#!/bin/bash
echo ">>> Stopping all servers for a workshop" 

lsof -ti :8000,4000 | xargs -I {} kill {}

