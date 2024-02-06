#!/bin/bash


#sudo systemctl stop mysql
sudo systemctl stop mariadb


sudo mysqld_safe --skip-grant-tables --skip-networking &


# --- --- --- --- inside SQL
mysql -u root

FLUSH PRIVILEGES;

# For MySQL 5.7.6 and newer as well as MariaDB 10.1.20 and newer, use the following command.
ALTER USER 'root'@'localhost' IDENTIFIED BY 'esUnSecreto';

# For MySQL 5.7.5 and older as well as MariaDB 10.1.20 and older, use:
#SET PASSWORD FOR 'root'@'localhost' = PASSWORD('new_password');

FLUSH PRIVILEGES;


exit;
# --- --- --- --- inside SQL



# sudo kill `cat /var/run/mysqld/mysqld.pid`
# sudo kill `/var/run/mariadb/mariadb.pid`

#sudo systemctl stop mysql
sudo systemctl stop mariadb





#systemctl start mysql
systemctl start mariadb

exit 0;
