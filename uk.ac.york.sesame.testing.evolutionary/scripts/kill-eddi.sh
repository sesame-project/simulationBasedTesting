#!/bin/sh

# COPY SCRIPT INTO WSL /home/<...>/kill-eddi.sh
cd ~/eddi-docker
docker compose down
sleep 10
docker ps -aq | xargs docker stop | xargs docker rm | echo
echo "Done"