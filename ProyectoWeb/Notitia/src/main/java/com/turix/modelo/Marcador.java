/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.modelo;

/**
 *
 * @author dmonroy
 */
public class Marcador {
    private int id;
    private int calificacion;
    private String descripcion;
    private LinkedList<Comentario>();
    private String titulo;
    private String fecha;

    public Marcador(int id, int calificacion, String descripcion, String titulo, String fecha) {
        this.id = id;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
