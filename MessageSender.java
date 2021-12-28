package com.sachin;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class MessageSender {
	private static final String ACCOUNT_SID = "AC1aad40b0e7226dd3d597bf16e7376003";
	private static final String AUTH_TOKEN = "ae8411ccffccf65c678a3790e53386f5";

	public String send(String phone_num, String msg){
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		PhoneNumber to = new PhoneNumber(phone_num);
		// trial phone num
		PhoneNumber from = new PhoneNumber("+17622465090");
		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());

		return message.getSid();
	}
}
