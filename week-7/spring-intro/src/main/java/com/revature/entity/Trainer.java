package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This will provide our no argument constructor:
@NoArgsConstructor
// this will provide our all--argument constructor:
@AllArgsConstructor
// This provides getters, setters, hash code, toString
@Data
public class Trainer {
    private String name;
    private Pokemon starter;
    private int num_badges;

    // might need an extra constructor for everything but id

}
