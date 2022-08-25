package com.first_app.app_learning_springboot.sale_app.dto;

public class LocationDTO {
    private String country;
    private String city;

    public LocationDTO() {
    }

    public LocationDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
