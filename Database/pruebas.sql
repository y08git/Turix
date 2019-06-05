/* A D M I N */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Admin', false, 'pass','turixteam2019@gmail.com',false);

/* U S U A R I O S */
/* EN ESPERA */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Arthur García', true, 'pass','jarturoga1337@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Diana Ramirez', true, 'pass','dianissssss@ciencias.unam.mx',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yo', false, 'pass','yo@gmail.com',true);
VALUES ('Daniela Monroy', true, 'pass','danisuuuuuu@ciencias.unam.mx',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Miguel', true, 'pass','miguellllll@gmail.com',false);
/* ASIGNADOS */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Ernesto', false, 'pass','ernestoasfasaas@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Amelia', false, 'pass','angelasfsafsafsaf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Russell', false, 'pass','rusellasfsafafsa@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Canaria', false, 'pass','canariaasfasfasf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yolanda', false, 'pass','yolandaasfasfaf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Zepeda', false, 'pass','zepedaasfasfafs@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Roberto', false, 'pass','robertoasfasfafsaf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Will', false, 'pass','willasfafasf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Miriam', false, 'pass','miriam@gmail.com',false);
INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('info', true, 'contraseña','info@gmail.com',true);

/* T E M A S */
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario, color)
VALUES ('Fondas','buen sazón','Yo','FF0000');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario, color)
VALUES ('alberto','magic','Yo','C680FF');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario, color)
VALUES ('roberto','magic','Yo','000000');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario, color)
VALUES ('Parque España','parque','Yo','FFFFFF');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario, color)
VALUES ('Museos','en el museo','Yo','0000AA');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario, color)
VALUES ('restoran','comes bien','Yo','63FA03');
INSERT INTO notitia.temas (nombre, descripcion, nombre_usuario, color)
VALUES ('Teatro','buen show','Yo','555555');

/* M A R C A D O R E S */
INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('museo soumaya','much impressive WOW','93.23423, 94.34242','Zepeda','Teatro');
INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('catedral','sitio religioso','91.333242, 23.25235325','Russell','Fondas');
INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('bellas artes','conciertos','91.333332, 23.25245325','Amelia','Museos');

/* C O M E N T A R I O S*/
INSERT INTO notitia.comentarios (id_comentario, comentario, fecha, calificacionPositiva, calificacionNegativa, ubicacion, nombre_usuario)
VALUES (DEFAULT,'qué interesante lugar!','21/09/2019' , 0, 0, '91.333332, 23.25245325', 'Roberto');
INSERT INTO notitia.comentarios (id_comentario, comentario, fecha, calificacionPositiva, calificacionNegativa, ubicacion, nombre_usuario)
VALUES (DEFAULT,'no me gustó','24/09/2019' , 0, 0, '93.23423, 94.34242', 'Amelia');
