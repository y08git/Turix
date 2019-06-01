INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yo', false, 'password','asdfas',false);

INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Admin', true, 'contraseña','turixteam2019@gmail.com',false);

INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('wait', true, 'contraseña','wait@gmail.com',false);

INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('info', false, 'infoc','hola@gmail.com',true);

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

INSERT INTO notitia.comentarios (id_comentario, comentario, fecha, calificacionPositiva, calificacionNegativa, ubicacion, nombre_usuario)
VALUES (1, 'Ojala dejaran de fumar marihuana en el patio de mi casa', NOW(), 3, 1, 42, 'Yo')
