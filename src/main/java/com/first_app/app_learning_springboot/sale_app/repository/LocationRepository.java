package com.first_app.app_learning_springboot.sale_app.repository;

import com.first_app.app_learning_springboot.sale_app.model.Location;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("SELECT l FROM Location as l WHERE l.city = :city")
    Optional<Location> findLocationByCity (@Param("city") String city);
    // cách 2: Location findByCity(String city);

    @Query("SELECT l FROM Location l WHERE l.country = :country ")
    Optional<Location> findLocationByCountry (@Param("country") String country);

}
