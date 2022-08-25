package com.first_app.app_learning_springboot.sale_app.service;

import com.first_app.app_learning_springboot.sale_app.model.Product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> getAllProduct();
    Product getProductById(Integer productId);
    void createProduct(Product product);
    void updateProduct(Integer productId, Integer item, String productClass, String inventory);
    void deleteProduct(Integer productId);
}
