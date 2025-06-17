package com.challenge.mscv_challenge.products.services;

import java.util.List;
import java.util.Optional;

import com.challenge.mscv_challenge.products.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    

}
