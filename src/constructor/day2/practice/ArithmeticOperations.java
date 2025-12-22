package constructor.day2.practice;

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = number.nextInt();

        System.out.print("Enter b: ");
        int b = number.nextInt();

        System.out.print("Enter c: ");
        int c = number.nextInt();

        int r1 = a + b * c;
        int r2 = c + a / b;
        int r3 = a % b + c;
        int r4 = a * b + c;

        int max = r1;
        int min = r1;

        if (r2 > max)
            max = r2;
        if (r3 > max)
            max = r3;
        if (r4 > max)
            max = r4;

        if (r2 < min)
            min = r2;
        if (r3 < min)
            min = r3;
        if (r4 < min)
            min = r4;

        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
