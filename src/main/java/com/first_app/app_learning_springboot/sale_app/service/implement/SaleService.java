package com.first_app.app_learning_springboot.sale_app.service.implement;

import com.first_app.app_learning_springboot.sale_app.dto.SaleDTO;
import com.first_app.app_learning_springboot.sale_app.model.Sale;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.repository.SaleRepository;
import com.first_app.app_learning_springboot.sale_app.service.SaleServiceInterface;
import com.first_app.app_learning_springboot.sale_app.util.SaleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SaleService implements SaleServiceInterface {
    private final SaleRepository saleRepository;
    private final SaleUtil saleUtil;
    @Autowired
    public SaleService(SaleRepository saleRepository,SaleUtil saleUtil){
        this.saleRepository = saleRepository;
        this.saleUtil = saleUtil;
    }

    @Override
    // get all sale
    public List<SaleDTO> getAllSale(){
        List<Sale> listSale = saleRepository.findAll();
        List<SaleDTO> listSaleDTO = new ArrayList<>();
        for(int i = 0; i < listSale.size(); i++) {
            listSaleDTO.add(saleUtil.convertToSaleDTO(listSale.get(i)));
        }
        return listSaleDTO;
    }

    @Override
    // get sale by id
    public Sale getSaleById(Integer saleId){
        return saleRepository.findById(saleId).get();
    }

    @Override
    // create sale
    public void createSale(SaleDTO sale){
        saleRepository.save(saleUtil.convertToSale(sale));
    }

    @Override
    // update sale
    @Transactional // it use to ??? => maybe use to update Sale
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
