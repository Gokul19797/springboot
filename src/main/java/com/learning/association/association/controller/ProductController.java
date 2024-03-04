package com.learning.association.association.controller;


import com.learning.association.association.model.Product;
import com.learning.association.association.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;


    @PostMapping("addProduct")
    public Product addProduct(@RequestBody Product product){

      Product product1=  productRepository.save(product);

      return product1;

    }
}
