package constructor.day5.practice;

import java.util.Scanner;

public class HeadAndTails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of times to flip the coin: ");
        int number = scanner.nextInt();

        int tails = 0;
        int heads = 0;
        for (int flip = 0; flip < number; flip++) {
            double coin = Math.random();
            if (coin < 0.5) {
                tails++;
            } else {
                heads++;
            }
        }
        int headPercentage = (heads * 100) / number;
        int tailPercentage = (tails * 100) / number;

        System.out.println("Heads percentage: " + headPercentage + "%");
        System.out.println("Tails percentage: " + tailPercentage + "%");
    }
}
