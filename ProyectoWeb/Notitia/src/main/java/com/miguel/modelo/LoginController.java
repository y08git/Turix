/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.modelo;

import com.miguel.proyecto.web.Comentarista;
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
    private Comentarista usuario;
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

    public Comentarista getUsuario() {
        return usuario;
    }

    public void setUsuario(Comentarista usuario) {
        this.usuario = usuario;
    }
    
    public Comentarista getComentarista(){
        return (Comentarista) u.getComentarista().get(0);
    }
    
    
    public String openUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "SELECT 1 FROM notitia.Comentarista \n"
                + "WHERE notitia.Comentarista('"+login.getUsuario()+"','"+login.getContraseña()+"');";
        boolean success = false; 
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery(query);
            usuario =  (Comentarista) q.list().get(0);
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
