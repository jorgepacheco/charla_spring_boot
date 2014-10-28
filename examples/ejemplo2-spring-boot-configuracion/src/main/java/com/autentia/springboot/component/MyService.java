package com.autentia.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.autentia.springboot.mail.MessageProperties;

@Service
public class MyService implements CommandLineRunner {

	private final JavaMailSender javaMailSender;
    
	@Autowired
    private MessageProperties messageProperties;

	@Autowired
	public MyService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	public String message() {
		send();
		return "Primera aplicación con Spring Boot !!!!\n";
	}
	

	public SimpleMailMessage send() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(messageProperties.getTo());
		mailMessage.setReplyTo(messageProperties.getReplyTo());
		mailMessage.setFrom(messageProperties.getFrom());
		mailMessage.setSubject(messageProperties.getSubject());
		mailMessage.setText(messageProperties.getText());
		javaMailSender.send(mailMessage);
		return mailMessage;
	}

	public void run(String... args) {
		System.out.println(":::: COMMAND LINE RUNNER ::::");
	}

}