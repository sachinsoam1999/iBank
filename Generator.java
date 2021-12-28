package com.sachin;

import java.util.Random;

public class Generator {
	private final static String small_abc = "abcdefghijklmnopqrstuvwxyz";
	private final static String num = "0123456789";
	private static final String all = small_abc + num + small_abc.toUpperCase();

	public static String generateOTP() {
		StringBuilder otp = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			otp.append(num.charAt(new Random().nextInt(10)));
		}
		return String.valueOf(otp);
	}

	public static String generateCaptcha() {
		StringBuilder captcha = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			// nextInt() => 0 to bound - 1
			captcha.append(all.charAt(new Random().nextInt(62)));
		}
		return String.valueOf(captcha);
	}

}
