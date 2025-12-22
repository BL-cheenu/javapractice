package constructor.day5.practice;

import java.util.Scanner;

public class HarmonicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number == 0) {
            System.out.println("Invalid input! Please Enter a valid number.");
        }
        double value = 0.0;

        for (int i = 1; i <= number; i++) {
            value = value + (1.0 / i);
        }
        System.out.println("Harmoinc Number is: " + value);
    }
}
