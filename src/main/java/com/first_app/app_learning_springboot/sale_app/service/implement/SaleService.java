package com.first_app.app_learning_springboot.sale_app.service.implement;

import com.first_app.app_learning_springboot.sale_app.model.Sale;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.repository.SaleRepository;
import com.first_app.app_learning_springboot.sale_app.service.SaleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class SaleService implements SaleServiceInterface {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    // get all sale
    public List<Sale> getAllSale(){
        return saleRepository.findAll();
    }

    @Override
    // get sale by id
    public Sale getSaleById(Integer saleId){
        return saleRepository.findById(saleId).get();
    }

    @Override
    // create sale
    public void createSale(Sale sale){
        saleRepository.save(sale);
    }

    @Override
    // update sale
    @Transactional
    public void updateSale(Integer saleId,Double dollars){
        Sale sale = saleRepository.findById(saleId).orElseThrow(() -> new IllegalStateException("sale is not exists!"));
        if(dollars != null && sale.getDollars() != dollars){
            sale.setDollars(dollars);
        }
    }

    @Override
    // delete product
    public void deleteSale(Integer saleId){
        boolean exists = saleRepository.existsById(saleId);
        if(!exists){
            throw new IllegalStateException("Id is not exists!");
        }
        saleRepository.findById(saleId);
        saleRepository.deleteById(saleId);
    }
}