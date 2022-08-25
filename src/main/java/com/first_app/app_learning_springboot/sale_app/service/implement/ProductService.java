package com.first_app.app_learning_springboot.sale_app.service.implement;

import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.repository.ProductRepository;
import com.first_app.app_learning_springboot.sale_app.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements ProductServiceInterface {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    // get all product
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    // get product by id
    public Product getProductById(Integer productId){
        return productRepository.findById(productId).get();
    }

    @Override
    // create product
    public void createProduct(Product product){
        productRepository.save(product);
    }

    @Override
    // update product
    @Transactional
    public void updateProduct(Integer productId, Integer item, String productClass, String inventory){
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("Product is not exists!"));
        if(item != null && !Objects.equals(product.getItem(), item)){
            product.setItem(item);
        }
        if(productClass != null && productClass.length() > 0 && !Objects.equals(product.getProductClass(), productClass)){
            product.setProductClass(productClass);
        }
        if(inventory != null && inventory.length() > 0 && !Objects.equals(product.getInventory(), inventory)){
            product.setInventory(inventory);
        }

    }

    @Override
    // delete product
    public void deleteProduct(Integer productId){
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Id is not exists!");
        }
        productRepository.findById(productId);
        productRepository.deleteById(productId);
    }
}
