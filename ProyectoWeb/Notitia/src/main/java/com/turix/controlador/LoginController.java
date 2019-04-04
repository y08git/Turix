/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Usuario;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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


    public String openUser() {
        u.login(login, usuario);
        return null;
    }


    /**
     * POR IMPLEMENTAR
     *
     *funcion para hacer login en el propio objeto
     */
}
