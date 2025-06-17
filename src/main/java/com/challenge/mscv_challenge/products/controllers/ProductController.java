package com.challenge.mscv_challenge.products.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.challenge.mscv_challenge.products.entities.Product;
import com.challenge.mscv_challenge.products.services.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>>list() {

       return ResponseEntity.ok(this.productService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> detail (@PathVariable Long id) {
        Optional<Product> producOptional = productService.findById(id);
        if (producOptional.isPresent()) {
            return ResponseEntity.ok(producOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    

}
