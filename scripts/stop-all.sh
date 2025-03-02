#!/bin/bash
echo ">>> Stopping all servers for a workshop" 

lsof -i :8000,4000 -sTCP:LISTEN 

lsof -ti :8000,4000 -sTCP:LISTEN | xargs -I {} sh -c "echo killing {}; kill {}"
