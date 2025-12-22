package constructor.day5.practice;

import java.util.Scanner;

public class SwapValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number1: ");
        int number1 = sc.nextInt();

        System.out.print("Enter a number2: ");
        int number2 = sc.nextInt();

        number1 = number1 + number2;
        number2 = number1 - number2;
        number1 = number1 - number2;

        System.out.println("number1: " + number1);
        System.out.println("number2: " + number2);
    }
}
