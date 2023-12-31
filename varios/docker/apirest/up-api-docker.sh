#!/bin/bash
rm -rf ./target
#mvn clean install package -DskipTests -e -X
mvn clean install package
docker build -t spring-boot-docker:latest .
docker run --rm -d -p 8081:8081 --network bridge --name sb1 spring-boot-docker
exit 0;