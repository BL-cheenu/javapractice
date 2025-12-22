package constructor.day2.practice;

import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        // 1. Write a Program for the sum of n natural numbers eg. Input N=5 output 1+2+3+4+5

        Scanner number = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = number.nextInt();
        int sum = 0;
        int i = 1;

        while (num != 0) {
            sum += i;
            System.out.print(sum);

            if (i < num) {
                System.out.print("+");
            }
            num--;
        }
        System.out.println();

        // 2. Write a Program to reverse the integer number eg. Input n=231 reverse is 132
        System.out.println("Reverse number will be print! ");
        System.out.print("Enter a number: ");
        num = number.nextInt();
        int reversal = 0;

        while (num != 0) {
            int remainder = num % 10;
            reversal = reversal * 10 + remainder;
            num /= 10;
        }
        System.out.println("reversal: " + reversal
        );
    }
}
