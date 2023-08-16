#create database automotora;
use automotora;

drop table autos;
drop table propietarios;

create table propietarios(
	id int(11) primary key auto_increment not null,
    nombre varchar(60),
    apellido varchar(60)
);

create table autos(
	id int(11) primary key auto_increment not null,
    modelo varchar(60),
    marca varchar(60),
    propietarioId int(11),
    foreign key(propietarioId) references propietarios(id)
);

#INSERT INTO propietarios(nombre, apellido) VALUES ('Mauro','Martinez');
#INSERT INTO autos(modelo, marca, propietarioId) VALUES ('Ferary','2010','2');
SELECT * FROM propietarios;
#UPDATE propietarios SET nombre = 'Mauro', apellido = 'Martinez' WHERE id = '2';
SELECT * FROM autos;
#SELECT * FROM propietarios WHERE nombre='Mauro';