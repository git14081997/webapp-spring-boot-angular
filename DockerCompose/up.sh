#!/bin/zsh
docker volume create myvol
docker compose up -d --remove-orphans
exit 0;
