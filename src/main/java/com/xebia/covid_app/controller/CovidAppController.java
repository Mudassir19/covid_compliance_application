package com.xebia.covid_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.covid_app.service.CovidAppServices;
import com.xebia.covid_app.utility.MailSender;

@RestController
@RequestMapping(value = "/login")
public class CovidAppController {

	private static final String CLASS_NAME = CovidAppController.class.getName();

	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);

	@Autowired
	private CovidAppServices service;

	String userName = "";

	@PostMapping(value = "/otp", produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateSendOTP(@RequestParam String userId) {

		userName = userId;
		LOGGER.info("Generate OTP Controller::User name-->" + userName);

		int otp = service.generateOTP(userName);
		LOGGER.info("Generated OTP is:" + otp);

		String status = MailSender.sendMail(userName, otp);

		LOGGER.info("Mail Status is:" + status);

		return status;

	}

	@PostMapping(value = "/validateOtp")
	public String validateOtp(@RequestParam int otp) {
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";

		// Validate the Otp
		if (otp >= 0) {
			int serverOtp = service.getOTP(userName);
			if (serverOtp > 0) {
				if (otp == serverOtp) {
					// service.clearOTP(userName);
					return ("Entered Otp is valid");
				} else {
					return SUCCESS;
				}
			} else {
				return FAIL;
			}
		} else {
			return FAIL;
		}

	}
}
