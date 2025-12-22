package constructor.day6.practice;

import java.util.Scanner;

public class SimulateStopwatch {
    static long startTime;
    static long endTime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Press ENTER to start the Stopwatch: ");
        scanner.nextLine();
        start();

        System.out.print("Press ENTER to stop the Stopwatch: ");
        scanner.nextLine();
        End();

        long elapsedTime = elapsedTime();
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
        System.out.println("Elapsed Time: " + (elapsedTime / 1000.0) + " seconds");
    }

    private static long elapsedTime() {
        return endTime - startTime;
    }

    private static void End() {
        endTime = System.currentTimeMillis();
        System.out.println("Stopwatch stopped...");
    }

    private static void start() {
        startTime = System.currentTimeMillis();
        System.out.println("Stopwatch started...");
    }
}
