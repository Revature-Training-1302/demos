package Wednesday.ExceptionExample;

import java.io.FileReader;
import java.io.IOException;

public class Inner {
    public static void main(String[] args) throws IOException {
        // because we said that doSomething could potentially throw an exception, we have to declare that in this method
       doSomething();

        // doSomething2 catches the exception so we don't have to specify it within this method
        doSomething2();

    }

    // if we declare this method with the throws clause, we have to declare the same thing in another method that we call it from
    public static void doSomething() throws IOException  {

    }

    public static void doSomething2() {
        try {
            // this file might not exist, therefore we might get an IOException
            FileReader file = new FileReader("test.txt");
        } catch(Exception exception) {
            // this is what happens when the exception occurs
            System.err.println("Text file doesn't exist. Generating sample text...");
            String text = "sample";
        }
    }
}
