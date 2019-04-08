/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Usuario;
import com.turix.modelo.Temas;
import com.turix.modelo.Marcadores;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;



/**
 *
 * @author miguel
 */
public class Utility {

    static Usuario userObj;
    static Temas temaObj;
    static Session sessionObj;
    String nombreTema=null;
    
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

    public void login(Login login, Usuario usuario){
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT *  FROM notitia.Usuario "
                  + "WHERE notitia.Usuario('"+login.getUsuario()+"','"+login.getContraseña()+"');";
        boolean success = false; 
        try {
            Transaction tx = sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Usuario.class);
            usuario = (q.list().isEmpty())? null:(Usuario) q.list().get(0);
            success = usuario != null;
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
        if (!success) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                     "Fallo de inicio: La contraseña o el usuario no coinciden", ""));
        } else {
            login.setUsuario(usuario.getNombre_usuario());
            login.setContraseña(usuario.getContraseña());
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                     "Felicidades, el ingreso se ha realizado correctamente", ""));
        }
    }
    
    public void save(Usuario user) {
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
     
     
     public void guardarMarcador(Marcadores marcador){
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Marcadores "
                   + "WHERE notitia.Marcadores.ubicacion LIKE '"+ marcador.getUbicacion() +"';";
        String queryT = "SELECT * FROM notitia.Temas "
                  + "WHERE notitia.Temas.nombre LIKE '"+ marcador.getTemas().getNombre() +"';";
       
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
                                    "Fallo: Ya existe el marcador o el Tema asociado no existe o el usuario no existe", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el marcador", ""));
          
        }
          
          
         }
     
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
     
    
    
     public void eliminarMarcador(Marcadores m){
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
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
    
    
 

}
