
package com.miguel.proyecto.web;


import java.util.Date;

/**
 *
 * @author dmonroy
 */
public class Comentario {
    public Date fecha;
    public String contenido;
    public Usuario usuarioC;
    public int id;
    public int calificacionPositiva;
    public int calificacionNegativa;

    public Date getFecha() {
        return fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public Usuario getUsuarioC() {
        return usuarioC;
    }

    public int getId() {
        return id;
    }

    public int getCalificacionPositiva() {
        return calificacionPositiva;
    }

    public int getCalificacionNegativa() {
        return calificacionNegativa;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setUsuarioC(Usuario usuarioC) {
        this.usuarioC = usuarioC;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCalificacionPositiva(int calificacionPositiva) {
        this.calificacionPositiva = calificacionPositiva;
    }

    public void setCalificacionNegativa(int calificacionNegativa) {
        this.calificacionNegativa = calificacionNegativa;
    }
    
    
}
