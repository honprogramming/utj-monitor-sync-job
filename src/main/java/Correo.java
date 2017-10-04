/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

/**
 *
 * @author Omar
 */
public class Correo {
    
    private Properties propiedades;
    
    private String usuario;
    private String password;
    private String para;
    private String asunto;
    private String host;
    private String puerto;
    private String[] destinatarios;
    private Logger log;
   
    public Correo(Properties propiedades, Logger log) throws IOException {
        
        this.propiedades = propiedades;
        this.usuario = propiedades.getProperty("correoOrigen");
        this.password = propiedades.getProperty("password");
        this.para = propiedades.getProperty("correoDestino");
        this.asunto = propiedades.getProperty("asunto");
        this.host = propiedades.getProperty("host");
        this.puerto = propiedades.getProperty("puerto");
        this.destinatarios = para.split(";");
        this.log = log;
    
    }
    
    public void sendMail(String mensaje) {
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);
 
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                    
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                    
                        return new PasswordAuthentication(usuario, password);
                    
                    }
                
                });
 
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            Address []destinos = new Address[destinatarios.length];//Aqui usamos el arreglo de destinatarios
            for( int i=0;i<destinos.length;i++ ) { 
                destinos[i]=new InternetAddress(destinatarios[i]); 
            } 
            message.setRecipients(Message.RecipientType.TO, destinos);
            message.setSubject(asunto);
            message.setText(mensaje);
 
            Transport.send(message);
            
            System.out.println("Su mensaje se ha enviado");
         
        } catch (MessagingException e) {
        
            System.out.println(e);
            log.error("Mensaje no enviado", e);
            
            throw new RuntimeException(e);
        
        }
        
    }
    
}
