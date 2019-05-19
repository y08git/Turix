/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.modelo;

import java.io.Serializable;

import javax.persistence.*;

/**
 *
 * @author dianis
 */
@Entity
@Table(catalog = "notitia", schema = "notitia", name = "temporal")
public class Temporal implements Serializable{
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
    
    @Transient
    private String confirmaContrasena;
    
    @Column(name = "codigo")
    private String codigo;

    public String getConfirmaContrasena() {
        return confirmaContrasena;
    }

    public void setConfirmaContrasena(String confirmaContrasena) {
        this.confirmaContrasena = confirmaContrasena;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
 
    
    
    
    
}
