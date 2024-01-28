
SHOW DATABASES;
CREATE DATABASE dbdev;
USE dbdev;


create table dbdev.aartista (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.artista (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.cancion (artista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.ccancion (fk_aartista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.curso (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.escritor (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.estudiante (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.libro (id integer not null auto_increment, titulo varchar(255), primary key (id)) engine=InnoDB;
create table dbdev.libro_escritor (escritor_id integer not null, libro_id integer not null) engine=InnoDB;
create table dbdev.personaje (id integer not null auto_increment, puntos decimal(38,2), fecha_guardado datetime(6), nombre varchar(27), primary key (id)) engine=InnoDB;


alter table dbdev.artista add constraint UK_7ptc116swarkeb8akjo5tdm2l unique (nombre);
alter table dbdev.personaje add constraint UK_3ux5ftu5rl5p8ijhl2bel9ujv unique (nombre);

create table inventario_facturacion.cliente_abona (abonos decimal(38,2), cargos decimal(38,2), factura_id integer, id integer not null auto_increment, saldo decimal(38,2), saldo_anterior decimal(38,2), usuario_id integer, fecha datetime(6), detalles varchar(512), primary key (id)) engine=InnoDB;
create table inventario_facturacion.factura (costo_total decimal(38,2) not null, ganancia decimal(38,2) not null, id integer not null auto_increment, iva decimal(38,2) not null, subtotal_sin_iva decimal(38,2) not null, tipo_pago varchar(1), total decimal(38,2) not null, usuario_id integer, fecha_devolucion datetime(6), fecha_emision datetime(6), nombre_completo varchar(255) not null, primary key (id)) engine=InnoDB;
create table inventario_facturacion.factura_detalle (cantidad_producto_vendido integer not null, costo_del_subtotal_por_producto decimal(38,2), costo_unidad decimal(38,2), factura_id integer, ganancia_del_subtotal_por_producto decimal(38,2), ganancia_unidad decimal(38,2), id integer not null auto_increment, iva_del_subtotal_por_producto decimal(38,2), precio_venta_por_producto decimal(38,2) not null, producto_id integer, subtotal_por_producto decimal(38,2), nombre_producto varchar(255), primary key (id)) engine=InnoDB;
create table inventario_facturacion.imagen_producto (id integer not null auto_increment, archivo LONGBLOB, imagen LONGBLOB, primary key (id)) engine=InnoDB;
create table inventario_facturacion.ingresos_egresos (egresos decimal(38,2), id integer not null auto_increment, ingresos decimal(38,2), fecha datetime(6), detalle varchar(512), primary key (id)) engine=InnoDB;
create table inventario_facturacion.inventario (entradas integer, existencia integer, id integer not null auto_increment, producto_id integer, saldo_anterior integer, salidas integer, fecha datetime(6), primary key (id)) engine=InnoDB;
create table inventario_facturacion.producto (costo_unidad decimal(38,2) not null, existencias integer not null, ganancia decimal(38,2) not null, id integer not null auto_increment, precio_venta decimal(38,2) not null, fecha_adquisicion datetime(6), fecha_modificado datetime(6), nombre varchar(512) not null, primary key (id)) engine=InnoDB;
create table inventario_facturacion.usuario (id integer not null auto_increment, pendiente_de_pago decimal(38,2), comentarios varchar(512), apellido varchar(255), apellido_dos varchar(255), nombre varchar(255) not null, nombre_completo varchar(255), nombre_dos varchar(255), primary key (id)) engine=InnoDB;


alter table inventario_facturacion.producto add constraint UK_9su14n91mtgcg5ehl658v4afx unique (nombre);

alter table dbdev.cancion add constraint FKkoeqsbikkwgjhfa5mv9ybfq5a foreign key (artista_id) references dbdev.artista (id);
alter table dbdev.ccancion add constraint FKctopd9ibbcmft5p9j6207b6rb foreign key (fk_aartista_id) references dbdev.aartista (id);
alter table dbdev.libro_escritor add constraint FKnd82f6r1exglb0bbpjwm0ond6 foreign key (escritor_id) references dbdev.escritor (id);
alter table dbdev.libro_escritor add constraint FKesq51snm36vikdx5caqqgwxcu foreign key (libro_id) references dbdev.libro (id);

alter table inventario_facturacion.cliente_abona add constraint FK7px57p1vlvgqvsk7hy3ljgenc foreign key (usuario_id) references inventario_facturacion.usuario (id);
alter table inventario_facturacion.cliente_abona add constraint FK87vei7j6jlrbu2jaosy9cncjh foreign key (factura_id) references inventario_facturacion.factura (id);
alter table inventario_facturacion.factura add constraint FKarq3cr11iiegh05de5ty51bmt foreign key (usuario_id) references inventario_facturacion.usuario (id);
alter table inventario_facturacion.factura_detalle add constraint FK82g5tpb19dn0ed3dh8rjepfeo foreign key (factura_id) references inventario_facturacion.factura (id);
alter table inventario_facturacion.factura_detalle add constraint FK49cxxxb69hbp79ot7q72d1amt foreign key (producto_id) references inventario_facturacion.producto (id);
alter table inventario_facturacion.inventario add constraint FK2jpmjsxwl42blfea24vda6fs6 foreign key (producto_id) references inventario_facturacion.producto (id);


