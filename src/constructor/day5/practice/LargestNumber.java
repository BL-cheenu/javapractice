package constructor.day5.practice;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        System.out.print("Enter third number: ");
        int c = scanner.nextInt();

        int largest = 0;
        if (a > b && a > c) {
            largest = a;
        } else if (b > c && b > a) {
            largest = b;
        } else {
            largest = c;
        }

        System.out.println("Largest Number is: " + largest);
    }
}
