package com.miguel.modelo;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "prueba")
@SessionScoped
public class Prueba{
	LoginController login = new LoginController();
	Login yo = new Login();
        String Usuario;
        public void start(){
            boolean success = true;
            yo.setContraseña("password");
            yo.setUsuario("Yo");
            login.setLogin(yo);
            login.getUser();
            Usuario = login.getUsuario().getCorreo();
            if (!success) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                        "Fallo de inicio: La contraseña no funciono", ""));
            } else {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_INFO,
                                        "El correo es"+Usuario+":V:V:V:v:V", ""));
            }
        } 
	
}
