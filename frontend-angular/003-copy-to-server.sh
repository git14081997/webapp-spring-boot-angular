#!/bin/zsh

sudo chown -R franklin:staff .
rm -rf dist
npm install
npm run build

MIDIR="/Users/franklin"

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
brew services stop httpd;
brew services start httpd;

exit 0;
