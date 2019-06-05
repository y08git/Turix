/*
* Clase controladora para comentarios
* Las acciones principales es guardar, eliminar y editar comentarios
* Las acciones secundarias son mostrar los comentarios de acuerdo a la ubicacion,
* verificar la existencia de un usuario y de un marcador
*/
package com.turix.controlador;

import static com.sun.faces.facelets.util.Path.context;
import com.turix.modelo.Comentarios;
import com.turix.modelo.Marcadores;
import com.turix.modelo.Temas;
import com.turix.modelo.Usuario;
import java.sql.SQLException;
import java.util.Date;
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
    public Comentarios comentario = new Comentarios();
    private Utility u = new Utility();
    public String t ;
    public String usuario;
    public String ubicacion;
    public int id_comentario;

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
        return u.darComentarios();
    }
    
    /**
     * Metodo que llama al metodo getMiUsuario de utilty
     * @return List
     */
    public List listaUsuariosEnEspera() throws SQLException{
        return u.getMiUsuario();
    }
    
    /**
     * Metodo que llama al metodo existeMarcador de utilty
     * @return Marcadores
     */
    public Marcadores existeMarcador(String t){
       return u.existeMarcador(t);
    }
    
    /**
     * Metodo que llama al metodo existeUsuario de utilty
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
     * @return Usuario
     */
    public void agregarComentario(){
        System.out.print(t);
         comentario.setFecha(new Date());
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
        if(comentario.getUsuario().getNombre_usuario().equals(yo)){
            u.actualizarComentario(comentario);
        }else{
          System.out.print("No eres el creador del comentario");
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
        }else{
            System.out.print("No eres el creador del comentario");
        }
    }
    
}
