package com.revature.cartexample.service;

import com.revature.cartexample.data.ProductRepository;
import com.revature.cartexample.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void add(Product product) {
        productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }


}
