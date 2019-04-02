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
@Table(catalog = "notitia", schema = "notitia", name = "comentarios")
public class Comentarios implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_comentario")
    private long id_comentario;
    
    @ManyToOne
    @JoinColumn(name = "ubicacion")
    private Marcadores marcadores;
    
    @Column(name = "comentario")
    private String comentario;
    
    @Column(name = "calificacion")
    private String calificacion;
    
    @ManyToOne
    @JoinColumn(name  = "nombre_usuario")
    private Usuario usuario;

    public long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Marcadores getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(Marcadores marcadores) {
        this.marcadores = marcadores;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
