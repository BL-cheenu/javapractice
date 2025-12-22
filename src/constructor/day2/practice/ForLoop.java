package constructor.day2.practice;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        // 1. Write a Program for the sum of n natural numbers eg. Input N=5 output 1+2+3+4+5

        System.out.println("Sum of n natural numbers ");
        Scanner number = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = number.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.print(i);
            if (i < num) {
                System.out.print("+");
            }
        }
        System.out.println();
//        2. Write a Program to reverse the integer number eg. Input n=231 reverse is 132

        System.out.println("Reverse the integer number");
        System.out.print("Enter a number: ");
        num = number.nextInt();
        int reversal = 0;

        for (int i = num; i > 0; i /= 10) {
            int remainder = i % 10;
            reversal = reversal * 10 + remainder;
        }
        System.out.println("reverse: " + reversal);
        System.out.println();

//        3. Write a Program to find Palindrome Number
        System.out.println("find Palindrome Number");
        System.out.print("Enter a number: ");
        num = number.nextInt();
        int reversal1 = 0;

        for (int i = num; i > 0; i /= 10) {
            int remainder = i % 10;
            reversal1 = reversal1 * 10 + remainder;
        }
        if (reversal1 == num) {
            System.out.println("It is a Palindrome Number");
        } else {
            System.out.println("It is not a Palindrome Number");
        }
    }
}
