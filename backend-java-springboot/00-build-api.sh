#!/bin/bash
sudo chown -R franklin:staff .
./mvnw clean package
cp ./target/pruebas-0.0.1-SNAPSHOT.jar /Users/franklin/Desktop/up-webapp/api.jar
exit 0;
