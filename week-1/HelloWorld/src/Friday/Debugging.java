package Friday;

public class Debugging {
    public static void main(String[] args) {
        // dummy code to test out what goes wrong:
        int x = 5; // 5

        int y = 45;

        x *= 5; // 25

        x -= 10; // 15

        x += 50; // 65

        // we're expecting 75
        System.out.println(x);

        // we want to calculate the average of an array:
        int[] numbers = {45,77,32,57,86,23};
        int sum = 0;
        for(int i = 0; i < numbers.length; i ++) {
            // By looking at the code, we could recognize a mistake like this:
            sum *= numbers[i];
        }
        System.out.println(sum/(numbers.length));




    }
}
