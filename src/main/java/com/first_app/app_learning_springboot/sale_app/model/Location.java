package com.first_app.app_learning_springboot.sale_app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Location {

    @Id //  primary key
    @GeneratedValue // auto generate id increase
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;


    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)  // MappedBy point to 'location variable' in Sales.
    private Collection<Sale> sales;

    public Location(Integer location_Id, String country, String city) {
        this.id = location_Id;
        this.country = country;
        this.city = city;
    }

    public Location() {
    }

    public Integer getLocationId() {
        return id;
    }

    public void setLocationId(Integer locationId) {
        this.id = locationId;
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
