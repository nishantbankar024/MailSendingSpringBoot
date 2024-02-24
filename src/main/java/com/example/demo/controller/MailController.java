package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MailStructor;
import com.example.demo.service.MialService;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	MialService mailService;
	
	@PostMapping("/send/{mail}")
	public String sendMail(@PathVariable String mail, @RequestBody MailStructor mailStructure ) {
		this.mailService.sendMail(mail, mailStructure);
		return "mail send sucessfully ";
	}
	

}
