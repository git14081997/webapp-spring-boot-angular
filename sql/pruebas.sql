
-- mySQL

-- crear base de datos
create database dbdev;
-- crear base de datos



-- crear usuario de base de datos
create user 'userapi'@'%' identified by 'esUnSecreto';
-- crear usuario de base de datos



-- dar TODOS los permisos al usuario recien-creado de base de datos
grant all on dbdev.* to 'userapi'@'%';
-- dar TODOS los permisos al usuario recien-creado de base de datos



-- quitar permisos a cierto Usuario de base de datos
revoke all on dbdev.* from 'userapi'@'%';
-- quitar permisos a cierto Usuario de base de datos



-- dar pocos permisos a usuario de base de datos
grant select, insert, delete, update on dbdev.* to 'userapi'@'%';
-- dar pocos permisos a usuario de base de datos





-- Relación uno a muchos 1-M entre 1Artista tiene Muchas canciones
alter table cancion drop foreign key FK_CANCION_ARTISTA;
drop table if exists artista;
drop table if exists cancion;

create table artista (
    id integer not null auto_increment,
    nombre varchar(255),
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8MB4;

create table cancion (
    id integer not null auto_increment,
    nombre varchar(255),
    primary key (id),
    artista_id integer
) engine=InnoDB DEFAULT CHARSET=UTF8MB4;

alter table cancion
    add constraint FK_CANCION_ARTISTA
    foreign key (artista_id)
    references artista (id_artista);
-- Relación uno a muchos 1-M entre 1Artista tiene Muchas canciones













-- relacion Muchos a Muchos M-M entre Libro-Escritor
alter table libro_escritor
   drop foreign key FKnd82f6r1exglb0bbpjwm0ond6

alter table libro_escritor
   drop foreign key FKesq51snm36vikdx5caqqgwxcu

drop table if exists libro;
drop table if exists escritor;
drop table if exists libro_escritor;

create table libro (
    id integer not null auto_increment,
    titulo varchar(255),
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8MB4;

create table escritor (
    id integer not null auto_increment,
    nombre varchar(255),
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8MB4;

create table libro_escritor (
    escritor_id integer not null,
    libro_id integer not null
) engine=InnoDB DEFAULT CHARSET=UTF8MB4;

alter table libro_escritor
   add constraint FK_LE_ESCRITOR
   foreign key (escritor_id)
   references escritor (id)

alter table libro_escritor
   add constraint FK_LE_LIBRO
   foreign key (libro_id)
   references libro (id)

-- relacion Muchos a Muchos M-M entre Libro-Escritor







-- VALOR UNICO
alter table usuario add constraint UK_CORREO unique (correo);
alter table usuario add constraint UK_TELEFONO unique (telefono);


-- relacion 1 apunta a otro 1
create table usuario (
id integer not null auto_increment,
correo varchar(255),
contrasena varchar(255),
nombre varchar(255),
apellido varchar(255),
usuario_modifico integer,
primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8MB4;

alter table usuario
   add constraint FK_USUARIO_USUARIO
   foreign key (usuario_modifico)
   references usuario (id)
-- relacion 1 apunta a otro 1







-- AGREGAR UN CAMPO MANUALMENTE
ALTER TABLE USUARIOS_X ADD COLUMN CREADO DATE;

-- QUITAR UN CAMPO
ALTER TABLE USUARIOS_X DROP COLUMN CREADO;




-- RENOMBRAR CAMPO
ALTER TABLE USUARIOS_X CHANGE FECHA FECHA_CREADO TIMESTAMP;

-- CAMBIAR TIPO DE CAMPO
ALTER TABLE USUARIOS_X CHANGE FECHA FECHA_CREADO DATE;






-- AGREGAR CAMPO FECHA QUE GUARDA INSTANTE DE CREACION.
ALTER TABLE USUARIOS_X ADD COLUMN fecha_creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP;


-- AGREGAR CAMPO FECHA QUE GUARDA INSTANTE DE MODIFICACION.
ALTER TABLE USUARIOS_X ADD COLUMN fecha_MODIFICADO TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;





-- VER SOLO FECHA, SOLO HORA DE UN CAMPO FECHA
SELECT NOMBRE, DATE(fecha_creado) FECHA, TIME(fecha_creado) HORA FROM USUARIOS_X












-- campos diferentes
drop table if exists usuarios_x;
create table usuarios_x (
    id integer not null auto_increment,
    primary key (id),
    nombre varchar(255),
) engine=InnoDB DEFAULT CHARSET=UTF8MB4;



