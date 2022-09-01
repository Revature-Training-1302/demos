package org.example.Searching;

public class Main {
    public static void main(String[] args) {
        int [] grades = {65,78,34,56,78,12,55,100,45,12,57,54,34,67,80,79,64};
        int grade_to_find = 200; // we know that it exists at the 10th index position
        // write an algorithm to find where the number is:
        // Linear search is just a matter of searching through the entire collection, data structure, etc.
        // and checking each value until we reach the target value or if we don't reach it
        for(int i = 0; i < grades.length; i ++) {
            // at each step, check if we found the value
            if(grades[i] == grade_to_find) {
                // if we did find it, print out the index:
                System.out.println("Found it");
                System.out.println("Index is " + i);
                return;
            }
        }
        // if we reach the end of the array and don't find it, print that out:
        System.out.println("Item not in array");

        int [] numbers = {1,4,7,9,10,14,16,18,20,24,26,34,39,45,56};
        System.out.println(binarySearch(numbers, 10)); // 4
        System.out.println(binarySearch(numbers, 34)); // 11
        System.out.println(binarySearch(numbers, 16)); //6


    }

    // given an array of numbers, search through it and find the index
    public static int binarySearch(int [] numbers, int target) {
        int mid = 0;
        // initialize the low and high to be both ends of the array:
        int low = 0; // first index:
        int high = numbers.length-1; // last index
        System.out.println("Low: " + low + ", High: " + high);
        // loop until low does not equal high
        while(low <= high) {
            // get the midpoint between high and low, offset by the low bound
//            mid = low + ((high-low)/2);
            // if we've found the value:
            mid = (int) Math.floor((high + low)/2); // rounding down the midpoint to avoid decimals

            if(numbers[mid] == target) return mid;
            // if our target is greater than the midpoint
            else if (target > numbers[mid]) low = mid + 1;
            // updating the higher bound to be this midpoint
            else if (target < numbers[mid]) high = mid - 1;
            System.out.println("Low: " + low + ", High: " + high);
        }
        return mid;

    }
}
