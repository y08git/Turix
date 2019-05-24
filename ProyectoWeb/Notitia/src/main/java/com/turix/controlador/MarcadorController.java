/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Marcadores;
import com.turix.modelo.Temas;
import com.turix.modelo.Usuario;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;

/**
 *
 * @author dianis
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class MarcadorController {

    
   private MapModel model =new DefaultMapModel();
    private Utility u = new Utility();
    private Marcadores marcador = new Marcadores();
    private Temas tema = new Temas();
    public String t ;
    public String usuario;
    private String title;
    private String data;
    public MapModel getModel() {
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Temas getTema() {
        return tema;
    }

    public void setTema(Temas tema) {
        this.tema=tema;
    }

    public MarcadorController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }

    public Marcadores getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcadores marcador) {
        this.marcador = marcador;
    }

    /**
     * Se modificó el xhtml , ahora llama a un atributo del controller, un string
     * posteriormente usamos este string para buscar el tema deseado con existeTema
     * y luego con el valor que nos regresa hacemos marcador.setTemas
     */

    /**
     * Metodo que guarda un marcador
     * manda a llamar a guardarMarcador de Utility
     * para guardar en la BD
     */
    public void guardarMarcador(){
        //FacesContext context = getCurrentInstance();
        //Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        //marcador.setInformador(user);
        marcador.setTemas(existeTema(t));
        marcador.setInformador(existeUsuario(usuario));
        //solucion temporal de lo de login analogo a existeTema
            u.guardarMarcador(marcador);
            marcador = null;
         }

    /**
     * Metodo para checar si existe el Tema
     * manda a llamar a existeTema del Utility
     * para buscar en la BD
     * @param t nombre del Tema a buscar
     * @return Temas
     */
    public Temas existeTema(String t){
       return u.existeTema(t);
    }

    /**
     * Metodo para checar si existe el Usuario
     * manda a llamar a existeUsuario de Utility
     * para buscar en la BD
     * @param t nombre del Usuario a buscar
     * @return Usuario
     */
    public Usuario existeUsuario(String t){
        return u.existeUsuario(usuario);
    }

    /**
     * Metodo que nos regres una lista de todos los Marcadores
     * Manda a llamar a darMarcadores de Utility
     * para buscar los marcadores en la BD
     * @return List
     */
    public List listMarcadores(){
        return u.darMarcadores();
    }

     /**
      * Metodo que elimina al marcador
      * manda a llamar a eliminarMarcador de Utility
      * para eliminarlo de la BD
      */
     public void eliminaMarcador(){
             u.eliminarMarcador(marcador);

     }
     public List misMarcadores() throws SQLException{
        return u.dameMarcadoresT(t);
     }

}
