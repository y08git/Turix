/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.modelo;

/**
 *
 * @author yair
 */

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
@Table(catalog = "notitia", schema = "notitia", name = "calificar")
public class Calificar implements Serializable{
   
    @Column(name = "gustar")
    private boolean gustar;
    
    @ManyToOne
    @JoinColumn(name = "comentarios")
    private Comentarios comentarios;
    
    @ManyToOne
    @JoinColumn(name  = "nombre_usuario")
    private Usuario usuario;

    public boolean isGustar() {
        return gustar;
    }

    public void setGustar(boolean gustar) {
        this.gustar = gustar;
    }

    public Comentarios getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentarios comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
