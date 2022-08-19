package com.revature;

import java.util.Scanner;


public class App

{

    public static int findBalls(int N) {



        //this is default OUTPUT. You can change it.

        // starting out with 0 balls:
        int result = 0;



        //write your Logic here:

        for(int i = 0; i <= N; i ++) {
            // when we start out we have 0 balls, so we can't really drop any
            // check if even:
            if(i%2 == 0) {
                // if we have 0 balls, we can't drop any:
                if (i == 0) continue;
                // otherwise, we drop 1
                else {
                    result -= 1;
                }
            }
            // otherwise, we have an odd second
            else {
                // add 2 to our result:
                result += 2;
            }
            System.out.println("i: " + i + "# balls: " + result);

        }





        return result;




    }

    public static void main (String[] args)

    {



        Scanner sc=new Scanner(System.in);



        //INPUT [uncomment & modify if required]

        int N = sc.nextInt();

        sc.close();



        //OUTPUT [uncomment & modify if required]

        System.out.print(findBalls(N));

        System.out.println(N % 2 == 1); // if remainded when divided by 2 is 1 (odd)
        System.out.println(N % 1 == 0); // this should always be true because anything divided by 1 is itself

        System.out.println(4 % 1);
        System.out.println(5 % 1);



    }

}