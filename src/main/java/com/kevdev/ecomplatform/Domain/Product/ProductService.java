package com.kevdev.ecomplatform.Domain.Product;

import com.kevdev.ecomplatform.Interfaces.Dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final MaintypeRepository maintypeRepository;

    @Autowired
    private final SubtypeRepository subtypeRepository;

    private ProductService(
            ProductRepository productRepository,
            MaintypeRepository maintypeRepository,
            SubtypeRepository subtypeRepository) {
        this.maintypeRepository = maintypeRepository;
        this.productRepository = productRepository;
        this.subtypeRepository = subtypeRepository;
    }

    public Collection<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createNewProducts(ProductDto productDto) throws Exception {
        String mainType = productDto.getMainType();
        String subType = productDto.getSubType();

        try {
            if(productRepository.findProductsByProductName(productDto.getProductName()) != null){
                throw new Exception("Product already exists.");
            }
            Product newProduct = new Product(
                    productDto.getProductName(),
                    productDto.getProductPrice(),
                    productDto.getProductWeight(),
                    new Maintype(mainType),
                    new Subtype(subType),
                    true);
            productRepository.save(newProduct);
            return newProduct;
        }
        catch(Exception e){
            throw new Exception("Cannot create product with error: " + e);
        }
    }

    public void updateProducts(){

    }

    public void deleteProducts(){

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

    public void createProductSubType(Subtype productSubtype){
        try {
            subtypeRepository.save(productSubtype);
        }
        catch(Exception e){
            throw e;
        }
    }

    public void updateProductSubType(){

    }

    public void deleteProductSubType(){

    }

}
