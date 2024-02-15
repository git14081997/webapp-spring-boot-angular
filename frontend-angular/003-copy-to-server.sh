#!/bin/bash

MIDIR="/Users/franklin"

echo ""
echo "actualizar el frontend del servidor local" 
echo ""

WEBDIR="$MIDIR/all/repos/fullstack/frontend-angular"
WEBAPP="$MIDIR/all/repos/fullstack/frontend-angular/dist/frontend/browser"
WEBSERVER="/opt/homebrew/var/www"

cd $WEBDIR
sudo ng build
sudo rm -rf $WEBSERVER
sudo mkdir -p $WEBSERVER

cd $WEBAPP
sudo cp -R . $WEBSERVER
sudo chmod 755 $WEBSERVER
brew services restart httpd;

exit 0;
