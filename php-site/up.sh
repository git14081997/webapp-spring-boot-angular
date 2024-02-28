#!/bin/bash
#docker run -d -p 8088:80 -v "$PWD":/var/www/html php:8-apache
docker build -t phpapp .
docker run -d -p 8088:80 -v "$PWD/src":/var/www/html phpapp:latest
exit 0;
