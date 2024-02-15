#!/bin/zsh
sudo chown -R franklin:staff .
rm -rf dist
npm install
npm run build
exit 0;
