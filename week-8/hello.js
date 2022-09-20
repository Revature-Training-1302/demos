// to run this, first
// tsc hello.ts
// node hello.js
console.log("Hello World");
var x = 4;
var str = "hello";
// Once we declare the variables as a certain type, we can't change that type later on:
// x = "string";
// str = 5.4;
// Declare an array of strings:
var names = ["john", "bob", "steve"];
console.log(names);
// this variable is of type person:
var p1 = {
    name_: "bob",
    age: 20,
    job: "programmer"
};
console.log(p1);
// if we declare a variable as any, we have no guarantee of its type:
var y = 3;
y = "hello";
y = {
    name: "rory"
};
// an array of objects
var people = [
    {
        name_: "bob",
        age: 20,
        job: "programmer"
    }, {
        name_: "bob",
        age: 20,
        job: "programmer"
    }, {
        name_: "bob",
        age: 20,
        job: "programmer"
    }
];
