begin;

-- create role miguel with superuser;
-- alter role miguel with login;

-- createdb ejemplo -O miguel

drop schema if exists notitia cascade;
create schema notitia;

drop table if exists notitia.Comentarista ;
CREATE TABLE notitia.Comentarista
(
  nombre_usuario text NOT NULL,
  contraseña text NOT NULL,
  correo text NOT NULL,
  es_informador Boolean NOT NULL,
  PRIMARY KEY (nombre_usuario)
);

drop table if exists notitia.Temas;
CREATE TABLE notitia.Temas
(
  nombre INT NOT NULL,
  descripcion text NOT NULL,
  PRIMARY KEY (nombre)
);

drop table if exists notitia.Marcadores;
CREATE TABLE notitia.Marcadores
(
  datos_utliles text NOT NULL,
  descripcion text NOT NULL,
  ubicacion text NOT NULL,
  nombre_usuario text NOT NULL,
  nombre INT NOT NULL,
  PRIMARY KEY (ubicacion),
  FOREIGN KEY (nombre_usuario) REFERENCES notitia.Comentarista(nombre_usuario),
  FOREIGN KEY (nombre) REFERENCES notitia.Temas(nombre)
);


drop table if exists notitia.Comentarios;
CREATE TABLE notitia.Comentarios
(
  id_comentario Serial NOT NULL,
  comentario text NOT NULL,
  fecha DATE NOT NULL,
  calificacion text NOT NULL,
  ubicacion text NOT NULL,
  nombre_usuario text NOT NULL,
  PRIMARY KEY (id_comentario, ubicacion),
  FOREIGN KEY (ubicacion) REFERENCES notitia.Marcadores(ubicacion),
  FOREIGN KEY (nombre_usuario) REFERENCES notitia.Comentarista(nombre_usuario)
);




drop extension if exists pgcrypto;
create extension pgcrypto;

comment on table notitia.Comentarista
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
before insert on notitia.Comentarista
for each row execute procedure notitia.hash();

create or replace function notitia.Comentarista(usuario text, password text) returns boolean as $$
  select exists(select 1
                  from notitia.Comentarista 
                 where nombre_usuario = usuario and
                       contraseña = crypt(password, contraseña));
$$ language sql stable;


commit;
