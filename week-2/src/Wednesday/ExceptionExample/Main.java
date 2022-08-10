package Wednesday.ExceptionExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        // example of an unchecked exception (Arithmetic exception)
        try {
            int x = 5/1;
        } catch(ArithmeticException e) {
            // custom output
            System.err.println("Divide by 0 error!");
            // this will take the exception that we caught and print out the relevant stack information:
            e.printStackTrace();
        } finally {
            System.out.println("This will print no matter what");
        }

        // IO Exception
        // reading data from an external file:
        // We can't even run the program before we either catch or throw this exception:
        // In this try-block, we put in the problematic code
        try {
            // this file might not exist, therefore we might get an IOException
            FileReader file = new FileReader("test.txt");
        } catch(Exception exception) {
            // this is what happens when the exception occurs
            System.err.println("Text file doesn't exist. Generating sample text...");
            String text = "sample";
        }


        try {
            FileReader file2 = new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            // throw is the action of causing an exception to happen:
            throw new RuntimeException(e);
        }


        System.out.println("Made it to the end of the program");


    }
}
