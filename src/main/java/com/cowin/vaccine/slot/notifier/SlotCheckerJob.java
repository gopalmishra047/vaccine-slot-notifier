package com.cowin.vaccine.slot.notifier;

import com.cowin.vaccine.slot.notifier.model.*;
import com.cowin.vaccine.slot.notifier.util.*;
import com.google.gson.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.client.*;

@Component
public class SlotCheckerJob {

    @Autowired private WebClientUtil webClientUtil;
    @Autowired private WhatsappNotifer whatsappNotifer;
    private static final Gson gson = new Gson();

    @Scheduled(cron = "*/30 * * * * *")
    public void checkSlots() {
        String json = webClientUtil.getAndRetrieve().bodyToMono(String.class)
                .block();
        Response response = gson.fromJson(json, Response.class);
        if (response != null) {
            List<Center> centers = response.getCenters();
            System.out.println("===========================================================");
            System.out.println("Total vaccination centers in Mumbai: " + centers.size());
            System.out.println("===========================================================");
            for (Center center : centers) {
                System.out.println();
                System.out.println("Checking for 18+ slots in: " + center.getName());
                for (Session session : center.getSessions()) {
                    if (session.getAvailable_capacity() != 0 && session.getMin_age_limit() == 18) {
                        System.out.println("Hurry up ! "+session.getAvailable_capacity() +" Slot found in " + center.getName());
                        whatsappNotifer.sendWhatsappMessage(center);
                        System.out.println("Notification send on your whatsapp.");
                    } else {
                        System.out.println();
                        System.out.println("No slot found.");
                    }
                }
            }
            System.out.println();
            System.out.println("Will check again after 15 seconds....");
            System.out.println();
        }
    }
}
