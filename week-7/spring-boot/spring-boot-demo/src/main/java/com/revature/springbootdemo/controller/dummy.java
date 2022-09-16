package com.revature.springbootdemo.controller;

public class dummy {
    public static void main(String[] args) {
        String number = "45";
        int multiply = 1;

        for(int i = 0; i < number.length(); i ++) {
            // first get the individual character:
            char c = number.charAt(i);
            String s = String.valueOf(c);
            int j = Integer.parseInt(s);
            multiply = multiply * j;
        }
    }
}
