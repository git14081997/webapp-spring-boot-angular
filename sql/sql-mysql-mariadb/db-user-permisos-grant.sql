
-- grant all privileges on inventario_facturacion.* to 'noroot'@'127.0.0.1';
-- grant all privileges on inventario_facturacion.* to 'noroot'@'localhost';
-- grant all privileges on inventario_facturacion.* to 'noroot'@'%';

grant select,insert,update on inventario_facturacion.* to 'noroot'@'127.0.0.1';
grant select,insert,update on inventario_facturacion.* to 'noroot'@'localhost';
grant select,insert,update on inventario_facturacion.* to 'noroot'@'%';
flush privileges;

