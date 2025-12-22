package constructor.day5.practice;

import java.util.Scanner;

public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number1: ");
        int number1 = sc.nextInt();

        System.out.print("Enter a number2: ");
        int number2 = sc.nextInt();

        int quot = number1 / number2;
        int rem = number1 % number2;

        System.out.println("quotient  is: " + quot);
        System.out.println("remainder  is: " + rem);
    }
}
