#!/bin/bash

SERVIDOR_DESTINO="172.233.175.128"

ORIGIN=$HOME/all/repos/fullstack/frontend-angular
cd $ORIGIN
sudo npm install
sudo npm run build

ORIGIN=$HOME/all/repos/fullstack/frontend-angular/dist/frontend/browser
cd $ORIGIN
scp -p -r * root@$SERVIDOR_DESTINO:/var/www/html


ORIGIN=$HOME/all/repos/fullstack/backend-java-springboot
cd $ORIGIN
./mvnw clean package install
ORIGIN=$HOME/all/repos/fullstack/backend-java-springboot/target/pruebas-0.0.1-SNAPSHOT.jar
scp -p -r $ORIGIN root@$SERVIDOR_DESTINO:/root

ORIGIN=$HOME/all/repos/fullstack/backend-java-springboot/target/pruebas-0.0.1-SNAPSHOT.jar.original
scp -p -r $ORIGIN root@$SERVIDOR_DESTINO:/root

exit 0;
