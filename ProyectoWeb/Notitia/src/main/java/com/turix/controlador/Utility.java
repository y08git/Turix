/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Usuario;
import com.turix.modelo.Temas;
import java.util.List;
import java.util.Random;
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
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
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



    public void guardarTema(Temas tema){
         sessionObj = HibernateUtil.getSessionFactory().openSession();
          try{
         sessionObj.beginTransaction();
         sessionObj.save(tema);
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
          
         }
    public String existeTema(Temas tema){
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String id = null;
        List l = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            String query = "SELECT nombre FROM notitia.Temas "
                    + "WHERE notitia.Temas.nombre LIKE "+ "tema.getNombre()"+";";
            Query q = sessionObj.createSQLQuery(query).addEntity(Temas.class);
            l = q.list();
            if(l.size()!=0)
            id=l.get(0).toString();
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
        return id;
        
    }
    
     public void eliminarTema(Temas t){
     sessionObj = HibernateUtil.getSessionFactory().openSession();
     
      
      try {
         sessionObj.beginTransaction();
         
         
          
         Temas tema = (Temas)sessionObj.get(Temas.class,t.getNombre()); 
         sessionObj.delete(tema); 
         if (sessionObj.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
         sessionObj.getTransaction().commit();
      } catch (HibernateException e) {
         if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
         e.printStackTrace(); }
      } finally {
       if (sessionObj != null) {
                sessionObj.close();
            }
   }
     }
    
    
 

}
