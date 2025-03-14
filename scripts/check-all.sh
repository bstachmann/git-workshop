#!/bin/bash
echo ">>> Checking for running servers for a workshop" 

lsof -i :8000,4000 -sTCP:LISTEN

