#!/bin/bash


ORIGIN=$HOME/all/repos/fullstack/frontend-angular
cd $ORIGIN
sudo npm install
sudo npm run build

ORIGIN=$HOME/all/repos/fullstack/frontend-angular/dist/frontend/browser
cd $ORIGIN
scp -p -r * root@172.233.185.122:/var/www/html


ORIGIN=$HOME/all/repos/fullstack/backend-java-springboot
cd $ORIGIN
./mvnw clean package install
ORIGIN=$HOME/all/repos/fullstack/backend-java-springboot/target/pruebas-0.0.1-SNAPSHOT.jar
scp -p -r $ORIGIN root@172.233.185.122:/root


exit 0;
