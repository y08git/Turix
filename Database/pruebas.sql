
INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yo', false, 'password','asdfas',false);

INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Admin', false, 'contraseña','turixteam2019@gmail.com',false);

INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('wait', true, 'contraseña','wait@gmail.com',false);

INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('info', true, 'contraseña','info@gmail.com',true);


INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('rigoberto','magic');
INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('alberto','magic');
INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('roberto','magic');
INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('canto','mahou');

INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('marcador1','descripcion1','19.326480,-99.179080','Yo','roberto');

INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('marcador2','descripcion2','19.327178,-99.182041','Yo','roberto');

