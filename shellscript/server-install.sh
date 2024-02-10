#!/bin/bash

CONFIG_MYSQL="/etc/mysql/mysql.conf.d/mysqld.cnf"

SRC_DB="/var/lib/mysql"

apt update
apt upgrade
apt install mariadb-server mariadb-client 
apt install apache2
apt install openjdk-17-jre openjdk-17-jdk

systemctl stop mariadb.service



rm -rf $SRC_DB
mkdir -p $SRC_DB
chown -R mysql:mysql $SRC_DB
chmod 750 $SRC_DB



echo "bind-address = 0.0.0.0" >> $CONFIG_MYSQL
echo "lower_case_table_names = 1" >> $CONFIG_MYSQL 
cp $CONFIG_MYSQL /root/mysqld.cnf



systemctl stop mariadb.service
apt remove mariadb-server mariadb-client 
apt autoremove

apt install mariadb-server mariadb-client 
mysql_secure_installation


systemctl stop mariadb.service
systemctl start mariadb.service

exit 0;
