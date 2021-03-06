package com.evaluateyourself.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private MailSender mailSender;
	
	public void sendEmail(String to, String subject, String body){
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
	}
}
