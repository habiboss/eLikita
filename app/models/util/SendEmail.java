package models.util;

//File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

public  void main() {    
   // Recipient's email ID needs to be mentioned.
   String to = "habib2diakite2@gmail.com";

   // Sender's email ID needs to be mentioned
   String from = "habib2diakite2@gmail.com";

   // Assuming you are sending email from localhost
   String host = "localhost";

   // Get system properties
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("This is the Subject Line!");

      // Now set the actual message
      message.setContent("<h1>This is to Confirm your Registration /n</h1>"
      		+ "We do hope that you allow us to check", "text/html");
       

      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
   } catch (MessagingException mex) {
      mex.printStackTrace();
   }
}
}