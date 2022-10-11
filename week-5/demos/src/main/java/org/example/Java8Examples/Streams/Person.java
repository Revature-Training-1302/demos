package org.example.Java8Examples.Streams;

import java.util.Objects;

// implement the Comparable interface so we can define what makes one Person
// "less than" or "greater than" another person
// Right-click + Generate Methods
public class Person implements Comparable<Person>{
    // Here, not using Encapsulation just for the demo
    String name;
    String house;

    public Person(String name, String house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", house='" + house + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(house, person.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, house);
    }

    @Override
    public int compareTo(Person other) {
        // return the comparison of the names
        // now if we sort a collection of Person objects, it would sort by the name:
        return this.name.compareTo(other.name);
    }
}
