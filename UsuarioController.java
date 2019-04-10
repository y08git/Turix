/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.controlador.HibernateUtil;
import com.turix.modelo.Usuario;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import org.hibernate.*;

/**
 *
 * @author yair
 */
@ManagedBean
@RequestScoped
public class UsuarioController {
    
    private Usuario user = new Usuario();
    private Utility u = new Utility();
    
    public UsuarioController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public Usuario getUser(String user_name,String contraseña) {
        Session session = null;
        Usuario usuario = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            usuario =  (Usuario) session.get(Usuario.class, user_name);
        } catch (HibernateException e) {
            usuario = null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return usuario;
    }
    
    public void eliminarInformador(){
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
                                    "Se retiraron privilegios de informador al usuario", ""));
            u.eliminarInformador(user);
     //}
    }  
    
    public String set(Usuario user) {
        if(user != null){
            user.setEs_informador(!user.isEs_informador());
            u.update1(user);
        }
        return "listaUsuarios?faces-redirect=true";
        
    }
    
    public String inf(Usuario usuario){
        if(usuario != null){
            if(usuario.isEs_informador()){
                return "Remover permisos";
            }
            return "Ceder Permisos";
        }
        return null;
    }
    
    public List listaUsuarios(){
        return u.darUsuarios();
    }
}
