package com.seshagiri.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.seshagiri.ps.entity.ProductEntity;
import com.seshagiri.ps.service.ProductService;
import com.seshagiri.optl.OpenTelemetrySpan;
import org.slf4j.*;

@RestController()
@RequestMapping("/api/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);


    private ProductService productService;
    private OpenTelemetrySpan openTelemetrySpan;

    public ProductController(ProductService productService, OpenTelemetrySpan openTelemetrySpan){
        this.productService = productService;
        this.openTelemetrySpan = openTelemetrySpan;
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody ProductEntity product) {
        this.openTelemetrySpan.startSpan(ProductController.class.getName(),"createProduct",
                "POST","WEB");
        logger.info("Creating a new product: {}", product);
        productService.createProduct(product);
        this.openTelemetrySpan.stopSpan();
        return "Product created successfully";
      }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestBody ProductEntity product) {
        this.openTelemetrySpan.startSpan(ProductController.class.getName(),"createProduct",
                "DELETE","WEB");
        logger.info("Deleting Existing product: {}", product);
        productService.deleteProduct(product.getId());
        this.openTelemetrySpan.stopSpan();
        return "Product deleted successfully";
      }
    

}
