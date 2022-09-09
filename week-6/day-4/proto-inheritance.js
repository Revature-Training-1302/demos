let animal = {
    eats: true,
    walk() {
        console.log("Animal walk");
    }
};

let rabbit = {
    jumps: true,
    __proto__: animal // similar to using the extends keyword
}

// animal can eat:
console.log(animal.eats);
// rabbit can jump:
console.log(rabbit.jumps);
console.log(rabbit.eats);
// rabbit can inherit the functionality from the animal:
rabbit.walk();