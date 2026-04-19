package com.seshagiri.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.seshagiri.ps.entity.ProductEntity;
import com.seshagiri.ps.service.ProductService;
import org.slf4j.*;

@RestController()
@RequestMapping("/api/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public String createProduct(@RequestBody ProductEntity product) {
        logger.info("Creating a new product: {}", product);
        productService.createProduct(product);
        return "Product created successfully";
      }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestBody ProductEntity product) {
        logger.info("Deleting Existing product: {}", product);
        productService.deleteProduct(product.getId());
        return "Product deleted successfully";
      }
    

}
