package com.example.Login.services;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.Twilio;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	 	@Value("${app.twilio.accountSID}")
	    private String accountSID;

	    @Value("${app.twilio.authToken}")
	    private String authToken;

	    @Value("${app.twilio.fromPhoneNo}")
	    private String fromPhoneNo;


	    public void sendSms(String toPhoneNo, String message) {
	        Twilio.init(accountSID, authToken);
	        Message.creator(new PhoneNumber(toPhoneNo), new PhoneNumber(fromPhoneNo), message).create();
	    }
}
