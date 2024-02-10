#!/bin/bash
apt update
apt upgrade
apt install mariadb-server mariadb-client 
apt install apache2
apt install openjdk-17-jre openjdk-17-jdk


echo "config mysql"
echo \tDefault options are read from the following files in the given order:
echo \t/etc/my.cnf /etc/mysql/my.cnf ~/.my.cnf

echo ""
echo File: /etc/mysql/mysql.conf.d/mysqld.conf
echo \t[mysqld]
echo \tbind-address = 0.0.0.0
echo ""

echo ./mysql_secure_installation
echo root@localhost:/# systemctl stop mariadb.service
echo root@localhost:/# systemctl start mariadb.service


echo CREATE user 'example_user'@'192.0.2.0' IDENTIFIED BY 'password';
echo GRANT SELECT,INSERT,UPDATE,DELETE ON example-db.* TO 'example_user' IDENTIFIED BY 'password';

exit 0;
