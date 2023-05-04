package com.sid.productservice.repository;

import com.sid.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'name': ?0}")
    Optional<Product> findByName(String name);
}