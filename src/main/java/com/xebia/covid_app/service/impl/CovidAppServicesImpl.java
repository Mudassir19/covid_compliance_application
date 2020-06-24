package com.xebia.covid_app.service.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.xebia.covid_app.service.CovidAppServices;

@Service
public class CovidAppServicesImpl implements CovidAppServices {

	// cache based on username and OPT MAX 8
	private static final Integer EXPIRE_MINS = 5;
	private LoadingCache<String, Integer> otpCache;

	public CovidAppServicesImpl() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	@Override
	public int generateOTP(String userName) {

		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);

		otpCache.put(userName, otp);
		return otp;

	}

	public int getOTP(String userId) {
		try {
			return otpCache.get(userId);
		} catch (Exception e) {
			return 0;
		}
	}

	// This method is used to clear the OTP catched already
	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}

}
