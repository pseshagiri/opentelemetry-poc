package com.seshagiri.ps.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import com.seshagiri.ps.entity.ProductEntity;
import com.seshagiri.ps.repo.ProductRepository;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks()
    ProductService productService;

    @Mock()
    ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        ProductEntity product = new ProductEntity(1, "Book", 
                    "This is a test product", 99.99);
         
         Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
         ProductEntity addedProduct = productService.createProduct(product);
         Assert.notNull(addedProduct, "Added product should not be null");
         Assert.isTrue(addedProduct.getId() == 1, "Product ID should be 1");
         Assert.isTrue(addedProduct.getName().equals("Book"), "Product name should be 'Book'");
         Assert.isTrue(addedProduct.getDescription().equals("This is a test product"), "Product description should be 'This is a test product'");
         Assert.isTrue(addedProduct.getPrice() == 99.99, "Product price should be 99.99");
    }

    @Test() 
    public void testCreateProductWithNullName() {
         ProductEntity product = new ProductEntity(1, null, "This is a test product", 99.99);
         try {
             productService.createProduct(product);
         } catch (RuntimeException e) {
             Assert.isTrue(e.getMessage().equals("Product name cannot be null or empty"), "Exception message should be 'Product name cannot be null or empty'");
         }
    }

     @Test() 
     public void testCreateProductWithEmptyName() {
          ProductEntity product = new ProductEntity(1, "   ", "This is a test product", 99.99);
          
          try {
              productService.createProduct(product);
          } catch (RuntimeException e) {
              Assert.isTrue(e.getMessage().equals("Product name cannot be null or empty"), "Exception message should be 'Product name cannot be null or empty'");
          }
     }
     @Test()
      public void testPrivateMethodValidateProduct()  throws NoSuchMethodException {
       // ProductEntity product = new ProductEntity(1, "Book", "This is a test product", 99.99);
       try{
         Method method = ProductService.class.getDeclaredMethod("validateProductName", 
            String.class);
            method.setAccessible(true);
            Boolean result = (Boolean)method.invoke(productService, "Book");
            assertTrue(result);
       }catch(Exception e){ 
         throw new RuntimeException("Failed to invoke private method validateProduct", e);
       }      
      }   
      
      @Test()
      public void testPrivateMethodValidateProduct_Exception(){

        try{
            Method method = ProductService.class.getDeclaredMethod("validateProductName",
             String.class);
             method.setAccessible(true);
             Boolean result = (Boolean)method.invoke(productService, "");
             assertFalse(result);
        }catch(Exception e){
            throw new RuntimeException("Product Name cannot be empty");
        }
      }

      @Test()
      public void testProductDelete(){
        ProductEntity product = new ProductEntity(1, "Book", 
                    "This is a test product", 99.99);        
        Mockito.doNothing().when(productRepository).deleteById(Mockito.any());
        productService.deleteProduct(product.getId());
        verify(productRepository,times(1)).deleteById(product.getId());           

      }
}
