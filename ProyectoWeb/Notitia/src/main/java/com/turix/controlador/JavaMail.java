/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turix.controlador;

/**
 *
 * @author dianis
 */
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMail {
    private static final String envioEmail = "dianisrmz97@gmail.com";//change with your sender email
  private static final String envioPass = "Isoftware2019";//change with your sender password

  public static void enviar(String to, String title, String html) throws MessagingException {
      System.out.println("Sending email to " + to);

      Session session = crearSesion();

      //create message using session
      MimeMessage message = new MimeMessage(session);
      prepareEmailMessage(message, to, title, html);

      //sending message
      Transport.send(message);
      System.out.println("Done");
  }

  private static void prepareEmailMessage(MimeMessage message, String to, String title, String html)
          throws MessagingException {
      message.setContent(html, "text/html; charset=utf-8");
      message.setFrom(new InternetAddress(envioEmail));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      message.setSubject(title);
  }

  private static Session crearSesion() {
      Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(envioEmail, envioPass);
          }
      });
      return session;
  }
  
  
 /** public static void main(String[] args) throws MessagingException {
      JavaMail.enviar("dianis0297@gmail.com",
              "Test email",
              "<h2>Java Mail Example</h2><p>hi there!</p>");
  }*/
    
}
