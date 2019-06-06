/*
* Clase controladora para comentarios
* Las acciones principales es guardar, eliminar y editar comentarios
* Las acciones secundarias son mostrar los comentarios de acuerdo a la ubicacion,
* verificar la existencia de un usuario y de un marcador
*/
package com.turix.controlador;

import static com.sun.faces.facelets.util.Path.context;
import com.turix.modelo.Calificar;
import com.turix.modelo.Comentarios;
import com.turix.modelo.Marcadores;
import com.turix.modelo.Temas;
import com.turix.modelo.Usuario;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import static javax.faces.context.FacesContext.getCurrentInstance;

/**
 *
 * @author daniela
 */
@ManagedBean
@RequestScoped
public class ComentarioController {
    public Marcadores marcador = new Marcadores();
    public Usuario user;
    public Comentarios comentario;
    private Utility u = new Utility();
    public String t ;
    public String usuario;
    public String ubicacion;
    public int id_comentario;
    private int opcion = -1;

    public int getOpcion() {
        return opcion;
        
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
 
    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public Comentarios getComentario() {
        return comentario;
    }

    public void setComentario(Comentarios comentario) {
        this.comentario = comentario;
    }

    public Marcadores getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcadores marcador) {
        this.marcador = marcador;
    }

    public ComentarioController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    /**
     * Metodo que llama al metodo getMiUsuario de utilty
     * @return List
     */
    public List listaUsuarios() throws SQLException{
        return u.getMiUsuario();
    }

    /**
     * Metodo que llama al metodo darComentarios de utilty
     * @return List
     */
    public List listaComentariosAdmin() throws SQLException{
        return u.darComentariosAdmin();
         
    }
    
    
    /**
     * Metodo que llama al metodo darComentarios de utilty
     * @return List
     * @throws java.sql.SQLException
     */
    public List listaComentarios() throws SQLException{
        return u.darComentarios(t);
    }
    
    /**
     * Metodo que llama al metodo getMiUsuario de utilty
     * @return List
     * @throws java.sql.SQLException
     */
    public List listaUsuariosEnEspera() throws SQLException{
        return u.getMiUsuario();
    }
    
    /**
     * Metodo que llama al metodo existeMarcador de utilty
     * @param t - ubicacion del marcador con formato \<latitud\>+','+\<longitud\>
     * @return Marcadores
     */
    public Marcadores existeMarcador(String t){
       return u.existeMarcador(t);
    }
    
    /**
     * Metodo que llama al metodo existeUsuario de utilty
     * @param t - id del usuario a llamar
     * @return Usuario
     */
    public Usuario existeUsuario(String t){
        return u.existeUsuario(t);
    }
    
    /**
     * Metodo que llama a los metodos:
     * setFecha de hoy
     * setMarcadores con la verificacion de que existe este marcador
     * setUsuario con la verificacion de que existe este usuario
     * Mandamos a llamar a guardarComentario
     */
    public void agregarComentario(){
//        FacesContext.getCurrentInstance().getExternalContext()
//                        .getSessionMap().put("marcador", marcador);
        System.out.print(t);
         comentario.setFecha(new Date());
        //String u2 = comentario.getMarcadores().getUbicacion();
//        marcador = (Marcadores) FacesContext.getCurrentInstance().getExternalContext()
//                .getSessionMap().get("marcador");
        comentario.setMarcadores(u.existeMarcador(t));
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        String yo = user.getNombre_usuario();
        comentario.setUsuario(user);
        System.out.print(marcador.getUbicacion()+"fekfk");
        u.guardarComentario(comentario);
        comentario = null;
    }
    
     /* Metodo que llama al metodo existeTema de utilty
     * @return Temas
     */
    public Temas existeTema(String t){
       return u.existeTema(t);
    }
    /* Metodo que llama al metodo actualizar de utility
     */
    public void editarComentario(){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        String yo = user.getNombre_usuario();
        String coment = comentario.getComentario();
        comentario = u.obtenerC(id_comentario);
        comentario.setComentario(coment);
        if(comentario.getUsuario().getNombre_usuario() == null ? yo == null : comentario.getUsuario().getNombre_usuario().equals(yo)){
            u.actualizarComentario(comentario);
        }
    }
    
    /* Metodo que llama al metodo borrarComentario de utility
     */
    public void eliminarComentario(){
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        String yo = user.getNombre_usuario();
        comentario = u.obtenerC(id_comentario);
        System.out.print(comentario.getUsuario().getNombre_usuario());
        System.out.print(yo);
        if(comentario.getUsuario().getNombre_usuario().equals(yo)){
            u.borrarComentario(comentario);
        }
        System.out.print("NO");
    }
    
    /**Metodo para comprobar si un comentario fue calificado por el usuario actual
     * 
     * @param c
     * @return 
     */
    public boolean test(Comentarios c){
        FacesContext context = getCurrentInstance();
        user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        comentario = c;
        if(user == null)
            return true;
        return false;
    }
    
    /**Metodo para guardar, actualizar o eliminar una calificacion
     * 
     * @param c - comentario que se relacionara con el usuario en la cuenta actual
     * @return String de redireccionamiento
     */
    public String actualizarCal(Comentarios c){
        boolean existe;
        System.out.println("\n\n\n\n\nopcion = "+opcion+"\n\n\n\n\nUsuario =? null ->"+
                (user == null) +"\n\n\n\nid_comentario = "+c.getId_comentario()+"\n\n\n\n");
        if(user == null)
            return null;
        Calificar cal = u.calificacion(user, c);
        if(opcion == -1){
            if(cal != null)
                u.delete(cal);
            return null;
        }
        if(cal == null){
            cal = new Calificar();
            cal.setComentarios(c);
            cal.setUsuario(user);
            existe = false;
        }else{
            existe = true;
        }
        if(opcion == 1)
                cal.setGustar(true);
            else 
                cal.setGustar(false);
        if(existe)
            u.update(cal);
        else
            u.save(cal);
        return null;
    }
}
