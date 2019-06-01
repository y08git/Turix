/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;
import javax.faces.application.FacesMessage;
import com.turix.controlador.HibernateUtil;
import com.turix.modelo.Temas;
import com.turix.modelo.Usuario;
import java.util.Locale;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import org.hibernate.*;

/**
 *
 * @author dianis
 */
@ManagedBean
@RequestScoped
public class TemaController {

    private Temas tema = new Temas();
    private Utility u = new Utility();
    private boolean f = false;
    public String nom;
    public String usuario;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

     public TemaController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }

    public Temas getTema() {
        return tema;
    }

    public void setTema(Temas tema) {
        this.tema = tema;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


     /**
      * Metodo que guarda un Tema
      * manda a llamar a guardarTema de Utility
      * para guardarlo en la BD
      */
     public void guardarTema(){
             u.guardarTema(tema);
            tema = null;
         }

     /**
      * Metodo que elimina un Tema
      * manda a llamar a eliminarTema de Utility
      * para eliminarlo en la BD
      */
     public void eliminarTema(Temas tema){
             u.eliminarTema(tema);

     }
     
     public void eliminarTema2(){
        u.eliminarTema2(tema, nom);

     }

     /**
      * Metodo que da la lista de todos los temas
      * manda a llamar darTema de Utility
      * para buscarlos en la BD
      * @return List
      */
     public List<Temas> listaTemas(){
        return u.darTemas();
     }

     public String redir(){
         f = true;
         return "buscarTemas";
     }
     
     public List da(){
         FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        String yo = user.getNombre_usuario();
        return u.darMisTemas(yo);
        //marcador.setInformador(user);
     }
}
