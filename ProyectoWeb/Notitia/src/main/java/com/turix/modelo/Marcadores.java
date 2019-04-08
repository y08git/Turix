/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.modelo;

/**
 *
 * @author yair
 */

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(catalog = "notitia", schema = "notitia", name = "marcadores")
public class Marcadores implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ubicacion")
    private String ubicacion;
    
    @Column(name = "datos_utiles")
    private String datos_utiles;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "nombre_usuario")
    private Usuario comentarista;
    
    
    @ManyToOne
    @JoinColumn(name = "nombre")
    private Temas temas;
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDatos_utiles() {
        return datos_utiles;
    }

    public void setDatos_utiles(String datos_utiles) {
        this.datos_utiles = datos_utiles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getInformador() {
        return comentarista;
    }

    public void setInformador(Usuario informador) {
        this.comentarista = informador;
    }

    public Temas getTemas() {
        return temas;
    }

    public void setTemas(Temas temas) {
        this.temas = temas;
    }
    
    
    
}
