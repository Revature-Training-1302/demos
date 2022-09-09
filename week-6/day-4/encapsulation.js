const Book = function(t,a) {
    // can't use access modifiers:
    let title = t;
    let author = a;

    return {
        // here we use a closure to return a summary of the book, it still has access to the values from 
        summary: function() {
            console.log(`${title} by ${author}.`)
        }
    }
}

const book1 = new Book('Harry Potter', 'JK Rowling');
// can't change the inner representation of the book:
book1.title = 'changed title';
// when we call the summary method, we still get the original values:
book1.summary();