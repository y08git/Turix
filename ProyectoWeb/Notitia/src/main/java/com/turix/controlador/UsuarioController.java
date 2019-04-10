/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Login;
import com.turix.modelo.Usuario;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;

/**
 *
 * @author yair
 */
    @ManagedBean
    @RequestScoped
public class UsuarioController {
    private Utility u = new Utility();
    private Usuario usuario;
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
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
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
        usuario = new Usuario();
        usuario.setNombre_usuario(user.getNombre_usuario());
        usuario.setEs_informador(user.isEs_informador());
        usuario.setCorreo(user.getCorreo());
        if(contraseña.equals(confirmarContraseña)){
            usuario.setContraseña(contraseña);
            u.update(user, usuario);
            context
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Se ha actualizado los datos", ""));
            context.getExternalContext().getSessionMap().replace("usuario", usuario);
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
    
    public boolean doRefresh(){
        return bool;
    }
    
    public String deleteUsuario(){
        FacesContext context = getCurrentInstance();
        usuario = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null){
            return "registro?faces-redirect=true";
        }
        u.delete(usuario);
        
        return "inicio?faces-redirect=true";
    }
    
}
