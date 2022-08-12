package Thursday;

public class FindMax {
    public static void main(String[] args) {
        int [] grades = {45,67,12,34,56,78,100,23,99};

        // find the maximum:
        int max = 0;

        for(int i = 0; i < grades.length; i ++) {
            if(grades[i] > max) {
                System.out.println("New maximum found: " + grades[i]);
                // update this maximum variable that we're keeping track of:
                max = grades[i];
            }
        }
        System.out.println(max);

        // initialize the minimum to be the maximum
        int min = max;
        for(int i = 0; i < grades.length; i ++) {
            if(grades[i] < min) {
                System.out.println("New minimum found: " + grades[i]);
                min = grades[i];
            }
        }
        System.out.println(min);
    }
}
