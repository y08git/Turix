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
import com.turix.modelo.Temporal;
import static java.lang.Math.random;
import java.util.Random;
import javax.faces.event.ActionEvent;



/**
 *
 * @author dianis
 */
@ManagedBean
@RequestScoped
public class RegistroController {
    private Temporal userT = new Temporal();

    public Temporal getUserT() {
        return userT;
    }

    public void setUserT(Temporal userT) {
        this.userT = userT;
    }
    private Usuario user = new Usuario();
    private Utility u = new Utility();
    private String confirmarContraseña;
    private JavaMail mail = new JavaMail();
    private String confirmacion;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

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
    
     public void confirmacion(){
       user= u.confirmar(codigo);
        u.save(user);
        user = null;
    }
    
    
    /**
     * Metodo para guardar a un usuario
     * mandamos a llamar a save de Utility 
     * para gardarlo en la BD
     * @throws javax.mail.MessagingException
     */
    public void agregarUsuario() throws MessagingException {
        Random random= new Random();
        String confirma= String.format("%04d", random.nextInt(10000));
        userT.setCodigo(confirma);
        boolean guardar= u.saveTemp(userT);
        String correo = u.getCorreo(userT);
      
	if(guardar){
        mail.enviar(correo,"Correo de confirmación","<h2>Bienvenido a Notitia </h2><p>Tu código de activación es: </p>"+ confirma+"\n"+"Favor de ingresarlo en el sitio");
        }
    }
}
