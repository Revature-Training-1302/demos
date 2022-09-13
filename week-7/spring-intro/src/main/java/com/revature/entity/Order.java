package com.revature.entity;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
/*
the Order class contains an id as well as
1. an instance of Account class
2. an instance of Item class
These 2 classes are dependencies because the Order class depends on them
We also know that these fields probably need valid values/data in order to function properly. So the Autowiring tells Spring
inject values into these fields based on what configuration we provide (xml file)
 */


@ToString
public class Order {
    @Value("1")
    private int id;
    private Account buyer;

    // Autowire the field directly
    @Autowired
    private Item item;

    public Item getItem() {
        return this.item;
    }

    // If we have both setters and constructor, default to setters:
    // Autowire the setter:
    @Autowired
    // specifying that if we use the setter, we take the bean with name "ron"
    public void setBuyer(@Qualifier("account1") Account buyer) {
        this.buyer = buyer;
    }

    public Account getBuyer() {
        return this.buyer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    // if we're missing a setter, we will use the constructor:
    @Autowired
    // if we use the constructor, we'll use the bean with name "harry"
    public Order(@Qualifier("account2") Account buyer, Item item) {
        this.buyer = buyer;
        this.item = item;
    }

    public Order() {

    }


}
