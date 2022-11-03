package org.example.coupling.loose;

public class AnimalExample {
    public static void main(String[] args) {
        Pet pet = new Pet(new Dog());
        pet.display();
        pet = new Pet(new Cat());
        pet.display();
    }
}

class Pet {
    // we have a field of this class that is of type Animal
    // the instance of the animal could be a cat, dog, etc.
    Animal animal;
//    Owner owner;

    Pet(Animal animal) {
        this.animal = animal;
    }

    void display() {
        this.animal.speak();
    }

}

interface Animal {
    public void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Bark!");
    }

}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

