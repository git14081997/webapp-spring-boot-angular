#!/bin/zsh

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
mysqldump -h$HOST -P$PORT -u$USUARIO -p$PASSWORD --events --routines --triggers --default-character-set=utf8 --opt DBDEV                  > ${DESTINO}/${FECHA}-DBDEV.sql;

exit 0;
