import java.util.LinkedList;

public class GestionarTema {
	
	Tema tema ;
	LinkedList<Tema> listaTema = new LinkedList<Tema>();
	
	public GestionarTema(Tema tema){
		this.tema=tema;
	}
	
	public GestionarTema(){
	}
	

    public Tema crearTema (String idTema, LinkedList<Marcador> listaMarcadores) {
        tema = new Tema(idTema, listaMarcadores);
        return tema;
    }

    
    public LinkedList agregarTema(){
        listaTema.add(tema);
        return listaTema;
    }
    
    public LinkedList eliminarTema(){
        listaTema.remove(tema);
        return listaTema;
	}
	
	public LinkedList buscarTema(){
		return this.listaTema;
		
	}
	
	public agregarMarcadorLista(Marcador marcador){
		tema.getListaMarcadores().add(marcador);
		return tema.getListaMarcadores();
	}
	
	public eliminarMarcadorLista(Marcador marcador){
		tema.getListaMarcadores().remove(marcador);
		return tema.getListaMarcadores();
	}
	
	public boolean vaciarListaMarcadores(){
		boolean vacia = false;
		if(!tema.getListaMarcadores().empty())
		tema.getListaMarcadores().clear();
		
		if(tema.getListaMarcadores().size()==0)
		vacia=true;
		
		return vacia;
	}
	
	
}
