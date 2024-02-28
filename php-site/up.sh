#!/bin/bash
docker build -t phpapp .
docker run -d \
	-p 8088:80 \
	-v "$PWD/src":/var/www/html \
	--rm phpapp:latest
exit 0;
