package com.revature.cartexample.controller;

import com.revature.cartexample.entity.Cart;
import com.revature.cartexample.entity.Product;
import com.revature.cartexample.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

// make this controller a bean (managed by Spring IOC container)
@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping
    public Cart add(@RequestBody Cart cart) {
        cartService.add(cart);
        return cart;
    }

    @GetMapping("/{id}")
    public Cart getById(@PathVariable("id") Long id) {
        return cartService.getById(id);
    }

    @GetMapping()
    public List<Cart> getAll() {
        return cartService.getAll();
    }

//    @PatchMapping()
//    public void addToCart() {
//        cartService.addToCart(2l, 1l, 100);
//    }
//
//    @GetMapping("/{id}/products")
//    public Set<Product> getProductsInCart(@PathVariable("id") Long id) {
//        return cartService.getProductsInCart(id);
//
//    }

}
