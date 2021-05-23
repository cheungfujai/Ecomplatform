package com.kevdev.ecomplatform.Domain.Product;

import com.kevdev.ecomplatform.Interfaces.Dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final MaintypeRepository maintypeRepository;

    private ProductService(
            ProductRepository productRepository,
            MaintypeRepository maintypeRepository) {
        this.maintypeRepository = maintypeRepository;
        this.productRepository = productRepository;
    }

    public Collection<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Collection<Product> createNewProducts(Collection<ProductDto> productDtos) throws Exception {
        try {
            Collection<Product> newProducts = transferProduct(productDtos);
            productRepository.saveAll(newProducts);
            return newProducts;
        }
        catch(Exception e){
            throw new Exception("Cannot create product with error: " + e);
        }
    }

    public Collection<Product> transferProduct(Collection<ProductDto> productDtos){
        return productDtos.stream()
                .filter(pDto -> productRepository.findProductsByProductName(pDto.getProductName()) == null)
                .map(pDto -> new Product(
                        pDto.getProductName(),
                        pDto.getProductPrice(),
                        pDto.getProductWeight(),
                        true
                ))
                .collect(Collectors.toList());
    }

    public void updateProducts(Collection<Product> products) throws Exception {
        try{
            products.stream()
                    .map(p -> {
                p.setUpdateAt(LocalDateTime.now());
                return p;
            }).collect(Collectors.toList());
            productRepository.saveAll(products);
        }
        catch (Exception e){
            throw new Exception("Cannot update products.");
        }
    }

    public void deleteProducts(Collection<Product> products){
        products.stream()
                .forEach(p -> {
                    productRepository.delete(p);
                });
        return;
    }

    public void createProductMainType(Maintype productMaintype){
        try{
            maintypeRepository.save(productMaintype);
        }
        catch(Exception e){
            throw e;
        }
    }

    public void updateProductMainType(){

    }

    public void deleteProductMainType(){

    }

}
