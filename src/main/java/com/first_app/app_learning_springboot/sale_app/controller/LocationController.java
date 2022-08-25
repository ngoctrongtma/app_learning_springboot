package com.first_app.app_learning_springboot.sale_app.controller;

import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.service.LocationServiceInteface;
import com.first_app.app_learning_springboot.sale_app.util.SaleAppUrlUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = SaleAppUrlUtil.locationUrl)
public class LocationController {
    private final LocationServiceInteface locationService;
    // creating a logger
    Logger logger
            = LoggerFactory.getLogger(LocationController.class);


    @Autowired
    public LocationController(LocationServiceInteface locationServiceInteface){
        this.locationService = locationServiceInteface;
    }

    @GetMapping
    public List<Location> getLocations(){
        logger.info("get all location");
        return locationService.getLocations();
    }

    @GetMapping(path = "{locationId}")
    public Location getLocationById(@PathVariable("locationId") Integer locationId){
        logger.info("get location by id");
        return locationService.getLocationById(locationId);
    }
    @PostMapping
    public void createLocation(@RequestBody Location location){
        logger.info("create location");
        locationService.addLocation(location);
    }

    // /api/v1/location/{id}?country={country}&city={city}
    @PutMapping(path = "{locationId}")
    public void updateLocation(
            @PathVariable("locationId") Integer locationId,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city
    ){
        logger.info("update location");
        locationService.updateLocation(locationId, country, city);
    }

    @DeleteMapping(path = "{locationId}")
    public void deleteLocation(@PathVariable("locationId") Integer locationId){
        logger.info("delete location");
        locationService.deleteLocation(locationId);
    }
}
