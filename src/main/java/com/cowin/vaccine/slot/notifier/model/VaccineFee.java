package com.cowin.vaccine.slot.notifier.model;

import java.util.*;

public class VaccineFee {
    private String vaccine;
    private String fee;

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccineFee that = (VaccineFee) o;
        return Objects.equals(vaccine, that.vaccine) && Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccine, fee);
    }

    @Override
    public String toString() {
        return "VaccineFee{" +
                "vaccine='" + vaccine + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
