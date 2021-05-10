package com.cowin.vaccine.slot.notifier.model;

import java.util.*;

public class Response {
    private List<Center> centers;

    public List<Center> getCenters() {
        return centers;
    }

    public void setCenters(List<Center> centers) {
        this.centers = centers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(centers, response.centers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centers);
    }

    @Override
    public String toString() {
        return "Response{" +
                "centers=" + centers +
                '}';
    }
}
