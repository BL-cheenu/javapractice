package constructor.day2.practice;

import java.util.Scanner;

public class IfElseStatementProblems {
    public static void main(String[] args) {

//  1. Read a single Digit Number and write in word
        Scanner number = new Scanner(System.in);

        System.out.print("Enter a single digit number (0-9): ");
        int num = number.nextInt();

        if (num == 0) {
            System.out.println("Zero");
        } else if (num == 1) {
            System.out.println("One");
        } else if (num == 2) {
            System.out.println("Two");
        } else if (num == 3) {
            System.out.println("Three");
        } else if (num == 4) {
            System.out.println("Four");
        } else if (num == 5) {
            System.out.println("Five");
        } else if (num == 6) {
            System.out.println("Six");
        } else if (num == 7) {
            System.out.println("Seven");
        } else if (num == 8) {
            System.out.println("Eight");
        } else if (num == 9) {
            System.out.println("Nine");
        } else {
            System.out.println("Invalid input! Please enter a single digit number");
        }

//  2. Read a Number 1,10,100,1000 and display unit, ten hundred
        System.out.print("Enter a number 1,10,100,1000: ");
        num = number.nextInt();

        if (num == 1) {
            System.out.println("Unit");
        } else if (num == 10) {
            System.out.println("Ten");
        } else if (num == 100) {
            System.out.println("Hundred");
        } else if (num == 1000) {
            System.out.println("Thousand");
        } else System.out.println("Invalid input");
    }
}

