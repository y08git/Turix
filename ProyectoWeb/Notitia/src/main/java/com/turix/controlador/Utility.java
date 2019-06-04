/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Login;
import com.turix.modelo.Comentarios;
import com.turix.modelo.Marcadores;
import com.turix.modelo.Temas;
import com.turix.modelo.Temporal;
import com.turix.modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import static sun.security.jgss.GSSUtil.login;



/**
 *
 * @author miguel
 */
public class Utility {

    static Usuario userObj;
    static Session sessionObj;
    static Comentarios comObj;
    static Temas temaObj;
    static Temporal temObj;
    static Marcadores marcaObj;
    static Comentarios c = new Comentarios();


    public List getUsuario(){
        List l = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Session " + sessionObj);
            Query q = sessionObj.createSQLQuery("SELECT * "
                    + "FROM notitia.Comentarista"
                    + "notitia.Comentarista('"+userObj.getNombre_usuario()+"','"+userObj.getCorreo()+"')");
            l = q.list();
            System.out.println("\n.......Records loades Successfully from the Database.......\n");

        } catch (HibernateException sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n"
                        + "Values of usu");
                sessionObj.getTransaction().rollback();
            }
            l = null;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }

        }
        return l;

    }

    /**Metodo que busca en la base de datos un usuario en especifico
     * 
     * @param login -- Un objeto de tipo login 
     * @return Un usuario si ambos atributos en login son correctos, null si no
     */
    public Usuario login(Login login){
        Usuario usuario = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT *  FROM notitia.Usuario('"+login.getUsuario()+
                "','"+login.getContraseña()+"');";
        List l;
        try {
            Transaction tx = sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Usuario.class);
            usuario = (q.list().isEmpty())? null:(Usuario) q.list().get(0);
            tx.commit();
        } catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
            
            
            if (sessionObj != null && sessionObj.isOpen()) {
                sessionObj.close();
            }
        }
        return usuario;        
    }

    /**Un metodo para actualizar un usuario cuya contraseña ha sido cambiada
     * 
     * @param user -- Usuario a buscar
     * @param usuario -- El mismo usuario con los cambios hechos (no por nombre)
     * @return True si se hizo el update
     */
    public boolean update(Usuario user, Usuario usuario){
        boolean success = false;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sessionObj.beginTransaction();
            sessionObj.delete(user);
            sessionObj.save(usuario);
            tx.commit();
            success = true;
        } catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
            
            
            if (sessionObj != null && sessionObj.isOpen()) {
                sessionObj.close();
            }
        }
        return success;
    }
    
    /**Un metodo para actualizar un usuario cuya contraseña no ha sido cambiada
     * 
     * @param usuario -- Usuario modificado (no por nombre)
     */
    public void update1(Usuario usuario){
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();

            sessionObj.update(usuario);
            
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch (HibernateException sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

//        List l = null;
    /**Metodo para borrar un usuario de la base de datos
     * 
     * @param user -- Usuario a borrar
     */
    public void delete(Usuario user){
         boolean guardar = false;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
          try{
             sessionObj.beginTransaction();
               guardar = user!=null;
                sessionObj.delete(user); 
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
          
        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: El usuario ya a sido eliminar", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó correctamente el usuario", ""));
          
        }
    
    }
    

    
    public void save() {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Session " + sessionObj);
            sessionObj.beginTransaction();

            sessionObj.save(userObj);
            
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch (HibernateException sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    /**
     * Metodo para guardar a un Usuario en la base de datos al momento de registrar
     * @param user
     * @return true si fue exitosa la transaccion
     */
    public void save(Usuario user) {
        
          sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
          
            sessionObj.beginTransaction();
            sessionObj.save(user);
            sessionObj.getTransaction().commit();
            
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        
        } 
    }
    
    
    /**
     * Metodo para pre-registro de un Usuario en la base de datos 
     * @param user
     * @return true si fue exitosa la transaccion
     */
    public boolean saveTemp(Temporal user) {
        //querys para hacer verificaciones
        boolean guardar = false;
          sessionObj = HibernateUtil.getSessionFactory().openSession();
           String queryNombre = "SELECT * FROM notitia.Usuario "
                   + "WHERE notitia.Usuario.nombre_usuario LIKE '"+ user.getNombre_usuario()+"';";
            String queryCorreo = "SELECT * FROM notitia.Usuario "
                   + "WHERE notitia.Usuario.correo LIKE '"+ user.getCorreo() +"';";
           //iniciamos transaccion
        try {
          
            sessionObj.beginTransaction();
            Query q1 = sessionObj.createSQLQuery(queryNombre).addEntity(Temporal.class);
            Query q2 = sessionObj.createSQLQuery(queryCorreo).addEntity(Temporal.class);
            if(q1.list().isEmpty()&& q2.list().isEmpty()){
                guardar = true;
                sessionObj.save(user);
                sessionObj.getTransaction().commit();
            }
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        //Mensajes de exito o error 
          if (!user.getContraseña().equals(user.getConfirmaContrasena())) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo de registro: Las contraseñas deben coincidir", ""));
        } else if (!guardar){
             FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo de registro: elija un correo o usuario distinto", ""));
         
            
        }else {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Revise su correo e ingrese el código en Confirmar", ""));
        }
          return guardar;
    }
    
    
    
    /**
     * Metodo para guarda el tema en la base de datos
     * @param tema 
     */
    public void guardarTema(Temas tema){
      boolean guardar = false;
        List l = null;
       sessionObj = HibernateUtil.getSessionFactory().openSession();
       //query para verificacion

        String query = "SELECT * FROM notitia.Temas "
                   + "WHERE notitia.Temas.nombre LIKE '"+ tema.getNombre() +"';";
          try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Temas.class);
            l = q.list();
            if(l.isEmpty()){
                guardar = true;
               sessionObj.save(tema); 
                sessionObj.getTransaction().commit();
            }
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
          
          //mensajes de error o exito

        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: Ya existe el tema", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el tema", ""));
          
        }
    }

