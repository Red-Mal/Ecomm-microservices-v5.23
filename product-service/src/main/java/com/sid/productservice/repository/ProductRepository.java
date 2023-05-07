package com.sid.productservice.repository;

import com.sid.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    @Query("{'name': ?0}")
    Optional<Product> findByName(String name);
}