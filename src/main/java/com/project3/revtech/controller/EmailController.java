
package com.project3.revtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.project3.revtech.entity.EmailNotification;
import com.project3.revtech.service.EmailService;
import com.project3.revtech.service.EmailServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("api")
public class EmailController {
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	
	

	/*@PostMapping("api/message")
	String sendEmailMessage() {
		this.emailService.sendMessage(//
				 "demoreceiveracct1@gmail.com", //
				 "Project 3's First Email", //
				 "The project's initial email works." //
			);
			return "Message sent";	
	} */
	
	@PostMapping("/notification")
	public void sendMessage() {
	emailServiceImpl.sendMessage(null, null, null);
	}
}
