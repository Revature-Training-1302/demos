var numbers = [1,2,3,4];
numbers.push(5);
console.log(numbers.length);

var unordered = [5,45,7214,354354,321342,357,3,4647,235,6775];
// kind of like setting up a compareTo method like in Java
unordered.sort( (val1, val2) => val1 - val2  );
console.log(unordered);

var people = [
    {
        name: 'bob',
        age: 40
    },
    {
        name: 'alex',
        age: 56
    },
    {
        name: 'steve',
        age: 32
    },
    {
        name: 'john',
        age: 15
    }
]

// sort by age
people.sort((val1, val2) => val1.age - val2.age);
console.log(people);
// sort by name:
people.sort((person1, person2) => {
    // specifying the ordering based on the person's name
    if(person1.name > person2.name) return 1;
    else if (person2.name > person1.name) return -1;
    else return 0;
});
console.log(people);

// filter and only keep people whose ages are greater than 35
let older_people = people.filter((person) => person.age > 35);
console.log(older_people);

// for each person in the people array, increment the age by 1:
people.map((person => {person.age += 1}));
console.log(people);

for(let i = 0; i < people.length; i ++){
    console.log(people[i]);
}
console.log("\n\n");
// for of loop:
for(const person of people) {
    console.log(person);
}

// spread operator:
let first = ['a','b','c','d','e','f','g','h','i'];
let second = ['j','k','l','m','n','o','p'];
// the long way of combining the way:
// let combined = [];
// for(const letter of first) {
//     combined.push(letter);
// }
// for(const letter of second) {
//     combined.push(letter);
// }
// console.log(combined);

// taking the elements of the first array and "spreading them out" so they will be entries in the combined array
// doing the same thing with the second array
let combined = [...first, ...second];
console.log(combined);


// rest operator, allows us to pass in any number of parameters
function sumNumbers(param1, ...numbers) {
    console.log(param1);
    let sum = 0;
    // we use constants for for of loops so we don't change the array that we're referencing:
    for(const number of numbers) {
        sum += number;
    }
    return sum;
}

// because we are using the rest operator, we pass in the numbers as arguments rather than the array itself
let sum = sumNumbers(1,2,3,4,5,6,7);
console.log(sum);