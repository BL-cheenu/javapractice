package constructor.day5.practice;

import java.util.Scanner;

public class ThreeSumZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of element: ");
        int N = scanner.nextInt();
        int[] a = new int[N];

        System.out.println("Enter the elements:");
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        count++;
                    }

                }
            }
        }
        System.out.println("Number of distinct triplets: " + count);
    }
}
