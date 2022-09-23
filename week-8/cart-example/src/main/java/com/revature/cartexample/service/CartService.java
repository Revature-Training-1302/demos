package com.revature.cartexample.service;

import com.revature.cartexample.data.CartRepository;
import com.revature.cartexample.entity.Cart;
import com.revature.cartexample.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    public void add(Cart cart) {
        cartRepository.save(cart);
    }

    public Cart getById(Long id) {
        return cartRepository.findById(id).get();
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public void addToCart(Long productId, Long cartId, int quantity) {
        Cart cart = getById(cartId);
        Product product = productService.getById(productId);
        cart.getProducts().add(product);
        cartRepository.save(cart);
    }

    public Set<Product> getProductsInCart(Long id) {
        return getById(id).getProducts();
    }
}
