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
    
    /**Un metodo que regresa la anterior Contraseña
     * 
     * @return Un objeto de tipo String
     */
    public String getAContraseña() {
        return aContraseña;
    }
    
    /**Un metodo que recibe la anterior Contraseña
     * @param aContraseña -- Anterior contraseña
     */
    public void setAContraseña(String aContraseña) {
        this.aContraseña = aContraseña;
    }
    
    /**Un metodo que regresa la Contraseña
     * @return Un objeto de tipo String
     */
    public String getContraseña() {
        return contraseña;
    }
    
    /**Un metodo que recibe la Contraseña
     * 
     * @param contraseña -- Un objeto de tipo String
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /**Un metodo que regresa la confirmacion de la Contraseña
     * 
     * @return Un objeto de tipo String
     */
    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }
    /**Un metodo que recibe la Confirmación de la Contraseña
     * 
     * @param confirmarContraseña -- Un objeto de tipo String
     */
    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }
    
    /**Un metodo que regresa el correo
     * 
     * @return Un objeto de tipo String
     */
    public String getCorreo() {
        FacesContext context = getCurrentInstance();
        Usuario a = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(a != null)
            return a.getCorreo();
        return null;
    }
    /**Un metodo que recibe el correo
     * 
     * @param correo -- Un objeto de tipo String
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**Un metodo que regresa el Usuario
     * 
     * @return Un objeto de tipo Usuario
     */
    public Usuario getUser() {
        return user;
    }
    /**Un metodo que recibe el usuario
     * 
     * @param usuario -- Un objeto de tipo Usuario
     */
    public void setUser(Usuario usuario) {
        this.user = usuario;
    }
    
    /**Constructor de UsuarioController
     * 
     */
    public UsuarioController() {
//        FacesContext context = getCurrentInstance();
//        user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
//        if(user != null)
//               correo = user.getCorreo();

    }
    
    /**Un metodo que actualiza los datos del usuario actual
     * 
     * @return String de redireccion
     */
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
    private Usuario getUser(String user_name,String contraseña) {
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
    /**Metodo para eliminar el de esta instancia informador
     * 
     */
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
    
    /**Metodo para actualizar un usuario recibido
     * @param user -- El usuario que se actualizara
     * @return String de redireccion
     */
    public String set(Usuario user) {
        if(user != null){
            user.setEs_informador(!user.isEs_informador());
            u.update1(user);
        }
        return "listaUsuarios?faces-redirect=true";
    }

    /**Metodo para actualizar un usuario recibido
     * @param user -- El usuario que se actualizara
     * @return String de redireccion
     */
    public String setRegistrados(Usuario user) {
        if(user != null){
            user.setEs_informador(!user.isEs_informador());
            u.update1(user);
        }
        return "listaUsuariosRegistrados?faces-redirect=true";
    }
    /**Metodo para decir si es comentarista o informador 
     * 
     * @param usuario -- Usuario al que se le quiere cambiar su estado
     * @return Un String que nos dice que tipo de usuario es
     */
    public String inf(Usuario usuario){
        if(usuario != null){
            if(usuario.isEs_informador()){
                return "Remover permisos";
            }
            return "Ceder Permisos";
        }
        return null;
    }
    
    /**Metodo que regresa a todos los usuarios registrados
     * 
     * @return Un objeto de tipo lista
     */
    public List listaUsuarios(){
        return u.darUsuarios();
    }

    /**Metodo que regresa a todos los usuarios registrados
     * 
     * @return Un objeto de tipo lista
     */
    public List listaUsuariosRegistrados(){
        return u.darUsuariosRegistrados();
    }
    
    /**Un metodo para borrar el usuario en esta instancia
     * 
     * @return String de redireccion
     */
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