package com.project3.revtech.service;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.NoArgsConstructor;

// this may need to be moved to controller
@Service
@CrossOrigin
public class EmailService {
	
	JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
	
	
	public EmailService() {
		emailSender.setHost("smtp.gmail.com");
	    emailSender.setPort(587);
	    emailSender.setUsername("devdemoacct1@gmail.com");
	    emailSender.setPassword("Gmaildemo-1");
	    
	    Properties props = emailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.port","587");
        props.put("mail.smtp.host", "devdemoacct1@gmail.com");
        props.put("mail.smtp.starttls.enable", "true") ;
        props.put("mail.smtp.auth", "true") ;
	    
	    
	    emailSender.setJavaMailProperties(props);
  	}
	
	public void sendMessage(String to, String subject, String text) {
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("devdemoacct1");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		this.emailSender.send(message);
	}
}
