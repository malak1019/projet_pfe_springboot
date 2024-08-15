/*package com.example.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Login.services.SmsService;


@RestController
@RequestMapping("/SMS")
public class SmsController {
	
    @Autowired
    private SmsService smsService;

    @PostMapping("/sendTestSms")
    public String sendTestSms(@RequestParam String phoneNumber) {
        String message = "Hello World";
        smsService.sendSms(phoneNumber, message);
        return "SMS sent to " + phoneNumber;
    }
    
}
*/