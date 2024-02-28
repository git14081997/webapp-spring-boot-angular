
create database pruebas 
	character set = 'utf8mb4' 
	collate = 'utf8mb4_bin';

use pruebas;

create table usuario (
	id integer not null auto_increment,
	primary key (id),
	nombre_completo varchar(255),
	dinero decimal(38,2),
	fecha datetime(6)
) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;


-- unique 
alter table usuario
	add constraint uk_usuario_nombre_completo unique (nombre_completo);
-- unique 

-- foreign key 
-- 1 proveedor -> M producto
----alter table producto 
----  add constraint fk_producto_proveedor 
----  foreign key (proveedor_id) 
----  references proveedor (id);
-- foreign key 





create table libro (
	id integer not null auto_increment,
	primary key (id),
	nombre varchar(255),
	usuario_id integer
) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;


-- foreign key 
-- 1 usuario -> M libro
alter table libro 
	add constraint fk_libro_usuario 
	foreign key (usuario_id) 
	references usuario (id);
-- foreign key 




