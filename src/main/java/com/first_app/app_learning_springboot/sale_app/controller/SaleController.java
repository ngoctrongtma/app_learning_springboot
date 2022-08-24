package com.first_app.app_learning_springboot.sale_app.controller;

import com.first_app.app_learning_springboot.sale_app.model.Sale;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.service.SaleService;
import com.first_app.app_learning_springboot.sale_app.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sale")
public class SaleController {
    private final SaleService saleService;
    @Autowired
    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @GetMapping
    public List<Sale> getAllSale(){
        return saleService.getAllSale();
    }

    @GetMapping(path = "{saleId}")
    public  Sale getSaleById(@PathVariable("saleId") Integer saleId){
        return saleService.getSaleById(saleId);
    }

    @PostMapping
    public void createSale(@RequestBody Sale sale){
        saleService.createSale(sale);
    }

    @PutMapping(path = "{saleId}")
    public void updateSale(
            @PathVariable("saleId") Integer timeId,
            @RequestParam(required = false) Double dollas

    ){
        saleService.updateSale(timeId, dollas);
    }

    @DeleteMapping(path = "{saleId}")
    public void deleteTime(@PathVariable("saleId") Integer saleId){
        saleService.deleteSale(saleId);
    }


}
