package com.seshagiri.ps.util;

import com.seshagiri.ps.entity.ProductEntity;
import com.seshagiri.ps.pojo.Product;

public class ProductUtil {

    public static ProductEntity toEntity(Product product) {
        //ProductEntity entity = new ProductEntity();
        //entity.setId(product.getId());
        //entity.setName(product.getName());
        //entity.setDescription(product.getDescription());
        //entity.setPrice(product.getPrice());
        //return entity;
        return new ProductEntity(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public static Product toPojo(ProductEntity entity) {
        //Product product = new Product();
        //product.setId(entity.getId());
        //product.setName(entity.getName());
        //product.setDescription(entity.getDescription());
        //product.setPrice(entity.getPrice());
        //return product;
        return new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
    }

    public static boolean validateProductName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("Product name cannot be null or empty");
        }else{
            return true;
        }        
    }

}
