package com.first_app.app_learning_springboot.sale_app.util;

import com.first_app.app_learning_springboot.sale_app.dto.SaleDTO;
import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.model.Sale;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.repository.LocationRepository;
import com.first_app.app_learning_springboot.sale_app.repository.ProductRepository;
import com.first_app.app_learning_springboot.sale_app.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SaleUtil {
    private final LocationRepository locationRepository;
    private final TimeRepository timeRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SaleUtil(LocationRepository locationRepository, TimeRepository timeRepository, ProductRepository productRepository){
        this.locationRepository = locationRepository;
        this.productRepository = productRepository;
        this.timeRepository = timeRepository;
    }

    public static Sale convertSale(SaleDTO saleDTO,ProductRepository productRepository, LocationRepository locationRepository, TimeRepository timeRepository){
        Integer productId = saleDTO.getProductId();
        Integer locationId = saleDTO.getLocationId();
        Integer timeId = saleDTO.getTimeId();

        Product product = productRepository.findById(productId).get();
        Location location = locationRepository.findById(locationId).get();
        Time time = timeRepository.findById(timeId).get();

        if(product != null && location != null && time != null){
            Sale sale = new Sale(product, location, time, saleDTO.getDollars());
            return sale;
        }else{
            return new Sale();
        }
    }
}
