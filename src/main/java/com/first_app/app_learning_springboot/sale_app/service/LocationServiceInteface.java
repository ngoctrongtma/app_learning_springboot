package com.first_app.app_learning_springboot.sale_app.service;

import com.first_app.app_learning_springboot.sale_app.model.Location;

import java.util.List;

public interface LocationServiceInteface {
    //get all location
    List<Location> getLocations();
    Location getLocationById(Integer location_Id);
    void addLocation(Location location);
    void updateLocation(Integer locationId, String country, String city);
    void deleteLocation(Integer locationId);
}
