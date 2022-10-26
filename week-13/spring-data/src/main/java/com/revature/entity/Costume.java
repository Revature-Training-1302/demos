package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// persistence, dealing with persisting data to a database
import javax.persistence.Entity;
import javax.persistence.Id;

// make this class an entity in our table:
@Entity
// Provide shortcuts for the setters/getters/constructors/etc
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costume {
    @Id
    private int id;
    private String name;
    private String color;
    private String franchise; // ex: Marvel, Star Wars
    private double cost;
}