//    public void irTema(String temas){
//        boolean guardar = false;
//        List l = null;
//        sessionObj = HibernateUtil.getSessionFactory().openSession();
//        String query = "SELECT * FROM notitia.Temas "
//                   + "WHERE notitia.Temas.nombre LIKE '"+ temas +"';";
//            Query q = sessionObj.createSQLQuery(query).addEntity(Comentarios.class);
//            l = q.list();
//              System.out.println(q.list());      
//    }
    
    /**
     * Metodo para eliminar un tema de la BD
     * @param t 
     */
    public void eliminarTema(Temas t){
      boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();

        //query para restricciones
        String query = "SELECT * FROM notitia.Temas "
                   + "WHERE notitia.Temas.nombre LIKE '"+ t.getNombre() +"';";
          try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Temas.class);
            l = q.list();
            if(!l.isEmpty()){
                guardar = true;
               Temas tema = (Temas)sessionObj.get(Temas.class,t.getNombre()); 
                sessionObj.delete(tema); 
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
            }
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }

          //mensajes de error o exito
        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: No existe el Tema a eliminar", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó correctamente el tema", ""));
          
        }
      }
    /**
     * Metodo auxiliar para saber si existe el Tema en la BD
     * @param t
     * @return Temas
     */
    public Temas existeTema(String t){
        List l = null;
        Temas tema = new Temas();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Temas "
                   + "WHERE notitia.Temas.nombre LIKE '"+t+"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Temas.class);
        l = q.list();
        if(!l.isEmpty()){
            tema =(Temas)l.get(0);  
        }
        return tema;
     }
    
    

      public String getCorreo(Temporal t){
        List l = null;
        Temporal u = new Temporal();
        String correo = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Temporal "
                   + "WHERE notitia.Temporal.nombre_usuario LIKE '"+t.getNombre_usuario()+"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Temporal.class);
        l = q.list();
        if(!l.isEmpty()){
             u=(Temporal)l.get(0);
             correo=u.getCorreo();
        }
        return correo;
     }
     
    /**
     * Metodo auxiliar para saber si existe el marcador en la BD
     * @param m
     * @return null si no existe
     */
    public Marcadores existeMarcador(String m){
         List l = null;
        Marcadores mar = new Marcadores();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.marcadores "
                   + "WHERE notitia.marcadores.ubicacion LIKE '"+m+"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Marcadores.class);
        l = q.list();
        if(!l.isEmpty()){
            mar =(Marcadores)l.get(0);
        } 
        return mar;
         
     }
     
     /**
      * Metodo para ver si existe un usuario
      * @param u -- un string 
      * @return null si no existe
      */
     public Usuario existeUsuario(String u){
        List l = null;
        Usuario usuario = new Usuario();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Usuario "
                   + "WHERE notitia.Usuario.nombre_usuario LIKE '"+u+"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Usuario.class);
        l = q.list();
        if(!l.isEmpty()){
            usuario =(Usuario)l.get(0);
        } 
        return usuario;
         
     }
     
     /**
      * Metodo para guardar un marcador en la BD
      * @param marcador 
      */
    public void guardarMarcador(Marcadores marcador){
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        //Querys para restricciones
        String query = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.nombre LIKE '"+ marcador.getUbicacion() +"';";
        String queryT = "SELECT * FROM notitia.Temas "
                  + "WHERE notitia.Temas.nombre LIKE '"+ marcador.getTemas().getNombre() +"';";
         //inicio transaccion
          try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Marcadores.class);
            Query qT = sessionObj.createSQLQuery(queryT).addEntity(Temas.class);
            l = q.list();
            
            if(l.isEmpty()&& !qT.list().isEmpty()&& !marcador.getInformador().equals(null)){
                guardar = true;
               sessionObj.save(marcador); 
                sessionObj.getTransaction().commit();
            }
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
          
          //mensaje de error o exito
        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: Ya existe el marcador o el Tema asociado no existe", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el marcador", ""));
          
        }
          
          
         }
    
    /**
     * Devuelve la lista de usuarios registrados en la base
     * @return la lista de usuarios registrados en la base
     */
    public List darUsuarios() {
        List l;
        Usuario u = new Usuario();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Usuario WHERE en_espera AND NOT es_informador";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Usuario.class);
        l = q.list();
        return l;
    }

    /**
     * Devuelve la lista de usuarios registrados en la base
     * @return la lista de usuarios registrados en la base
     */
    public List darUsuariosRegistrados() {
        List l;
        Usuario u = new Usuario();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Usuario";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Usuario.class);
        l = q.list();
        return l;
    }
    
    /**
     * Metodo para enlistar todos los temas
     * @return list
     */
     public List darTemas(){
         List l = null;
        Temas tema = new Temas();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Temas ";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Temas.class);
        l = q.list();
        return l;
     }   
     
     /**
     * Metodo para enlistar todos los temas
     * @return list
     */
     public List darNomTemas(){
         List l = null;
        Temas tema = new Temas();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT nombre FROM notitia.Temas ";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query);
        l = q.list();
        
        return l;
     }   
     
     /**
      * Metodo para enlistar todos los marcadores
      * @return list
      */
     public List darMarcadores(){
         List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Marcadores ";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Marcadores.class);
        l = q.list();
        return l;
     }  
     
     /**
      * Metodo para eliminar un marcador de BD
      * @param m 
      */
     public void eliminarMarcador(Marcadores m){
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        //query para restricciones
        String query = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.ubicacion LIKE '"+ m.getUbicacion() +"';";
          try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Marcadores.class);
            l = q.list();
            if(!l.isEmpty()){
                guardar = true;
               Marcadores marcador = (Marcadores)sessionObj.get(Marcadores.class,m.getUbicacion()); 
                sessionObj.delete(marcador); 
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
            }
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
          
          //mensajes de error o exito
        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: No existe el marcador a eliminar", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó correctamente el marcador", ""));
          
        }
     }
     
     /**
      * Metodo para dar un marcador por su ubicacion
      * @param m -- un string
      * @return Una lista de marcadores
      */
     public List dameMarcadoresT(String m){
         List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.ubicacion LIKE '"+  m +"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Marcadores.class);
        l = q.list();
        return l;
     } 
    //Métodos para comentariosCOntroller
     /**
      * Metodo para dar un comentario por su ubicacion
      * @param m -- Un string
      * @return Lista de comentarios
      */
     public List darComentarios(String m){
         List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Comentarios "
                   + "WHERE notitia.Comentarios.ubicacion LIKE '"+  m+"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Comentarios.class);
        l = q.list();
        return l;
     } 
     /**
      * Metodo para ver si existe un usuario
      * @param usuario -- un string 
      * @return  true si existe
      */
     public boolean verificaUsuario(String usuario){
         boolean es = false;
         Usuario a = null;
         sessionObj = HibernateUtil.getSessionFactory().openSession();
        try{
            String hq1 = "FROM notitia.usuario WHERE NOMBRE = '" + usuario ;
            Query query = sessionObj.createQuery(hq1);

            if (!query.list().isEmpty()){
                a = (Usuario) query.list().get(0);
                return es =true;
            }
        }catch (Exception e){
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }  
         return es;
     }

    public List getMarca() throws SQLException{
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT ubicacion FROM notitia.Marcadores";
        System.out.println(query);
        try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query);
            l = q.list();
            System.out.println(l);
            if(!l.isEmpty()){
                guardar = true;
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
                return l;
            }
        }
            catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
        return l;
    }
    
    public List getMiUsuario() throws SQLException{
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT nombre_usuario FROM notitia.Usuario";
        System.out.println(query);
        try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query);
            l = q.list();
            System.out.println(l);
            if(!l.isEmpty()){
                guardar = true;
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
            }
        }
            catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
        return l;
    }
    /**
      * Metodo para guardar un comentario
      * @param comentario -- Comentario a guardar
      */
    public void guardarComentario(Comentarios comentario) {
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Comentarios "
                   + "WHERE notitia.Comentarios.ubicacion LIKE '"+ comentario.darUbicacion() +"';";
        String queryT = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.ubicacion LIKE '"+ comentario.darUbicacion() +"';";
          try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Comentarios.class);
            Query qT = sessionObj.createSQLQuery(queryT).addEntity(Marcadores.class);
            l = q.list();
              System.out.println(qT.list());
            if(!qT.list().isEmpty()){
                guardar = true;
               sessionObj.save(comentario); 
                sessionObj.getTransaction().commit();
            }
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
          
        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: No existe el marcador", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el comentario", ""));
          
        }
    }
    /**
      * Metodo para borrar un comentario
      * @param id_comentario -- ID del Comentario que no se guardara
      */
    public void borrarComentario(int id_comentario){
        boolean guardar = false;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
          try{
         sessionObj.beginTransaction();
                
               Comentarios come = (Comentarios)sessionObj.get(Comentarios.class,id_comentario); 
               guardar = come!=null;
                sessionObj.delete(come); 
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
          
        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: No existe el marcador a eliminar", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó correctamente el comentario", ""));
          
        }
    }
    
    /**
      * Metodo auxiliar para actualizar
      * @param id_comentario-- Id del comentario que queremos obtener
      * @return  El comentario
      */
     public Comentarios obtenerC (int id_comentario){
        boolean guardar = false;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        Comentarios come = null;
          try{
         sessionObj.beginTransaction();
                
               come = (Comentarios)sessionObj.get(Comentarios.class,id_comentario); 
               guardar = come!=null;
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }
              return come;
              
              
    }
     }
    
    /**
      * Metodo para actualizar un comentario
      * @param comentario -- Comentario a actualizar
      */
    public void actualizarComentario(Comentarios comentario){
        boolean guardar = false;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
          try{
         sessionObj.beginTransaction();
                
               guardar = comentario!=null;
                sessionObj.update(comentario); 
                if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
                sessionObj.getTransaction().commit();
          }catch (HibernateException e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
        } finally {
              if (sessionObj != null) {
              sessionObj.close(); 
          }    
          }
          
        if (!guardar) {
           FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: No existe el marcador a eliminar", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Se eliminó correctamente el comentario", ""));
          
        }
    }
    
    /**
     * Elimina a un informador de la base de datos
     * @param user -- el usuario que desea eliminarse de la base
     */
    public void eliminarInformador(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  public Usuario confirmar(String cod){
        List l = null;
        Usuario u = new Usuario();
        Temporal t= new Temporal();
        String codigo = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Temporal "
                   + "WHERE notitia.Temporal.codigo LIKE '"+cod+"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Temporal.class);
        l = q.list();
        if(l.isEmpty()){
         FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Fallo: el código no coincide" , ""));
       
        }else{
             t=(Temporal)l.get(0);
             u.setContraseña(t.getContraseña());
             u.setNombre_usuario(t.getNombre_usuario());
             u.setCorreo(t.getCorreo());
             u.setConfirmaContrasena(t.getConfirmaContrasena());
             u.setEs_informador(t.isEs_informador());
        
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se finalizó tu registro con éxito", ""));
          
        }
        return u;
    }
  
  
         /**
      * Metodo para filtrar los marcadores
      * @param t -- un string
      * @return Una lista de marcadores
      */
     public List filtrar(String t){
         List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.nombre LIKE '"+  t +"';";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Marcadores.class);
        l = q.list();
        return l;
     } 
     
     
     
     }


