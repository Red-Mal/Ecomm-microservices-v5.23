package com.sid.productservice.controller;

import com.sid.productservice.dto.ProductRequest;
import com.sid.productservice.dto.ProductResponse;
import com.sid.productservice.model.Product;
import com.sid.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Create product.
     *
     * @param productRequest the product request
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    /**
     * Gets all products.
     *
     * @return the all products
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Get product by name response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @GetMapping("/{name}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductByName(name));

    }

    /**
     * Update product response entity.
     *
     * @param product the product
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }


    /**
     * Delete product response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(String id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}