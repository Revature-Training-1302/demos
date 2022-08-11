package Wednesday.ExceptionExample;

// When we make our exception class, we extend exception
public class DogException extends Exception{

    // when we create an exception, we give a message, ad pass it to the super-class
    // in this case, the Exception class
    public DogException(String message) {
        // calling the super-constructor:
        super(message);
    }
}
