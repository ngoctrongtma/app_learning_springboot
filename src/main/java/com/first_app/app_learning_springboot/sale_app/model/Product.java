package com.first_app.app_learning_springboot.sale_app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Product {

    @Id // primary key
    @GeneratedValue // auto generate id increase
    private Integer id;

    @Column(name = "item")
    private Integer item;

    @Column(name = "product_class")
    private String productClass;

    @Column(name = "inventory")
    private String inventory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)  // MappedBy point to product variable in Sales.
    private Collection<Sale> sales;

    public Product(Integer product_Id, Integer item, String aClass, String inventory) {
        id = product_Id;
        this.item = item;
        productClass = aClass;
        this.inventory = inventory;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Product{" +
                "Product_Id=" + id +
                ", Item=" + item +
                ", Class='" + productClass + '\'' +
                ", Inventory='" + inventory + '\'' +
                '}';
    }
}
