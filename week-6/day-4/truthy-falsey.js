var x = 0;

// we can use x as a boolean here:
if(x) {
    console.log('true');
}
else {
    console.log('false');
}

// empty objects are truthy
var object =  {}
if(object) {
    console.log('true');
}
else {
    console.log('false');
}

// assume we got this from some API request:
var username = undefined;
if(username) {
    console.log(`Hello ${username}`);
}
else {
    console.log("Something was wrong with your password");
}