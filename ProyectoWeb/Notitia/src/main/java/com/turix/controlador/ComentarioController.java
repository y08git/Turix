/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Comentarios;
import com.turix.modelo.Marcadores;
import com.turix.modelo.Usuario;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import static javax.faces.context.FacesContext.getCurrentInstance;

/**
 *
 * @author dmonroy
 */
@ManagedBean
@RequestScoped
public class ComentarioController {
    public Marcadores marcador = new Marcadores();
    public Comentarios comentario = new Comentarios();
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
    public String ubicacion;
    public void setMarcador(Marcadores marcador) {
        this.marcador = marcador;
    }

    public List listaComentarios() throws SQLException{
        return u.getMarca();
    }
    
    public List listaUsuarios() throws SQLException{
        return u.getMiUsuario();
    }

    public void agregarComentario(Comentarios comentario){
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el tema", ""));
             u.guardarComentario(comentario);
            comentario = null;
    }

    public String editarComentario(){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        Usuario u2 = comentario.getUsuario();
        if(user == null){
            return "ingresar?faces-redirect=true";
        }
        else if(u2 == user){
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se editó correctamente el comentario", ""));
             u.actualizarComentario(comentario);
        }
            comentario = null;
            return null;
    }

    public String eliminarComentario(){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        Usuario u2 = comentario.getUsuario();
        if(user == null){
            return "ingresar?faces-redirect=true";
        }
        else if(u2 == user){
        FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó el comentario exitosamentes", ""));
             u.borrarComentario(comentario);
        }
        comentario = null;
            return null;
    }
}
