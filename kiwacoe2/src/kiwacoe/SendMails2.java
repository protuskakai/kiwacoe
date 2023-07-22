/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

 
public class SendMails2 {
       public static String host = "mail.nzoiawater.or.ke";
        public static String port = "587";
        public static String mailFrom = "pkakai@nzoiawater.or.ke";
       public  static String password = "kakai@2016";
 
        // message info
      public static  String mailTo = "your-friend-email";
      public static  String subject = "New email with attachments";
      public  static String message = "I have some attachments for you.";
 
        // attachments
       public static String[] attachFiles = new String[0];
       // attachFiles[0] = "e:/Test/Picture.png";
        // usrnm,toaddr,subj,mssg,String[] attachFiles;
         public static void send(String userName,  String toAddress,
            String subject, String message, String[] attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
        
        
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", "pkakai@nzoiawater.or.ke");
        properties.put("mail.password", "kakai@");
 
        // creates a new session with an authenticator
          Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pkakai@nzoiawater.or.ke", "kakai@");
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
      //  attachFiles[0] = "e:/Test/Picture.png";
 
        // sends the e-mail
        Transport.send(msg);
     //   send();
 
    }
 
  public  void send()
  {
      /* 
      // attachFiles[1] = "e:/Test/Music.mp3";
      //  attachFiles[2] = "e:/Test/Video.mp4";
   //  attachFiles="";
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                subject, message, attachFiles);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
*/
  }
   
}
