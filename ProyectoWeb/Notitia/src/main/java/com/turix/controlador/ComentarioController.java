/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

import com.turix.modelo.Comentarios;
import com.turix.modelo.Marcadores;
import java.util.List;

/**
 *
 * @author dmonroy
 */
public class ComentarioController {
    public Marcadores marcador; 
    private Utility u = new Utility();

    public Marcadores getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcadores marcador) {
        this.marcador = marcador;
    }
    
    public List<Comentarios> listaComentarios(){
        if (marcador == null){
            return null;
        }
        return (List<Comentarios>)u.listaComentarios(marcador);
    }
    
    public void agregarComentario(Marcadores m2){
        
    }
    
}
