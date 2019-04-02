package com.miguel.proyecto.web;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(catalog = "notitia", schema = "notitia", name = "comentarista")
public class Comentarista implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "correo")
    private String correo;

    @Column(name = "es_informador")
    private boolean es_informador;

    public Comentarista() {
        this.nombre_usuario = "";
        this.contraseña = "";
        this.correo = "";
        this.es_informador = false;
    }
    
    

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEs_informador() {
        return es_informador;
    }

    public void setEs_informador(boolean es_informador) {
        this.es_informador = es_informador;
    }

    
}
