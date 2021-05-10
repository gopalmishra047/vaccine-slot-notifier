package com.cowin.vaccine.slot.notifier.model;

import java.util.*;

public class Session {
    private String session_id;
    private String date;
    private int available_capacity;
    private int min_age_limit;
    private String vaccine;
    private List<String> slots;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(int available_capacity) {
        this.available_capacity = available_capacity;
    }

    public int getMin_age_limit() {
        return min_age_limit;
    }

    public void setMin_age_limit(int min_age_limit) {
        this.min_age_limit = min_age_limit;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public List<String> getSlots() {
        return slots;
    }

    public void setSlots(List<String> slots) {
        this.slots = slots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return available_capacity == session.available_capacity && min_age_limit == session.min_age_limit && Objects.equals(session_id, session.session_id) && Objects.equals(date, session.date) && Objects.equals(vaccine, session.vaccine) && Objects.equals(slots, session.slots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session_id, date, available_capacity, min_age_limit, vaccine, slots);
    }

    @Override
    public String toString() {
        return "Session{" +
                "session_id='" + session_id + '\'' +
                ", date='" + date + '\'' +
                ", available_capacity=" + available_capacity +
                ", min_age_limit=" + min_age_limit +
                ", vaccine='" + vaccine + '\'' +
                ", slots=" + slots +
                '}';
    }
}
