package com.ds.FireAlarmMonitor.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ds.FireAlarmMonitor.model.FireAlarm;

public class MailController {

	public  void sendMail(FireAlarm f) throws AddressException,MessagingException{
		String  sendermail = "apicoders.codeArmy@gmail.com";
		String senderPassword = "p5@k@a9833";
		String recipientAddress = "pasanpramuditha97@gmail.com";
		String subject = "Alert on fireAlarm "+f.getId();
		String emailBody = "The fire alarm "+f.getId()+" at Floor "+ f.getFloorNo()+" room "+f.getRoomNo()+"  CO2  Level - "+f.getCo2Level()+"  Smoke Level - "+f.getSmokeLevel();
		
		
		
		//set SMTP server properties
		 Properties properties = new Properties();
	     properties.put("mail.smtp.host", "smtp.gmail.com");
	     properties.put("mail.smtp.port","587");
	     properties.put("mail.smtp.auth", "true");
	     properties.put("mail.smtp.starttls.enable", "true");
		
	     //creating new session using authenticator
	     Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(sendermail, senderPassword);
	            }
	        };  
	        
	     Session session = Session.getInstance(properties, auth); 
	      
	     //create new email
	     Message message = new MimeMessage(session);
	     
	     message.setFrom(new InternetAddress(sendermail));
	     InternetAddress[] toAddresses = { new InternetAddress(recipientAddress) };
	     message.setRecipients(Message.RecipientType.TO, toAddresses);
	     message.setSubject(subject);
	     message.setSentDate(new Date());
	     message.setText(emailBody);
	     
	     Transport.send(message);
		
	}
}
