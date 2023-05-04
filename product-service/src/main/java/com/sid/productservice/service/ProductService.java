package com.sid.productservice.service;

import com.sid.productservice.dto.ProductRequest;
import com.sid.productservice.dto.ProductResponse;
import com.sid.productservice.model.Product;
import com.sid.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Product service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Create product.
     *
     * @param productRequest the product request
     */
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    /**
     * Gets all products.
     *
     * @return the all products
     */
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    /**
     * Get product by name product response.
     *
     * @param name the name
     * @return the product response
     */
    public ProductResponse getProductByName(String name){
       return mapToProductResponse( productRepository.findByName(name).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Product By Name %s",name)
        ))
       );
    }

    /**
     * Update product.
     *
     * @param product the product
     */
//to Modify
    public void updateProduct(Product product){
        Product savedProduct=productRepository.findById(product.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find Product B Id %s",product.getId())
                ));
       productRepository.save(savedProduct);
    }

    /**
     * Delete product.
     *
     * @param id the id
     */
//to Modify
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }


    //to Modify (Use mapStruct)
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
