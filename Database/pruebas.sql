INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Admin', false, 'pass','turixteam2019@gmail.com',false);

/* U S U A R I O S */
/* EN ESPERA */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Arthur', true, 'pass','jarturoga1337@gmail.com',false);

/* ASIGNADOS */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Angel', true, 'pass','angel@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yo', true, 'pass','yo@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Miguel', true, 'pass','miguel@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Ernesto', false, 'pass','ernesto@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Amelia', false, 'pass','angel@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Russell', false, 'pass','rusell@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Canaria', false, 'pass','canaria@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yolanda', false, 'pass','yolanda@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Zepeda', false, 'pass','zepeda@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Roberto', false, 'pass','roberto@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Will', false, 'pass','will@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Miriam', false, 'pass','miriam@gmail.com',false);

/* T E M A S */
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario)
VALUES ('Fondas','buen sazón','Miguel');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario)
VALUES ('alberto','magic','Angel');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario)
VALUES ('roberto','magic','Angel');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario)
VALUES ('Parque España','parque','Yo');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario)
VALUES ('Museos','en el museo','Amelia');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario)
VALUES ('restoran','comes bien','Zepeda');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario)
VALUES ('Teatro','buen show','Angel');

/* M A R C A D O R E S */
INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('museo soumaya','much impressive WOW','93.23423, 94.34242','Zepeda','Teatro');
INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('catedral','sitio religioso','91.333242, 23.25235325','Russell','Fondas');
INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('bellas artes','conciertos','91.333332, 23.25245325','Amelia','Museos');

/* C O M E N T A R I O S*/
