package constructor.day5.practice;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number % 2 == 0) {
            System.out.println("It is Even Number");
        } else {
            System.out.println("It is Odd Number");
        }
    }
}
