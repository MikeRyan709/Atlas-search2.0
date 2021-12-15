package com.keyin.AtlasSearch.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long location_id;
    private String city;
    private String country;
    private String zipcode;
    private String timezone;


    public Location() {
    }

    public Location(long location_id, String city, String country, String zipcode, String timezone) {
        this.location_id = location_id;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        this.timezone = timezone;
    }

    public Location(String city, String country, String zipcode, String timezone) {
    }


    //Getters for Location.java
    public long getLocation_id(){ return location_id; }
    public String getCity(){ return city; }
    public String getCountry(){ return country; }
    public String getZipcode(){ return zipcode; }
    public String getTimezone(){ return timezone; }


    //Setters for Location.java
    public void setLocation_id(long location_id){ this.location_id = location_id; }
    public void setCity(String city) { this.city = city; }
    public void setCountry(String country){ this.country = country; }
    public void setZipcode(String zipcode){ this.zipcode = zipcode; }
    public void setTimezone(String timezone){ this.timezone = timezone; }
}