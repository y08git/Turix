/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Usuario;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author yair
 */
@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController {
    private Login login = new Login();
    private Usuario usuario;
    private Utility u = new Utility();

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
    public LoginController()  {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsusario(){
        return (Usuario) u.getUsuario().get(0);
    }
    
    
    public String openUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT *  FROM notitia.Usuario "
                  + "WHERE notitia.Usuario('"+login.getUsuario()+"','"+login.getContraseña()+"');";
        System.out.println(query);
        boolean success = false; 
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createSQLQuery(query).addEntity(Usuario.class);
            usuario = (q.list().isEmpty())? null:(Usuario) q.list().get(0);
            success = usuario != null;
            tx.commit();
        } catch (HibernateException e) {
            if (null != session.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                session.getTransaction().rollback();
            }
        } finally {
            
            
            if (session != null && session.isOpen()) {
                session.close();
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
        return null;
    }
    
    
    /**
     * POR IMPLEMENTAR
     * 
     *funcion para hacer login en el propio objeto
     */
}
