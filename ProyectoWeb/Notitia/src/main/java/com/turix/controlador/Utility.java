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
    static Session sessionObj;
    static Comentarios comObj;
    static Temas temaObj;


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
    public boolean login(Login login, Usuario usuario){
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT *  FROM notitia.Usuario  "
                  + "WHERE notitia.Usuario('"+login.getUsuario()+"','"+login.getContraseña()+"');";
        boolean success = false; 
        List l;
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
        return success;
        
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
    //Métodos para marcadorController
    public void guardarMarcador(Marcadores marcador){
        boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Temas "
                   + "WHERE notitia.Temas.nombre LIKE '"+ marcador.getUbicacion() +"';";
          try{
         sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(query).addEntity(Temas.class);
            l = q.list();
            if(l.isEmpty()){
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
                                    "Fallo: Ya existe el marcador", ""));
        } else {

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Felicidades, se agrego correctamente el marcador", ""));
          
        }
    }
    
    
     public void eliminarMarcador(Marcadores m){
          boolean guardar = false;
        List l = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT * FROM notitia.Temas "
                   + "WHERE notitia.Temas.nombre LIKE '"+ m.getUbicacion() +"';";
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
    //Métodos para comentariosCOntroller

    public List<Comentarios> listaComentarios (Marcadores m){

        String s = "SELECT * FROM notitia.Marcadores INNER JOIN "
                + "notitita.Comentarios CO ON "+m.getUbicacion()+" = CO.ubicacion";
        List l = null;
         try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            Query q = sessionObj.createSQLQuery(s).addEntity(Comentarios.class);
            l = q.list();

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
         return l;
    }

    public void guardarComentario(Comentarios c) {
        Random r = new Random();
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Session " + sessionObj);
            sessionObj.beginTransaction();

            sessionObj.save(comObj);

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

    public void borrarComentario(Comentarios c){
        sessionObj = HibernateUtil.getSessionFactory().openSession();

      try {
         sessionObj.beginTransaction();

         Comentarios comentario = (Comentarios)sessionObj.get(Comentarios.class,c.getId_comentario());
         sessionObj.delete(comentario);
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
    public void actualizarComentario(Comentarios comentario){
       try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();

            System.out.println("Session " + sessionObj);
            sessionObj.beginTransaction();
            if (comentario != null){
                 sessionObj.update(comentario);
                 System.out.println("\n.......Records Saved Successfully To The Database.......\n");
            }
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

}
