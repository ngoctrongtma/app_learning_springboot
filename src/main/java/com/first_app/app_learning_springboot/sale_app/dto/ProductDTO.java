package com.first_app.app_learning_springboot.sale_app.dto;

public class ProductDTO {

    private Integer item;
    private String productClass;
    private String inventory;

    public ProductDTO( ) {
    }

    public ProductDTO(Integer item, String productClass, String inventory) {
        this.item = item;
        this.productClass = productClass;
        this.inventory = inventory;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
}
