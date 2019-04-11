/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Login;
import com.turix.modelo.Usuario;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author yair
 */
    @ManagedBean
    @RequestScoped
public class UsuarioController {
    private Utility u = new Utility();
    private Usuario user;
    private boolean bool;
    private String correo;
    private String aContraseña;
    private String contraseña;
    private String confirmarContraseña;

    public String getAContraseña() {
        return aContraseña;
    }

    public void setAContraseña(String aContraseña) {
        this.aContraseña = aContraseña;
    }
    
    
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }

    public String getCorreo() {
        FacesContext context = getCurrentInstance();
        Usuario a = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(a != null)
            return a.getCorreo();
        return null;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario usuario) {
        this.user = usuario;
    }
    
    
    public UsuarioController() {
//        FacesContext context = getCurrentInstance();
//        user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
//        if(user != null)
//               correo = user.getCorreo();
    }
    
    
    public String updateUsuario(){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        bool = false;
        if(user == null)
            return "registro?faces-redirect=true";
        
//        if(correo != null && !correo.equals(""))
//            user.setCorreo(correo);
        
        if(u.login(new Login(user.getNombre_usuario(),aContraseña)) == null){
            context
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "La contraseña es Incorrecta", ""));
            return null;
        }
        this.user = new Usuario();
        this.user.setNombre_usuario(user.getNombre_usuario());
        this.user.setEs_informador(user.isEs_informador());
        this.user.setCorreo(user.getCorreo());
        if(contraseña.equals(confirmarContraseña)){
            this.user.setContraseña(contraseña);
            u.update(user, this.user);
            context
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Se ha actualizado los datos", ""));
            context.getExternalContext().getSessionMap().replace("usuario", this.user);
            bool = true;
            return null;
        }else{
            context
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Las contraseñas no coinciden", ""));
        }
        
        return null;
        
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
    
    public String deleteUsuario(){
        FacesContext context = getCurrentInstance();
        user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(user == null){
            return "registro?faces-redirect=true";
        }
        u.delete(user);
        
        return "inicio?faces-redirect=true";
    }
    
}