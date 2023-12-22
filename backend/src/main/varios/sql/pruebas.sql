

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
alter table cancion drop foreign key FKkoeqsbikkwgjhfa5mv9ybfq5a
drop table if exists artista;
drop table if exists cancion;

create table artista (
    id integer not null auto_increment,
    nombre varchar(255),
    primary key (id)
) engine=InnoDB;

create table cancion (
    id integer not null auto_increment,
    nombre varchar(255),
    primary key (id),
    artista_id integer
) engine=InnoDB;

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
    ) engine=InnoDB

    create table escritor (
        id integer not null auto_increment,
        nombre varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table libro_escritor (
        escritor_id integer not null,
        libro_id integer not null
    ) engine=InnoDB

    alter table libro_escritor
       add constraint FKnd82f6r1exglb0bbpjwm0ond6
       foreign key (escritor_id)
       references escritor (id)

    alter table libro_escritor
       add constraint FKesq51snm36vikdx5caqqgwxcu
       foreign key (libro_id)
       references libro (id)

-- relacion Muchos a Muchos M-M entre Libro-Escritor






