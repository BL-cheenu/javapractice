package constructor.day2.practice;

import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter m: ");
        int m = sc.nextInt();
        System.out.print("Enter d: ");
        int d = sc.nextInt();

        if ((m == 3 && d >= 20 && d <= 31) || (m == 4 && d >= 1 && d <= 30)
                || (m == 5 && d >= 1 && d <= 31) || (m == 6 && d <= 20)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
