package com.xebia.covid_app.service;

import org.springframework.stereotype.Service;


public interface CovidAppServices {

	public int generateOTP(String userName);
	
	public int getOTP(String userId);

	public void clearOTP(String userName);
}
