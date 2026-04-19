package com.seshagiri.ps.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seshagiri.ps.entity.ProductEntity;
import com.seshagiri.ps.repo.ProductRepository;


@Service
public class ProductService {

    Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public ProductEntity createProduct(ProductEntity product) {
        logger.info("Creating a new product");
        //ProductEntity entity = ProductUtil.toEntity(product);
        if(validateProductName(product.getName())){
                logger.info("Product validation successful");   
                productRepository.save(product);
                logger.info("Product created successfully");                
           }
        return product; 
    }

    private Boolean validateProductName(String name) {  
        return name != null && !name.trim().isEmpty();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteProduct(Integer id){
        logger.info("Product Deleted Initiated ... ");       
        productRepository.deleteById(id);
        logger.info("Product Deleted Successfully ... ");

    }


}
