INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yo', false, 'password','asdfas',false);

INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Admin', false, 'contraseña','turixteam2019@gmail.com',false);

INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('wait', true, 'contraseña','wait@gmail.com',false);

INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('rigoberto','magic');
INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('alberto','magic');
INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('roberto','magic');
INSERT INTO notitia.temas (nombre, descripcion)
VALUES ('canto','mahou');

INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('datos inutiles','much impressive WOW','2342.23423,23423.34242','Yo','rigoberto');

INSERT INTO notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre)
VALUES ('rigoberto','magic','42','Yo','roberto');
