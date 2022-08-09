import java.util.Arrays;

public class app {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(nums));

        System.out.println("-----------------------------------------");

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        for (int i = nums.length -1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\n");

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] RandMcast = {"Rick", "Morty", "Jerry", "Beth", "Summer"};
        System.out.println(Arrays.toString(RandMcast));

        System.out.println("-----------------------------------------");

        for (int i = 0; i < RandMcast.length; i++) {
            System.out.print(RandMcast[i] + " ");
        }

        System.out.println();

        for (int i = RandMcast.length -1; i >= 0; i--) {

            String nstr="";
            char ch;

            for (int j=0; j<RandMcast[i].length(); j++)
            {
                ch= RandMcast[i].charAt(j);
                nstr= ch+nstr;
            }
            System.out.print(nstr + " ");


        }

        System.out.println();
    }
}
