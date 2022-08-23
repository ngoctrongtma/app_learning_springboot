package com.first_app.app_learning_springboot.sale_app.controller;
import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProduct();
    }

    @GetMapping(path = "{productId}")
    public  Product getProductById(@PathVariable("productId") Integer productId){
        return productService.getProductById(productId);
    }


    @PostMapping
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @PutMapping(path = "{productId}")
    public void updateLocation(
            @PathVariable("productId") Integer productId,
            @RequestParam(required = false) Integer item,
            @RequestParam(required = false) String productClass,
            @RequestParam(required = false) String inventory
    ){
        productService.updateProduct(productId, item, productClass, inventory );
    }

    @DeleteMapping(path = "{productId}")
    public void deleteLocation(@PathVariable("productId") Integer productId){
        productService.deleteProduct(productId);
    }

}
