package com.seshagiri.ps.controller;

import org.springframework.web.bind.annotation.*;

import com.seshagiri.ps.entity.ProductEntity;
import com.seshagiri.ps.service.ProductService;
import com.seshagiri.optl.OpenTelemetrySpan;
import org.slf4j.*;

@RestController()
@RequestMapping("/api/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    private final OpenTelemetrySpan openTelemetrySpan;



    public ProductController(ProductService productService,
                             OpenTelemetrySpan openTelemetrySpan){
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
        logger.info("Product Controller span: {}", this.openTelemetrySpan);
        return "Product created successfully";
      }

    @GetMapping()
    public String getProduct() {
        this.openTelemetrySpan.startSpan(ProductController.class.getName(),"createProduct",
                "POST","WEB");
        logger.info("Creating a new product: {}", "Hai");

        this.openTelemetrySpan.stopSpan();
        logger.info("Product Controller span: {}", this.openTelemetrySpan);
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
