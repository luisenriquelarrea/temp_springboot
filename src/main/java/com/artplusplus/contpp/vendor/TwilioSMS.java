package com.dulcesmontes.logistica.vendor;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import io.github.cdimascio.dotenv.Dotenv;
public class TwilioSMS {
    Dotenv dotenv = null;

    private String ACCOUNT_SID;
    private String AUTH_TOKEN;
    private String PHONE_NUMBER;

    public TwilioSMS(){
        dotenv = Dotenv.configure().load();
        ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
        AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
        PHONE_NUMBER = dotenv.get("TWILIO_PHONE_NUMBER");
        // Find your Account Sid and Token at twilio.com/console
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public String sendMessage(String msg, String phoneNumber){
        Message message = Message.creator(
            new PhoneNumber("whatsapp:+521"+phoneNumber),
            new PhoneNumber("whatsapp:+"+PHONE_NUMBER),
            msg
        ).create();
        return message.getSid();
    }
}
