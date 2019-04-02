/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.proyecto.web;

/**
 *
 * @author yair
 */


import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(catalog = "notitia", schema = "notitia", name = "temas")
public class Temas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
