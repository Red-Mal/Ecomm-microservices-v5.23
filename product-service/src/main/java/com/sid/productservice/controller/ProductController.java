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

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductByName(name));

    }
    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(String id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}