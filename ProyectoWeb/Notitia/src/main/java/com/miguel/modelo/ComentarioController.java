package com.miguel.proyecto.web;

import java.util.LinkedList;

/**
 *
 * @author dmonroy
 */
public class ComentarioController {
    private Comentario comentario = new Comentario();
    LinkedList lista = new LinkedList();

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    public LinkedList agregarComentario(){
        lista.add(comentario);
        return lista;
    }
    
    public LinkedList eliminarComentario(){
        lista.remove(comentario);
        return lista;
    }
    
    public Comentario editarComentario(String nuevo){
        comentario.setContenido(nuevo);
        return comentario;
    }
    
    public Comentario agregarCalificacionPositiva(int pos){
        int contadorPositivo = comentario.getCalificacionPositiva();
        comentario.setCalificacionPositiva(contadorPositivo+pos);
        return comentario;
    }
     public Comentario agregarCalificacionNegativa(int neg){
        int contadorNegativo = comentario.getCalificacionNegativa();
        comentario.setCalificacionNegativa(contadorNegativo+neg);
        return comentario;
    }
    
}
