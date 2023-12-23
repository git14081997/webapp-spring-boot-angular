#!/bin/zsh

HOST="127.0.0.1"
PORT="3306"
USUARIO="root"
PASSWORD="esUnSecreto"
DBNAME="INVENTARIO_FACTURACION"

DIA=`date +"%Y-%m-%d"`
HORA=`date +"%H-%M-%S"`
FECHA=$DIA-$HORA

DESTINO="$HOME/$DBNAME"
mkdir -p $DESTINO
chmod 700 $DESTINO;

mysqldump -h$HOST -P$PORT -u$USUARIO -p$PASSWORD --events --routines --triggers --default-character-set=utf8 --opt INVENTARIO_FACTURACION > ${DESTINO}/${FECHA}-INVENTARIO_FACTURACION;
mysqldump -h$HOST -P$PORT -u$USUARIO -p$PASSWORD --events --routines --triggers --default-character-set=utf8 --opt DBDEV                  > ${DESTINO}/${FECHA}-DBDEV;

exit 0;
