/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;
import javax.faces.application.FacesMessage;
import com.turix.controlador.HibernateUtil;
import com.turix.modelo.Temas;
import java.util.Locale;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
     
   
     
     public void guardarTema(){
          if (tema.getNombre().equals(u.existeTema(tema))) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: Ya existe el tema", ""));
        } else {
               System.out.println(u.existeTema(tema));
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el tema", ""));
             u.guardarTema(tema);
            tema = null;
        }
         
        
         
         }
     
     public List listaTemas(){
         return u.darTemas();
         
     }
     
     public String buscarTema(Temas tema){
         String id = null;
         return id;
         
     }
     
     public void eliminarTema(){
          /**if (!tema.getNombre().equals(u.existeTema(tema))) {
              System.out.println(u.existeTema(tema));
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: No existe el tema "+u.existeTema(tema), ""));
        } else {*/
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó el tema exitosamentes", ""));
             u.eliminarTema(tema);
            
         
     //}
     }    
}
