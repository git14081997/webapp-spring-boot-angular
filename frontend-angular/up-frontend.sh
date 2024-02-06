#!/bin/sh
rm -rf dist
npm install
npm run build
npm start
exit 0;
