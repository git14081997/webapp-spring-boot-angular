#!/bin/sh
./mvnw clean package install
java -jar target/pruebas-0.0.1-SNAPSHOT.jar
exit 0;
