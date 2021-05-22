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
    public Collection<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Object> createProducts(@RequestBody ProductDto productDto) throws Exception{
        try{
            productService.createNewProducts(productDto);
            return new ResponseEntity<>("Product created successfully.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Cannot created product with reason: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
