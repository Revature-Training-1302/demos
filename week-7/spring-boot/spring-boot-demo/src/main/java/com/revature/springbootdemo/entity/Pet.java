package com.revature.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
// @Data gives us Getters/Setters, ToString, hashCode, Equals
@Data
// The @Entity annotation indicates that this class should be persisted to a database
// There will be a pet table in the database:
@Entity
public class Pet {
    // the @Id annotation tells us that this field will be the primary key
    // Serial id using the @GeneratedValue (Auto count up)
    // Changing the strategy type: https://docs.oracle.com/javaee/6/api/javax/persistence/GenerationType.html
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    private String food;
}
