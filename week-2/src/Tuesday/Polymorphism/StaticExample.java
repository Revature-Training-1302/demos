package Tuesday.Polymorphism;

public class StaticExample {

    // Main method is static because it is basically just responsible for running through the code that we write
    // It doesn't care about any member variables
    public static void main(String[] args) {
        // to use a non-static method, we need an instance of the class (object)
        Calculator calculator = new Calculator();
        int result = calculator.add(20,30);

        // we can use static method from a non-static context
        int result2 = calculator.multiply(10,20);
        // with static methods, we can use the class (capital Calculator), without having to create an instance of the object
        result2 = Calculator.multiply(10,20);
        System.out.println(result2);

        // non-static add method cannot be called from the non-static context (Class)
         int result3 = Calculator.add(2,4);

        // even if we change a static variable from an instance, it will affect the entire class
        calculator.name = "new name";

        System.out.println(Calculator.name);

        Calculator calc1 = new Calculator();
        Calculator calc2 = new Calculator();
        // calc1 changes the value of pi:
        // calc1.pi = 6;
        // because it is static, the value of pi changes for all instances and the class itself
        System.out.println(calc1.pi);
        System.out.println(calc2.pi);
        System.out.println(Calculator.pi);


    }
}
