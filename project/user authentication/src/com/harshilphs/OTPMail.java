package com.harshilphs;

//import java.util.Properties;
import java.util.Random;

//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;  
  
public class OTPMail { 
	
static char[] OTP(int len){
  
    // Using numeric values
    String numbers = "0123456789";
  
    // Using random method
    Random rndm_method = new Random();
  
    char[] otp = new char[len];
  
    for (int i = 0; i < len; i++){
            // Use of charAt() method : to get character value
	    // Use of nextInt() as it is scanning the value as int
	    otp[i] =numbers.charAt(rndm_method.nextInt(numbers.length()));
    }
    return otp;
}	
	
	
 public static void main(String[] args) {  
  
//    String to = ""; // put receiver mail id
//    String subject = "OTP for reset password";
    
      int generatedOtp = Integer.parseInt(String.valueOf(OTP(6)));
      
      String msg = "OTP : "+generatedOtp;
      System.out.println(msg);
//    final String from =""; // put sender mail id
//    final  String password =""; // put sender password
//
//
//    Properties props = new Properties();  
//    props.setProperty("mail.transport.protocol", "smtp");     
//    props.setProperty("mail.host", "smtp.gmail.com");  
//    props.put("mail.smtp.auth", "true");  
//    props.put("mail.smtp.port", "465");  
//    props.put("mail.debug", "true");  
//    props.put("mail.smtp.socketFactory.port", "465");  
//    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
//    props.put("mail.smtp.socketFactory.fallback", "false");  
//    Session session = Session.getDefaultInstance(props,  
//    new javax.mail.Authenticator() {
//       protected PasswordAuthentication getPasswordAuthentication() {  
//       return new PasswordAuthentication(from,password);  
//   }  
//   });  
//
//   //session.setDebug(true);  
//   try {
//   Transport transport = session.getTransport();  
//   InternetAddress addressFrom = new InternetAddress(from);  
//
//   MimeMessage message = new MimeMessage(session);  
//   message.setSender(addressFrom);  
//   message.setSubject(subject);  
//   message.setContent(msg, "text/plain");  
//   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
//
//   transport.connect();  
//   Transport.send(message);  
//   transport.close();}
//   catch (Exception e) {
//	// TODO: handle exception
//   }
   
 }  
} 