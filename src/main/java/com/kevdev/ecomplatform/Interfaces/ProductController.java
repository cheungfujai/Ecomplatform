package com.kevdev.ecomplatform.Interfaces;

import com.kevdev.ecomplatform.Domain.Product.Product;
import com.kevdev.ecomplatform.Domain.Product.ProductService;
import com.kevdev.ecomplatform.Interfaces.Dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Collection<Product> getProducts() throws Exception {
        try {
            return productService.getAllProducts();
        }
        catch (Exception e){
            throw new Exception("Cannot get products.");
        }
    }

    @PostMapping
    public ResponseEntity<Object> createProducts(@RequestBody Collection<ProductDto> productDto) throws Exception{
        try{
            productService.createNewProducts(productDto);
            return new ResponseEntity<>("Product created successfully.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Cannot create product with reason: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateProducts(@RequestBody Collection<Product> products) throws Exception{
        try{
            productService.updateProducts(products);
            return new ResponseEntity<>("Product updated successfully.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Cannot update product with reason: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteProducts(@RequestBody Collection<Product> products) throws Exception {
        try {
            productService.deleteProducts(products);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Cannot delete product with reason: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
