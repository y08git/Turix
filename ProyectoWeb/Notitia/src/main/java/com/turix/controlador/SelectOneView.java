package com.turix.controlador;


import com.turix.modelo.Calificar;
import com.turix.modelo.Comentarios;
import com.turix.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;

@ManagedBean
@ViewScoped
public class SelectOneView {
    int t;
    private final Utility u = new Utility();
    private Calificar cal;
    private int option = -1;   
 
    public int getOption() {
        return option;
    }
    
    public int getOption(Comentarios c) {
        if(isActualizada(c)){
            option = (cal.isGustar())? 1:0;
        }
        return option;
    }
    
    public void setOption(int option) {
        this.option = option;
    }
    
    public boolean isActualizada(Comentarios c){
        if(c == null)
            return false;
        FacesContext context = getCurrentInstance();
        Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null)
            return false;
        cal = u.calificacion(usuario, c);
        return cal != null;
        
    }
    
    public void actualizar(){
        if(cal == null)
            return;
        u.save(cal);
    }
    
    public boolean test(){
        FacesContext context = getCurrentInstance();
        Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        if(usuario == null)
            return true;
        if(cal == null)
            return option != -1;
        if(cal.isGustar())
            return option != 1;
        return option != 0;
    }
}