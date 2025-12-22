package constructor.day5.practice;

import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int M = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int N = scanner.nextInt();

        int[][] array = new int[M][N];
        System.out.println("Enter elements of the 2D array:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("2D Array is: ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
