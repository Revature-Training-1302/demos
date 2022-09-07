// because x isn't defined in a function, or block, or anything else, it is global
var x = 5;
// still globals even if we use let and const
let y = 6;
const z = 7;

function print(message) {
    console.log(message);
    // this variable is only accessible from this function
    var y = 6;
    console.log(y);
}

// because y was defined in the function, we can't access it outside of the function
// console.log(y);

// block scope:
for(var i = 0; i < 10; i ++) {
   let j = 0;
   const k = 0;
   // can't reassign a value to a constant variable:
//    k = 3;
}

// try to access the variable i outside of the block scope in which it was defined:
console.log(i); // if we define a variable with "var" keyword, we can access it from outside of the block scope
// console.log(j);
// console.log(k);

// define a outside of the function but use it inside of the function
var a = 3;
function test() {
    var b = 4;
    // lexical scope, first look for a value for a in the current scope, if not then search outwards
    var a = 5;
    console.log(a);
    console.log(b);


}

test();

// can't create a const variable without assigning it a value:
// const y;

