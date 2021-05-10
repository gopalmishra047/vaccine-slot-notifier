package com.cowin.vaccine.slot.notifier.config;

import org.springframework.boot.context.properties.*;
import org.springframework.stereotype.*;

@ConfigurationProperties("api")
@Component
public class ApiProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
