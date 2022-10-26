package com.revature.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

// declare that this class is going to be a table in the database
@Entity // does not make this a Spring bean
// Lombok annotations (not inherently part of Spring)
@Data // Getters, Setters, toString, hashCode
@NoArgsConstructor
@AllArgsConstructor
// customize the table that's generated:
@Table(name = "monsters")
//@Component
public class Monster {
    // declare this column as the primary key:
    @Id
    // declare this column as serial, create a sequence so we can count up for each insertion
    @GeneratedValue
    private Long id;
    @Column(name = "monster_name") // customize the name of the column:
    private String name;
    private String description;
}
