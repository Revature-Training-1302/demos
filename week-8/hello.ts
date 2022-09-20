// to run this, first
// tsc hello.ts
// node hello.js
console.log("Hello World");

let x:Number = 4;

let str:String = "hello";

// Once we declare the variables as a certain type, we can't change that type later on:
// x = "string";
// str = 5.4;

// Declare an array of strings:
let names:String[] = ["john", "bob", "steve"];
console.log(names);

// Can't add a different type to the string array:
// names.push(1);


// declare an interface so we can assign types to custom objects:
interface PersonI {
    // make this id field optional using the question mark
    id?: Number,
    name_: String,
    age: Number,
    job: String
}


// this variable is of type person:
let p1:PersonI = {
    name_: "bob",
    age: 20,
    job: "programmer"
}

console.log(p1);

// if we declare a variable as any, we have no guarantee of its type:
let y:any = 3;
y = "hello";
y = {
    name: "rory"
}
// can reassign to empty object or an array
y = {};
y = [];

// an array of objects
let people: PersonI[] = [
    {
        name_: "bob",
        age: 20,
        job: "programmer"
    },{
        name_: "bob",
        age: 20,
        job: "programmer"
    },{
        name_: "bob",
        age: 20,
        job: "programmer"
    }
]

// let's say we forgot what x is, in VS code, we can hover over the variable and see what type we declare it as:
console.log(x);

let z:String[] = [];
// can't redeclare an array as an empty object because, even though it is an object, it has properties like length, pop, push, etc.
// z = {};



interface Slime {
    Hp: Number,
    Color: String
}

let Chu:Slime = {
    Hp: 20,
    Color: 'Green'
}

let Den:Slime[] = [
    {
        /*
        {{
            Hp: 20,
            Color: 'Green'
        }}
        */
       // Using the spread operator to "spread out" the fields instead of having the double-nested object
        ...Chu
    },{
        Hp: 30,
        Color: 'Gold'
    }
]
