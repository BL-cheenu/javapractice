package constructor.day6.practice;

import java.util.Scanner;

public class Coupon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a coupon length number: ");
        int number = scanner.nextInt();
        int totalRandomNumber = coupons(number);
        System.out.println("totalRandomNumber: " + totalRandomNumber);
    }

    private static int coupons(int number) {
        boolean[] collected = new boolean[number];
        int distinctCount = 0;
        int totalRandomNumbers = 0;

        while (distinctCount < number) {
            int random = generateRandomCouponNumbers(number);
            totalRandomNumbers++;

            if (!collected[random]) {
                collected[random] = true;
                distinctCount++;
            }
        }
        return totalRandomNumbers;
    }

    private static int generateRandomCouponNumbers(int number) {
        return (int) (Math.random() * number);
    }
}
