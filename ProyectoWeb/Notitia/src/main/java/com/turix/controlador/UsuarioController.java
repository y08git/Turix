/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Usuario;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.hibernate.*;

/**
 *
 * @author yair
 */
public class UsuarioController {
    
    public UsuarioController() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    public Usuario getUser(String user_name,String contraseña) {
        Session session = null;
        Usuario usuario = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            usuario =  (Usuario) session.get(Usuario.class, user_name);
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
