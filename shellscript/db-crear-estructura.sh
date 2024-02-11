#!/bin/bash
mysql -u root -p -h localhost -P 3306 < $HOME/all/repos/fullstack/sql/sql-mysql-mariadb/db-drop-inventario_facturacion.sql
mysql -u root -p -h localhost -P 3306 < $HOME/all/repos/fullstack/sql/sql-mysql-mariadb/db-inventario-facturacion.sql
exit 0;
