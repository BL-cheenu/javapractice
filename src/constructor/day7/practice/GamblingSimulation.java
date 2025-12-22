package constructor.day7.practice;

import java.util.Scanner;

public class GamblingSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial amount: ");
        int initialAmount = scanner.nextInt();

        System.out.print("Enter goal amount: ");
        int goal = scanner.nextInt();

        int bets = 0;
        int wins = 0;
        int loss = 0;

        while (initialAmount > 0 && initialAmount <= goal) {
            bets++;

            int random = (int) (Math.random() * 2);
            if (random == 1) {
                wins++;
                initialAmount++;
            } else {
                initialAmount--;
                loss++;
            }
        }
        System.out.println("Final amount: " + initialAmount);
        System.out.println("Total Bets: " + bets);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + loss);
    }
}
