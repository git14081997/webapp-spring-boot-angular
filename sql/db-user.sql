
create user 'noroot'@'localhost' identified by 'esUnSecreto';
create user 'noroot'@'%'         identified by 'esUnSecreto';

grant all privileges on inventario_facturacion.* to 'noroot'@'localhost';
grant all            on inventario_facturacion.* to 'noroot'@'%';
flush privileges;

grant select,insert,update on inventario_facturacion.* to 'noroot'@'localhost';
grant select,insert,update on inventario_facturacion.* to 'noroot'@'%';

revoke all on inventario_facturacion.* from 'noroot'@'localhost';
revoke all on inventario_facturacion.* from 'noroot'@'%';

drop user 'noroot'@'localhost';
drop user 'noroot'@'%';

show grants for 'noroot'@'localhost';
show grants for 'noroot'@'%';

