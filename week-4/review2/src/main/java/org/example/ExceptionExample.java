package org.example;

import java.sql.SQLException;

public class ExceptionExample {

    public static void main(String[] args) throws Exception {


        try {
            System.out.println("hello");
        }
        finally {
            System.out.println("World");
        }
        String [] names = {"Rory", "Abiy", "Zabeer"};
        try {
//            System.out.println(names[20]);
            // because this method throws a ClassNotFound exception, we have to include a Class not Found Exception
            // in one of the catch blocks:
            Class.forName("dummyclass");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Array index too big.");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        finally {
            System.out.println("This will happen no matter what");

        }

        // action of throwing the exception:
        throw new Exception("Made it to the end");

        // This code will only execute if we make it to the end of the program
        // System.out.println("This code is outside");
    }
}
