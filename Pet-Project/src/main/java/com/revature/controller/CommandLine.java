package com.revature.controller;

import com.revature.entity.Person;

import java.util.Scanner;

public class CommandLine {
    public static void menu() {
        System.out.println("Which menu do you want to see?");
        System.out.println("1 - Pet Menu");
        System.out.println("2 - Person menu");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                PetCommandLineInterface.menu();
                break;
            case 2:
                PersonCommandLineInterface.menu();
                break;
            default:
                System.out.println("Please choose 1 or 2");
                break;
        }


    }
}
