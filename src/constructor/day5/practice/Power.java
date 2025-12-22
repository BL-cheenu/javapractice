package constructor.day5.practice;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int value = 1;

        if (number < 0 || number >= 31) {
            System.out.println("Invalid input! Please Enter a number between 0 to 31.");
        }
        for (int i = 0; i <= number; i++) {
            System.out.println("2^" + i + " = " + value);
            value = value * 2;
        }
    }
}
