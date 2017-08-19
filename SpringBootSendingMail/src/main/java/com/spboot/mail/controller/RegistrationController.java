package com.spboot.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spboot.mail.domain.User;
import com.spboot.mail.service.NotificationService;

@RestController
public class RegistrationController {

	@Autowired
	NotificationService notificationService;

	@RequestMapping("/signup")
	public String signUp() {
		return "Please sign-up to proceed";

	}

	@RequestMapping("/signup-success")
	public String signUpSuccess() {

		User user = new User();
		user.setFirstName("Jyoti");
		user.setLastName("Prakash");
		user.setEmail("mr.jyotiprakash@gmail.com");

		try {
			notificationService.sendNotification(user);
		} catch (MailException e) {
			e.printStackTrace();

		}

		return "You have registered successfully, Thank you";

	}

}
