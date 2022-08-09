package Tuesday.Polymorphism;

public class Main {
    public static void main(String[] args) {
        int x = Calculator.add(3,4);
        System.out.println(x);
        // changing the number of parameters, but keeping the same method name:
        int y = Calculator.add(3,4,5);
        System.out.println(y);
        // change the type, but keep the same name
        double z = Calculator.add(4.5, 2.6);
        System.out.println(z);

        // change the order of types and it's still 2 different methods
        double a = Calculator.add(3.6, 4);
        double b = Calculator.add(4, 9.6);
        System.out.println(a);
        System.out.println(b);

        // because we pass in an array, we get that specified functionality
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int sum = Calculator.add(numbers);
        System.out.println(sum);
    }
}
