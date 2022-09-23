package com.revature.cartexample.controller;

import com.revature.cartexample.entity.Product;
import com.revature.cartexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Product add(@RequestBody Product product) {
        productService.add(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }


}
