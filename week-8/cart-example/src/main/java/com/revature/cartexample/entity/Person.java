package com.revature.cartexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;

    @OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL)
    private Cart current;

    @OneToMany(targetEntity = Cart.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
//    @OneToMany
    private List<Cart> previous;
}
