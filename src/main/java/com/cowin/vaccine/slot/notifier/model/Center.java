package com.cowin.vaccine.slot.notifier.model;

import java.util.*;

public class Center {
    private int center_id;
    private String name;
    private String address;
    private String state_name;
    private String district_name;
    private String block_name;
    private int pincode;
    private int lat;
    // private int long;
    private String from;
    private String to;
    private String fee_type;
    private List<Session> sessions;
    private List<VaccineFee> vaccine_fees;

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<VaccineFee> getVaccine_fees() {
        return vaccine_fees;
    }

    public void setVaccine_fees(List<VaccineFee> vaccine_fees) {
        this.vaccine_fees = vaccine_fees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Center center = (Center) o;
        return center_id == center.center_id && pincode == center.pincode && lat == center.lat && Objects.equals(name, center.name) && Objects.equals(address, center.address) && Objects.equals(state_name, center.state_name) && Objects.equals(district_name, center.district_name) && Objects.equals(block_name, center.block_name) && Objects.equals(from, center.from) && Objects.equals(to, center.to) && Objects.equals(fee_type, center.fee_type) && Objects.equals(sessions, center.sessions) && Objects.equals(vaccine_fees, center.vaccine_fees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center_id, name, address, state_name, district_name, block_name, pincode, lat, from, to, fee_type, sessions, vaccine_fees);
    }

    @Override
    public String toString() {
        return "Center{" +
                "center_id=" + center_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", state_name='" + state_name + '\'' +
                ", district_name='" + district_name + '\'' +
                ", block_name='" + block_name + '\'' +
                ", pincode=" + pincode +
                ", lat=" + lat +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", fee_type='" + fee_type + '\'' +
                ", sessions=" + sessions +
                ", vaccine_fees=" + vaccine_fees +
                '}';
    }
}
