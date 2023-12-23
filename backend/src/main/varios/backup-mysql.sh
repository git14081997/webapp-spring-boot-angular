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

NOMBRE_ARCHIVO="${FECHA}.db"

mysqldump -h$HOST -p$PORT -u$USUARIO -p$PASSWORD --events --routines --triggers --default-character-set=utf8 --opt $DBNAME > ${DESTINO}/${NOMBRE_ARCHIVO};

# backup completo de todas las bases de datos.
mysqldump -h$HOST -p$PORT -u$USUARIO -p$PASSWORD --events --routines --triggers --default-character-set=utf8 --opt –all-databases > ${DESTINO}/alldb-${NOMBRE_ARCHIVO};

chmod 400 $DESTINO/*;

exit 0;
