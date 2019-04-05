/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Login;
import com.turix.modelo.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author miguel
 */
public class Utility {

    static Usuario userObj;
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

}
