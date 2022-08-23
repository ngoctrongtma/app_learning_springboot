package com.first_app.app_learning_springboot.sale_app.service;

import com.first_app.app_learning_springboot.sale_app.model.Sale;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class SaleService {
    private final SaleRepository saleRepository;


    @Autowired
    public SaleService(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    // get all sale
    public List<Sale> getAllSale(){
        return saleRepository.findAll();
    }

    // get sale by id
    public Sale getSaleById(Integer saleId){
        return saleRepository.findById(saleId).get();
    }
    // create sale
    public void createSale(Sale sale){
        saleRepository.save(sale);
    }

    // update sale
//    @Transactional
//    public void updateSale(Integer saleId, Integer timeId, Integer productId, Integer locationId){
//        Sale sale = saleRepository.findById(saleId).orElseThrow(() -> new IllegalStateException("Time is not exists!"));
//        if(timeId != null){
//            sale.set(month);
//        }
//        if(year != null && !Objects.equals(time.getYear(), year)){
//            time.setYear(year);
//        }
//        if(quarter != null && !Objects.equals(time.getQuarter(), quarter)){
//            time.setQuarter(quarter);
//        }
//    }

    // delete product
//    public void deleteTime(Integer timeId){
//        boolean exists = timeRepository.existsById(timeId);
//        if(!exists){
//            throw new IllegalStateException("Id is not exists!");
//        }
//        timeRepository.findById(timeId);
//        timeRepository.deleteById(timeId);
//    }
}
