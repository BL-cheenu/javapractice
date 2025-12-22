package constructor.day6.practice;

import java.util.Scanner;

public class MonthlyPayment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a P: ");
        double p = scanner.nextInt();

        System.out.print("Enter a Y: ");
        double y = scanner.nextInt();

        System.out.print("Enter a R: ");
        double r = scanner.nextInt();

        double payment = calculateMonthlyPayment(p, y, r);
        System.out.println("payment: " + payment);
    }

    private static double calculateMonthlyPayment(double p, double y, double r) {
        double n = 12 * y;
        double r1 = r / (12 * 100);
        double result = (p * r1) / (1 - Math.pow(1 + r1, -n));

        return result;
    }
}
