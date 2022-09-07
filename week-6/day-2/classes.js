class Animal {
    constructor(name, legs) {
        // this keyword means that we're referring to the object that called this method rather than any other object
        this.name = name;
        this.legs = legs;
    }

    speak() {
        console.log("This animal is speaking.");
    }
}

class Cat extends Animal {
    constructor(name) {
        // assume that cats have 4 legs
        super(name, 4);
    }

    speak() {
        console.log("Meow");
    }
}


class Person {
    static legs = 2;
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // computed property, take in 2 or more fields and combine them into one property to access
    get ['fullName']() {
        return this.getFullName();
    }

    // use a function to return computer property
    getFullName() {
        return this.firstName + ' ' + this.lastName;
    }


}

let animal = new Animal('Ashes', 4);
animal.speak();

let cat = new Cat('Ashes');
cat.speak();

let person = new Person('Abe', 'Lincoln');
console.log(person.firstName);
console.log(person.lastName);
// access this computer property:
console.log(person.fullName);

// accessing static variables through the class:
console.log(Person.legs);
