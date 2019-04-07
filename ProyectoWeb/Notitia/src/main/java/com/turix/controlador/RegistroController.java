/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.turix.modelo.Usuario;
import javax.mail.MessagingException;


/**
 *
 * @author dianis
 */
@ManagedBean
@RequestScoped
public class RegistroController {

    private Usuario user = new Usuario();
    private Utility u = new Utility();
    private JavaMail mail = new JavaMail();

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public RegistroController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }

    public void agregarUsuario() throws MessagingException {
           
            u.save(user);
            user = null;
            mail.enviar("dianis0297@gmail.com","Test email","<h2>Java Mail Example</h2><p>hi there!</p>");
            
        }
        
    }
