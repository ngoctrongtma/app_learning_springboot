package com.first_app.app_learning_springboot.sale_app.repository;

import com.first_app.app_learning_springboot.sale_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
