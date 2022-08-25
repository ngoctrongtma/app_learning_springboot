package com.first_app.app_learning_springboot.sale_app.dto;

public class SaleDTO {
    private Integer productId;
    private Integer locationId;
    private Integer timeId;
    private Double dollars;

    public SaleDTO( ) {}

    public SaleDTO(Integer product_id, Integer location_id, Integer time_id, Double dollars) {
        this.productId = product_id;
        this.locationId = location_id;
        this.timeId = time_id;
        this.dollars = dollars;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public Double getDollars() {
        return dollars;
    }

    public void setDollars(Double dollars) {
        this.dollars = dollars;
    }
}
