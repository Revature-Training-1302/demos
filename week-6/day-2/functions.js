function greet(name = "Jim") {
    console.log("Hello, " + name);
}

// if we pass in a value, the function will use that value
greet("Zabeer");
// otherwise, it will use the default parameter:
greet();

// arrow functions
(x) => {
    console.log(x);
    return x * x;
}

// if we don't include curly braces, assume that we just return the expression
(x) => x*x;

// anonymous functions, store arrow functions in a variable:
var square = (x) => x * x;

// to call the function, we call the variable in which we stored that arrow function (anonymous function)
console.log(square(4));
console.log(square(9));
console.log(square(13));

// self-invoking functions, functions that are executed right after they are defined
(function (x) {
    console.log(x);
    console.log("Hello");
}) (45);

// call-back functions:
var cube = (x) => x * x * x;

// this function takes in a function and a value, applies that function to that value
// and returns the result
function calculateAndPrint(func, value) {
    let result = func(value);
    console.log(result);
}

calculateAndPrint(square, 10);
calculateAndPrint(cube, 5);

// Closures:
function greeting() {
    // define a variable in the outer function
    let x = "Hello";
    function sayHi() {
        // using the variable in the inner function
        console.log(x);
    }
    // return the function from the outer function
    return sayHi;
}

// taking the return value of the greeting function and storing it in a variable
// this is a closure, it still has access to the variable that was defined in "greeting"
let func1 = greeting();
func1();

// pass by value:
function increment(x) {
    x += 1;
}

let number = 5;
increment(number);
// even though we incremented the variable within the function, we passed by value rather than by reference so this variable is not changed
console.log(number);

function incrementAge(person) {
    person.age ++;
}

let person3 = {
    name: "Bob",
    age: 30
}

// here, we pass in the reference of the object (still passing by value) so the object will be affected
incrementAge(person3);
// so, this object will have age 31:
console.log(person3);

