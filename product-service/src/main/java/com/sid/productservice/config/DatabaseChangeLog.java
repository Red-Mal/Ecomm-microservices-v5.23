package com.sid.productservice.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.sid.productservice.model.Product;
import com.sid.productservice.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001",id = "seedDatabase",author = "Red")
    public void seedDatabase(ProductRepository productRepository){
        List<Product> productList=new ArrayList<>();
        productList.add(createNewProduct("MacBook Pro","MacBook 2023",BigDecimal.valueOf(20000)));
        productList.add(createNewProduct("MacBook Air","MacBook 2023",BigDecimal.valueOf(20000)));
        productList.add(createNewProduct("Ipad Pro","MacBook 2023",BigDecimal.valueOf(20000)));
        productList.add(createNewProduct("Ipad Air","MacBook 2023",BigDecimal.valueOf(20000)));
        productRepository.insert(productList);
    }

    private Product createNewProduct(String name ,String description,BigDecimal price){
        Product product=new Product();
        product.setDescription(description);
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
