let string = `{"name": "rory", "state": "VA"}`;
// convert from string to JSON
let object = JSON.parse(string);
console.log(object);
// convert from JSON to string
let string2 = JSON.stringify(object);
console.log(string2);