/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.modelo;

import java.util.Locale;
import javax.faces.context.FacesContext;
import org.hibernate.*;

/**
 *
 * @author yair
 */
public class ComentaristaController {
    
    public ComentaristaController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    public Comentarista getUser(String user_name,String contraseña) {
        Session session = null;
        Comentarista usuario = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            usuario =  (Comentarista) session.get(Comentarista.class, user_name);
        } catch (HibernateException e) {
            usuario = null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return usuario;
    }
    
}
