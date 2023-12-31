#!/bin/zsh

# variables de entorno
export DB_USERNAME="root"
export DB_PASSWORD="esUnSecreto"

cp ../../backend/target/pruebas-0.0.1-SNAPSHOT.jar app1.jar
docker build -t apiserver0 .
docker run -dit --name container1 -p 8089:8089 apiserver0
exit 0;
