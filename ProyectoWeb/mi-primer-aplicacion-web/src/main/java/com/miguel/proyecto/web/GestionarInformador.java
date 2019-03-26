public class GestionarInformador {
       
    Informador informador;
  
    public GestionadorInformador(Informador informador) {
        this.informador = informador;
    }
  
    public void eliminarInformador() {
        this.informador = null;       
    }
    
    public void editarNombre(String nombre) {
        this.informador.setNombre(nombre); 
    }
  
    public void editarPaterno(String paterno) {
  
}
