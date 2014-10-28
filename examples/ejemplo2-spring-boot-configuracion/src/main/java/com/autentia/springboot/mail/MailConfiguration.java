package com.autentia.springboot.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {

	@Autowired
	private MailProperties mailProperties;
	
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
       
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",  mailProperties.getSmtp().isAuth());
        properties.put("mail.smtp.starttls.enable",  mailProperties.getSmtp().isStarttlsEnable());
        mailSender.setJavaMailProperties(properties);
        mailSender.setHost(mailProperties.getHost());
        mailSender.setPort(mailProperties.getPort());
        mailSender.setProtocol(mailProperties.getProtocol());
        mailSender.setUsername(mailProperties.getUsername());
        mailSender.setPassword(mailProperties.getPassword());
        return mailSender;
    }



}