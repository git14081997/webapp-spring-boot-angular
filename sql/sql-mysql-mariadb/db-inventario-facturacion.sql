
-- show collation;
-- character set = 'utf8mb4' collate = 'utf8mb4_bin' 

create database inventario_facturacion character set = 'utf8mb4' collate = 'utf8mb4_bin';
use inventario_facturacion;

create table cliente_abona    (abonos decimal(38,2), cargos decimal(38,2), factura_id integer, id integer not null auto_increment, saldo decimal(38,2), saldo_anterior decimal(38,2), usuario_id integer, fecha datetime(6), detalles varchar(512), primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table factura          (costo_total decimal(38,2) not null, ganancia decimal(38,2) not null, id integer not null auto_increment, iva decimal(38,2) not null, subtotal_sin_iva decimal(38,2) not null, tipo_pago varchar(1), total decimal(38,2) not null, usuario_id integer, fecha_devolucion datetime(6), fecha_emision datetime(6), nombre_completo varchar(512) not null, primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table factura_detalle  (cantidad_producto_vendido integer not null, costo_del_subtotal_por_producto decimal(38,2), costo_unidad decimal(38,2), factura_id integer, ganancia_del_subtotal_por_producto decimal(38,2), ganancia_unidad decimal(38,2), id integer not null auto_increment, iva_del_subtotal_por_producto decimal(38,2), precio_venta_por_producto decimal(38,2) not null, producto_id integer, subtotal_por_producto decimal(38,2), nombre_producto varchar(512), primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table imagen_producto  (id integer not null auto_increment, imagen longblob, primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table ingresos_egresos (egresos decimal(38,2), id integer not null auto_increment, ingresos decimal(38,2), fecha datetime(6), detalle varchar(512), primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table inventario       (entradas integer, existencia integer, id integer not null auto_increment, producto_id integer, saldo_anterior integer, salidas integer, fecha datetime(6), primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table producto         (proveedor_id integer, costo_unidad decimal(38,2) not null, existencias integer not null, ganancia decimal(38,2) not null, id integer not null auto_increment, precio_venta decimal(38,2) not null, fecha_adquisicion datetime(6), fecha_modificado datetime(6), nombre varchar(512) not null, primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table usuario          (id integer not null auto_increment, pendiente_de_pago decimal(38,2) not null, comentarios varchar(512), apellido varchar(512), apellido_dos varchar(255), nombre varchar(255) not null, nombre_completo varchar(255), nombre_dos varchar(255), primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;
create table proveedor        (id integer not null auto_increment, nombre varchar(512) not null, direccion varchar(512), primary key (id)) engine=innodb charset=utf8mb4 collate=utf8mb4_bin;

alter table producto        add constraint uk_producto_nombre          unique (nombre);
alter table producto        add constraint fk_producto_proveedor       foreign key (proveedor_id)  references proveedor (id);
alter table cliente_abona   add constraint fk_cliente_abona_usuario    foreign key (usuario_id)    references usuario   (id);
alter table cliente_abona   add constraint fk_cliente_abona_factura    foreign key (factura_id)    references factura   (id);
alter table factura         add constraint fk_factura_usuario          foreign key (usuario_id)    references usuario   (id);
alter table factura_detalle add constraint fk_factura_detalle_factura  foreign key (factura_id)    references factura   (id);
alter table factura_detalle add constraint fk_factura_detalle_producto foreign key (producto_id)   references producto  (id);
alter table inventario      add constraint fk_inventario_producto      foreign key (producto_id)   references producto  (id);

-- se calculara
-- cuanto ya esta pagado y cuanto falta por pagar
alter table factura add column pagado decimal(38,2);

-- ahora voy a guardar una imagen por producto
alter table producto add column imagen longblob




