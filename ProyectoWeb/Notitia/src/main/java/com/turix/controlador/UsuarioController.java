/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Usuario;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
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
    private final Utility u = new Utility();
    private Usuario user;
    private boolean bool;
    private String nombre;
    private String correo;
    private String aContraseña;
    private String contraseña;
    private String confirmarContraseña;
    private JavaMail mail = new JavaMail();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

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
     */
    public void updateUsuario(){
        FacesContext context = getCurrentInstance();
        Usuario usuario = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        bool = false;
        if(usuario == null)
            return;
        u.update(usuario);


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
        return "listaUsuariosEnEspera?faces-redirect=true";
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

    /**Metodo para actualizar un usuario recibido (se invoca desde la lista de informadores)
     * @param user -- El usuario que se actualizara
     * @return String de redireccion
     */
    public String setRegistradosInf(Usuario user) {
        if(user != null){
            user.setEs_informador(!user.isEs_informador());
            u.update1(user);
        }
        return "listaInformadores?faces-redirect=true";
    }

    /**Metodo para actualizar un usuario recibido (se invoca desde la lista de comentaristas)
     * @param user -- El usuario que se actualizara
     * @return String de redireccion
     */
    public String setRegistradosCom(Usuario user) {
        if(user != null){
            user.setEs_informador(!user.isEs_informador());
            u.update1(user);
        }
        return "listaComentaristas?faces-redirect=true";
    }

    /**Metodo para actualizar un usuario recibido (se invoca desde la lista de búsqueda de usuarios)
     * @param user -- El usuario que se actualizara
     * @return String de redireccion
     */
    public String setRegistradosBus(Usuario user) {
        if(user != null){
            user.setEs_informador(!user.isEs_informador());
            u.update1(user);
        }
        return "buscarUsuarios?faces-redirect=true";
    }

    /**Metodo para decir si es comentarista o informador
     *
     * @param usuario -- Usuario al que se le quiere cambiar su estado
     * @return Un String que nos dice que tipo de usuario es
     */
    public String inf(Usuario usuario){
        if(usuario != null){
            if(usuario.isEs_informador()){
                return "Hacer Comentarista";
            }
            return "Hacer informador";
        }
        return null;
    }

    public boolean hayEnEspera() {
        return u.hayUsuariosEnEspera();
    }

    public int contarUsuariosEnEspera() {
        return u.contarEnEspera();
    }

    /**Metodo que regresa a todos los usuarios registrados en espera de asignación
     *
     * @return Un objeto de tipo lista
     */
    public List listaUsuariosEnEspera(){
        return u.darUsuarios();
    }

    /**Metodo que regresa a todos los usuarios registrados en la base
     *
     * @return Un objeto de tipo lista
     */
    public List listaUsuariosRegistrados(){
        return u.darUsuariosRegistrados();
    }

    /**Metodo que regresa a todos los informadores registrados
     *
     * @return Un objeto de tipo lista
     */
    public List listaInformadores(){
        return u.darInformadores();
    }

    /**Metodo que regresa a todos los comentaristas registrados
     *
     * @return Un objeto de tipo lista
     */
    public List listaComentaristas(){
        return u.darComentaristas();
    }

    /**Metodo que regresa a todos los comentaristas registrados
     *
     * @return Un objeto de tipo lista
     */
    public List listaEncontrados(){
        return u.darEncontrados(nombre);
    }

    /**Un metodo para borrar el usuario en esta instancia
     *
     * @param usuario -- Usuario a borrar con hibernate
     * @return String de redireccion
     */
    public String deleteUsuario(Usuario usuario){
        //FacesContext context = getCurrentInstance();
        //user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null){
            return "registro?faces-redirect=true";
        }
        u.delete(usuario);
        return "listaUsuariosRegistrados?faces-redirect=true";
    }

    /**Un metodo para borrar usuarios desde la vista de Informadores
     *
     * @param usuario -- Usuario a borrar con hibernate
     * @return String de redireccion
     */
    public String deleteInformador(Usuario usuario){
        //FacesContext context = getCurrentInstance();
        //user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null){
            return "registro?faces-redirect=true";
        }
        u.delete(usuario);
        return "listaInformadores?faces-redirect=true";
    }

    /**Un metodo para borrar usuarios desde la vista de Comentaristas
     *
     * @param usuario -- Usuario a borrar con hibernate 
     * @return String de redireccion
     */
    public String deleteComentarista(Usuario usuario){
        //FacesContext context = getCurrentInstance();
        //user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null){
            return "registro?faces-redirect=true";
        }
        u.delete(usuario);
        return "listaComentaristas?faces-redirect=true";
    }

    /**Un metodo para borrar usuarios desde la vista de Búsqueda de usuarios
     *
     * @param usuario -- Usuario a borrar con hibernate
     * @return String de redireccion
     */
    public String deleteBuscar(Usuario usuario){
        //FacesContext context = getCurrentInstance();
        //user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null){
            return "registro?faces-redirect=true";
        }
        u.delete(usuario);
        return "buscarUsuarios?faces-redirect=true";
    }
    
    
    public void deleteItself(){
        if (user != null) u.delete(user);
    }

      /**
     * Metodo para guardar a un usuario
     * mandamos a llamar a save de Utility
     * para gardarlo en la BD
     * @throws javax.mail.MessagingException
     */
    public void agregarInformador(Usuario user) throws MessagingException {
        String correo = user.getCorreo();
        System.out.println(correo);
        mail.enviar(correo,"Correo de confirmación","<h2>¡Felicidades! ¡Ya eres Informador en Notitia!</h2>");
    }
    public String cambiarContraseña(){
        FacesContext context = getCurrentInstance();
        Usuario usuario = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null){
            return "inicio?faces-redirect=true";
        }
        if(contraseña.equals(confirmarContraseña)){
            usuario.setContraseña(aContraseña);
            u.update(usuario);
            context
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se ha actualizado los datos", ""));
            return null;
        }else{
            context
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Las contraseñas no coinciden", ""));
            return null;
        }
    }
}
