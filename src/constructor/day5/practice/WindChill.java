package constructor.day5.practice;

import java.util.Scanner;

public class WindChill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a temperature: ");
        int t = scanner.nextInt();

        System.out.print("Enter the wind speed: ");
        int v = scanner.nextInt();

        if (Math.abs(t) > 50 || v < 3 || v > 120) {
            System.out.println("Invalid input values.");
            System.out.println("Temperature must be between -50 and 50.");
            System.out.println("Wind speed must be between 3 and 120.");
            return;
        }

        double w = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
        System.out.println("Wind Chill = " + w);
    }
}
