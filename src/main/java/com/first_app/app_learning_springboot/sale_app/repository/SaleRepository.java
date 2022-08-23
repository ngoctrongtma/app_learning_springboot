package com.first_app.app_learning_springboot.sale_app.repository;

import com.first_app.app_learning_springboot.sale_app.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
