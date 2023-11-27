package org.example.service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {



        private static String correo = "correo@gmail.com";
        private static String clave = "contrasena";
        private static String puerto = "443";
        private static String servidorCorreo = "smtp.gmail.com";

        public static void enviarCorreo(String destinatario, String asunto, String contenido) {
            Properties propiedades = new Properties();
            propiedades.put("mail.smtp.host", servidorCorreo);
            propiedades.put("mail.smtp.port", puerto);
            propiedades.put("mail.smtp.auth", "true");

            Session sesion = Session.getInstance(propiedades, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo, clave);
                }
            });

            try {

                Message mensaje = new MimeMessage(sesion);
                mensaje.setFrom(new InternetAddress(correo));
                mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                mensaje.setSubject(asunto);
                mensaje.setText(contenido);
                Transport.send(mensaje);
                System.out.println("Correo enviado con éxito.");

            } catch (MessagingException e) {
                System.out.println("Error al enviar el correo: " + e.getMessage());
            }
        }





}