package com.revature.springbootdemo.dto;

import com.revature.springbootdemo.entity.Person;
import com.revature.springbootdemo.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// DTO - Data Transfer Object
// Used when we want to package together multiple classes/fields into one request body
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetPerson {
    Pet pet;
    Person person;
}
