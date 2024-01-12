#!/bin/zsh

# trasladar ajustes a carpetaCopia de ajustes
DEST="/Users/franklin/Downloads/all/config"
cp ~/.zshrc $DEST
cp ~/.vimrc $DEST
cp ~/.gitconfig $DEST
cp -R ~/bin $DEST


# trasladar webapp angular al servidor local
WEBDIR="/Users/franklin/Downloads/fullstack/frontend"
WEBAPP="/Users/franklin/Downloads/fullstack/frontend/dist/frontend/browser/"
WEBSERVER="/opt/homebrew/var/www"
cd $WEBDIR
sudo ng build
cp -R $WEBAPP $WEBSERVER
sudo chmod 755 $WEBSERVER
sudo brew services restart httpd;


# resguardar, crear copia, respaldar, hacer backup de la base de datos INVENTARIO_FACTURACION
HOST="127.0.0.1"
PORT="3306"
USUARIO="root"
PASSWORD="esUnSecreto"

DIA=`date +"%Y-%m-%d"`
HORA=`date +"%H-%M-%S"`
FECHA=$DIA-$HORA

DESTINO="$HOME/backup-db"
mkdir -p $DESTINO
chmod 700 $DESTINO;

mysqldump -h$HOST -P$PORT -u$USUARIO -p$PASSWORD --events --routines --triggers --default-character-set=utf8 --opt INVENTARIO_FACTURACION > ${DESTINO}/${FECHA}-INVENTARIO_FACTURACION.sql;
mysqldump -h$HOST -P$PORT -u$USUARIO -p$PASSWORD --events --routines --triggers --default-character-set=utf8 --opt INVENTARIO_FACTURACION > ${DESTINO}/INVENTARIO_FACTURACION.sql;
# resguardar, crear copia, respaldar, hacer backup de la base de datos INVENTARIO_FACTURACION



exit 0;
