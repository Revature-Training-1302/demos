package Friday;

public class DifferentScopes {
    public static void main(String[] args) {
        int x = 0;
        int j = 0;
        while(j < 10) {
            x = 0;
            for(int i = 0; i < 10; i ++) {
                // each time, we 10 to x
                x += 10;
            }

            System.out.println(x);
            j ++;
        }
    }
}
