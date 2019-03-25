package com.miguel.proyecto.web;
import java.util.LinkedList;
public class Informador {
	
	private String nombre;
  private String paterno;
  private String materno;
  private int id;
	private int edad;
  private char sexo;
  private String direccion;
  private String nacimiento;
	
  /**
   * Constructor para un Informador que sólo recibe el nombre y apellidos
   * @param nombre el Nombre del informador
   * @param paterno el Apellido Paterno del informador
   * @param materno el Apellido Materno del informador
   */
	public Informador(String nombre, String paterno, String materno) {
		  this.nombre = nombre;
		  this.paterno = paterno;
      this.materno = materno;
      this.id = obtenerID();  // <- llamar función para recuperar id actual según la base de datos.
      this.edad = 0;
      this.sexo = null;
      this.dirección = null;
      this.nacimiento = null;
	}

  /**
   * Constructor completo para un Informador
   * @param nombre el Nombre del informador
   * @param paterno el Apellido Paterno del informador
   * @param materno el Apellido Materno del informador
   */
  public Informador (String nombre, String paterno, String materno, int id, int edad, char sexo, 
                     String direccion, String nacimiento) {
      this.nombre = nombre;
		  this.paterno = paterno;
      this.materno = materno;
      this.id = obtenerID();    // <- llamar función para recuperar id actual según la base de datos.
      this.sexo = sexo;
      this.dirección = direccion;
      this.nacimiento = nacimiento;
  }
  
  public String getNombre() {
      return nombre; 
  }
  
  public void setNombre(String nombre) {
      this.nombre = nombre
  }
  
  public String getMaterno() {
      return materno; 
  }
  
  public void setMaterno(String materno) {
      this.materno = materno;
  }  
  
  public String getPaterno() {
      return paterno; 
  }
  
  public void setPaterno(String paterno) {
      this.paterno = paterno;
  }
  
  public String getID() {
      return id; 
  }
  
  public void setNombre(String nombre) {
      this.nombre = nombre
  }  
  
}
