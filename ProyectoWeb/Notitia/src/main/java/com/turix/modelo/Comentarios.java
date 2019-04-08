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
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(catalog = "notitia", schema = "notitia", name = "comentarios")
public class Comentarios implements Serializable{
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private int id_comentario;
    

    @ManyToOne
    @JoinColumn(name = "ubicacion")
    private Marcadores marcadores;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "calificacionPositiva")
    private int calificacionPositiva;

    @Column(name = "calificacionNegativa")
    private int calificacionNegativa;

    @ManyToOne
    @JoinColumn(name  = "nombre_usuario")
    private Usuario usuario;


    @Column(name  = "fecha")
    private Date fecha;

    public long getId_comentario() {
        return id_comentario;
    }

    public Marcadores getMarcadores() {
        return marcadores;
    }
    
    public String darUbicacion(){
         return marcadores.getUbicacion();
    }

    public String getComentario() {
        return comentario;
    }

    public int getCalificacionPositiva() {
        return calificacionPositiva;
    }

    public int getCalificacionNegativa() {
        return calificacionNegativa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public void setMarcadores(Marcadores marcadores) {
        this.marcadores = marcadores;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setCalificacionPositiva(int calificacionPositiva) {
        this.calificacionPositiva = calificacionPositiva;
    }

    public void setCalificacionNegativa(int calificacionNegativa) {
        this.calificacionNegativa = calificacionNegativa;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
