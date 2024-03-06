#!/bin/bash

npm init -y

npm run tsc -- --init

npm install -D @types/express
npm install -D ts-node-dev
npm install -D typescript

npm install -E express

exit 0;
