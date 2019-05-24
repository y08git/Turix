/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador; 
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author dianis
 */
public class ValidaCorreo {
  	boolean valido;
        boolean validacion(String email) {
		boolean valido = false;
		try {
			//
			// Create InternetAddress object and validated the supplied
			// address which is this case is an email address.
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			valido = true;
		} catch (AddressException e) {
			System.out.println("You are in catch block -- Exception Occurred for: " + email);
		}
		return valido;
	}
 
	private void mensaje(String email, boolean valid) {
		System.out.println(email  + (valid ? "es un " : "no es un") + " correo válido\n");
	}

    
}
