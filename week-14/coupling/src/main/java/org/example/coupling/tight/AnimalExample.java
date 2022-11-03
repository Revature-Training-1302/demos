package org.example.coupling.tight;

public class AnimalExample {
    public static void main(String[] args) {
        // Tightly coupled
        // Imagine trying to change this to work with a cat
        // Ideally, we wouldn't want to have to change the pet class
        Pet pet = new Pet(new Cat());
        pet.speak();

    }

}

class Pet {
    // tight coupling because we're directly including a dog field
    Cat cat;
    // constructor that takes in a dog
    public Pet(Cat cat) {
        this.cat = cat;
    }

    public void speak() {
        cat.meow();
    }
}

class Dog {
    public void bark() {
        System.out.println("Bark!");
    }
}

class Cat {
    public void meow() {
        System.out.println("Meow!");
    }
}

