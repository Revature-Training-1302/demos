package com.revature.cartexample.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private double price;
    // how many items we have in stock: (ex: 100000)
    private int quantity;

    // prevent infinite recursion:
//    @ManyToMany(mappedBy = "products")
//    private Set<Cart> carts;

    // For one item, we could have many instances of that item in the cart
    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductCart> productCartList;



}
