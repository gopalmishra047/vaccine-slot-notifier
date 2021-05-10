package com.cowin.vaccine.slot.notifier.config;

import java.util.*;
import org.springframework.boot.context.properties.*;

@ConfigurationProperties("twilio")
public class TwilioProperties {
    private String accountId;
    private String authToken;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwilioProperties that = (TwilioProperties) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(authToken, that.authToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, authToken);
    }
}
