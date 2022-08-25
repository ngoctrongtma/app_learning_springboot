package com.first_app.app_learning_springboot.sale_app.model;

import javax.persistence.*;

@Entity
@Table
//@IdClass(CompositeSaleId.class)
public class Sale {

    @Id
    @GeneratedValue
    private Integer id;

//    @Id
    @ManyToOne
//  @PrimaryKeyJoinColumn(name = "product_id")
    @JoinColumn(name = "product_id")
    private Product product;

//    @Id
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

 //   @Id
    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    private Double dollars;

    public Sale(Product product, Location location, Time time, Double dollars) {
        this.product = product;
        this.location = location;
        this.time = time;
        this.dollars = dollars;
    }

    public Sale() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Double getDollars() {
        return dollars;
    }

    public void setDollars(Double dollars) {
        this.dollars = dollars;
    }
}
