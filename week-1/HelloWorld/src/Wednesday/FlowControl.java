package Wednesday;

public class FlowControl {
    public static void main(String [] args) {
        // we have to be 60 inches or taller to ride the roller coaster
        int height = 70;
        int age = 20;
        int threshold = 60;

        // condition in ()
        // what happens based on that condition goes in {}
        if(height > threshold) {
            // notice the indendation, everything in this if-block is pushed a little more
            System.out.println("You can ride the roller coaster");
        }
        else if(age >= 18) {
            System.out.println("You're an adult, ride at your own risk.");
        }
        // if none of the conditions trigger, then the else statement will
        else {
            System.out.println("You cannot ride the roller coaster");
        }

        // imagine we don't have an else statement
        if(height > threshold) {
            System.out.println("You can ride.");
        }
        // if we can't do else, we have to take the opposite of the previous if-statement
        if (height <= threshold) {
            System.out.println("You can't ride.");
        }

        // we can us boolean operators to ensure 2 conditions are true before the code is executed
        if(age >= 18 && height > threshold) {
            System.out.println("You are perfectly safe");
        }

        // Let's say we want to count to 10 in our code:
        // why is this bad code?
        // DRY - Don't Repeat Yourself
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);
        System.out.println(10);

        int counter = 1;
        // while our counter is less than 11:
        while(counter < 11) {
            // loop body, this is what executes at every iteration
            // in this case, we print out counter at every step:
            System.out.println(counter);
            // update counter
            // we take the value of counter, add 1 to it, and assign it back to the variable counter:
            // counter = counter + 1;
            // counter += 1;
            // this is the shortest way to increment a variable, just keep in mind that it adds exactly 1
            counter ++;
        }


    }
}
