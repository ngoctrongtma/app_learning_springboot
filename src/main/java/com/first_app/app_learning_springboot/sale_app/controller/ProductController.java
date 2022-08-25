package com.first_app.app_learning_springboot.sale_app.controller;
import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.service.ProductServiceInterface;
import com.first_app.app_learning_springboot.sale_app.util.SaleAppUrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = SaleAppUrlUtil.productUrl)
public class ProductController {
    private final ProductServiceInterface productService;
    @Autowired
    public ProductController(ProductServiceInterface productServiceInterface){
        this.productService = productServiceInterface;
    }
    Logger logger
            = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public List<Product> getProducts(){
        logger.info("get all product");
        return productService.getAllProduct();
    }

    @GetMapping(path = "{productId}")
    public  Product getProductById(@PathVariable("productId") Integer productId){
        logger.info("get product by id");
        return productService.getProductById(productId);
    }


    @PostMapping
    public void createProduct(@RequestBody Product product){
        logger.info("create product");
        productService.createProduct(product);
    }

    @PutMapping(path = "{productId}")
    public void updateLocation(
            @PathVariable("productId") Integer productId,
            @RequestParam(required = false) Integer item,
            @RequestParam(required = false) String productClass,
            @RequestParam(required = false) String inventory
    ){
        logger.info("update product");
        productService.updateProduct(productId, item, productClass, inventory );
    }

    @DeleteMapping(path = "{productId}")
    public void deleteLocation(@PathVariable("productId") Integer productId){
        logger.info("delete product");
        productService.deleteProduct(productId);
    }

}
