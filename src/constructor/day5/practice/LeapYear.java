package constructor.day5.practice;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a 4 digit year: ");
        int number = scanner.nextInt();

        if (number < 1000 && number > 9999) {
            System.out.println("Invalid input!");
            return;
        }

        boolean isLeapYear = false;
        if (number % 400 == 0) {
            isLeapYear = true;
        } else if (number % 100 == 0) {
            isLeapYear = false;
        } else if (number % 4 == 0) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }

        if (isLeapYear) {
            System.out.println("It is a Leap year.");
        } else {
            System.out.println("It is not a leap year.");
        }
    }
}
