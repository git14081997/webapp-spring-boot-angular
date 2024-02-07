#!/bin/bash
mvn clean package install
cp target/pruebas-0.0.1-SNAPSHOT.jar app.jar
java -jar app.jar
exit 0;
