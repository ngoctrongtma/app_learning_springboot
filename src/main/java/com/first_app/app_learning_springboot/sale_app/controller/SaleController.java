package com.first_app.app_learning_springboot.sale_app.controller;

import com.first_app.app_learning_springboot.sale_app.model.Sale;
import com.first_app.app_learning_springboot.sale_app.service.SaleServiceInterface;
import com.first_app.app_learning_springboot.sale_app.util.SaleAppUrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = SaleAppUrlUtil.saleUrl)
public class SaleController {
    private final SaleServiceInterface saleService;
    @Autowired
    public SaleController(SaleServiceInterface saleServiceInterface){
        this.saleService = saleServiceInterface;
    }

    Logger logger
            = LoggerFactory.getLogger(SaleController.class);

    @GetMapping
    public List<Sale> getAllSale(){
        logger.info("get all sale");
        return saleService.getAllSale();
    }

    @GetMapping(path = "{saleId}")
    public  Sale getSaleById(@PathVariable("saleId") Integer saleId){
        logger.info("get sale by id");
        return saleService.getSaleById(saleId);
    }

    @PostMapping
    public void createSale(@RequestBody Sale sale){
        logger.info("create sale");
        saleService.createSale(sale);
    }

    @PutMapping(path = "{saleId}")
    public void updateSale(
            @PathVariable("saleId") Integer timeId,
            @RequestParam(required = false) Double dollars

    ){
        logger.info("update sale");
        saleService.updateSale(timeId, dollars);
    }

    @DeleteMapping(path = "{saleId}")
    public void deleteTime(@PathVariable("saleId") Integer saleId){
        logger.info("delete sale");
        saleService.deleteSale(saleId);
    }


}
