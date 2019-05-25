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
@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController {
    private Login login = new Login();
    private Usuario usuario;
    private Utility u = new Utility();
    
    /**Un metodo para obtener un login en LoginController
     * 
     * @return Un objeto de tipo login
     */
    public Login getLogin() {
        return login;
    }
    
    /**Un metodo para declarar un login en LoginController
     * @param login -- Un objeto de tipo login
     */
    public void setLogin(Login login) {
        this.login = login;
    }
    
    /**Constructor para la clase LoginController
     * 
     */
    public LoginController()  {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public Usuario getCurrentUser(){
        FacesContext context = getCurrentInstance();
        usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        
        if(usuario != null) 
            return usuario;
       
        return null;
    }
    
    /**Un metodo para declarar un Nombre en LoginController
     * 
     * @return Un objeto de tipo String
     */
    public String getNombre(){
        FacesContext context = getCurrentInstance();
        usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        
        if(usuario != null) 
            return usuario.getNombre_usuario();
       
        return"Error";
        
    }
    /**Un metodo para declarar un usuario en LoginController
     * 
     * @return Un objeto de tipo Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    
    /**Un metodo para declarar un usuario en LoginController
     * 
     * @param usuario -- Un objeto de tipo usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**Un metodo para manterner un objeto en la sesión actual con la etiqueta de "usuario"
     * 
     * @return String de redireccion
     */
    public String openUser() {
        usuario = u.login(login);
        if (usuario == null) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                     "Fallo de inicio","La contraseña o el usuario no coinciden"));
            return null;
        }
        FacesContext context = getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", usuario);
        return "welcome?faces-redirect=true";
        
    }
    /**Un metodo para quitar cualquier declaración en la sesión actual
     * 
     * @return String de redireccion
     */
    public String logout() {
        FacesContext context = getCurrentInstance();
        context.getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
    /**Un metodo para redireccionar si no hay un usuario en la sesión actual
     * @return la direccion al que el usuario será redireccionado
     */
    public String userTest(){
        if(isLogged())
            return null;
        return "index?faces-redirect=true";
    }
    
    
    /**Un metodo para decir si hay un usuario en la declaración de la sesión actual
     * @return true si existe un usuario en la sesión actual
     */
    public boolean isLogged(){
        FacesContext context = getCurrentInstance();
        Usuario l = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        return l != null;
    }
    
    
    /**Un metodo para decir si un usuario es administrador
     * @return true si es administrador
     */
    public boolean isAdmin(){
        FacesContext context = getCurrentInstance();
        Usuario l = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        if( l == null)
            return false;
        return l.getNombre_usuario().equals("Admin");
    }
    
}