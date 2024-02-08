#!/bin/bash
rm -rf dist
npm install
npm run build
npm start
sudo chown -R franklin:staff .
exit 0;
