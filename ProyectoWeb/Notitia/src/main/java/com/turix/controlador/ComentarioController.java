/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author dmonroy
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

   

    public List listaComentarios() throws SQLException{
        return u.darComentarios(ubicacion);
    }
    
    public List listaUsuarios() throws SQLException{
        return u.getMiUsuario();
    }
    
    public Marcadores existeMarcador(String t){
       return u.existeMarcador(t);
    }
    
    public Usuario existeUsuario(String t){
        return u.existeUsuario(t);
    }
    public void agregarComentario(){
//        long range = 1234567L;
//        Random r = new Random();
//        long number = (long)(r.nextDouble()*range);
//       // (Usuario)context.getExternalContext().getSessionMap().get("usuario");
//       comentario.setId_comentario(number);
        comentario.setFecha(new Date());
       comentario.setMarcadores(existeMarcador(t));
        //marcador.setTemas(existeTema(t));
        comentario.setUsuario(existeUsuario(usuario));
        //marcador.setInformador(existeUsuario(usuario));
        //solucion temporal de lo de login analogo a existeTema
            u.guardarComentario(comentario);
            comentario = null;
         }
    
    public Temas existeTema(String t){
       return u.existeTema(t);
    }

//        String x = comentario.getUsuario().getNombre_usuario();
//        if(true==u.verificaUsuario(x)){
//            FacesContext.getCurrentInstance()
//                    .addMessage(null,
//                            new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                    "Felicidades, se agrego correctamente el tema", ""));
//             u.guardarComentario();
//        } else {
//            FacesContext.getCurrentInstance()
//                    .addMessage(null,
//                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                    "Fallo de registro: Las contraseñas deben coincidir", ""));
//        }
//            comentario = null;
   

    public void editarComentario(){
        String coment = comentario.getComentario();
        comentario = u.obtenerC(id_comentario);
        comentario.setComentario(coment);
        u.actualizarComentario(comentario);
    }

    public void eliminarComentario(){
        u.borrarComentario(id_comentario);
    }
}
