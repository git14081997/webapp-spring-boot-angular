#!/bin/zsh

HOST="127.0.0.1"
USUARIO="root"
PASSWORD="esUnSecreto"
DBNAME="INVENTARIO_FACTURACION"

DIA=`date +"%Y-%m-%d"`
HORA=`date +"%H-%M-%S"`
FECHA=$DIA-$HORA

DESTINO="$HOME/$DBNAME"
mkdir -p $DESTINO
chmod 700 $DESTINO;

NOMBRE_ARCHIVO="${FECHA}.db"

mysqldump -h$HOST -u$USUARIO -p$PASSWORD --opt $DBNAME > ${DESTINO}/${NOMBRE_ARCHIVO};
chmod 400 $DESTINO/*;

exit 0;
