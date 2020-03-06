package com.openx.openxtask.models;

public class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

    public Geo getGeo() {
        return geo;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
