package com.challenge.mscv_challenge.products.repositories;

import org.springframework.data.repository.CrudRepository;

import com.challenge.mscv_challenge.products.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{

}
