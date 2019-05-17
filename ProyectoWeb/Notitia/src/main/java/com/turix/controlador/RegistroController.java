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
import javax.mail.MessagingException;
import com.turix.modelo.Usuario;
import static java.lang.Math.random;
import java.util.Random;


/**
 *
 * @author dianis
 */
@ManagedBean
@RequestScoped
public class RegistroController {

    private Usuario user = new Usuario();
    private Utility u = new Utility();
    private String confirmarContraseña;
    private JavaMail mail = new JavaMail();
    private String confirmacion;
    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }
    
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
    /**
     * Metodo para guardar a un usuario
     * mandamos a llamar a save de Utility 
     * para gardarlo en la BD
     */
    public void agregarUsuario() throws MessagingException {
        Random random= new Random();
        u.save(user);
        String correo = u.getCorreo(user);
        user = null;
        String codigo= String.format("%04d", random.nextInt(10000));
	mail.enviar(correo,"Test email","<h2>Java Mail Example</h2><p>Bienvenido tu código de activación es: !</p>"+ codigo);
    }
}
