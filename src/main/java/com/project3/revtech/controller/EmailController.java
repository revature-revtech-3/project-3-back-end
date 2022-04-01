
package com.project3.revtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.revtech.service.EmailService;

@RestController
public class EmailController extends EmailService {
	
	@Autowired
	private EmailService emailService;
	
	public EmailController(JavaMailSender emailSender) {
		super();
	}
	
	/*@PostMapping("/api/message")
	String sendEmailMessage() {
		this.emailService.sendMessage(//
				 "demoreceiveracct1@gmail.com", //
				 "Project 3's First Email", //
				 "The project's initial email works." //
			);
			return "Message sent";	
	} */
}