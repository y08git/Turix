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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author dianis
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class MarcadorController {


   private MapModel model ;
    private Utility u = new Utility();
    private Marcadores marcador = new Marcadores();
    private Temas tema = new Temas();
    public String t ;
    public String usuario;
    private String title;
    private String data;
    private String descripcion;
    private String datos;
    private double lng;
    private double lat;

    @PostConstruct
    public void init() {
        model = new DefaultMapModel();
        List<Marcadores> marcadores = u.darMarcadores();
        marcadores.forEach((marcador) -> {
           String[] coordenadas= marcador.getUbicacion().split("");
           double c1=Double.parseDouble(coordenadas[0]);
           double c2=Double.parseDouble(coordenadas[1]);
            model.addOverlay(new Marker(new LatLng(c1, c2),
                    marcador.getDescripcion()));
        });
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }


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
         Marker marker = new Marker(new LatLng(lat, lng),title);
           model.addOverlay(marker);

        //FacesContext context = getCurrentInstance();
        //Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        //marcador.setInformador(user);

        //Codigo original nuestro para la BD
       /** marcador.setTemas(existeTema(t));
        marcador.setInformador(existeUsuario(usuario));
        //solucion temporal de lo de login analogo a existeTema
            u.guardarMarcador(marcador);
           String[] coordenadas= marcador.getUbicacion().split("");
           double latitud=Double.parseDouble(coordenadas[0]);
           double longitud=Double.parseDouble(coordenadas[1]);*/

       //Codigo Miguel
        //marcador.setDescripcion(descripcion);
        //marcador.setDatos_utiles(datos);
        //marcador.setUbicacion(latitud);
        //marcador.setTemaId(tema);
           //model.addOverlay(new Marker(new LatLng(lat, lng),marcador.getDescripcion()));
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
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

      public void onMarkerSelect(OverlaySelectEvent event) {
        Marker marker = (Marker) event.getOverlay();
        data = (String) marker.getData();
        title = (String) marker.getTitle();
    }


}
