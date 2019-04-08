/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Marcadores;
import com.turix.modelo.Temas;
import com.turix.modelo.Usuario;
import java.util.LinkedList;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;

/**
 *
 * @author dianis
 */
@ManagedBean
@RequestScoped
public class MarcadorController {
     
   
    private Utility u = new Utility();
    private Marcadores marcador = new Marcadores();
    private Temas tema = new Temas();
    public String t ;
    public String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Temas getTema() {
        return tema;
    }

    public void setTema(Temas tema) {
        this.tema=tema;
    }
    
    public MarcadorController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }

    public Marcadores getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcadores marcador) {
        this.marcador = marcador;
    }

    /**
     * Se modificó el xhtml , ahora llama a un atributo del controller, un string
     * posteriormente usamos este string para buscar el tema deseado con existeTema
     * y luego con el valor que nos regresa hacemos marcador.setTemas
     */
    
    public void guardarMarcador(){
        //FacesContext context = getCurrentInstance();
        //Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        //marcador.setInformador(user);
        marcador.setTemas(existeTema(t));
        marcador.setInformador(existeUsuario(usuario));
        //solucion temporal de lo de login analogo a existeTema
            u.guardarMarcador(marcador);
            marcador = null;
         }
    
    public Temas existeTema(String t){
       return u.existeTema(t);
    }
    
    public Usuario existeUsuario(String t){
        return u.existeUsuario(usuario);
    }
   
    
     
     
     
     public void eliminarMarcador(){
             u.eliminarMarcador(marcador);  
     
     }
    
    
}
