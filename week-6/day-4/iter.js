let a = [1,2,3];
// accessing the iterator property of a
// symbols as well as strings can be used to access properties
// symbols are guaranteed to be unique
// return the iterator from the a array:
// when we pass in the symbol into the brackets, we're going to return the iterator to that object (array)
let iter = a[Symbol.iterator]()
console.log(iter.next());
console.log(iter.next());
console.log(iter.next());
console.log(iter.next());

// we can use strings to access property names
var person = {name: 'rory'};
console.log(person['name']);

let b = [5,7,9,34,656,13];
let iter2 = b[Symbol.iterator]();
while(true) {
    // get the next element in the array:
    var current = iter2.next();
    // check if done is false:
    if(current.done === false){
        // if we're not done, print out the value
        console.log(current.value);
    // otherwise, exit the loop:
    }else {
        break;
    }
}

'2' == 2;


console.log("Generator =>");

// Generator:
// first we can define a function 
let square = x => x*x;


// make a generator function that yields values
// the * makes this function a generator
function* makeSquareGenerator(upper_limit) {
    // define the behavior of what output we generate
    for (let i = 0; i < upper_limit; i++) {
        // this yield indicates that this is the value that we return from the generator:
        yield square(i)
    }
    return;
}
// we create an iterator from the generator
let squareIter = makeSquareGenerator(100);
// call the iterator next value
let result = squareIter.next();
while(result.value < 100000) {
    console.log(result.value);
    result = squareIter.next();
}

// Iterable objects, let us use for of loop:
const squareIterable = {
    // implement the iterator method:
    *[Symbol.iterator]() {
        // define the behavior of what we want to return
        for (let i = 0; i < 9; i++) {
            yield square(i);
        }
        return;
    }
}
// Because we implemented the iterator method, we can use the for-of syntax rather than the 
//.next syntax
// when we iterate through this iterable, we're taking the values from the iterator method that we defined
for (let value of squareIterable) {
    console.log(value);
}

