begin;

drop schema if exists notitia cascade;
create schema notitia;
------Creamos usuario
---llave nombre usuario
drop table if exists notitia.Usuario ;
CREATE TABLE notitia.Usuario
(
  nombre_usuario text NOT NULL,
  en_espera Boolean NOT NULL,
  contraseña text NOT NULL,
  correo text NOT NULL,
  es_informador Boolean NOT NULL,
  PRIMARY KEY (nombre_usuario)
);

---pre registri
CREATE TABLE notitia.Temporal
(
  nombre_usuario text NOT NULL,
  contraseña text NOT NULL,
  correo text NOT NULL,
  es_informador Boolean NOT NULL,
  codigo text NOT NULL,
  timestamp timestamp NOT NULL DEFAULT NOW(),
  PRIMARY KEY (nombre_usuario)
);
----------
drop table if exists notitia.Temas;
CREATE TABLE notitia.Temas
(
  nombre text NOT NULL,
  descripcion text NOT NULL,
  PRIMARY KEY (nombre)
);

drop table if exists notitia.Marcadores;
CREATE TABLE notitia.Marcadores
(
  datos_utiles text NOT NULL,
  descripcion text NOT NULL,
  ubicacion text NOT NULL,
  nombre_usuario text NOT NULL,
  nombre text NOT NULL,
  PRIMARY KEY (ubicacion),
  FOREIGN KEY (nombre_usuario) REFERENCES notitia.Usuario(nombre_usuario),
  FOREIGN KEY (nombre) REFERENCES notitia.Temas(nombre)
  ON DELETE CASCADE
);


drop table if exists notitia.Comentarios;
CREATE TABLE notitia.Comentarios
(
  id_comentario serial primary key,
  comentario text NOT NULL,
  fecha DATE NOT NULL,
  calificacionPositiva int NOT NULL,
  calificacionNegativa int NOT NULL,
  ubicacion text NOT NULL,
  nombre_usuario text NOT NULL,
  FOREIGN KEY (ubicacion) REFERENCES notitia.Marcadores(ubicacion),
  FOREIGN KEY (nombre_usuario) REFERENCES notitia.Usuario(nombre_usuario)
    ON DELETE CASCADE
); /*  INSERT INTO notitai.usuario (nombre_usuario, contraseña, correo, es_informador)
		VALUES ('Yo','password','asdfasd@adds',false)	*/




drop extension if exists pgcrypto;
create extension pgcrypto;

comment on table notitia.Usuario
is
'El usuario USUARIO tiene la contraseña PASS después de aplicarle un hash';

create or replace function notitia.hash() returns trigger as $$
  begin
    if TG_OP = 'INSERT' then
       new.contraseña = crypt(new.contraseña, gen_salt('bf', 8)::text);
    end if;
    return new;
  end;
$$ language plpgsql;



comment on function notitia.hash()
is
'Cifra la contraseña del usuario al guardarla en la base de datos.';

create trigger cifra
before insert on notitia.Usuario
for each row execute procedure notitia.hash();

create or replace function notitia.Usuario(usuari text, password text) returns notitia.usuario as $$
  select *     from notitia.usuario
                 where (nombre_usuario LIKE usuari and
                       contraseña LIKE crypt(password, contraseña));
$$ language sql stable;

create or replace function notitia.buscarTema(n_tema text) returns TABLE(nombre text, descripcion text) as $$
select *
from notitia.temas
where nombre ILIKE concat(concat('%',n_tema),'%');
$$ language sql stable;

create or replace function notitia.buscarMarcador(n_marcador text) returns notitia.Marcadores as $$
select *
from notitia.marcadores
where ubicacion LIKE n_marcador;
$$ language sql stable;

CREATE OR REPLACE FUNCTION eliminar() RETURNS trigger

    LANGUAGE plpgsql
    AS $$
BEGIN
  DELETE FROM notitia.Temporal WHERE timestamp < NOW() - INTERVAL '2 days';
  RETURN NEW;
END;
$$;

CREATE TRIGGER eliminar_trigger
    AFTER INSERT ON notitia.Temporal
    EXECUTE PROCEDURE eliminar();


commit;
