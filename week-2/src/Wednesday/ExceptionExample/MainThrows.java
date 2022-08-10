package Wednesday.ExceptionExample;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainThrows {
    public static void main(String[] args) throws FileNotFoundException {
        // If we don't wrap the exception in a try-catch block we can declare it up above with the "throws" keyword
        FileReader file2 = new FileReader("test.txt");
        // this will throw no matter what
        throw new FileNotFoundException();
    }
}
