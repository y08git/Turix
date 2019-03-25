package com.miguel.proyecto.web;
import java.util.LinkedList;
public class Tema {
	
	private String idTema;
	private LinkedList <Marcador> listaMarcadores;
	
	public Tema(String idTema, LinkedList<Marcador> listaMarcadores){
		this.idTema=idTema;
		this.listaMarcadores=listaMarcadores;
	}

    public String getId() {
        return idTema;
    }

    public LinkedList getListaMarcadores() {
        return listaMarcadores;
    }

	public void setId(String idTema) {
        this.idTema = idTema;
    }

    public void setListaMarcadores(LinkedList<Marcador> listaMarcadores) {
        this.listaMarcadores = listaMarcadores;
}
	
	
}
