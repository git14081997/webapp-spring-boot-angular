#!/bin/zsh
cp ../../backend/target/pruebas-0.0.1-SNAPSHOT.jar app1.jar
docker build -t apiserver0 .
docker run -dit --name container1 -p 8089:8089 apiserver0
exit 0;
