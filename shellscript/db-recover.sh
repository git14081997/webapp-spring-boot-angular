#!/bin/zsh

# $1 = nombre de base de datos que quiero restaurar/recuperar.
# $2 = nombreDelArchivoBackupDB.sql 
# mysql -u root -p $1 < $2
UBICACION_BACKUP_DB="$HOME/backup-db/INVENTARIO_FACTURACION.sql"
mysql -u root -p INVENTARIO_FACTURACION < $UBICACION_BACKUP_DB

exit 0;
