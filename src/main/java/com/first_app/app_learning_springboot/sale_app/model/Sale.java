package com.first_app.app_learning_springboot.sale_app.model;

import javax.persistence.*;

@Entity
@Table
public class Sale {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    private Double dollars;


}
