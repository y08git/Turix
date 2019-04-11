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
    // Métodos para temaController
    public boolean save(Usuario user) {
        boolean guardar = false;
          sessionObj = HibernateUtil.getSessionFactory().openSession();
           String queryNombre = "SELECT * FROM notitia.Usuario "
                   + "WHERE notitia.Usuario.nombre_usuario LIKE '"+ user.getNombre_usuario()+"';";
            String queryCorreo = "SELECT * FROM notitia.Usuario "
                   + "WHERE notitia.Usuario.correo LIKE '"+ user.getCorreo() +"';";
           
        try {
          
            sessionObj.beginTransaction();
            Query q1 = sessionObj.createSQLQuery(queryNombre).addEntity(Usuario.class);
            Query q2 = sessionObj.createSQLQuery(queryCorreo).addEntity(Usuario.class);
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
                                    "Felicidades, el registro se ha realizado correctamente", ""));
        }
          return guardar;
    }

    public void guardarTema(Temas tema){
      boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
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

    public void eliminarTema(Temas t){
      boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
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
    //Métodos para marcadorController
    /**
      * Metodo para ver si existe un tema
      * @param string 
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
     /**
      * Metodo para ver si existe un marcador
      * @param string 
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
      * @param string 
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
    public void guardarMarcador(Marcadores marcador){
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.nombre LIKE '"+ marcador.getUbicacion() +"';";
        String queryT = "SELECT * FROM notitia.Temas "
                  + "WHERE notitia.Temas.nombre LIKE '"+ marcador.getTemas().getNombre() +"';";
          //marcador.setNombreTema(marcador);
         // existeTema(marcador.());
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
    
    public List darUsuarios() {
        List l;
        Usuario u = new Usuario();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Usuario ";
        sessionObj.beginTransaction();
        sessionObj.getTransaction().commit();
        Query q = sessionObj.createSQLQuery(query).addEntity(Usuario.class);
        l = q.list();
        return l;
    }
    
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
     
     public void eliminarMarcador(Marcadores m){
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.ubicacion LIKE '"+ m.getUbicacion() +"';";
          try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Temas.class);
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
      * @param string 
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
      * @param list 
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
      * @param string 
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
    /**
      * Metodo para guardar un comentario
      * @param string 
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
      * @param string 
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
      * @param string 
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
      * @param string 
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
    
    
    public void eliminarInformador(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
