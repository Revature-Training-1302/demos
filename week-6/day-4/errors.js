var object = null;

// in our try block, we try out some potentially dangerous code
try {
    console.log(object.name);
    // in our catch block, we define what happens if we encounter the error:
} catch (error) {
    console.log("Object is not defined");
}

console.error("This is an error message");