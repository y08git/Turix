package com.turix.modelo;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(catalog = "notitia", schema = "notitia", name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Column(name = "en_espera")
    private boolean en_espera;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "correo")
    private String correo;

    @Column(name = "es_informador")
    private boolean es_informador;
    
    @Transient
    private String confirmaContrasena;
    
    @Transient
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario() {
        this.nombre_usuario = "";
        this.contraseña = "";
        this.correo = "";
        this.es_informador = false;
    }
    
    

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario.trim();
    }

    public boolean getEn_espera() {
        return en_espera;
    }

    public void setEn_espera(boolean value) {
        this.en_espera = value;
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

    public String getConfirmaContrasena() {
        return confirmaContrasena;
    }

    public void setConfirmaContrasena(String confirmaContrasena) {
        this.confirmaContrasena = confirmaContrasena;
    }
        
}