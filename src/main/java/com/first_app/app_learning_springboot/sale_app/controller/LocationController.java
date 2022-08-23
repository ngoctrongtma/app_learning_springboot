package com.first_app.app_learning_springboot.sale_app.controller;

import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "api/v1/location")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getLocations(){
        return locationService.getLocations();
    }

    @GetMapping(path = "{locationId}")
    public Location getLocationById(@PathVariable("locationId") Integer locationId){
        return locationService.getLocationById(locationId);
    }

    @PostMapping
    public void createLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    // /api/v1/location/{id}?country={country}&city={city}
    @PutMapping(path = "{locationId}")
    public void updateLocation(
            @PathVariable("locationId") Integer locationId,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city
    ){
        locationService.updateLocation(locationId, country, city);
    }

    @DeleteMapping(path = "{locationId}")
    public void deleteLocation(@PathVariable("locationId") Integer locationId){
        locationService.deleteLocation(locationId);
    }





}
