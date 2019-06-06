/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Comentarios;
import com.sun.faces.context.SessionMap;
import com.turix.modelo.Marcadores;
import com.turix.modelo.Temas;
import com.turix.modelo.Usuario;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
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
@ViewScoped
public class MarcadorController {
    
    
   private  MapModel model;
   private final MapModel modelFiltro = new DefaultMapModel();
    private Utility u = new Utility();
    private Marcadores marcador = new Marcadores();
    private Temas tema = new Temas();
    private Comentarios comentario = new Comentarios();
    public String t ;
    public String usuario;
    private String color;
    private String datos_utiles;
    private String data;
    private String descripcion;
    private String datos;
    private double lng;
    private double lat;
    private String title;
    private Marker marker;
    private String ubicacion;
    private String filtro;
     private List <Marcadores> marcadores;
 private SessionMap map ;
 private boolean validar;
 
 public boolean isValidar() {
        return validar;
    }

    public void setValidar(boolean validar) {
        this.validar = validar;
    }
 
    public List<Marcadores> getLista() {
        return marcadores;
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
    public void setLista(List<Marcadores> lista) {
        this.marcadores = lista;
    }
   
    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
        
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @PostConstruct
    public void init() {
        List<Marcadores> marcadores= null;
        model = new DefaultMapModel();
        marcadores = iniciar();
        System.out.println("---------------ELEMENTOS: "+marcadores.size());
        marcadores.forEach((marcador) -> {
           String[] coordenadas= marcador.getUbicacion().split(",");
           double c1=Double.parseDouble(coordenadas[0]);
           double c2=Double.parseDouble(coordenadas[1]); 
           Marker m = new Marker(new LatLng(c1, c2),marcador.getDatos_utiles(), marcador.getDescripcion());
           m.setIcon("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|" + marcador.getTemas().getColor());
            model.addOverlay(m);
        });
       
        
        
    }
    /**
     * Metodo que regresa una lista para inicializar el mapa
     * @return 
     */
    public List<Marcadores> iniciar(){
     marcadores= null;
       if(filtro==null){
           marcadores= u.darMarcadores();
       }else
           marcadores=u.filtrar(filtro);
        return marcadores;
    
       }
    
    public void valida(){
         if(!marcador.getDatos_utiles().equals(null)||! marcador.getDescripcion().equals(null))
             validar=true;
    }
        
      public String getDatos_utiles() {
        return datos_utiles;
    }

    public void setDatos_utiles(String datos_utiles) {
        this.datos_utiles = datos_utiles;
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

    public MapModel getModelFiltro() {
        return modelFiltro;
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

         Marker marker = new Marker(new LatLng(lat, lng),datos_utiles);
//           model.addOverlay(marker);
        FacesContext context = getCurrentInstance();
        Usuario user = (Usuario)context.getExternalContext().getSessionMap().get("usuario");
        marcador.setInformador(user);
        marcador.setTemas(u.existeTema(t));
        String ub1= String.valueOf(lat);
        String ub2= String.valueOf(lng);
        marcador.setUbicacion(ub1+","+ub2);
         u.guardarMarcador(marcador);
         model.addOverlay(new Marker(new LatLng(lat, lng),marcador.getDatos_utiles()));

           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
          
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
     public String eliminaMarcador(){
         marcador.setUbicacion(ubicacion);
         u.eliminarMarcador(marcador);
             return "map";

     }
     public List misMarcadores() throws SQLException{
        return u.dameMarcadoresT(t);
     }

      public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        String ub = marker.getLatlng().toString();
         //Separamos el LatLng de marker
        String[] split = ub.split(":");
        String ub2= split[2]; //lng
       String[] split2=split[1].split(",");
        String ub1= split2[0]; //lat
       ubicacion= ub1+","+ub2;
        data = (String) marker.getData();
        title = (String) marker.getTitle();
  
    }


      /**
       * Metodo que guarda el filtro para marcadores
       */
       public void savefiltro(){
             String f = (String) map.get("filtro");
           setFiltro(f);
        }
      
       
       /**
        * Metodo que inicializa el mapa con los marcadores filtrados
        */
      public void filtrar(){
         
      
          List<Marcadores> marcadores = u.filtrar(filtro);
          FacesContext context = getCurrentInstance();
          map = (SessionMap) context.getExternalContext().getSessionMap();
          map.put("filtro", filtro);
          savefiltro();
          init();   
      }
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    public boolean verificar(){
        boolean lleno=false;
        if(!marcador.getDatos_utiles().equals(null)||! marcador.getDescripcion().equals(null)|| !marcador.getTemas().equals(null))
            lleno=true;
       return lleno;
    }


}

