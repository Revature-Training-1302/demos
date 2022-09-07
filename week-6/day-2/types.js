var x = 4;
var y = '4';

// what is the expected output here:
console.log(x == y); // == ignores type, it just checks the value, type coercion
console.log(x === y); // check type as well, this should return false

console.log('cat' === 'cat');




var person1 = {
    name: "rory",
    cat: "ashes"
}

var person2 = {
    name: "rory",
    cat: "ashes"
}

// even though same values, return false for these:
console.log(person1 == person2);
console.log(person1 === person2);

var equal = true;
// check if 2 objects are equal:
for(var key in person1){
    if(person1[key] != person2[key]) {
        equal = false;
    }
}

console.log(equal);