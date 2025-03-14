#!/bin/bash
echo ">>> Restart all servers for a workshop" 

bash scripts/stop-all.sh
bash scripts/start-all.sh