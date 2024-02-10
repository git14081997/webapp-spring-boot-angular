
-- show collation;
-- character set = 'utf8mb4' collate = 'utf8mb4_bin' 

create database dbdev character set = 'utf8mb4' collate = 'utf8mb4_bin';
use dbdev;

create table aartista       (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table artista        (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table cancion        (artista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table ccancion       (fk_aartista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table curso          (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table escritor       (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table estudiante     (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table libro          (id integer not null auto_increment, titulo varchar(255), primary key (id)) engine=innodb default charset=utf8mb4;
create table libro_escritor (escritor_id integer not null, libro_id integer not null) engine=innodb default charset=utf8mb4;
create table personaje      (id integer not null auto_increment, puntos decimal(38,2), fecha_guardado datetime(6), nombre varchar(27), primary key (id)) engine=innodb default charset=utf8mb4;

alter table artista        add constraint uk_artista_nombre          unique (nombre);
alter table personaje      add constraint uk_personaje_nombre        unique (nombre);
alter table cancion        add constraint fk_cancion_artista         foreign key (artista_id)     references dbdev.artista  (id);
alter table ccancion       add constraint fk_ccancion_aartista       foreign key (fk_aartista_id) references dbdev.aartista (id);
alter table libro_escritor add constraint fk_libro_escritor_escritor foreign key (escritor_id)    references dbdev.escritor (id);
alter table libro_escritor add constraint fk_libro_escritor_libro    foreign key (libro_id)       references dbdev.libro    (id);

