package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.MailStructor;

@Service
public class MialService {
	
	@Autowired
	JavaMailSender javaMailSender;

	@Value("$(spring.mail.username)")
	private String formMail;
	
	public void sendMail(String mail,MailStructor mailStructor) {
		
		SimpleMailMessage simpleMessage=new SimpleMailMessage();
		
		simpleMessage.setFrom(formMail);
		simpleMessage.setSubject(mailStructor.getSubject());
		simpleMessage.setText(mailStructor.getMessage());
		simpleMessage.setTo(mail);
		
		javaMailSender.send(simpleMessage);
	}
}
