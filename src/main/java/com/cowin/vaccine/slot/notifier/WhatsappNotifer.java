package com.cowin.vaccine.slot.notifier;

import com.cowin.vaccine.slot.notifier.model.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import javax.annotation.*;
import org.springframework.stereotype.*;

@Service
public class WhatsappNotifer {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC49c3fffd77ac2c66b75bac6a9444941f";
    public static final String AUTH_TOKEN = "e10e0e882be8bd98c73747d6139f358d";

    @PostConstruct
    public void setUp(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
    public void sendWhatsappMessage(Center center) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+919175479870"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Hello Gopal, Vaccine slot is available for 18+ on following slots: /n"+center.toString())
                .create();

        System.out.println(message.getSid());
    }
}