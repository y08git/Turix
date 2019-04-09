/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Login;
import com.turix.modelo.Usuario;
import java.security.Principal;
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
@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController {
    private Login login = new Login();
    private Usuario usuario;
    private Utility u = new Utility();

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
    public LoginController()  {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsusario(){
        return (Usuario) u.getUsuario().get(0);
    }
    
    public String getNombre(){
        FacesContext context = getCurrentInstance();
        usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        
        if(usuario != null) 
            return usuario.getNombre_usuario();
       
        return"Error";
        
    }
    
    
    public String openUser() {
        usuario = u.login(login);
        if (usuario == null ){
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                     "Fallo de inicio: La contraseña o el usuario no coinciden",""));
            return null;
        }
        FacesContext context = getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", usuario);
        return "inicio?faces-redirect=true";
        
    }
    
    
    public String logout() {
        FacesContext context = getCurrentInstance();
        context.getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
    public boolean isLogged(){
        FacesContext context = getCurrentInstance();
        Usuario l = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        return l != null;
    }
    /**
     * POR IMPLEMENTAR
     * 
     *funcion para hacer login en el propio objeto
     */
}
