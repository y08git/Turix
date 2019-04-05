/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Comentarios;
import com.turix.modelo.Marcadores;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dmonroy
 */
public class ComentarioController {
    public Marcadores marcador;
    public Comentarios comentario;
    private Utility u = new Utility();

    public ComentarioController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public Comentarios getComentario() {
        return comentario;
    }

    public void setComentario(Comentarios comentario) {
        this.comentario = comentario;
    }
    
    public Marcadores getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcadores marcador) {
        this.marcador = marcador;
    }
    
    public List<Comentarios> listaComentarios(){
        if (marcador == null){
            return null;
        }
        return (List<Comentarios>)u.listaComentarios(marcador);
    }
    
    public void agregarComentario(Marcadores m2,String conten){
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el comentario", ""));
             u.guardarComentario(comentario);
            comentario = null;
    }
    
    public void editarComentario(Comentarios comenta){
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el comentario", ""));
             u.actualizarComentario(comenta);
            comenta = null;
    }
    
    public void eliminarComentario(Comentarios comenta){
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó el tema exitosamentes", ""));
             u.borrarComentario(comentario);
    }
}
