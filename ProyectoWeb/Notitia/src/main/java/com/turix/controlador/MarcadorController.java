/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Marcadores;
import com.turix.modelo.Temas;
import com.turix.modelo.Usuario;
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

    
    public void guardarMarcador(){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        marcador.setInformador(user);
            u.guardarMarcador(marcador);
            marcador = null;
         }
     
    
     
     
     
     public void eliminarMarcador(){
             u.eliminarMarcador(marcador);  
     
     }
    
    
}
