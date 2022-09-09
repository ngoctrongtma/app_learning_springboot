package com.first_app.app_learning_springboot.sale_app.service;

import com.first_app.app_learning_springboot.sale_app.dto.SaleDTO;
import com.first_app.app_learning_springboot.sale_app.model.Sale;

import java.util.List;

public interface SaleServiceInterface {
    List<SaleDTO> getAllSale();
    Sale getSaleById(Integer saleId);
    void createSale(SaleDTO sale);
    void updateSale(Integer saleId,Double dollars);
    void deleteSale(Integer saleId);
}
