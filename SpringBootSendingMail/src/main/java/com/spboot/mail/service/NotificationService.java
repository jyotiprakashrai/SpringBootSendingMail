package com.spboot.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.spboot.mail.domain.User;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {

		this.javaMailSender = javaMailSender;

	}

	public void sendNotification(User user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("mr.jyotiprakash@gmail.com");
		mail.setSubject("Registration Completed");
		mail.setText("Hey user this is a confirmation mail of your registration");

		javaMailSender.send(mail);
	}

}
