#!/bin/zsh
rm -rf webapp;
mkdir webapp;
cp -R ../../frontend/dist/frontend/browser/ ./webapp
docker build -t miwebserver0 .
docker run -dit --name container0 -p 80:80 miwebserver0
exit 0;
