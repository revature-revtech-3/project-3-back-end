package com.project3.revtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
//@CrossOrigin
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender emailSender;
	
	public EmailServiceImpl (JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	@Override
	public void sendMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom ("revtech@support.com");
		message.setTo(to);
		message.setSubject("Transaction Complete");
		message.setText("Thank you for choosing RevTech! "
				+ "Your transaction has been completed. "
				+ "Please allow 5-10 business days for shipping information. "
				+ "Contact RevTech Support with any further questions. ");
		emailSender.send(message);
		System.out.println("Email Sent Successfully!");
		
	}
	

}
