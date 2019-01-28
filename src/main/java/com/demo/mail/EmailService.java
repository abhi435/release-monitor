package com.demo.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public String sendMail(String processingStatus) {
		MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
        	helper.setTo("rohit2300@gmail.com");
        	if ("success".equalsIgnoreCase(processingStatus)) {
        		helper.setText("Application is up and running!");
                helper.setSubject("Application test success!");
        	} else {
        		helper.setText("Application is down!");
                helper.setSubject("Application test failed!");
        	}
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error sending mail!";
        }
        mailSender.send(message);
        return "Mail notification sent successfully!";
	}
}
