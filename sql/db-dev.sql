
use dbdev;

create table aartista (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table artista (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table cancion (artista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table ccancion (fk_aartista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table curso (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table escritor (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table estudiante (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table libro (id integer not null auto_increment, titulo varchar(255), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table libro_escritor (escritor_id integer not null, libro_id integer not null) engine=InnoDB DEFAULT CHARSET=UTF8MB4;
create table personaje (id integer not null auto_increment, puntos decimal(38,2), fecha_guardado datetime(6), nombre varchar(27), primary key (id)) engine=InnoDB DEFAULT CHARSET=UTF8MB4;

alter table artista add constraint UK_7ptc116swarkeb8akjo5tdm2l unique (nombre)
alter table personaje add constraint UK_3ux5ftu5rl5p8ijhl2bel9ujv unique (nombre)
alter table cancion add constraint FKkoeqsbikkwgjhfa5mv9ybfq5a foreign key (artista_id) references dbdev.artista (id)
alter table ccancion add constraint FKctopd9ibbcmft5p9j6207b6rb foreign key (fk_aartista_id) references dbdev.aartista (id)
alter table libro_escritor add constraint FKnd82f6r1exglb0bbpjwm0ond6 foreign key (escritor_id) references dbdev.escritor (id)
alter table libro_escritor add constraint FKesq51snm36vikdx5caqqgwxcu foreign key (libro_id) references dbdev.libro (id)

