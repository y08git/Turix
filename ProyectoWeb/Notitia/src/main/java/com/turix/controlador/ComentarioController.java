/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Comentarios;
import com.turix.modelo.Marcadores;
import com.turix.modelo.Usuario;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;

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
    
    public String agregarComentario(){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        comentario.setUsuario(user);
        if(user == null){
            return "ingresar?faces-redirect=true";
        }
        if(comentario.getComentario().trim() == ""){
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "No se pueden agregar comentarios vacíos", ""));
        return null;
    }
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agregó correctamente el comentario", ""));
             u.guardarComentario(comentario);
            comentario = null;
            return null;
    }
    
    public String editarComentario(Comentarios comenta){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        comentario.setUsuario(user);
        if(user == null){
            return "ingresar?faces-redirect=true";
        }
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se editó correctamente el comentario", ""));
             u.actualizarComentario(comenta);
            comenta = null;
            return null;
    }
    
    public String eliminarComentario(Comentarios comenta){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        comentario.setUsuario(user);
        if(user == null){
            return "ingresar?faces-redirect=true";
        }
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó el comentario exitosamentes", ""));
             u.borrarComentario(comentario);
             return null;
    }
}
