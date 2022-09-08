// take in an executor function that determines if we should resolve or reject the process
let promise1 = new Promise(function(resolve, reject) {
    var success = false;
    if(success) {
        resolve ('The process succeeded');
    }
    else {
        reject('The process failed');
    }
})

// now that the promise is defined, we use the .then method to indicate what happens upon success
promise1
// passing in a callback function that specifies how we resolve
.then((message) => {console.log(message)})
// passing in a callback function that specifies how we reject
.catch((message) => {console.error(message)});