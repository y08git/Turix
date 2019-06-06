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

@Entity
@Table(catalog = "notitia", schema = "notitia", name = "calificar")
public class Calificar implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificar")
    private int id_calificar;
    
    @Column(name = "gustar")
    private boolean gustar;
    
    @ManyToOne
    @JoinColumn(name = "id_comentario")
    private Comentarios comentarios;
    
    @ManyToOne
    @JoinColumn(name  = "nombre_usuario")
    private Usuario usuario;

    public int getId_calificar() {
        return id_calificar;
    }

    public void setId_calificar(int id_calificar) {
        this.id_calificar = id_calificar;
    }
    
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
