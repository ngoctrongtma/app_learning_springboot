package com.first_app.app_learning_springboot.sale_app.service.implement;

import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.repository.LocationRepository;
import com.first_app.app_learning_springboot.sale_app.service.LocationServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocationService implements LocationServiceInteface {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @Override
    //get all location
    public List<Location> getLocations(){
        // save in list
        // convert to dto
        // return to client
        return locationRepository.findAll();
    }


    @Override
    // get location by Id
    public Location getLocationById(Integer location_Id){
        return locationRepository.findById(location_Id).get();
    }

    @Override
    //create location
    public void addLocation(Location location){
        Optional<Location> cityOptional = locationRepository.findLocationByCity(location.getCity());
        Optional<Location> countryOptional = locationRepository.findLocationByCountry(location.getCountry());
        if(cityOptional.isPresent() && countryOptional.isPresent()){
            throw new IllegalStateException("Location is exists");
        }
        // locationRepository.findByCity(location.getCity());
        locationRepository.save(location);
    }


    // update location
    @Override
    @Transactional
    public void updateLocation(Integer locationId, String country, String city){
        Location location = locationRepository.findById(locationId).orElseThrow(()-> new IllegalStateException("Location is not exists"));
        Optional<Location> cityOptional = locationRepository.findLocationByCity(city);
        Optional<Location> countryOptional = locationRepository.findLocationByCountry(country);
        if(cityOptional.isPresent() && countryOptional.isPresent()){
            throw new IllegalStateException("Location is exists!");
        }
        if(country != null && country.length() > 0 && !Objects.equals(location.getCountry(), country)){
            location.setCountry(country);
        }
        if(city != null && city.length() > 0 && !Objects.equals(location.getCountry(), city)){
            location.setCity(city);
        }
    }

    @Override
    // delete location
    public void deleteLocation(Integer locationId) {
        boolean exists = locationRepository.existsById(locationId);
        if(!exists){
            throw new IllegalStateException("Id is not exists!");
        }
        locationRepository.findById(locationId);
        locationRepository.deleteById(locationId);
    }

}
