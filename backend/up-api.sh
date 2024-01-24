#!/bin/sh
./mvnw clean package install
cp target/pruebas-0.0.1-SNAPSHOT.jar .
java -jar ./pruebas-0.0.1-SNAPSHOT.jar
exit 0;
