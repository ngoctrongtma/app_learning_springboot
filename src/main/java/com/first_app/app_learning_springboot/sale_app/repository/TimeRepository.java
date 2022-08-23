package com.first_app.app_learning_springboot.sale_app.repository;

import com.first_app.app_learning_springboot.sale_app.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

}
