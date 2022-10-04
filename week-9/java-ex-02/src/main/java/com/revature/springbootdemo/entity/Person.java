package com.revature.springbootdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@Entity
// change the name of the table:
//@Table(name = "new table name")
public class Person {
    // this is letting the db know that this field is our primary key:
    @Id
    // this lets us serialize the id:
    @GeneratedValue
    private Long id;
    // set this column to be unique and set the name of the column to be person_name
    @Column(unique = true, nullable = false)
    private String name;
    private String password;

    @OneToMany(targetEntity = Pet.class, cascade = CascadeType.ALL)
    // set up the column in the pet table
    @JoinColumn(name = "person_fk", referencedColumnName = "id")
    List<Pet> adoptedPets;

    public Person() {
        // initialize our adopted pets to be an empty array list:
        adoptedPets = new ArrayList<>();
    }

    public void adopt(Pet pet) {
        adoptedPets.add(pet);
    }



}
